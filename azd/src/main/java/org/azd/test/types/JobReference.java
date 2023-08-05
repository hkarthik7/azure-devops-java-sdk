package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

/**
 * Phase in pipeline 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobReference extends SerializableEntity {
	/**
 	* Attempt number of the job 
	**/
	@JsonProperty("attempt")
	private Integer attempt;
	/**
 	* Matrixing in YAML generates copies of a job with different inputs in matrix. JobName is the name of those input. Maximum supported length for name is 256 character. 
	**/
	@JsonProperty("jobName")
	private String jobName;

	public Integer getAttempt() { return attempt; }

	public void setAttempt(Integer attempt) { this.attempt = attempt; }

	public String getJobName() { return jobName; }

	public void setJobName(String jobName) { this.jobName = jobName; }

}