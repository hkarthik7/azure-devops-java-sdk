package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents the result after adding a user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlementOperationResult extends BaseAbstractMethod {
    /***
     * Array of errors if any
     */
    @JsonProperty("errors")
    private Object[] errors;
    /***
     * Success status of the operation.
     */
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    /***
     * Result of the MemberEntitlement after the operation
     */
    @JsonProperty("result")
    private UserEntitlement result;
    /***
     * Identifier of the Member being acted upon.
     */
    @JsonProperty("userId")
    private String userId;

    public Object[] getErrors() {
        return errors;
    }

    public void setErrors(Object[] errors) {
        this.errors = errors;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public UserEntitlement getResult() {
        return result;
    }

    public void setResult(UserEntitlement result) {
        this.result = result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
