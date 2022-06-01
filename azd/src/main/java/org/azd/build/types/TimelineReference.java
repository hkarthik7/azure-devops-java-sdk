package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a reference to a timeline.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineReference {
    /**
     * The change ID.
     */
    @JsonProperty("changeId")
    private int changeId;
    /**
     * The ID of the timeline.
     */
    @JsonProperty("id")
    private String id;
    /**
     * The REST URL of the timeline.
     */
    @JsonProperty("url")
    private String url;

    public int getChangeId() {
        return changeId;
    }

    public void setChangeId(int changeId) {
        this.changeId = changeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TimelineReference{" +
                "changeId=" + changeId +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
