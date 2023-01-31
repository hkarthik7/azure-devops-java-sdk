package org.azd.build.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * The type (error, warning) of the issue. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum IssueType {
	@JsonProperty("error")
	ERROR,
	@JsonProperty("warning")
	WARNING
}