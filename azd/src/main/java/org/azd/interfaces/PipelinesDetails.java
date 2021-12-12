package org.azd.interfaces;

import org.azd.enums.PipelinesExpandOptions;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.pipelines.types.*;

import java.util.Map;

public interface PipelinesDetails {
    PipelinesArtifact getArtifacts(int pipelineId, int runId, String artifactName) throws ConnectionException, AzDException;
    PipelinesArtifact getArtifacts(int pipelineId, int runId, String artifactName,
                                   PipelinesExpandOptions expandOptions) throws ConnectionException, AzDException;
    PipelineLog getPipelineLog(int pipelineId, int runId, int logId) throws ConnectionException, AzDException;
    PipelineLog getPipelineLog(int pipelineId, int runId, int logId, PipelinesExpandOptions expandOptions) throws ConnectionException, AzDException;
    LogCollection getPipelineLogs(int pipelineId, int runId) throws ConnectionException, AzDException;
    LogCollection getPipelineLogs(int pipelineId, int runId, PipelinesExpandOptions expandOptions) throws ConnectionException, AzDException;
    Pipeline createPipeline(String name, String folder, String pathOfYamlFile, String repositoryId, String repositoryName)
            throws ConnectionException, AzDException;
    Pipeline getPipeline(int pipelineId) throws ConnectionException, AzDException;
    Pipeline getPipeline(int pipelineId, String pipelineVersion) throws ConnectionException, AzDException;
    Pipelines getPipelines() throws ConnectionException, AzDException;
    PreviewRun previewPipeline(int pipelineId, boolean previewRun) throws ConnectionException, AzDException;
    PreviewRun previewPipeline(int pipelineId, boolean previewRun, String yamlOverride) throws ConnectionException, AzDException;
    PipelineRun getPipelineRun(int pipelineId, int runId) throws ConnectionException, AzDException;
    PipelineRuns getPipelineRuns(int pipelineId) throws ConnectionException, AzDException;
    PipelineRun runPipeline(int pipelineId) throws ConnectionException, AzDException;
    PipelineRun runPipeline(int pipelineId, Map pipelineRunParameters) throws ConnectionException, AzDException;
}
