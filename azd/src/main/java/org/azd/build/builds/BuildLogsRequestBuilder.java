package org.azd.build.builds;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildLogs;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Build Logs Api.
 */
public class BuildLogsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildLogsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "35a80daf-7f30-45fc-86e8-6b813d9c90df");
    }

    /**
     * Gets an individual log file for a build.
     *
     * @param buildId ID of the build.
     * @param logId   ID of the log file.
     * @return Future string object or plain text.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<String> getAsync(int buildId, int logId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("logId", logId)
                .build()
                .executeStringAsync();
    }

    /**
     * Gets an individual log file for a build as plain text.
     *
     * @param buildId              ID of the build.
     * @param logId                ID of the log file.
     * @param requestConfiguration Consumer of query parameters.
     * @return String object or plain text.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<String> getAsync(int buildId, int logId,
                                              Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("logId", logId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeStringAsync();
    }

    /**
     * Gets an individual log file for a build as a zip file.
     *
     * @param buildId ID of the build.
     * @param logId   ID of the log file.
     * @return Input stream of logs.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZipAsync(int buildId, int logId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("logId", logId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Gets the logs for a build.
     *
     * @param buildId ID of the build.
     * @return BuildLogs future object {@link BuildLogs}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<BuildLogs> getAsync(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(BuildLogs.class);
    }

    /**
     * Gets the logs for a build as zip content.
     *
     * @param buildId ID of the build.
     * @return CompletableFuture of Input stream of logs.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZipAsync(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Gets an individual log file for a build.
     *
     * @param buildId ID of the build.
     * @param logId   ID of the log file.
     * @return String object or plain text.
     * @throws AzDException Default Api exception handler.
     */
    public String get(int buildId, int logId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("logId", logId)
                .build()
                .executeString();
    }

    /**
     * Gets an individual log file for a build as plain text.
     *
     * @param buildId              ID of the build.
     * @param logId                ID of the log file.
     * @param requestConfiguration Consumer of query parameters.
     * @return String object or plain text.
     * @throws AzDException Default Api exception handler.
     */
    public String get(int buildId, int logId,
                      Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("logId", logId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeString();
    }

    /**
     * Gets an individual log file for a build as a zip file.
     *
     * @param buildId ID of the build.
     * @param logId   ID of the log file.
     * @return Input stream of logs.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getAsZip(int buildId, int logId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("logId", logId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Gets the logs for a build.
     *
     * @param buildId ID of the build.
     * @return BuildLogs future object {@link BuildLogs}
     * @throws AzDException Default Api exception handler.
     */
    public BuildLogs get(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(BuildLogs.class);
    }

    /**
     * Gets the logs for a build as zip content.
     *
     * @param buildId ID of the build.
     * @return Input stream of logs.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getAsZip(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        @QueryParameter(name = "startLine")
        public long startLine;
        @QueryParameter(name = "endLine")
        public long endLine;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
