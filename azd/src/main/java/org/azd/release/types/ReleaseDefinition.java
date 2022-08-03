package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ReleaseDefinitionSource;

import java.util.List;
import java.util.Map;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinition extends BaseAbstractMethod {
	/**
 	* Gets the links to related resources, APIs, and views for the release definition. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Gets or sets the list of artifacts. 
	**/
	@JsonProperty("artifacts")
	private List<Artifact> artifacts;
	/**
 	* Gets or sets comment. 
	**/
	@JsonProperty("comment")
	private String comment;
	/**
 	* Gets or sets the identity who created. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* Gets date on which it got created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Gets or sets the description. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Gets or sets the list of environments. 
	**/
	@JsonProperty("environments")
	private List<ReleaseDefinitionEnvironment> environments;
	/**
 	* Gets the unique identifier of release definition. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Whether release definition is deleted. 
	**/
	@JsonProperty("isDeleted")
	private boolean isDeleted;
	/**
 	* Gets the reference of last release. 
	**/
	@JsonProperty("lastRelease")
	private ReleaseReference lastRelease;
	/**
 	* Gets or sets the identity who modified. 
	**/
	@JsonProperty("modifiedBy")
	private Author modifiedBy;
	/**
 	* Gets date on which it got modified. 
	**/
	@JsonProperty("modifiedOn")
	private String modifiedOn;
	/**
 	* Gets or sets the name of the release definition. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets or sets the path of the release definition. 
	**/
	@JsonProperty("path")
	private String path;
	/**
 	* Gets or sets project reference. 
	**/
	@JsonProperty("projectReference")
	private ProjectReference projectReference;
	/**
 	* Gets or sets properties. 
	**/
	@JsonProperty("properties")
	private Object properties;
	/**
 	* Gets or sets the release name format. 
	**/
	@JsonProperty("releaseNameFormat")
	private String releaseNameFormat;
	/**
 	* Gets the revision number. 
	**/
	@JsonProperty("revision")
	private Integer revision;
	/**
 	* Gets or sets source of release definition. 
	**/
	@JsonProperty("source")
	private ReleaseDefinitionSource source;
	/**
 	* Gets or sets list of tags. 
	**/
	@JsonProperty("tags")
	private String[] tags;
	/**
 	* Gets or sets the list of triggers. 
	**/
	@JsonProperty("triggers")
	private List<ReleaseTriggerBase> triggers;
	/**
 	* Gets the REST API url to access the release definition. 
	**/
	@JsonProperty("url")
	private String url;
	/**
 	* Gets or sets the list of variable groups. 
	**/
	@JsonProperty("variableGroups")
	private List<Integer> variableGroups;
	/**
 	* Gets or sets the dictionary of variables. 
	**/
	@JsonProperty("variables")
	private Map<String, ConfigurationVariableValue> variables;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public List<Artifact> getArtifacts() { return artifacts; }

	public void setArtifacts(List<Artifact> artifacts) { this.artifacts = artifacts; }

	public String getComment() { return comment; }

	public void setComment(String comment) { this.comment = comment; }

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public List<ReleaseDefinitionEnvironment> getEnvironments() { return environments; }

	public void setEnvironments(List<ReleaseDefinitionEnvironment> environments) { this.environments = environments; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public boolean getIsDeleted() { return isDeleted; }

	public void setIsDeleted(boolean isDeleted) { this.isDeleted = isDeleted; }

	public ReleaseReference getLastRelease() { return lastRelease; }

	public void setLastRelease(ReleaseReference lastRelease) { this.lastRelease = lastRelease; }

	public Author getModifiedBy() { return modifiedBy; }

	public void setModifiedBy(Author modifiedBy) { this.modifiedBy = modifiedBy; }

	public String getModifiedOn() { return modifiedOn; }

	public void setModifiedOn(String modifiedOn) { this.modifiedOn = modifiedOn; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public ProjectReference getProjectReference() { return projectReference; }

	public void setProjectReference(ProjectReference projectReference) { this.projectReference = projectReference; }

	public Object getProperties() { return properties; }

	public void setProperties(Object properties) { this.properties = properties; }

	public String getReleaseNameFormat() { return releaseNameFormat; }

	public void setReleaseNameFormat(String releaseNameFormat) { this.releaseNameFormat = releaseNameFormat; }

	public Integer getRevision() { return revision; }

	public void setRevision(Integer revision) { this.revision = revision; }

	public ReleaseDefinitionSource getSource() { return source; }

	public void setSource(ReleaseDefinitionSource source) { this.source = source; }

	public String[] getTags() { return tags; }

	public void setTags(String[] tags) { this.tags = tags; }

	public List<ReleaseTriggerBase> getTriggers() { return triggers; }

	public void setTriggers(List<ReleaseTriggerBase> triggers) { this.triggers = triggers; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public List<Integer> getVariableGroups() { return variableGroups; }

	public void setVariableGroups(List<Integer> variableGroups) { this.variableGroups = variableGroups; }

	public Map<String, ConfigurationVariableValue> getVariables() { return variables; }

	public void setVariables(Map<String, ConfigurationVariableValue> variables) { this.variables = variables; }

}
