package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectEntitlement {
    @JsonProperty("assignmentSource")
    private String assignmentSource;
    @JsonProperty("group")
    private Group group;
    @JsonProperty("projectPermissionInherited")
    private String projectPermissionInherited;
    @JsonProperty("projectRef")
    private ProjectRef projectRef;
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

    @Override
    public String toString() {
        return "ProjectEntitlement{" +
                "assignmentSource='" + assignmentSource + '\'' +
                ", group=" + group +
                ", projectPermissionInherited='" + projectPermissionInherited + '\'' +
                ", projectRef=" + projectRef +
                ", teamRefs=" + teamRefs +
                '}';
    }
}
