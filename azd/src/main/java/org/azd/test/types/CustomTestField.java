package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * A custom field information. Allowed Key : Value pairs - ( AttemptId: int value, IsTestResultFlaky: bool) 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomTestField extends BaseAbstractMethod {
	/**
 	* Field Name. 
	**/
	@JsonProperty("fieldName")
	private String fieldName;
	/**
 	* Field value. 
	**/
	@JsonProperty("value")
	private Object value;

	public String getFieldName() { return fieldName; }

	public void setFieldName(String fieldName) { this.fieldName = fieldName; }

	public Object getValue() { return value; }

	public void setValue(Object value) { this.value = value; }

}