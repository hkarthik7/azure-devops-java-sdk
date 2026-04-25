package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Versioning for an artifact as described at http://semver.org/, of the form major.minor.patch.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SemanticVersion extends SerializableEntity {
    /**
     * Major version.
     */
    @JsonProperty("major")
    private int major;
    /**
     * Minor version.
     */
    @JsonProperty("minor")
    private int minor;
    /**
     * Patch version.
     */
    @JsonProperty("patch")
    private int patch;

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getPatch() {
        return patch;
    }

    public void setPatch(int patch) {
        this.patch = patch;
    }
}
