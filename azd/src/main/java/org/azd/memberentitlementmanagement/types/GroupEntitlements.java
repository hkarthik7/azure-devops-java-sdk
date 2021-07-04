package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupEntitlements {
    @JsonProperty("value")
    private List<GroupEntitlement> GroupEntitlements;

    public List<GroupEntitlement> getGroupEntitlements() {
        return GroupEntitlements;
    }

    public void setGroupEntitlements(List<GroupEntitlement> groupEntitlements) {
        GroupEntitlements = groupEntitlements;
    }

    @Override
    public String toString() {
        return "GroupEntitlements{" +
                "GroupEntitlements=" + GroupEntitlements +
                '}';
    }
}
