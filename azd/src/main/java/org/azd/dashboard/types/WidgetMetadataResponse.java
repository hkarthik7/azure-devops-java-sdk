package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Widget metadata response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetMetadataResponse extends SerializableEntity {
    /**
     * Widget metadata.
     */
    @JsonProperty("widgetMetadata")
    private WidgetMetadata widgetMetadata;
    /**
     * URL
     */
    @JsonProperty("url")
    private String url;

    public WidgetMetadata getWidgetMetadata() {
        return widgetMetadata;
    }

    public void setWidgetMetadata(WidgetMetadata widgetMetadata) {
        this.widgetMetadata = widgetMetadata;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
