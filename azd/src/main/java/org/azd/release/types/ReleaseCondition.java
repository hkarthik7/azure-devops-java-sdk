package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ConditionType;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseCondition extends BaseAbstractMethod {
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
 	* The release condition result. 
	**/
	@JsonProperty("result")
	private boolean result;
	/**
 	* Gets or set value of the condition. 
	**/
	@JsonProperty("value")
	private String value;

	public ConditionType getConditionType() { return conditionType; }

	public void setConditionType(ConditionType conditionType) { this.conditionType = conditionType; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public boolean getResult() { return result; }

	public void setResult(boolean result) { this.result = result; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

}
