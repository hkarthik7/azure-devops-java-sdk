package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents an installation issue
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstalledExtensionStateIssue extends BaseAbstractMethod {
    /***
     * The error message
     */
    @JsonProperty("message")
    private String message;
    /***
     * Source of the installation issue, for example "Demands"
     */
    @JsonProperty("source")
    private String source;
    /***
     * Installation issue type (Warning, Error)
     */
    @JsonProperty("type")
    private String type;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
