package org.azd.Work.Iterations.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamSettingsIteration {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("path")
    private String path;
    @JsonProperty("url")
    private String url;

    @Override
    public String toString() {
        return "TeamSettingsIteration{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class TeamIterationAttributes {
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
}
