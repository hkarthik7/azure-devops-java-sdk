package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Widget size.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetSize extends SerializableEntity {
    /**
     * The Width of the widget, expressed in dashboard grid columns.
     */
    @JsonProperty("columnSpan")
    private int columnSpan;
    /**
     * The height of the widget, expressed in dashboard grid rows.
     */
    @JsonProperty("rowSpan")
    private int rowSpan;

    public int getColumnSpan() {
        return columnSpan;
    }

    public void setColumnSpan(int columnSpan) {
        this.columnSpan = columnSpan;
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }
}
