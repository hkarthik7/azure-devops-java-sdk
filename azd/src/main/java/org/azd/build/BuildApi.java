package org.azd.build;

import org.azd.build.stages.StagesRequestBuilder;
import org.azd.build.types.*;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.AzDHelpers;
import org.azd.interfaces.BuildDetails;
import org.azd.serviceClient.AzDServiceClient;
import org.azd.utils.AzDAsyncApi;
import org.azd.utils.InstanceFactory;

import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/***
 * Build class to manage build API
 */
public class BuildApi extends AzDAsyncApi<BuildApi> implements BuildDetails {

    private final BuildBaseRequestBuilder BUILD;

    /**
     * Requires the instance of AzDServiceClient.
     * @param client Pass the instance of {@link AzDServiceClient}
     */
    public BuildApi(AzDServiceClient client) {
        BUILD = client.build();
    }

    /***
     * Deletes a build.
     * @param buildId pass the build id to delete
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteBuild(int buildId) throws AzDException {
        return BUILD.builds().delete(buildId);
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build getBuild(int buildId) throws AzDException {
        return BUILD.builds().get(buildId);
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return the object of build changes
     */
    @Override
    public BuildChanges getBuildChanges(int buildId) throws AzDException {
        return BUILD.builds().changes().get(buildId);
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @param top The maximum number of changes to return
     * @param continuationToken pass the continuation token
     * @param includeSourceChange if set to true gets the source changes
     * @throws AzDException Default Api Exception handler.
     * @return the object of build changes
     */
    @Override
    public BuildChanges getBuildChanges(
            int buildId, int top, String continuationToken, boolean includeSourceChange) throws AzDException {
        return BUILD.builds().changes().get(buildId, r -> {
            r.queryParameters.top = top;
            r.queryParameters.continuationToken = continuationToken;
            r.queryParameters.includeSourceChange = includeSourceChange;
        });
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @throws AzDException Default Api Exception handler.
     * @return logs associated with the build for given id
     */
    @Override
    public String getBuildLog(int buildId, int logId) throws AzDException {
        return BUILD.builds().logs().get(buildId, logId);
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @param startLine pass the line number from log which you need to fetch
     * @param endLine pass till which line number you need to fetch from the log
     * @throws AzDException Default Api Exception handler.
     * @return logs associated with the build for given id
     */
    @Override
    public String getBuildLog(int buildId, int logId, long startLine, long endLine) throws AzDException {
        return BUILD.builds().logs().get(buildId, logId, r -> {
            r.queryParameters.startLine = startLine;
            r.queryParameters.endLine = endLine;
        });
    }

    /***
     * Gets the logs for a build.
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return the object of build logs with id. This can be used to fetch the particular log with id
     */
    @Override
    public BuildLogs getBuildLogs(int buildId) throws AzDException {
        return BUILD.builds().logs().get(buildId);
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId The ID of the build.
     * @throws AzDException Default Api Exception handler.
     * @return an array of work items associated with the build
     */
    @Override
    public BuildWorkItems getBuildWorkItems(int buildId) throws AzDException {
        return BUILD.builds().workItems().get(buildId);
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId id of the build
     * @param top specify how many top work items to return
     * @throws AzDException Default Api Exception handler.
     * @return an array of work items associated with the build
     */
    @Override
    public BuildWorkItems getBuildWorkItems(int buildId, int top) throws AzDException {
        return BUILD.builds().workItems().get(buildId, r -> r.queryParameters.top = top);
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @throws AzDException Default Api Exception handler.
     * @return an array of changes between the builds
     */
    @Override
    public BuildChanges getChangesBetweenBuilds(int fromBuildId, int toBuildId, int top) throws AzDException {
        return BUILD.builds().changes().get(r -> {
            r.queryParameters.fromBuildId = fromBuildId;
            r.queryParameters.toBuildId = toBuildId;
            r.queryParameters.top = top;
        });
    }

    /***
     * Gets all the work items between two builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @throws AzDException Default Api Exception handler.
     * @return an array of workitems between the builds
     */
    @Override
    public BuildWorkItems getWorkItemsBetweenBuilds(int fromBuildId, int toBuildId, int top) throws AzDException {
        return BUILD.builds().workItems().get(r -> {
            r.queryParameters.fromBuildId = fromBuildId;
            r.queryParameters.toBuildId = toBuildId;
            r.queryParameters.top = top;
        });
    }

    /***
     * Gets a list of builds.
     * @throws AzDException Default Api Exception handler.
     * @return a build array {@link Builds}
     */
    @Override
    public Builds getBuilds() throws AzDException {
        return BUILD.builds().list();
    }

    /***
     * Gets a list of builds.
     * @param buildIds array of build ids
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int[] buildIds) throws AzDException {
        return BUILD.builds().list(r -> r.queryParameters.buildIds = AzDHelpers.toString(buildIds));
    }

    /***
     * Gets a list of builds.
     * @param top specify how many builds to retrieve
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int top) throws AzDException {
        return BUILD.builds().list(r -> r.queryParameters.top = top);
    }

    /***
     * Gets a list of builds.
     * @param top specify how many builds to retrieve
     * @param branchName If specified, filters to builds that built branches that built this branch.
     * @param buildNumber If specified, filters to builds that match this build number. Append * to do a prefix search.
     * @param continuationToken A continuation token, returned by a previous call to this method, that can be used to return the next set of builds.
     * @param definitions A comma-delimited list of definition IDs. If specified, filters to builds for these definitions.
     * @param deletedFilter Indicates whether to exclude, include, or only return deleted builds.
     * @param maxBuildsPerDefinition The maximum number of builds to return per definition.
     * @param maxTime If specified, filters to builds that finished/started/queued before this date based on the queryOrder specified.
     * @param minTime If specified, filters to builds that finished/started/queued after this date based on the queryOrder specified.
     * @param properties A comma-delimited list of properties to retrieve.
     * @param queryOrder The order in which builds should be returned.
     * @param queues A comma-delimited list of queue IDs. If specified, filters to builds that ran against these queues.
     * @param reasonFilter If specified, filters to builds that match this reason.
     * @param repositoryId If specified, filters to builds that built from this repository.
     * @param repositoryType If specified, filters to builds that built from repositories of this type.
     * @param requestedFor If specified, filters to builds requested for the specified user.
     * @param resultFilter If specified, filters to builds that match this result.
     * @param statusFilter If specified, filters to builds that match this status.
     * @param tagFilters A comma-delimited list of tags. If specified, filters to builds that have the specified tags.
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(
            int top, String branchName, String buildNumber, String continuationToken, int[] definitions,
            QueryDeletedOption deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, BuildQueryOrder queryOrder, int[] queues, BuildReason reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, BuildResult resultFilter,
            BuildStatus statusFilter, String tagFilters) throws AzDException {

        return BUILD.builds().list(r -> {
            r.queryParameters.top = top;
            r.queryParameters.branchName = branchName;
            r.queryParameters.buildNumber = buildNumber;
            r.queryParameters.continuationToken = continuationToken;
            r.queryParameters.definitions = AzDHelpers.toString(definitions);
            r.queryParameters.deletedFilter = deletedFilter;
            r.queryParameters.maxBuildsPerDefinition = maxBuildsPerDefinition;
            r.queryParameters.maxTime = maxTime;
            r.queryParameters.minTime = minTime;
            r.queryParameters.properties = AzDHelpers.toString(properties);
            r.queryParameters.queryOrder = queryOrder;
            r.queryParameters.queues = AzDHelpers.toString(queues);
            r.queryParameters.reasonFilter = reasonFilter;
            r.queryParameters.repositoryType = repositoryType;
            r.queryParameters.requestedFor = requestedFor;
            r.queryParameters.resultFilter = resultFilter;
            r.queryParameters.repositoryId = repositoryId;
            r.queryParameters.statusFilter = statusFilter;
            r.queryParameters.tagFilters = tagFilters;
        });
    }

    /***
     * Queues a build
     * @param definitionId pass the pipeline id to queue the build
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(int definitionId) throws AzDException {
        return BUILD.builds().queue(definitionId);
    }

    /***
     * Queues a build
     * @param buildParameters dictionary of parameters to queue the build.
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(Build buildParameters) throws AzDException {
        return BUILD.builds().queue(buildParameters);
    }

    /**
     * Updates a build.
     *
     * @param build pass the Build object to update. {@link Build}
     * @param buildId The ID of the build.
     * @param retry None
     * @return Build Object {@link Build}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Build updateBuild(Build build, int buildId, boolean retry) throws AzDException {
        return BUILD.builds().update(buildId, retry, build);
    }

    /**
     * Updates multiple builds.
     *
     * @param builds List of build to update. {@link Builds}
     * @return Build Object {@link Build}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Builds updateBuilds(Builds builds) throws AzDException {
        return BUILD.builds().update(builds);
    }

    /***
     * Gets controllers
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers() throws AzDException {
        return BUILD.controllers().list();
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers(String name) throws AzDException {
        return BUILD.controllers().list(name);
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws AzDException Default Api Exception handler.
     * @return build controller {@link BuildController}
     */
    @Override
    public BuildController getBuildController(int controllerId) throws AzDException {
        return BUILD.controllers().get(controllerId);
    }

    /***
     * Creates a new definition.
     * @param buildDefinitionParameters json string of the build pipeline. Export the build definition from existing pipeline and edit it.
     * Or get the existing build definition using getBuildDefinition(definitionId) method and call toString() method on it to
     * convert the value to string and create the definition. Easiest way is to use cloneBuildDefinition() method to create
     * a clone of build definition and later edit it to suit the needs.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    @Override
    public BuildDefinition createBuildDefinition(String buildDefinitionParameters) throws AzDException {
        Objects.requireNonNull(buildDefinitionParameters);
        var serializer = InstanceFactory.createSerializerContext();
        return BUILD.definitions().create(serializer.deserialize(buildDefinitionParameters, BuildDefinition.class), null);
    }

    /**
     * Creates a new definition.
     * @param buildDefinition Build definition object.
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/build/definitions/create?view=azure-devops-rest-7.2">Definitions - Create</a>
     * @param definitionToCloneId Pass the definition clone id.
     * @param definitionToCloneRevision Pass the definition clone revision.
     * @throws AzDException Default Api Exception handler.
     * @return BuildDefinition object {@link BuildDefinition}.
     */
    @Override
    public BuildDefinition createBuildDefinition(BuildDefinition buildDefinition, Number definitionToCloneId, Number definitionToCloneRevision) throws AzDException {
        return BUILD.definitions().create(buildDefinition, r -> {
            r.definitionQueryParameters.definitionToCloneId = definitionToCloneId;
            r.definitionQueryParameters.definitionToCloneRevision = definitionToCloneRevision;
        });
    }

    /***
     * Clone an existing definition/pipeline
     * @param definitionName Name of the build definition/pipeline. E.g., WebApp-Deployment-CI
     * @param definitionCloneName Name of the pipeline/definition to be created or cloned. E.g., WebApp-Deployment-CI-Copy
     * @return build definition {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildDefinition cloneBuildDefinition(String definitionName, String definitionCloneName) throws AzDException {
        // validate if the definition exists
        int def;

        try {
            def = getBuildDefinitions()
                    .getBuildDefinitions()
                    .stream()
                    .filter(x -> x.getName().equals(definitionName))
                    .findFirst()
                    .get()
                    .getId();
        } catch (Exception e) {
            throw new AzDException("Cannot find the definition with name '" + definitionName + "'.");
        }

        if (!Integer.toString(def).isEmpty()) {
            var definitionObject = getBuildDefinition(def);
            definitionObject.setName(definitionCloneName);
            var res = InstanceFactory.createSerializerContext();
            return createBuildDefinition(res.serialize(definitionObject));
        }

        return null;
    }

    /***
     * Deletes a definition and all associated builds.
     * @param definitionId pass the definition id
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteBuildDefinition(int definitionId) throws AzDException {
        return BUILD.definitions().delete(definitionId);
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    @Override
    public BuildDefinition getBuildDefinition(int definitionId) throws AzDException {
        return BUILD.definitions().get(definitionId);
    }

    /***
     * Gets a definition, optionally at a specific revision.
     * @param definitionId The ID of the definition.
     * @param includeLatestBuilds if specified gets the details of latest build
     * @param minMetricsTime If specified, indicates the date from which metrics should be included.
     * @param revision The revision number to retrieve. If this is not specified, the latest version will be returned.
     * @throws AzDException Default Api Exception handler.
     * @return Build definition object
     */
    @Override
    public BuildDefinition getBuildDefinition(
            int definitionId, boolean includeLatestBuilds, String minMetricsTime, int revision) throws AzDException {
        return BUILD.definitions().get(definitionId, r -> {
            r.queryParameters.includeLatestBuilds = includeLatestBuilds;
            r.queryParameters.minMetricsTime = minMetricsTime;
            r.queryParameters.revision = revision;
        });
    }

    /***
     * Gets all revisions of a definition.
     * @param definitionId The ID of the definition.
     * @throws AzDException Default Api Exception handler.
     * @return array of build definition revisions {@link BuildDefinitionRevision}
     */
    @Override
    public BuildDefinitionRevisions getBuildDefinitionRevisions(int definitionId) throws AzDException {
        return BUILD.definitions().getRevisions(definitionId);
    }

    /***
     * Gets a list of definitions.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions() throws AzDException {
        return BUILD.definitions().list();
    }

    /***
     * Gets a list of definitions.
     * @param definitionIds array of definition ids
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int[] definitionIds) throws AzDException {
        return BUILD.definitions().list(r -> r.queryParameters.definitionIds = AzDHelpers.toString(definitionIds));
    }

    /***
     * Gets a list of definitions.
     * @param top definitions to retrieve
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int top) throws AzDException {
        return BUILD.definitions().list(r -> r.queryParameters.top = top);
    }

    /***
     * Gets a list of definitions.
     * @param name Name of the build definition
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(String name) throws AzDException {
        return BUILD.definitions().list(r -> r.queryParameters.name = name);
    }

    /**
     * Gets a list of definitions.
     * @param includeAllProperties Indicates whether the full definitions should be returned. By default, shallow representations of the definitions are returned.
     * @param includeLatestBuilds Indicates whether to return the latest and latest completed builds for this definition.
     * @return build definitions {@link BuildDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildDefinitions getBuildDefinitions(boolean includeAllProperties, boolean includeLatestBuilds) throws AzDException {
        return BUILD.definitions().list(r -> {
            r.queryParameters.includeLatestBuilds = includeLatestBuilds;
            r.queryParameters.includeAllProperties = includeAllProperties;
        });
    }

    /***
     * Gets a list of definitions.
     * @param builtAfter If specified, filters to definitions that have builds after this date.
     * @param continuationToken A continuation token, returned by a previous call to this method, that can be used to return the next set of definitions.
     * @param includeAllProperties Indicates whether the full definitions should be returned. By default, shallow representations of the definitions are returned.
     * @param includeLatestBuilds Indicates whether to return the latest and latest completed builds for this definition.
     * @param minMetricsTime If specified, indicates the date from which metrics should be included.
     * @param notBuiltAfter If specified, filters to definitions that do not have builds after this date.
     * @param path If specified, filters to definitions under this folder.
     * @param processType If specified, filters to definitions with the given process type.
     * @param queryOrder Indicates the order in which definitions should be returned.
     * @param repositoryId A repository ID. If specified, filters to definitions that use this repository.
     * @param repositoryType If specified, filters to definitions that have a repository of this type.
     * @param taskIdFilter If specified, filters to definitions that use the specified task.
     * @param yamlFilename If specified, filters to YAML definitions that match the given filename.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(
            String builtAfter, String continuationToken, boolean includeAllProperties,
            boolean includeLatestBuilds, String minMetricsTime, String notBuiltAfter,
            String path, int processType, DefinitionQueryOrder queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) throws AzDException {

        return BUILD.definitions().list(r -> {
            r.queryParameters.builtAfter = builtAfter;
            r.queryParameters.continuationToken = continuationToken;
            r.queryParameters.includeAllProperties = includeAllProperties;
            r.queryParameters.includeLatestBuilds = includeLatestBuilds;
            r.queryParameters.minMetricsTime = minMetricsTime;
            r.queryParameters.notBuiltAfter = notBuiltAfter;
            r.queryParameters.path = path;
            r.queryParameters.processType = processType;
            r.queryParameters.queryOrder = queryOrder;
            r.queryParameters.repositoryId = repositoryId;
            r.queryParameters.repositoryType = repositoryType;
            r.queryParameters.taskIdFilter = taskIdFilter;
            r.queryParameters.yamlFilename = yamlFilename;
        });
    }

    /***
     * Restores a deleted definition
     * @param definitionId pass the build definition id
     * @param deleted When false, restores a deleted definition.
     * @throws AzDException Default Api Exception handler.
     * @return a {@link BuildDefinition} object
     */
    @Override
    public BuildDefinition restoreBuildDefinition(int definitionId, boolean deleted) throws AzDException {
        return BUILD.definitions().restore(definitionId, deleted);
    }

    /**
     * Updates an existing build definition.
     * In order for this operation to succeed, the value of the "Revision" property of the request body must match the
     * existing build definition's. It is recommended that you obtain the existing build definition by using GET, modify
     * the build definition as necessary, and then submit the modified definition with PUT.
     *
     * @param definition Build definition object.
     * @return BuildDefinition Object {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public BuildDefinition updateBuildDefinition(BuildDefinition definition) throws AzDException {
        Objects.requireNonNull(definition);
        return BUILD.definitions().update(definition.getId(), definition, null);
    }

    /**
     * Updates an existing build definition.
     * In order for this operation to succeed, the value of the "Revision" property of the request body must match the
     * existing build definition's. It is recommended that you obtain the existing build definition by using GET, modify
     * the build definition as necessary, and then submit the modified definition with PUT.
     *
     * @param secretsSourceDefinitionId None
     * @param secretsSourceDefinitionRevision None
     * @param definition Build definition object.
     * @return BuildDefinition Object {@link BuildDefinition}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public BuildDefinition updateBuildDefinition(BuildDefinition definition, Number secretsSourceDefinitionId, Number secretsSourceDefinitionRevision)
            throws AzDException {
        Objects.requireNonNull(definition);
        return BUILD.definitions().update(definition.getId(), definition, r -> {
            r.updateQueryParameters.secretsSourceDefinitionId = secretsSourceDefinitionId;
            r.updateQueryParameters.secretsSourceDefinitionRevision = secretsSourceDefinitionRevision;
        });
    }

    /**
     * Creates a new folder.
     *
     * @param path The full path of the folder.
     * @param folder Folder object with mandatory details.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Folder createFolder(String path, Folder folder) throws AzDException {
        return BUILD.folders().create(path, folder);
    }

    /**
     * Deletes a definition folder. Definitions and their corresponding builds will also be deleted.
     *
     * @param path The full path to the folder.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Void deleteFolder(String path) throws AzDException {
        return BUILD.folders().delete(path);
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Folders getFolders() throws AzDException {
        return BUILD.folders().list();
    }

    /**
     * Gets a list of build definition folders.
     * @param path The path to start with.
     * @param queryOrder The order in which folders should be returned. {@link FolderQueryOrder}
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Folders getFolders(String path, FolderQueryOrder queryOrder) throws AzDException {
        return BUILD.folders().list(path, queryOrder);
    }

    /**
     * Updates an existing folder at given  existing path
     *
     * @param path The full path to the folder.
     * @return Folder Object {@link Folder}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Folder updateFolder(String path, Folder folder) throws AzDException {
        return BUILD.folders().update(path, folder);
    }

    /***
     * Adds a tag to a build.
     * @param buildId The ID of the build.
     * @param tag The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addBuildTag(int buildId, String tag) throws AzDException {
        return BUILD.tags().build().add(buildId, tag);
    }

    /***
     * Adds tags to a build.
     * @param buildId The ID of the build.
     * @param tags The tags to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addBuildTags(int buildId, List<String> tags) throws AzDException {
        return BUILD.tags().build().add(buildId, tags);
    }

    /***
     * Adds a tag to a definition.
     * @param definitionId Id of build definition.
     * @param tag The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addDefinitionTag(int definitionId, String tag) throws AzDException {
        return BUILD.tags().definition().add(definitionId, tag);
    }

    /***
     * Adds multiple tags to a definition.
     * @param definitionId Id of build definition.
     * @param tags The tags to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addDefinitionTags(int definitionId, List<String> tags) throws AzDException {
        return BUILD.tags().definition().add(definitionId, tags);
    }

    /***
     * Removes a tag from a build.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the updateBuildTags method instead.
     * @param buildId Id of the build.
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags deleteBuildTag(int buildId, String tag) throws AzDException {
        return BUILD.tags().build().delete(buildId, tag);
    }

    /***
     * Removes a tag from a definition.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the updateDefinitionTags method instead.
     * @param definitionId Id of the build definition.
     * @param tag The tag to delete
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags deleteDefinitionTag(int definitionId, String tag) throws AzDException {
        return BUILD.tags().definition().delete(definitionId, tag);
    }

    /***
     * Removes a tag from builds, definitions, and from the tag store
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags deleteTag(String tag) throws AzDException {
        return BUILD.tags().delete(tag);
    }

    /***
     * Gets the tags for a build.
     * @param buildId The ID of the build.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getBuildTags(int buildId) throws AzDException {
        return BUILD.tags().build().get(buildId);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @return Sting array of tags
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getDefinitionTags(int definitionId) throws AzDException {
        return BUILD.tags().definition().get(definitionId);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @param revision The definition revision number. If not specified, uses the latest revision of the definition.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getDefinitionTags(int definitionId, int revision) throws AzDException {
        return BUILD.tags().definition().get(definitionId, revision);
    }

    /***
     * Gets a list of all build tags in the project.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getTags() throws AzDException {
        return BUILD.tags().list();
    }

    /***
     * Adds/Removes tags from a build.
     * @param buildId The ID of the build.
     * @param tags The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags updateBuildTags(int buildId, List<String> tags, boolean toRemove) throws AzDException {
        return BUILD.tags().build().update(buildId, tags, toRemove);
    }

    /***
     * Adds/Removes tags from a build.
     * @param definitionId The Id of the build definition.
     * @param tags The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags updateDefinitionTags(int definitionId, List<String> tags, boolean toRemove) throws AzDException {
        return BUILD.tags().definition().update(definitionId, tags, toRemove);
    }

    /***
     * Converts a definition to YAML.
     * @param definitionId The ID of the definition.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public YamlBuild getYaml(int definitionId) throws AzDException {
        return BUILD.yaml().get(definitionId);
    }

    /***
     * Converts a definition to YAML, optionally at a specific revision.
     * @param definitionId The ID of the definition.
     * @param includeLatestBuilds if true includes latest builds
     * @param minMetricsTime If specified, indicates the date from which metrics should be included.
     * @param propertyFilters A comma-delimited list of properties to include in the results.
     * @param revision The revision number to retrieve. If this is not specified, the latest version will be returned.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public YamlBuild getYaml(int definitionId, boolean includeLatestBuilds, String minMetricsTime,
                             String[] propertyFilters, Number revision) throws AzDException {
        return BUILD.yaml().get(definitionId, r -> {
            r.queryParameters.includeLatestBuilds = includeLatestBuilds;
            r.queryParameters.minMetricsTime = minMetricsTime;
            r.queryParameters.propertyFilters = AzDHelpers.toString(propertyFilters);
            r.queryParameters.revision = revision;
        });
    }

    /***
     * Update a build stage.
     * @param buildId Id of the build to update the stage.
     * @param stageReferenceName Name of the stage to update.
     * @param forceRetryAllJobs if true forcefully retries all jobs.
     * @param state state to update.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void updateBuildStage(int buildId, String stageReferenceName, boolean forceRetryAllJobs, StageUpdateType state) throws AzDException {
        var updateStage = new StagesRequestBuilder.UpdateStageRequest();
        updateStage.buildId = buildId;
        updateStage.stageReferenceName = stageReferenceName;
        updateStage.state = state;
        updateStage.forceRetryAllJobs = forceRetryAllJobs;

        return BUILD.stages().update(updateStage);
    }

    /**
     * Gets the contents of a file in the given source code repository.
     *
     * @param providerName      The name of the source provider. E.g., Github
     * @param serviceEndpointId If specified, the ID of the service endpoint to query. Can only be omitted for providers
     *                          that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get branches.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @param branchName        The identifier of the commit or branch from which a file's contents are retrieved.
     * @param path              The path to the file to retrieve, relative to the root of the repository.
     * @return Contents of the file given String. {@link String}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public String getFileContents(String providerName, String serviceEndpointId, String repositoryName, String branchName, String path)
            throws AzDException {
        return BUILD.sourceProviders().getFileContents(providerName, r -> {
            r.queryParameters.path = path;
            r.queryParameters.repository = repositoryName;
            r.queryParameters.serviceEndpointId = serviceEndpointId;
            r.queryParameters.commitOrBranch = branchName;
        });
    }

    /**
     * Gets the contents of a directory in the given source code repository.
     *
     * @param providerName      The name of the source provider. E.g., Github
     * @param serviceEndpointId If specified, the ID of the service endpoint to query. Can only be omitted for providers
     *                          that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get branches.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @param branchName        The identifier of the commit or branch from which a file's contents are retrieved.
     * @param path              The path to the file to retrieve, relative to the root of the repository.
     * @return SourceRepositoryItems {@link SourceRepositoryItems}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceRepositoryItems getPathContents(String providerName, String serviceEndpointId, String repositoryName, String branchName, String path)
            throws AzDException {
        return BUILD.sourceProviders().getPathContents(providerName, r -> {
            r.queryParameters.path = path;
            r.queryParameters.repository = repositoryName;
            r.queryParameters.serviceEndpointId = serviceEndpointId;
            r.queryParameters.commitOrBranch = branchName;
        });
    }

    /**
     * Gets a pull request object from source provider.
     *
     * @param providerName      The name of the source provider.
     * @param pullRequestId     Vendor-specific id of the pull request.
     * @param repositoryName    Vendor-specific identifier or the name of the repository that contains the pull request.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @return SourceProviderPullRequest {@link SourceProviderPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceProviderPullRequest getPullRequest(String providerName, String pullRequestId, String repositoryName, String serviceEndpointId)
            throws AzDException {
        return BUILD.sourceProviders().getPullRequest(providerName, pullRequestId, repositoryName, serviceEndpointId);
    }

    /**
     * Get a list of source providers and their capabilities.
     *
     * @return SourceProviderAttributes {@link SourceProviderAttributes}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceProviderAttributes getSourceProviders() throws AzDException {
        return BUILD.sourceProviders().list();
    }

    /**
     * Gets a list of branches for the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    The vendor-specific identifier or the name of the repository to get branches.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @return SourceProvideBranches {@link SourceProvideBranches}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceProvideBranches getBranches(String providerName, String serviceEndpointId, String repositoryName) throws AzDException {
        return BUILD.sourceProviders().listBranches(providerName, r -> {
            r.queryParameters.serviceEndpointId = serviceEndpointId;
            r.queryParameters.repository = repositoryName;
        });
    }

    /**
     * Gets a list of branches for the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    The vendor-specific identifier or the name of the repository to get branches.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @param branchName        If supplied, the name of the branch to check for specifically.
     * @return SourceProvideBranches {@link SourceProvideBranches}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceProvideBranches getBranches(String providerName, String serviceEndpointId, String repositoryName, String branchName) throws AzDException {
        return BUILD.sourceProviders().listBranches(providerName, r -> {
            r.queryParameters.serviceEndpointId = serviceEndpointId;
            r.queryParameters.repository = repositoryName;
            r.queryParameters.branchName = branchName;
        });
    }

    /**
     * Gets a list of source code repositories.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @return SourceRepositories {@link SourceRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceRepositories getRepositories(String providerName, String serviceEndpointId) throws AzDException {
        return BUILD.sourceProviders().listRepositories(providerName, r -> r.queryParameters.serviceEndpointId = serviceEndpointId);
    }

    /**
     * Gets a list of source code repositories.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of a single repository to get.
     * @return SourceRepositories {@link SourceRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceRepositories getRepositories(String providerName, String serviceEndpointId, String repositoryName) throws AzDException {
        return BUILD.sourceProviders().listRepositories(providerName, r -> {
            r.queryParameters.serviceEndpointId = serviceEndpointId;
            r.queryParameters.repository = repositoryName;
        });
    }

    /**
     * Gets a list of source code repositories.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of a single repository to get.
     * @param continuationToken When paging results, this is a continuation token, returned by a previous call to
     *                          this method, that can be used to return the next set of repositories.
     * @param pageResults       If set to true, this will limit the set of results and will return a continuation token to continue the query.
     * @param resultSet         'top' for the repositories most relevant for the endpoint. If not set, all repositories are returned. Ignored if 'repository' is set.
     * @return SourceRepositories {@link SourceRepositories}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceRepositories getRepositories(String providerName, String serviceEndpointId, String repositoryName, String continuationToken,
                                              boolean pageResults, SourceProviderResultSet resultSet) throws AzDException {
        return BUILD.sourceProviders().listRepositories(providerName, r -> {
            r.queryParameters.serviceEndpointId = serviceEndpointId;
            r.queryParameters.repository = repositoryName;
            r.queryParameters.continuationToken = continuationToken;
            r.queryParameters.pageResults = pageResults;
            r.queryParameters.resultSet = resultSet;
        });
    }

    /**
     * Gets a list of webhooks installed in the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get webhooks.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @return RepositoryWebhooks {@link RepositoryWebhooks}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public RepositoryWebhooks getWebHooks(String providerName, String serviceEndpointId, String repositoryName) throws AzDException {
        return BUILD.sourceProviders().listWebhooks(providerName, serviceEndpointId, repositoryName);
    }

    /**
     * Recreates the webhooks for the specified triggers in the given source code repository.
     *
     * @param providerName      The name of the source provider.
     * @param serviceEndpointId If specified, the ID of the service endpoint to query.
     *                          Can only be omitted for providers that do not use service endpoints, e.g. TFVC or TFGit.
     * @param repositoryName    If specified, the vendor-specific identifier or the name of the repository to get webhooks.
     *                          Can only be omitted for providers that do not support multiple repositories.
     * @param triggerTypes      The types of triggers to restore webhooks for.
     * @return Void; successful operation
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void restoreWebHooks(String providerName, String serviceEndpointId, String repositoryName, List<String> triggerTypes) throws AzDException {
        return BUILD.sourceProviders().restore(providerName, serviceEndpointId, repositoryName, triggerTypes);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId Id of the build. use getBuilds() to list all the builds.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Timeline getTimeline(int buildId) throws AzDException {
        return BUILD.timeline().get(buildId);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId    Id of the build. use getBuilds() to list all the builds.
     * @param timelineId Id of the build timeline.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Timeline getTimeline(int buildId, String timelineId) throws AzDException {
        return BUILD.timeline().get(buildId, timelineId);
    }

    /**
     * Gets details for a build.
     *
     * @param buildId    Id of the build. use getBuilds() to list all the builds.
     * @param timelineId Id of the build timeline.
     * @param changeId   Timeline change id.
     * @param planId     Timeline plan id. This value can be null if unknown.
     * @return a timeline object. {@link Timeline}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Timeline getTimeline(int buildId, String timelineId, int changeId, String planId) throws AzDException {
        return BUILD.timeline().get(buildId, timelineId, r -> {
            r.queryParameters.changeId = changeId;
            r.queryParameters.planId = planId;
        });
    }

    /**
     * Associates an artifact with a build.
     *
     * @param buildId The ID of the build.
     * @param artifact Build artifact to associate.
     * @return BuildArtifact Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public BuildArtifact createArtifact(int buildId, BuildArtifact artifact) throws AzDException {
        return BUILD.artifacts().create(buildId, artifact);
    }

    /**
     * Gets a specific artifact for a build.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return BuildArtifact Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public BuildArtifact getArtifact(int buildId, String artifactName) throws AzDException {
        return BUILD.artifacts().get(buildId, artifactName);
    }

    /**
     * Gets a specific artifact for a build as a zip file.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public InputStream getArtifactAsZip(int buildId, String artifactName) throws AzDException {
        return BUILD.artifacts().getAsZip(buildId, artifactName);
    }

    /**
     * Gets a file from the build. Returns the file contents as InputStream and {@link org.azd.helpers.StreamHelper}
     * can be used to download the file.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public InputStream getArtifactFile(int buildId, String artifactName, String fileId, String fileName) throws AzDException {
        return BUILD.artifacts().getFile(buildId, artifactName, fileId, fileName);
    }

    /**
     * Gets all artifacts for a build.
     *
     * @param buildId The ID of the build.
     * @return BuildArtifact Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public BuildArtifacts getArtifacts(int buildId) throws AzDException {
        return BUILD.artifacts().list(buildId);
    }

    /**
     * Gets the list of attachments of a specific type that are associated with a build.
     *
     * @param buildId The ID of the build.
     * @param type The type of attachment.
     * @return Attachment Object {@link Attachment}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Attachments getAttachments(int buildId, String type) throws AzDException {
        return BUILD.attachments().list(buildId, type);
    }
}
