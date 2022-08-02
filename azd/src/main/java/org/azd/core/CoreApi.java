package org.azd.core;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.core.types.*;
import org.azd.enums.CustomHeader;
import org.azd.enums.FeatureManagement;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.CoreDetails;
import org.azd.utils.AzDAsyncApi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static org.azd.utils.RestClient.send;

/***
 * Core class to manage core API
 */
public class CoreApi extends AzDAsyncApi<CoreApi> implements CoreDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String CORE = "79134c72-4a58-4b42-976c-04e7115f32bf";
    private final String AREA = "projects";

    /***
     * Pass the connection object to work with Core Api
     * @param connection Connection object
     */
    public CoreApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Get a list of processes.
     * @throws AzDException Default Api Exception handler.
     * @return a list of processes {@link Processes}
     */
    @Override
    public Processes getProcesses() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                "process/processes", null, null, ApiVersion.CORE, null, null, null);

        return MAPPER.mapJsonResponse(r, Processes.class);
    }

    /***
     * Creates a default scrum project
     * @param projectName pass the project name
     * @param description pass the description for the project
     * @throws AzDException Default Api Exception handler.
     * @return object with link to the project
     */
    @Override
    public OperationReference createProject(String projectName, String description) throws AzDException {

        LinkedHashMap<String, Object> h = new LinkedHashMap<>() {{
            put("name", projectName);
            put("description", description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", "Git");
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", "6b724908-ef14-45cf-84f8-768b5384da45");
                }});
            }});
        }};

        String r = send(RequestMethod.POST, CONNECTION, CORE, null,
                AREA, null, null, ApiVersion.PROJECT, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, OperationReference.class);
    }

    /***
     * Creates a project for given process id
     * @param projectName pass the project name
     * @param description project description
     * @param sourceControlType type of version control
     * @param templateTypeId pass the process id. Run getProcesses to get the list of process id
     * @throws AzDException Default Api Exception handler.
     * @return object with link to the project
     */
    @Override
    public OperationReference createProject(String projectName, String description, String sourceControlType,
                                            String templateTypeId) throws AzDException {

        LinkedHashMap<String, Object> h = new LinkedHashMap<>() {{
            put("name", projectName);
            put("description", description);
            put("capabilities", new LinkedHashMap<String, Object>() {{
                put("versioncontrol", new LinkedHashMap<String, Object>() {{
                    put("sourceControlType", sourceControlType);
                }});
                put("processTemplate", new LinkedHashMap<String, Object>() {{
                    put("templateTypeId", templateTypeId);
                }});
            }});
        }};

        String r = send(RequestMethod.POST, CONNECTION, CORE, null,
                AREA, null, null, ApiVersion.PROJECT, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, OperationReference.class);
    }

    /***
     * Queues a project to be deleted.
     * <p>
     *     You should pass the project id to delete it. Passing the project name
     *     won't delete. To get the project id run getProject() with projectName
     *     and get the Id.
     * </p>
     * @param projectId pass the project id
     * @throws AzDException Default Api Exception handler.
     * @return object of deleted project with url
     */
    @Override
    public OperationReference deleteProject(String projectId) throws AzDException {

        String r = send(RequestMethod.DELETE, CONNECTION, CORE, null,
                AREA, projectId, null, ApiVersion.PROJECT, null, null, null);

        return MAPPER.mapJsonResponse(r, OperationReference.class);
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    @Override
    public Project getProject(String projectName) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                AREA, projectName, null, ApiVersion.PROJECT, null, null, null);

        return MAPPER.mapJsonResponse(r, Project.class);
    }

    /***
     * Get project with the specified id or name with optional parameters
     * @param projectName pass the project name or id
     * @param includeCapabilities Include capabilities (such as source control) in the team project result (default: false).
     * @param includeHistory Search within renamed projects (that had such name in the past).
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    @Override
    public Project getProject(String projectName, boolean includeCapabilities, boolean includeHistory) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("includeCapabilities", includeCapabilities);
            put("includeHistory", includeHistory);
        }};

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                AREA, projectName, null, ApiVersion.PROJECT, q, null, null);

        return MAPPER.mapJsonResponse(r, Project.class);
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    @Override
    public ProjectProperties getProjectProperties(String projectId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                AREA, projectId, "properties", ApiVersion.PROJECT_PROPERTIES, null, null, null);

        return MAPPER.mapJsonResponse(r, ProjectProperties.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @throws AzDException Default Api Exception handler.
     * @return array of projects {@link Projects}
     */
    @Override
    public Projects getProjects() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                AREA, null, null, ApiVersion.PROJECT, null, null, null);

        return MAPPER.mapJsonResponse(r, Projects.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @param skip specify how many projects to skip
     * @param top specify the number projects to retrieve
     * @param continuationToken specify the next value to retrieve
     * @param getDefaultTeamImageUrl if true gets the default team image url
     * @param stateFilter allowed values are [all, createPending, deleted, deleting, new, unchanged, wellFormed]
     * @throws AzDException Default Api Exception handler.
     * @return array of projects {@link Projects}
     */
    @Override
    public Projects getProjects(int skip, int top, String continuationToken,
                                boolean getDefaultTeamImageUrl, String stateFilter) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("$skip", skip);
            put("$top", top);
            put("continuationToken", continuationToken);
            put("getDefaultTeamImageUrl", getDefaultTeamImageUrl);
            put("stateFilter", stateFilter);
        }};

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                AREA, null, null, ApiVersion.PROJECT, q, null, null);

        return MAPPER.mapJsonResponse(r, Projects.class);
    }

    /***
     * Update an existing project's name, abbreviation, description, or restore a project.
     * @param projectId pass the project id
     * @param projectParameters HashMap of project parameters to be updated.
     * <p> Refer "https://docs.microsoft.com/en-us/rest/api/azure/devops/core/projects/update?view=azure-devops-rest-6.1" </p>
     * @throws AzDException Default Api Exception handler.
     * @return an object or team project with url
     */
    @Override
    public OperationReference updateProject(String projectId, Project projectParameters) throws AzDException {

        String r = send(RequestMethod.PATCH, CONNECTION, CORE, null,
                AREA, projectId, null, ApiVersion.PROJECT, null, projectParameters, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, OperationReference.class);
    }

    /***
     * Create a team in a team project.
     * @param projectName project name or GUID
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     * @return returns web api object
     */
    @Override
    public WebApiTeam createTeam(String projectName, String teamName) throws AzDException {

        HashMap<String, Object> h = new HashMap<>() {{
            put("name", teamName);
        }};

        String r = send(RequestMethod.POST, CONNECTION, CORE, null,
                AREA, projectName, "teams", ApiVersion.PROJECT_TEAMS, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, WebApiTeam.class);
    }

    /***
     * Delete a team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteTeam(String projectName, String teamName) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, CORE, null,
                    AREA, projectName, "teams/" + teamName, ApiVersion.PROJECT_TEAMS, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     * @return team object
     */
    @Override
    public Team getTeam(String projectName, String teamName) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                AREA, projectName, "teams/" + teamName, ApiVersion.PROJECT_TEAMS, null, null, null);

        return MAPPER.mapJsonResponse(r, Team.class);
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @param expandIdentity if true gets the identity object
     * @throws AzDException Default Api Exception handler.
     * @return team object
     */
    @Override
    public Team getTeam(String projectName, String teamName, boolean expandIdentity) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("$expandIdentity", expandIdentity);
        }};

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                AREA, projectName, "teams/" + teamName, ApiVersion.PROJECT_TEAMS, q, null, null);

        return MAPPER.mapJsonResponse(r, Team.class);
    }

    /***
     * Get a list of all teams.
     * @throws AzDException Default Api Exception handler.
     * @return array of team
     */
    @Override
    public Teams getTeams() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                "teams", null, null, ApiVersion.PROJECT_TEAMS, null, null, null);
        return MAPPER.mapJsonResponse(r, Teams.class);
    }

    /***
     * Get a list of all teams.
     * @param expandIdentity if true gets the identity object
     * @param mine if true gets the team to which user has access to
     * @param skip pass to skip number of teams
     * @param top pass to retrieve number of teams
     * @throws AzDException Default Api Exception handler.
     * @return array of team
     */
    @Override
    public Teams getTeams(boolean expandIdentity, String mine, int skip, int top) throws AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("$expandIdentity", expandIdentity);
            put("$mine", mine);
            put("$skip", skip);
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, CORE, null,
                "teams", null, null, ApiVersion.PROJECT_TEAMS, q, null, null);

        return MAPPER.mapJsonResponse(r, Teams.class);
    }

    /***
     * Update a team's name and/or description.
     * @param projectName The name or ID (GUID) of the team project containing the team to update.
     * @param teamName The name or ID of the team to update.
     * @param description provide the description for your team to update
     * @throws AzDException Default Api Exception handler.
     * @return team object {@link Team}
     */
    @Override
    public Team updateTeams(String projectName, String teamName, String description) throws AzDException {

        HashMap<String, Object> h = new HashMap<>() {{
            put("name", teamName);
            put("description", description);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, CORE, null,
                AREA, projectName, "teams/" + teamName, ApiVersion.PROJECT_TEAMS, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, Team.class);
    }

    /***
     * Call un-published API feature to fetch project service feature state.
     * See {@link FeatureManagement} for current list of features.
     * Besides an 'enabled' and 'disabled' state, there is also an undefined state, hence the Optional return wrapper
     * @param projectId project identifier
     * @param feature FeatureManagement enum type for which to return state
     * @return Optional wrapped boolean, empty if state is undefined
     * @throws AzDException Default Api Exception handler
     */
    @Override
    public Optional<Boolean> getFeatureState(String projectId, FeatureManagement feature) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, null, null,
                "FeatureManagement/FeatureStates/host/project", projectId, feature.getFeatureId(), ApiVersion.FEATURE_MANAGEMENT,
                null, null, null);

        return MAPPER.mapJsonResponse(r, ProjectFeature.class).getStateAsBoolean();
    }

    /***
     * Set project feature state for project service
     * See {@link FeatureManagement} for list of features
     *
     * @param projectId project identifier
     * @param feature enum value for feature to enable or disable
     * @param state enable or disable feature
     * @return object containing feature id and state
     * @throws AzDException Default Api Exception handler
     */
    @Override
    public ProjectFeature featureToggle(String projectId, FeatureManagement feature, boolean state) throws AzDException {
        LinkedHashMap<String, Object> b = new LinkedHashMap<>() {{
            put("featureId", feature.getFeatureId());
            put("scope", new LinkedHashMap<>() {{
                put("settingScope", "project");
                put("userScoped", false);
            }});
            put("state", state ? 1 : 0);
        }};
        String r = send(RequestMethod.PATCH, CONNECTION, null, null,
                "FeatureManagement/FeatureStates/host/project", projectId, feature.getFeatureId(), ApiVersion.FEATURE_MANAGEMENT,
                null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, ProjectFeature.class);
    }
}
