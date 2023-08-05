package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/**
 * Stage in pipeline 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShallowReference extends SerializableEntity {
	/**
 	* ID of the resource 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Name of the linked resource (definition name, controller name, etc.) 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Full http link to the resource 
	**/
	@JsonProperty("url")
	private String url;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}