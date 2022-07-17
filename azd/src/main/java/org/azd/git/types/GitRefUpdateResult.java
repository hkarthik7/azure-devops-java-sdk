package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Result of a git reference update.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRefUpdateResult {

    /***
     * Custom message for the result object For instance, Reason for failing.
     */
    @JsonProperty("customMessage")
    private String customMessage;
    /***
     * Whether the ref is locked or not
     */
    @JsonProperty("isLocked")
    private boolean isLocked;
    /***
     * Ref name
     */
    @JsonProperty("name")
    private String name;
    /***
     * New Object Id
     */
    @JsonProperty("newObjectId")
    private String newObjectId;
    /***
     * Old Object Id
     */
    @JsonProperty("oldObjectId")
    private String oldObjectId;

    /***
     * Name of the plugin that rejected the updated.
     */
    @JsonProperty("rejectedBy")
    private String rejectedBy;
    /***
     * repository id
     */
    @JsonProperty("repositoryId")
    private String repositoryId;
    /***
     * True if the ref update succeeded, false otherwise
     */
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("updateStatus")
    private String GitRefUpdateStatus;

    @Override
    public String toString() {
        return "GitRefUpdateResult{" +
                "customMessage=" + customMessage + '\'' +
                ", isLocked='" + isLocked + '\'' +
                ", name='" + name + '\'' +
                ", newObjectId='" + newObjectId + '\'' +
                ", oldObjectId='" + oldObjectId + '\'' +
                ", rejectedBy='" + rejectedBy + '\'' +
                ", repositoryId='" + repositoryId + '\'' +
                ", success='" + success + '\'' +
                ", updateStatus='" + GitRefUpdateStatus + '\'' +
                '}';
    }

}
