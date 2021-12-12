package org.azd.build;

import org.azd.build.types.*;
import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.BuildDetails;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.azd.utils.Client.send;

/***
 * Build class to manage build API
 */
public class BuildApi implements BuildDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "build";
    private final String BUILD = "5d6898bb-45ec-463f-95f9-54d49c71752e";

    /***
     * Pass the connection object to work with Build Api
     * @param connection Connection object
     */
    public BuildApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Deletes a build.
     * @param buildId pass the build id to delete
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void deleteBuild(int buildId) throws ConnectionException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                    AREA + "/builds", Integer.toString(buildId), null, ApiVersion.BUILD, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build getBuild(int buildId) throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA + "/builds", Integer.toString(buildId), null, ApiVersion.BUILD, null, null);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return the object of build changes
     */
    @Override
    public BuildChanges getBuildChanges(int buildId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "changes", ApiVersion.BUILD_CHANGES,null, null);

        return MAPPER.mapJsonResponse(r, BuildChanges.class);
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @param top The maximum number of changes to return
     * @param continuationToken pass the continuation token
     * @param includeSourceChange if set to true gets the source changes
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return the object of build changes
     */
    @Override
    public BuildChanges getBuildChanges(
            int buildId, int top, String continuationToken, boolean includeSourceChange) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
            put("continuationToken", continuationToken);
            put("includeSourceChange", includeSourceChange);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "changes", ApiVersion.BUILD_CHANGES, q, null);
        return MAPPER.mapJsonResponse(r, BuildChanges.class);
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return logs associated with the build for given id
     */
    @Override
    public String getBuildLog(int buildId, int logId) throws ConnectionException, AzDException {
        return send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId), "logs/" + logId, ApiVersion.BUILD_LOGS, null, null, "text");
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @param startLine pass the line number from log which you need to fetch
     * @param endLine pass till which line number you need to fetch from the log
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return logs associated with the build for given id
     */
    @Override
    public String getBuildLog(int buildId, int logId, long startLine, long endLine) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("startLine", startLine);
            put("endLine", endLine);
        }};

        return send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId),"logs/" + logId, ApiVersion.BUILD_LOGS, q, null,"text");
    }

    /***
     * Gets the logs for a build.
     * @param buildId pass the build id
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return the object of build logs with id. This can be used to fetch the particular log with id
     */
    @Override
    public BuildLogs getBuildLogs(int buildId) throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId),"logs", ApiVersion.BUILD_LOGS,null,null);

        return MAPPER.mapJsonResponse(r, BuildLogs.class);
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId The ID of the build.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return an array of work items associated with the build
     */
    @Override
    public BuildWorkItems getBuildWorkItems(int buildId) throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA + "/builds", Integer.toString(buildId), "workitems", ApiVersion.BUILD_WORK_ITEMS,null,null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId id of the build
     * @param top specify how many top work items to return
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return an array of work items associated with the build
     */
    @Override
    public BuildWorkItems getBuildWorkItems(int buildId, int top) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA + "/builds", Integer.toString(buildId),"workitems", ApiVersion.BUILD_WORK_ITEMS, q,null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return an array of changes between the builds
     */
    @Override
    public BuildChanges getChangesBetweenBuilds(int fromBuildId, int toBuildId, int top) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
            put("fromBuildId", fromBuildId);
            put("toBuildId", toBuildId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null, "changes", ApiVersion.BUILD_CHANGES, q,null);

        return MAPPER.mapJsonResponse(r, BuildChanges.class);
    }

    /***
     * Gets all the work items between two builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return an array of workitems between the builds
     */
    @Override
    public BuildWorkItems getWorkItemsBetweenBuilds(int fromBuildId, int toBuildId, int top) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
            put("fromBuildId", fromBuildId);
            put("toBuildId", toBuildId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null,"workitems", ApiVersion.BUILD_WORK_ITEMS, q,null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
    }

    /***
     * Gets a list of builds.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return a build array {@link Builds}
     */
    @Override
    public Builds getBuilds() throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds",null,null, ApiVersion.BUILD,null,null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @param buildIds array of build ids
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int[] buildIds) throws ConnectionException, AzDException {

        String ids = Arrays.stream(buildIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

        HashMap<String, Object> q = new HashMap<>(){{
            put("buildIds", ids);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds",null,null, ApiVersion.BUILD, q,null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @param top specify how many builds to retrieve
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int top) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds",null,null, ApiVersion.BUILD, q,null);

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
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return an array of build
     */
    @Override
    public Builds getBuilds(
            int top, String branchName, String buildNumber, String continuationToken, int[] definitions,
            String deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, String queryOrder, int[] queues, String reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, String resultFilter,
            String statusFilter, String tagFilters) throws ConnectionException, AzDException {

            String ids = (definitions != null) ? Arrays.stream(definitions).mapToObj(String::valueOf).collect(Collectors.joining(",")) : null;
            String queueIds = (queues != null) ? Arrays.stream(queues).mapToObj(String::valueOf).collect(Collectors.joining(",")) : null;

        HashMap<String, Object> q = new HashMap<>(){{
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
                AREA + "/builds",null,null, ApiVersion.BUILD, q,null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Queues a build
     * @param definitionId pass the pipeline id to queue the build
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(int definitionId) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("definitionId", String.valueOf(definitionId));
        }};

        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds",null,null, ApiVersion.BUILD, q,null);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Queues a build
     * @param buildParameters dictionary of parameters to queue the build.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(HashMap<String, Object> buildParameters) throws ConnectionException, AzDException {

        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA + "/builds", null,null, ApiVersion.BUILD,null, buildParameters);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Gets controllers
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers() throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD,null,
                        AREA,null,"controllers", ApiVersion.BUILD_CONTROLLERS,null,null);

        return MAPPER.mapJsonResponse(r, BuildControllers.class);
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers(String name) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD,null,
                AREA,null,"controllers", ApiVersion.BUILD_CONTROLLERS, q,null);

        return MAPPER.mapJsonResponse(r, BuildControllers.class);
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build controller {@link BuildController}
     */
    @Override
    public BuildController getBuildController(int controllerId) throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD,null,
                AREA + "/controllers", Integer.toString(controllerId),null, ApiVersion.BUILD_CONTROLLERS,null,null);

        return MAPPER.mapJsonResponse(r, BuildController.class);
    }

    /***
     * Creates a new definition.
     * @param buildDefinitionParameters json string of the build pipeline. Export the build definition from existing pipeline and edit it.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    @Override
    public BuildDefinition createBuildDefinition(String buildDefinitionParameters) throws ConnectionException, AzDException {

        if (buildDefinitionParameters.isEmpty()) throw new AzDException();

        var requestBody = MAPPER.mapJsonResponse(buildDefinitionParameters, Map.class);

        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA,null,"definitions", ApiVersion.BUILD_DEFINITIONS,null, requestBody);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Clone an existing definition/pipeline
     * @param definitionName Name of the build definition/pipeline. E.g., WebApp-Deployment-CI
     * @param definitionCloneName Name of the pipeline/definition to be created or cloned. E.g., WebApp-Deployment-CI-Copy
     * @return build definition {@link BuildDefinition}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildDefinition cloneBuildDefinition(String definitionName, String definitionCloneName) throws ConnectionException, AzDException {
        // validate if the definition exists
        int def;

        try {
            def = getBuildDefinitions()
                    .getBuildDefinition()
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
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public void deleteBuildDefinition(int definitionId) throws ConnectionException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                    AREA + "/definitions", Integer.toString(definitionId),null, ApiVersion.BUILD_DEFINITIONS,null,null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build definition {@link BuildDefinition}
     */
    @Override
    public BuildDefinition getBuildDefinition(int definitionId) throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA + "/definitions", Integer.toString(definitionId),null, ApiVersion.BUILD_DEFINITIONS,null,null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Gets a definition, optionally at a specific revision.
     * @param definitionId The ID of the definition.
     * @param includeLatestBuilds if specified gets the details of latest build
     * @param minMetricsTime If specified, indicates the date from which metrics should be included.
     * @param revision The revision number to retrieve. If this is not specified, the latest version will be returned.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return Build definition object
     */
    @Override
    public BuildDefinition getBuildDefinition(
            int definitionId, boolean includeLatestBuilds, String minMetricsTime, int revision) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("includeLatestBuilds", includeLatestBuilds);
            put("minMetricsTime", minMetricsTime);
            put("revision", revision);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA + "/definitions", Integer.toString(definitionId),null, ApiVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Gets all revisions of a definition.
     * @param definitionId The ID of the definition.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return array of build definition revisions {@link BuildDefinitionRevision}
     */
    @Override
    public BuildDefinitionRevisions getBuildDefinitionRevisions(int definitionId) throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"revisions", ApiVersion.BUILD_DEFINITION_REVISIONS,null,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitionRevisions.class);
    }

    /***
     * Gets a list of definitions.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions() throws ConnectionException, AzDException {

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions",null,null, ApiVersion.BUILD_DEFINITIONS,null,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param definitionIds array of definition ids
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int[] definitionIds) throws ConnectionException, AzDException {

        String ids = Arrays.stream(definitionIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

        HashMap<String, Object> q = new HashMap<>(){{
            put("definitionIds", ids);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions",null,null, ApiVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param top definitions to retrieve
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int top) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions",null,null, ApiVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param name Name of the build definition
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(String name) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", null, null, ApiVersion.BUILD_DEFINITIONS, q,null);

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
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public Map getBuildDefinitions(
            String builtAfter, String continuationToken, boolean includeAllProperties,
            boolean includeLatestBuilds, String minMetricsTime, String notBuiltAfter,
            String path, int processType, String queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
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
                        AREA + "/definitions",null,null, ApiVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Restores a deleted definition
     * @param definitionId pass the build definition id
     * @param deleted When false, restores a deleted definition.
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     * @return a {@link BuildDefinition} object
     */
    @Override
    public BuildDefinition restoreBuildDefinition(int definitionId, boolean deleted) throws ConnectionException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("deleted", deleted);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                        AREA + "/definitions", Integer.toString(definitionId),null, ApiVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Adds a tag to a build.
     * @param buildId The ID of the build.
     * @param tag The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addBuildTag(int buildId, String tag) throws ConnectionException, AzDException {
        String r = send(RequestMethod.PUT, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId),"tags/" + tag, ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Adds tags to a build.
     * @param buildId The ID of the build.
     * @param tags The tags to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addBuildTags(int buildId, String[] tags) throws ConnectionException, AzDException {
        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId),"tags", ApiVersion.BUILD_TAGS, null, true, MAPPER.convertToString(tags));

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Adds a tag to a definition.
     * @param definitionId Id of build definition.
     * @param tag The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addDefinitionTag(int definitionId, String tag) throws ConnectionException, AzDException {
        String r = send(RequestMethod.PUT, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"tags/" + tag, ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Adds multiple tags to a definition.
     * @param definitionId Id of build definition.
     * @param tags The tags to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags addDefinitionTags(int definitionId, String[] tags) throws ConnectionException, AzDException {
        String r = send(RequestMethod.POST, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"tags", ApiVersion.BUILD_TAGS, null, true, MAPPER.convertToString(tags));

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Removes a tag from a build.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the updateBuildTags method instead.
     * @param buildId Id of the build.
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags deleteBuildTag(int buildId, String tag) throws ConnectionException, AzDException {
        String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId),"tags/" + tag, ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Removes a tag from a definition.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the updateDefinitionTags method instead.
     * @param definitionId Id of the build definition.
     * @param tag The tag to delete
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags deleteDefinitionTag(int definitionId, String tag) throws ConnectionException, AzDException {
        String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"tags/" + tag, ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Removes a tag from builds, definitions, and from the tag store
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags deleteTag(String tag) throws ConnectionException, AzDException {
        String r = send(RequestMethod.DELETE, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null,"tags/" + tag, ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Gets the tags for a build.
     * @param buildId The ID of the build.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getBuildTags(int buildId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId),"tags", ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @return Sting array of tags
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getDefinitionTags(int definitionId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"tags", ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @param revision The definition revision number. If not specified, uses the latest revision of the definition.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getDefinitionTags(int definitionId, int revision) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("revision", revision);
        }};

        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"tags", ApiVersion.BUILD_TAGS, q,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Gets a list of all build tags in the project.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags getTags() throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA, null,"tags", ApiVersion.BUILD_TAGS, null,null);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Adds/Removes tags from a build.
     * @param buildId The ID of the build.
     * @param tags The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags updateBuildTags(int buildId, String[] tags, boolean toRemove) throws ConnectionException, AzDException {

        var tagValue = toRemove ? "tagsToRemove" : "tagsToAdd" ;

        var body = new HashMap<String, Object>(){{
            put(tagValue, tags);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/builds", Integer.toString(buildId),"tags", ApiVersion.BUILD_TAGS, null, body);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }

    /***
     * Adds/Removes tags from a build.
     * @param definitionId The Id of the build definition.
     * @param tags The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws ConnectionException A connection object should be created with Azure DevOps organization name, personal access token
     * and project. This validates the connection object and throws exception if it is not provided.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public BuildTags updateDefinitionTags(int definitionId, String[] tags, boolean toRemove) throws ConnectionException, AzDException {
        var tagValue = toRemove ? "tagsToRemove" : "tagsToAdd" ;

        var body = new HashMap<String, Object>(){{
            put(tagValue, tags);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, BUILD, CONNECTION.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"tags", ApiVersion.BUILD_TAGS, null, body);

        return MAPPER.mapJsonResponse(r, BuildTags.class);
    }
}
