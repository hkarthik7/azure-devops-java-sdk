package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents a collection of definition resource reference
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefinitionResourceReferences extends SerializableCollectionEntity {
    /**
     * Contains the collection of definition resource reference
     */
    @JsonProperty("value")
    private List<DefinitionResourceReference> definitionResourceReferences;

    public List<DefinitionResourceReference> getDefinitionResourceReferences() {
        return definitionResourceReferences;
    }

    public void setDefinitionResourceReferences(List<DefinitionResourceReference> definitionResourceReferences) {
        this.definitionResourceReferences = definitionResourceReferences;
    }
}
