package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Represents release Gates
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseGates {
    /***
     * Contains the gates job details of each evaluation.
     */
    @JsonProperty("deploymentJobs")
    private List<DeploymentJob> deploymentJobs;
    /***
     * ID of release gates.
     */
    @JsonProperty("id")
    private int id;
    /***
     * List of ignored gates.
     */
    @JsonProperty("ignoredGates")
    private List<IgnoredGates> ignoredGates;
    /***
     * Gates last modified time.
     */
    @JsonProperty("lastModifiedOn")
    private String lastModifiedOn;
    /***
     * Run plan ID of the gates.
     */
    @JsonProperty("runPlanId")
    private String runPlanId;
    /***
     * Gates stabilization completed date and time.
     */
    @JsonProperty("stabilizationCompletedOn")
    private String stabilizationCompletedOn;
    /***
     * Gates evaluation started time.
     */
    @JsonProperty("startedOn")
    private String startedOn;
    /***
     * Status of release gates.
     */
    @JsonProperty("status")
    private String status;
    /***
     * Date and time at which all gates executed successfully.
     */
    @JsonProperty("succeedingSince")
    private String succeedingSince;

    public List<DeploymentJob> getDeploymentJobs() {
        return deploymentJobs;
    }

    public void setDeploymentJobs(List<DeploymentJob> deploymentJobs) {
        this.deploymentJobs = deploymentJobs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<IgnoredGates> getIgnoredGates() {
        return ignoredGates;
    }

    public void setIgnoredGates(List<IgnoredGates> ignoredGates) {
        this.ignoredGates = ignoredGates;
    }

    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getRunPlanId() {
        return runPlanId;
    }

    public void setRunPlanId(String runPlanId) {
        this.runPlanId = runPlanId;
    }

    public String getStabilizationCompletedOn() {
        return stabilizationCompletedOn;
    }

    public void setStabilizationCompletedOn(String stabilizationCompletedOn) {
        this.stabilizationCompletedOn = stabilizationCompletedOn;
    }

    public String getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(String startedOn) {
        this.startedOn = startedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSucceedingSince() {
        return succeedingSince;
    }

    public void setSucceedingSince(String succeedingSince) {
        this.succeedingSince = succeedingSince;
    }

    @Override
    public String toString() {
        return "ReleaseGates{" +
                "deploymentJobs=" + deploymentJobs +
                ", id=" + id +
                ", ignoredGates=" + ignoredGates +
                ", lastModifiedOn='" + lastModifiedOn + '\'' +
                ", runPlanId='" + runPlanId + '\'' +
                ", stabilizationCompletedOn='" + stabilizationCompletedOn + '\'' +
                ", startedOn='" + startedOn + '\'' +
                ", status='" + status + '\'' +
                ", succeedingSince='" + succeedingSince + '\'' +
                '}';
    }
}
