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
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestTag extends BaseAbstractMethod {
	/**
 	* Name of the tag, alphanumeric value less than 30 chars 
	**/
	@JsonProperty("name")
	private String name;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

}