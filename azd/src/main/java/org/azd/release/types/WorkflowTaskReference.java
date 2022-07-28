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
public class WorkflowTaskReference {
	/**
 	* Task identifier. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Name of the task. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Version of the task. 
	**/
	@JsonProperty("version")
	private String version;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getVersion() { return version; }

	public void setVersion(String version) { this.version = version; }

	@Override
	public String toString() { 
	return 	"WorkflowTaskReference{" +
		"id='" + id + '\'' +
		",name='" + name + '\'' +
		",version='" + version + '\'' +
		'}';
	}
}