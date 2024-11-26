package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * A user entity with additional properties including their license, extensions, and project membership 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLinks extends SerializableEntity {
	/**
 	* The readonly view of the links.  Because Reference links are readonly, we only want to expose them as read only. 
	**/
	@JsonProperty("links")
	private Object links;

	public Object getLinks() { return links; }

	public void setLinks(Object links) { this.links = links; }

}