package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Widget types response.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetTypesResponse extends SerializableEntity {
    /**
     * Widget types.
     */
    @JsonProperty("widgetTypes")
    private List<WidgetMetadata> widgetTypes;
    /**
     * URL
     */
    @JsonProperty("url")
    private String url;

    public List<WidgetMetadata> getWidgetTypes() {
        return widgetTypes;
    }

    public void setWidgetTypes(List<WidgetMetadata> widgetTypes) {
        this.widgetTypes = widgetTypes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
