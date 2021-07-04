package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.graph.types.GraphGroup;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupEntitlement {
    @JsonProperty("group")
    private GraphGroup group;
    @JsonProperty("id")
    private String id;
    @JsonProperty("lastExecuted")
    private String lastExecuted;
    @JsonProperty("licenseRule")
    private AccessLevel licenseRule;
    @JsonProperty("members")
    private List<UserEntitlement> members;
    @JsonProperty("projectEntitlements")
    private List<ProjectEntitlement> projectEntitlements;
    @JsonProperty("status")
    private String status;

    public GraphGroup getGroup() {
        return group;
    }

    public void setGroup(GraphGroup group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastExecuted() {
        return lastExecuted;
    }

    public void setLastExecuted(String lastExecuted) {
        this.lastExecuted = lastExecuted;
    }

    public AccessLevel getLicenseRule() {
        return licenseRule;
    }

    public void setLicenseRule(AccessLevel licenseRule) {
        this.licenseRule = licenseRule;
    }

    public List<UserEntitlement> getMembers() {
        return members;
    }

    public void setMembers(List<UserEntitlement> members) {
        this.members = members;
    }

    public List<ProjectEntitlement> getProjectEntitlements() {
        return projectEntitlements;
    }

    public void setProjectEntitlements(List<ProjectEntitlement> projectEntitlements) {
        this.projectEntitlements = projectEntitlements;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GroupEntitlement{" +
                "group=" + group +
                ", id='" + id + '\'' +
                ", lastExecuted='" + lastExecuted + '\'' +
                ", licenseRule=" + licenseRule +
                ", members=" + members +
                ", projectEntitlements=" + projectEntitlements +
                ", status='" + status + '\'' +
                '}';
    }
}
