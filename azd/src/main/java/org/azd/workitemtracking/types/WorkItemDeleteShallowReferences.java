package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Work item shallow references
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemDeleteShallowReferences {
    /***
     * Work item shallow references
     */
    @JsonProperty("value")
    private List<WorkItemDeleteShallowReference> workItemDeleteShallowReferences;

    public List<WorkItemDeleteShallowReference> getWorkItemDeleteShallowReferences() {
        return workItemDeleteShallowReferences;
    }

    public void setWorkItemDeleteShallowReferences(List<WorkItemDeleteShallowReference> workItemDeleteShallowReferences) {
        this.workItemDeleteShallowReferences = workItemDeleteShallowReferences;
    }

    @Override
    public String toString() {
        return "WorkItemDeleteShallowReferences{" +
                "workItemDeleteShallowReferences=" + workItemDeleteShallowReferences +
                '}';
    }
}
