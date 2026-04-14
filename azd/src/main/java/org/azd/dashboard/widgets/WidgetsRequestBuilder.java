package org.azd.dashboard.widgets;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.dashboard.types.Widget;
import org.azd.dashboard.types.WidgetList;
import org.azd.exceptions.AzDException;
import org.azd.helpers.URLHelper;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Dashboard widgets Api.
 */
public class WidgetsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WidgetsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "Dashboard", "bdcff53a-8355-4172-a00a-40497ea23afc",
                ApiVersion.DASHBOARD_WIDGET);
    }

    /**
     * Create a widget on the specified dashboard.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of dashboard the widget will be added to.
     * @param widget      State of the widget to add.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Widget> createAsync(String team, String dashboardId, Widget widget) throws AzDException {
        return builder()
                .POST(widget)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .executeAsync(Widget.class);
    }

    /**
     * Delete the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to delete.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String team, String dashboardId, String widgetId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get the current state of the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to read.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Widget> getAsync(String team, String dashboardId, String widgetId) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .executeAsync(Widget.class);
    }

    /**
     * Get widgets contained on the specified dashboard.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard to read.
     * @return WidgetList {@link WidgetList}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WidgetList> listAsync(String team, String dashboardId) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .executeAsync(WidgetList.class);
    }

    /**
     * Override the state of the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to update.
     * @param widget      State to be written for the widget.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Widget> replaceAsync(String team, String dashboardId, String widgetId, Widget widget) throws AzDException {
        return builder()
                .PUT(widget)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .executeAsync(Widget.class);
    }

    /**
     * Perform a partial update of the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to update.
     * @param widget      Description of the widget changes to apply.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Widget> updateAsync(String team, String dashboardId, String widgetId, Widget widget) throws AzDException {
        return builder()
                .PATCH(widget)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .executeAsync(Widget.class);
    }

    /**
     * Create a widget on the specified dashboard.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of dashboard the widget will be added to.
     * @param widget      State of the widget to add.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public Widget create(String team, String dashboardId, Widget widget) throws AzDException {
        return builder()
                .POST(widget)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .execute(Widget.class);
    }

    /**
     * Delete the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to delete.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String team, String dashboardId, String widgetId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .executePrimitive();
    }

    /**
     * Get the current state of the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to read.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public Widget get(String team, String dashboardId, String widgetId) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .execute(Widget.class);
    }

    /**
     * Get widgets contained on the specified dashboard.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard to read.
     * @return WidgetList {@link WidgetList}
     * @throws AzDException Default Api Exception handler.
     */
    public WidgetList list(String team, String dashboardId) throws AzDException {
        return builder()
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .build()
                .execute(WidgetList.class);
    }

    /**
     * Override the state of the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to update.
     * @param widget      State to be written for the widget.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public Widget replace(String team, String dashboardId, String widgetId, Widget widget) throws AzDException {
        return builder()
                .PUT(widget)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .execute(Widget.class);
    }

    /**
     * Perform a partial update of the specified widget.
     *
     * @param team        Team name or ID.
     * @param dashboardId ID of the dashboard containing the widget.
     * @param widgetId    ID of the widget to update.
     * @param widget      Description of the widget changes to apply.
     * @return Widget object {@link Widget}
     * @throws AzDException Default Api Exception handler.
     */
    public Widget update(String team, String dashboardId, String widgetId, Widget widget) throws AzDException {
        return builder()
                .PATCH(widget)
                .serviceEndpoint("team", URLHelper.encodeSpecialWithSpace(team))
                .serviceEndpoint("dashboardId", dashboardId)
                .serviceEndpoint("widgetId", widgetId)
                .build()
                .execute(Widget.class);
    }
}
