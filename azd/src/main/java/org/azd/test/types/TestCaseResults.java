package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of test case results.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestCaseResults extends SerializableCollectionEntity {
    /**
     * List of test case results.
     */
    @JsonProperty("value")
    private List<TestCaseResult> results;

    public List<TestCaseResult> getResults() {
        return results;
    }

    public void setResults(List<TestCaseResult> results) {
        this.results = results;
    }
}
