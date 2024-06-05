package org.azd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DistributedTaskParams {
    @JsonProperty("agentId")
    public int agentId;
    @JsonProperty("poolId")
    public int poolId;
    @JsonProperty("deploymentGroupName")
    public String deploymentGroupName;
    @JsonProperty("environmentName")
    public String environmentName;
    @JsonProperty("variableGroupName")
    public String variableGroupName;
}
