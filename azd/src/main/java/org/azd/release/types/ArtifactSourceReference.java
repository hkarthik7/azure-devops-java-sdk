package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Indicates the deploy phase type. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtifactSourceReference {
	/**
 	* ID of the artifact source. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Name of the artifact source. 
	**/
	@JsonProperty("name")
	private String name;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	@Override
	public String toString() { 
	return 	"ArtifactSourceReference{" +
		"id='" + id + '\'' +
		",name='" + name + '\'' +
		'}';
	}
}