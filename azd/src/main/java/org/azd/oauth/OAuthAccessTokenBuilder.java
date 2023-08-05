package org.azd.oauth;

import org.azd.enums.CustomHeader;
import org.azd.enums.Instance;
import org.azd.enums.RequestMethod;
import org.azd.enums.VsoScope;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;
import org.azd.http.RequestInformation;
import org.azd.interfaces.RequestAdapter;
import org.azd.oauth.types.AuthorizedToken;
import org.azd.utils.BaseRequestBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * Provides the functionality to generate and oauth access token to call Azure DevOps Api.
 * Note that you should have registered you application before using this.
 */
public class OAuthAccessTokenBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public OAuthAccessTokenBuilder(RequestAdapter requestAdapter) {
        super(null, requestAdapter, Instance.ACCOUNT_INSTANCE.getInstance(), null);
    }

    /***
     * Generate the authorization endpoint with client id, state, scope and redirection url.
     * @param clientId The ID assigned to your app when it was registered
     * @param state Can be any value. Typically, a generated string value that correlates the callback with its associated authorization request.
     * @param scope Scopes registered with the app. Space separated.
     * See https://docs.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops#scopes
     * @param redirectUrl Callback URL for your app. Must exactly match the URL registered with the app.
     * @return The authorization endpoint to authorize your app
     */
    public String getAuthorizationEndpoint(final String clientId, final String state, final List<VsoScope> scope, final String redirectUrl) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(state);
        Objects.requireNonNull(scope);
        Objects.requireNonNull(redirectUrl);

        var allScopes = new StringBuilder();

        for (var vsoScope : scope) {
            allScopes.append(vsoScope.name());
            allScopes.append("%20");
        }

        StringBuilder stringBuilder = new StringBuilder()
            .append(service)
            .append("/oauth2/authorize?client_id=")
            .append(clientId)
            .append("&response_type=Assertion")
            .append("&state=")
            .append(state)
            .append("&scope=")
            .append(allScopes.toString().replaceAll("%20$", ""))
            .append("&redirect_uri=")
            .append(URLHelper.encodeSpecialChars(redirectUrl));

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
        stringBuilder.append(service);
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
        var res = getResponse(stringBuilder.toString(), body);
        res.setReceivedTimestamp(System.currentTimeMillis());

        return res;
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
        stringBuilder.append(service);
        stringBuilder.append("/oauth2/token");

        var body = new StringBuilder()
                .append("client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_assertion=")
                .append(URLHelper.encodeSpecialWithSpace(appSecret))
                .append("&grant_type=refresh_token&assertion=")
                .append(URLHelper.encodeSpecialWithSpace(refreshToken))
                .append("&redirect_uri=")
                .append(callbackUrl)
                .toString();

        var res = getResponse(stringBuilder.toString(), body);
        res.setReceivedTimestamp(System.currentTimeMillis());

        return res;
    }

    /***
     * Check if the access token has expired.
     * @param authorizedToken authorized token object {@link AuthorizedToken}
     * @return True if the token has expired. {@link Boolean}
     */
    public boolean hasTokenExpired(AuthorizedToken authorizedToken) {
        return authorizedToken.getReceivedTimestamp() < 1629897097271L || (authorizedToken.getReceivedTimestamp()
                + authorizedToken.getExpiresIn() * 1000) < System.currentTimeMillis();
    }

    private AuthorizedToken getResponse(String requestUrl, String body) throws AzDException {
        var reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.POST;
        reqInfo.setRequestUrl(requestUrl);
        reqInfo.requestHeaders.add(CustomHeader.URL_ENCODED);
        reqInfo.requestBody = body;

        // Overriding the requestAdapter as we don't want to send the access token yet to call the Api.
        return requestAdapter.send(reqInfo, AuthorizedToken.class);
    }
}
