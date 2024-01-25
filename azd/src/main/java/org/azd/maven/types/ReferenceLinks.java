package org.azd.maven.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * The class to represent a collection of REST reference links.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLinks extends SerializableEntity {
    /**
     * Related REST links.
     */
    @JsonProperty("links")
    private Object links;

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

}
