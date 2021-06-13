package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildController {
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("updatedDate")
    private String updatedDate;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("url")
    private String url;

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BuildController{" +
                "createdDate='" + createdDate + '\'' +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                ", uri='" + uri + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
