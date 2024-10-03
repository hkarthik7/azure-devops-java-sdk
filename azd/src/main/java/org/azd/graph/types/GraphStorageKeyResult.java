package org.azd.graph.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

/**
 * Storage key of a Graph entity 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphStorageKeyResult extends SerializableEntity {
	/**
 	* This field contains zero or more interesting links about the graph storage key.
	 * These links may be invoked to obtain additional relationships or more detailed information about this graph storage key.
	**/
	@JsonProperty("_links")
	private Object _links;
	/**
	 * Represents the storage key
	 */
	@JsonProperty("value")
	private String value;

	public Object get_links() { return _links; }

	public void set_links(Object _links) { this._links = _links; }

	public String getValue() { return value; }

	public void setValue(String value) { this.value = value; }

}