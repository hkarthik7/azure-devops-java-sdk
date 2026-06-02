package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Model of a Dashboard.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dashboard extends SerializableEntity {
    /**
     * ID of the Dashboard. Provided by service at creation time.
     */
    @JsonProperty("id")
    private String id;
    /**
     * Name of the Dashboard.
     */
    @JsonProperty("name")
    private String name;
    /**
     * Description of the dashboard.
     */
    @JsonProperty("description")
    private String description;
    /**
     * Server defined version tracking value, used for edit collision detection.
     */
    @JsonProperty("eTag")
    private String eTag;
    /**
     * ID of the Owner for a dashboard. For any legacy dashboards, this would be the unique
     * identifier for the team associated with the dashboard.
     */
    @JsonProperty("ownerId")
    private String ownerId;
    /**
     * ID of the group for a dashboard.
     */
    @JsonProperty("groupId")
    private String groupId;
    /**
     * Position of the dashboard, within a dashboard group. If unset at creation time,
     * position is decided by the service.
     */
    @JsonProperty("position")
    private Integer position;
    /**
     * Interval for client to automatically refresh the dashboard. Expressed in minutes.
     */
    @JsonProperty("refreshInterval")
    private Integer refreshInterval;
    /**
     * The set of Widgets on the dashboard.
     */
    @JsonProperty("widgets")
    private List<Widget> widgets;
    /**
     * Identifies the scope of dashboard storage and permissions.
     */
    @JsonProperty("dashboardScope")
    private String dashboardScope;
    /**
     * The URL of the dashboard.
     */
    @JsonProperty("url")
    private String url;
    /**
     * Links
     */
    @JsonProperty("_links")
    private Object links;
    /**
     * Modified date of the dashboard.
     */
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    /**
     * Modified by user ID.
     */
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    /**
     * Last accessed date of the dashboard.
     */
    @JsonProperty("lastAccessedDate")
    private String lastAccessedDate;

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

    public String getETag() {
        return eTag;
    }

    public void setETag(String eTag) {
        this.eTag = eTag;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(Integer refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }

    public String getDashboardScope() {
        return dashboardScope;
    }

    public void setDashboardScope(String dashboardScope) {
        this.dashboardScope = dashboardScope;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getLastAccessedDate() {
        return lastAccessedDate;
    }

    public void setLastAccessedDate(String lastAccessedDate) {
        this.lastAccessedDate = lastAccessedDate;
    }
}
