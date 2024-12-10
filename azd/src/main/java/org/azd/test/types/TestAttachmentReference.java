package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Reference to test attachment.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestAttachmentReference extends SerializableEntity {
    /**
     * ID of the attachment.
     */
    @JsonProperty("id")
    private int id;
    /**
     * Url to download the attachment.
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
