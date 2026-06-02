package org.azd.dashboard.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * Describes a list of dashboards associated to an owner. Currently, teams own dashboard groups.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardGroup extends SerializableEntity {
    /**
     * A list of Dashboards held by the Dashboard Group.
     */
    @JsonProperty("dashboardEntries")
    private List<Dashboard> dashboardEntries;
    /**
     * Deprecated: The old permission model describing the level of permissions for the current team.
     */
    @JsonProperty("permission")
    private String permission;
    /**
     * A permissions bit mask describing the security permissions of the current team for dashboards.
     */
    @JsonProperty("teamDashboardPermission")
    private String teamDashboardPermission;
    /**
     * URL
     */
    @JsonProperty("url")
    private String url;
    /**
     * Links
     */
    @JsonProperty("_links")
    private Object links;

    public List<Dashboard> getDashboardEntries() {
        return dashboardEntries;
    }

    public void setDashboardEntries(List<Dashboard> dashboardEntries) {
        this.dashboardEntries = dashboardEntries;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getTeamDashboardPermission() {
        return teamDashboardPermission;
    }

    public void setTeamDashboardPermission(String teamDashboardPermission) {
        this.teamDashboardPermission = teamDashboardPermission;
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
}
