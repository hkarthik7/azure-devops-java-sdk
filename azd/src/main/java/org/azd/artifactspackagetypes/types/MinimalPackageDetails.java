package org.azd.artifactspackagetypes.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Minimal package details required to identify a package within a protocol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MinimalPackageDetails extends SerializableEntity {
    /**
     * Package name.
     */
    @JsonProperty("id")
    public String id;
    /**
     * Package version.
     */
    @JsonProperty("version")
    public String version;
}
