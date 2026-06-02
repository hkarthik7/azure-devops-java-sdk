package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of widgets.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetList extends SerializableCollectionEntity {
    /**
     * List of widgets.
     */
    @JsonProperty("value")
    private List<Widget> widgets;

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }
}
