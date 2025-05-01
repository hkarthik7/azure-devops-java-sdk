package org.azd.build.builds;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildWorkItems;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to manage Build work items Api.
 */
public class BuildWorkItemsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildWorkItemsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "5a21f5d2-5642-47e4-a0bd-1356e6731bee", ApiVersion.BUILD_WORK_ITEMS);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     *
     * @param buildId ID of the build.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getAsync(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     *
     * @param buildId ID of the build.
     * @param top     The maximum number of work items to return.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getAsync(int buildId, int top) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .query("$top", top)
                .build()
                .executeAsync(BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build, filtered to specific commits.
     *
     * @param buildId  ID of the build.
     * @param commitId List of commit ids to get the work items.
     * @param top      The maximum number of work items to return, or the number of commits to consider if no commit IDs are specified.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getFromCommitsAsync(int buildId, List<String> commitId, int top) throws AzDException {
        return builder()
                .POST(commitId)
                .serviceEndpoint("buildId", buildId)
                .query("$top", top)
                .build()
                .executeAsync(BuildWorkItems.class);
    }

    /**
     * Gets all the work items between two builds.
     *
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("52ba8915-5518-42e3-a4bb-b0182d159e2d")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     *
     * @param buildId ID of the build.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems get(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     *
     * @param buildId ID of the build.
     * @param top     The maximum number of work items to return.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems get(int buildId, int top) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .query("$top", top)
                .build()
                .execute(BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build, filtered to specific commits.
     *
     * @param buildId  ID of the build.
     * @param commitId List of commit ids to get the work items.
     * @param top      The maximum number of work items to return, or the number of commits to consider if no commit IDs are specified.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems getFromCommits(int buildId, List<String> commitId, int top) throws AzDException {
        return builder()
                .POST(commitId)
                .serviceEndpoint("buildId", buildId)
                .query("$top", top)
                .build()
                .execute(BuildWorkItems.class);
    }

    /**
     * Gets all the work items between two builds.
     *
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems get(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("52ba8915-5518-42e3-a4bb-b0182d159e2d")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(BuildWorkItems.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        @QueryParameter(name = "$top")
        public Integer top;
        @QueryParameter(name = "fromBuildId")
        public Number fromBuildId;
        @QueryParameter(name = "toBuildId")
        public Number toBuildId;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
