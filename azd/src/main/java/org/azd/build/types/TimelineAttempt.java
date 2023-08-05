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
 * Represents an entry in a build's timeline. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineAttempt extends SerializableEntity {
	/**
 	* Gets or sets the attempt of the record. 
	**/
	@JsonProperty("attempt")
	private Integer attempt;
	/**
 	* Gets or sets the record identifier located within the specified timeline. 
	**/
	@JsonProperty("recordId")
	private String recordId;
	/**
 	* Gets or sets the timeline identifier which owns the record representing this attempt. 
	**/
	@JsonProperty("timelineId")
	private String timelineId;

	public Integer getAttempt() { return attempt; }

	public void setAttempt(Integer attempt) { this.attempt = attempt; }

	public String getRecordId() { return recordId; }

	public void setRecordId(String recordId) { this.recordId = recordId; }

	public String getTimelineId() { return timelineId; }

	public void setTimelineId(String timelineId) { this.timelineId = timelineId; }

}