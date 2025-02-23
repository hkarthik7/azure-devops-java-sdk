package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * List of test results filtered on the basis of GroupByValue
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResultHistoryForGroup extends SerializableEntity {
    /**
     * Display name of the group.
     */
    @JsonProperty("displayName")
    private String displayName;
    /**
     * Name or Id of the group identifier by which results are grouped together.
     */
    @JsonProperty("groupByValue")
    private String groupByValue;
    /**
     * List of results for GroupByValue
     */
    @JsonProperty("results")
    private TestCaseResults results;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGroupByValue() {
        return groupByValue;
    }

    public void setGroupByValue(String groupByValue) {
        this.groupByValue = groupByValue;
    }

    public TestCaseResults getResults() {
        return results;
    }

    public void setResults(TestCaseResults results) {
        this.results = results;
    }
}
