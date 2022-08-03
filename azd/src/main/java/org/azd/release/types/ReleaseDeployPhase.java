package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.DeployPhaseStatus;
import org.azd.enums.DeployPhaseTypes;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDeployPhase extends BaseAbstractMethod {
	/**
 	* Deployment jobs of the phase. 
	**/
	@JsonProperty("deploymentJobs")
	private List<DeploymentJob> deploymentJobs;
	/**
 	* Phase execution error logs. 
	**/
	@JsonProperty("errorLog")
	private String errorLog;
	/**
 	* List of manual intervention tasks execution information in phase. 
	**/
	@JsonProperty("manualInterventions")
	private List<ManualIntervention> manualInterventions;
	/**
 	* Name of the phase. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* ID of the phase. 
	**/
	@JsonProperty("phaseId")
	private String phaseId;
	/**
 	* Type of the phase. 
	**/
	@JsonProperty("phaseType")
	private DeployPhaseTypes phaseType;
	/**
 	* Rank of the phase. 
	**/
	@JsonProperty("rank")
	private int rank;
	/**
 	* Run Plan ID of the phase. 
	**/
	@JsonProperty("runPlanId")
	private String runPlanId;
	/**
 	* Phase start time. 
	**/
	@JsonProperty("startedOn")
	private String startedOn;
	/**
 	* Status of the phase. 
	**/
	@JsonProperty("status")
	private DeployPhaseStatus status;

	public List<DeploymentJob> getDeploymentJobs() { return deploymentJobs; }

	public void setDeploymentJobs(List<DeploymentJob> deploymentJobs) { this.deploymentJobs = deploymentJobs; }

	public String getErrorLog() { return errorLog; }

	public void setErrorLog(String errorLog) { this.errorLog = errorLog; }

	public List<ManualIntervention> getManualInterventions() { return manualInterventions; }

	public void setManualInterventions(List<ManualIntervention> manualInterventions) { this.manualInterventions = manualInterventions; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getPhaseId() { return phaseId; }

	public void setPhaseId(String phaseId) { this.phaseId = phaseId; }

	public DeployPhaseTypes getPhaseType() { return phaseType; }

	public void setPhaseType(DeployPhaseTypes phaseType) { this.phaseType = phaseType; }

	public int getRank() { return rank; }

	public void setRank(int rank) { this.rank = rank; }

	public String getRunPlanId() { return runPlanId; }

	public void setRunPlanId(String runPlanId) { this.runPlanId = runPlanId; }

	public String getStartedOn() { return startedOn; }

	public void setStartedOn(String startedOn) { this.startedOn = startedOn; }

	public DeployPhaseStatus getStatus() { return status; }

	public void setStatus(DeployPhaseStatus status) { this.status = status; }

}
