package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGate extends SerializableEntity {
	/**
 	* Gets or sets the gates workflow. 
	**/
	@JsonProperty("tasks")
	private List<WorkflowTask> tasks;

	public List<WorkflowTask> getTasks() { return tasks; }

	public void setTasks(List<WorkflowTask> tasks) { this.tasks = tasks; }

}
