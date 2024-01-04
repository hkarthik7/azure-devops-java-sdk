package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents an array of items in the repository from a source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRepositoryItems extends SerializableCollectionEntity {
    /**
     * Represents an array of items in the repository from a source provider.
     */
    @JsonProperty("value")
    private List<SourceRepositoryItem> sourceRepositoryItems;

    public List<SourceRepositoryItem> getSourceRepositoryItems() {
        return sourceRepositoryItems;
    }

    public void setSourceRepositoryItems(List<SourceRepositoryItem> sourceRepositoryItems) {
        this.sourceRepositoryItems = sourceRepositoryItems;
    }

}
