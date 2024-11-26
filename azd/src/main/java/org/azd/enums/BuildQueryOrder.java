package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum BuildQueryOrder {
    /**
     * Order by finish time ascending.
     */
    @JsonProperty("finishTimeAscending")
    FINISH_TIME_ASCENDING,
    /**
     * Order by finish time descending.
     */
    @JsonProperty("finishTimeDescending")
    FINISH_TIME_DESCENDING,
    /**
     * Order by queue time ascending.
     */
    @JsonProperty("queueTimeAscending")
    QUEUE_TIME_ASCENDING,
    /**
     * Order by queue time descending.
     */
    @JsonProperty("queueTimeDescending")
    QUEUE_TIME_DESCENDING,
    /**
     * Order by start time ascending.
     */
    @JsonProperty("startTimeAscending")
    START_TIME_ASCENDING,
    /**
     * Order by start time descending.
     */
    @JsonProperty("startTimeDescending")
    START_TIME_DESCENDING

}
