package org.azd.release.manualinterventions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.release.types.ManualIntervention;
import org.azd.release.types.ManualInterventionUpdateRequest;
import org.azd.release.types.ManualInterventions;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Release Manual Intervention Api.
 */
public class ManualInterventionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ManualInterventionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "616c46e4-f370-4456-adaa-fbaf79c7b79e", ApiVersion.RELEASE_MANUAL_INTERVENTION);
    }

    /**
     * Get manual intervention for a given release and manual intervention id.
     *
     * @param manualInterventionId Id of the manual intervention.
     * @param releaseId            Id of the release.
     * @return Manual Intervention object {@link ManualIntervention}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<ManualIntervention> getAsync(int manualInterventionId, int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("manualInterventionId", manualInterventionId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(ManualIntervention.class);
    }

    /**
     * List all manual interventions for a given release.
     *
     * @param releaseId Id of the release.
     * @return Manual Intervention object {@link ManualIntervention}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<ManualInterventions> listAsync(int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(ManualInterventions.class);
    }

    /**
     * Update manual intervention.
     *
     * @param manualInterventionId            Id of the manual intervention.
     * @param releaseId                       Id of the release.
     * @param manualInterventionUpdateRequest Represents the request body to update manual intervention.
     * @return Manual Intervention object {@link ManualIntervention}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<ManualIntervention> updateAsync(int manualInterventionId, int releaseId,
                                                             ManualInterventionUpdateRequest manualInterventionUpdateRequest)
            throws AzDException {
        return builder()
                .PATCH(manualInterventionUpdateRequest)
                .serviceEndpoint("manualInterventionId", manualInterventionId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .executeAsync(ManualIntervention.class);
    }

    /**
     * Get manual intervention for a given release and manual intervention id.
     *
     * @param manualInterventionId Id of the manual intervention.
     * @param releaseId            Id of the release.
     * @return Manual Intervention object {@link ManualIntervention}
     * @throws AzDException Default Api exception handler
     */
    public ManualIntervention get(int manualInterventionId, int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("manualInterventionId", manualInterventionId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(ManualIntervention.class);
    }

    /**
     * List all manual interventions for a given release.
     *
     * @param releaseId Id of the release.
     * @return Manual Intervention object {@link ManualIntervention}
     * @throws AzDException Default Api exception handler
     */
    public ManualInterventions list(int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(ManualInterventions.class);
    }

    /**
     * Update manual intervention.
     *
     * @param manualInterventionId            Id of the manual intervention.
     * @param releaseId                       Id of the release.
     * @param manualInterventionUpdateRequest Represents the request body to update manual intervention.
     * @return Manual Intervention object {@link ManualIntervention}
     * @throws AzDException Default Api exception handler
     */
    public ManualIntervention update(int manualInterventionId, int releaseId,
                                     ManualInterventionUpdateRequest manualInterventionUpdateRequest)
            throws AzDException {
        return builder()
                .PATCH(manualInterventionUpdateRequest)
                .serviceEndpoint("manualInterventionId", manualInterventionId)
                .serviceEndpoint("releaseId", releaseId)
                .build()
                .execute(ManualIntervention.class);
    }
}
