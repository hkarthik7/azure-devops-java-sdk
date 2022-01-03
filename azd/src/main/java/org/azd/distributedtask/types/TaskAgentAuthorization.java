package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentAuthorization {
    @JsonProperty("authorizationUrl")
    private String authorizationUrl;
    @JsonProperty("clientId")
    private String clientId;
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
