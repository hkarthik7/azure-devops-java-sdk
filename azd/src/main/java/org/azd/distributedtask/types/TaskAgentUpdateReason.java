package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Reason for this update.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAgentUpdateReason {
    /***
     * Code
     */
    @JsonProperty("code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TaskAgentUpdateReason{" +
                "code='" + code + '\'' +
                '}';
    }
}
