package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildArtifacts extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<BuildArtifact> buildArtifacts;

    public List<BuildArtifact> getBuildArtifacts() {
        return buildArtifacts;
    }

    public void setBuildArtifacts(List<BuildArtifact> buildArtifacts) {
        this.buildArtifacts = buildArtifacts;
    }

}
