package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Status of a Graph membership (active/inactive)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphMembershipState extends SerializableEntity {
    /**
     * This field contains zero or more interesting links about the graph membership state.
     * These links may be invoked to obtain additional relationships or more detailed information about this graph membership state.
     */
    @JsonProperty("_links")
    private Object links;
    /**
     * When true, the membership is active
     */
    @JsonProperty("active")
    private boolean active;

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
