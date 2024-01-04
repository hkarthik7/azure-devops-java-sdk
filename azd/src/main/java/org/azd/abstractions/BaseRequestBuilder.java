package org.azd.abstractions;

import org.azd.authentication.AccessTokenCredential;
import org.azd.http.ClientRequest;

import java.util.Objects;

public abstract class BaseRequestBuilder {
    protected final AccessTokenCredential accessTokenCredential;
    protected String organizationUrl;
    protected String area;
    protected String locationId;
    protected String apiVersion;

    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential) {
        this(organizationUrl, accessTokenCredential, null, null, null);
    }

    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential, final String area) {
        this(organizationUrl, accessTokenCredential, area, null, null);
    }

    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential, final String area,
                                 final String locationId) {
        this(organizationUrl, accessTokenCredential, area, locationId, null);
    }

    protected BaseRequestBuilder(final String organizationUrl, final AccessTokenCredential accessTokenCredential, final String area,
                                 final String locationId, final String apiVersion) {
        Objects.requireNonNull(accessTokenCredential, "Access token credential cannot be null.");
        Objects.requireNonNull(organizationUrl, "Organization url cannot be null.");

        this.organizationUrl = organizationUrl;
        this.accessTokenCredential = accessTokenCredential;
        this.area = area;
        this.locationId = locationId;
        this.apiVersion = apiVersion;
    }

    /**
     * Request builder to construct the request and execute it.
     *
     * @return ClientRequest.Builder of builder. {@link ClientRequest.Builder}
     */
    protected ClientRequest.Builder builder() {
        return ClientRequest.builder(accessTokenCredential)
                .baseInstance(organizationUrl)
                .area(area)
                .location(locationId)
                .apiVersion(apiVersion);
    }
}
