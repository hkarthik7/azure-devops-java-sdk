package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitions {
    @JsonProperty("value")
    private List<BuildDefinition> value;

    public List<BuildDefinition> getBuildDefinition() {
        return value;
    }

    public void setBuildDefinition(List<BuildDefinition> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BuildDefinitions{" +
                "value=" + value +
                '}';
    }
}
