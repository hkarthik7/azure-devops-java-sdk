package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.DeploymentOperationStatus;
import org.azd.enums.DeploymentReason;
import org.azd.enums.DeploymentStatus;

import java.util.List;

/**
 * Gets environment status. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentAttempt extends BaseAbstractMethod {
	/**
 	* Deployment attempt. 
	**/
	@JsonProperty("attempt")
	private int attempt;
	/**
 	* ID of the deployment. 
	**/
	@JsonProperty("deploymentId")
	private int deploymentId;
	/**
 	* Specifies whether deployment has started or not. 
	**/
	@JsonProperty("hasStarted")
	private boolean hasStarted;
	/**
 	* ID of deployment. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* All the issues related to the deployment. 
	**/
	@JsonProperty("issues")
	private List<Issue> issues;
	/**
 	* Identity who last modified this deployment. 
	**/
	@JsonProperty("lastModifiedBy")
	private Author lastModifiedBy;
	/**
 	* Time when this deployment last modified. 
	**/
	@JsonProperty("lastModifiedOn")
	private String lastModifiedOn;
	/**
 	* Deployment operation status. 
	**/
	@JsonProperty("operationStatus")
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
	private DeploymentOperationStatus operationStatus;
	/**
 	* Post deployment gates that executed in this deployment. 
	**/
	@JsonProperty("postDeploymentGates")
	private ReleaseGates postDeploymentGates;
	/**
 	* Pre deployment gates that executed in this deployment. 
	**/
	@JsonProperty("preDeploymentGates")
	private ReleaseGates preDeploymentGates;
	/**
 	* When this deployment queued on. 
	**/
	@JsonProperty("queuedOn")
	private String queuedOn;
	/**
 	* Reason for the deployment. 
	**/
	@JsonProperty("reason")
	private DeploymentReason reason;
	/**
 	* List of release deployphases executed in this deployment. 
	**/
	@JsonProperty("releaseDeployPhases")
	private List<ReleaseDeployPhase> releaseDeployPhases;
	/**
 	* Identity who requested this deployment. 
	**/
	@JsonProperty("requestedBy")
	private Author requestedBy;
	/**
 	* Identity for this deployment requested. 
	**/
	@JsonProperty("requestedFor")
	private Author requestedFor;
	/**
 	* status of the deployment. 
	**/
	@JsonProperty("status")
	private DeploymentStatus status;

	public int getAttempt() { return attempt; }

	public void setAttempt(int attempt) { this.attempt = attempt; }

	public int getDeploymentId() { return deploymentId; }

	public void setDeploymentId(int deploymentId) { this.deploymentId = deploymentId; }

	public boolean getHasStarted() { return hasStarted; }

	public void setHasStarted(boolean hasStarted) { this.hasStarted = hasStarted; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public List<Issue> getIssues() { return issues; }

	public void setIssues(List<Issue> issues) { this.issues = issues; }

	public Author getLastModifiedBy() { return lastModifiedBy; }

	public void setLastModifiedBy(Author lastModifiedBy) { this.lastModifiedBy = lastModifiedBy; }

	public String getLastModifiedOn() { return lastModifiedOn; }

	public void setLastModifiedOn(String lastModifiedOn) { this.lastModifiedOn = lastModifiedOn; }

	public DeploymentOperationStatus getOperationStatus() { return operationStatus; }

	public void setOperationStatus(DeploymentOperationStatus operationStatus) { this.operationStatus = operationStatus; }

	public ReleaseGates getPostDeploymentGates() { return postDeploymentGates; }

	public void setPostDeploymentGates(ReleaseGates postDeploymentGates) { this.postDeploymentGates = postDeploymentGates; }

	public ReleaseGates getPreDeploymentGates() { return preDeploymentGates; }

	public void setPreDeploymentGates(ReleaseGates preDeploymentGates) { this.preDeploymentGates = preDeploymentGates; }

	public String getQueuedOn() { return queuedOn; }

	public void setQueuedOn(String queuedOn) { this.queuedOn = queuedOn; }

	public DeploymentReason getReason() { return reason; }

	public void setReason(DeploymentReason reason) { this.reason = reason; }

	public List<ReleaseDeployPhase> getReleaseDeployPhases() { return releaseDeployPhases; }

	public void setReleaseDeployPhases(List<ReleaseDeployPhase> releaseDeployPhases) { this.releaseDeployPhases = releaseDeployPhases; }

	public Author getRequestedBy() { return requestedBy; }

	public void setRequestedBy(Author requestedBy) { this.requestedBy = requestedBy; }

	public Author getRequestedFor() { return requestedFor; }

	public void setRequestedFor(Author requestedFor) { this.requestedFor = requestedFor; }

	public DeploymentStatus getStatus() { return status; }

	public void setStatus(DeploymentStatus status) { this.status = status; }

}
