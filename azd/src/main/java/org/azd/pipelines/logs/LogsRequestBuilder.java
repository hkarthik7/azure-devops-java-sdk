package org.azd.pipelines.logs;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.GetLogExpandOptions;
import org.azd.exceptions.AzDException;
import org.azd.pipelines.types.LogCollection;
import org.azd.pipelines.types.PipelineLog;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Pipelines logs Api.
 */
public class LogsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public LogsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "pipelines", "fb1b6d27-3957-43d5-a14b-a2d70403e545");
    }

    /**
     * Get a specific log from a pipeline run
     *
     * @param pipelineId ID of the pipeline.
     * @param runId      ID of the run of that pipeline.
     * @param logId      ID of the log.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PipelineLog> getAsync(int pipelineId, int runId, int logId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("logId", logId)
                .build()
                .executeAsync(PipelineLog.class);
    }

    /**
     * Get a specific log from a pipeline run
     *
     * @param pipelineId       ID of the pipeline.
     * @param runId            ID of the run of that pipeline.
     * @param logId            ID of the log.
     * @param logExpandOptions Expand options. Default is None.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PipelineLog> getAsync(int pipelineId, int runId, int logId, GetLogExpandOptions logExpandOptions) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("logId", logId)
                .query("$expand", logExpandOptions.name())
                .build()
                .executeAsync(PipelineLog.class);
    }

    /**
     * Get a list of logs from a pipeline run.
     *
     * @param pipelineId ID of the pipeline.
     * @param runId      ID of the run of that pipeline.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<LogCollection> listAsync(int pipelineId, int runId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .build()
                .executeAsync(LogCollection.class);
    }

    /**
     * Get a list of logs from a pipeline run.
     *
     * @param pipelineId       ID of the pipeline.
     * @param runId            ID of the run of that pipeline.
     * @param logExpandOptions Expand options. Default is None.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<LogCollection> listAsync(int pipelineId, int runId, GetLogExpandOptions logExpandOptions) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .query("$expand", logExpandOptions.name())
                .build()
                .executeAsync(LogCollection.class);
    }

    /**
     * Get a specific log from a pipeline run
     *
     * @param pipelineId ID of the pipeline.
     * @param runId      ID of the run of that pipeline.
     * @param logId      ID of the log.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public PipelineLog get(int pipelineId, int runId, int logId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("logId", logId)
                .build()
                .execute(PipelineLog.class);
    }

    /**
     * Get a specific log from a pipeline run
     *
     * @param pipelineId       ID of the pipeline.
     * @param runId            ID of the run of that pipeline.
     * @param logId            ID of the log.
     * @param logExpandOptions Expand options. Default is None.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public PipelineLog get(int pipelineId, int runId, int logId, GetLogExpandOptions logExpandOptions) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .serviceEndpoint("logId", logId)
                .query("$expand", logExpandOptions.name())
                .build()
                .execute(PipelineLog.class);
    }

    /**
     * Get a list of logs from a pipeline run.
     *
     * @param pipelineId ID of the pipeline.
     * @param runId      ID of the run of that pipeline.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public LogCollection list(int pipelineId, int runId) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .build()
                .execute(LogCollection.class);
    }

    /**
     * Get a list of logs from a pipeline run.
     *
     * @param pipelineId       ID of the pipeline.
     * @param runId            ID of the run of that pipeline.
     * @param logExpandOptions Expand options. Default is None.
     * @return Pipeline log object {@link PipelineLog}.
     * @throws AzDException Default Api exception handler.
     */
    public LogCollection list(int pipelineId, int runId, GetLogExpandOptions logExpandOptions) throws AzDException {
        return builder()
                .serviceEndpoint("pipelineId", pipelineId)
                .serviceEndpoint("runId", runId)
                .query("$expand", logExpandOptions.toString())
                .build()
                .execute(LogCollection.class);
    }
}
