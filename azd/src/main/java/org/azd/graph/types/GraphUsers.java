package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * Represents a list of graph user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUsers extends SerializableCollectionEntity {
    /**
     * Represents a list of graph user
     */
    @JsonProperty("value")
    private List<GraphUser> users;

    public List<GraphUser> getUsers() {
        return users;
    }

    public void setUsers(List<GraphUser> users) {
        this.users = users;
    }

}
