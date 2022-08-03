package org.azd.build.types;
/**
----------------------------------------------------------
    GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents a folder that contains build definitions. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Folder extends BaseAbstractMethod {
	/**
 	* The process or person who created the folder. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* The date the folder was created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* The description. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* The process or person that last changed the folder. 
	**/
	@JsonProperty("lastChangedBy")
	private Author lastChangedBy;
	/**
 	* The date the folder was last changed. 
	**/
	@JsonProperty("lastChangedDate")
	private String lastChangedDate;
	/**
 	* The full path. 
	**/
	@JsonProperty("path")
	private String path;
	/**
 	* The project. 
	**/
	@JsonProperty("project")
	private TeamProjectReference project;

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

	public TeamProjectReference getProject() { return project; }

	public void setProject(TeamProjectReference project) { this.project = project; }

}
