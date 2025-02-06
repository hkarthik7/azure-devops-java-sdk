package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Group the result on the basis of TestResultGroupBy. This can be Branch, Environment or null(if results are fetched by BuildDefinitionId)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResultGroupBy extends SerializableEntity {
    /**
     * Group the results by branches
     */
    @JsonProperty("branch")
    private String branch;
    /**
     *
     * Group the results by environment
     */
    @JsonProperty("environment")
    private String environment;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
