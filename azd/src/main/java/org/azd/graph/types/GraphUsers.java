package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphUsers {
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
