package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDeployPhase {
    @JsonProperty("deploymentJobs")
    private List<DeploymentJob> deploymentJobs;
    @JsonProperty("errorLog")
    private String errorLog;
    @JsonProperty("manualInterventions")
    private List<ManualIntervention> manualInterventions;
    @JsonProperty("name")
    private String name;
    @JsonProperty("phaseId")
    private String phaseId;
    @JsonProperty("phaseType")
    private String phaseType;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("runPlanId")
    private String runPlanId;
    @JsonProperty("startedOn")
    private String startedOn;
    @JsonProperty("status")
    private String status;

    public List<DeploymentJob> getDeploymentJobs() {
        return deploymentJobs;
    }

    public void setDeploymentJobs(List<DeploymentJob> deploymentJobs) {
        this.deploymentJobs = deploymentJobs;
    }

    public String getErrorLog() {
        return errorLog;
    }

    public void setErrorLog(String errorLog) {
        this.errorLog = errorLog;
    }

    public List<ManualIntervention> getManualInterventions() {
        return manualInterventions;
    }

    public void setManualInterventions(List<ManualIntervention> manualInterventions) {
        this.manualInterventions = manualInterventions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
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

    public String getRunPlanId() {
        return runPlanId;
    }

    public void setRunPlanId(String runPlanId) {
        this.runPlanId = runPlanId;
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

    @Override
    public String toString() {
        return "ReleaseDeployPhase{" +
                "deploymentJobs=" + deploymentJobs +
                ", errorLog='" + errorLog + '\'' +
                ", manualInterventions=" + manualInterventions +
                ", name='" + name + '\'' +
                ", phaseId='" + phaseId + '\'' +
                ", phaseType='" + phaseType + '\'' +
                ", rank=" + rank +
                ", runPlanId='" + runPlanId + '\'' +
                ", startedOn='" + startedOn + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
