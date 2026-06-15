package org.azd.workitemtracking.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;


/**
 * Reference to a work item type.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTypeReference extends SerializableEntity {
	/**
 	* Name of the work item type. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* REST URL for the resource. 
	**/
	@JsonProperty("url")
	private String url;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }
}
