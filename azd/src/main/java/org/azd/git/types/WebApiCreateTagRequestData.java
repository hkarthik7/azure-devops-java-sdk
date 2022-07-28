package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The representation of data needed to create a tag definition which is sent across the wire. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebApiCreateTagRequestData {
	/**
 	* Name of the tag definition that will be created. 
	**/
	@JsonProperty("name")
	private String name;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	@Override
	public String toString() {
		return "WebApiCreateTagRequestData{" +
				"name='" + name + '\'' +
				'}';
	}
}