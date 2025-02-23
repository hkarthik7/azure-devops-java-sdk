package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents a collection of test points.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestPoints extends SerializableCollectionEntity {
    /**
     * List of test points.
     */
    @JsonProperty("value")
    private List<TestPoint> testPoints;

    public List<TestPoint> getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(List<TestPoint> testPoints) {
        this.testPoints = testPoints;
    }
}
