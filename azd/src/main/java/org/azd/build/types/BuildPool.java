package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

    @JsonIgnoreProperties(ignoreUnknown = true)
public class BuildPool {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("isHosted")
    private boolean isHosted;

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

    public boolean isHosted() {
        return isHosted;
    }

    public void setHosted(boolean hosted) {
        isHosted = hosted;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isHosted=" + isHosted +
                '}';
    }
}
