package org.azd.artifactspackagetypes.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Identifies a particular Maven package version
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MavenMinimalPackageDetails extends SerializableEntity {
    /**
     * Package artifact ID
     */
    @JsonProperty("artifact")
    public String artifact;
    /**
     * Package group ID
     */
    @JsonProperty("group")
    public String group;
    /**
     * Package version
     */
    @JsonProperty("version")
    public String version;
}
