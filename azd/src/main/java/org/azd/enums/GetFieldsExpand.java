package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Use ExtensionFields to include extension fields, otherwise exclude them. Unless the feature flag for this parameter is enabled, extension fields are always included. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GetFieldsExpand {
	/**
 	* Adds extension fields to the response. 
	**/
	@JsonProperty("extensionFields")
	EXTENSIONFIELDS,
	/**
 	* Includes fields that have been deleted. 
	**/
	@JsonProperty("includeDeleted")
	INCLUDEDELETED,
	/**
 	* Default behavior. 
	**/
	@JsonProperty("none")
	NONE;
}