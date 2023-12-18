package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * States of an installed extension
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ExtensionStateFlags {
    /***
     * Extension is disabled
     */
    @JsonProperty("disabled")
    DISABLED,
    /***
     * No flags set
     */
    @JsonProperty("none")
    NONE
}
