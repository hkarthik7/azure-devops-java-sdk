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

public class LocationsBaseRequestBuilder extends BaseRequestBuilder {
    private final String organizationUrl;

    public LocationsBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
        this.organizationUrl = organizationUrl;
    }

    public ResourceAreaRequestBuilder resourceArea() {
        return new ResourceAreaRequestBuilder(organizationUrl, accessTokenCredential);
    }

    public String getUrl(String resourceId) {
        return LookUpService.getInstance(accessTokenCredential)
                .locationUrl(organizationUrl, resourceId);
    }

    public CompletableFuture<String> getUrlAsync(String resourceId) {
        return CompletableFuture.completedFuture(getUrl(resourceId));
    }

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
