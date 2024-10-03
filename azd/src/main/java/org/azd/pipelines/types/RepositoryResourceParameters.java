package org.azd.pipelines.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryResourceParameters extends SerializableEntity {
	@JsonProperty("refName")
	private String refName;
	/**
 	* This is the security token to use when connecting to the repository. 
	**/
	@JsonProperty("token")
	private String token;
	/**
 	* Optional. This is the type of the token given. If not provided, a type of "Bearer" is assumed. Note: Use "Basic" for a PAT token. 
	**/
	@JsonProperty("tokenType")
	private String tokenType;

	@JsonProperty("version")
	private String version;

	public String getRefName() { return refName; }

	public void setRefName(String refName) { this.refName = refName; }

	public String getToken() { return token; }

	public void setToken(String token) { this.token = token; }

	public String getTokenType() { return tokenType; }

	public void setTokenType(String tokenType) { this.tokenType = tokenType; }

	public String getVersion() { return version; }

	public void setVersion(String version) { this.version = version; }

}