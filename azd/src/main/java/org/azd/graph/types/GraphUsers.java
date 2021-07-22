package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * Represents a list of graph user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUsers {
    /***
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

    @Override
    public String toString() {
        return "GraphUsers{" +
                "users=" + users +
                '}';
    }
}
