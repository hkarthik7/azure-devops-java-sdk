package org.azd.interfaces;

import org.azd.build.types.*;
import org.azd.enums.SourceProviderResultSet;
import org.azd.enums.StageUpdateType;
import org.azd.exceptions.AzDException;

import java.util.List;
import java.util.Map;

public interface BuildDetails {
    Void deleteBuild(int buildId) throws AzDException;

    Build getBuild(int buildId) throws AzDException;

    BuildChanges getBuildChanges(int buildId) throws AzDException;

    BuildChanges getBuildChanges(
            int buildId, int top, String continuationToken, boolean includeSourceChange) throws AzDException;

    String getBuildLog(int buildId, int logId) throws AzDException;

    String getBuildLog(int buildId, int logId, long startLine, long endLine) throws AzDException;

    BuildLogs getBuildLogs(int buildId) throws AzDException;

    BuildWorkItems getBuildWorkItems(int buildId) throws AzDException;

    BuildWorkItems getBuildWorkItems(int buildId, int top) throws AzDException;

    BuildChanges getChangesBetweenBuilds(int fromBuildId, int toBuildId, int top) throws AzDException;

    BuildWorkItems getWorkItemsBetweenBuilds(int fromBuildId, int toBuildId, int top) throws AzDException;

    Builds getBuilds() throws AzDException;

    Builds getBuilds(int[] buildIds) throws AzDException;

    Builds getBuilds(int top) throws AzDException;

    Builds getBuilds(
            int top, String branchName, String buildNumber, String continuationToken, int[] definitions,
            String deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, String queryOrder, int[] queues, String reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, String resultFilter,
            String statusFilter, String tagFilters) throws AzDException;

    Build queueBuild(int definitionId) throws AzDException;

    Build queueBuild(Map<String, Object> buildParameters) throws AzDException;

    BuildControllers getBuildControllers() throws AzDException;

    BuildControllers getBuildControllers(String name) throws AzDException;

    BuildController getBuildController(int controllerId) throws AzDException;

    BuildDefinition createBuildDefinition(String buildDefinitionParameters) throws AzDException;

    BuildDefinition cloneBuildDefinition(String definitionName, String definitionCloneName) throws AzDException;

    Void deleteBuildDefinition(int definitionId) throws AzDException;

    BuildDefinition getBuildDefinition(int definitionId) throws AzDException;

    BuildDefinition getBuildDefinition(
            int definitionId, boolean includeLatestBuilds, String minMetricsTime, int revision) throws AzDException;

    BuildDefinitionRevisions getBuildDefinitionRevisions(int definitionId) throws AzDException;

    BuildDefinitions getBuildDefinitions() throws AzDException;

    BuildDefinitions getBuildDefinitions(int[] definitionIds) throws AzDException;

    BuildDefinitions getBuildDefinitions(int top) throws AzDException;

    BuildDefinitions getBuildDefinitions(String name) throws AzDException;

    BuildDefinitions getBuildDefinitions(
            String builtAfter, String continuationToken, boolean includeAllProperties,
            boolean includeLatestBuilds, String minMetricsTime, String notBuiltAfter,
            String path, int processType, String queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) throws AzDException;

    BuildDefinition restoreBuildDefinition(int definitionId, boolean deleted) throws AzDException;

    BuildTags addBuildTag(int buildId, String tag) throws AzDException;

    BuildTags addBuildTags(int buildId, String[] tags) throws AzDException;

    BuildTags addDefinitionTag(int definitionId, String tag) throws AzDException;

    BuildTags addDefinitionTags(int definitionId, String[] tags) throws AzDException;

    BuildTags deleteBuildTag(int buildId, String tag) throws AzDException;

    BuildTags deleteDefinitionTag(int definitionId, String tag) throws AzDException;

    BuildTags deleteTag(String tag) throws AzDException;

    BuildTags getBuildTags(int buildId) throws AzDException;

    BuildTags getDefinitionTags(int definitionId) throws AzDException;

    BuildTags getDefinitionTags(int definitionId, int revision) throws AzDException;

    BuildTags getTags() throws AzDException;

    BuildTags updateBuildTags(int buildId, String[] tags, boolean toRemove) throws AzDException;

    BuildTags updateDefinitionTags(int definitionId, String[] tags, boolean toRemove) throws AzDException;

    YamlBuild getYaml(int definitionId) throws AzDException;

    YamlBuild getYaml(int definitionId, boolean includeLatestBuilds, String minMetricsTime,
                      String[] propertyFilters, int revision) throws AzDException;

    Void updateBuildStage(int buildId, String stageReferenceName, boolean forceRetryAllJobs, StageUpdateType state) throws AzDException;

    String getFileContents(String providerName, String serviceEndpointId, String repositoryName, String branchName, String path) throws AzDException;

    SourceRepositoryItems getPathContents(String providerName, String serviceEndpointId, String repositoryName, String branchName, String filePath) throws AzDException;

    SourceProviderPullRequest getPullRequest(String providerName, String pullRequestId, String repositoryName, String serviceEndpointId) throws AzDException;

    SourceProviderAttributes getSourceProviders() throws AzDException;

    SourceProvideBranches getBranches(String providerName, String serviceEndpointId, String repositoryName) throws AzDException;

    SourceProvideBranches getBranches(String providerName, String serviceEndpointId, String repositoryName, String branchName) throws AzDException;

    SourceRepositories getRepositories(String providerName, String serviceEndpointId) throws AzDException;

    SourceRepositories getRepositories(String providerName, String serviceEndpointId, String repositoryName) throws AzDException;

    SourceRepositories getRepositories(String providerName, String serviceEndpointId, String repositoryName, String continuationToken, boolean pageResults, SourceProviderResultSet resultSet) throws AzDException;

    RepositoryWebhooks getWebHooks(String providerName, String serviceEndpointId, String repositoryName) throws AzDException;

    Void restoreWebHooks(String providerName, String serviceEndpointId, String repositoryName, List<String> triggerTypes) throws AzDException;
}
