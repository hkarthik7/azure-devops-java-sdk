package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Pipeline reference 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhaseReference extends BaseAbstractMethod {
	/**
 	* Attempt number of the phase 
	**/
	@JsonProperty("attempt")
	private Integer attempt;
	/**
 	* Name of the phase. Maximum supported length for name is 256 character. 
	**/
	@JsonProperty("phaseName")
	private String phaseName;

	public Integer getAttempt() { return attempt; }

	public void setAttempt(Integer attempt) { this.attempt = attempt; }

	public String getPhaseName() { return phaseName; }

	public void setPhaseName(String phaseName) { this.phaseName = phaseName; }

}