package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/***
 * A page of users
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagedGraphMemberList extends SerializableEntity {
    /***
     * A user entity with additional properties including their license, extensions, and project membership
     */
    @JsonProperty("members")
    private List<UserEntitlement> members;

    public List<UserEntitlement> getMembers() {
        return members;
    }

    public void setMembers(List<UserEntitlement> members) {
        this.members = members;
    }

}
