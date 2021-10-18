package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtensions {
    @JsonProperty("value")
    private List<InstalledExtension> installedExtensions;

    public List<InstalledExtension> getInstalledExtensions() {
        return installedExtensions;
    }

    public void setInstalledExtensions(List<InstalledExtension> installedExtensions) {
        this.installedExtensions = installedExtensions;
    }

    @Override
    public String toString() {
        return "InstalledExtensions{" +
                "installedExtensions=" + installedExtensions +
                '}';
    }
}
