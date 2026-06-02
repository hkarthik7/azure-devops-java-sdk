package org.azd.dashboard.widgettypes;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.dashboard.types.WidgetMetadataResponse;
import org.azd.dashboard.types.WidgetTypesResponse;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Dashboard widget types Api.
 */
public class WidgetTypesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public WidgetTypesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "Dashboard", "6b3628d3-e96f-4fc7-b176-50240b03b515",
                ApiVersion.DASHBOARD_WIDGET_TYPES);
    }

    /**
     * Get the widget metadata satisfying the specified contribution ID.
     *
     * @param contributionId The ID of Contribution for the Widget.
     * @return WidgetMetadataResponse object {@link WidgetMetadataResponse}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WidgetMetadataResponse> getMetadataAsync(String contributionId) throws AzDException {
        return builder()
                .serviceEndpoint("contributionId", contributionId)
                .build()
                .executeAsync(WidgetMetadataResponse.class);
    }

    /**
     * Get all available widget metadata in alphabetical order.
     *
     * @param scope Widget scope.
     * @return WidgetTypesResponse object {@link WidgetTypesResponse}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WidgetTypesResponse> listAsync(String scope) throws AzDException {
        return builder()
                .query("$scope", scope)
                .build()
                .executeAsync(WidgetTypesResponse.class);
    }

    /**
     * Get the widget metadata satisfying the specified contribution ID.
     *
     * @param contributionId The ID of Contribution for the Widget.
     * @return WidgetMetadataResponse object {@link WidgetMetadataResponse}
     * @throws AzDException Default Api Exception handler.
     */
    public WidgetMetadataResponse getMetadata(String contributionId) throws AzDException {
        return builder()
                .serviceEndpoint("contributionId", contributionId)
                .build()
                .execute(WidgetMetadataResponse.class);
    }

    /**
     * Get all available widget metadata in alphabetical order.
     *
     * @param scope Widget scope.
     * @return WidgetTypesResponse object {@link WidgetTypesResponse}
     * @throws AzDException Default Api Exception handler.
     */
    public WidgetTypesResponse list(String scope) throws AzDException {
        return builder()
                .query("$scope", scope)
                .build()
                .execute(WidgetTypesResponse.class);
    }
}
