package org.azd.enums;

/***
 * Gets or sets the status of the approval.
 */
public enum ReleaseApprovalStatus {
    /***
     * Indicates the approval is approved.
     */
    APPROVED,
    /***
     * Indicates the approval is canceled.
     */
    CANCELED,
    /***
     * Indicates the approval is pending.
     */
    PENDING,
    /***
     * Indicates the approval is reassigned.
     */
    REASSIGNED,
    /***
     * Indicates the approval is rejected.
     */
    REJECTED,
    /***
     * Indicates the approval is skipped.
     */
    SKIPPED,
    /***
     * Indicates the approval does not have the status set.
     */
    UNDEFINED
}
