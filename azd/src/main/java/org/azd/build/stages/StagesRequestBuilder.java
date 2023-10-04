package org.azd.build.stages;

import org.azd.common.ApiVersion;
import org.azd.enums.StageUpdateType;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Build Stages Api.
 */
public class StagesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public StagesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD_STAGE);
    }

    /**
     * Update a build stage.
     * @param updateStageRequest UpdateStageRequest object to update the build stage.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(UpdateStageRequest updateStageRequest)
            throws AzDException {
        var body = new HashMap<String, Object>() {{
            put("forceRetryAllJobs", updateStageRequest.forceRetryAllJobs);
            put("state", updateStageRequest.state.name());
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + updateStageRequest.buildId + "/stages/"
                + updateStageRequest.stageReferenceName;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /**
     * Update a build stage.
     * @param updateStageRequest UpdateStageRequest object to update the build stage.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(UpdateStageRequest updateStageRequest)
            throws AzDException {
        var body = new HashMap<String, Object>() {{
            put("forceRetryAllJobs", updateStageRequest.forceRetryAllJobs);
            put("state", updateStageRequest.state.name());
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + updateStageRequest.buildId + "/stages/"
                + updateStageRequest.stageReferenceName;

        return requestAdapter.sendPrimitive(reqInfo);
    }

    public static class UpdateStageRequest {
        public int buildId;
        public String stageReferenceName;
        public Boolean forceRetryAllJobs;
        public StageUpdateType state;
    }
}
