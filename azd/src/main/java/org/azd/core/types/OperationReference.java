package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.OperationStatus;
import org.azd.serializer.SerializableEntity;

/***
 * Reference for an async operation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperationReference extends SerializableEntity {
    /***
     * Unique identifier for the operation.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The current status of the operation.
     */
    @JsonProperty("status")
    private OperationStatus status;
    /***
     * URL to get the full operation object.
     */
    @JsonProperty("url")
    private String url;
    /**
     * Unique identifier for the plugin.
     */
    @JsonProperty("pluginId")
    private String pluginId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
