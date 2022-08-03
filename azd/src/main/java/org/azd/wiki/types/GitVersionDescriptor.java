package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Versions of the wiki.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitVersionDescriptor extends BaseAbstractMethod {
    /***
     * Version string identifier (name of tag/branch, SHA1 of commit)
     */
    @JsonProperty("version")
    private String version;
    /***
     * Version options - Specify additional modifiers to version (e.g Previous)
     */
    @JsonProperty("versionOptions")
    private String versionOptions;
    /***
     * Version type (branch, tag, or commit). Determines how Id is interpreted
     */
    @JsonProperty("versionType")
    private String versionType;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionOptions() {
        return versionOptions;
    }

    public void setVersionOptions(String versionOptions) {
        this.versionOptions = versionOptions;
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }

}
