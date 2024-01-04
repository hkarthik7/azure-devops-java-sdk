package org.azd.build.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Represents the timeline of a build.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Timeline extends SerializableEntity {
    /**
     * The change ID.
     **/
    @JsonProperty("changeId")
    private Integer changeId;
    /**
     * The ID of the timeline.
     **/
    @JsonProperty("id")
    private String id;
    /**
     * The process or person that last changed the timeline.
     **/
    @JsonProperty("lastChangedBy")
    private String lastChangedBy;
    /**
     * The time the timeline was last changed.
     **/
    @JsonProperty("lastChangedOn")
    private String lastChangedOn;
    /**
     * Represents an entry in a build's timeline.
     **/
    @JsonProperty("records")
    private List<TimelineRecord> records;
    /**
     * The REST URL of the timeline.
     **/
    @JsonProperty("url")
    private String url;

    public Integer getChangeId() {
        return changeId;
    }

    public void setChangeId(Integer changeId) {
        this.changeId = changeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastChangedBy() {
        return lastChangedBy;
    }

    public void setLastChangedBy(String lastChangedBy) {
        this.lastChangedBy = lastChangedBy;
    }

    public String getLastChangedOn() {
        return lastChangedOn;
    }

    public void setLastChangedOn(String lastChangedOn) {
        this.lastChangedOn = lastChangedOn;
    }

    public List<TimelineRecord> getRecords() {
        return records;
    }

    public void setRecords(List<TimelineRecord> records) {
        this.records = records;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}