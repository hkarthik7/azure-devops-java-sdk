package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Test run state details
 */
public enum TestRunState {
    /**
     * Run is stopped and remaining tests have been aborted
     */
    @JsonProperty("aborted")
    ABORTED,

    /**
     * All tests have completed or been skipped.
     */
    @JsonProperty("completed")
    COMPLETED,

    /**
     * Tests are running.
     */
    @JsonProperty("inProgress")
    INPROGRESS,

    /**
     * Run requires investigation because of a test point failure This is a legacy state and should not be used any more
     */
    @JsonProperty("needsInvestigation")
    NEEDSINVESTIGATION,

    /**
     * The run is still being created. No tests have started yet.
     */
    @JsonProperty("notStarted")
    NOTSTARTED,

    /**
     * Only used during an update to preserve the existing value.
     */
    @JsonProperty("unspecified")
    UNSPECIFIED,

    /**
     * Run is currently initializing This is a legacy state and should not be used any more
     */
    @JsonProperty("waiting")
    WAITING
}
