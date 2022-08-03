package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Identity information including a vote on a pull request. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepositoryRef extends BaseAbstractMethod {
	/**
 	* Team Project Collection where this Fork resides 
	**/
	@JsonProperty("collection")
	private TeamProjectCollectionReference collection;

	@JsonProperty("id")
	private String id;
	/**
 	* True if the repository was created as a fork 
	**/
	@JsonProperty("isFork")
	private boolean isFork;

	@JsonProperty("name")
	private String name;
	/**
 	* Represents a shallow reference to a TeamProject. 
	**/
	@JsonProperty("project")
	private TeamProjectReference project;

	@JsonProperty("remoteUrl")
	private String remoteUrl;

	@JsonProperty("sshUrl")
	private String sshUrl;

	@JsonProperty("url")
	private String url;

	public TeamProjectCollectionReference getCollection() { return collection; }

	public void setCollection(TeamProjectCollectionReference collection) { this.collection = collection; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public boolean getIsFork() { return isFork; }

	public void setIsFork(boolean isFork) { this.isFork = isFork; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public TeamProjectReference getProject() { return project; }

	public void setProject(TeamProjectReference project) { this.project = project; }

	public String getRemoteUrl() { return remoteUrl; }

	public void setRemoteUrl(String remoteUrl) { this.remoteUrl = remoteUrl; }

	public String getSshUrl() { return sshUrl; }

	public void setSshUrl(String sshUrl) { this.sshUrl = sshUrl; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
