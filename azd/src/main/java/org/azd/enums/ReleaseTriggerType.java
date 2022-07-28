package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ReleaseTriggerType {
	/**
 	* Artifact based release trigger. 
	**/
	@JsonProperty("artifactSource")
	ARTIFACTSOURCE,
	/**
 	* Container image based release trigger. 
	**/
	@JsonProperty("containerImage")
	CONTAINERIMAGE,
	/**
 	* Package based release trigger. 
	**/
	@JsonProperty("package")
	PACKAGE,
	/**
 	* Pull request based release trigger. 
	**/
	@JsonProperty("pullRequest")
	PULLREQUEST,
	/**
 	* Schedule based release trigger. 
	**/
	@JsonProperty("schedule")
	SCHEDULE,
	/**
 	* Source repository based release trigger. 
	**/
	@JsonProperty("sourceRepo")
	SOURCEREPO,
	/**
 	* Release trigger type not set. 
	**/
	@JsonProperty("undefined")
	UNDEFINED;
}