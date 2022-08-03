package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.PullRequestAsyncStatus;
import org.azd.enums.PullRequestMergeFailureType;
import org.azd.enums.PullRequestStatus;

import java.util.List;

/**
 * The options which are used when a pull request merge is created. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitPullRequest extends BaseAbstractMethod {
	/**
 	* Links to other related objects. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* A string which uniquely identifies this pull request. To generate an artifact ID for a pull request, use this template: vstfs:///Git/PullRequestId/{projectId}/{repositoryId}/{pullRequestId} 
	**/
	@JsonProperty("artifactId")
	private String artifactId;
	/**
 	* If set, auto-complete is enabled for this pull request and this is the identity that enabled it. 
	**/
	@JsonProperty("autoCompleteSetBy")
	private Author autoCompleteSetBy;
	/**
 	* The user who closed the pull request. 
	**/
	@JsonProperty("closedBy")
	private Author closedBy;
	/**
 	* The date when the pull request was closed (completed, abandoned, or merged externally). 
	**/
	@JsonProperty("closedDate")
	private String closedDate;
	/**
 	* The code review ID of the pull request. Used internally. 
	**/
	@JsonProperty("codeReviewId")
	private Integer codeReviewId;
	/**
 	* The commits contained in the pull request. 
	**/
	@JsonProperty("commits")
	private List<GitCommitRef> commits;
	/**
 	* Options which affect how the pull request will be merged when it is completed. 
	**/
	@JsonProperty("completionOptions")
	private GitPullRequestCompletionOptions completionOptions;
	/**
 	* The most recent date at which the pull request entered the queue to be completed. Used internally. 
	**/
	@JsonProperty("completionQueueTime")
	private String completionQueueTime;
	/**
 	* The identity of the user who created the pull request. 
	**/
	@JsonProperty("createdBy")
	private Author createdBy;
	/**
 	* The date when the pull request was created. 
	**/
	@JsonProperty("creationDate")
	private String creationDate;
	/**
 	* The description of the pull request. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* If this is a PR from a fork this will contain information about its source. 
	**/
	@JsonProperty("forkSource")
	private GitForkRef forkSource;
	/**
 	* Multiple mergebases warning 
	**/
	@JsonProperty("hasMultipleMergeBases")
	private boolean hasMultipleMergeBases;
	/**
 	* Draft / WIP pull request. 
	**/
	@JsonProperty("isDraft")
	private boolean isDraft;
	/**
 	* The labels associated with the pull request. 
	**/
	@JsonProperty("labels")
	private List<WebApiTagDefinition> labels;
	/**
 	* The commit of the most recent pull request merge. If empty, the most recent merge is in progress or was unsuccessful. 
	**/
	@JsonProperty("lastMergeCommit")
	private GitCommitRef lastMergeCommit;
	/**
 	* The commit at the head of the source branch at the time of the last pull request merge. 
	**/
	@JsonProperty("lastMergeSourceCommit")
	private GitCommitRef lastMergeSourceCommit;
	/**
 	* The commit at the head of the target branch at the time of the last pull request merge. 
	**/
	@JsonProperty("lastMergeTargetCommit")
	private GitCommitRef lastMergeTargetCommit;
	/**
 	* If set, pull request merge failed for this reason. 
	**/
	@JsonProperty("mergeFailureMessage")
	private String mergeFailureMessage;
	/**
 	* The type of failure (if any) of the pull request merge. 
	**/
	@JsonProperty("mergeFailureType")
	private PullRequestMergeFailureType mergeFailureType;
	/**
 	* The ID of the job used to run the pull request merge. Used internally. 
	**/
	@JsonProperty("mergeId")
	private String mergeId;
	/**
 	* Options used when the pull request merge runs. These are separate from completion options since completion happens only once and a new merge will run every time the source branch of the pull request changes. 
	**/
	@JsonProperty("mergeOptions")
	private GitPullRequestMergeOptions mergeOptions;
	/**
 	* The current status of the pull request merge. 
	**/
	@JsonProperty("mergeStatus")
	private PullRequestAsyncStatus mergeStatus;
	/**
 	* The ID of the pull request. 
	**/
	@JsonProperty("pullRequestId")
	private Integer pullRequestId;
	/**
 	* Used internally. 
	**/
	@JsonProperty("remoteUrl")
	private String remoteUrl;
	/**
 	* The repository containing the target branch of the pull request. 
	**/
	@JsonProperty("repository")
	private GitRepository repository;
	/**
 	* A list of reviewers on the pull request along with the state of their votes. 
	**/
	@JsonProperty("reviewers")
	private List<IdentityRefWithVote> reviewers;
	/**
 	* The name of the source branch of the pull request. 
	**/
	@JsonProperty("sourceRefName")
	private String sourceRefName;
	/**
 	* The status of the pull request. 
	**/
	@JsonProperty("status")
	private PullRequestStatus status;
	/**
 	* If true, this pull request supports multiple iterations. Iteration support means individual pushes to the source branch of the pull request can be reviewed and comments left in one iteration will be tracked across future iterations. 
	**/
	@JsonProperty("supportsIterations")
	private boolean supportsIterations;
	/**
 	* The name of the target branch of the pull request. 
	**/
	@JsonProperty("targetRefName")
	private String targetRefName;
	/**
 	* The title of the pull request. 
	**/
	@JsonProperty("title")
	private String title;
	/**
 	* Used internally. 
	**/
	@JsonProperty("url")
	private String url;
	/**
 	* Any work item references associated with this pull request. 
	**/
	@JsonProperty("workItemRefs")
	private List<ResourceRef> workItemRefs;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getArtifactId() { return artifactId; }

	public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

	public Author getAutoCompleteSetBy() { return autoCompleteSetBy; }

	public void setAutoCompleteSetBy(Author autoCompleteSetBy) { this.autoCompleteSetBy = autoCompleteSetBy; }

	public Author getClosedBy() { return closedBy; }

	public void setClosedBy(Author closedBy) { this.closedBy = closedBy; }

	public String getClosedDate() { return closedDate; }

	public void setClosedDate(String closedDate) { this.closedDate = closedDate; }

	public Integer getCodeReviewId() { return codeReviewId; }

	public void setCodeReviewId(Integer codeReviewId) { this.codeReviewId = codeReviewId; }

	public List<GitCommitRef> getCommits() { return commits; }

	public void setCommits(List<GitCommitRef> commits) { this.commits = commits; }

	public GitPullRequestCompletionOptions getCompletionOptions() { return completionOptions; }

	public void setCompletionOptions(GitPullRequestCompletionOptions completionOptions) { this.completionOptions = completionOptions; }

	public String getCompletionQueueTime() { return completionQueueTime; }

	public void setCompletionQueueTime(String completionQueueTime) { this.completionQueueTime = completionQueueTime; }

	public Author getCreatedBy() { return createdBy; }

	public void setCreatedBy(Author createdBy) { this.createdBy = createdBy; }

	public String getCreationDate() { return creationDate; }

	public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public GitForkRef getForkSource() { return forkSource; }

	public void setForkSource(GitForkRef forkSource) { this.forkSource = forkSource; }

	public boolean getHasMultipleMergeBases() { return hasMultipleMergeBases; }

	public void setHasMultipleMergeBases(boolean hasMultipleMergeBases) { this.hasMultipleMergeBases = hasMultipleMergeBases; }

	public boolean getIsDraft() { return isDraft; }

	public void setIsDraft(boolean isDraft) { this.isDraft = isDraft; }

	public List<WebApiTagDefinition> getLabels() { return labels; }

	public void setLabels(List<WebApiTagDefinition> labels) { this.labels = labels; }

	public GitCommitRef getLastMergeCommit() { return lastMergeCommit; }

	public void setLastMergeCommit(GitCommitRef lastMergeCommit) { this.lastMergeCommit = lastMergeCommit; }

	public GitCommitRef getLastMergeSourceCommit() { return lastMergeSourceCommit; }

	public void setLastMergeSourceCommit(GitCommitRef lastMergeSourceCommit) { this.lastMergeSourceCommit = lastMergeSourceCommit; }

	public GitCommitRef getLastMergeTargetCommit() { return lastMergeTargetCommit; }

	public void setLastMergeTargetCommit(GitCommitRef lastMergeTargetCommit) { this.lastMergeTargetCommit = lastMergeTargetCommit; }

	public String getMergeFailureMessage() { return mergeFailureMessage; }

	public void setMergeFailureMessage(String mergeFailureMessage) { this.mergeFailureMessage = mergeFailureMessage; }

	public PullRequestMergeFailureType getMergeFailureType() { return mergeFailureType; }

	public void setMergeFailureType(PullRequestMergeFailureType mergeFailureType) { this.mergeFailureType = mergeFailureType; }

	public String getMergeId() { return mergeId; }

	public void setMergeId(String mergeId) { this.mergeId = mergeId; }

	public GitPullRequestMergeOptions getMergeOptions() { return mergeOptions; }

	public void setMergeOptions(GitPullRequestMergeOptions mergeOptions) { this.mergeOptions = mergeOptions; }

	public PullRequestAsyncStatus getMergeStatus() { return mergeStatus; }

	public void setMergeStatus(PullRequestAsyncStatus mergeStatus) { this.mergeStatus = mergeStatus; }

	public Integer getPullRequestId() { return pullRequestId; }

	public void setPullRequestId(Integer pullRequestId) { this.pullRequestId = pullRequestId; }

	public String getRemoteUrl() { return remoteUrl; }

	public void setRemoteUrl(String remoteUrl) { this.remoteUrl = remoteUrl; }

	public GitRepository getRepository() { return repository; }

	public void setRepository(GitRepository repository) { this.repository = repository; }

	public List<IdentityRefWithVote> getReviewers() { return reviewers; }

	public void setReviewers(List<IdentityRefWithVote> reviewers) { this.reviewers = reviewers; }

	public String getSourceRefName() { return sourceRefName; }

	public void setSourceRefName(String sourceRefName) { this.sourceRefName = sourceRefName; }

	public PullRequestStatus getStatus() { return status; }

	public void setStatus(PullRequestStatus status) { this.status = status; }

	public boolean getSupportsIterations() { return supportsIterations; }

	public void setSupportsIterations(boolean supportsIterations) { this.supportsIterations = supportsIterations; }

	public String getTargetRefName() { return targetRefName; }

	public void setTargetRefName(String targetRefName) { this.targetRefName = targetRefName; }

	public String getTitle() { return title; }

	public void setTitle(String title) { this.title = title; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public List<ResourceRef> getWorkItemRefs() { return workItemRefs; }

	public void setWorkItemRefs(List<ResourceRef> workItemRefs) { this.workItemRefs = workItemRefs; }

}
