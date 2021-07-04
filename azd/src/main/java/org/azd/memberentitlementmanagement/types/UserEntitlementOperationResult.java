package org.azd.memberentitlementmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntitlementOperationResult {
    @JsonProperty("errors")
    private Object[] errors;
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    @JsonProperty("result")
    private UserEntitlement result;
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

    @Override
    public String toString() {
        return "UserEntitlementOperationResult{" +
                "errors=" + Arrays.toString(errors) +
                ", isSuccess=" + isSuccess +
                ", result=" + result +
                ", userId='" + userId + '\'' +
                '}';
    }
}
