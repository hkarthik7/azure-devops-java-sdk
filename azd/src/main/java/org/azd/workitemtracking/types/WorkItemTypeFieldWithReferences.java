package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Collection of work item field references.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTypeFieldWithReferences extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<WorkItemTypeFieldWithReference> workItemTypeFieldWithReferences;

    public List<WorkItemTypeFieldWithReference> getWorkItemTypeFieldWithReferences() {
        return workItemTypeFieldWithReferences;
    }

    public void setWorkItemTypeFieldWithReferences(List<WorkItemTypeFieldWithReference> workItemTypeFieldWithReferences) {
        this.workItemTypeFieldWithReferences = workItemTypeFieldWithReferences;
    }
}
