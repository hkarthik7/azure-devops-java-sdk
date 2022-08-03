package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents the reference to a specific version of a comment on a Work Item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemCommentVersionRef extends BaseAbstractMethod {
    /***
     * The id assigned to the comment.
     */
    @JsonProperty("commentId")
    private int commentId;
    /***
     * The work item revision where this comment was originally added.
     */
    @JsonProperty("createdInRevision")
    private int createdInRevision;
    /***
     * Specifies whether comment was deleted.
     */
    @JsonProperty("isDeleted")
    private boolean isDeleted;
    /***
     * The text of the comment.
     */
    @JsonProperty("text")
    private String text;
    /***
     * Url
     */
    @JsonProperty("url")
    private String url;
    /***
     * The version number.
     */
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

}
