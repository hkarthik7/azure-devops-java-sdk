package org.azd.oauth;

import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.URLHelper;
import org.azd.oauth.types.AuthorizedToken;

import java.util.LinkedHashMap;

import static org.azd.utils.Client.send;

public class OAuth {

    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "accounts";

    public OAuth(Connection connection) { this.CONNECTION = connection; }

    public String getAuthorizationEndpoint(String clientId, String state, String scope, String redirectUrl) throws AzDException, ConnectionException {

        var q = new LinkedHashMap<String, Object>(){{
            put("client_id", clientId);
            put("response_type", "Assertion");
            put("state", state);
            put("scope", URLHelper.encodeSpace(scope));
            put("redirect_uri", URLHelper.encodeSpecialChars(redirectUrl));
        }};

        return send(RequestMethod.POST, CONNECTION, AREA, null, "oauth2", null,
                "authorize", null, q, true, null, null);
    }

    public AuthorizedToken getAccessToken(String appSecret, String authCode, String callbackUrl) throws AzDException, ConnectionException {
        var body = new StringBuilder()
                .append("client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_assertion=")
                .append(URLHelper.encodeSpecialChars(appSecret))
                .append("&grant_type=urn:ietf:params:oauth:grant-type:jwt-bearer&assertion=")
                .append(URLHelper.encodeSpecialChars(authCode))
                .append("&redirect_uri=")
                .append(URLHelper.encodeSpecialChars(callbackUrl))
                .toString();

        String r = send(RequestMethod.POST, CONNECTION, AREA, null, "oauth2", null,
                "token", null, null, false, body, Integer.toString(body.length()));

        // add current system time to refresh the token automatically.
        var res = MAPPER.mapJsonResponse(r, AuthorizedToken.class);
        res.setReceivedTimestamp(System.currentTimeMillis());

        return res;
    }

    public AuthorizedToken getRefreshToken(String appSecret, String authCode, String callbackUrl) throws AzDException, ConnectionException {
        var body = new StringBuilder()
                .append("client_assertion_type=urn:ietf:params:oauth:client-assertion-type:jwt-bearer&client_assertion=")
                .append(URLHelper.encodeSpecialChars(appSecret))
                .append("&grant_type=refresh_token&assertion=")
                .append(URLHelper.encodeSpecialChars(authCode))
                .append("&redirect_uri=")
                .append(URLHelper.encodeSpecialChars(callbackUrl))
                .toString();

        String r = send(RequestMethod.POST, CONNECTION, AREA, null, "oauth2", null,
                "token", null, null, false, body, Integer.toString(body.length()));

        return MAPPER.mapJsonResponse(r, AuthorizedToken.class);
    }

    public boolean hasTokenExpired(AuthorizedToken authorizedToken) {
        return (authorizedToken.getReceivedTimestamp() + authorizedToken.getExpiresIn())*1000 > System.currentTimeMillis();
    }
}
