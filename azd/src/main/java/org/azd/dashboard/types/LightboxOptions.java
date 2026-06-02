package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Lightbox configuration.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LightboxOptions extends SerializableEntity {
    /**
     * Height of desired lightbox, in pixels.
     */
    @JsonProperty("height")
    private Integer height;
    /**
     * Width of desired lightbox, in pixels.
     */
    @JsonProperty("width")
    private Integer width;
    /**
     * True to allow lightbox resizing, false to disallow lightbox resizing, defaults to false.
     */
    @JsonProperty("resizable")
    private Boolean resizable;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Boolean getResizable() {
        return resizable;
    }

    public void setResizable(Boolean resizable) {
        this.resizable = resizable;
    }
}
