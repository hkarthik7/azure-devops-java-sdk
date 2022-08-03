package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Reference for an async operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationReference extends BaseAbstractMethod {
    /***
     * Unique identifier for the operation.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The current status of the operation.
     */
    @JsonProperty("status")
    private String status;
    /***
     * URL to get the full operation object.
     */
    @JsonProperty("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
