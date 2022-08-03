package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VersionControl extends BaseAbstractMethod {
    @JsonProperty("sourceControlType")
    private String sourceControlType;
    @JsonProperty("gitEnabled")
    private boolean gitEnabled;
    @JsonProperty("tfvcEnabled")
    private boolean tfvcEnabled;

    public String getSourceControlType() {
        return sourceControlType;
    }

    public void setSourceControlType(String sourceControlType) {
        this.sourceControlType = sourceControlType;
    }

    public boolean isGitEnabled() {
        return gitEnabled;
    }

    public void setGitEnabled(boolean gitEnabled) {
        this.gitEnabled = gitEnabled;
    }

    public boolean isTfvcEnabled() {
        return tfvcEnabled;
    }

    public void setTfvcEnabled(boolean tfvcEnabled) {
        this.tfvcEnabled = tfvcEnabled;
    }

}
