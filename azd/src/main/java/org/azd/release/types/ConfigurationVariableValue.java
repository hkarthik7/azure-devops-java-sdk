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
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfigurationVariableValue extends BaseAbstractMethod {
	/**
 	* Gets and sets if a variable can be overridden at deployment time or not. 
	**/
	@JsonProperty("allowOverride")
	private boolean allowOverride;
	/**
 	* Gets or sets as variable is secret or not. 
	**/
	@JsonProperty("isSecret")
	private boolean isSecret;
	/**
 	* Gets and sets value of the configuration variable. 
	**/
	@JsonProperty("value")
	private String value;

	public boolean getAllowOverride() { return allowOverride; }

	public void setAllowOverride(boolean allowOverride) { this.allowOverride = allowOverride; }

	public boolean getIsSecret() { return isSecret; }

	public void setIsSecret(boolean isSecret) { this.isSecret = isSecret; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }
}
