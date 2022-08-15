package org.azd.build;

import org.azd.build.types.*;
import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.enums.SourceProviderResultSet;
import org.azd.enums.StageUpdateType;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.helpers.URLHelper;
import org.azd.interfaces.BuildDetails;
import org.azd.utils.AzDAsyncApi;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.azd.utils.RestClient.send;

/***
 * Build class to manage build API
 */
public class BuildApi extends AzDAsyncApi<BuildApi> implements BuildDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "build";
    private final String BUILD = "5d6898bb-45ec-463f-95f9-54d49c71752e";

    /***
     * Pass the connection object
     * @param connection Connection object
     */
    public BuildApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Deletes a build.
     * @param buildId pass the build id to delete
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteBuild(int buildId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                    AREA + "/builds", Integer.toString(buildId), null, ApiVersion.BUILD, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build getBuild(int buildId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), null, ApiVersion.BUILD, null, null, null);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return the object of build changes
     */
    @Override
    public BuildChanges getBuildChanges(int buildId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "changes", ApiVersion.BUILD_CHANGES, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildChanges.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
            put("continuationToken", continuationToken);
            put("includeSourceChange", includeSourceChange);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "changes", ApiVersion.BUILD_CHANGES, q, null, null);
        return MAPPER.mapJsonResponse(r, BuildChanges.class);
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
        return send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "logs/" + logId, ApiVersion.BUILD_LOGS,
                null, null, CustomHeader.TEXT_CONTENT);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("startLine", startLine);
            put("endLine", endLine);
        }};

        return send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "logs/" + logId, ApiVersion.BUILD_LOGS, q,
                null, CustomHeader.TEXT_CONTENT);
    }

    /***
     * Gets the logs for a build.
     * @param buildId pass the build id
     * @throws AzDException Default Api Exception handler.
     * @return the object of build logs with id. This can be used to fetch the particular log with id
     */
    @Override
    public BuildLogs getBuildLogs(int buildId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "logs", ApiVersion.BUILD_LOGS, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildLogs.class);
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId The ID of the build.
     * @throws AzDException Default Api Exception handler.
     * @return an array of work items associated with the build
     */
    @Override
    public BuildWorkItems getBuildWorkItems(int buildId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "workitems", ApiVersion.BUILD_WORK_ITEMS, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "workitems", ApiVersion.BUILD_WORK_ITEMS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
            put("fromBuildId", fromBuildId);
            put("toBuildId", toBuildId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "changes", ApiVersion.BUILD_CHANGES, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildChanges.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
            put("fromBuildId", fromBuildId);
            put("toBuildId", toBuildId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "workitems", ApiVersion.BUILD_WORK_ITEMS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
    }

    /***
     * Gets a list of builds.
     * @throws AzDException Default Api Exception handler.
     * @return a build array {@link Builds}
     */
    @Override
    public Builds getBuilds() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", null, null, ApiVersion.BUILD, null, null, null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @param buildIds array of build ids
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int[] buildIds) throws AzDException {

        String ids = Arrays.stream(buildIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

        HashMap<String, Object> q = new HashMap<>() {{
            put("buildIds", ids);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", null, null, ApiVersion.BUILD, q, null, null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @param top specify how many builds to retrieve
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int top) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", null, null, ApiVersion.BUILD, q, null, null);

        return MAPPER.mapJsonResponse(r, Builds.class);
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
            String deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, String queryOrder, int[] queues, String reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, String resultFilter,
            String statusFilter, String tagFilters) throws AzDException {

        String ids = (definitions != null) ? Arrays.stream(definitions).mapToObj(String::valueOf).collect(Collectors.joining(",")) : null;
        String queueIds = (queues != null) ? Arrays.stream(queues).mapToObj(String::valueOf).collect(Collectors.joining(",")) : null;

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
            put("branchName", branchName);
            put("buildNumber", buildNumber);
            put("continuationToken", continuationToken);
            put("definitions", ids);
            put("deletedFilter", deletedFilter);
            put("maxBuildsPerDefinition", maxBuildsPerDefinition);
            put("maxTime", maxTime);
            put("minTime", minTime);
            put("properties", (properties != null) ? String.join(",", properties) : null);
            put("queryOrder", queryOrder);
            put("queues", queueIds);
            put("reasonFilter", reasonFilter);
            put("repositoryType", repositoryType);
            put("requestedFor", requestedFor);
            put("resultFilter", resultFilter);
            put("repositoryId", repositoryId);
            put("statusFilter", statusFilter);
            put("tagFilters", tagFilters);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", null, null, ApiVersion.BUILD, q, null, null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Queues a build
     * @param definitionId pass the pipeline id to queue the build
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(int definitionId) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("definitionId", String.valueOf(definitionId));
        }};

        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", null, null, ApiVersion.BUILD, q, null, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Queues a build
     * @param buildParameters dictionary of parameters to queue the build.
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(Build buildParameters) throws AzDException {
        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", null, null, ApiVersion.BUILD, null, buildParameters, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Build.class);
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
        var q = new HashMap<String, Boolean>() {{
            put("retry", retry);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), null, ApiVersion.BUILD, q, build, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Build.class);
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
        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", null, null, ApiVersion.BUILD, null, builds.getBuildResults(), CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Gets controllers
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, null,
                AREA, null, "controllers", ApiVersion.BUILD_CONTROLLERS, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildControllers.class);
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers(String name) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, null,
                AREA, null, "controllers", ApiVersion.BUILD_CONTROLLERS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildControllers.class);
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws AzDException Default Api Exception handler.
     * @return build controller {@link BuildController}
     */
    @Override
    public BuildController getBuildController(int controllerId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, null,
                AREA + "/controllers", Integer.toString(controllerId), null, ApiVersion.BUILD_CONTROLLERS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, BuildController.class);
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

        if (buildDefinitionParameters.isEmpty()) throw new AzDException();

        var requestBody = MAPPER.mapJsonResponse(buildDefinitionParameters, Map.class);

        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "definitions", ApiVersion.BUILD_DEFINITIONS, null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
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
            var res = MAPPER.convertToString(definitionObject);
            return createBuildDefinition(res);
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
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                    AREA + "/definitions", Integer.toString(definitionId), null, ApiVersion.BUILD_DEFINITIONS, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    @Override
    public BuildDefinition getBuildDefinition(int definitionId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), null, ApiVersion.BUILD_DEFINITIONS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("includeLatestBuilds", includeLatestBuilds);
            put("minMetricsTime", minMetricsTime);
            put("revision", revision);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), null, ApiVersion.BUILD_DEFINITIONS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Gets all revisions of a definition.
     * @param definitionId The ID of the definition.
     * @throws AzDException Default Api Exception handler.
     * @return array of build definition revisions {@link BuildDefinitionRevision}
     */
    @Override
    public BuildDefinitionRevisions getBuildDefinitionRevisions(int definitionId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "revisions",
                ApiVersion.BUILD_DEFINITION_REVISIONS, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinitionRevisions.class);
    }

    /***
     * Gets a list of definitions.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", null, null, ApiVersion.BUILD_DEFINITIONS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param definitionIds array of definition ids
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int[] definitionIds) throws AzDException {

        String ids = Arrays.stream(definitionIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

        HashMap<String, Object> q = new HashMap<>() {{
            put("definitionIds", ids);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", null, null, ApiVersion.BUILD_DEFINITIONS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param top definitions to retrieve
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int top) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", null, null, ApiVersion.BUILD_DEFINITIONS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param name Name of the build definition
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(String name) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", null, null, ApiVersion.BUILD_DEFINITIONS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
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
            String path, int processType, String queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("builtAfter", builtAfter);
            put("continuationToken", continuationToken);
            put("includeAllProperties", includeAllProperties);
            put("includeLatestBuilds", includeLatestBuilds);
            put("minMetricsTime", minMetricsTime);
            put("notBuiltAfter", notBuiltAfter);
            put("path", path);
            put("processType", processType);
            put("queryOrder", queryOrder);
            put("repositoryId", repositoryId);
            put("repositoryType", repositoryType);
            put("taskIdFilter", taskIdFilter);
            put("yamlFilename", yamlFilename);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", null, null, ApiVersion.BUILD_DEFINITIONS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
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

        HashMap<String, Object> q = new HashMap<>() {{
            put("deleted", deleted);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), null, ApiVersion.BUILD_DEFINITIONS,
                q, null, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
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
        String r = send(RequestMethod.PUT, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definition.getId()), null, ApiVersion.BUILD_DEFINITIONS, null,
                definition, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
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
    public BuildDefinition updateBuildDefinition(BuildDefinition definition, int secretsSourceDefinitionId, int secretsSourceDefinitionRevision)
            throws AzDException {
        var q = new HashMap<String, Integer>(){{
            put("secretsSourceDefinitionId", secretsSourceDefinitionId);
            put("secretsSourceDefinitionRevision", secretsSourceDefinitionRevision);
        }};

        String r = send(RequestMethod.PUT, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definition.getId()), null, ApiVersion.BUILD_DEFINITIONS, q,
                definition, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
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
        var q = new HashMap<String, Object>(){{
            put("path", URLHelper.encodeSpecialWithSpace(path));
        }};

        String r = send(RequestMethod.PUT, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "folders", ApiVersion.BUILD_FOLDER, q, folder, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Folder.class);
    }

    /**
     * Deletes a definition folder. Definitions and their corresponding builds will also be deleted.
     *
     * @param path The full path to the folder.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Void deleteFolder(String path) throws AzDException {
        try {
            var q = new HashMap<String, Object>(){{
                put("path", URLHelper.encodeSpecialWithSpace(path));
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                    AREA, null, "folders", ApiVersion.BUILD_FOLDER, q, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /**
     * Gets a list of build definition folders.
     *
     * @return List of folder Object {@link Folders}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public Folders getFolders() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "folders", ApiVersion.BUILD_FOLDER, null, null, null);

        return MAPPER.mapJsonResponse(r, Folders.class);
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
        String finalPath;

        if (!path.isEmpty() && path.equals("+\\")) finalPath = "\\" + path;
        else finalPath = path;

        var q = new HashMap<String, Object>(){{
            put("path", URLHelper.encodeSpecialWithSpace(finalPath));
        }};

        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "folders", ApiVersion.BUILD_FOLDER, q, folder, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Folder.class);
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
        String r = send(RequestMethod.PUT, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "tags/" + tag, ApiVersion.BUILD_TAGS,
                null, null, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Adds tags to a build.
     * @param buildId The ID of the build.
     * @param tags The tags to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addBuildTags(int buildId, String[] tags) throws AzDException {
        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "tags", ApiVersion.BUILD_TAGS,
                null, tags, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
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
        String r = send(RequestMethod.PUT, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "tags/" + tag, ApiVersion.BUILD_TAGS,
                null, null, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Adds multiple tags to a definition.
     * @param definitionId Id of build definition.
     * @param tags The tags to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addDefinitionTags(int definitionId, String[] tags) throws AzDException {
        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "tags", ApiVersion.BUILD_TAGS,
                null, tags, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
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
        String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "tags/" + tag, ApiVersion.BUILD_TAGS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
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
        String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "tags/" + tag, ApiVersion.BUILD_TAGS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Removes a tag from builds, definitions, and from the tag store
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags deleteTag(String tag) throws AzDException {
        String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "tags/" + tag, ApiVersion.BUILD_TAGS, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Gets the tags for a build.
     * @param buildId The ID of the build.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getBuildTags(int buildId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "tags", ApiVersion.BUILD_TAGS, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @return Sting array of tags
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getDefinitionTags(int definitionId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "tags", ApiVersion.BUILD_TAGS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
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
        var q = new HashMap<String, Object>() {{
            put("revision", revision);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "tags", ApiVersion.BUILD_TAGS, q, null, null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Gets a list of all build tags in the project.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getTags() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "tags", ApiVersion.BUILD_TAGS, null, null, null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
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
    public BuildTags updateBuildTags(int buildId, String[] tags, boolean toRemove) throws AzDException {

        var tagValue = toRemove ? "tagsToRemove" : "tagsToAdd";

        var body = new HashMap<String, Object>() {{
            put(tagValue, tags);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "tags", ApiVersion.BUILD_TAGS,
                null, body, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
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
    public BuildTags updateDefinitionTags(int definitionId, String[] tags, boolean toRemove) throws AzDException {
        var tagValue = toRemove ? "tagsToRemove" : "tagsToAdd";

        var body = new HashMap<String, Object>() {{
            put(tagValue, tags);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "tags", ApiVersion.BUILD_TAGS,
                null, body, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Converts a definition to YAML.
     * @param definitionId The ID of the definition.
     * @return Yaml build object {@link YamlBuild}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public YamlBuild getYaml(int definitionId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "yaml", ApiVersion.BUILD_YAML,
                null, null, null);

        return MAPPER.mapJsonResponse(r, YamlBuild.class);
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
                             String[] propertyFilters, int revision) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("includeLatestBuilds", includeLatestBuilds);
            put("minMetricsTime", minMetricsTime);
            put("propertyFilters", String.join(",", propertyFilters));
            put("revision", revision);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId), "yaml", ApiVersion.BUILD_YAML,
                q, null, null);

        return MAPPER.mapJsonResponse(r, YamlBuild.class);
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
        try {
            var body = new HashMap<String, Object>() {{
                put("forceRetryAllJobs", forceRetryAllJobs);
                put("state", state.toString().toLowerCase());
            }};

            String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                    AREA + "/builds", buildId + "/stages/" + stageReferenceName, null, ApiVersion.BUILD_STAGE,
                    null, body, CustomHeader.JSON_CONTENT_TYPE);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
            put("commitOrBranch", branchName);
            put("path", path);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/filecontents", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, CustomHeader.TEXT_CONTENT);

        // Look for all the keys as genuine response can also contain any key in the content.
        if (!r.isEmpty() && r.contains("innerException") && r.contains("$id") && r.contains("eventId") && r.contains("typeName"))
            MAPPER.mapJsonResponse(r, Map.class);

        return r;
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
            put("commitOrBranch", branchName);
            put("path", path);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/pathcontents", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, SourceRepositoryItems.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repositoryId", repositoryName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/pullrequests/" + pullRequestId, ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, SourceProviderPullRequest.class);
    }

    /**
     * Get a list of source providers and their capabilities.
     *
     * @return SourceProviderAttributes {@link SourceProviderAttributes}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public SourceProviderAttributes getSourceProviders() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, null, ApiVersion.BUILD_SOURCE_PROVIDERS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, SourceProviderAttributes.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/branches", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, SourceProvideBranches.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
            put("branchName", branchName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/branches", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, SourceProvideBranches.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/repositories", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, SourceRepositories.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/repositories", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, SourceRepositories.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
            put("resultSet", resultSet.toString().toLowerCase());
            put("pageResults", pageResults);
            put("continuationToken", continuationToken);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/repositories", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, SourceRepositories.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                "sourceProviders", null, providerName + "/webhooks", ApiVersion.BUILD_SOURCE_PROVIDERS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, RepositoryWebhooks.class);
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
        var q = new HashMap<String, Object>() {{
            put("serviceEndpointId", serviceEndpointId);
            put("repository", repositoryName);
        }};

        try {
            String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                    "sourceProviders", null, providerName + "/webhooks", ApiVersion.BUILD_SOURCE_PROVIDERS,
                    q, triggerTypes, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
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
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "timeline", ApiVersion.BUILD_TIMELINE,
                null, null, null);

        return MAPPER.mapJsonResponse(r, Timeline.class);
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
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "timeline/" + timelineId, ApiVersion.BUILD_TIMELINE,
                null, null, null);

        return MAPPER.mapJsonResponse(r, Timeline.class);
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
        var q = new HashMap<String, Object>() {{
            put("changeId", changeId);
            put("planId", planId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "timeline/" + timelineId, ApiVersion.BUILD_TIMELINE,
                q, null, null);

        return MAPPER.mapJsonResponse(r, Timeline.class);
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
        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "artifacts", ApiVersion.BUILD_ARTIFACTS,
                null, artifact, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, BuildArtifact.class);
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
        var q = new HashMap<String, Object>() {{
            put("artifactName", artifactName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "artifacts", ApiVersion.BUILD_ARTIFACTS,
                q, null, null);

        return MAPPER.mapJsonResponse(r, BuildArtifact.class);
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
        var q = new HashMap<String, Object>() {{
            put("artifactName", artifactName);
        }};

        return send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "artifacts", ApiVersion.BUILD_ARTIFACTS,
                q, null, CustomHeader.STREAM_ZIP_ACCEPT, false);
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
        var q = new HashMap<String, Object>() {{
            put("artifactName", artifactName);
            put("fileId", fileId);
            put("fileName", fileName);
        }};

        return send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "artifacts", ApiVersion.BUILD_ARTIFACTS,
                q, null, CustomHeader.STREAM_ACCEPT, false);
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
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "artifacts", ApiVersion.BUILD_ARTIFACTS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, BuildArtifacts.class);
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
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "attachments/" + type, ApiVersion.BUILD_ATTACHMENTS,
                null, null, null);

        return MAPPER.mapJsonResponse(r, Attachments.class);
    }
}
