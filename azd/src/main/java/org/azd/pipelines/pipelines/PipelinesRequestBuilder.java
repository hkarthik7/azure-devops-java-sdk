package org.azd.pipelines.pipelines;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.pipelines.types.CreatePipelineParameters;
import org.azd.pipelines.types.Pipeline;
import org.azd.pipelines.types.Pipelines;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Pipelines Api.
 */
public class PipelinesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PipelinesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "pipelines", "28e1305e-2afe-47bf-abaf-cbb0e6a91988", ApiVersion.PIPELINES);
    }

    /**
     * Create a pipeline.
     *
     * @param createPipelineParameters Parameter to create the pipeline.
     * @return Pipeline object once the pipeline is successfully created. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Pipeline> createAsync(CreatePipelineParameters createPipelineParameters) throws AzDException {
        return builder()
                .POST(createPipelineParameters)
                .build()
                .executeAsync(Pipeline.class);
    }

    /**
     * Gets a pipeline.
     *
     * @param pipelineId ID of the pipeline.
     * @return Pipeline object once the pipeline is successfully created. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Pipeline> getAsync(String pipelineId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .executeAsync(Pipeline.class);
    }

    /**
     * Gets a pipeline at the specified version.
     *
     * @param pipelineId      ID of the pipeline.
     * @param pipelineVersion The pipeline version.
     * @return Pipeline object. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Pipeline> getAsync(String pipelineId, int pipelineVersion) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .query("pipelineVersion", pipelineVersion)
                .build()
                .executeAsync(Pipeline.class);
    }

    /**
     * Gets a list of pipelines.
     *
     * @return List of Pipeline object. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Pipelines> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Pipelines.class);
    }

    /**
     * Gets a list of pipelines.
     *
     * @return List of Pipeline object. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Pipelines> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Pipelines.class);
    }

    /**
     * Create a pipeline.
     *
     * @param createPipelineParameters Parameter to create the pipeline.
     * @return Pipeline object once the pipeline is successfully created. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public Pipeline create(CreatePipelineParameters createPipelineParameters) throws AzDException {
        return builder()
                .POST(createPipelineParameters)
                .build()
                .execute(Pipeline.class);
    }

    /**
     * Gets a pipeline.
     *
     * @param pipelineId ID of the pipeline.
     * @return Pipeline object once the pipeline is successfully created. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public Pipeline get(String pipelineId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .execute(Pipeline.class);
    }

    /**
     * Gets a pipeline at the specified version.
     *
     * @param pipelineId      ID of the pipeline.
     * @param pipelineVersion The pipeline version.
     * @return Pipeline object. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public Pipeline get(String pipelineId, int pipelineVersion) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .query("pipelineVersion", pipelineVersion)
                .build()
                .execute(Pipeline.class);
    }

    /**
     * Gets a list of pipelines.
     *
     * @return List of Pipeline object. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public Pipelines list() throws AzDException {
        return builder()
                .build()
                .execute(Pipelines.class);
    }

    /**
     * Gets a list of pipelines.
     *
     * @return List of Pipeline object. {@link Pipeline}
     * @throws AzDException Default Api exception handler.
     */
    public Pipelines list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Pipelines.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The maximum number of pipelines to return
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * A continuation token from a previous request, to retrieve the next page of results
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * A sort expression. Defaults to "name asc"
         */
        @QueryParameter(name = "orderBy")
        public String orderBy;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
