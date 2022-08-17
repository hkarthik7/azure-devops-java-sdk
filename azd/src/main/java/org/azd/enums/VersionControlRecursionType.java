package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Recursion level for subpages retrieval. Defaults to None (Optional).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum VersionControlRecursionType {
    /**
     * Return specified item and all descendants
     */
    @JsonProperty("full")
    FULL,
    /**
     * Only return the specified item.
     */
    @JsonProperty("none")
    NONE,
    /**
     * Return the specified item and its direct children.
     */
    @JsonProperty("oneLevel")
    ONE_LEVEL,
    /**
     * Return the specified item and its direct children, as well as recursive chains of nested child
     * folders that only contain a single folder.
     */
    @JsonProperty("oneLevelPlusNestedEmptyFolders")
    ONE_LEVEL_PLUS_NESTED_EMPTY_FOLDERS;

    public String getValue() {
        return this.name().replaceAll("_", "").toLowerCase();
    }
}
