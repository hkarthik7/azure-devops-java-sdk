package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionLicensing {
    @JsonProperty("overrides")
    private List<LicensingOverride> overrides;

    public List<LicensingOverride> getOverrides() {
        return overrides;
    }

    public void setOverrides(List<LicensingOverride> overrides) {
        this.overrides = overrides;
    }

    @Override
    public String toString() {
        return "ExtensionLicensing{" +
                "overrides=" + overrides +
                '}';
    }
}
