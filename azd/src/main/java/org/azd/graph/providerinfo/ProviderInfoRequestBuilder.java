package org.azd.graph.providerinfo;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphProviderInfo;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Graph provider info Api.
 */
public class ProviderInfoRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ProviderInfoRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "1e377995-6fa2-4588-bd64-930186abdcfa",
                ApiVersion.GRAPH);
    }

    /**
     * Get the graph provider information.
     *
     * @param userDescriptor Pass the user descriptor.
     * @return Graph provider info object {@link GraphProviderInfo}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GraphProviderInfo> getAsync(String userDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .executeAsync(GraphProviderInfo.class);
    }

    /**
     * Get the graph provider information.
     *
     * @param userDescriptor Pass the user descriptor.
     * @return Graph provider info object {@link GraphProviderInfo}
     * @throws AzDException Default Api exception handler.
     */
    public GraphProviderInfo get(String userDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("userDescriptor", userDescriptor)
                .build()
                .execute(GraphProviderInfo.class);
    }
}
