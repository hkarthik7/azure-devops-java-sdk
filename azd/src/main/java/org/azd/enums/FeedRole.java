package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * The role for this identity on a feed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum FeedRole {
    /***
     * Administrators have total control over the feed.
     */
    @JsonProperty("administrator")
    ADMINISTRATOR,
    /***
     * Collaborators have the same permissions as readers, but can also ingest packages from configured upstream sources.
     */
    @JsonProperty("collaborator")
    COLLABORATOR,
    /***
     * Contributors can do anything to packages in the feed including adding new packages, but they may not modify feed settings.
     */
    @JsonProperty("contributor")
    CONTRIBUTOR,
    /***
     * Readers can only read packages and view settings.
     */
    @JsonProperty("reader")
    READER
}
