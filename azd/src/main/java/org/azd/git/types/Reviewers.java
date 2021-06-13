package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reviewers {
    @JsonProperty("reviewerUrl")
    private String reviewerUrl;
    @JsonProperty("vote")
    private int vote;
    @JsonProperty("hasDeclined")
    private boolean hasDeclined;
    @JsonProperty("isFlagged")
    private boolean isFlagged;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("id")
    private String id;
    @JsonProperty("uniqueName")
    private String uniqueName;

    @Override
    public String toString() {
        return "Reviewers{" +
                "reviewerUrl='" + reviewerUrl + '\'' +
                ", vote=" + vote +
                ", hasDeclined=" + hasDeclined +
                ", isFlagged=" + isFlagged +
                ", displayName='" + displayName + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", uniqueName='" + uniqueName + '\'' +
                '}';
    }

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
