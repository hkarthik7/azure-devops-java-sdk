package org.azd.enums;

/**
 * Version type (branch, tag, or commit). Determines how Id is interpreted
 */
public enum GitVersionType {
    /**
     * Interpret the version as a branch name
     */
    BRANCH,
    /**
     * Interpret the version as a commit ID (SHA1)
     */
    COMMIT,
    /**
     * Interpret the version as a tag name
     */
    TAG
}
