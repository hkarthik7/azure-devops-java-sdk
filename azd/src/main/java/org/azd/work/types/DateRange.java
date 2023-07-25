package org.azd.work.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Represents team member capacity with totals aggregated 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateRange extends BaseAbstractMethod {
	/**
 	* End of the date range. 
	**/
	@JsonProperty("end")
	private String end;
	/**
 	* Start of the date range. 
	**/
	@JsonProperty("start")
	private String start;

	public String getEnd() { return end; }

	public void setEnd(String end) { this.end = end; }

	public String getStart() { return start; }

	public void setStart(String start) { this.start = start; }

}