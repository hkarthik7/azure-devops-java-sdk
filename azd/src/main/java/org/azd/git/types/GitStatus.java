package org.azd.git.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitStatus {
    @JsonProperty("_links")
    private JsonNode _links;
    @JsonProperty("context")
    private GitStatusContext context;
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("creationDate")
    private String creationDate;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private int id;
    @JsonProperty("state")
    private String state;
    @JsonProperty("targetUrl")
    private String targetUrl;
    @JsonProperty("updatedDate")
    private String updatedDate;

    public JsonNode get_links() {
        return _links;
    }

    public void set_links(JsonNode _links) {
        this._links = _links;
    }

    public GitStatusContext getContext() {
        return context;
    }

    public void setContext(GitStatusContext context) {
        this.context = context;
    }

    public Author getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Author createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "GitStatus{" +
                "_links=" + _links +
                ", context=" + context +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", state='" + state + '\'' +
                ", targetUrl='" + targetUrl + '\'' +
                ", updatedDate='" + updatedDate + '\'' +
                '}';
    }
}
