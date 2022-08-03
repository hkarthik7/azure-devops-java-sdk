package org.azd.feedmanagement.types;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.FeedRole;

/**
 * Permissions for a feed. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedPermission extends BaseAbstractMethod {
	/**
 	* Display name for the identity. 
	**/
	@JsonProperty("displayName")
	private String displayName;
	/**
 	* Identity associated with this role. 
	**/
	@JsonProperty("identityDescriptor")
	private String identityDescriptor;
	/**
 	* Id of the identity associated with this role. 
	**/
	@JsonProperty("identityId")
	private String identityId;
	/**
 	* boolean indicating whether the role is inherited or set directly.
	**/
	@JsonProperty("isInheritedRole")
	private boolean isInheritedRole;
	/**
 	* The role for this identity on a feed. 
	**/
	@JsonProperty("role")
	private FeedRole role;

	public String getDisplayName() { return displayName; }

	public void setDisplayName(String displayName) { this.displayName = displayName; }

	public String getIdentityDescriptor() { return identityDescriptor; }

	public void setIdentityDescriptor(String identityDescriptor) { this.identityDescriptor = identityDescriptor; }

	public String getIdentityId() { return identityId; }

	public void setIdentityId(String identityId) { this.identityId = identityId; }

	public boolean getIsInheritedRole() { return isInheritedRole; }

	public void setIsInheritedRole(boolean isInheritedRole) { this.isInheritedRole = isInheritedRole; }

	public FeedRole getRole() { return role; }

	public void setRole(FeedRole role) { this.role = role; }

}
