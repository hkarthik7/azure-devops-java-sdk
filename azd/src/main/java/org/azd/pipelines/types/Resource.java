package org.azd.pipelines.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;


/**
 * Presents resource object
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource extends SerializableEntity {
	/**
 	* Id of the resource. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Name of the resource. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Type of the resource. 
	**/
	@JsonProperty("type")
	private String type;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getType() { return type; }

	public void setType(String type) { this.type = type; }
}
