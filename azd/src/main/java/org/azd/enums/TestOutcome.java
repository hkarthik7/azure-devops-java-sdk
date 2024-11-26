package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Test run details.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TestOutcome {
    /**
     * Test was aborted. This was not caused by a user gesture, but rather by a framework decision.
     **/
    @JsonProperty("aborted")
    ABORTED,
    /**
     * Test had it chance for been executed but was not, as ITestElement.IsRunnable == false.
     **/
    @JsonProperty("blocked")
    BLOCKED,
    /**
     * There was a system error while we were trying to execute a test.
     **/
    @JsonProperty("error")
    ERROR,
    /**
     * Test was executed, but there were issues. Issues may involve exceptions or failed assertions.
     **/
    @JsonProperty("failed")
    FAILED,
    /**
     * Test is currently executing. Added this for TCM charts
     **/
    @JsonProperty("inProgress")
    INPROGRESS,
    /**
     * Test has completed, but we can't say if it passed or failed. May be used for aborted tests...
     **/
    @JsonProperty("inconclusive")
    INCONCLUSIVE,
    /**
     * Test has not been completed, or the test type does not report pass/failure.
     **/
    @JsonProperty("none")
    NONE,
    /**
     * Test is Not Applicable for execution.
     **/
    @JsonProperty("notApplicable")
    NOTAPPLICABLE,
    /**
     * Test was not executed. This was caused by a user gesture - e.g. user hit stop button.
     **/
    @JsonProperty("notExecuted")
    NOTEXECUTED,
    /**
     * Test is not impacted. Added fot TIA.
     **/
    @JsonProperty("notImpacted")
    NOTIMPACTED,
    /**
     * Test was executed w/o any issues.
     **/
    @JsonProperty("passed")
    PASSED,
    /**
     * Test is paused.
     **/
    @JsonProperty("paused")
    PAUSED,
    /**
     * The test timed out
     **/
    @JsonProperty("timeout")
    TIMEOUT,
    /**
     * Only used during an update to preserve the existing value.
     **/
    @JsonProperty("unspecified")
    UNSPECIFIED,
    /**
     * To be used by Run level results. This is not a failure.
     **/
    @JsonProperty("warning")
    WARNING
}