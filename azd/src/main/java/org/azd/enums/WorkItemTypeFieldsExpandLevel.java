package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Expand level for the API response. Properties: to include allowedvalues, default value, isRequired etc. as a part of response; None: to skip these properties.
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum WorkItemTypeFieldsExpandLevel {
	/**
 	* Includes allowed values and dependent fields of the field. 
	**/
	@JsonProperty("all")
	ALL,
	/**
 	* Includes allowed values for the field. 
	**/
	@JsonProperty("allowedValues")
	ALLOWEDVALUES,
	/**
 	* Includes dependent fields of the field. 
	**/
	@JsonProperty("dependentFields")
	DEPENDENTFIELDS,
	/**
 	* Includes only basic properties of the field. 
	**/
	@JsonProperty("none")
	NONE
}