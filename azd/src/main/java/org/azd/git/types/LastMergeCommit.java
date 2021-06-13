package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LastMergeCommit {
    @JsonProperty("commitId")
    private String commitId;
    @JsonProperty("author")
    private Committer author;
    @JsonProperty("committer")
    private Committer committer;
    @JsonProperty("comment")
    private String comment;
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

    @Override
    public String toString() {
        return "LastMergeCommit{" +
                "commitId='" + commitId + '\'' +
                ", author=" + author +
                ", committer=" + committer +
                ", comment='" + comment + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
