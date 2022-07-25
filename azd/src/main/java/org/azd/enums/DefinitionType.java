package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * The type of the definition.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum DefinitionType {
    /***
     * Build
     */
    @JsonProperty("build")
    BUILD,
    /***
     * XAML
     */
    @JsonProperty("xaml")
    XAML
}
