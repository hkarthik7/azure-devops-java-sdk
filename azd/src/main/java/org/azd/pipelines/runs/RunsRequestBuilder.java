package org.azd.pipelines.runs;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.pipelines.types.PipelineRun;
import org.azd.pipelines.types.PipelineRuns;
import org.azd.pipelines.types.RunPipelineParameters;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Pipelines runs Api.
 */
public class RunsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RunsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "pipelines", "7859261e-d2e9-4a68-b820-a5d84cc5bb3d", ApiVersion.PIPELINES);
    }

    /**
     * Gets a run for a particular pipeline.
     *
     * @param pipelineId The pipeline id
     * @param runId      The run id
     * @return Pipeline run object {@link PipelineRun}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PipelineRun> getAsync(int pipelineId, int runId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .build()
                .executeAsync(PipelineRun.class);
    }

    /**
     * Gets top 10000 runs for a particular pipeline.
     *
     * @param pipelineId The pipeline id
     * @return a list of pipeline run object {@link PipelineRuns}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PipelineRuns> listAsync(int pipelineId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .executeAsync(PipelineRuns.class);
    }

    /**
     * Runs a pipeline.
     *
     * @param pipelineId            The pipeline id
     * @param runPipelineParameters Request parameters to run pipeline.
     * @return a pipeline run object {@link PipelineRun}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PipelineRun> runAsync(int pipelineId, RunPipelineParameters runPipelineParameters) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .executeAsync(PipelineRun.class);
    }

    /**
     * Runs a pipeline.
     *
     * @param pipelineId            The pipeline id
     * @param runPipelineParameters Request parameters to run pipeline.
     * @param pipelineVersion       The pipeline version.
     * @return a pipeline run object {@link PipelineRun}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PipelineRun> runAsync(int pipelineId, RunPipelineParameters runPipelineParameters,
                                                   int pipelineVersion) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .query("pipelineVersion", pipelineVersion)
                .build()
                .executeAsync(PipelineRun.class);
    }

    /**
     * Gets a run for a particular pipeline.
     *
     * @param pipelineId The pipeline id
     * @param runId      The run id
     * @return Pipeline run object {@link PipelineRun}
     * @throws AzDException Default Api Exception handler.
     */
    public PipelineRun get(int pipelineId, int runId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .build()
                .execute(PipelineRun.class);
    }

    /**
     * Gets top 10000 runs for a particular pipeline.
     *
     * @param pipelineId The pipeline id
     * @return a list of pipeline run object {@link PipelineRuns}
     * @throws AzDException Default Api Exception handler.
     */
    public PipelineRuns list(int pipelineId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .execute(PipelineRuns.class);
    }

    /**
     * Runs a pipeline.
     *
     * @param pipelineId            The pipeline id
     * @param runPipelineParameters Request parameters to run pipeline.
     * @return a pipeline run object {@link PipelineRun}
     * @throws AzDException Default Api Exception handler.
     */
    public PipelineRun run(int pipelineId, RunPipelineParameters runPipelineParameters) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .build()
                .execute(PipelineRun.class);
    }

    /**
     * Runs a pipeline.
     *
     * @param pipelineId            The pipeline id
     * @param runPipelineParameters Request parameters to run pipeline.
     * @param pipelineVersion       The pipeline version.
     * @return a pipeline run object {@link PipelineRun}
     * @throws AzDException Default Api Exception handler.
     */
    public PipelineRun run(int pipelineId, RunPipelineParameters runPipelineParameters,
                           int pipelineVersion) throws AzDException {
        return builder()
                .POST(runPipelineParameters)
                .serviceEndpoint("pipelineId", pipelineId)
                .query("pipelineVersion", pipelineVersion)
                .build()
                .execute(PipelineRun.class);
    }
}
