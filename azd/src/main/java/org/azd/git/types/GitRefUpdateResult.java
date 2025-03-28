package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Result of a git reference update.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRefUpdateResult extends SerializableEntity {

    /**
     * Custom message for the result object For instance, Reason for failing.
     */
    @JsonProperty("customMessage")
    private String customMessage;
    /**
     * Whether the ref is locked or not
     */
    @JsonProperty("isLocked")
    private boolean isLocked;
    /**
     * Ref name
     */
    @JsonProperty("name")
    private String name;
    /**
     * New Object Id
     */
    @JsonProperty("newObjectId")
    private String newObjectId;
    /**
     * Old Object Id
     */
    @JsonProperty("oldObjectId")
    private String oldObjectId;

    /**
     * Name of the plugin that rejected the updated.
     */
    @JsonProperty("rejectedBy")
    private String rejectedBy;
    /**
     * repository id
     */
    @JsonProperty("repositoryId")
    private String repositoryId;
    /**
     * True if the ref update succeeded, false otherwise
     */
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("updateStatus")
    private String GitRefUpdateStatus;

    public String getCustomMessage() {
        return customMessage;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public String getName() {
        return name;
    }

    public String getNewObjectId() {
        return newObjectId;
    }

    public String getOldObjectId() {
        return oldObjectId;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public String getRepositoryId() {
        return repositoryId;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getGitRefUpdateStatus() {
        return GitRefUpdateStatus;
    }
}
