package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.definitions.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BuildDefinitionRevision {
    @JsonProperty("revision")
    private int revision;
    @JsonProperty("name")
    private String name;
    @JsonProperty("changedDate")
    private String changedDate;
    @JsonProperty("changeType")
    private String changeType;
    @JsonProperty("definitionUrl")
    private String definitionUrl;
    @JsonProperty("changedBy")
    private Author changedBy;

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getDefinitionUrl() {
        return definitionUrl;
    }

    public void setDefinitionUrl(String definitionUrl) {
        this.definitionUrl = definitionUrl;
    }

    public Author getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Author changedBy) {
        this.changedBy = changedBy;
    }

    @Override
    public String toString() {
        return "BuildDefinitionRevision{" +
                "revision=" + revision +
                ", name='" + name + '\'' +
                ", changedDate='" + changedDate + '\'' +
                ", changeType='" + changeType + '\'' +
                ", definitionUrl='" + definitionUrl + '\'' +
                ", changedBy=" + changedBy +
                '}';
    }
}
