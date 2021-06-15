package org.azd.Work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamIterationAttributes {
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("finishDate")
    private String finishDate;
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
