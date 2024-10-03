package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Status of the phase. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildVersion extends SerializableEntity {
	/**
 	* Gets or sets the commit message for the artifact. 
	**/
	@JsonProperty("commitMessage")
	private String commitMessage;
	/**
 	* Gets or sets the definition id. 
	**/
	@JsonProperty("definitionId")
	private String definitionId;
	/**
 	* Gets or sets the definition name. 
	**/
	@JsonProperty("definitionName")
	private String definitionName;
	/**
 	* Gets or sets the build id. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* Gets or sets if the artifact supports multiple definitions. 
	**/
	@JsonProperty("isMultiDefinitionType")
	private boolean isMultiDefinitionType;
	/**
 	* Gets or sets the build number. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets or sets the source branch for the artifact. 
	**/
	@JsonProperty("sourceBranch")
	private String sourceBranch;
	/**
 	* Gets or sets the source pull request version for the artifact. 
	**/
	@JsonProperty("sourcePullRequestVersion")
	private SourcePullRequestVersion sourcePullRequestVersion;
	/**
 	* Gets or sets the repository id for the artifact. 
	**/
	@JsonProperty("sourceRepositoryId")
	private String sourceRepositoryId;
	/**
 	* Gets or sets the repository type for the artifact. 
	**/
	@JsonProperty("sourceRepositoryType")
	private String sourceRepositoryType;
	/**
 	* Gets or sets the source version for the artifact. 
	**/
	@JsonProperty("sourceVersion")
	private String sourceVersion;

	public String getCommitMessage() { return commitMessage; }

	public void setCommitMessage(String commitMessage) { this.commitMessage = commitMessage; }

	public String getDefinitionId() { return definitionId; }

	public void setDefinitionId(String definitionId) { this.definitionId = definitionId; }

	public String getDefinitionName() { return definitionName; }

	public void setDefinitionName(String definitionName) { this.definitionName = definitionName; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public boolean getIsMultiDefinitionType() { return isMultiDefinitionType; }

	public void setIsMultiDefinitionType(boolean isMultiDefinitionType) { this.isMultiDefinitionType = isMultiDefinitionType; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getSourceBranch() { return sourceBranch; }

	public void setSourceBranch(String sourceBranch) { this.sourceBranch = sourceBranch; }

	public SourcePullRequestVersion getSourcePullRequestVersion() { return sourcePullRequestVersion; }

	public void setSourcePullRequestVersion(SourcePullRequestVersion sourcePullRequestVersion) { this.sourcePullRequestVersion = sourcePullRequestVersion; }

	public String getSourceRepositoryId() { return sourceRepositoryId; }

	public void setSourceRepositoryId(String sourceRepositoryId) { this.sourceRepositoryId = sourceRepositoryId; }

	public String getSourceRepositoryType() { return sourceRepositoryType; }

	public void setSourceRepositoryType(String sourceRepositoryType) { this.sourceRepositoryType = sourceRepositoryType; }

	public String getSourceVersion() { return sourceVersion; }

	public void setSourceVersion(String sourceVersion) { this.sourceVersion = sourceVersion; }

}