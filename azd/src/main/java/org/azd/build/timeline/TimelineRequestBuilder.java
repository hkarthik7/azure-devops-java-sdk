package org.azd.build.timeline;

import org.azd.build.types.Timeline;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Timeline Api.
 */
public class TimelineRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public TimelineRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD_TIMELINE);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId Id of the build. use getBuilds() to list all the builds.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Timeline> get(int buildId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/timeline";

        return requestAdapter.sendAsync(reqInfo, Timeline.class);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId    Id of the build. use getBuilds() to list all the builds.
     * @param timelineId Id of the build timeline.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Timeline> get(int buildId, String timelineId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/timeline/" + timelineId;

        return requestAdapter.sendAsync(reqInfo, Timeline.class);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId    Id of the build. use getBuilds() to list all the builds.
     * @param timelineId Id of the build timeline.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Timeline> get(int buildId, String timelineId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/timeline/" + timelineId;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, Timeline.class);
    }

    public static class GetQueryParameters {
        /**
         * Timeline change id.
         */
        @QueryParameter(name = "changeId")
        public Number changeId;
        /**
         * Timeline plan id. This value can be null if unknown.
         */
        @QueryParameter(name = "planId")
        public String planId;
    }

    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }


}
