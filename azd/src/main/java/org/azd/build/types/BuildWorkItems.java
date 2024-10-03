package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents an array of workitems
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildWorkItems extends SerializableCollectionEntity {
    /**
     * Represents an array of workitems
     */
    @JsonProperty("value")
    private List<BuildWorkItem> value;

    public List<BuildWorkItem> getBuildWorkItems() {
        return value;
    }

    public void setBuildWorkItems(List<BuildWorkItem> value) {
        this.value = value;
    }


}
