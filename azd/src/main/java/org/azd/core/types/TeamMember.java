package org.azd.core.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.serializer.SerializableEntity;
import org.azd.common.types.Author;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamMember extends SerializableEntity {

	@JsonProperty("identity")
	private Author identity;

	@JsonProperty("isTeamAdmin")
	private boolean isTeamAdmin;

	public Author getIdentity() { return identity; }

	public void setIdentity(Author identity) { this.identity = identity; }

	public boolean getIsTeamAdmin() { return isTeamAdmin; }

	public void setIsTeamAdmin(boolean isTeamAdmin) { this.isTeamAdmin = isTeamAdmin; }

}