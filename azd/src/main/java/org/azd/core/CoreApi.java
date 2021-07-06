package org.azd.core;

import org.azd.core.types.*;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.CoreDetails;
import org.azd.connection.Connection;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.azd.utils.Client.request;

/***
 * Core class to manage core API
 */
public class CoreApi implements CoreDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();

    /***
     * Pass the connection object to work with Core Api
     * @param connection Connection object
     */
    public CoreApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Get a list of processes.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return a list of processes {@link Processes}
     */
    @Override
    public Processes getProcesses() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE,null,
                        "process/processes",null,null, CoreVersion.VERSION,null,null);

        return MAPPER.mapJsonResponse(r, Processes.class);
    }

    /***
     * Creates a default scrum project
     * @param projectName pass the project name
     * @param description pass the description for the project
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return object with link to the project
     */
    @Override
    public Map createProject(String projectName, String description) throws DefaultParametersException, AzDException {

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

        String r = request(RequestMethod.POST, CONNECTION, ResourceId.CORE,null,
                        "projects",null, null, CoreVersion.PROJECT,null, h);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Creates a project for given process id
     * @param projectName pass the project name
     * @param description project description
     * @param sourceControlType type of version control
     * @param templateTypeId pass the process id. Run getProcesses to get the list of process id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return object with link to the project
     */
    @Override
    public Map createProject(String projectName, String description, String sourceControlType,
                             String templateTypeId) throws DefaultParametersException, AzDException {

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

        String r = request(RequestMethod.POST, CONNECTION, ResourceId.CORE,null,
                        "projects",null,null, CoreVersion.PROJECT, null, h);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Queues a project to be deleted.
     * <p>
     *     You should pass the project id to delete it. Passing the project name
     *     won't delete. To get the project id run getProject() with projectName
     *     and get the Id.
     * </p>
     * @param projectId pass the project id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return object of deleted project with url
     */
    @Override
    public Map deleteProject(String projectId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.DELETE, CONNECTION, ResourceId.CORE, null,
                        "projects", projectId,null, CoreVersion.PROJECT,null,null);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return project object {@link Project}
     */
    @Override
    public Project getProject(String projectName) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE,null,
                        "projects", projectName,null, CoreVersion.PROJECT,null,null);

        return MAPPER.mapJsonResponse(r, Project.class);
    }

    /***
     * Get project with the specified id or name with optional parameters
     * @param projectName pass the project name or id
     * @param includeCapabilities Include capabilities (such as source control) in the team project result (default: false).
     * @param includeHistory Search within renamed projects (that had such name in the past).
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return project object {@link Project}
     */
    @Override
    public Project getProject(String projectName, boolean includeCapabilities, boolean includeHistory) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>() {{
            put("includeCapabilities", includeCapabilities);
            put("includeHistory", includeHistory);
        }};

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE,null,
                        "projects", projectName,null, CoreVersion.PROJECT, q,null);

        return MAPPER.mapJsonResponse(r, Project.class);
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return ProjectProperties {@link ProjectProperties}
     */
    @Override
    public ProjectProperties getProjectProperties(String projectId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE, null,
                "projects", projectId, "properties", CoreVersion.PROJECT_PROPERTIES, null, null);

        return MAPPER.mapJsonResponse(r, ProjectProperties.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return array of projects {@link Projects}
     */
    @Override
    public Projects getProjects() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE, null,
                        "projects", null, null, CoreVersion.PROJECT, null, null);

        return MAPPER.mapJsonResponse(r, Projects.class);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @param skip specify how many projects to skip
     * @param top specify the number projects to retrieve
     * @param continuationToken specify the next value to retrieve
     * @param getDefaultTeamImageUrl if true gets the default team image url
     * @param stateFilter allowed values are [all, createPending, deleted, deleting, new, unchanged, wellFormed]
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return array of projects {@link Projects}
     */
    @Override
    public Projects getProjects(int skip, int top, String continuationToken,
                                boolean getDefaultTeamImageUrl, String stateFilter) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$skip", skip);
            put("$top", top);
            put("continuationToken", continuationToken);
            put("getDefaultTeamImageUrl", getDefaultTeamImageUrl);
            put("stateFilter", stateFilter);
        }};

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE, null,
                        "projects", null, null, CoreVersion.PROJECT, q, null);

        return MAPPER.mapJsonResponse(r, Projects.class);
    }

    /***
     * Update an existing project's name, abbreviation, description, or restore a project.
     * @param projectId pass the project id
     * @param projectParameters HashMap of project parameters to be updated.
     * <p> Refer "https://docs.microsoft.com/en-us/rest/api/azure/devops/core/projects/update?view=azure-devops-rest-6.1" </p>
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return an object or team project with url
     */
    @Override
    public Map updateProject(String projectId, HashMap<String, Object> projectParameters) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.PATCH, CONNECTION, ResourceId.CORE, null,
                        "projects", projectId, null, CoreVersion.PROJECT, null, projectParameters);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Create a team in a team project.
     * @param projectName project name or GUID
     * @param teamName pass the team name
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return returns web api object
     */
    @Override
    public Map createTeam(String projectName, String teamName) throws DefaultParametersException, AzDException {

        HashMap<String, Object> h = new HashMap<>(){{
            put("name", teamName);
        }};

        String r = request(RequestMethod.POST, CONNECTION, ResourceId.CORE, null,
                        "projects", projectName, "teams", CoreVersion.PROJECT_TEAMS, null, h);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Delete a team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteTeam(String projectName, String teamName) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, CONNECTION, ResourceId.CORE, null,
                    "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return team object
     */
    @Override
    public Team getTeam(String projectName, String teamName) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE, null,
                        "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, null, null);

        return MAPPER.mapJsonResponse(r, Team.class);
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @param expandIdentity if true gets the identity object
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return team object
     */
    @Override
    public Team getTeam(String projectName, String teamName, boolean expandIdentity) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$expandIdentity", expandIdentity);
        }};

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE, null,
                "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, q, null);

        return MAPPER.mapJsonResponse(r, Team.class);
    }

    /***
     * Get a list of all teams.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return array of team
     */
    @Override
    public Teams getTeams() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE, null,
                        "teams", null, null, CoreVersion.PROJECT_TEAMS, null, null);
        return MAPPER.mapJsonResponse(r, Teams.class);
    }

    /***
     * Get a list of all teams.
     * @param expandIdentity if true gets the identity object
     * @param mine if true gets the team to which user has access to
     * @param skip pass to skip number of teams
     * @param top pass to retrieve number of teams
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return array of team
     */
    @Override
    public Teams getTeams(boolean expandIdentity, String mine, int skip, int top) throws DefaultParametersException, AzDException {

        HashMap<String, Object> q = new HashMap<>(){{
            put("$expandIdentity", expandIdentity);
            put("$mine", mine);
            put("$skip", skip);
            put("$top", top);
        }};

        String r = request(RequestMethod.GET, CONNECTION, ResourceId.CORE, null,
                        "teams", null, null, CoreVersion.PROJECT_TEAMS, q, null);

        return MAPPER.mapJsonResponse(r, Teams.class);
    }

    /***
     * Update a team's name and/or description.
     * @param projectName The name or ID (GUID) of the team project containing the team to update.
     * @param teamName The name or ID of the team to update.
     * @param description provide the description for your team to update
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     * @return team object {@link Team}
     */
    @Override
    public Team updateTeams(String projectName, String teamName, String description) throws DefaultParametersException, AzDException {

        HashMap<String, Object> h = new HashMap<>(){{
            put("name", teamName);
            put("description", description);
        }};

        String r = request(RequestMethod.PATCH, CONNECTION, ResourceId.CORE, null,
                        "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, null, h);

        return MAPPER.mapJsonResponse(r, Team.class);
    }
}
