package org.azd.enums;

/**
 * What Git history mode should be used. This only applies to the search criteria when Ids = null and an itemPath is specified.
 */
public enum GitHistoryMode {
    /**
     * The history mode used by git log --first-parent
     */
    FIRSTPARENT,
    /**
     * The history mode used by git log --full-history
     */
    FULLHISTORY,
    /**
     * The history mode used by git log --full-history --simplify-merges
     */
    FULLHISTORYSIMPLIFYMERGES,
    /**
     * The history mode used by git log. This is the default.
     */
    SIMPLIFIEDHISTORY;
}
