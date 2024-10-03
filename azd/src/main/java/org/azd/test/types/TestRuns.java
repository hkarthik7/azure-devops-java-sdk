package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents an array of test run
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestRuns extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<TestRun> testRuns;

    public List<TestRun> getTestRuns() {
        return testRuns;
    }

    public void setTestRuns(List<TestRun> testRuns) {
        this.testRuns = testRuns;
    }
}
