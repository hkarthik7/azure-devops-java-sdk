package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents an array of items in the repository from a source provider.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SourceRepositoryItems {
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

    @Override
    public String toString() {
        return "SourceRepositoryItems{" +
                "sourceRepositoryItems=" + sourceRepositoryItems +
                '}';
    }
}
