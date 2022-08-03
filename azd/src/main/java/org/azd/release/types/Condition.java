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
 * Gets or sets the trigger type. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition extends BaseAbstractMethod {
	/**
 	* Gets or sets the condition type. 
	**/
	@JsonProperty("conditionType")
	private ConditionType conditionType;
	/**
 	* Gets or sets the name of the condition. e.g. 'ReleaseStarted'. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets or set value of the condition. 
	**/
	@JsonProperty("value")
	private String value;

	public ConditionType getConditionType() { return conditionType; }

	public void setConditionType(ConditionType conditionType) { this.conditionType = conditionType; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

}
