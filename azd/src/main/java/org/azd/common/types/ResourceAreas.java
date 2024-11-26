package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceAreas extends SerializableCollectionEntity {
    @JsonProperty("count")
    private int count;
    @JsonProperty("value")
    private List<LocationUrl> resourceAreas;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<LocationUrl> getResourceAreas() {
        return resourceAreas;
    }

    public void setResourceAreas(List<LocationUrl> resourceAreas) {
        this.resourceAreas = resourceAreas;
    }
}
