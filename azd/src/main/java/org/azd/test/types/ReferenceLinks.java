package org.azd.test.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * Reference to a release. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReferenceLinks extends BaseAbstractMethod {
	/**
 	* The readonly view of the links.  Because Reference links are readonly, we only want to expose them as read only. 
	**/
	@JsonProperty("links")
	private Object links;

	public Object getLinks() { return links; }

	public void setLinks(Object links) { this.links = links; }

}