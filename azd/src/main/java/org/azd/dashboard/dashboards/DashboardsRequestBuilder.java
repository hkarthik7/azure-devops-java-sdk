package org.azd.dashboard.dashboards;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.dashboard.types.Dashboard;
import org.azd.dashboard.types.DashboardGroup;
import org.azd.dashboard.types.DashboardList;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Dashboard dashboards Api.
 */
public class DashboardsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DashboardsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "Dashboard", "454b3e51-2e6e-48d4-ad81-978154089351",
                ApiVersion.DASHBOARD);
    }

    /**
     * Create the supplied dashboard.
     *
     * @param team      Team name or ID.
     * @param dashboard The initial state of the dashboard.
     * @return Dashboard object {@link Dashboard}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Dashboard> createAsync(String team, Dashboard dashboard) throws AzDException {
        return builder()
                .POST(dashboard)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(Dashboard.class);
    }

    /**
     * Delete a dashboard given its ID. This also deletes the widgets associated with this dashboard.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard to delete.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String team, String dashboardId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a dashboard by its ID.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard.
     * @return Dashboard object {@link Dashboard}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Dashboard> getAsync(String team, String dashboardId) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .executeAsync(Dashboard.class);
    }

    /**
     * Get a list of dashboards under a project for the specified team.
     *
     * @param team Team name or ID.
     * @return DashboardList {@link DashboardList}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DashboardList> listAsync(String team) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(DashboardList.class);
    }

    /**
     * Replace configuration for the specified dashboard. Replaces Widget list on Dashboard,
     * only if property is supplied.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard to replace.
     * @param dashboard   The configuration of the dashboard to replace.
     * @return Dashboard object {@link Dashboard}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Dashboard> replaceAsync(String team, String dashboardId, Dashboard dashboard) throws AzDException {
        return builder()
                .PUT(dashboard)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .executeAsync(Dashboard.class);
    }

    /**
     * Update the name and position of dashboards in the supplied group, and remove omitted dashboards.
     * Does not modify dashboard content.
     *
     * @param team  Team name or ID.
     * @param group Dashboard group.
     * @return DashboardGroup object {@link DashboardGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DashboardGroup> replaceDashboardsAsync(String team, DashboardGroup group) throws AzDException {
        return builder()
                .PUT(group)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .executeAsync(DashboardGroup.class);
    }

    /**
     * Create the supplied dashboard.
     *
     * @param team      Team name or ID.
     * @param dashboard The initial state of the dashboard.
     * @return Dashboard object {@link Dashboard}
     * @throws AzDException Default Api Exception handler.
     */
    public Dashboard create(String team, Dashboard dashboard) throws AzDException {
        return builder()
                .POST(dashboard)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(Dashboard.class);
    }

    /**
     * Delete a dashboard given its ID. This also deletes the widgets associated with this dashboard.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard to delete.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String team, String dashboardId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a dashboard by its ID.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard.
     * @return Dashboard object {@link Dashboard}
     * @throws AzDException Default Api Exception handler.
     */
    public Dashboard get(String team, String dashboardId) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .execute(Dashboard.class);
    }

    /**
     * Get a list of dashboards under a project for the specified team.
     *
     * @param team Team name or ID.
     * @return DashboardList {@link DashboardList}
     * @throws AzDException Default Api Exception handler.
     */
    public DashboardList list(String team) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(DashboardList.class);
    }

    /**
     * Replace configuration for the specified dashboard. Replaces Widget list on Dashboard,
     * only if property is supplied.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard to replace.
     * @param dashboard   The configuration of the dashboard to replace.
     * @return Dashboard object {@link Dashboard}
     * @throws AzDException Default Api Exception handler.
     */
    public Dashboard replace(String team, String dashboardId, Dashboard dashboard) throws AzDException {
        return builder()
                .PUT(dashboard)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .execute(Dashboard.class);
    }

    /**
     * Update the name and position of dashboards in the supplied group, and remove omitted dashboards.
     * Does not modify dashboard content.
     *
     * @param team  Team name or ID.
     * @param group Dashboard group.
     * @return DashboardGroup object {@link DashboardGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public DashboardGroup replaceDashboards(String team, DashboardGroup group) throws AzDException {
        return builder()
                .PUT(group)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .build()
                .execute(DashboardGroup.class);
    }
}
