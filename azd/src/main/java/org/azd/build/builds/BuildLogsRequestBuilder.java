package org.azd.build.builds;

import org.azd.build.types.BuildLogs;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Build Logs Api.
 */
public class BuildLogsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public BuildLogsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD_LOGS);
    }

    /**
     * Gets an individual log file for a build.
     * @param buildId ID of the build.
     * @param logId ID of the log file.
     * @return Future string object or plain text.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<String> get(int buildId, int logId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + logId;
        return requestAdapter.sendStringAsync(reqInfo);
    }

    /**
     * Gets an individual log file for a build as plain text.
     * @param buildId ID of the build.
     * @param logId ID of the log file.
     * @param requestConfiguration Consumer of query parameters.
     * @return String object or plain text.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<String> get(int buildId, int logId,
                                              Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetInformation(buildId, requestConfiguration);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + logId;
        reqInfo.requestHeaders.add(CustomHeader.TEXT_CONTENT);
        return requestAdapter.sendStringAsync(reqInfo);
    }

    /**
     * Gets an individual log file for a build as a zip file.
     * @param buildId ID of the build.
     * @param logId ID of the log file.
     * @return Input stream of logs.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZip(int buildId, int logId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + logId;
        reqInfo.requestHeaders.add(CustomHeader.STREAM_ZIP_ACCEPT);
        return requestAdapter.sendStreamAsync(reqInfo);
    }

    /**
     * Gets the logs for a build.
     * @param buildId ID of the build.
     * @return BuildLogs future object {@link BuildLogs}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildLogs> getLogs(int buildId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        return requestAdapter.sendAsync(reqInfo, BuildLogs.class);
    }

    /**
     * Gets the logs for a build as zip content.
     * @param buildId ID of the build.
     * @return CompletableFuture of Input stream of logs.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getLogsAsZip(int buildId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        reqInfo.requestHeaders.add(CustomHeader.STREAM_ZIP_ACCEPT);
        return requestAdapter.sendStreamAsync(reqInfo);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        @QueryParameter(name = "startLine")
        public int startLine;
        @QueryParameter(name = "endLine")
        public int endLine;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Constructs the request information for Build logs api.
     * @param buildId ID of the build.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(int buildId, Consumer<RequestConfiguration> requestConfig) {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/logs";
        if (requestConfig != null) {
            final var config = new RequestConfiguration();
            requestConfig.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }
        return reqInfo;
    }
}
