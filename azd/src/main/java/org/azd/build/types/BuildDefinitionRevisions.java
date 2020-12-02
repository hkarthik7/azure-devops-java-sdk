package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionRevisions {
    @JsonProperty("value")
    private List<BuildDefinitionRevision> value;

    public List<BuildDefinitionRevision> getBuildDefinitionRevision() {
        return value;
    }

    public void setBuildDefinitionRevision(List<BuildDefinitionRevision> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BuildDefinitionRevisions{" +
                "value=" + value +
                '}';
    }
}
