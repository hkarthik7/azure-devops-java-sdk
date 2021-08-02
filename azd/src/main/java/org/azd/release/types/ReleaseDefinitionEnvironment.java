package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;

import java.util.Arrays;
import java.util.List;

/***
 * Release definition environment
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionEnvironment {
    /***
     * Gets or sets the BadgeUrl. BadgeUrl will be used when Badge will be enabled in Release Definition Environment.
     */
    @JsonProperty("badgeUrl")
    private String badgeUrl;
    /***
     * Gets or sets the environment conditions.
     */
    @JsonProperty("conditions")
    private List<ReleaseCondition> conditions;
    /***
     * Gets or sets the current release reference.
     */
    @JsonProperty("currentRelease")
    private ReleaseShallowReference currentRelease;
    /***
     * Gets or sets the demands.
     */
    @JsonProperty("demands")
    private List<Demand> demands;
    /***
     * Gets or sets the deploy phases of environment.
     */
    @JsonProperty("deployPhases")
    private List<DeployPhase> deployPhases;
    /***
     * Gets or sets the deploy step.
     */
    @JsonProperty("deployStep")
    private ReleaseDefinitionDeployStep deployStep;
    /***
     * Gets or sets the environment options.
     */
    @JsonProperty("environmentOptions")
    private EnvironmentOptions environmentOptions;
    /***
     * Gets or sets the triggers on environment.
     */
    @JsonProperty("environmentTriggers")
    private List<EnvironmentTrigger> environmentTriggers;
    /***
     * Gets or sets the environment execution policy.
     */
    @JsonProperty("executionPolicy")
    private EnvironmentExecutionPolicy executionPolicy;
    /***
     * Gets and sets the ID of the ReleaseDefinitionEnvironment.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Gets and sets the name of the ReleaseDefinitionEnvironment.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Gets and sets the Owner of the ReleaseDefinitionEnvironment.
     */
    @JsonProperty("owner")
    private Author owner;
    /***
     * Gets or sets the post deployment approvals.
     */
    @JsonProperty("postDeployApprovals")
    private ReleaseDefinitionApprovals postDeployApprovals;
    /***
     * Gets or sets the post deployment gates.
     */
    @JsonProperty("postDeploymentGates")
    private ReleaseDefinitionGatesStep postDeploymentGates;
    /***
     * Gets or sets the pre deployment approvals.
     */
    @JsonProperty("preDeployApprovals")
    private ReleaseDefinitionApprovals preDeployApprovals;
    /***
     * Gets or sets the pre deployment gates.
     */
    @JsonProperty("preDeploymentGates")
    private ReleaseDefinitionGatesStep preDeploymentGates;
    /***
     * Gets or sets the environment process parameters.
     */
    @JsonProperty("processParameters")
    private JsonNode processParameters;
    /***
     * Gets or sets the properties on environment.
     */
    @JsonProperty("properties")
    private JsonNode properties;
    /***
     * Gets or sets the queue ID.
     */
    @JsonProperty("queueId")
    private int queueId;
    /***
     * Gets and sets the rank of the ReleaseDefinitionEnvironment.
     */
    @JsonProperty("rank")
    private int rank;
    /***
     * Gets or sets the environment retention policy.
     */
    @JsonProperty("retentionPolicy")
    private EnvironmentRetentionPolicy retentionPolicy;
    /***
     * Gets or sets the schedules
     */
    @JsonProperty("schedules")
    private List<ReleaseSchedule> schedules;
    /***
     * Gets or sets the variable groups.
     */
    @JsonProperty("variableGroups")
    private int[] variableGroups;
    /***
     * Gets and sets the variables.
     */
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
