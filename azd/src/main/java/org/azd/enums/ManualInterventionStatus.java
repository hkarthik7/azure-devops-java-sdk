package org.azd.enums;

/***
 * Gets or sets the status of the manual intervention.
 */
public enum ManualInterventionStatus {
    /***
     * The manual intervention is approved.
     */
    APPROVED,
    /***
     * The manual intervention is canceled.
     */
    CANCELLED,
    /***
     * The manual intervention is pending.
     */
    PENDING,
    /***
     * The manual intervention is rejected.
     */
    REJECTED,
    /***
     * The manual intervention does not have the status set.
     */
    UNKNOWN

}
