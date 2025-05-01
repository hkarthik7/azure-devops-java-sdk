package org.azd.locations;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.internals.LookUpService;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.types.ResourceAreas;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

/**
 * Represents the resource areas of the Api.
 */
public class ResourceAreaRequestBuilder extends BaseRequestBuilder {
    private final String organizationUrl;

    /**
     * Default constructor.
     * @param organizationUrl Pass the organisation URL.
     * @param accessTokenCredential Access token credential object.
     */
    public ResourceAreaRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
        this.organizationUrl = organizationUrl;
    }

    /**
     * Returns all publicly available resources areas.
     * @return ResourceAreas object {@link ResourceAreas}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ResourceAreas> listAsync() throws AzDException {
        return CompletableFuture.completedFuture(
                LookUpService.getInstance(accessTokenCredential)
                        .resourceAreas(organizationUrl));
    }

    /**
     * Returns all publicly available resources areas.
     * @return ResourceAreas object {@link ResourceAreas}
     * @throws AzDException Default Api exception handler.
     */
    public ResourceAreas list() throws AzDException {
        return LookUpService.getInstance(accessTokenCredential)
                .resourceAreas(organizationUrl);
    }

}
