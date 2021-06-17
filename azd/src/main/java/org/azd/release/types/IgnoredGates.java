package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IgnoredGates {
    @JsonProperty("lastModifiedOn")
    private String lastModifiedOn;
    @JsonProperty("name")
    private String name;

    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IgnoredGates{" +
                "lastModifiedOn='" + lastModifiedOn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
