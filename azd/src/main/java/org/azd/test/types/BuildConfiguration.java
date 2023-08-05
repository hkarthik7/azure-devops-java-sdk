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
 * BuildConfiguration Details. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildConfiguration extends SerializableEntity {
	/**
 	* Branch name for which build is generated. 
	**/
	@JsonProperty("branchName")
	private String branchName;
	/**
 	* BuildDefinitionId for build. 
	**/
	@JsonProperty("buildDefinitionId")
	private Integer buildDefinitionId;
	/**
 	* Build system. 
	**/
	@JsonProperty("buildSystem")
	private String buildSystem;
	/**
 	* Build Creation Date. 
	**/
	@JsonProperty("creationDate")
	private String creationDate;
	/**
 	* Build flavor (eg Build/Release). 
	**/
	@JsonProperty("flavor")
	private String flavor;
	/**
 	* BuildConfiguration Id. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Build Number. 
	**/
	@JsonProperty("number")
	private String number;
	/**
 	* BuildConfiguration Platform. 
	**/
	@JsonProperty("platform")
	private String platform;
	/**
 	* Project associated with this BuildConfiguration. 
	**/
	@JsonProperty("project")
	private ShallowReference project;
	/**
 	* Repository Guid for the Build. 
	**/
	@JsonProperty("repositoryGuid")
	private String repositoryGuid;
	/**
 	* Repository Type (eg. TFSGit). 
	**/
	@JsonProperty("repositoryType")
	private String repositoryType;
	/**
 	* Source Version(/first commit) for the build was triggered. 
	**/
	@JsonProperty("sourceVersion")
	private String sourceVersion;
	/**
 	* Target BranchName. 
	**/
	@JsonProperty("targetBranchName")
	private String targetBranchName;
	/**
 	* Build Uri. 
	**/
	@JsonProperty("uri")
	private String uri;

	public String getBranchName() { return branchName; }

	public void setBranchName(String branchName) { this.branchName = branchName; }

	public Integer getBuildDefinitionId() { return buildDefinitionId; }

	public void setBuildDefinitionId(Integer buildDefinitionId) { this.buildDefinitionId = buildDefinitionId; }

	public String getBuildSystem() { return buildSystem; }

	public void setBuildSystem(String buildSystem) { this.buildSystem = buildSystem; }

	public String getCreationDate() { return creationDate; }

	public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

	public String getFlavor() { return flavor; }

	public void setFlavor(String flavor) { this.flavor = flavor; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getNumber() { return number; }

	public void setNumber(String number) { this.number = number; }

	public String getPlatform() { return platform; }

	public void setPlatform(String platform) { this.platform = platform; }

	public ShallowReference getProject() { return project; }

	public void setProject(ShallowReference project) { this.project = project; }

	public String getRepositoryGuid() { return repositoryGuid; }

	public void setRepositoryGuid(String repositoryGuid) { this.repositoryGuid = repositoryGuid; }

	public String getRepositoryType() { return repositoryType; }

	public void setRepositoryType(String repositoryType) { this.repositoryType = repositoryType; }

	public String getSourceVersion() { return sourceVersion; }

	public void setSourceVersion(String sourceVersion) { this.sourceVersion = sourceVersion; }

	public String getTargetBranchName() { return targetBranchName; }

	public void setTargetBranchName(String targetBranchName) { this.targetBranchName = targetBranchName; }

	public String getUri() { return uri; }

	public void setUri(String uri) { this.uri = uri; }

}