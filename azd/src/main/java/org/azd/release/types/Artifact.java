package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.Map;

/**
 * Represents binding of data source for the service endpoint request. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artifact extends BaseAbstractMethod {
	/**
 	* Gets or sets alias. 
	**/
	@JsonProperty("alias")
	private String alias;
	/**
 	* Gets or sets definition reference. e.g. {"project":{"id":"fed755ea-49c5-4399-acea-fd5b5aa90a6c","name":"myProject"},"definition":{"id":"1","name":"mybuildDefinition"},"connection":{"id":"1","name":"myConnection"}}. 
	**/
	@JsonProperty("definitionReference")
	private Map<String, ArtifactSourceReference> definitionReference;
	/**
 	* Indicates whether artifact is primary or not. 
	**/
	@JsonProperty("isPrimary")
	private boolean isPrimary;
	/**
 	* Indicates whether artifact is retained by release or not. 
	**/
	@JsonProperty("isRetained")
	private boolean isRetained;
	/**
 	* Gets or sets type. It can have value as 'Build', 'Jenkins', 'GitHub', 'Nuget', 'Team Build (external)', 'ExternalTFSBuild', 'Git', 'TFVC', 'ExternalTfsXamlBuild'. 
	**/
	@JsonProperty("type")
	private String type;

	public String getAlias() { return alias; }

	public void setAlias(String alias) { this.alias = alias; }

	public Map<String, ArtifactSourceReference> getDefinitionReference() { return definitionReference; }

	public void setDefinitionReference(Map<String, ArtifactSourceReference> definitionReference) { this.definitionReference = definitionReference; }

	public boolean getIsPrimary() { return isPrimary; }

	public void setIsPrimary(boolean isPrimary) { this.isPrimary = isPrimary; }

	public boolean getIsRetained() { return isRetained; }

	public void setIsRetained(boolean isRetained) { this.isRetained = isRetained; }

	public String getType() { return type; }

	public void setType(String type) { this.type = type; }

}
