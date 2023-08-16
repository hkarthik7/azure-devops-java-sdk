package org.azd.build.builds;

import org.azd.build.types.Build;
import org.azd.build.types.Builds;
import org.azd.build.types.RetentionLeases;
import org.azd.cache.BuildCache;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Builds Api.
 */
public class BuildsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public BuildsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD);
    }

    /**
     * Provides functionality to Build changes Api.
     * @return BuildChangesRequestBuilder {@link BuildChangesRequestBuilder}
     */
    public BuildChangesRequestBuilder changes() {
        return new BuildChangesRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to Build logs Api.
     * @return BuildLogsRequestBuilder {@link BuildLogsRequestBuilder}
     */
    public BuildLogsRequestBuilder logs() {
        return new BuildLogsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to Build work items Api.
     * @return BuildWorkItemsRequestBuilder {@link BuildWorkItemsRequestBuilder}
     */
    public BuildWorkItemsRequestBuilder workItems() {
        return new BuildWorkItemsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /***
     * Deletes a build asynchronously.
     * @param buildId pass the build id to delete
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> delete(int buildId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return Future build object {@link Build}
     */
    public CompletableFuture<Build> get(int buildId) throws AzDException {
        var reqInfo = toGetInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId;
        var result = requestAdapter.sendAsync(reqInfo, Build.class);
        BuildCache.update(buildId, result);
        return result;
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @param propertyFilters Property filters.
     * @throws AzDException Default Api Exception handler.
     * @return Future build object {@link Build}
     */
    public CompletableFuture<Build> get(int buildId, String propertyFilters) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId;
        reqInfo.setQueryParameter("propertyFilters", propertyFilters);

        return requestAdapter.sendAsync(reqInfo, Build.class);
    }

    /***
     * Gets all retention leases that apply to a specific build.
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return Future Retention leases object {@link RetentionLeases}
     */
    public CompletableFuture<RetentionLeases> getRetentionLeases(int buildId) throws AzDException {
        var reqInfo = toGetInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/leases";
        reqInfo.apiVersion = ApiVersion.BUILD_RETENTION_LEASES;

        return requestAdapter.sendAsync(reqInfo, RetentionLeases.class);
    }

    /***
     * Gets a list of builds.
     * @throws AzDException Default Api Exception handler.
     * @return Future Builds object {@link org.azd.build.types.Builds}
     */
    public CompletableFuture<Builds> list() throws AzDException {
        var reqInfo = toGetInformation(null);

        return requestAdapter.sendAsync(reqInfo, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @throws AzDException Default Api Exception handler.
     * @return Future Builds object {@link org.azd.build.types.Builds}
     */
    public CompletableFuture<Builds> list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(requestConfiguration);

        return requestAdapter.sendAsync(reqInfo, Builds.class);
    }

    /***
     * Queues a build
     * @param definitionId pass the pipeline id to queue the build
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    public CompletableFuture<Build> queue(int definitionId) throws AzDException {
        var reqInfo = toPostRequestInformation(null);
        reqInfo.setQueryParameter("definitionId", definitionId);

        return requestAdapter.sendAsync(reqInfo, Build.class);
    }

    /***
     * Queues a build
     * @param build Build object to queue the build.
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    public CompletableFuture<Build> queue(Build build) throws AzDException {
        var reqInfo = toPostRequestInformation(build);

        return requestAdapter.sendAsync(reqInfo, Build.class);
    }

    /**
     * Updates a build.
     *
     * @param build pass the Build object to update. {@link Build}
     * @param buildId The ID of the build.
     * @param retry None
     * @return Build Object {@link Build}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Build> update(int buildId, boolean retry, Build build) throws AzDException {
        var reqInfo = toPatchRequestInformation(build);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId;
        reqInfo.setQueryParameter("retry", retry);

        return requestAdapter.sendAsync(reqInfo, Build.class);
    }

    /**
     * Updates multiple builds.
     *
     * @param builds List of build to update. {@link Builds}
     * @return Build Object {@link Builds}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Builds> update(Builds builds) throws AzDException {
        var reqInfo = toPatchRequestInformation(builds);

        return requestAdapter.sendAsync(reqInfo, Builds.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The maximum number of builds to return.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * If specified, filters to builds that built branches that built this branch.
         */
        @QueryParameter(name = "branchName")
        public String branchName;
        /**
         * A comma-delimited list that specifies the IDs of builds to retrieve.
         */
        @QueryParameter(name = "buildIds")
        public String[] buildIds;
        /**
         * If specified, filters to builds that match this build number. Append * to do a prefix search.
         */
        @QueryParameter(name = "buildNumber")
        public String buildNumber;
        /**
         * The maximum number of builds to return.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * A comma-delimited list of definition IDs. If specified, filters to builds for these definitions.
         */
        @QueryParameter(name = "definitions")
        public String[] definitions;
        /**
         * Indicates whether to exclude, include, or only return deleted builds.
         */
        @QueryParameter(name = "deletedFilter")
        public QueryDeletedOption deletedFilter;
        /**
         * The maximum number of builds to return per definition.
         */
        @QueryParameter(name = "maxBuildsPerDefinition")
        public Number maxBuildsPerDefinition;
        /**
         * If specified, filters to builds that finished/started/queued before this date based on the queryOrder specified.
         */
        @QueryParameter(name = "maxTime")
        public String maxTime;
        /**
         * If specified, filters to builds that finished/started/queued after this date based on the queryOrder specified.
         */
        @QueryParameter(name = "minTime")
        public String minTime;
        /**
         * A comma-delimited list of properties to retrieve.
         */
        @QueryParameter(name = "properties")
        public String[] properties;
        /**
         * A comma-delimited list of properties to retrieve.
         */
        @QueryParameter(name = "queryOrder")
        public BuildQueryOrder queryOrder;
        /**
         * A comma-delimited list of queue IDs. If specified, filters to builds that ran against these queues.
         */
        @QueryParameter(name = "queues")
        public String[] queues;
        /**
         * If specified, filters to builds that match this reason.
         */
        @QueryParameter(name = "reasonFilter")
        public BuildReason reasonFilter;
        /**
         *
         * If specified, filters to builds that built from this repository.
         */
        @QueryParameter(name = "repositoryId")
        public String repositoryId;
        /**
         * If specified, filters to builds that built from repositories of this type.
         */
        @QueryParameter(name = "repositoryType")
        public String repositoryType;
        /**
         * If specified, filters to builds requested for the specified user.
         */
        @QueryParameter(name = "requestedFor")
        public String requestedFor;
        /**
         * If specified, filters to builds that match this result.
         */
        @QueryParameter(name = "resultFilter")
        public BuildResult resultFilter;
        /**
         * If specified, filters to builds that match this status.
         */
        @QueryParameter(name = "statusFilter")
        public BuildStatus statusFilter;
        /**
         * A comma-delimited list of tags. If specified, filters to builds that have the specified tags.
         */
        @QueryParameter(name = "tagFilters")
        public String[] tagFilters;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }


    /**
     * Constructs the request information for Build Api.
     * @param requestConfig Consumer of query parameters.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = toGetRequestInformation();
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }
}
