package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.oauth.types.AuthorizedToken;

public interface OAuth {
    String getAuthorizationEndpoint(String clientId, String state, String scope, String redirectUrl) throws AzDException, ConnectionException;
    AuthorizedToken getAccessToken(String appSecret, String authCode, String callbackUrl) throws AzDException, ConnectionException;
    AuthorizedToken getRefreshToken(String appSecret, String authCode, String callbackUrl) throws AzDException, ConnectionException;
    boolean hasTokenExpired(AuthorizedToken authorizedToken);
}
