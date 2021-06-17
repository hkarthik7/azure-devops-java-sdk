package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGate {
    @JsonProperty("tasks")
    private List<WorkflowTask> tasks;

    public List<WorkflowTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<WorkflowTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionGate{" +
                "tasks=" + tasks +
                '}';
    }
}
