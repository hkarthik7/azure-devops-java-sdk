package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.common.types.Reference;

/***
 * This field contains zero or more interesting links about the graph subject.
 * These links may be invoked to obtain additional relationships or more detailed
 * information about this graph subject.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphReferenceLinks extends BaseAbstractMethod {
    /***
     * self reference url
     */
    @JsonProperty("self")
    protected Reference self;
    /***
     * Represents the ulr of membership API
     */
    @JsonProperty("memberships")
    protected Reference memberships;
    /***
     * Membership state url
     */
    @JsonProperty("membershipState")
    protected Reference membershipState;
    /***
     * Storage key url
     */
    @JsonProperty("storageKey")
    protected Reference storageKey;

    public Reference getSelf() {
        return self;
    }

    public void setSelf(Reference self) {
        this.self = self;
    }

    public Reference getMemberships() {
        return memberships;
    }

    public void setMemberships(Reference memberships) {
        this.memberships = memberships;
    }

    public Reference getMembershipState() {
        return membershipState;
    }

    public void setMembershipState(Reference membershipState) {
        this.membershipState = membershipState;
    }

    public Reference getStorageKey() {
        return storageKey;
    }

    public void setStorageKey(Reference storageKey) {
        this.storageKey = storageKey;
    }

}
