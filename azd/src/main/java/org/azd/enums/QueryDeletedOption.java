package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Indicates whether to exclude, include, or only return deleted builds.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum QueryDeletedOption {
    /**
     * Include only non-deleted builds.
     */
    @JsonProperty("excludeDeleted")
    EXCLUDEDELETED,
    /**
     * Include deleted and non-deleted builds.
     */
    @JsonProperty("includeDeleted")
    INCLUDEDELETED,
    /**
     * Include only deleted builds.
     */
    @JsonProperty("onlyDeleted")
    ONLYDELETED,
}
