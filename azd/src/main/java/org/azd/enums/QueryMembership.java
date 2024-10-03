package org.azd.enums;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The membership information to include with the identities. Values can be None for no membership data or
 * Direct to include the groups that the identity is a member of and the identities that are a member
 * of this identity (groups only)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum QueryMembership {
    /**
     * Query will return only direct membership data
     */
    @JsonProperty("direct")
    DIRECT,
    /**
     * Query will return expanded membership data
     */
    @JsonProperty("expanded")
    EXPANDED,
    /**
     * Query will return expanded down membership data (children only)
     */
    @JsonProperty("expandedDown")
    EXPANDED_DOWN,
    /**
     * Query will return expanded up membership data (parents only)
     */
    @JsonProperty("expandedUp")
    EXPANDED_UP,
    /**
     * Query will not return any membership data
     */
    @JsonProperty("none")
    NONE
}
