package org.azd.build.builds;

import org.azd.build.types.BuildWorkItems;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to manage Build work items Api.
 */
public class BuildWorkItemsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public BuildWorkItemsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD_WORK_ITEMS);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     * @param buildId ID of the build.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getAsync(int buildId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        return requestAdapter.sendAsync(reqInfo, BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     * @param buildId ID of the build.
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getAsync(int buildId,
                                                      Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(buildId, requestConfiguration);
        return requestAdapter.sendAsync(reqInfo, BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build, filtered to specific commits.
     * @param buildId ID of the build.
     * @param commitId List of commit ids to get the work items.
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getFromCommitsAsync(int buildId, List<String> commitId,
                                                                 Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toPostInformation(buildId, commitId, requestConfiguration);
        return requestAdapter.sendAsync(reqInfo, BuildWorkItems.class);
    }

    /**
     * Gets all the work items between two builds.
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return Future object of BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildWorkItems> getAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(0, requestConfiguration);
        reqInfo.serviceEndpoint = "build/workitems";
        return requestAdapter.sendAsync(reqInfo, BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     * @param buildId ID of the build.
     * @return BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems get(int buildId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        return requestAdapter.send(reqInfo, BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build. Only work items in the same project are returned.
     * @param buildId ID of the build.
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems get(int buildId,
                              Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(buildId, requestConfiguration);
        return requestAdapter.send(reqInfo, BuildWorkItems.class);
    }

    /**
     * Gets the work items associated with a build, filtered to specific commits.
     * @param buildId ID of the build.
     * @param commitId List of commit ids to get the work items.
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems getFromCommits(int buildId, List<String> commitId,
                                         Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toPostInformation(buildId, commitId, requestConfiguration);
        return requestAdapter.send(reqInfo, BuildWorkItems.class);
    }

    /**
     * Gets all the work items between two builds.
     * @param requestConfiguration Consumer of Request configuration query parameters.
     * @return BuildWorkItems {@link BuildWorkItems}
     * @throws AzDException Default Api exception handler.
     */
    public BuildWorkItems get(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(0, requestConfiguration);
        reqInfo.serviceEndpoint = "build/workitems";
        return requestAdapter.send(reqInfo, BuildWorkItems.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        @QueryParameter(name = "$top")
        public Number top;
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

    /**
     * Constructs the request information for Build work items api.
     * @param buildId ID of the build.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(int buildId, Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/workitems";
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }

    /**
     * Constructs the request information for Build work items api.
     * @param buildId ID of the build.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toPostInformation(int buildId, Object body, Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = toPostRequestInformation(body);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/workitems";
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }
}
