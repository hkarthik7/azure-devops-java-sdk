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
public class VariableValue extends BaseAbstractMethod {
	/**
 	* Gets or sets if the variable is read only or not. 
	**/
	@JsonProperty("isReadOnly")
	private boolean isReadOnly;
	/**
 	* Gets or sets as the variable is secret or not. 
	**/
	@JsonProperty("isSecret")
	private boolean isSecret;
	/**
 	* Gets or sets the value. 
	**/
	@JsonProperty("value")
	private String value;

	public boolean getIsReadOnly() { return isReadOnly; }

	public void setIsReadOnly(boolean isReadOnly) { this.isReadOnly = isReadOnly; }

	public boolean getIsSecret() { return isSecret; }

	public void setIsSecret(boolean isSecret) { this.isSecret = isSecret; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

}
