package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/***
 * Represents a Team Project object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    /***
     * Project identifier.
     */
    @JsonProperty("id")
    private String id;
    /***
     * Project name.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The project's description (if any).
     */
    @JsonProperty("description")
    private String description;
    /***
     * Url to the full version of the object.
     */
    @JsonProperty("url")
    private String url;
    /***
     * Project state.
     */
    @JsonProperty("state")
    private String state;
    /***
     * Set of capabilities this project has (such as process template & version control).
     */
    @JsonProperty("capabilities")
    private Capabilities capabilities;
    /***
     * Project revision.
     */
    @JsonProperty("revision")
    private int revision;
    /***
     * Project visibility.
     */
    @JsonProperty("visibility")
    private String visibility;
    /***
     * The ref to the default team.
     */
    @JsonProperty("defaultTeam")
    private Team defaultTeam;
    /***
     *
     * Project last update time.
     */
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Team getDefaultTeam() {
        return defaultTeam;
    }

    public void setDefaultTeam(Team defaultTeam) {
        this.defaultTeam = defaultTeam;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", state='" + state + '\'' +
                ", capabilities=" + capabilities +
                ", revision=" + revision +
                ", visibility='" + visibility + '\'' +
                ", defaultTeam=" + defaultTeam +
                ", lastUpdateTime='" + lastUpdateTime + '\'' +
                '}';
    }
}
