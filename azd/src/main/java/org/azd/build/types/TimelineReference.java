package org.azd.build.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineReference extends SerializableEntity {
	/**
 	* The change ID. 
	**/
	@JsonProperty("changeId")
	private Integer changeId;
	/**
 	* The ID of the timeline. 
	**/
	@JsonProperty("id")
	private String id;
	/**
 	* The REST URL of the timeline. 
	**/
	@JsonProperty("url")
	private String url;

	public Integer getChangeId() { return changeId; }

	public void setChangeId(Integer changeId) { this.changeId = changeId; }

	public String getId() { return id; }

	public void setId(String id) { this.id = id; }

	public String getUrl() { return url; }

	public void setUrl(String url) { this.url = url; }

}