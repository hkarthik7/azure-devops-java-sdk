package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.GateStatus;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseGates extends BaseAbstractMethod {
	/**
 	* Contains the gates job details of each evaluation. 
	**/
	@JsonProperty("deploymentJobs")
	private List<DeploymentJob> deploymentJobs;
	/**
 	* ID of release gates. 
	**/
	@JsonProperty("id")
	private int id;
	/**
 	* List of ignored gates. 
	**/
	@JsonProperty("ignoredGates")
	private List<IgnoredGate> ignoredGates;
	/**
 	* Gates last modified time. 
	**/
	@JsonProperty("lastModifiedOn")
	private String lastModifiedOn;
	/**
 	* Run plan ID of the gates. 
	**/
	@JsonProperty("runPlanId")
	private String runPlanId;
	/**
 	* Gates stabilization completed date and time. 
	**/
	@JsonProperty("stabilizationCompletedOn")
	private String stabilizationCompletedOn;
	/**
 	* Gates evaluation started time. 
	**/
	@JsonProperty("startedOn")
	private String startedOn;
	/**
 	* Status of release gates. 
	**/
	@JsonProperty("status")
	private GateStatus status;
	/**
 	* Date and time at which all gates executed successfully. 
	**/
	@JsonProperty("succeedingSince")
	private String succeedingSince;

	public List<DeploymentJob> getDeploymentJobs() { return deploymentJobs; }

	public void setDeploymentJobs(List<DeploymentJob> deploymentJobs) { this.deploymentJobs = deploymentJobs; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public List<IgnoredGate> getIgnoredGates() { return ignoredGates; }

	public void setIgnoredGates(List<IgnoredGate> ignoredGates) { this.ignoredGates = ignoredGates; }

	public String getLastModifiedOn() { return lastModifiedOn; }

	public void setLastModifiedOn(String lastModifiedOn) { this.lastModifiedOn = lastModifiedOn; }

	public String getRunPlanId() { return runPlanId; }

	public void setRunPlanId(String runPlanId) { this.runPlanId = runPlanId; }

	public String getStabilizationCompletedOn() { return stabilizationCompletedOn; }

	public void setStabilizationCompletedOn(String stabilizationCompletedOn) { this.stabilizationCompletedOn = stabilizationCompletedOn; }

	public String getStartedOn() { return startedOn; }

	public void setStartedOn(String startedOn) { this.startedOn = startedOn; }

	public GateStatus getStatus() { return status; }

	public void setStatus(GateStatus status) { this.status = status; }

	public String getSucceedingSince() { return succeedingSince; }

	public void setSucceedingSince(String succeedingSince) { this.succeedingSince = succeedingSince; }

}
