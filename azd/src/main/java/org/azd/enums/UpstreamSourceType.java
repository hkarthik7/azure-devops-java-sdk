package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Source type, such as Public or Internal.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum UpstreamSourceType {
    /***
     * Azure DevOps upstream source.
     */
    @JsonProperty("internal")
    INTERNAL,
    /***
     * Publicly available source.
     */
    @JsonProperty("public")
    PUBLIC
}
