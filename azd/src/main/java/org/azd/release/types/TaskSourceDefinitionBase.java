package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskSourceDefinitionBase extends BaseAbstractMethod {

	@JsonProperty("authKey")
	private String authKey;

	@JsonProperty("endpoint")
	private String endpoint;

	@JsonProperty("keySelector")
	private String keySelector;

	@JsonProperty("selector")
	private String selector;

	@JsonProperty("target")
	private String target;

	public String getAuthKey() { return authKey; }

	public void setAuthKey(String authKey) { this.authKey = authKey; }

	public String getEndpoint() { return endpoint; }

	public void setEndpoint(String endpoint) { this.endpoint = endpoint; }

	public String getKeySelector() { return keySelector; }

	public void setKeySelector(String keySelector) { this.keySelector = keySelector; }

	public String getSelector() { return selector; }

	public void setSelector(String selector) { this.selector = selector; }

	public String getTarget() { return target; }

	public void setTarget(String target) { this.target = target; }

}
