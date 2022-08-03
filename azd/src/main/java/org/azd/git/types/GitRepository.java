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
 * User info and date for Git operations. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepository extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;

	@JsonProperty("defaultBranch")
	private String defaultBranch;

	@JsonProperty("id")
	private String id;
	/**
 	* True if the repository is disabled. False otherwise. 
	**/
	@JsonProperty("isDisabled")
	private boolean isDisabled;
	/**
 	* True if the repository was created as a fork. 
	**/
	@JsonProperty("isFork")
	private boolean isFork;

	@JsonProperty("name")
	private String name;

	@JsonProperty("parentRepository")
	private GitRepositoryRef parentRepository;
	/**
 	* Represents a shallow reference to a TeamProject. 
	**/
	@JsonProperty("project")
	private TeamProjectReference project;

	@JsonProperty("remoteUrl")
	private String remoteUrl;
	/**
 	* Compressed size (bytes) of the repository. 
	**/
	@JsonProperty("size")
	private Integer size;

	@JsonProperty("sshUrl")
	private String sshUrl;

	@JsonProperty("url")
	private String url;

	@JsonProperty("validRemoteUrls")
	private String[] validRemoteUrls;

	@JsonProperty("webUrl")
	private String webUrl;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getDefaultBranch() { return defaultBranch; }

	public void setDefaultBranch(String defaultBranch) { this.defaultBranch = defaultBranch; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public boolean getIsDisabled() { return isDisabled; }

	public void setIsDisabled(boolean isDisabled) { this.isDisabled = isDisabled; }

	public boolean getIsFork() { return isFork; }

	public void setIsFork(boolean isFork) { this.isFork = isFork; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public GitRepositoryRef getParentRepository() { return parentRepository; }

	public void setParentRepository(GitRepositoryRef parentRepository) { this.parentRepository = parentRepository; }

	public TeamProjectReference getProject() { return project; }

	public void setProject(TeamProjectReference project) { this.project = project; }

	public String getRemoteUrl() { return remoteUrl; }

	public void setRemoteUrl(String remoteUrl) { this.remoteUrl = remoteUrl; }

	public Integer getSize() { return size; }

	public void setSize(Integer size) { this.size = size; }

	public String getSshUrl() { return sshUrl; }

	public void setSshUrl(String sshUrl) { this.sshUrl = sshUrl; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public String[] getValidRemoteUrls() { return validRemoteUrls; }

	public void setValidRemoteUrls(String[] validRemoteUrls) { this.validRemoteUrls = validRemoteUrls; }

	public String getWebUrl() { return webUrl; }

	public void setWebUrl(String webUrl) { this.webUrl = webUrl; }

}
