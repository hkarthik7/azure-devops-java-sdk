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
 * Defines a page with its metedata in a wiki. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPageDetail extends BaseAbstractMethod {
	/**
 	* When present, permanent identifier for the wiki page 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Path of the wiki page. 
	**/
	@JsonProperty("path")
	private String path;
	/**
 	* Path of the wiki page. 
	**/
	@JsonProperty("viewStats")
	private List<WikiPageStat> viewStats;
	/**
	 * Specified the version string of the attachment.
	 */
	@JsonProperty("etag")
	private String eTag;

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getPath() { return path; }

	public void setPath(String path) { this.path = path; }

	public List<WikiPageStat> getViewStats() { return viewStats; }

	public void setViewStats(List<WikiPageStat> viewStats) { this.viewStats = viewStats; }

	public String geteTag() {
		return eTag;
	}

	public void seteTag(String eTag) {
		this.eTag = eTag;
	}
}