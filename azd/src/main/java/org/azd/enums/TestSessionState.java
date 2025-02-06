package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * State of the test session
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TestSessionState {

    /**
     * The session has completed.
     */
    @JsonProperty("completed")
    COMPLETED,

    /**
     * This is required for Feedback session which are declined
     */
    @JsonProperty("declined")
    DECLINED,

    /**
     * The session is running.
     */
    @JsonProperty("inProgress")
    IN_PROGRESS,

    /**
     * The session is still being created.
     */
    @JsonProperty("notStarted")
    NOT_STARTED,

    /**
     * The session has paused.
     */
    @JsonProperty("paused")
    PAUSED,

    /**
     * Only used during an update to preserve the existing value.
     */
    @JsonProperty("unspecified")
    UNSPECIFIED,
}
