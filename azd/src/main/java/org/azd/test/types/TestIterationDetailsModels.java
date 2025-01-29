package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Collection of test iteration details models.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestIterationDetailsModels extends SerializableEntity {
    @JsonProperty("value")
    private List<TestIterationDetailsModel> testIterationDetailsModels;

    public List<TestIterationDetailsModel> getTestIterationDetailsModels() {
        return testIterationDetailsModels;
    }

    public void setTestIterationDetailsModels(List<TestIterationDetailsModel> testIterationDetailsModels) {
        this.testIterationDetailsModels = testIterationDetailsModels;
    }
}
