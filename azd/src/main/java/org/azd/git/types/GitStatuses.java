package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents a collection of Git pull request statuses
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitStatuses extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<GitStatus> statuses;

    public List<GitStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<GitStatus> statuses) {
        this.statuses = statuses;
    }
}
