package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Gets the results in the defined order. Default is 'None'.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FolderPathQueryOrder {
    /**
     * Order by folder name and path ascending.
     */
    @JsonProperty("ascending")
    ASCENDING,
    /**
     * Order by folder name and path descending.
     */
    @JsonProperty("descending")
    DESCENDING,
    /**
     * No order.
     */
    @JsonProperty("none")
    NONE
}
