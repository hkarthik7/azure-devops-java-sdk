package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Logical operator separating the condition clause 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum LogicalOperation {

	@JsonProperty("and")
	AND,

	@JsonProperty("none")
	NONE,

	@JsonProperty("or")
	OR;
}