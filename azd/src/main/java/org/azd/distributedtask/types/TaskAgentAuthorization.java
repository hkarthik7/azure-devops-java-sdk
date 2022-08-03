package org.azd.distributedtask.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Gets or sets the type of the pool 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentAuthorization extends BaseAbstractMethod {
	/**
 	* Endpoint used to obtain access tokens from the configured token service. 
	**/
	@JsonProperty("authorizationUrl")
	private String authorizationUrl;
	/**
 	* Client identifier for this agent. 
	**/
	@JsonProperty("clientId")
	private String clientId;
	/**
 	* Public key used to verify the identity of this agent. 
	**/
	@JsonProperty("publicKey")
	private TaskAgentPublicKey publicKey;

	public String getAuthorizationUrl() { return authorizationUrl; }

	public void setAuthorizationUrl(String authorizationUrl) { this.authorizationUrl = authorizationUrl; }

	public String getClientId() { return clientId; }

	public void setClientId(String clientId) { this.clientId = clientId; }

	public TaskAgentPublicKey getPublicKey() { return publicKey; }

	public void setPublicKey(TaskAgentPublicKey publicKey) { this.publicKey = publicKey; }

}
