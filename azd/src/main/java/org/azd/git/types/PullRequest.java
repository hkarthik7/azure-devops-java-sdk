package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequest {
    @JsonProperty("_links")
    private PullRequestReferenceLinks _links;
    @JsonProperty("artifactId")
    private String artifactId;
    @JsonProperty("autoCompleteSetBy")
    private Author autoCompleteSetBy;
    @JsonProperty("closedBy")
    private Author closedBy;
    @JsonProperty("closedDate")
    private String closedDate;
    @JsonProperty("codeReviewId")
    private int codeReviewId;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("pullRequestId")
    private int pullRequestId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("sourceRefName")
    private String sourceRefName;
    @JsonProperty("targetRefName")
    private String targetRefName;
    @JsonProperty("mergeStatus")
    private String mergeStatus;
    @JsonProperty("isDraft")
    private boolean isDraft;
    @JsonProperty("mergeId")
    private String mergeId;
    @JsonProperty("lastMergeSourceCommit")
    private LastMergeSourceCommit lastMergeSourceCommit;
    @JsonProperty("lastMergeTargetCommit")
    private LastMergeTargetCommit lastMergeTargetCommit;
    @JsonProperty("lastMergeCommit")
    private LastMergeCommit lastMergeCommit;
    @JsonProperty("reviewers")
    private List<Reviewers> reviewers;
    @JsonProperty("url")
    private String url;
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
