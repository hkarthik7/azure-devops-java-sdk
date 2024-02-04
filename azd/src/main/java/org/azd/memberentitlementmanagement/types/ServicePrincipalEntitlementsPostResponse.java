package org.azd.memberentitlementmanagement.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServicePrincipalEntitlementsPostResponse extends SerializableEntity {
	@JsonProperty("isSuccess")
	private boolean isSuccess;
	@JsonProperty("operationResult")
	private ServicePrincipalEntitlementOperationResult operationResult;
	@JsonProperty("servicePrincipalEntitlement")
	private ServicePrincipalEntitlement servicePrincipalEntitlement;

	public boolean getIsSuccess() { return isSuccess; }

	public void setIsSuccess(boolean isSuccess) { this.isSuccess = isSuccess; }

	public ServicePrincipalEntitlementOperationResult getOperationResult() { return operationResult; }

	public void setOperationResult(ServicePrincipalEntitlementOperationResult operationResult) { this.operationResult = operationResult; }

	public ServicePrincipalEntitlement getServicePrincipalEntitlement() { return servicePrincipalEntitlement; }

	public void setServicePrincipalEntitlement(ServicePrincipalEntitlement servicePrincipalEntitlement) { this.servicePrincipalEntitlement = servicePrincipalEntitlement; }

}