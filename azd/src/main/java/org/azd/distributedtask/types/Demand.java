package org.azd.distributedtask.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a JSON object. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Demand {

	@JsonProperty("name")
	private String name;

	@JsonProperty("value")
	private String value;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

	@Override
	public String toString() {
		return "Demand{" +
				"name='" + name + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}