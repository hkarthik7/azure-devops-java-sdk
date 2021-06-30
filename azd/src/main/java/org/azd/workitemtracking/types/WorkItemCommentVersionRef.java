package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemCommentVersionRef {
    @JsonProperty("commentId")
    private int commentId;
    @JsonProperty("createdInRevision")
    private int createdInRevision;
    @JsonProperty("isDeleted")
    private boolean isDeleted;
    @JsonProperty("text")
    private String text;
    @JsonProperty("url")
    private String url;
    @JsonProperty("version")
    private int version;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCreatedInRevision() {
        return createdInRevision;
    }

    public void setCreatedInRevision(int createdInRevision) {
        this.createdInRevision = createdInRevision;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "WorkItemCommentVersionRef{" +
                "commentId=" + commentId +
                ", createdInRevision=" + createdInRevision +
                ", isDeleted=" + isDeleted +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", version=" + version +
                '}';
    }
}
