package org.azd.interfaces;

import org.azd.build.types.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;

import java.util.HashMap;
import java.util.Map;

public interface BuildDetails {
    void deleteBuild(int buildId) throws DefaultParametersException, AzDException;

    Build getBuild(int buildId) throws DefaultParametersException, AzDException;

    BuildChanges getBuildChanges(int buildId) throws DefaultParametersException, AzDException;

    BuildChanges getBuildChanges(
            int buildId, int top, String continuationToken, boolean includeSourceChange) throws DefaultParametersException, AzDException;

    String getBuildLog(int buildId, int logId) throws DefaultParametersException, AzDException;

    String getBuildLog(int buildId, int logId, long startLine, long endLine) throws DefaultParametersException, AzDException;

    BuildLogs getBuildLogs(int buildId) throws DefaultParametersException, AzDException;

    BuildWorkItems getBuildWorkItems(int buildId) throws DefaultParametersException, AzDException;

    BuildWorkItems getBuildWorkItems(int buildId, int top) throws DefaultParametersException, AzDException;

    BuildChanges getChangesBetweenBuilds(int fromBuildId, int toBuildId, int top) throws DefaultParametersException, AzDException;

    BuildWorkItems getWorkItemsBetweenBuilds(int fromBuildId, int toBuildId, int top) throws DefaultParametersException, AzDException;

    Builds getBuilds() throws DefaultParametersException, AzDException;

    Builds getBuilds(int[] buildIds) throws DefaultParametersException, AzDException;

    Builds getBuilds(int top) throws DefaultParametersException, AzDException;

    Builds getBuilds(
            int top, String branchName, String buildNumber, String continuationToken, int[] definitions,
            String deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, String queryOrder, int[] queues, String reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, String resultFilter,
            String statusFilter, String tagFilters) throws DefaultParametersException, AzDException;

    Build queueBuild(int definitionId) throws DefaultParametersException, AzDException;

    Build queueBuild(HashMap<String, Object> buildParameters) throws DefaultParametersException, AzDException;

    BuildControllers getBuildControllers() throws DefaultParametersException, AzDException;

    BuildControllers getBuildControllers(String name) throws DefaultParametersException, AzDException;

    BuildController getBuildController(int controllerId) throws DefaultParametersException, AzDException;

    BuildDefinition createBuildDefinition(String buildDefinitionParameters) throws DefaultParametersException, AzDException;

    void deleteBuildDefinition(int definitionId) throws DefaultParametersException, AzDException;

    BuildDefinition getBuildDefinition(int definitionId) throws DefaultParametersException, AzDException;

    BuildDefinition getBuildDefinition(
            int definitionId, boolean includeLatestBuilds, String minMetricsTime, int revision) throws DefaultParametersException, AzDException;

    BuildDefinitionRevisions getBuildDefinitionRevisions(int definitionId) throws DefaultParametersException, AzDException;

    BuildDefinitions getBuildDefinitions() throws DefaultParametersException, AzDException;

    BuildDefinitions getBuildDefinitions(int[] definitionIds) throws DefaultParametersException, AzDException;

    BuildDefinitions getBuildDefinitions(int top) throws DefaultParametersException, AzDException;

    BuildDefinitions getBuildDefinitions(String name) throws DefaultParametersException, AzDException;

    Map getBuildDefinitions(
            String builtAfter, String continuationToken, boolean includeAllProperties,
            boolean includeLatestBuilds, String minMetricsTime, String notBuiltAfter,
            String path, int processType, String queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) throws DefaultParametersException, AzDException;

    BuildDefinition restoreBuildDefinition(int definitionId, boolean deleted) throws DefaultParametersException, AzDException;
}
