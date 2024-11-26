package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.GroupType;

/**
 * A group entity with additional properties including its license, extensions, and project membership 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group extends SerializableEntity {
	/**
 	* Display Name of the Group 
	**/
	@JsonProperty("displayName")
	private String displayName;
	/**
 	* Group Type 
	**/
	@JsonProperty("groupType")
	private GroupType groupType;

	public String getDisplayName() { return displayName; }

	public void setDisplayName(String displayName) { this.displayName = displayName; }

	public GroupType getGroupType() { return groupType; }

	public void setGroupType(GroupType groupType) { this.groupType = groupType; }

}