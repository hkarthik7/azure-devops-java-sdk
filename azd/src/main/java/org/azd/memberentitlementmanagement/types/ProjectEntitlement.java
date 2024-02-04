package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.AssignmentSource;
import org.azd.enums.ProjectPermissionInherited;

import java.util.List;

/**
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectEntitlement extends SerializableEntity {
	/**
 	* Assignment Source (e.g. Group or Unknown). 
	**/
	@JsonProperty("assignmentSource")
	private AssignmentSource assignmentSource;
	/**
 	* Project Group (e.g. Contributor, Reader etc.) 
	**/
	@JsonProperty("group")
	private Group group;
	/**
 	* Whether the user is inheriting permissions to a project through a Azure DevOps or AAD group membership. 
	**/
	@JsonProperty("projectPermissionInherited")
	private ProjectPermissionInherited projectPermissionInherited;
	/**
 	* Project Ref 
	**/
	@JsonProperty("projectRef")
	private ProjectRef projectRef;
	/**
 	* Team Ref. 
	**/
	@JsonProperty("teamRefs")
	private List<TeamRef> teamRefs;

	public AssignmentSource getAssignmentSource() { return assignmentSource; }

	public void setAssignmentSource(AssignmentSource assignmentSource) { this.assignmentSource = assignmentSource; }

	public Group getGroup() { return group; }

	public void setGroup(Group group) { this.group = group; }

	public ProjectPermissionInherited getProjectPermissionInherited() { return projectPermissionInherited; }

	public void setProjectPermissionInherited(ProjectPermissionInherited projectPermissionInherited) { this.projectPermissionInherited = projectPermissionInherited; }

	public ProjectRef getProjectRef() { return projectRef; }

	public void setProjectRef(ProjectRef projectRef) { this.projectRef = projectRef; }

	public List<TeamRef> getTeamRefs() { return teamRefs; }

	public void setTeamRefs(List<TeamRef> teamRefs) { this.teamRefs = teamRefs; }

}