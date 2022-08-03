package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Project visibility. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryCreateOptions extends BaseAbstractMethod {

	@JsonProperty("name")
	private String name;

	@JsonProperty("parentRepository")
	private GitRepositoryRef parentRepository;
	/**
 	* Represents a shallow reference to a TeamProject. 
	**/
	@JsonProperty("project")
	private TeamProjectReference project;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public GitRepositoryRef getParentRepository() { return parentRepository; }

	public void setParentRepository(GitRepositoryRef parentRepository) { this.parentRepository = parentRepository; }

	public TeamProjectReference getProject() { return project; }

	public void setProject(TeamProjectReference project) { this.project = project; }

}
