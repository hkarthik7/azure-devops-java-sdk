package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Represents an user object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestedFor extends BaseAbstractMethod {
    /***
     * This is the non-unique display name of the graph subject. To change this field, you must alter its value in the source provider.
     */
    @JsonProperty("displayName")
    private String displayName;
    /***
     * This url is the full route to the source resource of this graph subject.
     */
    @JsonProperty("url")
    private String url;
    /***
     * Unique id
     */
    @JsonProperty("id")
    private String id;
    /***
     * Unique name
     */
    @JsonProperty("uniqueName")
    private String uniqueName;
    /***
     * The descriptor is the primary way to reference the graph subject while the system is running.
     * This field will uniquely identify the same graph subject across both Accounts and Organizations.
     */
    @JsonProperty("descriptor")
    private String descriptor;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

}
