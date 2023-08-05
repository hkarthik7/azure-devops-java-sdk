package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * How this extension behaves with respect to licensing
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionLicensing extends SerializableEntity {
    /***
     * A list of contributions which deviate from the default licensing behavior
     */
    @JsonProperty("overrides")
    private List<LicensingOverride> overrides;

    public List<LicensingOverride> getOverrides() {
        return overrides;
    }

    public void setOverrides(List<LicensingOverride> overrides) {
        this.overrides = overrides;
    }
}
