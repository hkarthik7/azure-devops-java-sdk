package org.azd.feedmanagement.types;
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
public class UpstreamStatusDetail {
	/**
 	* Provides a human-readable reason for the status of the upstream. 
	**/
	@JsonProperty("reason")
	private String reason;

	public String getReason() { return reason; }

	public void setReason(String reason) { this.reason = reason; }
}