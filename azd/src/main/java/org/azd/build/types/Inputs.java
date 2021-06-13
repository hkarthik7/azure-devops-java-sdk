package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Inputs {
    @JsonProperty("branchFilters")
    private String branchFilters;
    @JsonProperty("workItemType")
    private String workItemType;
    @JsonProperty("assignToRequestor")
    private String assignToRequestor;

    public String getBranchFilters() {
        return branchFilters;
    }

    public void setBranchFilters(String branchFilters) {
        this.branchFilters = branchFilters;
    }

    public String getWorkItemType() {
        return workItemType;
    }

    public void setWorkItemType(String workItemType) {
        this.workItemType = workItemType;
    }

    public String getAssignToRequestor() {
        return assignToRequestor;
    }

    public void setAssignToRequestor(String assignToRequestor) {
        this.assignToRequestor = assignToRequestor;
    }

    @Override
    public String toString() {
        return "Inputs{" +
                "branchFilters='" + branchFilters + '\'' +
                ", workItemType='" + workItemType + '\'' +
                ", assignToRequestor='" + assignToRequestor + '\'' +
                '}';
    }
}
