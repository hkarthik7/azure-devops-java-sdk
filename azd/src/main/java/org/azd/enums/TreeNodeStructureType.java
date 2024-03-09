package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Node structure type. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum TreeNodeStructureType {
	/**
 	* Area type. 
	**/
	@JsonProperty("area")
	AREA,
	/**
 	* Iteration type. 
	**/
	@JsonProperty("iteration")
	ITERATION
}