package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UnInstallExtensionRequest {
    /**
     * Id of the publisher. Example: "sonarsource".
     */
    @JsonProperty("publisherId")
    public String publisherId;
    /**
     * Id of the extension. Example: "sonarqube".
     */
    @JsonProperty("extensionId")
    public String extensionId;
    /**
     * Reason for uninstall
     */
    @JsonProperty("reason")
    public String reason;
    /**
     * Reason code for uninstall
     */
    @JsonProperty("reasonCode")
    public String reasonCode;
}
