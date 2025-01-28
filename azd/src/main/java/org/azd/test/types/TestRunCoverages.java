package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestRunCoverages extends SerializableEntity {
    @JsonProperty("values")
    private List<TestRunCoverage> testRunCoverages;

    public List<TestRunCoverage> getTestRunCoverages() {
        return testRunCoverages;
    }

    public void setTestRunCoverages(List<TestRunCoverage> testRunCoverages) {
        this.testRunCoverages = testRunCoverages;
    }
}
