package org.azd.enums;

/***
 * The role for this identity on a feed.
 */
public enum FeedRole {
    /***
     * Administrators have total control over the feed.
     */
    ADMINISTRATOR,
    /***
     * Collaborators have the same permissions as readers, but can also ingest packages from configured upstream sources.
     */
    COLLABORATOR,
    /***
     * Contributors can do anything to packages in the feed including adding new packages, but they may not modify feed settings.
     */
    CONTRIBUTOR,
    /***
     * Readers can only read packages and view settings.
     */
    READER
}
