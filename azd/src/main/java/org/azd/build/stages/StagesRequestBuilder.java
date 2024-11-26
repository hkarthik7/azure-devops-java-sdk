package org.azd.build.stages;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.StageUpdateType;
import org.azd.exceptions.AzDException;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Build Stages Api.
 */
public class StagesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public StagesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "b8aac6c9-744b-46e1-88fc-3550969f9313");
    }

    /**
     * Update a build stage.
     *
     * @param updateStageRequest UpdateStageRequest object to update the build stage.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(UpdateStageRequest updateStageRequest)
            throws AzDException {
        Objects.requireNonNull(updateStageRequest, "Update stage request cannot be null.");
        var body = new HashMap<String, Object>() {{
            put("forceRetryAllJobs", updateStageRequest.forceRetryAllJobs);
            put("state", updateStageRequest.state.name());
        }};

        return builder()
                .PATCH(body)
                .serviceEndpoint("buildId", updateStageRequest.buildId)
                .serviceEndpoint("stageRefName", updateStageRequest.stageReferenceName)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Update a build stage.
     *
     * @param updateStageRequest UpdateStageRequest object to update the build stage.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(UpdateStageRequest updateStageRequest)
            throws AzDException {
        Objects.requireNonNull(updateStageRequest, "Update stage request cannot be null.");
        var body = new HashMap<String, Object>() {{
            put("forceRetryAllJobs", updateStageRequest.forceRetryAllJobs);
            put("state", updateStageRequest.state.name());
        }};

        return builder()
                .PATCH(body)
                .serviceEndpoint("buildId", updateStageRequest.buildId)
                .serviceEndpoint("stageRefName", updateStageRequest.stageReferenceName)
                .build()
                .executePrimitive();
    }

    public static class UpdateStageRequest {
        public int buildId;
        public String stageReferenceName;
        public Boolean forceRetryAllJobs;
        public StageUpdateType state;
    }
}
