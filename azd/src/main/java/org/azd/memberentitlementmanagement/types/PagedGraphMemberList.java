package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PagedGraphMemberList {
    @JsonProperty("members")
    private List<UserEntitlement> members;

    public List<UserEntitlement> getMembers() {
        return members;
    }

    public void setMembers(List<UserEntitlement> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "PagedGraphMemberList{" +
                "members=" + members +
                '}';
    }
}
