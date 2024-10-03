package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.ManualInterventionStatus;

/**
 * Represents the Release Manual intervention update request body
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManualInterventionUpdateRequest extends SerializableEntity {
    /**
     * Comments
     */
    @JsonProperty("comment")
    public String comment;
    /**
     * Sets the status of the manual intervention.
     */
    @JsonProperty("status")
    public ManualInterventionStatus status;
}
