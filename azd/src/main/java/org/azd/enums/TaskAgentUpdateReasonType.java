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
public enum TaskAgentUpdateReasonType {
	@JsonProperty("downgrade")
	DOWNGRADE,
	@JsonProperty("manual")
	MANUAL,
	@JsonProperty("minAgentVersionRequired")
	MINAGENTVERSIONREQUIRED;
}