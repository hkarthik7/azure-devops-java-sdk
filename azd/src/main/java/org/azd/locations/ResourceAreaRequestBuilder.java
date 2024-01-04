package org.azd.locations;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.internals.LookUpService;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.types.ResourceAreas;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

public class ResourceAreaRequestBuilder extends BaseRequestBuilder {
    private final static String id = "e81700f7-3be2-46de-8624-2eb35882fcaa";
    private final static String area = "location";
    private final String organizationUrl;

    public ResourceAreaRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
        this.organizationUrl = organizationUrl;
    }

    public CompletableFuture<ResourceAreas> listAsync() throws AzDException {
        return CompletableFuture.completedFuture(
                LookUpService.getInstance(accessTokenCredential)
                        .resourceAreas(organizationUrl));
    }

    public ResourceAreas list() throws AzDException {
        return LookUpService.getInstance(accessTokenCredential)
                .resourceAreas(organizationUrl);
    }

}
