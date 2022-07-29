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
public enum ReleaseDefinitionSource {
	/**
 	* Indicates ReleaseDefinition created from Ibiza. 
	**/
	@JsonProperty("ibiza")
	IBIZA,
	/**
 	* Indicates ReleaseDefinition created from PortalExtension API. 
	**/
	@JsonProperty("portalExtensionApi")
	PORTALEXTENSIONAPI,
	/**
 	* Indicates ReleaseDefinition created using REST API. 
	**/
	@JsonProperty("restApi")
	RESTAPI,
	/**
 	* Indicates ReleaseDefinition source not defined. 
	**/
	@JsonProperty("undefined")
	UNDEFINED,
	/**
 	* Indicates ReleaseDefinition created using UI. 
	**/
	@JsonProperty("userInterface")
	USERINTERFACE;
}