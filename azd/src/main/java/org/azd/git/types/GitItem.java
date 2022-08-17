package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.GitObjectType;

/**
 * State of the status. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitItem extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* SHA1 of commit item was fetched at 
	**/
	@JsonProperty("commitId")
	private String commitId;

	@JsonProperty("content")
	private String content;

	@JsonProperty("contentMetadata")
	private FileContentMetadata contentMetadata;
	/**
 	* Type of object (Commit, Tree, Blob, Tag, ...) 
	**/
	@JsonProperty("gitObjectType")
	private GitObjectType gitObjectType;

	@JsonProperty("isFolder")
	private boolean isFolder;

	@JsonProperty("isSymLink")
	private boolean isSymLink;
	/**
 	* Shallow ref to commit that last changed this item Only populated if latestProcessedChange is requested May not be accurate if latest change is not yet cached 
	**/
	@JsonProperty("latestProcessedChange")
	private GitCommitRef latestProcessedChange;
	/**
 	* Git object id 
	**/
	@JsonProperty("objectId")
	private String objectId;
	/**
 	* Git object id 
	**/
	@JsonProperty("originalObjectId")
	private String originalObjectId;

	@JsonProperty("path")
	private String path;

	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getCommitId() { return commitId; }

	public void setCommitId(String commitId) { this.commitId = commitId; }

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

	public FileContentMetadata getContentMetadata() { return contentMetadata; }

	public void setContentMetadata(FileContentMetadata contentMetadata) { this.contentMetadata = contentMetadata; }

	public GitObjectType getGitObjectType() { return gitObjectType; }

	public void setGitObjectType(GitObjectType gitObjectType) { this.gitObjectType = gitObjectType; }

	public boolean getIsFolder() { return isFolder; }

	public void setIsFolder(boolean isFolder) { this.isFolder = isFolder; }

	public boolean getIsSymLink() { return isSymLink; }

	public void setIsSymLink(boolean isSymLink) { this.isSymLink = isSymLink; }

	public GitCommitRef getLatestProcessedChange() { return latestProcessedChange; }

	public void setLatestProcessedChange(GitCommitRef latestProcessedChange) { this.latestProcessedChange = latestProcessedChange; }

	public String getObjectId() { return objectId; }

	public void setObjectId(String objectId) { this.objectId = objectId; }

	public String getOriginalObjectId() { return originalObjectId; }

	public void setOriginalObjectId(String originalObjectId) { this.originalObjectId = originalObjectId; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}