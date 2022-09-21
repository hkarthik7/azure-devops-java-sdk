package org.azd.enums;
/**
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
**/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Status of the git asynchronous operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum GitAsyncOperationStatus {
	/**
 	* The operation has been abandoned.
	**/
	@JsonProperty("abandoned")
	ABANDONED,
	/**
 	* The operation has completed.
	**/
	@JsonProperty("completed")
	COMPLETED,
	/**
 	* The operation has failed. Check for an error message.
	**/
	@JsonProperty("failed")
	FAILED,
	/**
 	* The operation is currently in progress.
	**/
	@JsonProperty("inProgress")
	INPROGRESS,
	/**
 	* The operation is waiting in a queue and has not yet started.
	**/
	@JsonProperty("queued")
	QUEUED;
}