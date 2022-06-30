package org.azd.interfaces;

import org.azd.enums.PipelinesExpandOptions;
import org.azd.exceptions.AzDException;
import org.azd.pipelines.types.*;

import java.util.Map;

public interface PipelinesDetails {
    PipelinesArtifact getArtifacts(int pipelineId, int runId, String artifactName) throws AzDException;

    PipelinesArtifact getArtifacts(int pipelineId, int runId, String artifactName,
                                   PipelinesExpandOptions expandOptions) throws AzDException;

    PipelineLog getPipelineLog(int pipelineId, int runId, int logId) throws AzDException;

    PipelineLog getPipelineLog(int pipelineId, int runId, int logId, PipelinesExpandOptions expandOptions) throws AzDException;

    LogCollection getPipelineLogs(int pipelineId, int runId) throws AzDException;

    LogCollection getPipelineLogs(int pipelineId, int runId, PipelinesExpandOptions expandOptions) throws AzDException;

    Pipeline createPipeline(String name, String folder, String pathOfYamlFile, String repositoryId, String repositoryName)
            throws AzDException;

    Pipeline getPipeline(int pipelineId) throws AzDException;

    Pipeline getPipeline(int pipelineId, String pipelineVersion) throws AzDException;

    Pipelines getPipelines() throws AzDException;

    PreviewRun previewPipeline(int pipelineId, boolean previewRun) throws AzDException;

    PreviewRun previewPipeline(int pipelineId, boolean previewRun, String yamlOverride) throws AzDException;

    PipelineRun getPipelineRun(int pipelineId, int runId) throws AzDException;

    PipelineRuns getPipelineRuns(int pipelineId) throws AzDException;

    PipelineRun runPipeline(int pipelineId) throws AzDException;

    PipelineRun runPipeline(int pipelineId, Map pipelineRunParameters) throws AzDException;
}
