package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlement extends SerializableEntity {
	/**
 	* Member's access level denoted by a license. 
	**/
	@JsonProperty("accessLevel")
	private AccessLevel accessLevel;
	/**
 	* [Readonly] Date the member was added to the collection. 
	**/
	@JsonProperty("dateCreated")
	private String dateCreated;
	/**
 	* [Readonly] GroupEntitlements that this member belongs to. 
	**/
	@JsonProperty("groupAssignments")
	private List<GroupEntitlement> groupAssignments;
	/**
 	* The unique identifier which matches the Id of the Identity associated with the GraphMember. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* [Readonly] Date the member last accessed the collection. 
	**/
	@JsonProperty("lastAccessedDate")
	private String lastAccessedDate;
	/**
 	* Relation between a project and the member's effective permissions in that project. 
	**/
	@JsonProperty("projectEntitlements")
	private List<ProjectEntitlement> projectEntitlements;
	/**
 	* User reference. 
	**/
	@JsonProperty("user")
	private GraphUser user;
	/**
	 * User reference.
	 **/
	@JsonProperty("member")
	private GraphUser member;

	public AccessLevel getAccessLevel() { return accessLevel; }

	public void setAccessLevel(AccessLevel accessLevel) { this.accessLevel = accessLevel; }

	public String getDateCreated() { return dateCreated; }

	public void setDateCreated(String dateCreated) { this.dateCreated = dateCreated; }

	public List<GroupEntitlement> getGroupAssignments() { return groupAssignments; }

	public void setGroupAssignments(List<GroupEntitlement> groupAssignments) { this.groupAssignments = groupAssignments; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getLastAccessedDate() { return lastAccessedDate; }

	public void setLastAccessedDate(String lastAccessedDate) { this.lastAccessedDate = lastAccessedDate; }

	public List<ProjectEntitlement> getProjectEntitlements() { return projectEntitlements; }

	public void setProjectEntitlements(List<ProjectEntitlement> projectEntitlements) { this.projectEntitlements = projectEntitlements; }

	public GraphUser getUser() { return user; }

	public void setUser(GraphUser user) { this.user = user; }

	public GraphUser getMember() {
		return member;
	}

	public void setMember(GraphUser member) {
		this.member = member;
	}
}