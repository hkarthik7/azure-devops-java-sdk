package org.azd.enums;

/***
 * Release environment status.
 */
public enum ReleaseEnvironmentStatus {
    /***
     * Environment is in canceled state.
     */
    CANCELED,
    /***
     * Environment is in progress state.
     */
    INPROGRESS,
    /***
     * Environment is in not started state.
     */
    NOTSTARTED,
    /***
     * Environment is in partially succeeded state.
     */
    PARTIALLYSUCCEEDED,
    /***
     * Environment is in queued state.
     */
    QUEUED,
    /***
     * Environment is in rejected state.
     */
    REJECTED,
    /***
     * Environment is in scheduled state.
     */
    SCHEDULED,
    /***
     * Environment is in succeeded state.
     */
    SUCCEEDED,
    /***
     * Environment status not set.
     */
    UNDEFINED
}
