package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Describes the tag value
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTagDefinition extends SerializableEntity {
    /**
     * ID of the tag
     */
    @JsonProperty("id")
    private String id;
    /**
     * Whe the tag was last updated
     */
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    /**
     * Name of the tag
     */
    @JsonProperty("name")
    private String name;
    /**
     * URL of the tag
     */
    @JsonProperty("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
