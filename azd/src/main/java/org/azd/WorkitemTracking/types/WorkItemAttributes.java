package org.azd.WorkitemTracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemAttributes {
    @JsonProperty("isLocked")
    private boolean isLocked;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("name")
    private String name;
    @JsonProperty("authorizedDate")
    private String authorizedDate;
    @JsonProperty("id")
    private int id;
    @JsonProperty("resourceCreatedDate")
    private String resourceCreatedDate;
    @JsonProperty("revisedDate")
    private String revisedDate;

    @Override
    public String toString() {
        return "WorkItemAttributes{" +
                "isLocked=" + isLocked +
                ", comment='" + comment + '\'' +
                ", name='" + name + '\'' +
                ", authorizedDate='" + authorizedDate + '\'' +
                ", id=" + id +
                ", resourceCreatedDate='" + resourceCreatedDate + '\'' +
                ", resourceModifiedDate='" + resourceModifiedDate + '\'' +
                ", revisedDate='" + revisedDate + '\'' +
                '}';
    }

    @JsonProperty("resourceModifiedDate")
    private String resourceModifiedDate;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(String authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceCreatedDate() {
        return resourceCreatedDate;
    }

    public void setResourceCreatedDate(String resourceCreatedDate) {
        this.resourceCreatedDate = resourceCreatedDate;
    }

    public String getResourceModifiedDate() {
        return resourceModifiedDate;
    }

    public void setResourceModifiedDate(String resourceModifiedDate) {
        this.resourceModifiedDate = resourceModifiedDate;
    }

    public String getRevisedDate() {
        return revisedDate;
    }

    public void setRevisedDate(String revisedDate) {
        this.revisedDate = revisedDate;
    }
}
