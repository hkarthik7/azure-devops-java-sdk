package org.azd.interfaces;

import org.azd.build.types.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;

import java.util.HashMap;
import java.util.Map;

public interface BuildDetails {
    void deleteBuild(int buildId) throws ConnectionException, AzDException;

    Build getBuild(int buildId) throws ConnectionException, AzDException;

    BuildChanges getBuildChanges(int buildId) throws ConnectionException, AzDException;

    BuildChanges getBuildChanges(
            int buildId, int top, String continuationToken, boolean includeSourceChange) throws ConnectionException, AzDException;

    String getBuildLog(int buildId, int logId) throws ConnectionException, AzDException;

    String getBuildLog(int buildId, int logId, long startLine, long endLine) throws ConnectionException, AzDException;

    BuildLogs getBuildLogs(int buildId) throws ConnectionException, AzDException;

    BuildWorkItems getBuildWorkItems(int buildId) throws ConnectionException, AzDException;

    BuildWorkItems getBuildWorkItems(int buildId, int top) throws ConnectionException, AzDException;

    BuildChanges getChangesBetweenBuilds(int fromBuildId, int toBuildId, int top) throws ConnectionException, AzDException;

    BuildWorkItems getWorkItemsBetweenBuilds(int fromBuildId, int toBuildId, int top) throws ConnectionException, AzDException;

    Builds getBuilds() throws ConnectionException, AzDException;

    Builds getBuilds(int[] buildIds) throws ConnectionException, AzDException;

    Builds getBuilds(int top) throws ConnectionException, AzDException;

    Builds getBuilds(
            int top, String branchName, String buildNumber, String continuationToken, int[] definitions,
            String deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, String queryOrder, int[] queues, String reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, String resultFilter,
            String statusFilter, String tagFilters) throws ConnectionException, AzDException;

    Build queueBuild(int definitionId) throws ConnectionException, AzDException;

    Build queueBuild(HashMap<String, Object> buildParameters) throws ConnectionException, AzDException;

    BuildControllers getBuildControllers() throws ConnectionException, AzDException;

    BuildControllers getBuildControllers(String name) throws ConnectionException, AzDException;

    BuildController getBuildController(int controllerId) throws ConnectionException, AzDException;

    BuildDefinition createBuildDefinition(String buildDefinitionParameters) throws ConnectionException, AzDException;

    BuildDefinition cloneBuildDefinition(String definitionName, String definitionCloneName) throws ConnectionException, AzDException;

    void deleteBuildDefinition(int definitionId) throws ConnectionException, AzDException;

    BuildDefinition getBuildDefinition(int definitionId) throws ConnectionException, AzDException;

    BuildDefinition getBuildDefinition(
            int definitionId, boolean includeLatestBuilds, String minMetricsTime, int revision) throws ConnectionException, AzDException;

    BuildDefinitionRevisions getBuildDefinitionRevisions(int definitionId) throws ConnectionException, AzDException;

    BuildDefinitions getBuildDefinitions() throws ConnectionException, AzDException;

    BuildDefinitions getBuildDefinitions(int[] definitionIds) throws ConnectionException, AzDException;

    BuildDefinitions getBuildDefinitions(int top) throws ConnectionException, AzDException;

    BuildDefinitions getBuildDefinitions(String name) throws ConnectionException, AzDException;

    Map getBuildDefinitions(
            String builtAfter, String continuationToken, boolean includeAllProperties,
            boolean includeLatestBuilds, String minMetricsTime, String notBuiltAfter,
            String path, int processType, String queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) throws ConnectionException, AzDException;

    BuildDefinition restoreBuildDefinition(int definitionId, boolean deleted) throws ConnectionException, AzDException;

    BuildTags addBuildTag(int buildId, String tag) throws ConnectionException, AzDException;

    BuildTags addBuildTags(int buildId, String[] tags) throws ConnectionException, AzDException;

    BuildTags addDefinitionTag(int definitionId, String tag) throws ConnectionException, AzDException;

    BuildTags addDefinitionTags(int definitionId, String[] tags) throws ConnectionException, AzDException;

    BuildTags deleteBuildTag(int buildId, String tag) throws ConnectionException, AzDException;

    BuildTags deleteDefinitionTag(int definitionId, String tag) throws ConnectionException, AzDException;

    BuildTags deleteTag(String tag) throws ConnectionException, AzDException;

    BuildTags getBuildTags(int buildId) throws ConnectionException, AzDException;

    BuildTags getDefinitionTags(int definitionId) throws ConnectionException, AzDException;

    BuildTags getDefinitionTags(int definitionId, int revision) throws ConnectionException, AzDException;

    BuildTags getTags() throws ConnectionException, AzDException;

    BuildTags updateBuildTags(int buildId, String[] tags, boolean toRemove) throws ConnectionException, AzDException;

    BuildTags updateDefinitionTags(int definitionId, String[] tags, boolean toRemove) throws ConnectionException, AzDException;
}
