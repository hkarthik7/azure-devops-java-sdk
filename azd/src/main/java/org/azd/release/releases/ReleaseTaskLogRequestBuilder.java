package org.azd.release.releases;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Release releases task log Api.
 */
public class ReleaseTaskLogRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ReleaseTaskLogRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Gets the task log of a release as a plain text file.
     *
     * @param uriParameters Represents the URI parameters
     * @return Logs in plain text
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<String> getAsync(Consumer<UriParameters> uriParameters) throws AzDException {
        Objects.requireNonNull(uriParameters, "URI parameters cannot be null.");

        final var pathParams = new UriParameters();
        uriParameters.accept(pathParams);

        return builder()
                .serviceEndpoint("releaseId", pathParams.releaseId)
                .serviceEndpoint("environmentId", pathParams.environmentId)
                .serviceEndpoint("releaseDeployPhaseId", pathParams.releaseDeployPhaseId)
                .serviceEndpoint("taskId", pathParams.taskId)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeStringAsync();
    }

    /**
     * Gets the task log of a release as a plain text file.
     *
     * @param uriParameters        Represents the URI parameters
     * @param requestConfiguration Represents the query parameters.
     * @return Logs in plain text
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<String> getAsync(Consumer<UriParameters> uriParameters,
                                              Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        Objects.requireNonNull(uriParameters, "URI parameters cannot be null.");

        final var pathParams = new UriParameters();
        uriParameters.accept(pathParams);

        return builder()
                .serviceEndpoint("releaseId", pathParams.releaseId)
                .serviceEndpoint("environmentId", pathParams.environmentId)
                .serviceEndpoint("releaseDeployPhaseId", pathParams.releaseDeployPhaseId)
                .serviceEndpoint("taskId", pathParams.taskId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeStringAsync();
    }

    /**
     * Gets the task log of a release as a plain text file.
     *
     * @param uriParameters Represents the URI parameters
     * @return Logs in plain text
     * @throws AzDException Default Api exception handler.
     */
    public String get(Consumer<UriParameters> uriParameters) throws AzDException {
        Objects.requireNonNull(uriParameters, "URI parameters cannot be null.");

        final var pathParams = new UriParameters();
        uriParameters.accept(pathParams);

        return builder()
                .serviceEndpoint("releaseId", pathParams.releaseId)
                .serviceEndpoint("environmentId", pathParams.environmentId)
                .serviceEndpoint("releaseDeployPhaseId", pathParams.releaseDeployPhaseId)
                .serviceEndpoint("taskId", pathParams.taskId)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeString();
    }

    /**
     * Gets the task log of a release as a plain text file.
     *
     * @param uriParameters        Represents the URI parameters
     * @param requestConfiguration Represents the query parameters.
     * @return Logs in plain text
     * @throws AzDException Default Api exception handler.
     */
    public String get(Consumer<UriParameters> uriParameters,
                      Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        Objects.requireNonNull(uriParameters, "URI parameters cannot be null.");

        final var pathParams = new UriParameters();
        uriParameters.accept(pathParams);

        return builder()
                .serviceEndpoint("releaseId", pathParams.releaseId)
                .serviceEndpoint("environmentId", pathParams.environmentId)
                .serviceEndpoint("releaseDeployPhaseId", pathParams.releaseDeployPhaseId)
                .serviceEndpoint("taskId", pathParams.taskId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeString();
    }

    /**
     * Represents the Uri parameters
     */
    public static class UriParameters {
        /**
         * Id of release environment.
         */
        public int environmentId;
        /**
         * Release deploy phase Id.
         */
        public int releaseDeployPhaseId;
        /**
         * Id of the release.
         */
        public int releaseId;
        /**
         * ReleaseTask Id for the log.
         */
        public int taskId;
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Starting line number for logs
         */
        @QueryParameter(name = "startLine")
        public Integer startLine;
        /**
         * Ending line number for logs
         */
        @QueryParameter(name = "endLine")
        public Integer endLine;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
