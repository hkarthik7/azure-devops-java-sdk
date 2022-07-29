package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status context that uniquely identifies the status. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GitPullRequestMergeStrategy {
	/**
 	* A two-parent, no-fast-forward merge. The source branch is unchanged. This is the default behavior. 
	**/
	@JsonProperty("noFastForward")
	NOFASTFORWARD,
	/**
 	* Rebase the source branch on top of the target branch HEAD commit, and fast-forward the target branch. The source branch is updated during the rebase operation. 
	**/
	@JsonProperty("rebase")
	REBASE,
	/**
 	* Rebase the source branch on top of the target branch HEAD commit, and create a two-parent, no-fast-forward merge. The source branch is updated during the rebase operation. 
	**/
	@JsonProperty("rebaseMerge")
	REBASEMERGE,
	/**
 	* Put all changes from the pull request into a single-parent commit. 
	**/
	@JsonProperty("squash")
	SQUASH;
}