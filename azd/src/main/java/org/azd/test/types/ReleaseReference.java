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
 * ResultMetadata for the given outcome/count. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseReference extends SerializableEntity {
	/**
 	* Number of Release Attempt. 
	**/
	@JsonProperty("attempt")
	private Integer attempt;
	/**
 	* Release Creation Date(UTC). 
	**/
	@JsonProperty("creationDate")
	private String creationDate;
	/**
 	* Release definition ID. 
	**/
	@JsonProperty("definitionId")
	private Integer definitionId;
	/**
 	* Environment creation Date(UTC). 
	**/
	@JsonProperty("environmentCreationDate")
	private String environmentCreationDate;
	/**
 	* Release environment definition ID. 
	**/
	@JsonProperty("environmentDefinitionId")
	private Integer environmentDefinitionId;
	/**
 	* Release environment definition name. 
	**/
	@JsonProperty("environmentDefinitionName")
	private String environmentDefinitionName;
	/**
 	* Release environment ID. 
	**/
	@JsonProperty("environmentId")
	private Integer environmentId;
	/**
 	* Release environment name. 
	**/
	@JsonProperty("environmentName")
	private String environmentName;
	/**
 	* Release ID. 
	**/
	@JsonProperty("id")
	private Integer id;
	/**
 	* Release name. 
	**/
	@JsonProperty("name")
	private String name;

	public Integer getAttempt() { return attempt; }

	public void setAttempt(Integer attempt) { this.attempt = attempt; }

	public String getCreationDate() { return creationDate; }

	public void setCreationDate(String creationDate) { this.creationDate = creationDate; }

	public Integer getDefinitionId() { return definitionId; }

	public void setDefinitionId(Integer definitionId) { this.definitionId = definitionId; }

	public String getEnvironmentCreationDate() { return environmentCreationDate; }

	public void setEnvironmentCreationDate(String environmentCreationDate) { this.environmentCreationDate = environmentCreationDate; }

	public Integer getEnvironmentDefinitionId() { return environmentDefinitionId; }

	public void setEnvironmentDefinitionId(Integer environmentDefinitionId) { this.environmentDefinitionId = environmentDefinitionId; }

	public String getEnvironmentDefinitionName() { return environmentDefinitionName; }

	public void setEnvironmentDefinitionName(String environmentDefinitionName) { this.environmentDefinitionName = environmentDefinitionName; }

	public Integer getEnvironmentId() { return environmentId; }

	public void setEnvironmentId(Integer environmentId) { this.environmentId = environmentId; }

	public String getEnvironmentName() { return environmentName; }

	public void setEnvironmentName(String environmentName) { this.environmentName = environmentName; }

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

}