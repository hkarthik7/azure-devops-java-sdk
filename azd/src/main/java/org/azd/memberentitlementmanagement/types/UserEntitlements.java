package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;

import java.util.List;

/***
 * List of user entitlement
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlements extends SerializableEntity {
    /***
     * List of user entitlement
     */
    @JsonProperty("value")
    private List<UserEntitlement> userEntitlements;

    public List<UserEntitlement> getUserEntitlements() {
        return userEntitlements;
    }

    public void setUserEntitlements(List<UserEntitlement> userEntitlements) {
        this.userEntitlements = userEntitlements;
    }

}
