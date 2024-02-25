package org.azd.build.builds;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.Build;
import org.azd.build.types.Builds;
import org.azd.build.types.RetentionLeases;
import org.azd.common.ApiVersion;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Builds Api.
 */
public class BuildsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "0cd358e1-9217-4d94-8269-1c1ee6f93dcf");

    }

    /**
     * Provides functionality to Build changes Api.
     *
     * @return BuildChangesRequestBuilder {@link BuildChangesRequestBuilder}
     */
    public BuildChangesRequestBuilder changes() {
        return new BuildChangesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Build logs Api.
     *
     * @return BuildLogsRequestBuilder {@link BuildLogsRequestBuilder}
     */
    public BuildLogsRequestBuilder logs() {
        return new BuildLogsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Build work items Api.
     *
     * @return BuildWorkItemsRequestBuilder {@link BuildWorkItemsRequestBuilder}
     */
    public BuildWorkItemsRequestBuilder workItems() {
        return new BuildWorkItemsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Deletes a build asynchronously.
     *
     * @param buildId pass the build id to delete
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int buildId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Gets a build
     *
     * @param buildId pass the build id
     * @return Future build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Build> getAsync(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(Build.class);
    }

    /**
     * Gets a build
     *
     * @param buildId         pass the build id
     * @param propertyFilters Property filters.
     * @return Future build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Build> getAsync(int buildId, String propertyFilters) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .query("propertyFilters", propertyFilters)
                .build()
                .executeAsync(Build.class);
    }

    /**
     * Gets all retention leases that apply to a specific build.
     *
     * @param buildId pass the build id
     * @return Future Retention leases object {@link RetentionLeases}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<RetentionLeases> getRetentionLeasesAsync(int buildId) throws AzDException {
        return builder()
                .location("3da19a6a-f088-45c4-83ce-2ad3a87be6c4")
                .serviceEndpoint("buildId", buildId)
                .apiVersion(ApiVersion.BUILD_RETENTION_LEASES)
                .build()
                .executeAsync(RetentionLeases.class);
    }

    /**
     * Gets a list of builds.
     *
     * @return Future Builds object {@link org.azd.build.types.Builds}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Builds> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Builds.class);
    }

    /**
     * Gets a list of builds.
     *
     * @return Future Builds object {@link org.azd.build.types.Builds}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Builds> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Builds.class);
    }

    /**
     * Queues a build
     *
     * @param definitionId pass the pipeline id to queue the build
     * @return a build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Build> queueAsync(int definitionId) throws AzDException {
        return builder()
                .POST(null)
                .query("definitionId", definitionId)
                .build()
                .executeAsync(Build.class);
    }

    /**
     * Queues a build
     *
     * @param build Build object to queue the build.
     * @return a build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Build> queueAsync(Build build) throws AzDException {
        return builder()
                .POST(build)
                .build()
                .executeAsync(Build.class);
    }

    /**
     * Updates a build.
     *
     * @param build   pass the Build object to update. {@link Build}
     * @param buildId The ID of the build.
     * @param retry   None
     * @return Build Object {@link Build}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Build> updateAsync(int buildId, boolean retry, Build build) throws AzDException {
        return builder()
                .PATCH(build)
                .serviceEndpoint("buildId", buildId)
                .query("retry", retry)
                .build()
                .executeAsync(Build.class);
    }

    /**
     * Updates multiple builds.
     *
     * @param builds List of build to update. {@link Builds}
     * @return Build Object {@link Builds}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Builds> updateAsync(Builds builds) throws AzDException {
        return builder()
                .PATCH(builds)
                .build()
                .executeAsync(Builds.class);
    }

    /**
     * Deletes a build hronously.
     *
     * @param buildId pass the build id to delete
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int buildId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executePrimitive();
    }

    /**
     * Gets a build
     *
     * @param buildId pass the build id
     * @return Future build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public Build get(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(Build.class);
    }

    /**
     * Gets a build
     *
     * @param buildId         pass the build id
     * @param propertyFilters Property filters.
     * @return Future build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public Build get(int buildId, String propertyFilters) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .query("propertyFilters", propertyFilters)
                .build()
                .execute(Build.class);
    }

    /**
     * Gets all retention leases that apply to a specific build.
     *
     * @param buildId pass the build id
     * @return Future Retention leases object {@link RetentionLeases}
     * @throws AzDException Default Api Exception handler.
     */
    public RetentionLeases getRetentionLeases(int buildId) throws AzDException {
        return builder()
                .location("3da19a6a-f088-45c4-83ce-2ad3a87be6c4")
                .serviceEndpoint("buildId", buildId)
                .apiVersion(ApiVersion.BUILD_RETENTION_LEASES)
                .build()
                .execute(RetentionLeases.class);
    }

    /**
     * Gets a list of builds.
     *
     * @return Future Builds object {@link org.azd.build.types.Builds}
     * @throws AzDException Default Api Exception handler.
     */
    public Builds list() throws AzDException {
        return builder()
                .build()
                .execute(Builds.class);
    }

    /**
     * Gets a list of builds.
     *
     * @return Future Builds object {@link org.azd.build.types.Builds}
     * @throws AzDException Default Api Exception handler.
     */
    public Builds list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Builds.class);
    }

    /**
     * Queues a build
     *
     * @param definitionId pass the pipeline id to queue the build
     * @return a build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public Build queue(int definitionId) throws AzDException {
        return builder()
                .POST(null)
                .query("definitionId", definitionId)
                .build()
                .execute(Build.class);
    }

    /**
     * Queues a build
     *
     * @param build Build object to queue the build.
     * @return a build object {@link Build}
     * @throws AzDException Default Api Exception handler.
     */
    public Build queue(Build build) throws AzDException {
        return builder()
                .POST(build)
                .build()
                .execute(Build.class);
    }

    /**
     * Updates a build.
     *
     * @param build   pass the Build object to update. {@link Build}
     * @param buildId The ID of the build.
     * @param retry   None
     * @return Build Object {@link Build}
     * @throws AzDException Default Api Exception handler.
     **/
    public Build update(int buildId, boolean retry, Build build) throws AzDException {
        return builder()
                .PATCH(build)
                .serviceEndpoint("buildId", buildId)
                .query("retry", retry)
                .build()
                .execute(Build.class);
    }

    /**
     * Updates multiple builds.
     *
     * @param builds List of build to update. {@link Builds}
     * @return Build Object {@link Builds}
     * @throws AzDException Default Api Exception handler.
     **/
    public Builds update(Builds builds) throws AzDException {
        return builder()
                .PATCH(builds)
                .build()
                .execute(Builds.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The maximum number of builds to return.
         */
        @QueryParameter(name = "$top")
        public Integer top;
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
        public Integer maxBuildsPerDefinition;
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
         * Build query order.
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
}

