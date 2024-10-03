package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The order in which folders should be returned.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FolderQueryOrder {
    /**
     * Order by folder name and path ascending.
     */
    @JsonProperty("folderAscending")
    FOLDERASCENDING,
    /**
     * Order by folder name and path descending.
     */
    @JsonProperty("folderDescending")
    FOLDERDESCENDING,
}
