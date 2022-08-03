package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents the response after adding a user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlementsResponse extends BaseAbstractMethod {
    /***
     * True if all operations were successful.
     */
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    /***
     * Operation result.
     */
    @JsonProperty("operationResult")
    private UserEntitlementOperationResult operationResult;
    /***
     * Result of the user entitlement after the operations have been applied.
     */
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

}
