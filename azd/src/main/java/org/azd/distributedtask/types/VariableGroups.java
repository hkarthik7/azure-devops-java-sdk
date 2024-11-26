package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Container of Variable groups
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroups extends SerializableCollectionEntity {
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

}
