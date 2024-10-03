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
 * The class to represent a collection of REST reference links. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphSubjectLookupKey extends SerializableEntity {
	/**
	 * Default constructor
	 */
	public GraphSubjectLookupKey() { }

	/**
	 * Constructor with descriptor.
	 * @param descriptor Pass the group or users descriptor.
	 */
	public GraphSubjectLookupKey(String descriptor) {
		this.descriptor = descriptor;
	}

	/**
	 * Represents the groups or users descriptor.
	 */
	@JsonProperty("descriptor")
	private String descriptor;

	public String getDescriptor() { return descriptor; }

	public void setDescriptor(String descriptor) { this.descriptor = descriptor; }

}