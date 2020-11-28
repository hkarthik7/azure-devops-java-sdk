package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildLog {
    @JsonProperty("lineCount")
    private int lineCount;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("lastChangedOn")
    private String lastChangedOn;
    @JsonProperty("id")
    private int id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return "BuildLog{" +
                "lineCount=" + lineCount +
                ", createdOn='" + createdOn + '\'' +
                ", lastChangedOn='" + lastChangedOn + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


}
