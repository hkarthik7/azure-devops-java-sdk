package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum BuildQueryOrder {
    /**
     * Order by finish time ascending.
     */
    @JsonProperty("finishTimeAscending")
    FINISHTIMEASCENDING,
    /**
     * Order by finish time descending.
     */
    @JsonProperty("finishTimeDescending")
    FINISHTIMEDESCENDING,
    /**
     * Order by queue time ascending.
     */
    @JsonProperty("queueTimeAscending")
    QUEUETIMEASCENDING,
    /**
     * Order by queue time descending.
     */
    @JsonProperty("queueTimeDescending")
    QUEUETIMEDESCENDING,
    /**
     * Order by start time ascending.
     */
    @JsonProperty("startTimeAscending")
    STARTTIMEASCENDING,
    /**
     * Order by start time descending.
     */
    @JsonProperty("startTimeDescending")
    STARTTIMEDESCENDING

}
