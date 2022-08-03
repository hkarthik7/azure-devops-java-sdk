package org.azd.git.types;
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
 * Project state. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitDeletedRepository extends BaseAbstractMethod {

	@JsonProperty("createdDate")
	private String createdDate;

	@JsonProperty("deletedBy")
	private Author deletedBy;

	@JsonProperty("deletedDate")
	private String deletedDate;

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private String name;
	/**
 	* Represents a shallow reference to a TeamProject. 
	**/
	@JsonProperty("project")
	private TeamProjectReference project;

	public String getCreatedDate() { return createdDate; }

	public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

	public Author getDeletedBy() { return deletedBy; }

	public void setDeletedBy(Author deletedBy) { this.deletedBy = deletedBy; }

	public String getDeletedDate() { return deletedDate; }

	public void setDeletedDate(String deletedDate) { this.deletedDate = deletedDate; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public TeamProjectReference getProject() { return project; }

	public void setProject(TeamProjectReference project) { this.project = project; }

}
