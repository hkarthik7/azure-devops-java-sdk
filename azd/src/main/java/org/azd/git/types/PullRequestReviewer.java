package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Identity information including a vote on a pull request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PullRequestReviewer {
    /***
     * The descriptor is the primary way to reference the graph subject while the system is running.
     * This field will uniquely identify the same graph subject across both Accounts and Organizations.
     */
    @JsonProperty("descriptor")
    private String descriptor;
    /***
     * This is the non-unique display name of the graph subject. To change this field, you must alter its value in the source provider.
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * Indicates if this reviewer has declined to review this pull request.
     */
    @JsonProperty("hasDeclined")
    private boolean hasDeclined;
    /***
     * Id of the reviewer
     */
    @JsonProperty("id")
    private String id;
    /***
     * deleted in origin
     */
    @JsonProperty("isDeletedInOrigin")
    private boolean isDeletedInOrigin;
    /***
     * Indicates if this reviewer is flagged for attention on this pull request.
     */
    @JsonProperty("isFlagged")
    private boolean isFlagged;
    /***
     * Indicates if this is a required reviewer for this pull request.
     * Branches can have policies that require particular reviewers are required for pull requests.
     */
    @JsonProperty("isRequired")
    private boolean isRequired;
    /***
     * URL to retrieve information about this identity
     */
    @JsonProperty("reviewerUrl")
    private String reviewerUrl;
    /***
     * This url is the full route to the source resource of this graph subject.
     */
    @JsonProperty("url")
    private String url;
    /***
     * Vote on a pull request:
     * 10 - approved 5 - approved with suggestions 0 - no vote -5 - waiting for author -10 - rejected
     */
    @JsonProperty("vote")
    private int vote;
    /***
     * Groups or teams that that this reviewer contributed to.
     */
    @JsonProperty("votedFor")
    private List<PullRequestReviewer> votedFor;

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isHasDeclined() {
        return hasDeclined;
    }

    public void setHasDeclined(boolean hasDeclined) {
        this.hasDeclined = hasDeclined;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeletedInOrigin() {
        return isDeletedInOrigin;
    }

    public void setDeletedInOrigin(boolean deletedInOrigin) {
        isDeletedInOrigin = deletedInOrigin;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public String getReviewerUrl() {
        return reviewerUrl;
    }

    public void setReviewerUrl(String reviewerUrl) {
        this.reviewerUrl = reviewerUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public List<PullRequestReviewer> getVotedFor() {
        return votedFor;
    }

    public void setVotedFor(List<PullRequestReviewer> votedFor) {
        this.votedFor = votedFor;
    }

    @Override
    public String toString() {
        return "PullRequestReviewer{" +
                "descriptor='" + descriptor + '\'' +
                ", displayName='" + displayName + '\'' +
                ", hasDeclined=" + hasDeclined +
                ", id='" + id + '\'' +
                ", isDeletedInOrigin=" + isDeletedInOrigin +
                ", isFlagged=" + isFlagged +
                ", isRequired=" + isRequired +
                ", reviewerUrl='" + reviewerUrl + '\'' +
                ", url='" + url + '\'' +
                ", vote=" + vote +
                ", votedFor=" + votedFor +
                '}';
    }
}
