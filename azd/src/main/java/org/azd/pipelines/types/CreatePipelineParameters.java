package org.azd.pipelines.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Parameters to create a pipeline. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePipelineParameters {
	/**
 	* Configuration parameters of the pipeline. 
	**/
	@JsonProperty("configuration")
	public CreatePipelineConfigurationParameters configuration;
	/**
 	* Folder of the pipeline. 
	**/
	@JsonProperty("folder")
	public String folder;
	/**
 	* Name of the pipeline. 
	**/
	@JsonProperty("name")
	public String name;
}