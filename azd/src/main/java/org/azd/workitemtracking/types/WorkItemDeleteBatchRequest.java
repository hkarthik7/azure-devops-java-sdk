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
 * Describes a request to delete a set of work items 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemDeleteBatchRequest {
	/**
 	* Optional parameter, if set to true, the work item is deleted permanently. Please note: the destroy action is PERMANENT and cannot be undone. 
	**/
	@JsonProperty("destroy")
	public Boolean destroy;
	/**
 	* The requested work item ids 
	**/
	@JsonProperty("ids")
	public List<Integer> ids;
	/**
 	* Optional parameter, if set to true, notifications will be disabled. 
	**/
	@JsonProperty("skipNotifications")
	public Boolean skipNotifications;
}