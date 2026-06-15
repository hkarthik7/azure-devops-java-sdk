package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Represents Work item type categories collection.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTypeCategories extends SerializableEntity {
    @JsonProperty("count")
    private int count;
    @JsonProperty("value")
    private List<WorkItemTypeCategory> workItemTypeCategories;

    public List<WorkItemTypeCategory> getWorkItemTypeCategories() {
        return workItemTypeCategories;
    }

    public void setWorkItemTypeCategories(List<WorkItemTypeCategory> workItemTypeCategories) {
        this.workItemTypeCategories = workItemTypeCategories;
    }
}
