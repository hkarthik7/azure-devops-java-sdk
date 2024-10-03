package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.GroupLicensingRuleStatus;

import java.util.List;

/**
 * The status of the group rule. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupEntitlement extends SerializableEntity {
	/**
 	* Member reference. 
	**/
	@JsonProperty("group")
	private GraphGroup group;
	/**
 	* The unique identifier which matches the Id of the GraphMember. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* [Readonly] The last time the group licensing rule was executed (regardless of whether any changes were made). 
	**/
	@JsonProperty("lastExecuted")
	private String lastExecuted;
	/**
 	* License Rule. 
	**/
	@JsonProperty("licenseRule")
	private AccessLevel licenseRule;
	/**
 	* Group members. Only used when creating a new group. 
	**/
	@JsonProperty("members")
	private List<UserEntitlement> members;
	/**
 	* Relation between a project and the member's effective permissions in that project. 
	**/
	@JsonProperty("projectEntitlements")
	private List<ProjectEntitlement> projectEntitlements;
	/**
 	* The status of the group rule. 
	**/
	@JsonProperty("status")
	private GroupLicensingRuleStatus status;

	public GraphGroup getGroup() { return group; }

	public void setGroup(GraphGroup group) { this.group = group; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getLastExecuted() { return lastExecuted; }

	public void setLastExecuted(String lastExecuted) { this.lastExecuted = lastExecuted; }

	public AccessLevel getLicenseRule() { return licenseRule; }

	public void setLicenseRule(AccessLevel licenseRule) { this.licenseRule = licenseRule; }

	public List<UserEntitlement> getMembers() { return members; }

	public void setMembers(List<UserEntitlement> members) { this.members = members; }

	public List<ProjectEntitlement> getProjectEntitlements() { return projectEntitlements; }

	public void setProjectEntitlements(List<ProjectEntitlement> projectEntitlements) { this.projectEntitlements = projectEntitlements; }

	public GroupLicensingRuleStatus getStatus() { return status; }

	public void setStatus(GroupLicensingRuleStatus status) { this.status = status; }

}