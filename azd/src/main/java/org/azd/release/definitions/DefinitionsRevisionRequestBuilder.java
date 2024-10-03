package org.azd.release.definitions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.release.types.ReleaseDefinitionRevisions;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Release Definitions history Api.
 */
public class DefinitionsRevisionRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DefinitionsRevisionRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "258b82e0-9d41-43f3-86d6-fef14ddd44bc", ApiVersion.RELEASE_DEFINITION_HISTORY);
    }

    /**
     * Get release definition for a given definitionId and revision
     *
     * @param definitionId Id of the definition.
     * @param revision     Id of the revision.
     * @return Stream of definition revision
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InputStream> getAsync(int definitionId, int revision) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .serviceEndpoint("revision", revision)
                .build()
                .executeStreamAsync();
    }

    /**
     * Get revision history for a release definition
     *
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinitionRevisions {@link ReleaseDefinitionRevisions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ReleaseDefinitionRevisions> getHistoryAsync(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executeAsync(ReleaseDefinitionRevisions.class);
    }

    /**
     * Get release definition for a given definitionId and revision
     *
     * @param definitionId Id of the definition.
     * @param revision     Id of the revision.
     * @return Stream of definition revision
     * @throws AzDException Default Api Exception handler.
     */
    public InputStream get(int definitionId, int revision) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .serviceEndpoint("revision", revision)
                .build()
                .executeStream();
    }

    /**
     * Get revision history for a release definition
     *
     * @param definitionId Id of the release definition/pipeline.
     * @return ReleaseDefinitionRevisions {@link ReleaseDefinitionRevisions}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseDefinitionRevisions getHistory(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .execute(ReleaseDefinitionRevisions.class);
    }
}
