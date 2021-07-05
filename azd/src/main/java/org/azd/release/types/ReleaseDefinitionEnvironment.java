package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionEnvironment {
    @JsonProperty("badgeUrl")
    private String badgeUrl;
    @JsonProperty("conditions")
    private List<ReleaseCondition> conditions;
    @JsonProperty("currentRelease")
    private ReleaseShallowReference currentRelease;
    @JsonProperty("demands")
    private List<Demand> demands;
    @JsonProperty("deployPhases")
    private List<DeployPhase> deployPhases;
    @JsonProperty("deployStep")
    private ReleaseDefinitionDeployStep deployStep;
    @JsonProperty("environmentOptions")
    private EnvironmentOptions environmentOptions;
    @JsonProperty("environmentTriggers")
    private List<EnvironmentTrigger> environmentTriggers;
    @JsonProperty("executionPolicy")
    private EnvironmentExecutionPolicy executionPolicy;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Author owner;
    @JsonProperty("postDeployApprovals")
    private ReleaseDefinitionApprovals postDeployApprovals;
    @JsonProperty("postDeploymentGates")
    private ReleaseDefinitionGatesStep postDeploymentGates;
    @JsonProperty("preDeployApprovals")
    private ReleaseDefinitionApprovals preDeployApprovals;
    @JsonProperty("preDeploymentGates")
    private ReleaseDefinitionGatesStep preDeploymentGates;
    @JsonProperty("processParameters")
    private JsonNode processParameters;
    @JsonProperty("properties")
    private JsonNode properties;
    @JsonProperty("queueId")
    private int queueId;
    @JsonProperty("rank")
    private int rank;
    @JsonProperty("retentionPolicy")
    private EnvironmentRetentionPolicy retentionPolicy;
    @JsonProperty("schedules")
    private List<ReleaseSchedule> schedules;
    @JsonProperty("variableGroups")
    private int[] variableGroups;
    @JsonProperty("variables")
    private JsonNode variables;

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    public List<ReleaseCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<ReleaseCondition> conditions) {
        this.conditions = conditions;
    }

    public ReleaseShallowReference getCurrentRelease() {
        return currentRelease;
    }

    public void setCurrentRelease(ReleaseShallowReference currentRelease) {
        this.currentRelease = currentRelease;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    public List<DeployPhase> getDeployPhases() {
        return deployPhases;
    }

    public void setDeployPhases(List<DeployPhase> deployPhases) {
        this.deployPhases = deployPhases;
    }

    public ReleaseDefinitionDeployStep getDeployStep() {
        return deployStep;
    }

    public void setDeployStep(ReleaseDefinitionDeployStep deployStep) {
        this.deployStep = deployStep;
    }

    public EnvironmentOptions getEnvironmentOptions() {
        return environmentOptions;
    }

    public void setEnvironmentOptions(EnvironmentOptions environmentOptions) {
        this.environmentOptions = environmentOptions;
    }

    public List<EnvironmentTrigger> getEnvironmentTriggers() {
        return environmentTriggers;
    }

    public void setEnvironmentTriggers(List<EnvironmentTrigger> environmentTriggers) {
        this.environmentTriggers = environmentTriggers;
    }

    public EnvironmentExecutionPolicy getExecutionPolicy() {
        return executionPolicy;
    }

    public void setExecutionPolicy(EnvironmentExecutionPolicy executionPolicy) {
        this.executionPolicy = executionPolicy;
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

    public Author getOwner() {
        return owner;
    }

    public void setOwner(Author owner) {
        this.owner = owner;
    }

    public ReleaseDefinitionApprovals getPostDeployApprovals() {
        return postDeployApprovals;
    }

    public void setPostDeployApprovals(ReleaseDefinitionApprovals postDeployApprovals) {
        this.postDeployApprovals = postDeployApprovals;
    }

    public ReleaseDefinitionGatesStep getPostDeploymentGates() {
        return postDeploymentGates;
    }

    public void setPostDeploymentGates(ReleaseDefinitionGatesStep postDeploymentGates) {
        this.postDeploymentGates = postDeploymentGates;
    }

    public ReleaseDefinitionApprovals getPreDeployApprovals() {
        return preDeployApprovals;
    }

    public void setPreDeployApprovals(ReleaseDefinitionApprovals preDeployApprovals) {
        this.preDeployApprovals = preDeployApprovals;
    }

    public ReleaseDefinitionGatesStep getPreDeploymentGates() {
        return preDeploymentGates;
    }

    public void setPreDeploymentGates(ReleaseDefinitionGatesStep preDeploymentGates) {
        this.preDeploymentGates = preDeploymentGates;
    }

    public JsonNode getProcessParameters() {
        return processParameters;
    }

    public void setProcessParameters(JsonNode processParameters) {
        this.processParameters = processParameters;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public int getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = queueId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public EnvironmentRetentionPolicy getRetentionPolicy() {
        return retentionPolicy;
    }

    public void setRetentionPolicy(EnvironmentRetentionPolicy retentionPolicy) {
        this.retentionPolicy = retentionPolicy;
    }

    public List<ReleaseSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ReleaseSchedule> schedules) {
        this.schedules = schedules;
    }

    public int[] getVariableGroups() {
        return variableGroups;
    }

    public void setVariableGroups(int[] variableGroups) {
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
        return "ReleaseDefinitionEnvironment{" +
                "badgeUrl='" + badgeUrl + '\'' +
                ", conditions=" + conditions +
                ", currentRelease=" + currentRelease +
                ", demands=" + demands +
                ", deployPhases=" + deployPhases +
                ", deployStep=" + deployStep +
                ", environmentOptions=" + environmentOptions +
                ", environmentTriggers=" + environmentTriggers +
                ", executionPolicy=" + executionPolicy +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", postDeployApprovals=" + postDeployApprovals +
                ", postDeploymentGates=" + postDeploymentGates +
                ", preDeployApprovals=" + preDeployApprovals +
                ", preDeploymentGates=" + preDeploymentGates +
                ", processParameters=" + processParameters +
                ", properties=" + properties +
                ", queueId=" + queueId +
                ", rank=" + rank +
                ", retentionPolicy=" + retentionPolicy +
                ", schedules=" + schedules +
                ", variableGroups=" + Arrays.toString(variableGroups) +
                ", variables=" + variables +
                '}';
    }
}
