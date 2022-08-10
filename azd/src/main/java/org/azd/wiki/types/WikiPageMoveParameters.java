package org.azd.wiki.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Contract encapsulating parameters for the page move operation. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPageMoveParameters extends BaseAbstractMethod {
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
 	* Current path of the wiki page. 
	**/
	@JsonProperty("path")
	private String path;

	public Integer getNewOrder() { return newOrder; }

	public void setNewOrder(Integer newOrder) { this.newOrder = newOrder; }

	public String getNewPath() { return newPath; }

	public void setNewPath(String newPath) { this.newPath = newPath; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

}