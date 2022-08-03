package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * List of issues occurred while execution of task.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issues extends BaseAbstractMethod {
    /***
     * Issue data.
     */
    @JsonProperty("data")
    private Object data;
    /***
     * Issue type, for example error, warning or info.
     */
    @JsonProperty("issueType")
    private String issueType;
    /***
     * Issue message.
     */
    @JsonProperty("message")
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
