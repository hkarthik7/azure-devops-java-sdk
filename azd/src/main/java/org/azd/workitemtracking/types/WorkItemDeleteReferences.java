package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Work item delete references
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemDeleteReferences extends SerializableCollectionEntity {
    /**
     * Work item delete references
     */
    @JsonProperty("value")
    private List<WorkItemDeleteReference> workItemDeleteReferences;

    public List<WorkItemDeleteReference> getWorkItemDeleteReferences() {
        return workItemDeleteReferences;
    }

    public void setWorkItemDeleteReferences(List<WorkItemDeleteReference> workItemDeleteReferences) {
        this.workItemDeleteReferences = workItemDeleteReferences;
    }

}
