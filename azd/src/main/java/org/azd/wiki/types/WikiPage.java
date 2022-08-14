package org.azd.wiki.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * Defines a page in a wiki. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPage extends BaseAbstractMethod {
	/**
 	* Content of the wiki page. 
	**/
	@JsonProperty("content")
	private String content;
	/**
 	* Path of the git item corresponding to the wiki page stored in the backing Git repository. 
	**/
	@JsonProperty("gitItemPath")
	private String gitItemPath;
	/**
 	* When present, permanent identifier for the wiki page 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* True if a page is non-conforming, i.e. 1) if the name doesn't match page naming standards. 2) if the page does not have a valid entry in the appropriate order file. 
	**/
	@JsonProperty("isNonConformant")
	private boolean isNonConformant;
	/**
 	* True if this page has subpages under its path. 
	**/
	@JsonProperty("isParentPage")
	private boolean isParentPage;
	/**
 	* Order of the wiki page, relative to other pages in the same hierarchy level. 
	**/
	@JsonProperty("order")
	private Integer order;
	/**
 	* Path of the wiki page. 
	**/
	@JsonProperty("path")
	private String path;
	/**
 	* Remote web url to the wiki page. 
	**/
	@JsonProperty("remoteUrl")
	private String remoteUrl;
	/**
 	* List of subpages of the current page. 
	**/
	@JsonProperty("subPages")
	private List<WikiPage> subPages;
	/**
 	* REST url for this wiki page. 
	**/
	@JsonProperty("url")
	private String url;
	/**
	 * Specified the version string of the attachment.
	 */
	@JsonProperty("etag")
	private String eTag;

	public String getContent() { return content; }

	public void setContent(String content) { this.content = content; }

	public String getGitItemPath() { return gitItemPath; }

	public void setGitItemPath(String gitItemPath) { this.gitItemPath = gitItemPath; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public boolean getIsNonConformant() { return isNonConformant; }

	public void setIsNonConformant(boolean isNonConformant) { this.isNonConformant = isNonConformant; }

	public boolean getIsParentPage() { return isParentPage; }

	public void setIsParentPage(boolean isParentPage) { this.isParentPage = isParentPage; }

	public Integer getOrder() { return order; }

	public void setOrder(Integer order) { this.order = order; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public String getRemoteUrl() { return remoteUrl; }

	public void setRemoteUrl(String remoteUrl) { this.remoteUrl = remoteUrl; }

	public List<WikiPage> getSubPages() { return subPages; }

	public void setSubPages(List<WikiPage> subPages) { this.subPages = subPages; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	public boolean isNonConformant() {
		return isNonConformant;
	}

	public void setNonConformant(boolean nonConformant) {
		isNonConformant = nonConformant;
	}

	public boolean isParentPage() {
		return isParentPage;
	}

	public void setParentPage(boolean parentPage) {
		isParentPage = parentPage;
	}

	public String geteTag() {
		return eTag;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}
}