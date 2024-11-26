package org.azd.graph.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Batching of subjects to lookup using the Graph API 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphSubjectLookup extends SerializableEntity {

	/**
	 * Collection of descriptors to lookup
	 */
	@JsonProperty("lookupKeys")
	private List<GraphSubjectLookupKey> lookupKeys;

	public List<GraphSubjectLookupKey> getLookupKeys() { return lookupKeys; }

	public void setLookupKeys(List<GraphSubjectLookupKey> lookupKeys) { this.lookupKeys = lookupKeys; }

}