package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Relation between a project and the user's effective permissions in that project.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectEntitlement extends BaseAbstractMethod {
    /***
     * Assignment Source (e.g. Group or Unknown).
     */
    @JsonProperty("assignmentSource")
    private String assignmentSource;
    /***
     * Project Group (e.g. Contributor, Reader etc.)
     */
    @JsonProperty("group")
    private Group group;
    /***
     * Whether the user is inheriting permissions to a project through a Azure DevOps or AAD group membership.
     */
    @JsonProperty("projectPermissionInherited")
    private String projectPermissionInherited;
    /***
     * Project Ref
     */
    @JsonProperty("projectRef")
    private ProjectRef projectRef;
    /***
     * Team Ref
     */
    @JsonProperty("teamRefs")
    private List<TeamRef> teamRefs;

    public String getAssignmentSource() {
        return assignmentSource;
    }

    public void setAssignmentSource(String assignmentSource) {
        this.assignmentSource = assignmentSource;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getProjectPermissionInherited() {
        return projectPermissionInherited;
    }

    public void setProjectPermissionInherited(String projectPermissionInherited) {
        this.projectPermissionInherited = projectPermissionInherited;
    }

    public ProjectRef getProjectRef() {
        return projectRef;
    }

    public void setProjectRef(ProjectRef projectRef) {
        this.projectRef = projectRef;
    }

    public List<TeamRef> getTeamRefs() {
        return teamRefs;
    }

    public void setTeamRefs(List<TeamRef> teamRefs) {
        this.teamRefs = teamRefs;
    }

}
