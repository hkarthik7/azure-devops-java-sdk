package org.azd.oauth;

import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.URLHelper;
import org.azd.oauth.types.AuthorizedToken;
import org.azd.utils.BaseClient;
import org.azd.utils.Client;

import java.util.LinkedHashMap;

import static org.azd.utils.Client.send;

public class OAuthApi {

    private static final JsonMapper MAPPER = new JsonMapper();
    private static final String AREA = "accounts";

    private static String VSTS_BASE_URL;

    static {
        try {
            VSTS_BASE_URL = Client.getLocationUrl(AREA,null);
        } catch (ConnectionException |AzDException e) {

        }
    }

    public OAuthApi() {}

    public static String getAuthorizationEndpoint(String clientId, String state, String scope, String redirectUrl) {

        var queryString = new LinkedHashMap<String, Object>(){{

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

    private static String getQueryString(String key, Object value) {
        return "&" + key + "=" + value;
    }


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

        String r = BaseClient.post(stringBuilder.toString(), body);

        // add current system time to refresh the token automatically.
        var res = MAPPER.mapJsonResponse(r, AuthorizedToken.class);
        res.setReceivedTimestamp(System.currentTimeMillis());

        return res;
    }

    public static AuthorizedToken getRefreshToken(String appSecret, String authCode, String callbackUrl) throws AzDException, ConnectionException {

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

        String r = BaseClient.post(stringBuilder.toString(), body);
        var res = MAPPER.mapJsonResponse(r, AuthorizedToken.class);
        res.setReceivedTimestamp(System.currentTimeMillis());

        return res;
    }

    public static boolean hasTokenExpired(AuthorizedToken authorizedToken) {
        return authorizedToken.getReceivedTimestamp() < 1629897097271L || (authorizedToken.getReceivedTimestamp() + authorizedToken.getExpiresIn()*1000) < System.currentTimeMillis();
    }
}
