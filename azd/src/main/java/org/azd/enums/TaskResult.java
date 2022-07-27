package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum TaskResult {
	@JsonProperty("abandoned")
	ABANDONED,
	@JsonProperty("canceled")
	CANCELED,
	@JsonProperty("failed")
	FAILED,
	@JsonProperty("skipped")
	SKIPPED,
	@JsonProperty("succeeded")
	SUCCEEDED,
	@JsonProperty("succeededWithIssues")
	succeededwithissues;
}