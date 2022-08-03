package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ApprovalExecutionOrder;

/**
 * Gets or sets the condition type. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApprovalOptions extends BaseAbstractMethod {
	/**
 	* Specify whether the approval can be skipped if the same approver approved the previous stage. 
	**/
	@JsonProperty("autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped")
	private boolean autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped;
	/**
 	* Specify whether revalidate identity of approver before completing the approval. 
	**/
	@JsonProperty("enforceIdentityRevalidation")
	private boolean enforceIdentityRevalidation;
	/**
 	* Approvals execution order. 
	**/
	@JsonProperty("executionOrder")
	private ApprovalExecutionOrder executionOrder;
	/**
 	* Specify whether the user requesting a release or deployment should allow to approver. 
	**/
	@JsonProperty("releaseCreatorCanBeApprover")
	private boolean releaseCreatorCanBeApprover;
	/**
 	* The number of approvals required to move release forward. '0' means all approvals required. 
	**/
	@JsonProperty("requiredApproverCount")
	private Integer requiredApproverCount;
	/**
 	* Approval timeout. Approval default timeout is 30 days. Maximum allowed timeout is 365 days. '0' means default timeout i.e 30 days. 
	**/
	@JsonProperty("timeoutInMinutes")
	private Integer timeoutInMinutes;

	public boolean getAutoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped() { return autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped; }

	public void setAutoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped(boolean autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped) { this.autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped = autoTriggeredAndPreviousEnvironmentApprovedCanBeSkipped; }

	public boolean getEnforceIdentityRevalidation() { return enforceIdentityRevalidation; }

	public void setEnforceIdentityRevalidation(boolean enforceIdentityRevalidation) { this.enforceIdentityRevalidation = enforceIdentityRevalidation; }

	public ApprovalExecutionOrder getExecutionOrder() { return executionOrder; }

	public void setExecutionOrder(ApprovalExecutionOrder executionOrder) { this.executionOrder = executionOrder; }

	public boolean getReleaseCreatorCanBeApprover() { return releaseCreatorCanBeApprover; }

	public void setReleaseCreatorCanBeApprover(boolean releaseCreatorCanBeApprover) { this.releaseCreatorCanBeApprover = releaseCreatorCanBeApprover; }

	public Integer getRequiredApproverCount() { return requiredApproverCount; }

	public void setRequiredApproverCount(Integer requiredApproverCount) { this.requiredApproverCount = requiredApproverCount; }

	public Integer getTimeoutInMinutes() { return timeoutInMinutes; }

	public void setTimeoutInMinutes(Integer timeoutInMinutes) { this.timeoutInMinutes = timeoutInMinutes; }

}
