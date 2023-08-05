package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/**
 * Represents a collection of retention lease
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetentionLeases extends SerializableEntity {
    /**
     * Represents a collection of retention lease
     */
    @JsonProperty("value")
    private List<RetentionLease> retentionLeases;

    public List<RetentionLease> getRetentionLeases() {
        return retentionLeases;
    }

    public void setRetentionLeases(List<RetentionLease> retentionLeases) {
        this.retentionLeases = retentionLeases;
    }
}
