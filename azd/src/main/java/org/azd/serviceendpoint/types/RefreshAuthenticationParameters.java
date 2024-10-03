package org.azd.serviceendpoint.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefreshAuthenticationParameters extends SerializableEntity {
	/**
 	* EndpointId which needs new authentication params 
	**/
	@JsonProperty("endpointId")
	private String endpointId;
	/**
 	* Scope of the token requested. For GitHub marketplace apps, scope contains repository Ids 
	**/
	@JsonProperty("scope")
	private List<Integer> scope;
	/**
 	* The requested endpoint authentication should be valid for _ minutes. Authentication params will not be refreshed if the token contained in endpoint already has active token. 
	**/
	@JsonProperty("tokenValidityInMinutes")
	private Integer tokenValidityInMinutes;

	public String getEndpointId() { return endpointId; }

	public void setEndpointId(String endpointId) { this.endpointId = endpointId; }

	public List<Integer> getScope() { return scope; }

	public void setScope(List<Integer> scope) { this.scope = scope; }

	public Integer getTokenValidityInMinutes() { return tokenValidityInMinutes; }

	public void setTokenValidityInMinutes(Integer tokenValidityInMinutes) { this.tokenValidityInMinutes = tokenValidityInMinutes; }

}