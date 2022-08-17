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
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitBlobRef extends BaseAbstractMethod {
	/**
 	* The class to represent a collection of REST reference links. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* SHA1 hash of git object 
	**/
	@JsonProperty("objectId")
	private String objectId;
	/**
 	* Size of blob content (in bytes) 
	**/
	@JsonProperty("size")
	private Integer size;

	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getObjectId() { return objectId; }

	public void setObjectId(String objectId) { this.objectId = objectId; }

	public Integer getSize() { return size; }

	public void setSize(Integer size) { this.size = size; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}