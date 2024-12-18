package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum AttachmentType {
    /**
     * Attachment type CodeCoverage.
     */
    @JsonProperty("codeCoverage")
    CODE_COVERAGE,
    /**
     * Attachment type ConsoleLog.
     */
    @JsonProperty("consoleLog")
    CONSOLE_LOG,
    /**
     * Attachment type GeneralAttachment , use this as default type unless you have other type.
     */
    @JsonProperty("generalAttachment")
    GENERAL_ATTACHMENT
}
