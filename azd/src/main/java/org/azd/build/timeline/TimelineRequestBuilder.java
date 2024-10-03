package org.azd.build.timeline;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.Timeline;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Build Timeline Api.
 */
public class TimelineRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TimelineRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "8baac422-4c6e-4de5-8532-db96d92acffa", ApiVersion.BUILD_TIMELINE);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId Id of the build. use getBuilds() to list all the builds.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Timeline> getAsync(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(Timeline.class);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId    Id of the build. use getBuilds() to list all the builds.
     * @param timelineId Id of the build timeline.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Timeline> getAsync(int buildId, String timelineId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("timelineId", timelineId)
                .build()
                .executeAsync(Timeline.class);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId              Id of the build. use getBuilds() to list all the builds.
     * @param timelineId           Id of the build timeline.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Timeline> getAsync(int buildId, String timelineId,
                                                Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("timelineId", timelineId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Timeline.class);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId Id of the build. use getBuilds() to list all the builds.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public Timeline get(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(Timeline.class);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId    Id of the build. use getBuilds() to list all the builds.
     * @param timelineId Id of the build timeline.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public Timeline get(int buildId, String timelineId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("timelineId", timelineId)
                .build()
                .execute(Timeline.class);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId              Id of the build. use getBuilds() to list all the builds.
     * @param timelineId           Id of the build timeline.
     * @param requestConfiguration Consumer of query parameters to filter.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    public Timeline get(int buildId, String timelineId,
                        Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("timelineId", timelineId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Timeline.class);
    }

    /**
     * Represents the query parameters.
     */
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

    /**
     * Represents the configuration to pass for query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
