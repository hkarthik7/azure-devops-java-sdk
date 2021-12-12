package org.azd.pipelines;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.PipelinesExpandOptions;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.git.GitApi;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.PipelinesDetails;
import org.azd.pipelines.types.*;

import java.util.HashMap;
import java.util.Map;

import static org.azd.utils.Client.send;

/***
 * PipelinesApi class to manage Pipelines API
 */
public class PipelinesApi implements PipelinesDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "pipelines";
    private final String PIPELINES = "2e0bf237-8973-4ec9-a581-9c3d679d1776";

    /***
     * Pass the connection object to work with Pipelines Api
     * @param connection Connection object
     */
    public PipelinesApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Get a specific artifact from a pipeline run
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @param artifactName Name of the artifact.
     * @return PipelinesArtifact object {@link PipelinesArtifact}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelinesArtifact getArtifacts(int pipelineId, int runId, String artifactName) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("artifactName", artifactName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs/" + runId + "/artifacts", ApiVersion.PIPELINES, q, null);

        return MAPPER.mapJsonResponse(r, PipelinesArtifact.class);
    }

    /***
     * Get a specific artifact from a pipeline run
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @param artifactName Name of the artifact.
     * @param expandOptions Expand options. Default is None. {@link PipelinesExpandOptions}
     * @return PipelinesArtifact object {@link PipelinesArtifact}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelinesArtifact getArtifacts(int pipelineId, int runId, String artifactName, PipelinesExpandOptions expandOptions)
            throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("artifactName", artifactName);
            put("$expand", expandOptions.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs/" + runId + "/artifacts", ApiVersion.PIPELINES, q, null);

        return MAPPER.mapJsonResponse(r, PipelinesArtifact.class);
    }

    /***
     * Get a specific log from a pipeline run
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @param logId ID of the log.
     * @return PipelineLog object {@link PipelineLog}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelineLog getPipelineLog(int pipelineId, int runId, int logId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs/" + runId + "/logs/" + logId, ApiVersion.PIPELINES, null, null);

        return MAPPER.mapJsonResponse(r, PipelineLog.class);
    }

    /***
     * Get a specific log from a pipeline run
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @param logId ID of the log.
     * @param expandOptions Expand options. Default is None. {@link PipelinesExpandOptions}
     * @return PipelineLog object {@link PipelineLog}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelineLog getPipelineLog(int pipelineId, int runId, int logId, PipelinesExpandOptions expandOptions) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expandOptions.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs/" + runId + "/logs/" + logId, ApiVersion.PIPELINES, q, null);

        return MAPPER.mapJsonResponse(r, PipelineLog.class);
    }

    /***
     * Get a list of logs from a pipeline run.
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @return LogCollection object {@link LogCollection}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public LogCollection getPipelineLogs(int pipelineId, int runId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs/" + runId + "/logs", ApiVersion.PIPELINES, null, null);

        return MAPPER.mapJsonResponse(r, LogCollection.class);
    }

    /***
     * Get a list of logs from a pipeline run.
     * @param pipelineId ID of the pipeline.
     * @param runId ID of the run of that pipeline.
     * @param expandOptions Expand options. Default is None. {@link PipelinesExpandOptions}
     * @return LogCollection object {@link LogCollection}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public LogCollection getPipelineLogs(int pipelineId, int runId, PipelinesExpandOptions expandOptions) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expandOptions.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs/" + runId + "/logs", ApiVersion.PIPELINES, null, null);

        return MAPPER.mapJsonResponse(r, LogCollection.class);
    }

    /***
     * Create a pipeline.
     * @param name Name of the pipeline.
     * @param folder Folder of the pipeline.
     * @param pathOfYamlFile Path of azure-pipelines.yaml file in the repository.
     * @param repositoryId Id of the repository
     * @param repositoryName Name of the repository
     * @return Pipeline object {@link Pipeline}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Pipeline createPipeline(String name, String folder, String pathOfYamlFile, String repositoryId, String repositoryName) throws ConnectionException, AzDException {
        var git = new GitApi(CONNECTION);

        var body = new HashMap<String, Object>(){{
            put("name", name);
            put("folder", folder);
            put("configuration", new HashMap<>(){{
                put("type", "yaml");
                put("path", pathOfYamlFile);
                put("repository", new HashMap<>(){{
                    put("id", repositoryId);
                    put("name", repositoryName);
                    put("type", "azureReposGit");
                }});
            }});
        }};

        String r = send(RequestMethod.POST, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.PIPELINES, null, body);

        return MAPPER.mapJsonResponse(r, Pipeline.class);
    }

    /***
     * Gets a pipeline, optionally at the specified version
     * @param pipelineId The pipeline ID
     * @return Pipeline object {@link Pipeline}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Pipeline getPipeline(int pipelineId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), null, ApiVersion.PIPELINES, null, null);

        return MAPPER.mapJsonResponse(r, Pipeline.class);
    }

    /***
     * Gets a pipeline, optionally at the specified version
     * @param pipelineId The pipeline ID
     * @param pipelineVersion The pipeline version
     * @return Pipeline object {@link Pipeline}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Pipeline getPipeline(int pipelineId, String pipelineVersion) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("pipelineVersion", pipelineVersion);
        }};

        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), null, ApiVersion.PIPELINES, q, null);

        return MAPPER.mapJsonResponse(r, Pipeline.class);
    }

    /***
     * Get a list of pipelines.
     * @return Pipelines {@link Pipelines}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Pipelines getPipelines() throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, null, null, ApiVersion.PIPELINES, null, null);

        return MAPPER.mapJsonResponse(r, Pipelines.class);
    }

    /***
     * Queues a dry run of the pipeline and returns an object containing the final yaml.
     * @param pipelineId The pipeline ID.
     * @param previewRun If true, don't actually create a new run. Instead, return the final YAML document after parsing templates.
     * @return PreviewRun object {@link PreviewRun}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PreviewRun previewPipeline(int pipelineId, boolean previewRun) throws ConnectionException, AzDException {
        var body = new HashMap<String, Object>(){{
            put("previewRun", previewRun);
        }};

        String r = send(RequestMethod.POST, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "preview", ApiVersion.PIPELINES, null, body);

        return MAPPER.mapJsonResponse(r, PreviewRun.class);
    }

    /***
     * Queues a dry run of the pipeline and returns an object containing the final yaml.
     * @param pipelineId The pipeline ID.
     * @param previewRun If true, don't actually create a new run. Instead, return the final YAML document after parsing templates.
     * @param yamlOverride If you use the preview run option, you may optionally supply different YAML.
     * This allows you to preview the final YAML document without committing a changed file.
     * @return PreviewRun object {@link PreviewRun}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PreviewRun previewPipeline(int pipelineId, boolean previewRun, String yamlOverride) throws ConnectionException, AzDException {
        var body = new HashMap<String, Object>(){{
            put("previewRun", previewRun);
            put("yamlOverride", yamlOverride);
        }};

        String r = send(RequestMethod.POST, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "preview", ApiVersion.PIPELINES, null, body);

        return MAPPER.mapJsonResponse(r, PreviewRun.class);
    }

    /***
     * Gets a run for a particular pipeline.
     * @param pipelineId The pipeline id
     * @param runId The run id
     * @return Pipeline run object {@link PipelineRun}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelineRun getPipelineRun(int pipelineId, int runId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs/" + runId, ApiVersion.PIPELINES, null, null);

        return MAPPER.mapJsonResponse(r, PipelineRun.class);
    }

    /***
     * Gets top 10000 runs for a particular pipeline.
     * @param pipelineId The pipeline id
     * @return a list of pipeline run object {@link PipelineRuns}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelineRuns getPipelineRuns(int pipelineId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs", ApiVersion.PIPELINES, null, null);

        return MAPPER.mapJsonResponse(r, PipelineRuns.class);
    }

    /***
     * Runs a pipeline.
     * @param pipelineId The pipeline id
     * @return a pipeline run object {@link PipelineRun}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelineRun runPipeline(int pipelineId) throws ConnectionException, AzDException {
        var body = new HashMap<String, Object>(){{
           put("resources", "{}");
        }};

        String r = send(RequestMethod.POST, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs", ApiVersion.PIPELINES, null, body);

        return MAPPER.mapJsonResponse(r, PipelineRun.class);
    }

    /***
     * Runs a pipeline.
     * @param pipelineId The pipeline id
     * @param pipelineRunParameters a map of request parameters.
     * @return a pipeline run object {@link PipelineRun}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PipelineRun runPipeline(int pipelineId, Map pipelineRunParameters) throws ConnectionException, AzDException {
        String r = send(RequestMethod.POST, CONNECTION, PIPELINES, CONNECTION.getProject(),
                AREA, Integer.toString(pipelineId), "runs", ApiVersion.PIPELINES, null, pipelineRunParameters);

        return MAPPER.mapJsonResponse(r, PipelineRun.class);
    }
}
