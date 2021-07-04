package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlementsResponse {
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    @JsonProperty("operationResult")
    private UserEntitlementOperationResult operationResult;
    @JsonProperty("userEntitlement")
    private UserEntitlement userEntitlement;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public UserEntitlementOperationResult getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(UserEntitlementOperationResult operationResult) {
        this.operationResult = operationResult;
    }

    public UserEntitlement getUserEntitlement() {
        return userEntitlement;
    }

    public void setUserEntitlement(UserEntitlement userEntitlement) {
        this.userEntitlement = userEntitlement;
    }

    @Override
    public String toString() {
        return "UserEntitlementsPostResponse{" +
                "isSuccess=" + isSuccess +
                ", operationResult=" + operationResult +
                ", userEntitlement=" + userEntitlement +
                '}';
    }
}
