package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Approval options
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApprovalOptions {
    /***
     * Specify whether the approval can be skipped if the same approver approved the previous stage.
     */
    @JsonProperty("autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped")
    private boolean autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped;
    /***
     * Specify whether revalidate identity of approver before completing the approval.
     */
    @JsonProperty("enforceIdentityRevalidation")
    private boolean enforceIdentityRevalidation;
    /***
     * Approvals execution order.
     */
    @JsonProperty("executionOrder")
    private String executionOrder;
    /***
     * Specify whether the user requesting a release or deployment should allow to approver.
     */
    @JsonProperty("releaseCreatorCanBeApprover")
    private boolean releaseCreatorCanBeApprover;
    /***
     * The number of approvals required to move release forward. '0' means all approvals required.
     */
    @JsonProperty("requiredApproverCount")
    private int requiredApproverCount;
    /***
     * Approval timeout. Approval default timeout is 30 days. Maximum allowed timeout is 365 days. '0' means default timeout i.e 30 days.
     */
    @JsonProperty("timeoutInMinutes")
    private int timeoutInMinutes;

    public boolean isAutoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped() {
        return autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped;
    }

    public void setAutoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped(boolean autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped) {
        this.autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped = autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped;
    }

    public boolean isEnforceIdentityRevalidation() {
        return enforceIdentityRevalidation;
    }

    public void setEnforceIdentityRevalidation(boolean enforceIdentityRevalidation) {
        this.enforceIdentityRevalidation = enforceIdentityRevalidation;
    }

    public String getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(String executionOrder) {
        this.executionOrder = executionOrder;
    }

    public boolean isReleaseCreatorCanBeApprover() {
        return releaseCreatorCanBeApprover;
    }

    public void setReleaseCreatorCanBeApprover(boolean releaseCreatorCanBeApprover) {
        this.releaseCreatorCanBeApprover = releaseCreatorCanBeApprover;
    }

    public int getRequiredApproverCount() {
        return requiredApproverCount;
    }

    public void setRequiredApproverCount(int requiredApproverCount) {
        this.requiredApproverCount = requiredApproverCount;
    }

    public int isTimeoutInMinutes() {
        return timeoutInMinutes;
    }

    public void setTimeoutInMinutes(int timeoutInMinutes) {
        this.timeoutInMinutes = timeoutInMinutes;
    }

    @Override
    public String toString() {
        return "ApprovalOptions{" +
                "autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped=" + autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped +
                ", enforceIdentityRevalidation=" + enforceIdentityRevalidation +
                ", executionOrder='" + executionOrder + '\'' +
                ", releaseCreatorCanBeApprover=" + releaseCreatorCanBeApprover +
                ", requiredApproverCount=" + requiredApproverCount +
                ", timeoutInMinutes=" + timeoutInMinutes +
                '}';
    }
}
