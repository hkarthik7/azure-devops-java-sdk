package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.EnvironmentStatus;

import java.util.List;
import java.util.Map;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseEnvironment extends BaseAbstractMethod {
	/**
 	* Gets list of conditions. 
	**/
	@JsonProperty("conditions")
	private List<ReleaseCondition> conditions;
	/**
 	* Gets date on which it got created. 
	**/
	@JsonProperty("createdOn")
	private String createdOn;
	/**
 	* Gets definition environment id. 
	**/
	@JsonProperty("definitionEnvironmentId")
	private int definitionEnvironmentId;
	/**
 	* Gets list of deploy phases snapshot. 
	**/
	@JsonProperty("deployPhasesSnapshot")
	private List<DeployPhase> deployPhasesSnapshot;
	/**
 	* Gets deploy steps. 
	**/
	@JsonProperty("deploySteps")
	private List<DeploymentAttempt> deploySteps;
	/**
 	* Gets environment options. 
	**/
	@JsonProperty("environmentOptions")
	private EnvironmentOptions environmentOptions;
	/**
 	* Gets the unique identifier of this field. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* Gets date on which it got modified. 
	**/
	@JsonProperty("modifiedOn")
	private String modifiedOn;
	/**
 	* Gets name. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Gets next scheduled UTC time. 
	**/
	@JsonProperty("nextScheduledUtcTime")
	private String nextScheduledUtcTime;
	/**
 	* Gets the identity who is owner for release environment. 
	**/
	@JsonProperty("owner")
	private Author owner;
	/**
 	* Gets list of post deploy approvals snapshot. 
	**/
	@JsonProperty("postApprovalsSnapshot")
	private ReleaseDefinitionApprovals postApprovalsSnapshot;
	/**
 	* Gets list of post deploy approvals. 
	**/
	@JsonProperty("postDeployApprovals")
	private List<ReleaseApproval> postDeployApprovals;
	/**
 	* Post deployment gates snapshot data. 
	**/
	@JsonProperty("postDeploymentGatesSnapshot")
	private ReleaseDefinitionGatesStep postDeploymentGatesSnapshot;
	/**
 	* Gets list of pre deploy approvals snapshot. 
	**/
	@JsonProperty("preApprovalsSnapshot")
	private ReleaseDefinitionApprovals preApprovalsSnapshot;
	/**
 	* Gets list of pre deploy approvals. 
	**/
	@JsonProperty("preDeployApprovals")
	private List<ReleaseApproval> preDeployApprovals;
	/**
 	* Pre deployment gates snapshot data. 
	**/
	@JsonProperty("preDeploymentGatesSnapshot")
	private ReleaseDefinitionGatesStep preDeploymentGatesSnapshot;
	/**
 	* Gets process parameters. 
	**/
	@JsonProperty("processParameters")
	private ProcessParameters processParameters;
	/**
 	* Gets rank. 
	**/
	@JsonProperty("rank")
	private int rank;
	/**
 	* Gets release reference which specifies the reference of the release to which this release environment is associated. 
	**/
	@JsonProperty("release")
	private ReleaseShallowReference release;
	/**
 	* Gets the identity who created release. 
	**/
	@JsonProperty("releaseCreatedBy")
	private Author releaseCreatedBy;
	/**
 	* Gets releaseDefinitionReference which specifies the reference of the release definition to which this release environment is associated. 
	**/
	@JsonProperty("releaseDefinition")
	private ReleaseDefinitionShallowReference releaseDefinition;
	/**
 	* Gets release id. 
	**/
	@JsonProperty("releaseId")
	private int releaseId;
	/**
 	* Gets schedule deployment time of release environment. 
	**/
	@JsonProperty("scheduledDeploymentTime")
	private String scheduledDeploymentTime;
	/**
 	* Gets list of schedules. 
	**/
	@JsonProperty("schedules")
	private List<ReleaseSchedule> schedules;
	/**
 	* Gets environment status. 
	**/
	@JsonProperty("status")
	private EnvironmentStatus status;
	/**
 	* Gets time to deploy. 
	**/
	@JsonProperty("timeToDeploy")
	private int timeToDeploy;
	/**
 	* Gets trigger reason. 
	**/
	@JsonProperty("triggerReason")
	private String triggerReason;
	/**
 	* Gets the list of variable groups. 
	**/
	@JsonProperty("variableGroups")
	private List<VariableGroup> variableGroups;
	/**
 	* Gets the dictionary of variables. 
	**/
	@JsonProperty("variables")
	private Map<String, ConfigurationVariableValue> variables;

	public List<ReleaseCondition> getConditions() { return conditions; }

	public void setConditions(List<ReleaseCondition> conditions) { this.conditions = conditions; }

	public String getCreatedOn() { return createdOn; }

	public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }

	public int getDefinitionEnvironmentId() { return definitionEnvironmentId; }

	public void setDefinitionEnvironmentId(int definitionEnvironmentId) { this.definitionEnvironmentId = definitionEnvironmentId; }

	public List<DeployPhase> getDeployPhasesSnapshot() { return deployPhasesSnapshot; }

	public void setDeployPhasesSnapshot(List<DeployPhase> deployPhasesSnapshot) { this.deployPhasesSnapshot = deployPhasesSnapshot; }

	public List<DeploymentAttempt> getDeploySteps() { return deploySteps; }

	public void setDeploySteps(List<DeploymentAttempt> deploySteps) { this.deploySteps = deploySteps; }

	public EnvironmentOptions getEnvironmentOptions() { return environmentOptions; }

	public void setEnvironmentOptions(EnvironmentOptions environmentOptions) { this.environmentOptions = environmentOptions; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getModifiedOn() { return modifiedOn; }

	public void setModifiedOn(String modifiedOn) { this.modifiedOn = modifiedOn; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getNextScheduledUtcTime() { return nextScheduledUtcTime; }

	public void setNextScheduledUtcTime(String nextScheduledUtcTime) { this.nextScheduledUtcTime = nextScheduledUtcTime; }

	public Author getOwner() { return owner; }

	public void setOwner(Author owner) { this.owner = owner; }

	public ReleaseDefinitionApprovals getPostApprovalsSnapshot() { return postApprovalsSnapshot; }

	public void setPostApprovalsSnapshot(ReleaseDefinitionApprovals postApprovalsSnapshot) { this.postApprovalsSnapshot = postApprovalsSnapshot; }

	public List<ReleaseApproval> getPostDeployApprovals() { return postDeployApprovals; }

	public void setPostDeployApprovals(List<ReleaseApproval> postDeployApprovals) { this.postDeployApprovals = postDeployApprovals; }

	public ReleaseDefinitionGatesStep getPostDeploymentGatesSnapshot() { return postDeploymentGatesSnapshot; }

	public void setPostDeploymentGatesSnapshot(ReleaseDefinitionGatesStep postDeploymentGatesSnapshot) { this.postDeploymentGatesSnapshot = postDeploymentGatesSnapshot; }

	public ReleaseDefinitionApprovals getPreApprovalsSnapshot() { return preApprovalsSnapshot; }

	public void setPreApprovalsSnapshot(ReleaseDefinitionApprovals preApprovalsSnapshot) { this.preApprovalsSnapshot = preApprovalsSnapshot; }

	public List<ReleaseApproval> getPreDeployApprovals() { return preDeployApprovals; }

	public void setPreDeployApprovals(List<ReleaseApproval> preDeployApprovals) { this.preDeployApprovals = preDeployApprovals; }

	public ReleaseDefinitionGatesStep getPreDeploymentGatesSnapshot() { return preDeploymentGatesSnapshot; }

	public void setPreDeploymentGatesSnapshot(ReleaseDefinitionGatesStep preDeploymentGatesSnapshot) { this.preDeploymentGatesSnapshot = preDeploymentGatesSnapshot; }

	public ProcessParameters getProcessParameters() { return processParameters; }

	public void setProcessParameters(ProcessParameters processParameters) { this.processParameters = processParameters; }

	public int getRank() { return rank; }

	public void setRank(int rank) { this.rank = rank; }

	public ReleaseShallowReference getRelease() { return release; }

	public void setRelease(ReleaseShallowReference release) { this.release = release; }

	public Author getReleaseCreatedBy() { return releaseCreatedBy; }

	public void setReleaseCreatedBy(Author releaseCreatedBy) { this.releaseCreatedBy = releaseCreatedBy; }

	public ReleaseDefinitionShallowReference getReleaseDefinition() { return releaseDefinition; }

	public void setReleaseDefinition(ReleaseDefinitionShallowReference releaseDefinition) { this.releaseDefinition = releaseDefinition; }

	public int getReleaseId() { return releaseId; }

	public void setReleaseId(int releaseId) { this.releaseId = releaseId; }

	public String getScheduledDeploymentTime() { return scheduledDeploymentTime; }

	public void setScheduledDeploymentTime(String scheduledDeploymentTime) { this.scheduledDeploymentTime = scheduledDeploymentTime; }

	public List<ReleaseSchedule> getSchedules() { return schedules; }

	public void setSchedules(List<ReleaseSchedule> schedules) { this.schedules = schedules; }

	public EnvironmentStatus getStatus() { return status; }

	public void setStatus(EnvironmentStatus status) { this.status = status; }

	public int getTimeToDeploy() { return timeToDeploy; }

	public void setTimeToDeploy(int timeToDeploy) { this.timeToDeploy = timeToDeploy; }

	public String getTriggerReason() { return triggerReason; }

	public void setTriggerReason(String triggerReason) { this.triggerReason = triggerReason; }

	public List<VariableGroup> getVariableGroups() { return variableGroups; }

	public void setVariableGroups(List<VariableGroup> variableGroups) { this.variableGroups = variableGroups; }

	public Map<String, ConfigurationVariableValue> getVariables() { return variables; }

	public void setVariables(Map<String, ConfigurationVariableValue> variables) { this.variables = variables; }

}
