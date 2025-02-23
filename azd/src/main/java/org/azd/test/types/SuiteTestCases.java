package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Collection of test case for the suite.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuiteTestCases extends SerializableEntity {
    /**
     * List of suite test cases.
     */
    @JsonProperty("value")
    private List<SuiteTestCase> suiteTestCases;

    public List<SuiteTestCase> getSuiteTestCases() {
        return suiteTestCases;
    }

    public void setSuiteTestCases(List<SuiteTestCase> suiteTestCases) {
        this.suiteTestCases = suiteTestCases;
    }
}
