package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemDeleteReferences {
    @JsonProperty("value")
    private List<WorkItemDeleteReference> workItemDeleteReferences;

    public List<WorkItemDeleteReference> getWorkItemDeleteReferences() {
        return workItemDeleteReferences;
    }

    public void setWorkItemDeleteReferences(List<WorkItemDeleteReference> workItemDeleteReferences) {
        this.workItemDeleteReferences = workItemDeleteReferences;
    }

    @Override
    public String toString() {
        return "WorkItemDeleteReferences{" +
                "workItemDeleteReferences=" + workItemDeleteReferences +
                '}';
    }
}
