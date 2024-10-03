package org.azd.workitemtracking.types;
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
 * Describes response to delete a set of work items. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemDeleteBatch extends SerializableEntity {
	/**
 	* List of results for each work item 
	**/
	@JsonProperty("results")
	private List<WorkItemDelete> results;

	public List<WorkItemDelete> getResults() { return results; }

	public void setResults(List<WorkItemDelete> results) { this.results = results; }

}