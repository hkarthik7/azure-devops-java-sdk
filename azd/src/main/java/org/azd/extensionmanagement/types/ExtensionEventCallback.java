package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Base class for an event callback for an extension
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtensionEventCallback extends BaseAbstractMethod {
    /***
     * The uri of the endpoint that is hit when an event occurs
     */
    @JsonProperty("uri")
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}
