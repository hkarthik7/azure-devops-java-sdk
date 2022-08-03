package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.release.types.ProjectReference;

import java.util.List;

/***
 * Deployment group.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentGroup extends BaseAbstractMethod {
    /***
     * Description of the deployment group.
     */
    @JsonProperty("description")
    private String description;
    /***
     * Deployment group identifier.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Number of deployment targets in the deployment group.
     */
    @JsonProperty("machineCount")
    private int machineCount;
    /***
     * List of unique tags across all deployment targets in the deployment group.
     */
    @JsonProperty("machineTags")
    private String[] machineTags;
    /***
     * List of deployment targets in the deployment group.
     */
    @JsonProperty("machines")
    private List<DeploymentMachine> machines;
    /***
     * Name of the deployment group.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Deployment pool in which deployment agents are registered.
     */
    @JsonProperty("pool")
    private TaskAgentPoolReference pool;
    /***
     * Project to which the deployment group belongs.
     */
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

}
