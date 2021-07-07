package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamProjectReference {
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("defaultTeamImageUrl")
    private String defaultTeamImageUrl;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private String id;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("name")
    private String name;
    @JsonProperty("revision")
    private String revision;
    @JsonProperty("state")
    private String state;
    @JsonProperty("url")
    private String url;
    @JsonProperty("visibility")
    private String visibility;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDefaultTeamImageUrl() {
        return defaultTeamImageUrl;
    }

    public void setDefaultTeamImageUrl(String defaultTeamImageUrl) {
        this.defaultTeamImageUrl = defaultTeamImageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "TeamProjectReference{" +
                "abbreviation='" + abbreviation + '\'' +
                ", defaultTeamImageUrl='" + defaultTeamImageUrl + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                ", name='" + name + '\'' +
                ", revision='" + revision + '\'' +
                ", state='" + state + '\'' +
                ", url='" + url + '\'' +
                ", visibility='" + visibility + '\'' +
                '}';
    }
}
