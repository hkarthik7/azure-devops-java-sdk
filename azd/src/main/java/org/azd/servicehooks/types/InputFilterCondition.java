package org.azd.servicehooks.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.InputFilterOperator;

/**
 * The operator applied between the expected and actual input value 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class InputFilterCondition extends SerializableEntity {
	/**
 	* Whether or not to do a case sensitive match 
	**/
	@JsonProperty("caseSensitive")
	private Boolean caseSensitive;
	/**
 	* The Id of the input to filter on 
	**/
	@JsonProperty("inputId")
	private String inputId;
	/**
 	* The "expected" input value to compare with the actual input value 
	**/
	@JsonProperty("inputValue")
	private String inputValue;
	/**
 	* The operator applied between the expected and actual input value 
	**/
	@JsonProperty("operator")
	private InputFilterOperator operator;

	public Boolean getCaseSensitive() { return caseSensitive; }

	public void setCaseSensitive(Boolean caseSensitive) { this.caseSensitive = caseSensitive; }

	public String getInputId() { return inputId; }

	public void setInputId(String inputId) { this.inputId = inputId; }

	public String getInputValue() { return inputValue; }

	public void setInputValue(String inputValue) { this.inputValue = inputValue; }

	public InputFilterOperator getOperator() { return operator; }

	public void setOperator(InputFilterOperator operator) { this.operator = operator; }

}