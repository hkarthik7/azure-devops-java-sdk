package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommit {
    @JsonProperty("_links")
    private JsonNode _links;
    @JsonProperty("author")
    private GitUserDate author;
    @JsonProperty("changeCounts")
    private JsonNode changeCounts;
    @JsonProperty("changes")
    private List<GitChange> changes;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("commentTruncated")
    private boolean commentTruncated;
    @JsonProperty("commitId")
    private String commitId;
    @JsonProperty("committer")
    private GitUserDate committer;
    @JsonProperty("parents")
    private String[] parents;
    @JsonProperty("push")
    private GitPushRef push;
    @JsonProperty("remoteUrl")
    private String remoteUrl;
    @JsonProperty("statuses")
    private List<GitStatus> statuses;
    @JsonProperty("treeId")
    private String treeId;
    @JsonProperty("url")
    private String url;
    @JsonProperty("workItems")
    private ResourceRefs workItems;

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    public GitUserDate getAuthor() {
        return author;
    }

    public void setAuthor(GitUserDate author) {
        this.author = author;
    }

    public JsonNode getChangeCounts() {
        return changeCounts;
    }

    public void setChangeCounts(JsonNode changeCounts) {
        this.changeCounts = changeCounts;
    }

    public List<GitChange> getChanges() {
        return changes;
    }

    public void setChanges(List<GitChange> changes) {
        this.changes = changes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isCommentTruncated() {
        return commentTruncated;
    }

    public void setCommentTruncated(boolean commentTruncated) {
        this.commentTruncated = commentTruncated;
    }

    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public GitUserDate getCommitter() {
        return committer;
    }

    public void setCommitter(GitUserDate committer) {
        this.committer = committer;
    }

    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
    }

    public GitPushRef getPush() {
        return push;
    }

    public void setPush(GitPushRef push) {
        this.push = push;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public List<GitStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<GitStatus> statuses) {
        this.statuses = statuses;
    }

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ResourceRefs getWorkItems() {
        return workItems;
    }

    public void setWorkItems(ResourceRefs workItems) {
        this.workItems = workItems;
    }

    @Override
    public String toString() {
        return "GitCommit{" +
                "_links=" + _links +
                ", author=" + author +
                ", changeCounts=" + changeCounts +
                ", changes=" + changes +
                ", comment='" + comment + '\'' +
                ", commentTruncated=" + commentTruncated +
                ", commitId='" + commitId + '\'' +
                ", committer=" + committer +
                ", parents=" + Arrays.toString(parents) +
                ", push=" + push +
                ", remoteUrl='" + remoteUrl + '\'' +
                ", statuses=" + statuses +
                ", treeId='" + treeId + '\'' +
                ", url='" + url + '\'' +
                ", workItems=" + workItems +
                '}';
    }
}
