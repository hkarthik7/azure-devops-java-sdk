package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionApprovals {
    @JsonProperty("approvalOptions")
    private ApprovalOptions approvalOptions;
    @JsonProperty("approvals")
    private ReleaseDefinitionApprovalStep approvals;

    public ApprovalOptions getApprovalOptions() {
        return approvalOptions;
    }

    public void setApprovalOptions(ApprovalOptions approvalOptions) {
        this.approvalOptions = approvalOptions;
    }

    public ReleaseDefinitionApprovalStep getApprovals() {
        return approvals;
    }

    public void setApprovals(ReleaseDefinitionApprovalStep approvals) {
        this.approvals = approvals;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionApprovals{" +
                "approvalOptions=" + approvalOptions +
                ", approvals=" + approvals +
                '}';
    }

}
