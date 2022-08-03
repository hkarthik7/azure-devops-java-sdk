package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Reference to a field in a work item
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemFieldReference extends BaseAbstractMethod {
    /***
     * The friendly name of the field.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The reference name of the field.
     */
    @JsonProperty("referenceName")
    private String referenceName;
    /***
     * The REST URL of the resource.
     */
    @JsonProperty("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
