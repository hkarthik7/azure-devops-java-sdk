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
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicePrincipalEntitlementOperationResult extends SerializableEntity {
	/**
 	* List of error codes paired with their corresponding error messages. 
	**/
	@JsonProperty("errors")
	private List<Object> errors;
	/**
 	* Success status of the operation. 
	**/
	@JsonProperty("isSuccess")
	private boolean isSuccess;
	/**
 	* Resulting entitlement property.  For specific implementations, see also: 
	**/
	@JsonProperty("result")
	private String result;
	/**
 	* Identifier of the ServicePrincipal being acted upon. 
	**/
	@JsonProperty("servicePrincipalId")
	private String servicePrincipalId;

	public List<Object> getErrors() { return errors; }

	public void setErrors(List<Object> errors) { this.errors = errors; }

	public boolean getIsSuccess() { return isSuccess; }

	public void setIsSuccess(boolean isSuccess) { this.isSuccess = isSuccess; }

	public String getResult() { return result; }

	public void setResult(String result) { this.result = result; }

	public String getServicePrincipalId() { return servicePrincipalId; }

	public void setServicePrincipalId(String servicePrincipalId) { this.servicePrincipalId = servicePrincipalId; }

}