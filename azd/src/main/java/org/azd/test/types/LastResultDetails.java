package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Last result details of test point.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastResultDetails extends SerializableEntity {
    /**
     * Completed date of last result.
     */
    @JsonProperty("dateCompleted")
    private String dateCompleted;
    /**
     * Duration of the last result in milliseconds.
     */
    @JsonProperty("duration")
    private Integer duration;
    /**
     * The user who executed the last result.
     */
    @JsonProperty("runBy")
    private IdentityRef runBy;

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public IdentityRef getRunBy() {
        return runBy;
    }

    public void setRunBy(IdentityRef runBy) {
        this.runBy = runBy;
    }
}
