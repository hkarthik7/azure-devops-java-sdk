package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.enums.VersionControlRecursionType;

/**
 * Git Item descriptor
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitItemDescriptor {
    /**
     * Path to item
     */
    @JsonProperty("path")
    public String path;
    /**
     * Specifies whether to include children (OneLevel), all descendants (Full), or None
     */
    @JsonProperty("recursionLevel")
    public VersionControlRecursionType recursionLevel;
    /**
     * Version string (interpretation based on VersionType defined in subclass
     */
    @JsonProperty("version")
    public String version;
    /**
     * Version modifiers (e.g. previous)
     */
    @JsonProperty("versionOptions")
    public GitVersionOptions versionOptions;
    /**
     * How to interpret version (branch,tag,commit)
     */
    @JsonProperty("versionType")
    public GitVersionType versionType;
}
