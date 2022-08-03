package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * Represents all the data associated with a pull request. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitCommitRef extends BaseAbstractMethod {
	/**
 	* A collection of related REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Author of the commit. 
	**/
	@JsonProperty("author")
	private GitUserDate author;
	/**
 	* Counts of the types of changes (edits, deletes, etc.) included with the commit. 
	**/
	@JsonProperty("changeCounts")
	private Object changeCounts;
	/**
 	* An enumeration of the changes included with the commit. 
	**/
	@JsonProperty("changes")
	private List<GitChange> changes;
	/**
 	* Comment or message of the commit. 
	**/
	@JsonProperty("comment")
	private String comment;
	/**
 	* Indicates if the comment is truncated from the full Git commit comment message. 
	**/
	@JsonProperty("commentTruncated")
	private boolean commentTruncated;
	/**
 	* ID (SHA-1) of the commit. 
	**/
	@JsonProperty("commitId")
	private String commitId;
	/**
 	* Committer of the commit. 
	**/
	@JsonProperty("committer")
	private GitUserDate committer;
	/**
 	* An enumeration of the parent commit IDs for this commit. 
	**/
	@JsonProperty("parents")
	private String[] parents;
	/**
 	* The push associated with this commit. 
	**/
	@JsonProperty("push")
	private GitPushRef push;
	/**
 	* Remote URL path to the commit. 
	**/
	@JsonProperty("remoteUrl")
	private String remoteUrl;
	/**
 	* A list of status metadata from services and extensions that may associate additional information to the commit. 
	**/
	@JsonProperty("statuses")
	private List<GitStatus> statuses;
	/**
 	* REST URL for this resource. 
	**/
	@JsonProperty("url")
	private String url;
	/**
 	* A list of workitems associated with this commit. 
	**/
	@JsonProperty("workItems")
	private List<ResourceRef> workItems;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public GitUserDate getAuthor() { return author; }

	public void setAuthor(GitUserDate author) { this.author = author; }

	public Object getChangeCounts() { return changeCounts; }

	public void setChangeCounts(Object changeCounts) { this.changeCounts = changeCounts; }

	public List<GitChange> getChanges() { return changes; }

	public void setChanges(List<GitChange> changes) { this.changes = changes; }

	public String getComment() { return comment; }

	public void setComment(String comment) { this.comment = comment; }

	public boolean getCommentTruncated() { return commentTruncated; }

	public void setCommentTruncated(boolean commentTruncated) { this.commentTruncated = commentTruncated; }

	public String getCommitId() { return commitId; }

	public void setCommitId(String commitId) { this.commitId = commitId; }

	public GitUserDate getCommitter() { return committer; }

	public void setCommitter(GitUserDate committer) { this.committer = committer; }

	public String[] getParents() { return parents; }

	public void setParents(String[] parents) { this.parents = parents; }

	public GitPushRef getPush() { return push; }

	public void setPush(GitPushRef push) { this.push = push; }

	public String getRemoteUrl() { return remoteUrl; }

	public void setRemoteUrl(String remoteUrl) { this.remoteUrl = remoteUrl; }

	public List<GitStatus> getStatuses() { return statuses; }

	public void setStatuses(List<GitStatus> statuses) { this.statuses = statuses; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public List<ResourceRef> getWorkItems() { return workItems; }

	public void setWorkItems(List<ResourceRef> workItems) { this.workItems = workItems; }

}
