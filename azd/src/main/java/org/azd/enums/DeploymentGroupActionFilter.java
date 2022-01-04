package org.azd.enums;

/***
 * Get the deployment group only if this action can be performed on it.
 */
public enum DeploymentGroupActionFilter {
    /***
     * Only deployment groups for which caller has manage permission.
     */
    MANAGE,

    /***
     * Only deployment groups for which caller has use permission.
     */
    USE
}
