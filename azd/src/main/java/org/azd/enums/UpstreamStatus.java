package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Specifies the status of the upstream.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum UpstreamStatus {
    /***
     * Upstream source is disabled.
     */
    @JsonProperty("disabled")
    DISABLED,
    /***
     * Upstream source is ok.
     */
    @JsonProperty("ok")
    OK
}
