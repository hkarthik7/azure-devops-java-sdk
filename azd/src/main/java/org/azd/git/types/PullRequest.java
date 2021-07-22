package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

import java.util.List;

/***
 * Represents all the data associated with a pull request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequest {
    /***
     * Links to other related objects.
     */
    @JsonProperty("_links")
    private PullRequestReferenceLinks _links;
    /***
     * A string which uniquely identifies this pull request.
     */
    @JsonProperty("artifactId")
    private String artifactId;
    /***
     * If set, auto-complete is enabled for this pull request and this is the identity that enabled it.
     */
    @JsonProperty("autoCompleteSetBy")
    private Author autoCompleteSetBy;
    /***
     * The user who closed the pull request.
     */
    @JsonProperty("closedBy")
    private Author closedBy;
    /***
     * The date when the pull request was closed (completed, abandoned, or merged externally).
     */
    @JsonProperty("closedDate")
    private String closedDate;
    /***
     * The code review ID of the pull request. Used internally.
     */
    @JsonProperty("codeReviewId")
    private int codeReviewId;
    /***
     * Repository
     */
    @JsonProperty("repository")
    private Repository repository;
    /***
     * Id of the pull request
     */
    @JsonProperty("pullRequestId")
    private int pullRequestId;
    /***
     * The status of the pull request.
     */
    @JsonProperty("status")
    private String status;
    /***
     * The identity of the user who created the pull request.
     */
    @JsonProperty("createdBy")
    private Author createdBy;
    /***
     * The date when the pull request was created.
     */
    @JsonProperty("creationDate")
    private String creationDate;
    /***
     * The title of the pull request.
     */
    @JsonProperty("title")
    private String title;
    /***
     * The description of the pull request.
     */
    @JsonProperty("description")
    private String description;
    /***
     * The name of the source branch of the pull request.
     */
    @JsonProperty("sourceRefName")
    private String sourceRefName;
    /***
     * The name of the target branch of the pull request.
     */
    @JsonProperty("targetRefName")
    private String targetRefName;
    /***
     * The current status of the pull request merge.
     */
    @JsonProperty("mergeStatus")
    private String mergeStatus;
    /***
     * Draft / WIP pull request.
     */
    @JsonProperty("isDraft")
    private boolean isDraft;
    /***
     * The ID of the job used to run the pull request merge. Used internally.
     */
    @JsonProperty("mergeId")
    private String mergeId;
    /***
     * The commit at the head of the source branch at the time of the last pull request merge.
     */
    @JsonProperty("lastMergeSourceCommit")
    private LastMergeSourceCommit lastMergeSourceCommit;
    /***
     * The commit at the head of the target branch at the time of the last pull request merge.
     */
    @JsonProperty("lastMergeTargetCommit")
    private LastMergeTargetCommit lastMergeTargetCommit;
    /***
     * The commit of the most recent pull request merge. If empty, the most recent merge is in progress or was unsuccessful.
     */
    @JsonProperty("lastMergeCommit")
    private LastMergeCommit lastMergeCommit;
    /***
     * A list of reviewers on the pull request along with the state of their votes.
     */
    @JsonProperty("reviewers")
    private List<Reviewers> reviewers;
    /***
     * Used internally.
     */
    @JsonProperty("url")
    private String url;
    /***
     * If true, this pull request supports multiple iterations.
     * Iteration support means individual pushes to the source branch of the pull request can be reviewed and comments
     * left in one iteration will be tracked across future iterations.
     */
    @JsonProperty("supportsIterations")
    private boolean supportsIterations;

    public PullRequestReferenceLinks get_links() {
        return _links;
    }

    public void set_links(PullRequestReferenceLinks _links) {
        this._links = _links;
    }

    public Author getAutoCompleteSetBy() {
        return autoCompleteSetBy;
    }

    public void setAutoCompleteSetBy(Author autoCompleteSetBy) {
        this.autoCompleteSetBy = autoCompleteSetBy;
    }

    public Author getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(Author closedBy) {
        this.closedBy = closedBy;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public int getPullRequestId() {
        return pullRequestId;
    }

    public void setPullRequestId(int pullRequestId) {
        this.pullRequestId = pullRequestId;
    }

    public int getCodeReviewId() {
        return codeReviewId;
    }

    public void setCodeReviewId(int codeReviewId) {
        this.codeReviewId = codeReviewId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Author getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Author createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceRefName() {
        return sourceRefName;
    }

    public void setSourceRefName(String sourceRefName) {
        this.sourceRefName = sourceRefName;
    }

    public String getTargetRefName() {
        return targetRefName;
    }

    public void setTargetRefName(String targetRefName) {
        this.targetRefName = targetRefName;
    }

    public String getMergeStatus() {
        return mergeStatus;
    }

    public void setMergeStatus(String mergeStatus) {
        this.mergeStatus = mergeStatus;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public String getMergeId() {
        return mergeId;
    }

    public void setMergeId(String mergeId) {
        this.mergeId = mergeId;
    }

    public LastMergeSourceCommit getLastMergeSourceCommit() {
        return lastMergeSourceCommit;
    }

    public void setLastMergeSourceCommit(LastMergeSourceCommit lastMergeSourceCommit) {
        this.lastMergeSourceCommit = lastMergeSourceCommit;
    }

    public LastMergeTargetCommit getLastMergeTargetCommit() {
        return lastMergeTargetCommit;
    }

    public void setLastMergeTargetCommit(LastMergeTargetCommit lastMergeTargetCommit) {
        this.lastMergeTargetCommit = lastMergeTargetCommit;
    }

    public LastMergeCommit getLastMergeCommit() {
        return lastMergeCommit;
    }

    public void setLastMergeCommit(LastMergeCommit lastMergeCommit) {
        this.lastMergeCommit = lastMergeCommit;
    }

    public List<Reviewers> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewers> reviewers) {
        this.reviewers = reviewers;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSupportsIterations() {
        return supportsIterations;
    }

    public void setSupportsIterations(boolean supportsIterations) {
        this.supportsIterations = supportsIterations;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    @Override
    public String toString() {
        return "PullRequest{" +
                "_links=" + _links +
                ", artifactId='" + artifactId + '\'' +
                ", autoCompleteSetBy=" + autoCompleteSetBy +
                ", closedBy=" + closedBy +
                ", closedDate='" + closedDate + '\'' +
                ", codeReviewId=" + codeReviewId +
                ", repository=" + repository +
                ", pullRequestId=" + pullRequestId +
                ", status='" + status + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sourceRefName='" + sourceRefName + '\'' +
                ", targetRefName='" + targetRefName + '\'' +
                ", mergeStatus='" + mergeStatus + '\'' +
                ", isDraft=" + isDraft +
                ", mergeId='" + mergeId + '\'' +
                ", lastMergeSourceCommit=" + lastMergeSourceCommit +
                ", lastMergeTargetCommit=" + lastMergeTargetCommit +
                ", lastMergeCommit=" + lastMergeCommit +
                ", reviewers=" + reviewers +
                ", url='" + url + '\'' +
                ", supportsIterations=" + supportsIterations +
                '}';
    }
}
