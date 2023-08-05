package org.azd.build.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/**
 * Represents a reference to a task. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskReference extends SerializableEntity {
	/**
 	* The ID of the task definition. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* The name of the task definition. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* The version of the task definition. 
	**/
	@JsonProperty("version")
	private String version;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getVersion() { return version; }

	public void setVersion(String version) { this.version = version; }

}