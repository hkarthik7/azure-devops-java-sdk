package org.azd.git.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Status information about a requested fork operation.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitForkOperationStatusDetail extends BaseAbstractMethod {
	/**
 	* All valid steps for the forking process
	**/
	@JsonProperty("allSteps")
	private String[] allSteps;
	/**
 	* Index into AllSteps for the current step
	**/
	@JsonProperty("currentStep")
	private String currentStep;
	/**
 	* Error message if the operation failed.
	**/
	@JsonProperty("errorMessage")
	private String errorMessage;
}

