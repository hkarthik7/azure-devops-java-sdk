package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionGatesOptions extends BaseAbstractMethod {
	/**
 	* Gets or sets as the gates enabled or not. 
	**/
	@JsonProperty("isEnabled")
	private boolean isEnabled;
	/**
 	* Gets or sets the minimum duration for steady results after a successful gates evaluation. 
	**/
	@JsonProperty("minimumSuccessDuration")
	private Integer minimumSuccessDuration;
	/**
 	* Gets or sets the time between re-evaluation of gates. 
	**/
	@JsonProperty("samplingInterval")
	private Integer samplingInterval;
	/**
 	* Gets or sets the delay before evaluation. 
	**/
	@JsonProperty("stabilizationTime")
	private Integer stabilizationTime;
	/**
 	* Gets or sets the timeout after which gates fail. 
	**/
	@JsonProperty("timeout")
	private Integer timeout;

	public boolean getIsEnabled() { return isEnabled; }

	public void setIsEnabled(boolean isEnabled) { this.isEnabled = isEnabled; }

	public Integer getMinimumSuccessDuration() { return minimumSuccessDuration; }

	public void setMinimumSuccessDuration(Integer minimumSuccessDuration) { this.minimumSuccessDuration = minimumSuccessDuration; }

	public Integer getSamplingInterval() { return samplingInterval; }

	public void setSamplingInterval(Integer samplingInterval) { this.samplingInterval = samplingInterval; }

	public Integer getStabilizationTime() { return stabilizationTime; }

	public void setStabilizationTime(Integer stabilizationTime) { this.stabilizationTime = stabilizationTime; }

	public Integer getTimeout() { return timeout; }

	public void setTimeout(Integer timeout) { this.timeout = timeout; }

}
