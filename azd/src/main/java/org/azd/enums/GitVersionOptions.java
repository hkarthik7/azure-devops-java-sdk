package org.azd.enums;

/**
 * Version options - Specify additional modifiers to version (e.g Previous)
 */
public enum GitVersionOptions {
    /**
     * First parent of commit (HEAD^)
     */
    FIRSTPARENT,

    /**
     * Commit that changed item prior to the current version
     */
    PREVIOUSCHANGE
}
