package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourcePullRequestVersion extends SerializableEntity {
	/**
 	* Pull Request Iteration Id for which the release will publish status. 
	**/
	@JsonProperty("iterationId")
	private String iterationId;
	/**
 	* Pull Request Id for which the release will publish status. 
	**/
	@JsonProperty("pullRequestId")
	private String pullRequestId;
	/**
 	* Date and time of the pull request merge creation. It is required to keep timeline record of Releases created by pull request. 
	**/
	@JsonProperty("pullRequestMergedAt")
	private String pullRequestMergedAt;
	/**
 	* Source branch of the Pull Request. 
	**/
	@JsonProperty("sourceBranch")
	private String sourceBranch;
	/**
 	* Source branch commit Id of the Pull Request for which the release will publish status. 
	**/
	@JsonProperty("sourceBranchCommitId")
	private String sourceBranchCommitId;
	/**
 	* Target branch of the Pull Request. 
	**/
	@JsonProperty("targetBranch")
	private String targetBranch;

	public String getIterationId() { return iterationId; }

	public void setIterationId(String iterationId) { this.iterationId = iterationId; }

	public String getPullRequestId() { return pullRequestId; }

	public void setPullRequestId(String pullRequestId) { this.pullRequestId = pullRequestId; }

	public String getPullRequestMergedAt() { return pullRequestMergedAt; }

	public void setPullRequestMergedAt(String pullRequestMergedAt) { this.pullRequestMergedAt = pullRequestMergedAt; }

	public String getSourceBranch() { return sourceBranch; }

	public void setSourceBranch(String sourceBranch) { this.sourceBranch = sourceBranch; }

	public String getSourceBranchCommitId() { return sourceBranchCommitId; }

	public void setSourceBranchCommitId(String sourceBranchCommitId) { this.sourceBranchCommitId = sourceBranchCommitId; }

	public String getTargetBranch() { return targetBranch; }

	public void setTargetBranch(String targetBranch) { this.targetBranch = targetBranch; }

}