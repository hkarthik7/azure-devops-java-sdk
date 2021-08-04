package org.azd.work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents the team iteration attributes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamIterationAttributes {
    /***
     * Start date of the iteration. Date-only, correct unadjusted at midnight in UTC.
     */
    @JsonProperty("startDate")
    private String startDate;
    /***
     * Finish date of the iteration. Date-only, correct unadjusted at midnight in UTC.
     */
    @JsonProperty("finishDate")
    private String finishDate;
    /***
     * Time frame of the iteration, such as past, current or future.
     */
    @JsonProperty("timeFrame")
    private String timeFrame;

    @Override
    public String toString() {
        return "TeamIterationAttributes{" +
                "startDate='" + startDate + '\'' +
                ", finishDate='" + finishDate + '\'' +
                ", timeFrame='" + timeFrame + '\'' +
                '}';
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }
}
