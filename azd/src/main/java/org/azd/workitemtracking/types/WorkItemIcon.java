package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Reference to a work item icon.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemIcon extends BaseAbstractMethod {
    /***
     * The identifier of the icon.
     */
    @JsonProperty("id")
    private String id;
    /***
     * The REST URL of the resource.
     */
    @JsonProperty("url")
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
