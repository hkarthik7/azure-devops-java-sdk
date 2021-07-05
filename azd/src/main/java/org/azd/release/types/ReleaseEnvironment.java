package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseEnvironment {
    @JsonProperty("conditions")
    private List<ReleaseCondition> conditions;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("definitionEnvironmentId")
    private int definitionEnvironmentId;
    @JsonProperty("deployPhasesSnapshot")
    private List<DeployPhase> deployPhasesSnapshot;
    @JsonProperty("environmentOptions")
    private EnvironmentOptions environmentOptions;
    @JsonProperty("id")
    private int id;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nextScheduledUtcTime")
    private String nextScheduledUtcTime;
    @JsonProperty("owner")
    private Author owner;
    @JsonProperty("postApprovalsSnapshot")
    private ReleaseDefinitionApprovals postApprovalsSnapshot;
    @JsonProperty("postDeployApprovals")
    private List<ReleaseApproval> postDeployApprovals;
    @JsonProperty("postDeploymentGatesSnapshot")
    private ReleaseDefinitionGatesStep postDeploymentGatesSnapshot;
    @JsonProperty("preApprovalsSnapshot")
    private ReleaseDefinitionApprovals preApprovalsSnapshot;
    @JsonProperty("preDeployApprovals")
    private List<ReleaseApproval> preDeployApprovals;
    @JsonProperty("preDeploymentGatesSnapshot")
    private ReleaseDefinitionGatesStep preDeploymentGatesSnapshot;
    @JsonProperty("processParameters")
    private JsonNode processParameters;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("release")
    private ReleaseShallowReference release;
    @JsonProperty("releaseCreatedBy")
    private Author releaseCreatedBy;
    @JsonProperty("releaseDefinition")
    private ReleaseShallowReference releaseDefinition;
    @JsonProperty("releaseId")
    private int releaseId;
    @JsonProperty("scheduledDeploymentTime")
    private String scheduledDeploymentTime;
    @JsonProperty("schedules")
    private List<ReleaseSchedule> schedules;
    @JsonProperty("status")
    private String status;
    @JsonProperty("timeToDeploy")
    private int timeToDeploy;
    @JsonProperty("triggerReason")
    private String triggerReason;
    @JsonProperty("variableGroups")
    private JsonNode variableGroups;
    @JsonProperty("variables")
    private JsonNode variables;

    public List<ReleaseCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<ReleaseCondition> conditions) {
        this.conditions = conditions;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public int getDefinitionEnvironmentId() {
        return definitionEnvironmentId;
    }

    public void setDefinitionEnvironmentId(int definitionEnvironmentId) {
        this.definitionEnvironmentId = definitionEnvironmentId;
    }

    public List<DeployPhase> getDeployPhasesSnapshot() {
        return deployPhasesSnapshot;
    }

    public void setDeployPhasesSnapshot(List<DeployPhase> deployPhasesSnapshot) {
        this.deployPhasesSnapshot = deployPhasesSnapshot;
    }

    public EnvironmentOptions getEnvironmentOptions() {
        return environmentOptions;
    }

    public void setEnvironmentOptions(EnvironmentOptions environmentOptions) {
        this.environmentOptions = environmentOptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNextScheduledUtcTime() {
        return nextScheduledUtcTime;
    }

    public void setNextScheduledUtcTime(String nextScheduledUtcTime) {
        this.nextScheduledUtcTime = nextScheduledUtcTime;
    }

    public Author getOwner() {
        return owner;
    }

    public void setOwner(Author owner) {
        this.owner = owner;
    }

    public ReleaseDefinitionApprovals getPostApprovalsSnapshot() {
        return postApprovalsSnapshot;
    }

    public void setPostApprovalsSnapshot(ReleaseDefinitionApprovals postApprovalsSnapshot) {
        this.postApprovalsSnapshot = postApprovalsSnapshot;
    }

    public List<ReleaseApproval> getPostDeployApprovals() {
        return postDeployApprovals;
    }

    public void setPostDeployApprovals(List<ReleaseApproval> postDeployApprovals) {
        this.postDeployApprovals = postDeployApprovals;
    }

    public ReleaseDefinitionGatesStep getPostDeploymentGatesSnapshot() {
        return postDeploymentGatesSnapshot;
    }

    public void setPostDeploymentGatesSnapshot(ReleaseDefinitionGatesStep postDeploymentGatesSnapshot) {
        this.postDeploymentGatesSnapshot = postDeploymentGatesSnapshot;
    }

    public ReleaseDefinitionApprovals getPreApprovalsSnapshot() {
        return preApprovalsSnapshot;
    }

    public void setPreApprovalsSnapshot(ReleaseDefinitionApprovals preApprovalsSnapshot) {
        this.preApprovalsSnapshot = preApprovalsSnapshot;
    }

    public List<ReleaseApproval> getPreDeployApprovals() {
        return preDeployApprovals;
    }

    public void setPreDeployApprovals(List<ReleaseApproval> preDeployApprovals) {
        this.preDeployApprovals = preDeployApprovals;
    }

    public ReleaseDefinitionGatesStep getPreDeploymentGatesSnapshot() {
        return preDeploymentGatesSnapshot;
    }

    public void setPreDeploymentGatesSnapshot(ReleaseDefinitionGatesStep preDeploymentGatesSnapshot) {
        this.preDeploymentGatesSnapshot = preDeploymentGatesSnapshot;
    }

    public JsonNode getProcessParameters() {
        return processParameters;
    }

    public void setProcessParameters(JsonNode processParameters) {
        this.processParameters = processParameters;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ReleaseShallowReference getRelease() {
        return release;
    }

    public void setRelease(ReleaseShallowReference release) {
        this.release = release;
    }

    public Author getReleaseCreatedBy() {
        return releaseCreatedBy;
    }

    public void setReleaseCreatedBy(Author releaseCreatedBy) {
        this.releaseCreatedBy = releaseCreatedBy;
    }

    public ReleaseShallowReference getReleaseDefinition() {
        return releaseDefinition;
    }

    public void setReleaseDefinition(ReleaseShallowReference releaseDefinition) {
        this.releaseDefinition = releaseDefinition;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public String getScheduledDeploymentTime() {
        return scheduledDeploymentTime;
    }

    public void setScheduledDeploymentTime(String scheduledDeploymentTime) {
        this.scheduledDeploymentTime = scheduledDeploymentTime;
    }

    public List<ReleaseSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ReleaseSchedule> schedules) {
        this.schedules = schedules;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTimeToDeploy() {
        return timeToDeploy;
    }

    public void setTimeToDeploy(int timeToDeploy) {
        this.timeToDeploy = timeToDeploy;
    }

    public String getTriggerReason() {
        return triggerReason;
    }

    public void setTriggerReason(String triggerReason) {
        this.triggerReason = triggerReason;
    }

    public JsonNode getVariableGroups() {
        return variableGroups;
    }

    public void setVariableGroups(JsonNode variableGroups) {
        this.variableGroups = variableGroups;
    }

    public JsonNode getVariables() {
        return variables;
    }

    public void setVariables(JsonNode variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        return "ReleaseEnvironment{" +
                "conditions=" + conditions +
                ", createdOn='" + createdOn + '\'' +
                ", definitionEnvironmentId=" + definitionEnvironmentId +
                ", deployPhasesSnapshot=" + deployPhasesSnapshot +
                ", environmentOptions=" + environmentOptions +
                ", id=" + id +
                ", modifiedOn='" + modifiedOn + '\'' +
                ", name='" + name + '\'' +
                ", nextScheduledUtcTime='" + nextScheduledUtcTime + '\'' +
                ", owner=" + owner +
                ", postApprovalsSnapshot=" + postApprovalsSnapshot +
                ", postDeployApprovals=" + postDeployApprovals +
                ", postDeploymentGatesSnapshot=" + postDeploymentGatesSnapshot +
                ", preApprovalsSnapshot=" + preApprovalsSnapshot +
                ", preDeployApprovals=" + preDeployApprovals +
                ", preDeploymentGatesSnapshot=" + preDeploymentGatesSnapshot +
                ", processParameters=" + processParameters +
                ", rank=" + rank +
                ", release=" + release +
                ", releaseCreatedBy=" + releaseCreatedBy +
                ", releaseDefinition=" + releaseDefinition +
                ", releaseId=" + releaseId +
                ", scheduledDeploymentTime='" + scheduledDeploymentTime + '\'' +
                ", schedules=" + schedules +
                ", status='" + status + '\'' +
                ", timeToDeploy=" + timeToDeploy +
                ", triggerReason='" + triggerReason + '\'' +
                ", variableGroups=" + variableGroups +
                ", variables=" + variables +
                '}';
    }
}
