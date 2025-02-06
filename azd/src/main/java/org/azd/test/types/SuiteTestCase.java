package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Test case for the suite.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuiteTestCase extends SerializableEntity {
    /**
     * Point Assignment for test suite's test case.
     */
    @JsonProperty("pointAssignments")
    private List<PointAssignment> pointAssignments;
    /**
     * Test case workItem reference.
     */
    @JsonProperty("testCase")
    private WorkItemReference testCase;

    public List<PointAssignment> getPointAssignments() {
        return pointAssignments;
    }

    public void setPointAssignments(List<PointAssignment> pointAssignments) {
        this.pointAssignments = pointAssignments;
    }

    public WorkItemReference getTestCase() {
        return testCase;
    }

    public void setTestCase(WorkItemReference testCase) {
        this.testCase = testCase;
    }
}
