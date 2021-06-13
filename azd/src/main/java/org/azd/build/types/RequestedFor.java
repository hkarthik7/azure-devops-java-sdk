package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

    @JsonIgnoreProperties(ignoreUnknown = true)
public class RequestedFor {
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("url")
    private String url;
    @JsonProperty("id")
    private String id;
    @JsonProperty("uniqueName")
    private String uniqueName;
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

    @Override
    public String toString() {
        return "RequestedFor{" +
                "displayName='" + displayName + '\'' +
                ", url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", uniqueName='" + uniqueName + '\'' +
                ", descriptor='" + descriptor + '\'' +
                '}';
    }
}
