package org.azd.locations;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.internals.LookUpService;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.Constants;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;
import org.azd.locations.types.ConnectionData;
import org.azd.utils.UrlBuilder;

import java.util.concurrent.CompletableFuture;

/**
 * Represents Api locations and helper functions.
 */
public class LocationsBaseRequestBuilder extends BaseRequestBuilder {
    private final String organizationUrl;

    /**
     * Default constructor
     * @param organizationUrl Organisation URL.
     * @param accessTokenCredential Access token credential object.
     */
    public LocationsBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
        this.organizationUrl = organizationUrl;
    }

    /**
     * Returns the resource area request builder.
     * @return ResourceAreaRequestBuilder {@link ResourceAreaRequestBuilder}
     */
    public ResourceAreaRequestBuilder resourceArea() {
        return new ResourceAreaRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Get the url for given resource id.
     * @param resourceId Pass the resource id. E.g., ResourceId.BUILD
     * @return Location URL for specific Api.
     */
    public String getUrl(String resourceId) {
        return LookUpService.getInstance(accessTokenCredential)
                .locationUrl(organizationUrl, resourceId);
    }

    /**
     * Get the url for given resource id.
     * @param resourceId Pass the resource id. E.g., ResourceId.BUILD
     * @return Location URL for specific Api.
     */
    public CompletableFuture<String> getUrlAsync(String resourceId) {
        return CompletableFuture.completedFuture(getUrl(resourceId));
    }

    /**
     * Get connection data for current USER.
     * @return ConnectionData object {@link ConnectionData}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ConnectionData> getConnectionDataAsync() throws AzDException {
        var uri = UrlBuilder.fromBaseUrl(organizationUrl)
                .appendPath(Constants.APIS_RELATIVE_PATH)
                .appendPath(Constants.CONNECTION_DATA)
                .build();
        return ClientRequest.builder(accessTokenCredential)
                .URI(uri)
                .build()
                .executeAsync(ConnectionData.class);
    }

    /**
     * Get connection data for current USER.
     * @return ConnectionData object {@link ConnectionData}
     * @throws AzDException Default Api exception handler.
     */
    public ConnectionData getConnectionData() throws AzDException {
        var uri = UrlBuilder.fromBaseUrl(organizationUrl)
                .appendPath(Constants.APIS_RELATIVE_PATH)
                .appendPath(Constants.CONNECTION_DATA)
                .build();
        return ClientRequest.builder(accessTokenCredential)
                .URI(uri)
                .build()
                .execute(ConnectionData.class);
    }

}
