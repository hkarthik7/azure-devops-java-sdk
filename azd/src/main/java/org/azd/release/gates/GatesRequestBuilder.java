package org.azd.release.gates;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.release.types.ReleaseGates;
import org.azd.release.types.ReleaseGatesUpdateRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Release Gates Api.
 */
public class GatesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public GatesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "2666a539-2001-4f80-bcc7-0379956749d4", ApiVersion.RELEASE_GATES);
    }

    /**
     * Updates the gate for a deployment.
     *
     * @param gateStepId                Gate step Id.
     * @param releaseGatesUpdateRequest Represents the request body to update release gates.
     * @return Release Gates object {@link ReleaseGates}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ReleaseGates> updateAsync(int gateStepId, ReleaseGatesUpdateRequest releaseGatesUpdateRequest)
            throws AzDException {
        return builder()
                .PATCH(releaseGatesUpdateRequest)
                .serviceEndpoint("gateStepId", gateStepId)
                .build()
                .executeAsync(ReleaseGates.class);
    }

    /**
     * Updates the gate for a deployment.
     *
     * @param gateStepId                Gate step Id.
     * @param releaseGatesUpdateRequest Represents the request body to update release gates.
     * @return Release Gates object {@link ReleaseGates}
     * @throws AzDException Default Api exception handler.
     */
    public ReleaseGates update(int gateStepId, ReleaseGatesUpdateRequest releaseGatesUpdateRequest)
            throws AzDException {
        return builder()
                .PATCH(releaseGatesUpdateRequest)
                .serviceEndpoint("gateStepId", gateStepId)
                .build()
                .execute(ReleaseGates.class);
    }
}
