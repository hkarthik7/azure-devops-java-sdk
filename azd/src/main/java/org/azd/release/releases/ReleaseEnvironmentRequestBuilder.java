package org.azd.release.releases;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.ReleaseEnvironmentExpands;
import org.azd.exceptions.AzDException;
import org.azd.release.types.ReleaseEnvironment;
import org.azd.release.types.ReleaseEnvironmentUpdateMetadata;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Release environments Api.
 */
public class ReleaseEnvironmentRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ReleaseEnvironmentRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "a7e426b1-03dc-48af-9dfe-c98bac612dcb", ApiVersion.RELEASE_ENVIRONMENT);
    }

    /**
     * Get a release environment.
     *
     * @param releaseId     pass the release id
     * @param environmentId Id of the release environment.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseEnvironment> getAsync(int environmentId, int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(ReleaseEnvironment.class);
    }

    /**
     * Get a release environment.
     *
     * @param releaseId     pass the release id
     * @param environmentId Id of the release environment.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseEnvironment> getAsync(int environmentId, int releaseId,
                                                          ReleaseEnvironmentExpands expand) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .serviceEndpoint("releaseId", releaseId)
                .query("$expand", expand.name())
                .build()
                .executeAsync(ReleaseEnvironment.class);
    }

    /**
     * Update the status of a release environment
     *
     * @param releaseId      pass the release id
     * @param environmentId  Id of the release environment.
     * @param updateMetadata Request metadata to update.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseEnvironment> updateAsync(int environmentId, int releaseId,
                                                             ReleaseEnvironmentUpdateMetadata updateMetadata)
            throws AzDException {
        return builder()
                .PATCH(updateMetadata)
                .serviceEndpoint("environmentId", environmentId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(ReleaseEnvironment.class);
    }

    /**
     * Get a release environment.
     *
     * @param releaseId     pass the release id
     * @param environmentId Id of the release environment.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseEnvironment get(int environmentId, int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(ReleaseEnvironment.class);
    }

    /**
     * Get a release environment.
     *
     * @param releaseId     pass the release id
     * @param environmentId Id of the release environment.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseEnvironment get(int environmentId, int releaseId,
                                  ReleaseEnvironmentExpands expand) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .serviceEndpoint("releaseId", releaseId)
                .query("$expand", expand.name())
                .build()
                .execute(ReleaseEnvironment.class);
    }

    /**
     * Update the status of a release environment
     *
     * @param releaseId      pass the release id
     * @param environmentId  Id of the release environment.
     * @param updateMetadata Request metadata to update.
     * @return Release Environment {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseEnvironment update(int environmentId, int releaseId,
                                     ReleaseEnvironmentUpdateMetadata updateMetadata) throws AzDException {
        return builder()
                .PATCH(updateMetadata)
                .serviceEndpoint("environmentId", environmentId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(ReleaseEnvironment.class);
    }

}
