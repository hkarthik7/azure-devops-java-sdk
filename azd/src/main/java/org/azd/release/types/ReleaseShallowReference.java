package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseShallowReference extends BaseAbstractMethod {
	/**
 	* Gets the links to related resources, APIs, and views for the release. 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* Gets the unique identifier of release. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Gets or sets the name of the release. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets the REST API url to access the release. 
	**/
	@JsonProperty("url")
	private String url;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
