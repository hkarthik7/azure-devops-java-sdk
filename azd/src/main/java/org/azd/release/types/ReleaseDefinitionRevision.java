package org.azd.release.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReleaseDefinitionRevision {
    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("changeType")
    private String changeType;
    @JsonProperty("changedBy")
    private Author changedBy;
    @JsonProperty("changedDate")
    private String changedDate;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("definitionId")
    private int definitionId;
    @JsonProperty("definitionUrl")
    private String definitionUrl;
    @JsonProperty("revision")
    private int revision;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public Author getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Author changedBy) {
        this.changedBy = changedBy;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(int definitionId) {
        this.definitionId = definitionId;
    }

    public String getDefinitionUrl() {
        return definitionUrl;
    }

    public void setDefinitionUrl(String definitionUrl) {
        this.definitionUrl = definitionUrl;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    @Override
    public String toString() {
        return "ReleaseDefinitionRevision{" +
                "apiVersion='" + apiVersion + '\'' +
                ", changeType='" + changeType + '\'' +
                ", changedBy=" + changedBy +
                ", changedDate='" + changedDate + '\'' +
                ", comment='" + comment + '\'' +
                ", definitionId=" + definitionId +
                ", definitionUrl='" + definitionUrl + '\'' +
                ", revision=" + revision +
                '}';
    }
}
