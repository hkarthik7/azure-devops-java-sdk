package org.azd.enums;

/***
 * Gets or sets the type of approval.
 */
public enum ReleaseApprovalType {
    /***
     * Indicates all approvals.
     */
    ALL,
    /***
     * Indicates the approvals which executed after deployment.
     */
    POSTDEPLOY,
    /***
     * Indicates the approvals which executed before deployment.
     */
    PREDEPLOY,
    /***
     * Indicates the approval type does not set.
     */
    UNDEFINED
}
