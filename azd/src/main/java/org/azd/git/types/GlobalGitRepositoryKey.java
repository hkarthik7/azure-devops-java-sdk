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
 * Fully-qualified identifier for the source repository. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalGitRepositoryKey extends BaseAbstractMethod {
	/**
 	* Team Project Collection ID of the collection for the repository.
	**/
	@JsonProperty("collectionId")
	private String collectionId;
	/**
 	* Team Project ID of the project for the repository.
	**/
	@JsonProperty("projectId")
	private String projectId;
	/**
 	* ID of the repository.
	**/
	@JsonProperty("repositoryId")
	private String repositoryId;

	public String getCollectionId() { return collectionId; }

	public void setCollectionId(String collectionId) { this.collectionId = collectionId; }

	public String getProjectId() { return projectId; }

	public void setProjectId(String projectId) { this.projectId = projectId; }

	public String getRepositoryId() { return repositoryId; }

	public void setRepositoryId(String repositoryId) { this.repositoryId = repositoryId; }
	
}
