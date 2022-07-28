package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitTemplate {
	/**
 	* Name of the Template 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Type of the Template 
	**/
	@JsonProperty("type")
	private String type;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getType() { return type; }

	public void setType(String type) { this.type = type; }

	@Override
	public String toString() {
		return "GitTemplate{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}