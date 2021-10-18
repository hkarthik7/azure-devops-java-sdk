package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtensionState {
    @JsonProperty("flags")
    private String flags;
    @JsonProperty("installationIssues")
    private List<InstalledExtensionStateIssue> installationIssues;
    @JsonProperty("lastUpdated")
    private String lastUpdated;

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public List<InstalledExtensionStateIssue> getInstallationIssues() {
        return installationIssues;
    }

    public void setInstallationIssues(List<InstalledExtensionStateIssue> installationIssues) {
        this.installationIssues = installationIssues;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "InstalledExtensionState{" +
                "flags='" + flags + '\'' +
                ", installationIssues=" + installationIssues +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}
