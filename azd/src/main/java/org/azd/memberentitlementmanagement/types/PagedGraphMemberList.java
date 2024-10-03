package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * A page of users
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagedGraphMemberList extends SerializableEntity {
    /**
     * A user entity with additional properties including their license, extensions, and project membership
     */
    @JsonProperty("members")
    private List<UserEntitlement> members;
    @JsonProperty("continuationToken")
    private String continuationToken;
    @JsonProperty("totalCount")
    private int totalCount;
    @JsonProperty("items")
    private List<UserEntitlement> users;

    public List<UserEntitlement> getMembers() {
        return members;
    }

    public void setMembers(List<UserEntitlement> members) {
        this.members = members;
    }

    public String getContinuationToken() {
        return continuationToken;
    }

    public void setContinuationToken(String continuationToken) {
        this.continuationToken = continuationToken;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<UserEntitlement> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntitlement> users) {
        this.users = users;
    }
}
