package org.azd.pipelines.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.ConfigurationType;

/**
 * Configuration parameters of the pipeline. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePipelineConfigurationParameters {
	/**
 	* Type of configuration. 
	**/
	@JsonProperty("type")
	public ConfigurationType type;
	@JsonProperty("path")
	public String yamlFilePath;
	/**
	 * Repository reference
	 */
	@JsonProperty("repository")
	public CreatePipelineRepositoryReference repository;
}