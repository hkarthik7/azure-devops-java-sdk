package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a reference to a timeline.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TimelineRecordState {
    @JsonProperty("completed")
    COMPLETED,
    @JsonProperty("inProgress")
    INPROGRESS,
    @JsonProperty("pending")
    PENDING,
}