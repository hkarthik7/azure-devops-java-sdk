package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Collection of Graph subject or entity.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphEntities extends SerializableCollectionEntity {
    /**
     * Collection of Graph subject or entity.
     */
    @JsonProperty("value")
    private List<GraphEntity> entities;

    public List<GraphEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<GraphEntity> entities) {
        this.entities = entities;
    }
}
