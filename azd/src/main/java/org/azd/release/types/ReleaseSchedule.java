package org.azd.release.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ScheduleDays;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseSchedule extends BaseAbstractMethod {
	/**
 	* Days of the week to release. 
	**/
	@JsonProperty("daysToRelease")
	private ScheduleDays daysToRelease;
	/**
 	* Team Foundation Job Definition Job Id. 
	**/
	@JsonProperty("jobId")
	private String jobId;
	/**
 	* Flag to determine if this schedule should only release if the associated artifact has been changed or release definition changed. 
	**/
	@JsonProperty("scheduleOnlyWithChanges")
	private boolean scheduleOnlyWithChanges;
	/**
 	* Local time zone hour to start. 
	**/
	@JsonProperty("startHours")
	private Integer startHours;
	/**
 	* Local time zone minute to start. 
	**/
	@JsonProperty("startMinutes")
	private Integer startMinutes;
	/**
 	* Time zone Id of release schedule, such as 'UTC'. 
	**/
	@JsonProperty("timeZoneId")
	private String timeZoneId;

	public ScheduleDays getDaysToRelease() { return daysToRelease; }

	public void setDaysToRelease(ScheduleDays daysToRelease) { this.daysToRelease = daysToRelease; }

	public String getJobId() { return jobId; }

	public void setJobId(String jobId) { this.jobId = jobId; }

	public boolean getScheduleOnlyWithChanges() { return scheduleOnlyWithChanges; }

	public void setScheduleOnlyWithChanges(boolean scheduleOnlyWithChanges) { this.scheduleOnlyWithChanges = scheduleOnlyWithChanges; }

	public Integer getStartHours() { return startHours; }

	public void setStartHours(Integer startHours) { this.startHours = startHours; }

	public Integer getStartMinutes() { return startMinutes; }

	public void setStartMinutes(Integer startMinutes) { this.startMinutes = startMinutes; }

	public String getTimeZoneId() { return timeZoneId; }

	public void setTimeZoneId(String timeZoneId) { this.timeZoneId = timeZoneId; }

}
