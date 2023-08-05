package org.azd.build.builds;

import org.azd.build.types.Build;
import org.azd.build.types.Builds;
import org.azd.build.types.RetentionLeases;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.Map;
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
        return requestAdapter.sendStringAsync(toDeleteInformation(buildId))
                .thenApplyAsync(r -> {
                    try {
                        if (!r.isEmpty()) serializer.deserialize(r, Map.class);
                    } catch (AzDException e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                });
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return Future build object {@link Build}
     */
    public CompletableFuture<Build> get(int buildId) throws AzDException {
        return requestAdapter.sendAsync(toGetInformation(buildId, null), Build.class);
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @param requestConfiguration Consumer of request configuration for query parameters.
     * @throws AzDException Default Api Exception handler.
     * @return Future build object {@link Build}
     */
    public CompletableFuture<Build> get(int buildId,
                                             Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return requestAdapter.sendAsync(toGetInformation(buildId, requestConfiguration), Build.class);
    }

    /***
     * Gets all retention leases that apply to a specific build.
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return Future Retention leases object {@link RetentionLeases}
     */
    public CompletableFuture<RetentionLeases> getRetentionLeases(int buildId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
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
        var reqInfo = toGetInformation(0, null);
        reqInfo.serviceEndpoint = service;
        return requestAdapter.sendAsync(reqInfo, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @throws AzDException Default Api Exception handler.
     * @return Future Builds object {@link org.azd.build.types.Builds}
     */
    public CompletableFuture<Builds> list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(0, requestConfiguration);
        reqInfo.serviceEndpoint = service;
        return requestAdapter.sendAsync(reqInfo, Builds.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        @QueryParameter(name = "propertyFilters")
        public String propertyFilters;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }


    /**
     * Constructs the request information for Build Api.
     * @param buildId ID of the build
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toDeleteInformation(int buildId) {
        var reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.DELETE;
        reqInfo.project = accessTokenCredential.getProjectName();
        reqInfo.serviceEndpoint = service + "/" + buildId;
        reqInfo.apiVersion = apiVersion;
        return reqInfo;
    }

    /**
     * Constructs the request information for Build Api.
     * @param buildId ID of the build
     * @param requestConfig Consumer of query parameters.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(int buildId, Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = new RequestInformation();
        reqInfo.project = project;
        reqInfo.serviceEndpoint = service + "/" + buildId;
        reqInfo.apiVersion = apiVersion;
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }
}
