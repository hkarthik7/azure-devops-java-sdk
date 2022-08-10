package org.azd.wiki.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Defines properties for wiki page stat. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiPageStat extends BaseAbstractMethod {
	/**
 	* the count of the stat for the Day 
	**/
	@JsonProperty("count")
	private Integer count;
	/**
 	* Day of the stat 
	**/
	@JsonProperty("day")
	private String day;

	public Integer getCount() { return count; }

	public void setCount(Integer count) { this.count = count; }

	public String getDay() { return day; }

	public void setDay(String day) { this.day = day; }

}