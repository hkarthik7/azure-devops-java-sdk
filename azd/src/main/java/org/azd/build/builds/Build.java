package org.azd.build.builds;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.build.types.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Request;
import org.azd.utils.RequestMethod;
import org.azd.utils.ResourceId;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import static org.azd.validators.AzDDefaultParametersValidator.validateDefaultParameters;

/***
 * Build class to manage build API
 * @author Harish karthic
 */
public class Build {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final ObjectMapper MAPPER = new ObjectMapper();
    private final String AREA = "build";


    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public Build(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    /***
     * Deletes a build.
     * @param buildId pass the build id to delete
     */
    public void deleteBuild(int buildId) {

        try {
            Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds", Integer.toString(buildId), null, BuildVersion.VERSION, null, null);
        } catch (Exception e) {
            AzDException.handleException(e);
        }
    }

    /***
     * Gets a build
     * @param buildId pass the build id
     * @return a build object {@link BuildT}
     */
    public BuildT getBuild(int buildId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/builds", Integer.toString(buildId), null, BuildVersion.VERSION, null, null);

            return MAPPER.readValue(r, BuildT.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @return the object of build changes
     */
    public BuildChanges getBuildChanges(int buildId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds", Integer.toString(buildId), "changes", BuildVersion.BUILD_CHANGES,null, null);

            return MAPPER.readValue(r, BuildChanges.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets the changes associated with a build
     * @param buildId pass the build id
     * @param top The maximum number of changes to return
     * @param continuationToken pass the continuation token
     * @param includeSourceChange if set to true gets the source changes
     * @return the object of build changes
     */
    public BuildChanges getBuildChanges(
            int buildId, int top,  String continuationToken, boolean includeSourceChange) {

        try {
            HashMap<String, Object> q = new HashMap<>() {{
                put("$top", top);
                put("continuationToken", continuationToken);
                put("includeSourceChange", includeSourceChange);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds", Integer.toString(buildId), "changes", BuildVersion.BUILD_CHANGES, q, null);
            return MAPPER.readValue(r, BuildChanges.class);
        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @return logs associated with the build for given id
     */
    public String getBuildLog(int buildId, int logId) {

        try {
            return Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds", Integer.toString(buildId), "logs/" + logId, BuildVersion.BUILD_LOGS, null, null, "text");
        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets an individual log file for a build.
     * @param buildId pass the build id
     * @param logId pass the log id
     * @param startLine pass the line number from log which you need to fetch
     * @param endLine pass till which line number you need to fetch from the log
     * @return logs associated with the build for given id
     */
    public String getBuildLog(int buildId, int logId, long startLine, long endLine) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("startLine", startLine);
                put("endLine", endLine);
            }};

            return Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds", Integer.toString(buildId),"logs/" + logId, BuildVersion.BUILD_LOGS, q, null,"text");

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets the logs for a build.
     * @param buildId pass the build id
     * @return the object of build logs with id. This can be used to fetch the particular log with id
     */
    public BuildLogs getBuildLogs(int buildId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds", Integer.toString(buildId),"logs", BuildVersion.BUILD_LOGS,null,null);

            return MAPPER.readValue(r, BuildLogs.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId The ID of the build.
     * @return an array of work items associated with the build
     */
    public BuildWorkItems getBuildWorkItems(int buildId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/builds", Integer.toString(buildId), "workitems", BuildVersion.BUILD_WORK_ITEMS,null,null);

            return MAPPER.readValue(r, BuildWorkItems.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets the work items associated with a build.
     * @param buildId id of the build
     * @param top specify how many top work items to return
     * @return an array of work items associated with the build
     */
    public BuildWorkItems getBuildWorkItems(int buildId, int top) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$top", top);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/builds", Integer.toString(buildId),"workitems", BuildVersion.BUILD_WORK_ITEMS, q,null);

            return MAPPER.readValue(r, BuildWorkItems.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets the changes made to the repository between two given builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @return an array of changes between the builds
     */
    public BuildChanges getChangesBetweenBuilds(int fromBuildId, int toBuildId, int top) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$top", top);
                put("fromBuildId", fromBuildId);
                put("toBuildId", toBuildId);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA, null, "changes", BuildVersion.BUILD_CHANGES, q,null);

            return MAPPER.readValue(r, BuildChanges.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets all the work items between two builds.
     * @param fromBuildId The ID of the first build.
     * @param toBuildId The ID of the last build.
     * @param top The maximum number of changes to return.
     * @return an array of workitems between the builds
     */
    public BuildWorkItems getWorkItemsBetweenBuilds(int fromBuildId, int toBuildId, int top) {


        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$top", top);
                put("fromBuildId", fromBuildId);
                put("toBuildId", toBuildId);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA, null,"workitems", BuildVersion.BUILD_WORK_ITEMS, q,null);

            return MAPPER.readValue(r, BuildWorkItems.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a list of builds.
     * @return a build array
     */
    public Builds getBuilds() {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds",null,null, BuildVersion.VERSION,null,null);

            return MAPPER.readValue(r, Builds.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a list of builds.
     * @param buildIds array of build ids
     * @return an array of build
     */
    public Builds getBuilds(int[] buildIds) {

        try {
            String ids = Arrays.stream(buildIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

            HashMap<String, Object> q = new HashMap<>(){{
                put("buildIds", ids);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

            return MAPPER.readValue(r, Builds.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a list of builds.
     * @param top specify how many builds to retrieve
     * @return an array of build
     */
    public Builds getBuilds(int top) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$top", top);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

            return MAPPER.readValue(r, Builds.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return an array of build
     */
    public Builds getBuilds(
            int top, String branchName, String buildNumber, String continuationToken, int[] definitions,
            String deletedFilter, int maxBuildsPerDefinition, String maxTime, String minTime,
            String[] properties, String queryOrder, int[] queues, String reasonFilter,
            String repositoryId, String repositoryType, String requestedFor, String resultFilter,
            String statusFilter, String tagFilters) {


        try {
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

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

            return MAPPER.readValue(r, Builds.class);
        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Queues a build
     * @param definitionName pass the pipeline name to queue the build
     * @return a build object {@link BuildT}
     */
    public BuildT queueBuild(String definitionName) {

        try {
            var d = getBuildDefinitions().getBuildDefinition()
                    .stream().filter(id -> (id.getName().equals(definitionName))).findFirst();

            HashMap<String, Object> q = new HashMap<>() {{
                put("definitionId", d.get().getId());
            }};

            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/builds",null,null, BuildVersion.VERSION, q,null);

            return MAPPER.readValue(r, BuildT.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Queues a build
     * @param buildParameters dictionary of parameters to queue the build.
     * @return a build object {@link BuildT}
     */
    public BuildT queueBuild(HashMap<String, Object> buildParameters) {

        try {
            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/builds", null,null, BuildVersion.VERSION,null, buildParameters);

            return MAPPER.readValue(r, BuildT.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets controllers
     * @return array of build controller
     */
    public BuildControllers getBuildControllers() {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD,null,
                            AREA,null,"controllers", BuildVersion.BUILD_CONTROLLERS,null,null);

            return MAPPER.readValue(r, BuildControllers.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets controller, optionally filtered by name
     * @param name pass the controller name
     * @return array of build controller
     */
    public BuildControllers getBuildControllers(String name) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("name", name);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD,null,
                    AREA,null,"controllers", BuildVersion.BUILD_CONTROLLERS, q,null);

            return MAPPER.readValue(r, BuildControllers.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a controller
     * @param controllerId pass the controller id
     * @return build controller
     */
    public BuildController getBuildController(int controllerId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD,null,
                    AREA + "/controllers", Integer.toString(controllerId),null, BuildVersion.BUILD_CONTROLLERS,null,null);

            return MAPPER.readValue(r, BuildController.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Creates a new definition.
     * @param buildParameters dictionary of build definition to create the build pipeline.
     * @return build definition {@link BuildDefinition}
     */
    public BuildDefinition createBuildDefinition(HashMap<String, Object> buildParameters) {

        try {
            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA,null,"definitions", BuildVersion.BUILD_DEFINITIONS,null, buildParameters);

            return MAPPER.readValue(r, BuildDefinition.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Deletes a definition and all associated builds.
     * @param definitionId pass the definition id
     */
    public void deleteBuildDefinition(int definitionId) {

        try {
            Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS,null,null);
        } catch (Exception e) {
            AzDException.handleException(e);
        }
    }

    /***
     * Gets a definition
     * @param definitionId pass the definition id
     * @return build definition {@link BuildDefinition}
     */
    public BuildDefinition getBuildDefinition(int definitionId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS,null,null);

            return MAPPER.readValue(r, BuildDefinition.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a definition, optionally at a specific revision.
     * @param definitionId The ID of the definition.
     * @param includeLatestBuilds if specified gets the details of latest build
     * @param minMetricsTime If specified, indicates the date from which metrics should be included.
     * @param revision The revision number to retrieve. If this is not specified, the latest version will be returned.
     * @return Build definition object
     */
    public Map getBuildDefinition(
            int definitionId, boolean includeLatestBuilds, String minMetricsTime, int revision) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("includeLatestBuilds", includeLatestBuilds);
                put("minMetricsTime", minMetricsTime);
                put("revision", revision);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS, q,null);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets all revisions of a definition.
     * @param definitionId The ID of the definition.
     * @return array of build definition revisions {@link BuildDefinitionRevision}
     */
    public BuildDefinitionRevisions getBuildDefinitionRevision(int definitionId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/definitions", Integer.toString(definitionId),"revisions", BuildVersion.BUILD_DEFINITION_REVISIONS,null,null);

            return MAPPER.readValue(r, BuildDefinitionRevisions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a list of definitions.
     * @return build definitions {@link BuildDefinitions}
     */
    public BuildDefinitions getBuildDefinitions() {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS,null,null);

            return MAPPER.readValue(r, BuildDefinitions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a list of definitions.
     * @param definitionIds array of definition ids
     * @return build definitions {@link BuildDefinitions}
     */
    public BuildDefinitions getBuildDefinitions(int[] definitionIds) {

        try {
            String ids = Arrays.stream(definitionIds).mapToObj(String::valueOf).collect(Collectors.joining(","));

            HashMap<String, Object> q = new HashMap<>(){{
                put("definitionIds", ids);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS, q,null);

            return MAPPER.readValue(r, BuildDefinitions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a list of definitions.
     * @param top definitions to retrieve
     * @return build definitions {@link BuildDefinitions}
     */
    public BuildDefinitions getBuildDefinitions(int top) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$top", top);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS, q,null);

            return MAPPER.readValue(r, BuildDefinitions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Gets a list of definitions.
     * @param name Name of the build definition
     * @return build definitions {@link BuildDefinitions}
     */
    public BuildDefinitions getBuildDefinitions(String name) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("name", name);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/definitions", null, null, BuildVersion.BUILD_DEFINITIONS, q,null);

            return MAPPER.readValue(r, BuildDefinitions.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
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
     * @return build definitions {@link BuildDefinitions}
     */
    public Map getBuildDefinitions(
            String builtAfter, String continuationToken, boolean includeAllProperties,
            boolean includeLatestBuilds, String minMetricsTime, String notBuiltAfter,
            String path, int processType, String queryOrder, String repositoryId,
            String repositoryType, String taskIdFilter, String yamlFilename) {


        try {
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

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/definitions",null,null, BuildVersion.BUILD_DEFINITIONS, q,null);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Restores a deleted definition
     * @param definitionId pass the build definition id
     * @param deleted When false, restores a deleted definition.
     * @return a {@link BuildDefinition} object
     */
    public BuildDefinition restoreBuildDefinition(int definitionId,  boolean deleted) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("deleted", deleted);
            }};

            String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.BUILD, DEFAULT_PARAMETERS.getProject(),
                            AREA + "/definitions", Integer.toString(definitionId),null, BuildVersion.BUILD_DEFINITIONS, q,null);

            return MAPPER.readValue(r, BuildDefinition.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }
}
