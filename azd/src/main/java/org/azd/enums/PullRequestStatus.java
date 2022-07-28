package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public enum PullRequestStatus {
    /***
     * Pull request is abandoned.
     */
    @JsonProperty("abandoned")
    ABANDONED,
    /***
     * Pull request is active.
     */
    @JsonProperty("active")
    ACTIVE,
    /***
     * Used in pull request search criteria to include all statuses.
     */
    @JsonProperty("all")
    ALL,
    /***
     * Pull request is completed.
     */
    @JsonProperty("completed")
    COMPLETED
}
