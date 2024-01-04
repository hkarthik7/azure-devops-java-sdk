package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/***
 * Represents a List of build results
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Builds extends SerializableCollectionEntity {
    /***
     * Represents a List of build results
     */
    @JsonProperty("value")
    private List<Build> builds;

    public List<Build> getBuildResults() {
        return builds;
    }

    public void setBuildResults(List<Build> value) {
        this.builds = value;
    }

}
