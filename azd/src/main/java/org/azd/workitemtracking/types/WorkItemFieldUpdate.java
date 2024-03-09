package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Describes an update request for a work item field.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemFieldUpdate extends SerializableEntity {
    /**
     *
     * Indicates whether the user wants to restore the field.
     */
    @JsonProperty("isDeleted")
    public Boolean isDeleted;
    /**
     * Indicates whether the user wants to lock the field.
     */
    @JsonProperty("isLocked")
    public Boolean isLocked;
}
