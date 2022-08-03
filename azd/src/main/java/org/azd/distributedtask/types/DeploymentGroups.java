package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * List of deployment group
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentGroups extends BaseAbstractMethod {
    /***
     * List of deployment group
     */
    @JsonProperty("value")
    private List<DeploymentGroup> deploymentGroups;


    public List<DeploymentGroup> getDeploymentGroups() {
        return deploymentGroups;
    }

    public void setDeploymentGroups(List<DeploymentGroup> deploymentGroups) {
        this.deploymentGroups = deploymentGroups;
    }
}
