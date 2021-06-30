package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemDeleteShallowReferences {
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
