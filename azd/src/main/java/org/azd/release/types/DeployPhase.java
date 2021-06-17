package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeployPhase {
    @JsonProperty("name")
    private String name;
    @JsonProperty("phaseType")
    private String phaseType;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("refName")
    private String refName;
    @JsonProperty("workflowTasks")
    private List<WorkflowTask> workflowTasks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(String phaseType) {
        this.phaseType = phaseType;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public List<WorkflowTask> getWorkflowTasks() {
        return workflowTasks;
    }

    public void setWorkflowTasks(List<WorkflowTask> workflowTasks) {
        this.workflowTasks = workflowTasks;
    }

    @Override
    public String toString() {
        return "DeployPhase{" +
                "name='" + name + '\'' +
                ", phaseType='" + phaseType + '\'' +
                ", rank=" + rank +
                ", refName='" + refName + '\'' +
                ", workflowTasks=" + workflowTasks +
                '}';
    }
}
