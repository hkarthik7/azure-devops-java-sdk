package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceRef {

	@JsonProperty("id")
	private String id;

	@JsonProperty("url")
	private String url;

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

	@Override
	public String toString() {
		return "ResourceRef{" +
				"id='" + id + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}