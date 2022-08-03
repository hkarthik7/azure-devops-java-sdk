package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionApprovals extends BaseAbstractMethod {
	/**
 	* Gets or sets the approval options. 
	**/
	@JsonProperty("approvalOptions")
	private ApprovalOptions approvalOptions;
	/**
 	* Gets or sets the approvals. 
	**/
	@JsonProperty("approvals")
	private List<ReleaseDefinitionApprovalStep> approvals;

	public ApprovalOptions getApprovalOptions() { return approvalOptions; }

	public void setApprovalOptions(ApprovalOptions approvalOptions) { this.approvalOptions = approvalOptions; }

	public List<ReleaseDefinitionApprovalStep> getApprovals() { return approvals; }

	public void setApprovals(List<ReleaseDefinitionApprovalStep> approvals) { this.approvals = approvals; }

}
