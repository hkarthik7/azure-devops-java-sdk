package org.azd.graph.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.Reference;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphReferenceLinks {
    @JsonProperty("self")
    private Reference self;
    @JsonProperty("memberships")
    private Reference memberships;
    @JsonProperty("membershipState")
    private Reference membershipState;
    @JsonProperty("storageKey")
    private Reference storageKey;

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

    @Override
    public String toString() {
        return "GraphReferenceLinks{" +
                "self=" + self +
                ", memberships=" + memberships +
                ", membershipState=" + membershipState +
                ", storageKey=" + storageKey +
                '}';
    }
}
