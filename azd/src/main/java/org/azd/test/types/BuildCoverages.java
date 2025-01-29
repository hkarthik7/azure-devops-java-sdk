package org.azd.test.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildCoverages extends SerializableCollectionEntity {
    @JsonProperty("value")
    private List<BuildCoverage> buildCoverages;

    public List<BuildCoverage> getBuildCoverages() {
        return buildCoverages;
    }

    public void setBuildCoverages(List<BuildCoverage> buildCoverages) {
        this.buildCoverages = buildCoverages;
    }
}
