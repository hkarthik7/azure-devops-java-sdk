package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents any workitems associated with a build
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildWorkItem extends BaseAbstractMethod {
    /***
     * Workitem Id
     */
    @JsonProperty("id")
    private String id;
    /***
     * Workitem url
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
