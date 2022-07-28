package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A filter which would allow fetching approval steps selectively based on whether it is automated, or manual. This would also decide whether we should fetch pre and post approval snapshots. Assumes All by default 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ApprovalFilters {
	/**
 	* All approval steps and approval snapshots. 
	**/
	@JsonProperty("all")
	ALL,
	/**
 	* No approval steps, but approval snapshots (Use with either ManualApprovals or AutomatedApprovals for approval steps). 
	**/
	@JsonProperty("approvalSnapshots")
	APPROVALSNAPSHOTS,
	/**
 	* Automated approval steps but no approval snapshots (Use with ApprovalSnapshots for snapshots). 
	**/
	@JsonProperty("automatedApprovals")
	AUTOMATEDAPPROVALS,
	/**
 	* Manual approval steps but no approval snapshots (Use with ApprovalSnapshots for snapshots). 
	**/
	@JsonProperty("manualApprovals")
	MANUALAPPROVALS,
	/**
 	* No approvals or approval snapshots. 
	**/
	@JsonProperty("none")
	NONE;
}