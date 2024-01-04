package org.azd.oauth;

import org.azd.enums.CustomHeader;
import org.azd.enums.Instance;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.http.ClientRequest;
import org.azd.oauth.types.AuthorizationEndpoint;
import org.azd.oauth.types.AuthorizedToken;

import java.util.Objects;

/**
 * Provides the functionality to generate and oauth access token to call Azure DevOps Api.
 * Note that you should have registered you application before using this.
 */
public class OAuthAccessTokenBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     */
    public OAuthAccessTokenBuilder() {
    }

    /***
     * Generate the authorization endpoint with client id, state, scope and redirection url.
     * @param authorizationEndpoint Provide the parameters to build authorization endpoint.
     * @return The authorization endpoint to authorize your app
     */
    public String buildAuthorizationEndpoint(AuthorizationEndpoint authorizationEndpoint) {
        Objects.requireNonNull(authorizationEndpoint);
        var allScopes = new StringBuilder();

        for (var vsoScope : authorizationEndpoint.scope) {
            allScopes.append(vsoScope.name());
            allScopes.append("%20");
        }

        StringBuilder stringBuilder = new StringBuilder()
                .append(Instance.ACCOUNT_INSTANCE.getInstance())
                .append("/oauth2/authorize?client_id=")
                .append(authorizationEndpoint.clientId)
                .append("&response_type=Assertion")
                .append("&state=")
                .append(authorizationEndpoint.state)
                .append("&scope=")
                .append(allScopes.toString().replaceAll("%20$", ""))
                .append("&redirect_uri=")
                .append(URLHelper.encodeSpecialChars(authorizationEndpoint.redirectUrl));

        return stringBuilder.toString();
    }

    /***
     * Now you use the authorization code to request an access token for the user.
     * Your service must make a service-to-service HTTP request to Azure DevOps Services.
     * @param appSecret URL encoded client secret acquired when the app was registered.
     * @param authCode URL encoded "code" provided via the code query parameter to your callback URL.
     * @param callbackUrl callback URL registered with the app.
     * @return AuthorizedToken object {@link AuthorizedToken}
     * @throws AzDException Default Api Exception handler.
     */
    public AuthorizedToken getAccessToken(String appSecret, String authCode, String callbackUrl) throws AzDException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Instance.ACCOUNT_INSTANCE.getInstance());
        stringBuilder.append("/oauth2/token");

        var body = new StringBuilder()
                .append("client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_assertion=")
                .append(URLHelper.encodeSpecialWithSpace(appSecret))
                .append("&grant_type=urn:ietf:params:oauth:grant-type:jwt-bearer&assertion=")
                .append(URLHelper.encodeSpecialWithSpace(authCode))
                .append("&redirect_uri=")
                .append(callbackUrl)
                .toString();

        // add current system time to refresh the token automatically.
        var authorizedToken = builder(stringBuilder.toString(), body).execute(AuthorizedToken.class);
        authorizedToken.setReceivedTimestamp(System.currentTimeMillis());

        return authorizedToken;
    }

    /***
     * If a user's access token expires, you can use the refresh token that they acquired in the authorization flow to get a new access token.
     * @param appSecret URL encoded client secret acquired when the app was registered.
     * @param refreshToken URL encoded refresh token for the user.
     * @param callbackUrl callback URL registered with the app.
     * @return AuthorizedToken object {@link AuthorizedToken}
     * @throws AzDException Default Api Exception handler.
     */
    public AuthorizedToken getRefreshToken(String appSecret, String refreshToken, String callbackUrl) throws AzDException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Instance.ACCOUNT_INSTANCE.getInstance());
        stringBuilder.append("/oauth2/token");

        var body = new StringBuilder()
                .append("client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_assertion=")
                .append(URLHelper.encodeSpecialWithSpace(appSecret))
                .append("&grant_type=refresh_token&assertion=")
                .append(URLHelper.encodeSpecialWithSpace(refreshToken))
                .append("&redirect_uri=")
                .append(callbackUrl)
                .toString();

        var authorizedToken = builder(stringBuilder.toString(), body).execute(AuthorizedToken.class);
        authorizedToken.setReceivedTimestamp(System.currentTimeMillis());

        return authorizedToken;
    }

    /***
     * Check if the access token has expired.
     * @param authorizedToken authorized token object {@link AuthorizedToken}
     * @return True if the token has expired. {@link Boolean}
     */
    public boolean hasTokenExpired(AuthorizedToken authorizedToken) {
        return authorizedToken.getReceivedTimestamp() < 1629897097271L || (authorizedToken.getReceivedTimestamp()
                + authorizedToken.getExpiresIn() * 1000L) < System.currentTimeMillis();
    }

    private ClientRequest builder(String requestUrl, String body) {
        return ClientRequest.builder()
                .URI(requestUrl)
                .header(CustomHeader.URL_ENCODED)
                .POST(body)
                .build();
    }
}
