package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Gets or sets the status of the manual intervention.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum ManualInterventionStatus {
    /***
     * The manual intervention is approved.
     */
    @JsonProperty("approved")
    APPROVED,
    /***
     * The manual intervention is canceled.
     */
    @JsonProperty("canceled")
    CANCELLED,
    /***
     * The manual intervention is pending.
     */
    @JsonProperty("pending")
    PENDING,
    /***
     * The manual intervention is rejected.
     */
    @JsonProperty("rejected")
    REJECTED,
    /***
     * The manual intervention does not have the status set.
     */
    @JsonProperty("unknown")
    UNKNOWN

}
