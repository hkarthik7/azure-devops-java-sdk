package org.azd.graph.storagekeys;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.graph.types.GraphStorageKeyResult;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Graph Service Principals Api.
 */
public class StorageKeysRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public StorageKeysRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "graph", "eb85f8cc-f0f6-4264-a5b1-ffe2e4d4801f", ApiVersion.GRAPH);
    }

    /**
     * Resolve a descriptor to a storage key.
     *
     * @param subjectDescriptor Group or users descriptor id.
     * @return GraphStorageKeyResult Object {@link GraphStorageKeyResult}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GraphStorageKeyResult> getAsync(String subjectDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .build()
                .executeAsync(GraphStorageKeyResult.class);
    }

    /**
     * Resolve a descriptor to a storage key.
     *
     * @param subjectDescriptor Group or users descriptor id.
     * @return GraphStorageKeyResult Object {@link GraphStorageKeyResult}
     * @throws AzDException Default Api Exception handler.
     **/
    public GraphStorageKeyResult get(String subjectDescriptor) throws AzDException {
        return builder()
                .serviceEndpoint("subjectDescriptor", subjectDescriptor)
                .build()
                .execute(GraphStorageKeyResult.class);
    }

}
