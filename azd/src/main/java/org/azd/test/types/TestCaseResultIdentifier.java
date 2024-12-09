package org.azd.test.types;

/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Reference to a test result.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCaseResultIdentifier extends SerializableEntity {

    /**
     * Test result ID.
     **/
    @JsonProperty("testResultId")
    private Integer testResultId;

    /**
     * Test run ID.
     **/
    @JsonProperty("testRunId")
    private Integer testRunId;

    public Integer getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(Integer testResultId) {
        this.testResultId = testResultId;
    }

    public Integer getTestRunId() {
        return testRunId;
    }

    public void setTestRunId(Integer testRunId) {
        this.testRunId = testRunId;
    }
}
