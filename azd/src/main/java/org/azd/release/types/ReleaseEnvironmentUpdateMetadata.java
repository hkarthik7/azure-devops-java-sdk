package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.EnvironmentStatus;

import java.util.Map;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseEnvironmentUpdateMetadata extends SerializableEntity {
	/**
 	* Gets or sets comment. 
	**/
	@JsonProperty("comment")
	private String comment;
	/**
 	* Gets or sets scheduled deployment time. 
	**/
	@JsonProperty("scheduledDeploymentTime")
	private String scheduledDeploymentTime;
	/**
 	* Gets or sets status of environment. 
	**/
	@JsonProperty("status")
	private EnvironmentStatus status;
	/**
 	* Sets list of environment variables to be overridden at deployment time. 
	**/
	@JsonProperty("variables")
	private Map<String, ConfigurationVariableValue> variables;

	public String getComment() { return comment; }

	public void setComment(String comment) { this.comment = comment; }

	public String getScheduledDeploymentTime() { return scheduledDeploymentTime; }

	public void setScheduledDeploymentTime(String scheduledDeploymentTime) { this.scheduledDeploymentTime = scheduledDeploymentTime; }

	public EnvironmentStatus getStatus() { return status; }

	public void setStatus(EnvironmentStatus status) { this.status = status; }

	public Map<String, ConfigurationVariableValue> getVariables() { return variables; }

	public void setVariables(Map<String, ConfigurationVariableValue> variables) { this.variables = variables; }

}