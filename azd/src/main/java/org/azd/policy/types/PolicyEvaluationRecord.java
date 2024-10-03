package org.azd.policy.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.PolicyEvaluationStatus;

/**
 * Status of the policy (Running, Approved, Failed, etc.) 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyEvaluationRecord extends SerializableEntity {
	/**
 	* Links to other related objects 
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
 	* A string which uniquely identifies the target of a policy evaluation. 
	**/
	@JsonProperty("artifactId")
	private String artifactId;
	/**
 	* Time when this policy finished evaluating on this pull request. 
	**/
	@JsonProperty("completedDate")
	private String completedDate;
	/**
 	* Contains all configuration data for the policy which is being evaluated. 
	**/
	@JsonProperty("configuration")
	private PolicyConfiguration configuration;
	/**
 	* Internal context data of this policy evaluation. 
	**/
	@JsonProperty("context")
	private Object context;
	/**
 	* Guid which uniquely identifies this evaluation record (one policy running on one pull request). 
	**/
	@JsonProperty("evaluationId")
	private String evaluationId;
	/**
 	* Time when this policy was first evaluated on this pull request. 
	**/
	@JsonProperty("startedDate")
	private String startedDate;
	/**
 	* Status of the policy (Running, Approved, Failed, etc.) 
	**/
	@JsonProperty("status")
	private PolicyEvaluationStatus status;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getArtifactId() { return artifactId; }

	public void setArtifactId(String artifactId) { this.artifactId = artifactId; }

	public String getCompletedDate() { return completedDate; }

	public void setCompletedDate(String completedDate) { this.completedDate = completedDate; }

	public PolicyConfiguration getConfiguration() { return configuration; }

	public void setConfiguration(PolicyConfiguration configuration) { this.configuration = configuration; }

	public Object getContext() { return context; }

	public void setContext(Object context) { this.context = context; }

	public String getEvaluationId() { return evaluationId; }

	public void setEvaluationId(String evaluationId) { this.evaluationId = evaluationId; }

	public String getStartedDate() { return startedDate; }

	public void setStartedDate(String startedDate) { this.startedDate = startedDate; }

	public PolicyEvaluationStatus getStatus() { return status; }

	public void setStatus(PolicyEvaluationStatus status) { this.status = status; }

}