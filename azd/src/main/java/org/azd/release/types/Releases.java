package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of release
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Releases extends SerializableCollectionEntity {
    /**
     * List of release
     */
    @JsonProperty("value")
    private List<Release> releases;

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

}
