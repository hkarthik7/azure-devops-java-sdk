package org.azd.workitemtracking.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.enums.WorkItemErrorPolicy;
import org.azd.enums.WorkItemExpand;

import java.util.List;

/**
 * Describes a request to get a set of work items 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemBatchGetRequest {
	/**
 	* The expand parameters for work item attributes. Possible options are { None, Relations, Fields, Links, All } 
	**/
	@JsonProperty("$expand")
	public WorkItemExpand $expand;
	/**
 	* AsOf UTC date time string 
	**/
	@JsonProperty("asOf")
	public String asOf;
	/**
 	* The flag to control error policy in a bulk get work items request. Possible options are {Fail, Omit}. 
	**/
	@JsonProperty("errorPolicy")
	public WorkItemErrorPolicy errorPolicy;
	/**
 	* The requested fields 
	**/
	@JsonProperty("fields")
	public List<String> fields;
	/**
 	* The requested work item ids 
	**/
	@JsonProperty("ids")
	public List<Integer> ids;
}