package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.DeployPhaseTypes;

import java.util.List;

/**
 * Type of release trigger. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeployPhase extends BaseAbstractMethod {
	/**
 	* Gets and sets the name of deploy phase. 
	**/
	@JsonProperty("name")
	private String name;
	/**
 	* Indicates the deploy phase type. 
	**/
	@JsonProperty("phaseType")
	private DeployPhaseTypes phaseType;
	/**
 	* Gets and sets the rank of deploy phase. 
	**/
	@JsonProperty("rank")
	private Integer rank;
	/**
 	* Gets and sets the reference name of deploy phase. 
	**/
	@JsonProperty("refName")
	private String refName;
	/**
 	* Gets and sets the workflow tasks for the deploy phase. 
	**/
	@JsonProperty("workflowTasks")
	private List<WorkflowTask> workflowTasks;
	/**
	 * Species deployment input object
	 */
	@JsonProperty("deploymentInput")
	private Object deploymentInput;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public DeployPhaseTypes getPhaseType() { return phaseType; }

	public void setPhaseType(DeployPhaseTypes phaseType) { this.phaseType = phaseType; }

	public Integer getRank() { return rank; }

	public void setRank(Integer rank) { this.rank = rank; }

	public String getRefName() { return refName; }

	public void setRefName(String refName) { this.refName = refName; }

	public List<WorkflowTask> getWorkflowTasks() { return workflowTasks; }

	public void setWorkflowTasks(List<WorkflowTask> workflowTasks) { this.workflowTasks = workflowTasks; }

	public Object getDeploymentInput() {
		return deploymentInput;
	}

	public void setDeploymentInput(Object deploymentInput) {
		this.deploymentInput = deploymentInput;
	}

}
