package org.azd.oauth.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents an Authorized token object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizedToken extends BaseAbstractMethod {
    /***
     * Access token
     */
    @JsonProperty("access_token")
    private String accessToken;
    /***
     * Type of the token
     */
    @JsonProperty("token_type")
    private String tokenType;
    /***
     * Time stamp of token expiry date/time
     */
    @JsonProperty("expires_in")
    private int expiresIn;
    /***
     * Refresh token
     */
    @JsonProperty("refresh_token")
    private String refreshToken;
    /***
     * Received date/time stamp
     */
    @JsonProperty("receivedTimestamp")
    private long receivedTimestamp;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getReceivedTimestamp() {
        return receivedTimestamp;
    }

    public void setReceivedTimestamp(long receivedTimestamp) {
        this.receivedTimestamp = receivedTimestamp;
    }

}
