package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApprovalOptions {
    @JsonProperty("autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped")
    private boolean autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped;
    @JsonProperty("enforceIdentityRevalidation")
    private boolean enforceIdentityRevalidation;
    @JsonProperty("executionOrder")
    private String executionOrder;
    @JsonProperty("releaseCreatorCanBeApprover")
    private boolean releaseCreatorCanBeApprover;
    @JsonProperty("requiredApproverCount")
    private int requiredApproverCount;
    @JsonProperty("timeoutInMinutes")
    private boolean timeoutInMinutes;

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

    public boolean isTimeoutInMinutes() {
        return timeoutInMinutes;
    }

    public void setTimeoutInMinutes(boolean timeoutInMinutes) {
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
