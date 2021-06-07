package org.azd.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unboundid.scim2.common.messages.PatchOperation;
import com.unboundid.scim2.common.utils.JsonDiff;
import org.azd.core.types.*;
import org.azd.exceptions.AzDException;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Request;
import org.azd.utils.RequestMethod;
import org.azd.utils.ResourceId;

import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

/***
 * Core class to manage core API
 * @author Harish karthic
 */
public class Core {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final ObjectMapper MAPPER = new ObjectMapper();

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public Core(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    public AzDDefaultParameters getDEFAULT_PARAMETERS() {
        return DEFAULT_PARAMETERS;
    }

    /***
     * Get a list of processes.
     * @return a list of processes
     */
    public Processes getProcesses() {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE,null,
                            "process/processes",null,null, CoreVersion.VERSION,null,null);

            return MAPPER.readValue(r, Processes.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Creates a default scrum project
     * @param projectName pass the project name
     * @param description pass the description for the project
     * @return object with link to the project
     */
    public Map createProject(String projectName, String description) {

        try {
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

            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.CORE,null,
                            "projects",null, null, CoreVersion.PROJECT,null, h);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Creates a project for given process id
     * @param projectName pass the project name
     * @param description project description
     * @param sourceControlType type of version control
     * @param templateTypeId pass the process id. Run getProcesses to get the list of process id
     * @return object with link to the project
     */
    public Map createProject(String projectName, String description, String sourceControlType,
                             String templateTypeId) {

        try {
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

            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.CORE,null,
                            "projects",null,null, CoreVersion.PROJECT, null, h);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Queues a project to be deleted.
     * <p>
     *     You should pass the project id to delete it. Passing the project name
     *     won't delete. To get the project id run getProject() with projectName
     *     and get the Id.
     * </p>
     * @param projectId pass the project id
     * @return object of deleted project with url
     */
    public Map deleteProject(String projectId) {

        try {
            String r = Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "projects", projectId,null, CoreVersion.PROJECT,null,null);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @return project object {@link Project}
     */
    public Project getProject(String projectName) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE,null,
                            "projects", projectName,null, CoreVersion.PROJECT,null,null);
        return MAPPER.readValue(r, Project.class);

        } catch (Exception e) {
            AzDException.handleException(e);

        }

        return null;
    }

    /***
     * Get project with the specified id or name with optional parameters
     * @param projectName pass the project name or id
     * @param includeCapabilities Include capabilities (such as source control) in the team project result (default: false).
     * @param includeHistory Search within renamed projects (that had such name in the past).
     * @return project object {@link Project}
     */
    public Project getProject(String projectName, boolean includeCapabilities, boolean includeHistory) {

        try {
            HashMap<String, Object> q = new HashMap<>() {{
                put("includeCapabilities", includeCapabilities);
                put("includeHistory", includeHistory);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE,null,
                            "projects", projectName,null, CoreVersion.PROJECT, q,null);

            return MAPPER.readValue(r, Project.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @return array of key value pairs
     */
    public Map getProjectProperties(String projectId) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                    "projects", projectId, null, CoreVersion.PROJECT_PROPERTIES, null, null);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @return array of projects {@link Projects}
     */
    public Projects getProjects() {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "projects", null, null, CoreVersion.PROJECT, null, null);

            return MAPPER.readValue(r, Projects.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @param skip specify how many projects to skip
     * @param top specify the number projects to retrieve
     * @param continuationToken specify the next value to retrieve
     * @param getDefaultTeamImageUrl if true gets the default team image url
     * @param stateFilter allowed values are [all, createPending, deleted, deleting, new, unchanged, wellFormed]
     * @return array of projects {@link Projects}
     */
    public Projects getProjects(int skip, int top, String continuationToken,
                                boolean getDefaultTeamImageUrl, String stateFilter) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$skip", skip);
                put("$top", top);
                put("continuationToken", continuationToken);
                put("getDefaultTeamImageUrl", getDefaultTeamImageUrl);
                put("stateFilter", stateFilter);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "projects", null, null, CoreVersion.PROJECT, q, null);

            return MAPPER.readValue(r, Projects.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Update an existing project's name, abbreviation, description, or restore a project.
     * @param projectId pass the project id
     * @param projectParameters HashMap of project parameters to be updated.
     * <p> Refer "https://docs.microsoft.com/en-us/rest/api/azure/devops/core/projects/update?view=azure-devops-rest-6.1" </p>
     * @return an object or team project with url
     */
    public Map updateProject(String projectId, HashMap<String, Object> projectParameters) {

        try {
            String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "projects", projectId, null, CoreVersion.PROJECT, null, projectParameters);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Create a team in a team project.
     * @param projectName project name or GUID
     * @param teamName pass the team name
     * @return returns web api object
     */
    public Map createTeam(String projectName, String teamName) {

        try {
            HashMap<String, Object> h = new HashMap<>(){{
                put("name", teamName);
            }};

            String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "projects", projectName, "teams", CoreVersion.PROJECT_TEAMS, null, h);

            return MAPPER.readValue(r, Map.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Delete a team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     */
    public void deleteTeam(String projectName, String teamName) {

        try {
            Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                    "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, null, null);
        } catch (Exception e) {
            AzDException.handleException(e);
        }
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @return team object
     */
    public Team getTeam(String projectName, String teamName) {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, null, null);

            return MAPPER.readValue(r, Team.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @param expandIdentity if true gets the identity object
     * @return team object
     */
    public Team getTeam(String projectName, String teamName, boolean expandIdentity) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$expandIdentity", expandIdentity);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                    "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, q, null);

            return MAPPER.readValue(r, Team.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get a list of all teams.
     * @return array of team
     */
    public Teams getTeams() {

        try {
            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "teams", null, null, CoreVersion.PROJECT_TEAMS, null, null);
            return MAPPER.readValue(r, Teams.class);
        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Get a list of all teams.
     * @param expandIdentity if true gets the identity object
     * @param mine if true gets the team to which user has access to
     * @param skip pass to skip number of teams
     * @param top pass to retrieve number of teams
     * @return array of team
     */
    public Teams getTeams(boolean expandIdentity, String mine, int skip, int top) {

        try {
            HashMap<String, Object> q = new HashMap<>(){{
                put("$expandIdentity", expandIdentity);
                put("$mine", mine);
                put("$skip", skip);
                put("$top", top);
            }};

            String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "teams", null, null, CoreVersion.PROJECT_TEAMS, q, null);

            return MAPPER.readValue(r, Teams.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }

    /***
     * Update a team's name and/or description.
     * @param projectName The name or ID (GUID) of the team project containing the team to update.
     * @param teamName The name or ID of the team to update.
     * @param description provide the description for your team to update
     * @return team object {@link Team}
     */
    public Team updateTeams(String projectName, String teamName, String description) {

        try {
            HashMap<String, Object> h = new HashMap<>(){{
                put("name", teamName);
                put("description", description);
            }};

            String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.CORE, null,
                            "projects", projectName, "teams/" + teamName, CoreVersion.PROJECT_TEAMS, null, h);

            return MAPPER.readValue(r, Team.class);

        } catch (Exception e) {
            AzDException.handleException(e);
        }

        return null;
    }
}
