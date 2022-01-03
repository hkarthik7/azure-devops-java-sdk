package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.release.types.ProjectReference;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentGroup {
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private int id;
    @JsonProperty("machineCount")
    private int machineCount;
    @JsonProperty("machineTags")
    private String[] machineTags;
    @JsonProperty("machines")
    private List<DeploymentMachine> machines;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pool")
    private TaskAgentPoolReference pool;
    @JsonProperty("project")
    private ProjectReference project;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMachineCount() {
        return machineCount;
    }

    public void setMachineCount(int machineCount) {
        this.machineCount = machineCount;
    }

    public String[] getMachineTags() {
        return machineTags;
    }

    public void setMachineTags(String[] machineTags) {
        this.machineTags = machineTags;
    }

    public List<DeploymentMachine> getMachines() {
        return machines;
    }

    public void setMachines(List<DeploymentMachine> machines) {
        this.machines = machines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskAgentPoolReference getPool() {
        return pool;
    }

    public void setPool(TaskAgentPoolReference pool) {
        this.pool = pool;
    }

    public ProjectReference getProject() {
        return project;
    }

    public void setProject(ProjectReference project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "DeploymentGroup{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", machineCount=" + machineCount +
                ", machineTags=" + Arrays.toString(machineTags) +
                ", machines=" + machines +
                ", name='" + name + '\'' +
                ", pool=" + pool +
                ", project=" + project +
                '}';
    }
}
