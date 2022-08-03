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
import org.azd.enums.ReleaseReason;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseReference extends BaseAbstractMethod {
	/**
 	* Gets links to access the release. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Gets list of artifacts. 
	**/
	@JsonProperty("artifacts")
	private List<Artifact> artifacts;
	/**
 	* Gets the identity who created release. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* Gets date on when this release created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Gets description. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* ID of the Release. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Gets the identity who modified release. 
	**/
	@JsonProperty("modifiedBy")
	private Author modifiedBy;
	/**
 	* Gets name of release. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets reason for release. 
	**/
	@JsonProperty("reason")
	private ReleaseReason reason;
	/**
 	* Gets release definition shallow reference. 
	**/
	@JsonProperty("releaseDefinition")
	private ReleaseDefinitionShallowReference releaseDefinition;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public List<Artifact> getArtifacts() { return artifacts; }

	public void setArtifacts(List<Artifact> artifacts) { this.artifacts = artifacts; }

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public Author getModifiedBy() { return modifiedBy; }

	public void setModifiedBy(Author modifiedBy) { this.modifiedBy = modifiedBy; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public ReleaseReason getReason() { return reason; }

	public void setReason(ReleaseReason reason) { this.reason = reason; }

	public ReleaseDefinitionShallowReference getReleaseDefinition() { return releaseDefinition; }

	public void setReleaseDefinition(ReleaseDefinitionShallowReference releaseDefinition) { this.releaseDefinition = releaseDefinition; }

}
