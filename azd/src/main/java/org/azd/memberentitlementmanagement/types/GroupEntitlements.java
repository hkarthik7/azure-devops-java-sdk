package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/***
 * List of group entitlement
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupEntitlements {
    /***
     * List of group entitlement
     */
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
