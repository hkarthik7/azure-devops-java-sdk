package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.GitPullRequestMergeStrategy;

/**
 * Specify the strategy used to merge the pull request during completion. If MergeStrategy is not set to any value, a no-FF merge will be created if SquashMerge == false. If MergeStrategy is not set to any value, the pull request commits will be squashed if SquashMerge == true. The SquashMerge property is deprecated. It is recommended that you explicitly set MergeStrategy in all cases. If an explicit value is provided for MergeStrategy, the SquashMerge property will be ignored. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitPullRequestCompletionOptions extends BaseAbstractMethod {
	/**
 	* List of any policy configuration Id's which auto-complete should not wait for. Only applies to optional policies (isBlocking == false). Auto-complete always waits for required policies (isBlocking == true). 
	**/
	@JsonProperty("autoCompleteIgnoreConfigIds")
	private int[] autoCompleteIgnoreConfigIds;
	/**
 	* If true, policies will be explicitly bypassed while the pull request is completed. 
	**/
	@JsonProperty("bypassPolicy")
	private boolean bypassPolicy;
	/**
 	* If policies are bypassed, this reason is stored as to why bypass was used. 
	**/
	@JsonProperty("bypassReason")
	private String bypassReason;
	/**
 	* If true, the source branch of the pull request will be deleted after completion. 
	**/
	@JsonProperty("deleteSourceBranch")
	private boolean deleteSourceBranch;
	/**
 	* If set, this will be used as the commit message of the merge commit. 
	**/
	@JsonProperty("mergeCommitMessage")
	private String mergeCommitMessage;
	/**
 	* Specify the strategy used to merge the pull request during completion. If MergeStrategy is not set to any value, a no-FF merge will be created if SquashMerge == false. If MergeStrategy is not set to any value, the pull request commits will be squashed if SquashMerge == true. The SquashMerge property is deprecated. It is recommended that you explicitly set MergeStrategy in all cases. If an explicit value is provided for MergeStrategy, the SquashMerge property will be ignored. 
	**/
	@JsonProperty("mergeStrategy")
	private GitPullRequestMergeStrategy mergeStrategy;
	/**
 	* SquashMerge is deprecated. You should explicitly set the value of MergeStrategy. If MergeStrategy is set to any value, the SquashMerge value will be ignored. If MergeStrategy is not set, the merge strategy will be no-fast-forward if this flag is false, or squash if true. 
	**/
	@JsonProperty("squashMerge")
	private boolean squashMerge;
	/**
 	* If true, we will attempt to transition any work items linked to the pull request into the next logical state (i.e. Active -> Resolved) 
	**/
	@JsonProperty("transitionWorkItems")
	private boolean transitionWorkItems;
	/**
 	* If true, the current completion attempt was triggered via auto-complete. Used internally. 
	**/
	@JsonProperty("triggeredByAutoComplete")
	private boolean triggeredByAutoComplete;

	public int[] getAutoCompleteIgnoreConfigIds() { return autoCompleteIgnoreConfigIds; }

	public void setAutoCompleteIgnoreConfigIds(int[] autoCompleteIgnoreConfigIds) { this.autoCompleteIgnoreConfigIds = autoCompleteIgnoreConfigIds; }

	public boolean getBypassPolicy() { return bypassPolicy; }

	public void setBypassPolicy(boolean bypassPolicy) { this.bypassPolicy = bypassPolicy; }

	public String getBypassReason() { return bypassReason; }

	public void setBypassReason(String bypassReason) { this.bypassReason = bypassReason; }

	public boolean getDeleteSourceBranch() { return deleteSourceBranch; }

	public void setDeleteSourceBranch(boolean deleteSourceBranch) { this.deleteSourceBranch = deleteSourceBranch; }

	public String getMergeCommitMessage() { return mergeCommitMessage; }

	public void setMergeCommitMessage(String mergeCommitMessage) { this.mergeCommitMessage = mergeCommitMessage; }

	public GitPullRequestMergeStrategy getMergeStrategy() { return mergeStrategy; }

	public void setMergeStrategy(GitPullRequestMergeStrategy mergeStrategy) { this.mergeStrategy = mergeStrategy; }

	public boolean getSquashMerge() { return squashMerge; }

	public void setSquashMerge(boolean squashMerge) { this.squashMerge = squashMerge; }

	public boolean getTransitionWorkItems() { return transitionWorkItems; }

	public void setTransitionWorkItems(boolean transitionWorkItems) { this.transitionWorkItems = transitionWorkItems; }

	public boolean getTriggeredByAutoComplete() { return triggeredByAutoComplete; }

	public void setTriggeredByAutoComplete(boolean triggeredByAutoComplete) { this.triggeredByAutoComplete = triggeredByAutoComplete; }

}
