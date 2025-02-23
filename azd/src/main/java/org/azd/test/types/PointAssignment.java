package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Adding test cases to a suite creates one of more test points based on the default configurations and
 * testers assigned to the test suite. PointAssignment is the list of test points that were created
 * for each of the test cases that were added to the test suite.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointAssignment extends SerializableEntity {
    /**
     * Configuration that was assigned to the test case.
     */
    @JsonProperty("configuration")
    private ShallowReference configuration;
    /**
     * Tester that was assigned to the test case
     */
    @JsonProperty("tester")
    private IdentityRef tester;

    public ShallowReference getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ShallowReference configuration) {
        this.configuration = configuration;
    }

    public IdentityRef getTester() {
        return tester;
    }

    public void setTester(IdentityRef tester) {
        this.tester = tester;
    }
}
