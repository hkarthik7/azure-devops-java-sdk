package org.azd.work.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Contains reference to a work item.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemReference extends BaseAbstractMethod {
    /***
     * Work item ID.
     */
    @JsonProperty("id")
    private String id;
    /***
     * REST API URL of the resource
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
