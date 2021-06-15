package org.azd.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedPermission {
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("identityDescriptor")
    private String identityDescriptor;
    @JsonProperty("identityId")
    private String identityId;
    @JsonProperty("isInheritedRole")
    private boolean isInheritedRole;
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
