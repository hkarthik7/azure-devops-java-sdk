package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Contains reference to a work item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemReference extends SerializableEntity {
    /**
     * Work item ID.
     */
    @JsonProperty("id")
    private int id;
    /**
     * REST API URL of the resource
     */
    @JsonProperty("url")
    private String url;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
