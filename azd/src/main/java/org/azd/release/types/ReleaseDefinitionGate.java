package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Gets or sets the gates.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGate {
    /***
     * Gets or sets the gates workflow.
     */
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
