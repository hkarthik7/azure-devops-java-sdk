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

/**
 * Request contract for Wiki Page Move. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPageMove extends BaseAbstractMethod {
	/**
 	* New order of the wiki page. 
	**/
	@JsonProperty("newOrder")
	private Integer newOrder;
	/**
 	* New path of the wiki page. 
	**/
	@JsonProperty("newPath")
	private String newPath;
	/**
 	* Resultant page of this page move operation. 
	**/
	@JsonProperty("page")
	private WikiPage page;
	/**
 	* Current path of the wiki page. 
	**/
	@JsonProperty("path")
	private String path;
	/**
	 * Specified the version string of the attachment.
	 */
	@JsonProperty("etag")
	private String eTag;

	public Integer getNewOrder() { return newOrder; }

	public void setNewOrder(Integer newOrder) { this.newOrder = newOrder; }

	public String getNewPath() { return newPath; }

	public void setNewPath(String newPath) { this.newPath = newPath; }

	public WikiPage getPage() { return page; }

	public void setPage(WikiPage page) { this.page = page; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public String geteTag() {
		return eTag;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}
}