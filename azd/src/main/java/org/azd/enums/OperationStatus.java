package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The current status of the operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OperationStatus {
    /**
     * The operation was cancelled by the user.
     */
    @JsonProperty("cancelled")
    CANCELLED,
    /**
     * The operation completed with a failure.
     */
    @JsonProperty("failed")
    FAILED,
    /**
     * The operation is in progress.
     */
    @JsonProperty("inProgress")
    INPROGRESS,
    /**
     * The operation does not have a status set.
     */
    @JsonProperty("notSet")
    NOTSET,
    /**
     * The operation has been queued.
     */
    @JsonProperty("queued")
    QUEUED,
    /**
     * The operation completed successfully.
     */
    @JsonProperty("succeeded")
    SUCCEEDED
}
