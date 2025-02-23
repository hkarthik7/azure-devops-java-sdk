package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Filter class for test point.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointsFilter extends SerializableEntity {
    /**
     * List of Configurations for filtering.
     */
    @JsonProperty("configurationNames")
    private String[] configurationNames;
    /**
     * List of Configurations for filtering.
     */
    @JsonProperty("testcaseIds")
    private Integer[] testcaseIds;
    /**
     * List of tester for filtering.
     */
    @JsonProperty("testers")
    private List<IdentityRef> testers;

    public String[] getConfigurationNames() {
        return configurationNames;
    }

    public void setConfigurationNames(String[] configurationNames) {
        this.configurationNames = configurationNames;
    }

    public Integer[] getTestcaseIds() {
        return testcaseIds;
    }

    public void setTestcaseIds(Integer[] testcaseIds) {
        this.testcaseIds = testcaseIds;
    }

    public List<IdentityRef> getTesters() {
        return testers;
    }

    public void setTesters(List<IdentityRef> testers) {
        this.testers = testers;
    }
}
