package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents build options input
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Inputs extends BaseAbstractMethod {
    /***
     * Branch filters
     */
    @JsonProperty("branchFilters")
    private String branchFilters;
    /***
     * Type of workitem
     */
    @JsonProperty("workItemType")
    private String workItemType;
    /***
     * user reference
     */
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

}
