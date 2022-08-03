package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Array of installed extensions
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtensions extends BaseAbstractMethod {
    /***
     * Array of installed extensions
     */
    @JsonProperty("value")
    private List<InstalledExtension> installedExtensions;

    public List<InstalledExtension> getInstalledExtensions() {
        return installedExtensions;
    }

    public void setInstalledExtensions(List<InstalledExtension> installedExtensions) {
        this.installedExtensions = installedExtensions;
    }

}
