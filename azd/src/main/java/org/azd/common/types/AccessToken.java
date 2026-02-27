package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Represents the access token result object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken extends SerializableEntity {
    /**
     * Type of token
     */
    @JsonProperty("token_type")
    public String TokenType;
    /**
     * Token expiration
     */
    @JsonProperty("expires_in")
    public int ExpiresIn;
    /**
     * Token extended expiration
     */
    @JsonProperty("ext_expires_in")
    public int ExtExpiresIn;
    /**
     * Access token
     */
    @JsonProperty("access_token")
    public String Token;

    public String getTokenType() {
        return TokenType;
    }

    public void setTokenType(String tokenType) {
        TokenType = tokenType;
    }

    public int getExpiresIn() {
        return ExpiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        ExpiresIn = expiresIn;
    }

    public int getExtExpiresIn() {
        return ExtExpiresIn;
    }

    public void setExtExpiresIn(int extExpiresIn) {
        ExtExpiresIn = extExpiresIn;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
