package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelineReference extends BaseAbstractMethod {
	/**
 	* Reference of the job 
	**/
	@JsonProperty("jobReference")
	private JobReference jobReference;
	/**
 	* Reference of the phase. 
	**/
	@JsonProperty("phaseReference")
	private PhaseReference phaseReference;
	/**
 	* Reference of the pipeline with which this pipeline instance is related. 
	**/
	@JsonProperty("pipelineId")
	private Integer pipelineId;
	/**
 	* Reference of the stage. 
	**/
	@JsonProperty("stageReference")
	private StageReference stageReference;

	public JobReference getJobReference() { return jobReference; }

	public void setJobReference(JobReference jobReference) { this.jobReference = jobReference; }

	public PhaseReference getPhaseReference() { return phaseReference; }

	public void setPhaseReference(PhaseReference phaseReference) { this.phaseReference = phaseReference; }

	public Integer getPipelineId() { return pipelineId; }

	public void setPipelineId(Integer pipelineId) { this.pipelineId = pipelineId; }

	public StageReference getStageReference() { return stageReference; }

	public void setStageReference(StageReference stageReference) { this.stageReference = stageReference; }

}