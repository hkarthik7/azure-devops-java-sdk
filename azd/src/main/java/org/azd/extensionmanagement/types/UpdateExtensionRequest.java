package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.ExtensionStateFlags;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateExtensionRequest {
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
     * If none extension will be enabled. {@link ExtensionStateFlags}
     */
    @JsonProperty("extensionState")
    public ExtensionStateFlags extensionState;
}
