package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;

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
    private GitVersionOptions versionOptions;
    /***
     * Version type (branch, tag, or commit). Determines how Id is interpreted
     */
    @JsonProperty("versionType")
    private GitVersionType versionType;

    public GitVersionDescriptor() {
    }

    public GitVersionDescriptor(String version) {
        this.version = version;
    }

    public GitVersionDescriptor(String version, GitVersionOptions versionOptions, GitVersionType versionType) {
        this.version = version;
        this.versionOptions = versionOptions;
        this.versionType = versionType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public GitVersionOptions getVersionOptions() {
        return versionOptions;
    }

    public void setVersionOptions(GitVersionOptions versionOptions) {
        this.versionOptions = versionOptions;
    }

    public GitVersionType getVersionType() {
        return versionType;
    }

    public void setVersionType(GitVersionType versionType) {
        this.versionType = versionType;
    }

}
