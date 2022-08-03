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
 * Status of release gates. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeploymentJob extends BaseAbstractMethod {
	/**
 	* Parent task of all executed tasks. 
	**/
	@JsonProperty("job")
	private ReleaseTask job;
	/**
 	* List of  executed tasks with in job. 
	**/
	@JsonProperty("tasks")
	private List<ReleaseTask> tasks;

	public ReleaseTask getJob() { return job; }

	public void setJob(ReleaseTask job) { this.job = job; }

	public List<ReleaseTask> getTasks() { return tasks; }

	public void setTasks(List<ReleaseTask> tasks) { this.tasks = tasks; }

}
