package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Permissions for a feed.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedPermission {
    /***
     * Display name for the identity.
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * Identity associated with this role.
     */
    @JsonProperty("identityDescriptor")
    private String identityDescriptor;
    /***
     * Id of the identity associated with this role.
     */
    @JsonProperty("identityId")
    private String identityId;
    /***
     * Boolean indicating whether the role is inherited or set directly.
     */
    @JsonProperty("isInheritedRole")
    private boolean isInheritedRole;
    /***
     * The role for this identity on a feed.
     */
    @JsonProperty("role")
    private String role;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIdentityDescriptor() {
        return identityDescriptor;
    }

    public void setIdentityDescriptor(String identityDescriptor) {
        this.identityDescriptor = identityDescriptor;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public boolean isInheritedRole() {
        return isInheritedRole;
    }

    public void setInheritedRole(boolean inheritedRole) {
        isInheritedRole = inheritedRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "FeedPermission{" +
                "displayName='" + displayName + '\'' +
                ", identityDescriptor='" + identityDescriptor + '\'' +
                ", identityId='" + identityId + '\'' +
                ", isInheritedRole=" + isInheritedRole +
                ", role='" + role + '\'' +
                '}';
    }
}
