package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Gets list of schedules.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseSchedule {
    /***
     * Days of the week to release.
     */
    @JsonProperty("daysToRelease")
    private String daysToRelease;
    /***
     * Team Foundation Job Definition Job Id.
     */
    @JsonProperty("jobId")
    private String jobId;
    /***
     * Flag to determine if this schedule should only release if the associated artifact has been changed or release definition changed.
     */
    @JsonProperty("scheduleOnlyWithChanges")
    private boolean scheduleOnlyWithChanges;
    /***
     * Local time zone hour to start.
     */
    @JsonProperty("startHours")
    private int startHours;
    /***
     * Local time zone minute to start.
     */
    @JsonProperty("startMinutes")
    private int startMinutes;
    /***
     * Time zone Id of release schedule, such as 'UTC'.
     */
    @JsonProperty("timeZoneId")
    private String timeZoneId;

    public String getDaysToRelease() {
        return daysToRelease;
    }

    public void setDaysToRelease(String daysToRelease) {
        this.daysToRelease = daysToRelease;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public boolean isScheduleOnlyWithChanges() {
        return scheduleOnlyWithChanges;
    }

    public void setScheduleOnlyWithChanges(boolean scheduleOnlyWithChanges) {
        this.scheduleOnlyWithChanges = scheduleOnlyWithChanges;
    }

    public int getStartHours() {
        return startHours;
    }

    public void setStartHours(int startHours) {
        this.startHours = startHours;
    }

    public int getStartMinutes() {
        return startMinutes;
    }

    public void setStartMinutes(int startMinutes) {
        this.startMinutes = startMinutes;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    @Override
    public String toString() {
        return "ReleaseSchedule{" +
                "daysToRelease='" + daysToRelease + '\'' +
                ", jobId='" + jobId + '\'' +
                ", scheduleOnlyWithChanges=" + scheduleOnlyWithChanges +
                ", startHours=" + startHours +
                ", startMinutes=" + startMinutes +
                ", timeZoneId='" + timeZoneId + '\'' +
                '}';
    }
}
