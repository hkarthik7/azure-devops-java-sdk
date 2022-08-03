package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionDeployStep extends BaseAbstractMethod {
	/**
 	* ID of the approval or deploy step. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* The list of steps for this definition. 
	**/
	@JsonProperty("tasks")
	private List<WorkflowTask> tasks;

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public List<WorkflowTask> getTasks() { return tasks; }

	public void setTasks(List<WorkflowTask> tasks) { this.tasks = tasks; }

}
