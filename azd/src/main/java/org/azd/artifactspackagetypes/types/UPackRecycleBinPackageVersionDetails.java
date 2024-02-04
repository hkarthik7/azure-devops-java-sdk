package org.azd.artifactspackagetypes.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Setting to false will undo earlier deletion and restore the package to feed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UPackRecycleBinPackageVersionDetails extends SerializableEntity {
    /**
     * Setting to false will undo earlier deletion and restore the package to feed.
     */
    @JsonProperty("deleted")
    public boolean deleted;
}
