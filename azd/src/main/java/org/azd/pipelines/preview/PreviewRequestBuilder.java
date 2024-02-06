package org.azd.pipelines.preview;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.pipelines.types.PreviewRun;
import org.azd.pipelines.types.RunPipelineParameters;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Pipelines preview Api.
 */
public class PreviewRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PreviewRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "pipelines", "53df2d18-29ea-46a9-bee0-933540f80abf");
    }

    /**
     * Queues a dry run of the pipeline and returns an object containing the final yaml.
     *
     * @param pipelineId            ID of the pipeline.
     * @param runPipelineParameters Run parameters to queue dry run.
     * @return Preview run object {@link PreviewRun}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PreviewRun> previewAsync(String pipelineId, RunPipelineParameters runPipelineParameters) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .executeAsync(PreviewRun.class);
    }

    /**
     * Queues a dry run of the pipeline and returns an object containing the final yaml.
     *
     * @param pipelineId            ID of the pipeline.
     * @param runPipelineParameters Run parameters to queue dry run.
     * @param pipelineVersion       The pipeline version
     * @return Preview run object {@link PreviewRun}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PreviewRun> previewAsync(String pipelineId, RunPipelineParameters runPipelineParameters,
                                                      int pipelineVersion) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .query("pipelineVersion", pipelineVersion)
                .build()
                .executeAsync(PreviewRun.class);
    }

    /**
     * Queues a dry run of the pipeline and returns an object containing the final yaml.
     *
     * @param pipelineId            ID of the pipeline.
     * @param runPipelineParameters Run parameters to queue dry run.
     * @return Preview run object {@link PreviewRun}
     * @throws AzDException Default Api exception handler.
     */
    public PreviewRun preview(String pipelineId, RunPipelineParameters runPipelineParameters) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .execute(PreviewRun.class);
    }

    /**
     * Queues a dry run of the pipeline and returns an object containing the final yaml.
     *
     * @param pipelineId            ID of the pipeline.
     * @param runPipelineParameters Run parameters to queue dry run.
     * @param pipelineVersion       The pipeline version
     * @return Preview run object {@link PreviewRun}
     * @throws AzDException Default Api exception handler.
     */
    public PreviewRun preview(String pipelineId, RunPipelineParameters runPipelineParameters,
                                                      int pipelineVersion) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .query("pipelineVersion", pipelineVersion)
                .build()
                .execute(PreviewRun.class);
    }
}
