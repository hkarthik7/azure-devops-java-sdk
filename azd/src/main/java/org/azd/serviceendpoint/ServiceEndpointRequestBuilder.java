package org.azd.serviceendpoint;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.serviceendpoint.endpoints.EndpointsRequestBuilder;

/**
 * Provides functionality to work with Service endpoint Api.
 */
public class ServiceEndpointRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ServiceEndpointRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage service endpoints Api.
     *
     * @return EndpointsRequestBuilder {@link EndpointsRequestBuilder}
     */
    public EndpointsRequestBuilder endpoints() {
        return new EndpointsRequestBuilder(organizationUrl, accessTokenCredential);
    }
}
