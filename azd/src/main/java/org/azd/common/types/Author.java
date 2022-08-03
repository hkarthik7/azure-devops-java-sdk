package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents the identity of an user object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author extends BaseAbstractMethod {
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
     * This field contains zero or more interesting links about the graph subject.
     * These links may be invoked to obtain additional relationships or more detailed information about this graph subject.
     */
    @JsonProperty("_links")
    private Object _links;
    /***
     * Unique Id
     */
    @JsonProperty("id")
    private String id;
    /***
     * Unique name
     */
    @JsonProperty("uniqueName")
    private String uniqueName;
    /***
     * Link to image
     */
    @JsonProperty("imageUrl")
    private String imageUrl;
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

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}
