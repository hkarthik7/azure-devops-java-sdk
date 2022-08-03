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
public class EnvironmentExecutionPolicy extends BaseAbstractMethod {
	/**
 	* This policy decides, how many environments would be with Environment Runner. 
	**/
	@JsonProperty("concurrencyCount")
	private Integer concurrencyCount;
	/**
 	* Queue depth in the EnvironmentQueue table, this table keeps the environment entries till Environment Runner is free [as per it's policy] to take another environment for running. 
	**/
	@JsonProperty("queueDepthCount")
	private Integer queueDepthCount;

	public Integer getConcurrencyCount() { return concurrencyCount; }

	public void setConcurrencyCount(Integer concurrencyCount) { this.concurrencyCount = concurrencyCount; }

	public Integer getQueueDepthCount() { return queueDepthCount; }

	public void setQueueDepthCount(Integer queueDepthCount) { this.queueDepthCount = queueDepthCount; }

}
