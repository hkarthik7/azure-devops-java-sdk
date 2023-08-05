package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * List of group entitlement
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupEntitlements extends SerializableEntity {
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

}
