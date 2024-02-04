package org.azd.memberentitlementmanagement.types;
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
 * Type of MSDN License (e.g. Visual Studio Professional, Visual Studio Enterprise etc.). To use the MsdnLicenseType, LicensingSource should be defined as 'msdn' in the request body. 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupOperationResult extends SerializableEntity {
	/**
 	* List of error codes paired with their corresponding error messages 
	**/
	@JsonProperty("errors")
	private List<Object> errors;
	/**
 	* Identifier of the Group being acted upon 
	**/
	@JsonProperty("groupId")
	private String groupId;
	/**
 	* Success status of the operation 
	**/
	@JsonProperty("isSuccess")
	private boolean isSuccess;
	/**
 	* Result of the Groupentitlement after the operation 
	**/
	@JsonProperty("result")
	private GroupEntitlement result;

	public List<Object> getErrors() { return errors; }

	public void setErrors(List<Object> errors) { this.errors = errors; }

	public String getGroupId() { return groupId; }

	public void setGroupId(String groupId) { this.groupId = groupId; }

	public boolean getIsSuccess() { return isSuccess; }

	public void setIsSuccess(boolean isSuccess) { this.isSuccess = isSuccess; }

	public GroupEntitlement getResult() { return result; }

	public void setResult(GroupEntitlement result) { this.result = result; }

}