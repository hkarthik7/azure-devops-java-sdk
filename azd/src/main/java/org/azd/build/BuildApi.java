package org.azd.build;

import org.azd.build.types.*;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.BuildDetails;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.ResourceId;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.azd.utils.Client.request;

/***
 * Build class to manage build API
 * @author Harish karthic
 */
public class BuildApi implements BuildDetails {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "build";


    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public BuildApi(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    /***
     * Deletes a build.
     * @param buildId pass the build id to delete
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteBuild(int buildId) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds", Integer.toString(buildId), null, BuildVersion.VERSION, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return a build object {@link Build}
     */
    @Override
    public Build getBuild(int buildId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/builds", Integer.toString(buildId), null, BuildVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return the object of build changes
     */
    @Override
    public BuildChanges getBuildChanges(int buildId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds", Integer.toString(buildId), "changes", BuildVersion.BUILD_CHANGES,null, null);

        return MAPPER.mapJsonResponse(r, BuildChanges.class);
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @param top The maximum number of changes to return
     * @param continuationToken pass the continuation token
     * @param includeSourceChange if set to true gets the source changes
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return the object of build changes
     */
    @Override
    public BuildChanges getBuildChanges(
            int buildId, int top, String continuationToken, boolean includeSourceChange) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("$top", top);
            put("continuationToken", continuationToken);
            put("includeSourceChange", includeSourceChange);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds", Integer.toString(buildId), "changes", BuildVersion.BUILD_CHANGES, q, null);
        return MAPPER.mapJsonResponse(r, BuildChanges.class);
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return logs associated with the build for given id
     */
    @Override
    public String getBuildLog(int buildId, int logId) throws DefaultParametersException, AzDException {
        return request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds", Integer.toString(buildId), "logs/" + logId, BuildVersion.BUILD_LOGS, null, null, "text");
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @param startLine pass the line number from log which you need to fetch
     * @param endLine pass till which line number you need to fetch from the log
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return logs associated with the build for given id
     */
    @Override
    public String getBuildLog(int buildId, int logId, long startLine, long endLine) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("startLine", startLine);
            put("endLine", endLine);
        }};

        return request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds", Integer.toString(buildId),"logs/" + logId, BuildVersion.BUILD_LOGS, q, null,"text");
    }

    /***
     * Gets the logs for a build.
     * @param buildId pass the build id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return the object of build logs with id. This can be used to fetch the particular log with id
     */
    @Override
    public BuildLogs getBuildLogs(int buildId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds", Integer.toString(buildId),"logs", BuildVersion.BUILD_LOGS,null,null);

        return MAPPER.mapJsonResponse(r, BuildLogs.class);
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId The ID of the build.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an array of work items associated with the build
     */
    @Override
    public BuildWorkItems getBuildWorkItems(int buildId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/builds", Integer.toString(buildId), "workitems", BuildVersion.BUILD_WORK_ITEMS,null,null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId id of the build
     * @param top specify how many top work items to return
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an array of work items associated with the build
     */
    @Override
    public BuildWorkItems getBuildWorkItems(int buildId, int top) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/builds", Integer.toString(buildId),"workitems", BuildVersion.BUILD_WORK_ITEMS, q,null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an array of changes between the builds
     */
    @Override
    public BuildChanges getChangesBetweenBuilds(int fromBuildId, int toBuildId, int top) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
            put("fromBuildId", fromBuildId);
            put("toBuildId", toBuildId);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA, null, "changes", BuildVersion.BUILD_CHANGES, q,null);

        return MAPPER.mapJsonResponse(r, BuildChanges.class);
    }

    /***
     * Gets all the work items between two builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an array of workitems between the builds
     */
    @Override
    public BuildWorkItems getWorkItemsBetweenBuilds(int fromBuildId, int toBuildId, int top) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
            put("fromBuildId", fromBuildId);
            put("toBuildId", toBuildId);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA, null,"workitems", BuildVersion.BUILD_WORK_ITEMS, q,null);

        return MAPPER.mapJsonResponse(r, BuildWorkItems.class);
    }

    /***
     * Gets a list of builds.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return a build array {@link Builds}
     */
    @Override
    public Builds getBuilds() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds",null,null, BuildVersion.VERSION,null,null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @param buildIds array of build ids
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int[] buildIds) throws DefaultParametersException, AzDException {

        String ids = Arrays.stream(buildIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

        HashMap<String, Object> q = new HashMap<>(){{
            put("buildIds", ids);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Gets a list of builds.
     * @param top specify how many builds to retrieve
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an array of build
     */
    @Override
    public Builds getBuilds(int top) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

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
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an array of build
     */
    @Override
    public Builds getBuilds(
            int top, String branchName, String buildNumber, String continuationToken, int[] definitions,
            String deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, String queryOrder, int[] queues, String reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, String resultFilter,
            String statusFilter, String tagFilters) throws DefaultParametersException, AzDException {

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

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

        return MAPPER.mapJsonResponse(r, Builds.class);
    }

    /***
     * Queues a build
     * @param definitionId pass the pipeline id to queue the build
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(int definitionId) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("definitionId", String.valueOf(definitionId));
        }};

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Queues a build
     * @param buildParameters dictionary of parameters to queue the build.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return a build object {@link Build}
     */
    @Override
    public Build queueBuild(HashMap<String, Object> buildParameters) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/builds", null,null, BuildVersion.VERSION,null, buildParameters);

        return MAPPER.mapJsonResponse(r, Build.class);
    }

    /***
     * Gets controllers
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD,null,
                        AREA,null,"controllers", BuildVersion.BUILD_CONTROLLERS,null,null);

        return MAPPER.mapJsonResponse(r, BuildControllers.class);
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return array of build controller {@link BuildControllers}
     */
    @Override
    public BuildControllers getBuildControllers(String name) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("name", name);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD,null,
                AREA,null,"controllers", BuildVersion.BUILD_CONTROLLERS, q,null);

        return MAPPER.mapJsonResponse(r, BuildControllers.class);
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build controller {@link BuildController}
     */
    @Override
    public BuildController getBuildController(int controllerId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD,null,
                AREA + "/controllers", Integer.toString(controllerId),null, BuildVersion.BUILD_CONTROLLERS,null,null);

        return MAPPER.mapJsonResponse(r, BuildController.class);
    }

    /***
     * Creates a new definition.
     * @param buildDefinitionParameters json string of the build pipeline. Export the build definition from existing pipeline and edit it.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build definition {@link BuildDefinition}
     */
    @Override
    public BuildDefinition createBuildDefinition(String buildDefinitionParameters) throws DefaultParametersException, AzDException {

        if (buildDefinitionParameters.isEmpty()) throw new AzDException();

        var requestBody = MAPPER.mapJsonResponse(buildDefinitionParameters, HashMap.class);

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA,null,"definitions", BuildVersion.BUILD_DEFINITIONS,null, requestBody);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Deletes a definition and all associated builds.
     * @param definitionId pass the definition id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteBuildDefinition(int definitionId) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS,null,null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build definition {@link BuildDefinition}
     */
    @Override
    public BuildDefinition getBuildDefinition(int definitionId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS,null,null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Gets a definition, optionally at a specific revision.
     * @param definitionId The ID of the definition.
     * @param includeLatestBuilds if specified gets the details of latest build
     * @param minMetricsTime If specified, indicates the date from which metrics should be included.
     * @param revision The revision number to retrieve. If this is not specified, the latest version will be returned.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return Build definition object
     */
    @Override
    public BuildDefinition getBuildDefinition(
            int definitionId, boolean includeLatestBuilds, String minMetricsTime, int revision) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("includeLatestBuilds", includeLatestBuilds);
            put("minMetricsTime", minMetricsTime);
            put("revision", revision);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }

    /***
     * Gets all revisions of a definition.
     * @param definitionId The ID of the definition.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return array of build definition revisions {@link BuildDefinitionRevision}
     */
    @Override
    public BuildDefinitionRevisions getBuildDefinitionRevisions(int definitionId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/definitions", Integer.toString(definitionId),"revisions", BuildVersion.BUILD_DEFINITION_REVISIONS,null,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitionRevisions.class);
    }

    /***
     * Gets a list of definitions.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS,null,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param definitionIds array of definition ids
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int[] definitionIds) throws DefaultParametersException, AzDException {

        String ids = Arrays.stream(definitionIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

        HashMap<String, Object> q = new HashMap<>(){{
            put("definitionIds", ids);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param top definitions to retrieve
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(int top) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$top", top);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinitions.class);
    }

    /***
     * Gets a list of definitions.
     * @param name Name of the build definition
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public BuildDefinitions getBuildDefinitions(String name) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("name", name);
        }};

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                AREA + "/definitions", null, null, BuildVersion.BUILD_DEFINITIONS, q,null);

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
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return build definitions {@link BuildDefinitions}
     */
    @Override
    public Map getBuildDefinitions(
            String builtAfter, String continuationToken, boolean includeAllProperties,
            boolean includeLatestBuilds, String minMetricsTime, String notBuiltAfter,
            String path, int processType, String queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) throws DefaultParametersException, AzDException {

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

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Restores a deleted definition
     * @param definitionId pass the build definition id
     * @param deleted When false, restores a deleted definition.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return a {@link BuildDefinition} object
     */
    @Override
    public BuildDefinition restoreBuildDefinition(int definitionId, boolean deleted) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("deleted", deleted);
        }};

        String r = request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS, q,null);

        return MAPPER.mapJsonResponse(r, BuildDefinition.class);
    }
}
