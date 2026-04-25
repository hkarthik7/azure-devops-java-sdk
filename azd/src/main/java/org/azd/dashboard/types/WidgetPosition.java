package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Widget position on the dashboard.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WidgetPosition extends SerializableEntity {
    /**
     * Column position.
     */
    @JsonProperty("column")
    private int column;
    /**
     * Row position.
     */
    @JsonProperty("row")
    private int row;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
