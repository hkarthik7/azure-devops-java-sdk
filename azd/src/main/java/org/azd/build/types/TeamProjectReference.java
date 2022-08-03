package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ProjectState;
import org.azd.enums.ProjectVisibility;

/**
 * None 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamProjectReference extends BaseAbstractMethod {
    /**
     * Project abbreviation.
     **/
    @JsonProperty("abbreviation")
    private String abbreviation;
    /**
     * Url to default team identity image.
     **/
    @JsonProperty("defaultTeamImageUrl")
    private String defaultTeamImageUrl;
    /**
     * The project's description (if any).
     **/
    @JsonProperty("description")
    private String description;
    /**
     * Project identifier.
     **/
    @JsonProperty("id")
    private String id;
    /**
     * Project last update time.
     **/
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    /**
     * Project name.
     **/
    @JsonProperty("name")
    private String name;
    /**
     * Project revision.
     **/
    @JsonProperty("revision")
    private Integer revision;
    /**
     * Project state.
     **/
    @JsonProperty("state")
    private ProjectState state;
    /**
     * Url to the full version of the object.
     **/
    @JsonProperty("url")
    private String url;
    /**
     * Project visibility.
     **/
    @JsonProperty("visibility")
    private ProjectVisibility visibility;

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

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public ProjectState getState() {
        return state;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProjectVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(ProjectVisibility visibility) {
        this.visibility = visibility;
    }

}
