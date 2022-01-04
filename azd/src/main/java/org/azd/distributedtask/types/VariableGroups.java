package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Container of Variable groups
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroups {
    /**
     * Container of Variable groups
     */
    @JsonProperty("value")
    private List<VariableGroup> variableGroups;

    public List<VariableGroup> getVariableGroups() {
        return variableGroups;
    }

    public void setVariableGroups(List<VariableGroup> variableGroups) {
        this.variableGroups = variableGroups;
    }

    @Override
    public String toString() {
        return "VariableGroups{" +
                "variableGroups=" + variableGroups +
                '}';
    }
}
