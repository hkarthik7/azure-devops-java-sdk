package org.azd.git.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * State of the status. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitPush extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Provides properties that describe a Git commit and associated metadata. 
	**/
	@JsonProperty("commits")
	private List<GitCommitRef> commits;

	@JsonProperty("date")
	private String date;

	@JsonProperty("pushId")
	private Integer pushId;

	@JsonProperty("pushedBy")
	private Author pushedBy;

	@JsonProperty("refUpdates")
	private List<GitRefUpdate> refUpdates;

	@JsonProperty("repository")
	private GitRepository repository;

	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public List<GitCommitRef> getCommits() { return commits; }

	public void setCommits(List<GitCommitRef> commits) { this.commits = commits; }

	public String getDate() { return date; }

	public void setDate(String date) { this.date = date; }

	public Integer getPushId() { return pushId; }

	public void setPushId(Integer pushId) { this.pushId = pushId; }

	public Author getPushedBy() { return pushedBy; }

	public void setPushedBy(Author pushedBy) { this.pushedBy = pushedBy; }

	public List<GitRefUpdate> getRefUpdates() { return refUpdates; }

	public void setRefUpdates(List<GitRefUpdate> refUpdates) { this.refUpdates = refUpdates; }

	public GitRepository getRepository() { return repository; }

	public void setRepository(GitRepository repository) { this.repository = repository; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}