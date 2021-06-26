package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionDeployStep {
    @JsonProperty("id")
    private int id;
    @JsonProperty("task")
    private List<WorkflowTask> task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<WorkflowTask> getTask() {
        return task;
    }

    public void setTask(List<WorkflowTask> task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionDeployStep{" +
                "id=" + id +
                ", task=" + task +
                '}';
    }
}
