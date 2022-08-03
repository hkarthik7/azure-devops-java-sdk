package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Provides properties that describe a Git commit and associated metadata.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastMergeCommit extends BaseAbstractMethod {
    /***
     * ID (SHA-1) of the commit.
     */
    @JsonProperty("commitId")
    private String commitId;
    /***
     * Author of the commit.
     */
    @JsonProperty("author")
    private Committer author;
    /***
     * Committer of the commit.
     */
    @JsonProperty("committer")
    private Committer committer;
    /***
     * Comment or message of the commit.
     */
    @JsonProperty("comment")
    private String comment;
    /***
     * REST URL for this resource.
     */
    @JsonProperty("url")
    private String url;

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public Committer getAuthor() {
        return author;
    }

    public void setAuthor(Committer author) {
        this.author = author;
    }

    public Committer getCommitter() {
        return committer;
    }

    public void setCommitter(Committer committer) {
        this.committer = committer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
