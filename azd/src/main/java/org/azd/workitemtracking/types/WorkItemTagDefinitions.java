package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents the collection of work item tag definition
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTagDefinitions extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<WorkItemTagDefinition> workItemTagDefinitions;

    public List<WorkItemTagDefinition> getWorkItemTagDefinitions() {
        return workItemTagDefinitions;
    }

    public void setWorkItemTagDefinitions(List<WorkItemTagDefinition> workItemTagDefinitions) {
        this.workItemTagDefinitions = workItemTagDefinitions;
    }
}
