package org.azd.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("_links")
    private ReferenceLinks _links;
    @JsonProperty("id")
    private String id;
    @JsonProperty("uniqueName")
    private String uniqueName;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("descriptor")
    private String descriptor;

    @Override
    public String toString() {
        return "WorkItemUserDetails{" +
                "displayName='" + displayName + '\'' +
                ", url='" + url + '\'' +
                ", _links=" + _links +
                ", id='" + id + '\'' +
                ", uniqueName='" + uniqueName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", descriptor='" + descriptor + '\'' +
                '}';
    }

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

    public ReferenceLinks get_links() {
        return _links;
    }

    public void set_links(ReferenceLinks _links) {
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
