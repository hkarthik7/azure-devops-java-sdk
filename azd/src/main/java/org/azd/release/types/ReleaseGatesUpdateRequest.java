package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Represents the request body to update Release Gates
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseGatesUpdateRequest extends SerializableEntity {
    /**
     * Comments
     */
    @JsonProperty("comment")
    public String comment;
    /**
     * Name of gate to be ignored.
     */
    @JsonProperty("gatesToIgnore")
    public List<String> gatesToIgnore;
}
