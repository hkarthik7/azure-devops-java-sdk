package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Provides data necessary for authorizing the agent using OAuth 2.0 authentication flows.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentAuthorization {
    /***
     * Endpoint used to obtain access tokens from the configured token service.
     */
    @JsonProperty("authorizationUrl")
    private String authorizationUrl;
    /***
     * Client identifier for this agent.
     */
    @JsonProperty("clientId")
    private String clientId;
    /***
     * Public key used to verify the identity of this agent.
     */
    @JsonProperty("publicKey")
    private TaskAgentPublicKey publicKey;

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public TaskAgentPublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(TaskAgentPublicKey publicKey) {
        this.publicKey = publicKey;
    }

    @Override
    public String toString() {
        return "TaskAgentAuthorization{" +
                "authorizationUrl='" + authorizationUrl + '\'' +
                ", clientId='" + clientId + '\'' +
                ", publicKey=" + publicKey +
                '}';
    }
}
