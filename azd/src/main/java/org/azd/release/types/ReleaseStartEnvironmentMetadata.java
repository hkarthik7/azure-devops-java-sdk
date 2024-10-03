package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.Map;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseStartEnvironmentMetadata extends SerializableEntity {
	/**
 	* Sets release definition environment id. 
	**/
	@JsonProperty("definitionEnvironmentId")
	private Integer definitionEnvironmentId;
	/**
 	* Sets list of environments variables to be overridden at deployment time. 
	**/
	@JsonProperty("variables")
	private Map<String, ConfigurationVariableValue> variables;

	public Integer getDefinitionEnvironmentId() { return definitionEnvironmentId; }

	public void setDefinitionEnvironmentId(Integer definitionEnvironmentId) { this.definitionEnvironmentId = definitionEnvironmentId; }

	public Map<String, ConfigurationVariableValue> getVariables() { return variables; }

	public void setVariables(Map<String, ConfigurationVariableValue> variables) { this.variables = variables; }

}