package org.azd.graph.descriptors;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphDescriptor;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Azure DevOps Graph Api.
 */
public class DescriptorsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DescriptorsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "048aee0a-7072-4cde-ab73-7af77b1e0b4e", ApiVersion.GRAPH);
    }

    /**
     * Resolve a storage key to a descriptor
     *
     * @param storageKey Storage key of the subject (user, group, scope, etc.) to resolve
     * @return GraphDescriptor Object {@link GraphDescriptor}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GraphDescriptor> getAsync(String storageKey) throws AzDException {
        return builder()
                .serviceEndpoint("storageKey", storageKey)
                .build()
                .executeAsync(GraphDescriptor.class);
    }

    /**
     * Resolve a storage key to a descriptor
     *
     * @param storageKey Storage key of the subject (user, group, scope, etc.) to resolve
     * @return GraphDescriptor Object {@link GraphDescriptor}
     * @throws AzDException Default Api Exception handler.
     **/
    public GraphDescriptor get(String storageKey) throws AzDException {
        return builder()
                .serviceEndpoint("storageKey", storageKey)
                .build()
                .execute(GraphDescriptor.class);
    }
}
