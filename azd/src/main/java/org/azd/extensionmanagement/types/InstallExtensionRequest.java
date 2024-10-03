package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InstallExtensionRequest {
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
     * if null latest version will be selected
     */
    @JsonProperty("version")
    public String version;
}
