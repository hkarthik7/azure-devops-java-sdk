package org.azd.oauth;

import org.azd.enums.VsoScope;
import org.azd.exceptions.AzDException;
import org.azd.oauth.types.AuthorizationEndpoint;
import org.azd.oauth.types.AuthorizedToken;
import org.azd.utils.InstanceFactory;

import java.util.List;

/***
 * OAuth Api class to authorize access to REST API
 */
public class OAuthApi {
    private static OAuthAccessTokenBuilder OAUTH;

    /***
     * Default constructor
     */
    public OAuthApi() {
        OAUTH = InstanceFactory.createOAuthAccessTokenBuilder();
    }

    /***
     * Generate the authorization endpoint with client id, state, scope and redirection url.
     * @param clientId The ID assigned to your app when it was registered
     * @param state Can be any value. Typically, a generated string value that correlates the callback with its associated authorization request.
     * @param scope Scopes registered with the app. Space separated.
     * @see <a href="https://docs.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops#scopes">Scopes</a>
     * @param redirectUrl Callback URL for your app. Must exactly match the URL registered with the app.
     * @return The authorization endpoint to authorize your app
     */
    public static String getAuthorizationEndpoint(String clientId, String state, List<VsoScope> scope, String redirectUrl) {
        var authorizationEndpoint = new AuthorizationEndpoint();
        authorizationEndpoint.clientId = clientId;
        authorizationEndpoint.scope = scope;
        authorizationEndpoint.redirectUrl = redirectUrl;
        authorizationEndpoint.state = state;

        return OAuthAccessTokenBuilder.buildAuthorizationEndpoint(authorizationEndpoint);
    }


    /***
     * Now you use the authorization code to request an access token for the user.
     * Your service must make a service-to-service HTTP request to Azure DevOps Services.
     * @param appSecret URL encoded client secret acquired when the app was registered
     * @param authCode URL encoded "code" provided via the code query parameter to your callback URL
     * @param callbackUrl callback URL registered with the app
     * @return AuthorizedToken object {@link AuthorizedToken}
     * @throws AzDException Default Api Exception handler.
     */
    public static AuthorizedToken getAccessToken(String appSecret, String authCode, String callbackUrl) throws AzDException {
        return OAUTH.getAccessToken(appSecret, authCode, callbackUrl);
    }

    /***
     * If a user's access token expires, you can use the refresh token that they acquired in the authorization flow to get a new access token.
     * @param appSecret URL encoded client secret acquired when the app was registered
     * @param authCode URL encoded "code" provided via the code query parameter to your callback URL
     * @param callbackUrl callback URL registered with the app
     * @return AuthorizedToken object {@link AuthorizedToken}
     * @throws AzDException Default Api Exception handler.
     */
    public static AuthorizedToken getRefreshToken(String appSecret, String authCode, String callbackUrl) throws AzDException {
        return OAUTH.getRefreshToken(appSecret, authCode, callbackUrl);
    }

    /***
     * Check if the access token has expired.
     * @param authorizedToken authorized token object {@link AuthorizedToken}
     * @return True if the token has expired. {@link Boolean}
     */
    public static boolean hasTokenExpired(AuthorizedToken authorizedToken) {
        return OAUTH.hasTokenExpired(authorizedToken);
    }
}
