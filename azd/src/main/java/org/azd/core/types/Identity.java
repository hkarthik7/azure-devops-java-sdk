package org.azd.core.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/**
 * Represnts an Identity object.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Identity extends SerializableEntity {
	/**
 	* The custom display name for the identity (if any). Setting this property to an empty string will clear the existing custom display name. Setting this property to null will not affect the existing persisted value (since null values do not get sent over the wire or to the database) 
	**/
	@JsonProperty("customDisplayName")
	private String customDisplayName;
	/**
 	* An Identity descriptor is a wrapper for the identity type (Windows SID, Passport) along with a unique identifier such as the SID or PUID. 
	**/
	@JsonProperty("descriptor")
	private String descriptor;
	/**
 	* Identity Identifier. Also called Storage Key, or VSID 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* True if the identity has a membership in any Azure Devops group in the organization. 
	**/
	@JsonProperty("isActive")
	private boolean isActive;
	/**
 	* True if the identity is a group. 
	**/
	@JsonProperty("isContainer")
	private boolean isContainer;

	@JsonProperty("masterId")
	private String masterId;
	/**
 	* Id of the members of the identity (groups only). 
	**/
	@JsonProperty("memberIds")
	private List<String> memberIds;
	/**
 	* An Identity descriptor is a wrapper for the identity type (Windows SID, Passport) along with a unique identifier such as the SID or PUID. 
	**/
	@JsonProperty("memberOf")
	private List<String> memberOf;
	/**
 	* An Identity descriptor is a wrapper for the identity type (Windows SID, Passport) along with a unique identifier such as the SID or PUID. 
	**/
	@JsonProperty("members")
	private List<String> members;

	@JsonProperty("metaTypeId")
	private Integer metaTypeId;
	/**
 	* The class represents a property bag as a collection of key-value pairs. Values of all primitive types (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected as base64 encoded string. 
	**/
	@JsonProperty("properties")
	private PropertiesCollection properties;
	/**
 	* The display name for the identity as specified by the source identity provider. 
	**/
	@JsonProperty("providerDisplayName")
	private String providerDisplayName;

	@JsonProperty("resourceVersion")
	private Integer resourceVersion;

	@JsonProperty("socialDescriptor")
	private String socialDescriptor;
	/**
 	* Subject descriptor of a Graph entity. 
	**/
	@JsonProperty("subjectDescriptor")
	private String subjectDescriptor;

	@JsonProperty("uniqueUserId")
	private Integer uniqueUserId;

	public String getCustomDisplayName() { return customDisplayName; }

	public void setCustomDisplayName(String customDisplayName) { this.customDisplayName = customDisplayName; }

	public String getDescriptor() { return descriptor; }

	public void setDescriptor(String descriptor) { this.descriptor = descriptor; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public boolean getIsActive() { return isActive; }

	public void setIsActive(boolean isActive) { this.isActive = isActive; }

	public boolean getIsContainer() { return isContainer; }

	public void setIsContainer(boolean isContainer) { this.isContainer = isContainer; }

	public String getMasterId() { return masterId; }

	public void setMasterId(String masterId) { this.masterId = masterId; }

	public List<String> getMemberIds() { return memberIds; }

	public void setMemberIds(List<String> memberIds) { this.memberIds = memberIds; }

	public List<String> getMemberOf() { return memberOf; }

	public void setMemberOf(List<String> memberOf) { this.memberOf = memberOf; }

	public List<String> getMembers() { return members; }

	public void setMembers(List<String> members) { this.members = members; }

	public Integer getMetaTypeId() { return metaTypeId; }

	public void setMetaTypeId(Integer metaTypeId) { this.metaTypeId = metaTypeId; }

	public PropertiesCollection getProperties() { return properties; }

	public void setProperties(PropertiesCollection properties) { this.properties = properties; }

	public String getProviderDisplayName() { return providerDisplayName; }

	public void setProviderDisplayName(String providerDisplayName) { this.providerDisplayName = providerDisplayName; }

	public Integer getResourceVersion() { return resourceVersion; }

	public void setResourceVersion(Integer resourceVersion) { this.resourceVersion = resourceVersion; }

	public String getSocialDescriptor() { return socialDescriptor; }

	public void setSocialDescriptor(String socialDescriptor) { this.socialDescriptor = socialDescriptor; }

	public String getSubjectDescriptor() { return subjectDescriptor; }

	public void setSubjectDescriptor(String subjectDescriptor) { this.subjectDescriptor = subjectDescriptor; }

	public Integer getUniqueUserId() { return uniqueUserId; }

	public void setUniqueUserId(Integer uniqueUserId) { this.uniqueUserId = uniqueUserId; }

}