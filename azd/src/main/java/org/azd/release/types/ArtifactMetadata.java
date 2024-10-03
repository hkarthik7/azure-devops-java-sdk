package org.azd.release.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Gets operation status of deployment. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtifactMetadata extends SerializableEntity {
	/**
 	* Sets alias of artifact. 
	**/
	@JsonProperty("alias")
	private String alias;
	/**
 	* Sets instance reference of artifact. e.g. for build artifact it is build number. 
	**/
	@JsonProperty("instanceReference")
	private BuildVersion instanceReference;

	public String getAlias() { return alias; }

	public void setAlias(String alias) { this.alias = alias; }

	public BuildVersion getInstanceReference() { return instanceReference; }

	public void setInstanceReference(BuildVersion instanceReference) { this.instanceReference = instanceReference; }

}