package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Represents the list of test session.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestSessions extends SerializableEntity {
    /**
     * Test sessions
     */
    @JsonProperty("value")
    private List<TestSession> testSessions;

    public List<TestSession> getTestSessions() {
        return testSessions;
    }

    public void setTestSessions(List<TestSession> testSessions) {
        this.testSessions = testSessions;
    }
}
