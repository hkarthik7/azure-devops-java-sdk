package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

    @JsonIgnoreProperties(ignoreUnknown = true)
public class BuildQueue {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pool")
    private BuildPool pool;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildPool getPool() {
        return pool;
    }

    public void setPool(BuildPool pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        return "BQueue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pool=" + pool +
                '}';
    }
}
