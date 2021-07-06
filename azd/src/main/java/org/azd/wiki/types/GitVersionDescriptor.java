package org.azd.wiki.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitVersionDescriptor {
    @JsonProperty("version")
    private String version;
    @JsonProperty("versionOptions")
    private String versionOptions;
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

    @Override
    public String toString() {
        return "GitVersionDescriptor{" +
                "version='" + version + '\'' +
                ", versionOptions='" + versionOptions + '\'' +
                ", versionType='" + versionType + '\'' +
                '}';
    }
}
