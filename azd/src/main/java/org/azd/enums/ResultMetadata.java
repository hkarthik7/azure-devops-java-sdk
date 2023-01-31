package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * This class is used to provide the filters used for discovery 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ResultMetadata {
	/**
 	* Flaky metadata 
	**/
	@JsonProperty("flaky")
	FLAKY,
	/**
 	* Rerun metadata 
	**/
	@JsonProperty("rerun")
	RERUN
}