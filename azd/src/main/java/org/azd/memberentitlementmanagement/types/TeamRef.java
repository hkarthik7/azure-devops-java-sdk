package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamRef extends SerializableEntity {
	/**
 	* Team ID 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Team Name 
	**/
	@JsonProperty("name")
	private String name;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

}