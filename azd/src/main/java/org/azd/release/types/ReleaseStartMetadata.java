package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.ReleaseReason;

import java.util.List;
import java.util.Map;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseStartMetadata extends SerializableEntity {
	/**
 	* Sets list of artifact to create a release. 
	**/
	@JsonProperty("artifacts")
	private List<ArtifactMetadata> artifacts;
	/**
 	* Sets definition Id to create a release. 
	**/
	@JsonProperty("definitionId")
	private Integer definitionId;
	/**
 	* Sets description to create a release. 
	**/
	@JsonProperty("description")
	private String description;
	/**
 	* Sets list of environments meta data. 
	**/
	@JsonProperty("environmentsMetadata")
	private List<ReleaseStartEnvironmentMetadata> environmentsMetadata;
	/**
 	* Sets 'true' to create release in draft mode, 'false' otherwise. 
	**/
	@JsonProperty("isDraft")
	private boolean isDraft;
	/**
 	* Sets list of environments to manual as condition. 
	**/
	@JsonProperty("manualEnvironments")
	private String[] manualEnvironments;
	/**
 	* The class represents a property bag as a collection of key-value pairs. Values of all primitive types (any type with a TypeCode != TypeCode.Object) except for DBNull are accepted. Values of type Byte[], Int32, Double, DateType and String preserve their type, other primitives are retuned as a String. Byte[] expected as base64 encoded string. 
	**/
	@JsonProperty("properties")
	private PropertiesCollection properties;
	/**
 	* Sets reason to create a release. 
	**/
	@JsonProperty("reason")
	private ReleaseReason reason;
	/**
 	* Sets list of release variables to be overridden at deployment time. 
	**/
	@JsonProperty("variables")
	private Map<String, ConfigurationVariableValue> variables;

	public List<ArtifactMetadata> getArtifacts() { return artifacts; }

	public void setArtifacts(List<ArtifactMetadata> artifacts) { this.artifacts = artifacts; }

	public Integer getDefinitionId() { return definitionId; }

	public void setDefinitionId(Integer definitionId) { this.definitionId = definitionId; }

	public String getDescription() { return description; }

	public void setDescription(String description) { this.description = description; }

	public List<ReleaseStartEnvironmentMetadata> getEnvironmentsMetadata() { return environmentsMetadata; }

	public void setEnvironmentsMetadata(List<ReleaseStartEnvironmentMetadata> environmentsMetadata) { this.environmentsMetadata = environmentsMetadata; }

	public boolean getIsDraft() { return isDraft; }

	public void setIsDraft(boolean isDraft) { this.isDraft = isDraft; }

	public String[] getManualEnvironments() { return manualEnvironments; }

	public void setManualEnvironments(String[] manualEnvironments) { this.manualEnvironments = manualEnvironments; }

	public PropertiesCollection getProperties() { return properties; }

	public void setProperties(PropertiesCollection properties) { this.properties = properties; }

	public ReleaseReason getReason() { return reason; }

	public void setReason(ReleaseReason reason) { this.reason = reason; }

	public Map<String, ConfigurationVariableValue> getVariables() { return variables; }

	public void setVariables(Map<String, ConfigurationVariableValue> variables) { this.variables = variables; }

}