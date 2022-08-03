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
 * Gets reason for release. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demand extends BaseAbstractMethod {
	/**
 	* Gets and sets the name of demand. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets and sets the value of demand. 
	**/
	@JsonProperty("value")
	private String value;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

}
