package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;

/***
 * Versions of the wiki.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitVersionDescriptor extends SerializableEntity {
    /***
     * Version string identifier (name of tag/branch, SHA1 of commit)
     */
    @JsonProperty("version")
    public String version;
    /***
     * Version options - Specify additional modifiers to version (e.g Previous)
     */
    @JsonProperty("versionOptions")
    public GitVersionOptions versionOptions;
    /***
     * Version type (branch, tag, or commit). Determines how Id is interpreted
     */
    @JsonProperty("versionType")
    public GitVersionType versionType;

}
