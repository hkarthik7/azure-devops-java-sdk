package org.azd.artifacts.feedmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpstreamSources {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("location")
    private String location;
    @JsonProperty("displayLocation")
    private String displayLocation;
    @JsonProperty("upstreamSourceType")
    private String upstreamSourceType;
    @JsonProperty("status")
    private String status;

    @Override
    public String toString() {
        return "UpstreamSources{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", protocol='" + protocol + '\'' +
                ", location='" + location + '\'' +
                ", displayLocation='" + displayLocation + '\'' +
                ", upstreamSourceType='" + upstreamSourceType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public String getUpstreamSourceType() {
        return upstreamSourceType;
    }

    public void setUpstreamSourceType(String upstreamSourceType) {
        this.upstreamSourceType = upstreamSourceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
