package org.azd.distributedtask.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentUpdate extends BaseAbstractMethod {
	/**
 	* Current state of this agent update. 
	**/
	@JsonProperty("currentState")
	private String currentState;
	/**
 	* Reason for this update. 
	**/
	@JsonProperty("reason")
	private TaskAgentUpdateReason reason;
	/**
 	* Date on which this update was requested. 
	**/
	@JsonProperty("requestTime")
	private String requestTime;
	/**
 	* Identity which requested this update. 
	**/
	@JsonProperty("requestedBy")
	private Author requestedBy;
	/**
 	* Source agent version of the update. 
	**/
	@JsonProperty("sourceVersion")
	private int sourceVersion;
	/**
 	* Target agent version of the update. 
	**/
	@JsonProperty("targetVersion")
	private int targetVersion;

	public String getCurrentState() { return currentState; }

	public void setCurrentState(String currentState) { this.currentState = currentState; }

	public TaskAgentUpdateReason getReason() { return reason; }

	public void setReason(TaskAgentUpdateReason reason) { this.reason = reason; }

	public String getRequestTime() { return requestTime; }

	public void setRequestTime(String requestTime) { this.requestTime = requestTime; }

	public Author getRequestedBy() { return requestedBy; }

	public void setRequestedBy(Author requestedBy) { this.requestedBy = requestedBy; }

	public int getSourceVersion() { return sourceVersion; }

	public void setSourceVersion(int sourceVersion) { this.sourceVersion = sourceVersion; }

	public int getTargetVersion() { return targetVersion; }

	public void setTargetVersion(int targetVersion) { this.targetVersion = targetVersion; }

}
