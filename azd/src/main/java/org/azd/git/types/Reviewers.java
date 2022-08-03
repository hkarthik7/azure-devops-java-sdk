package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Identity information including a vote on a pull request.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reviewers extends BaseAbstractMethod {
    /***
     * URL to retrieve information about this identity
     */
    @JsonProperty("reviewerUrl")
    private String reviewerUrl;
    /***
     * Vote on a pull request:
     * 10 - approved 5 - approved with suggestions 0 - no vote -5 - waiting for author -10 - rejected
     */
    @JsonProperty("vote")
    private int vote;
    /***
     * Indicates if this reviewer has declined to review this pull request.
     */
    @JsonProperty("hasDeclined")
    private boolean hasDeclined;
    /***
     * Indicates if this reviewer is flagged for attention on this pull request.
     */
    @JsonProperty("isFlagged")
    private boolean isFlagged;
    /***
     * This is the non-unique display name of the graph subject.
     * To change this field, you must alter its value in the source provider.
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * This url is the full route to the source resource of this graph subject.
     */
    @JsonProperty("url")
    private String url;
    /***
     * Id of the reviewer
     */
    @JsonProperty("id")
    private String id;
    /***
     * Unique name of the reviewer
     */
    @JsonProperty("uniqueName")
    private String uniqueName;


    public String getReviewerUrl() {
        return reviewerUrl;
    }

    public void setReviewerUrl(String reviewerUrl) {
        this.reviewerUrl = reviewerUrl;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public boolean isHasDeclined() {
        return hasDeclined;
    }

    public void setHasDeclined(boolean hasDeclined) {
        this.hasDeclined = hasDeclined;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }
}
