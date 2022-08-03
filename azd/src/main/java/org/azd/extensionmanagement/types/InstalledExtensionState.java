package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Information about this particular installation of the extension
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtensionState extends BaseAbstractMethod {
    /***
     * States of an installed extension
     */
    @JsonProperty("flags")
    private String flags;
    /***
     * List of installation issues
     */
    @JsonProperty("installationIssues")
    private List<InstalledExtensionStateIssue> installationIssues;
    /***
     * The time at which this installation was last updated
     */
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

}
