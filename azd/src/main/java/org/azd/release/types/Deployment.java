package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.common.types.Author;
import org.azd.enums.DeploymentOperationStatus;
import org.azd.enums.DeploymentReason;
import org.azd.enums.DeploymentStatus;

import java.util.List;

/**
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deployment extends SerializableEntity {
	/**
 	* Gets attempt number. 
	**/
	@JsonProperty("attempt")
	private Integer attempt;
	/**
 	* Gets the date on which deployment is complete. 
	**/
	@JsonProperty("completedOn")
	private String completedOn;
	/**
 	* Gets the list of condition associated with deployment. 
	**/
	@JsonProperty("conditions")
	private List<Condition> conditions;
	/**
 	* Gets release definition environment id. 
	**/
	@JsonProperty("definitionEnvironmentId")
	private Integer definitionEnvironmentId;
	/**
 	* Gets status of the deployment. 
	**/
	@JsonProperty("deploymentStatus")
	private DeploymentStatus deploymentStatus;
	/**
 	* Gets the unique identifier for deployment. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Gets the identity who last modified the deployment. 
	**/
	@JsonProperty("lastModifiedBy")
	private Author lastModifiedBy;
	/**
 	* Gets the date on which deployment is last modified. 
	**/
	@JsonProperty("lastModifiedOn")
	private String lastModifiedOn;
	/**
 	* Gets operation status of deployment. 
	**/
	@JsonProperty("operationStatus")
	private DeploymentOperationStatus operationStatus;
	/**
 	* Gets list of PostDeployApprovals. 
	**/
	@JsonProperty("postDeployApprovals")
	private List<ReleaseApproval> postDeployApprovals;
	/**
 	* Gets list of PreDeployApprovals. 
	**/
	@JsonProperty("preDeployApprovals")
	private List<ReleaseApproval> preDeployApprovals;
	/**
 	* Gets or sets project reference. 
	**/
	@JsonProperty("projectReference")
	private ProjectReference projectReference;
	/**
 	* Gets the date on which deployment is queued. 
	**/
	@JsonProperty("queuedOn")
	private String queuedOn;
	/**
 	* Gets reason of deployment. 
	**/
	@JsonProperty("reason")
	private DeploymentReason reason;
	/**
 	* Gets the reference of release. 
	**/
	@JsonProperty("release")
	private ReleaseReference release;
	/**
 	* Gets releaseDefinitionReference which specifies the reference of the release definition to which the deployment is associated. 
	**/
	@JsonProperty("releaseDefinition")
	private ReleaseDefinitionShallowReference releaseDefinition;
	/**
 	* Gets releaseEnvironmentReference which specifies the reference of the release environment to which the deployment is associated. 
	**/
	@JsonProperty("releaseEnvironment")
	private ReleaseEnvironmentShallowReference releaseEnvironment;
	/**
 	* Gets the identity who requested. 
	**/
	@JsonProperty("requestedBy")
	private Author requestedBy;
	/**
 	* Gets the identity for whom deployment is requested. 
	**/
	@JsonProperty("requestedFor")
	private Author requestedFor;
	/**
 	* Gets the date on which deployment is scheduled. 
	**/
	@JsonProperty("scheduledDeploymentTime")
	private String scheduledDeploymentTime;
	/**
 	* Gets the date on which deployment is started. 
	**/
	@JsonProperty("startedOn")
	private String startedOn;

	public Integer getAttempt() { return attempt; }

	public void setAttempt(Integer attempt) { this.attempt = attempt; }

	public String getCompletedOn() { return completedOn; }

	public void setCompletedOn(String completedOn) { this.completedOn = completedOn; }

	public List<Condition> getConditions() { return conditions; }

	public void setConditions(List<Condition> conditions) { this.conditions = conditions; }

	public Integer getDefinitionEnvironmentId() { return definitionEnvironmentId; }

	public void setDefinitionEnvironmentId(Integer definitionEnvironmentId) { this.definitionEnvironmentId = definitionEnvironmentId; }

	public DeploymentStatus getDeploymentStatus() { return deploymentStatus; }

	public void setDeploymentStatus(DeploymentStatus deploymentStatus) { this.deploymentStatus = deploymentStatus; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public Author getLastModifiedBy() { return lastModifiedBy; }

	public void setLastModifiedBy(Author lastModifiedBy) { this.lastModifiedBy = lastModifiedBy; }

	public String getLastModifiedOn() { return lastModifiedOn; }

	public void setLastModifiedOn(String lastModifiedOn) { this.lastModifiedOn = lastModifiedOn; }

	public DeploymentOperationStatus getOperationStatus() { return operationStatus; }

	public void setOperationStatus(DeploymentOperationStatus operationStatus) { this.operationStatus = operationStatus; }

	public List<ReleaseApproval> getPostDeployApprovals() { return postDeployApprovals; }

	public void setPostDeployApprovals(List<ReleaseApproval> postDeployApprovals) { this.postDeployApprovals = postDeployApprovals; }

	public List<ReleaseApproval> getPreDeployApprovals() { return preDeployApprovals; }

	public void setPreDeployApprovals(List<ReleaseApproval> preDeployApprovals) { this.preDeployApprovals = preDeployApprovals; }

	public ProjectReference getProjectReference() { return projectReference; }

	public void setProjectReference(ProjectReference projectReference) { this.projectReference = projectReference; }

	public String getQueuedOn() { return queuedOn; }

	public void setQueuedOn(String queuedOn) { this.queuedOn = queuedOn; }

	public DeploymentReason getReason() { return reason; }

	public void setReason(DeploymentReason reason) { this.reason = reason; }

	public ReleaseReference getRelease() { return release; }

	public void setRelease(ReleaseReference release) { this.release = release; }

	public ReleaseDefinitionShallowReference getReleaseDefinition() { return releaseDefinition; }

	public void setReleaseDefinition(ReleaseDefinitionShallowReference releaseDefinition) { this.releaseDefinition = releaseDefinition; }

	public ReleaseEnvironmentShallowReference getReleaseEnvironment() { return releaseEnvironment; }

	public void setReleaseEnvironment(ReleaseEnvironmentShallowReference releaseEnvironment) { this.releaseEnvironment = releaseEnvironment; }

	public Author getRequestedBy() { return requestedBy; }

	public void setRequestedBy(Author requestedBy) { this.requestedBy = requestedBy; }

	public Author getRequestedFor() { return requestedFor; }

	public void setRequestedFor(Author requestedFor) { this.requestedFor = requestedFor; }

	public String getScheduledDeploymentTime() { return scheduledDeploymentTime; }

	public void setScheduledDeploymentTime(String scheduledDeploymentTime) { this.scheduledDeploymentTime = scheduledDeploymentTime; }

	public String getStartedOn() { return startedOn; }

	public void setStartedOn(String startedOn) { this.startedOn = startedOn; }

}