package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourceAreas extends SerializableCollectionEntity {
    @JsonProperty("count")
    public int count;
    @JsonProperty("value")
    public List<LocationUrl> resourceAreas;
}
