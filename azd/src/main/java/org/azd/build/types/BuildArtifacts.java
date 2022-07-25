package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildArtifacts {
    @JsonProperty("value")
    private List<BuildArtifact> buildArtifacts;

    public List<BuildArtifact> getBuildArtifacts() {
        return buildArtifacts;
    }

    public void setBuildArtifacts(List<BuildArtifact> buildArtifacts) {
        this.buildArtifacts = buildArtifacts;
    }

    @Override
    public String toString() {
        return "BuildArtifacts{" +
                "buildArtifacts=" + buildArtifacts +
                '}';
    }
}
