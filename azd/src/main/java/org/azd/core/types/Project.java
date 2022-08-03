package org.azd.core.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.enums.ProjectState;
import org.azd.enums.ProjectVisibility;

/***
 * Represents a Team Project object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project extends BaseAbstractMethod {
    /**
     * Reference links
     */
    @JsonProperty("_links")
    private Object _links;
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
    private ProjectState state;
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
    private ProjectVisibility visibility;
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

    public ProjectState getState() {
        return state;
    }

    public void setState(ProjectState state) {
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

    public ProjectVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(ProjectVisibility visibility) {
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

    public Object get_links() {
        return _links;
    }

    public void set_links(Object _links) {
        this._links = _links;
    }

}
