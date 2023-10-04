package org.azd.build.builds;

import org.azd.build.types.BuildChanges;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Build Changes Api.
 */
public class BuildChangesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public BuildChangesRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD_CHANGES);
    }

    /**
     * Gets the changes associated with a build
     * @param buildId ID of the build.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<BuildChanges> getAsync(int buildId) throws AzDException {
        return requestAdapter.sendAsync(toGetInformation(buildId, null), BuildChanges.class);
    }

    /**
     * Gets the changes associated with a build
     * @param buildId ID of the build.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public CompletableFuture<BuildChanges> getAsync(int buildId,
                                                    Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(buildId, requestConfiguration);
        return requestAdapter.sendAsync(reqInfo, BuildChanges.class);
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param requestConfiguration Consumer of request configuration object.
     * @return BuildChanges future object {@link BuildChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildChanges> getAsync(Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        var reqInfo = toGetInformation(0, requestConfiguration);
        reqInfo.serviceEndpoint = "build/changes";
        return requestAdapter.sendAsync(reqInfo, BuildChanges.class);
    }

    /**
     * Gets the changes associated with a build
     * @param buildId ID of the build.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public BuildChanges get(int buildId) throws AzDException {
        return requestAdapter.send(toGetInformation(buildId, null), BuildChanges.class);
    }

    /**
     * Gets the changes associated with a build
     * @param buildId ID of the build.
     * @return Future object of BuildChanges {@link BuildChanges}
     * @throws AzDException Default Api exception handler
     */
    public BuildChanges get(int buildId,
                            Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(buildId, requestConfiguration);
        return requestAdapter.send(reqInfo, BuildChanges.class);
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param requestConfiguration Consumer of request configuration object.
     * @return BuildChanges future object {@link BuildChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildChanges get(Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        var reqInfo = toGetInformation(0, requestConfiguration);
        reqInfo.serviceEndpoint = "build/changes";
        return requestAdapter.send(reqInfo, BuildChanges.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        @QueryParameter(name = "fromBuildId")
        public int fromBuildId;
        @QueryParameter(name = "toBuildId")
        public int toBuildId;
        @QueryParameter(name = "$top")
        public Number top;
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        @QueryParameter(name = "includeSourceChange")
        public Boolean includeSourceChange;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Constructs the request information for Build changes api.
     * @param buildId ID of the build.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(int buildId, Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/changes";
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }
}
