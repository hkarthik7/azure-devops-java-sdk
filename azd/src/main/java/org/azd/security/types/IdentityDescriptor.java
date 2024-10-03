package org.azd.security.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * An Identity descriptor is a wrapper for the identity type (Windows SID, Passport) along with a unique identifier such as the SID or PUID. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityDescriptor extends SerializableEntity {
	/**
 	* The unique identifier for this identity, not exceeding 256 chars, which will be persisted. 
	**/
	@JsonProperty("identifier")
	private String identifier;
	/**
 	* Type of descriptor (for example, Windows, Passport, etc.). 
	**/
	@JsonProperty("identityType")
	private String identityType;

	public String getIdentifier() { return identifier; }

	public void setIdentifier(String identifier) { this.identifier = identifier; }

	public String getIdentityType() { return identityType; }

	public void setIdentityType(String identityType) { this.identityType = identityType; }

}