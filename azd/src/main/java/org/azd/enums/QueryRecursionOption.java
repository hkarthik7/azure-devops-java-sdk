package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The recursion option for use in a tree query. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum QueryRecursionOption {
	/**
 	* Returns work items that satisfy the target criteria, even if no work item satisfies the source and link criteria. 
	**/
	@JsonProperty("childFirst")
	CHILDFIRST,
	/**
 	* Returns work items that satisfy the source, even if no linked work item satisfies the target and link criteria. 
	**/
	@JsonProperty("parentFirst")
	PARENTFIRST;
}