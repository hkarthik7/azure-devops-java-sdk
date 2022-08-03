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
 * The representation of a tag definition which is sent across the wire. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebApiTagDefinition extends BaseAbstractMethod {
	/**
 	* Whether or not the tag definition is active. 
	**/
	@JsonProperty("active")
	private boolean active;
	/**
 	* ID of the tag definition. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* The name of the tag definition. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Resource URL for the Tag Definition. 
	**/
	@JsonProperty("url")
	private String url;

	public Boolean getActive() { return active; }

	public void setActive(Boolean active) { this.active = active; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}
