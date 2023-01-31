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
 * Test run statistics per outcome. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum RunFilter {
	/**
 	* filter for the test case sources (test containers) 
	**/
	@JsonProperty("sourceFilter")
	SOURCEFILTER,
	/**
 	* filter for the test cases 
	**/
	@JsonProperty("testCaseFilter")
	TESTCASEFILTER
}