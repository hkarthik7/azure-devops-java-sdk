package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentGroups {
    @JsonProperty("value")
    private List<DeploymentGroup> deploymentGroups;

    @Override
    public String toString() {
        return "DeploymentGroups{" +
                "deploymentGroups=" + deploymentGroups +
                '}';
    }

    public List<DeploymentGroup> getDeploymentGroups() {
        return deploymentGroups;
    }

    public void setDeploymentGroups(List<DeploymentGroup> deploymentGroups) {
        this.deploymentGroups = deploymentGroups;
    }
}
