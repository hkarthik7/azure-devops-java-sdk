package org.azd.workitemtracking.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Stores project ID and its process ID. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessMigrationResultModel extends BaseAbstractMethod {
	/**
 	* The ID of the process. 
	**/
	@JsonProperty("processId")
	private String processId;
	/**
 	* The ID of the project. 
	**/
	@JsonProperty("projectId")
	private String projectId;

	public String getProcessId() { return processId; }

	public void setProcessId(String processId) { this.processId = processId; }

	public String getProjectId() { return projectId; }

	public void setProjectId(String projectId) { this.projectId = projectId; }

}
