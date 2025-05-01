package org.azd.pipelines.artifacts;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.GetArtifactExpandOptions;
import org.azd.exceptions.AzDException;
import org.azd.pipelines.types.PipelinesArtifact;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Pipelines artifacts Api.
 */
public class ArtifactsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ArtifactsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "pipelines", "85023071-bd5e-4438-89b0-2a5bf362a19d", ApiVersion.PIPELINES);
    }

    /**
     * Get a specific artifact from a pipeline run
     *
     * @param pipelineId           ID of the pipeline.
     * @param runId                ID of the run of that pipeline.
     * @param requestConfiguration Represents query parameters.
     * @return Pipelines artifact object {@link PipelinesArtifact}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PipelinesArtifact> getAsync(int pipelineId, int runId,
                                                         Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PipelinesArtifact.class);

    }

    /**
     * Get a specific artifact from a pipeline run
     *
     * @param pipelineId           ID of the pipeline.
     * @param runId                ID of the run of that pipeline.
     * @param requestConfiguration Represents query parameters.
     * @return Pipelines artifact object {@link PipelinesArtifact}
     * @throws AzDException Default Api exception handler.
     */
    public PipelinesArtifact get(int pipelineId, int runId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PipelinesArtifact.class);

    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Name of the artifact.
         */
        @QueryParameter(name = "artifactName")
        public String artifactName;
        /**
         * Expand options. Default is None.
         */
        @QueryParameter(name = "$expand")
        public GetArtifactExpandOptions expand;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
