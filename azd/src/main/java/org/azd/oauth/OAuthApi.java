package org.azd.oauth;

import org.azd.enums.CustomHeader;
import org.azd.enums.Instance;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.URLHelper;
import org.azd.oauth.types.AuthorizedToken;
import org.azd.utils.RestClientProvider;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedHashMap;

import static org.azd.utils.RestClient.send;

/***
 * OAuth Api class to authorize access to REST API
 */
public class OAuthApi {

    /***
     * Deserialize JSON response to POJO
     */
    private static final JsonMapper MAPPER = new JsonMapper();
    private static final String VSTS_BASE_URL = Instance.ACCOUNT_INSTANCE.getInstance();

    /***
     * Default constructor
     */
    public OAuthApi() {
    }

    /***
     * Generate the authorization endpoint with client id, state, scope and redirection url.
     * @param clientId The ID assigned to your app when it was registered
     * @param state Can be any value. Typically a generated string value that correlates the callback with its associated authorization request.
     * @param scope Scopes registered with the app. Space separated. See https://docs.microsoft.com/en-us/azure/devops/integrate/get-started/authentication/oauth?view=azure-devops#scopes
     * @param redirectUrl Callback URL for your app. Must exactly match the URL registered with the app.
     * @return The authorization endpoint to authorize your app
     */
    public static String getAuthorizationEndpoint(String clientId, String state, String scope, String redirectUrl) {

        var queryString = new LinkedHashMap<String, Object>() {{
            put("response_type", "Assertion");
            put("state", state);
            put("scope", URLHelper.encodeSpace(scope));
            put("redirect_uri", URLHelper.encodeSpecialChars(redirectUrl));
        }};

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VSTS_BASE_URL);
        stringBuilder.append("/oauth2/authorize?");
        stringBuilder.append("client_id=");
        stringBuilder.append(clientId);

        for (var key : queryString.keySet()) {
            stringBuilder.append(getQueryString(key, queryString.get(key)));
        }
        return stringBuilder.toString();
    }

    /**
     * Helps to create a query string from given key and value
     *
     * @param key   pass the key of the HashMap
     * @param value pass the value of the HasMap
     * @return query string
     */
    private static String getQueryString(String key, Object value) {
        return "&" + key + "=" + value;
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

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VSTS_BASE_URL);
        stringBuilder.append("/oauth2/token");

        var body = new StringBuilder()
                .append("client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_assertion=")
                .append(URLHelper.encodeSpecialChars(appSecret))
                .append("&grant_type=urn:ietf:params:oauth:grant-type:jwt-bearer&assertion=")
                .append(URLHelper.encodeSpecialChars(authCode))
                .append("&redirect_uri=")
                .append(callbackUrl)
                .toString();

        String r = getResponse(stringBuilder.toString(), body);

        // add current system time to refresh the token automatically.
        var res = MAPPER.mapJsonResponse(r, AuthorizedToken.class);
        res.setReceivedTimestamp(System.currentTimeMillis());

        return res;
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

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VSTS_BASE_URL);
        stringBuilder.append("/oauth2/token");

        var body = new StringBuilder()
                .append("client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_assertion=")
                .append(URLHelper.encodeSpecialChars(appSecret))
                .append("&grant_type=refresh_token&assertion=")
                .append(URLHelper.encodeSpecialChars(authCode))
                .append("&redirect_uri=")
                .append(callbackUrl)
                .toString();

        String r = getResponse(stringBuilder.toString(), body);
        var res = MAPPER.mapJsonResponse(r, AuthorizedToken.class);
        res.setReceivedTimestamp(System.currentTimeMillis());

        return res;
    }

    /***
     * Check if the access token has expired.
     * @param authorizedToken authorized token object {@link AuthorizedToken}
     * @return True if the token has expired. {@link Boolean}
     */
    public static boolean hasTokenExpired(AuthorizedToken authorizedToken) {
        return authorizedToken.getReceivedTimestamp() < 1629897097271L || (authorizedToken.getReceivedTimestamp() + authorizedToken.getExpiresIn() * 1000) < System.currentTimeMillis();
    }

    private static String getResponse(String requestUrl, String body) throws AzDException {
        return RestClientProvider.post(requestUrl, null, HttpRequest.BodyPublishers.ofString(body),
                HttpResponse.BodyHandlers.ofString(), CustomHeader.URL_ENCODED, false)
                .thenApplyAsync(HttpResponse::body)
                .join();
    }
}
