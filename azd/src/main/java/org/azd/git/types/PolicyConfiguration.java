package org.azd.git.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;
import org.azd.policy.types.PolicyTypeRef;

import java.util.Objects;


/**
 * The full policy configuration with settings.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyConfiguration extends SerializableEntity {
	/**
 	* The links to other objects related to this object. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* A reference to the identity that created the policy. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* The date and time when the policy was created. 
	**/
	@JsonProperty("createdDate")
	private String createdDate;
	/**
 	* The policy configuration ID. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Indicates whether the policy is blocking. 
	**/
	@JsonProperty("isBlocking")
	private Boolean isBlocking;
	/**
 	* Indicates whether the policy has been (soft) deleted. 
	**/
	@JsonProperty("isDeleted")
	private Boolean isDeleted;
	/**
 	* Indicates whether the policy is enabled. 
	**/
	@JsonProperty("isEnabled")
	private Boolean isEnabled;
	/**
 	* If set, this policy requires "Manage Enterprise Policies" permission to create, edit, or delete. 
	**/
	@JsonProperty("isEnterpriseManaged")
	private Boolean isEnterpriseManaged;
	/**
 	* The policy configuration revision ID. 
	**/
	@JsonProperty("revision")
	private Integer revision;
	/**
 	* The policy configuration settings. 
	**/
	@JsonProperty("settings")
	private Object settings;
	/**
 	* The policy configuration type. 
	**/
	@JsonProperty("type")
	private PolicyTypeRef type;
	/**
 	* The URL where the policy configuration can be retrieved. 
	**/
	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreatedDate() { return createdDate; }

	public void setCreatedDate(String createdDate) { this.createdDate = createdDate; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public Boolean getIsBlocking() { return isBlocking; }

	public void setIsBlocking(Boolean isBlocking) { this.isBlocking = isBlocking; }

	public Boolean getIsDeleted() { return isDeleted; }

	public void setIsDeleted(Boolean isDeleted) { this.isDeleted = isDeleted; }

	public Boolean getIsEnabled() { return isEnabled; }

	public void setIsEnabled(Boolean isEnabled) { this.isEnabled = isEnabled; }

	public Boolean getIsEnterpriseManaged() { return isEnterpriseManaged; }

	public void setIsEnterpriseManaged(Boolean isEnterpriseManaged) { this.isEnterpriseManaged = isEnterpriseManaged; }

	public Integer getRevision() { return revision; }

	public void setRevision(Integer revision) { this.revision = revision; }

	public Object getSettings() { return settings; }

	public void setSettings(Object settings) { this.settings = settings; }

	public PolicyTypeRef getType() { return type; }

	public void setType(PolicyTypeRef type) { this.type = type; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }
}
