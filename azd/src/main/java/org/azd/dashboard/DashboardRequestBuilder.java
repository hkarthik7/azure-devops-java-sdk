package org.azd.dashboard;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.dashboard.dashboards.DashboardsRequestBuilder;
import org.azd.dashboard.widgets.WidgetsRequestBuilder;
import org.azd.dashboard.widgettypes.WidgetTypesRequestBuilder;

/**
 * Provides functionality to work with Dashboard Api.
 */
public class DashboardRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DashboardRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Dashboard dashboards Api.
     *
     * @return DashboardsRequestBuilder {@link DashboardsRequestBuilder}
     */
    public DashboardsRequestBuilder dashboards() {
        return new DashboardsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Dashboard widgets Api.
     *
     * @return WidgetsRequestBuilder {@link WidgetsRequestBuilder}
     */
    public WidgetsRequestBuilder widgets() {
        return new WidgetsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to work with Dashboard widget types Api.
     *
     * @return WidgetTypesRequestBuilder {@link WidgetTypesRequestBuilder}
     */
    public WidgetTypesRequestBuilder widgetTypes() {
        return new WidgetTypesRequestBuilder(organizationUrl, accessTokenCredential);
    }
}
