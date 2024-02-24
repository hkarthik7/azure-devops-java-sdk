package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;

/**
 * Gets the results in the defined order. Default is 'None'. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Folder extends SerializableEntity {
	/**
 	* Identity who created this folder. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* Time when this folder created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Description of the folder. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Identity who last changed this folder. 
	**/
	@JsonProperty("lastChangedBy")
	private Author lastChangedBy;
	/**
 	* Time when this folder last changed. 
	**/
	@JsonProperty("lastChangedDate")
	private String lastChangedDate;
	/**
 	* path of the folder. 
	**/
	@JsonProperty("path")
	private String path;

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public Author getLastChangedBy() { return lastChangedBy; }

	public void setLastChangedBy(Author lastChangedBy) { this.lastChangedBy = lastChangedBy; }

	public String getLastChangedDate() { return lastChangedDate; }

	public void setLastChangedDate(String lastChangedDate) { this.lastChangedDate = lastChangedDate; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

}