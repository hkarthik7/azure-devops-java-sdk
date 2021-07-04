package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.graph.types.GraphUser;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlement {
    @JsonProperty("accessLevel")
    private AccessLevel accessLevel;
    @JsonProperty("dateCreated")
    private String dateCreated;
    @JsonProperty("groupAssignments")
    private List<GroupEntitlement> groupAssignments;
    @JsonProperty("id")
    private String id;
    @JsonProperty("lastAccessedDate")
    private String lastAccessedDate;
    @JsonProperty("projectEntitlements")
    private List<ProjectEntitlement> projectEntitlements;
    @JsonProperty("user")
    private GraphUser user;

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<GroupEntitlement> getGroupAssignments() {
        return groupAssignments;
    }

    public void setGroupAssignments(List<GroupEntitlement> groupAssignments) {
        this.groupAssignments = groupAssignments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastAccessedDate() {
        return lastAccessedDate;
    }

    public void setLastAccessedDate(String lastAccessedDate) {
        this.lastAccessedDate = lastAccessedDate;
    }

    public List<ProjectEntitlement> getProjectEntitlements() {
        return projectEntitlements;
    }

    public void setProjectEntitlements(List<ProjectEntitlement> projectEntitlements) {
        this.projectEntitlements = projectEntitlements;
    }

    public GraphUser getUser() {
        return user;
    }

    public void setUser(GraphUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserEntitlement{" +
                "accessLevel=" + accessLevel +
                ", dateCreated='" + dateCreated + '\'' +
                ", groupAssignments=" + groupAssignments +
                ", id='" + id + '\'' +
                ", lastAccessedDate='" + lastAccessedDate + '\'' +
                ", projectEntitlements=" + projectEntitlements +
                ", user=" + user +
                '}';
    }
}
