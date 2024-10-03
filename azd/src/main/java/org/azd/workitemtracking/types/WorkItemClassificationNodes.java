package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents the collection of WorkItemClassificationNode
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemClassificationNodes extends SerializableCollectionEntity {
    /**
     * Represents the collection of WorkItemClassificationNode
     */
    @JsonProperty("value")
    private List<WorkItemClassificationNode> workItemClassificationNodes;

    public List<WorkItemClassificationNode> getWorkItemClassificationNodes() {
        return workItemClassificationNodes;
    }

    public void setWorkItemClassificationNodes(List<WorkItemClassificationNode> workItemClassificationNodes) {
        this.workItemClassificationNodes = workItemClassificationNodes;
    }
}
