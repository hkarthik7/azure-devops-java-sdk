package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * A reference to an agent.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentReference {
    /***
     * This agent's access point.
     */
    @JsonProperty("accessPoint")
    private String accessPoint;
    /***
     * Whether or not this agent should run jobs.
     */
    @JsonProperty("enabled")
    private boolean enabled;
    /***
     * Identifier of the agent.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Name of the agent.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Agent OS.
     */
    @JsonProperty("osDescription")
    private String osDescription;
    /***
     * Provisioning state of this agent.
     */
    @JsonProperty("provisioningState")
    private String provisioningState;
    /***
     * Whether or not the agent is online.
     */
    @JsonProperty("status")
    private String status;
    /***
     * Agent version.
     */
    @JsonProperty("version")
    private String version;

    public String getAccessPoint() {
        return accessPoint;
    }

    public void setAccessPoint(String accessPoint) {
        this.accessPoint = accessPoint;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsDescription() {
        return osDescription;
    }

    public void setOsDescription(String osDescription) {
        this.osDescription = osDescription;
    }

    public String getProvisioningState() {
        return provisioningState;
    }

    public void setProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TaskAgentReference{" +
                "accessPoint='" + accessPoint + '\'' +
                ", enabled=" + enabled +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", osDescription='" + osDescription + '\'' +
                ", provisioningState='" + provisioningState + '\'' +
                ", status='" + status + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
