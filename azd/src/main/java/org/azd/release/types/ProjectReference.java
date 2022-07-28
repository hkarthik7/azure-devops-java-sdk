package org.azd.release.types;
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
public class ProjectReference {
	/**
 	* Gets the unique identifier of this field. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Gets name of project. 
	**/
	@JsonProperty("name")
	private String name;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	@Override
	public String toString() { 
	return 	"ProjectReference{" +
		"id='" + id + '\'' +
		",name='" + name + '\'' +
		'}';
	}
}