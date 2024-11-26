package org.azd.enums;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User status in the account 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public enum AccountUserStatus {
	/**
 	* User has signed in at least once to the VSTS account 
	**/
	@JsonProperty("active")
	ACTIVE,
	/**
 	* User is removed from the VSTS account by the VSTS account admin 
	**/
	@JsonProperty("deleted")
	DELETED,
	/**
 	* User cannot sign in; primarily used by admin to temporarily remove a user due to absence or license reallocation 
	**/
	@JsonProperty("disabled")
	DISABLED,
	/**
 	* User can sign in; primarily used when license is in expired state and we give a grace period 
	**/
	@JsonProperty("expired")
	EXPIRED,

	@JsonProperty("none")
	NONE,
	/**
 	* User is invited to join the VSTS account by the VSTS account admin, but has not signed up/signed in yet 
	**/
	@JsonProperty("pending")
	PENDING,
	/**
 	* User is disabled; if reenabled, they will still be in the Pending state 
	**/
	@JsonProperty("pendingDisabled")
	PENDING_DISABLED
}