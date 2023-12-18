package org.azd.core;

import org.azd.core.types.*;
import org.azd.enums.FeatureManagement;
import org.azd.enums.ProjectState;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.CoreDetails;
import org.azd.serviceclient.AzDServiceClient;
import org.azd.utils.AzDAsyncApi;

import java.util.Optional;

/***
 * Core class to manage core API
 */
public class CoreApi extends AzDAsyncApi<CoreApi> implements CoreDetails {

    private final CoreRequestBuilder CORE;

    /**
     * Requires the instance of AzDServiceClient.
     * @param client Pass the instance of {@link AzDServiceClient}
     */
    public CoreApi(AzDServiceClient client) {
        CORE = client.core();
    }

    /***
     * Get a list of processes.
     * @throws AzDException Default Api Exception handler.
     * @return a list of processes {@link Processes}
     */
    @Override
    public Processes getProcesses() throws AzDException {
        return CORE.processes().list();
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
        return CORE.projects().create(projectName, description);
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
        return CORE.projects().create(projectName, description, sourceControlType, templateTypeId);
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
        return CORE.projects().delete(projectId);
    }

    /***
     * Get project with the specified id or name
     * @param projectName pass the project name or id
     * @throws AzDException Default Api Exception handler.
     * @return project object {@link Project}
     */
    @Override
    public Project getProject(String projectName) throws AzDException {
        return CORE.projects().get(projectName);
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
        return CORE.projects().get(projectName, r ->  {
            r.queryParameters.includeCapabilities = includeCapabilities;
            r.queryParameters.includeHistory = includeHistory;
        });
    }

    /***
     * Get a collection of team project properties.
     * @param projectId provide the project guid not the project name
     * @throws AzDException Default Api Exception handler.
     * @return ProjectProperties {@link ProjectProperties}
     */
    @Override
    public ProjectProperties getProjectProperties(String projectId) throws AzDException {
        return CORE.projects().properties().get(projectId);
    }

    /***
     * Get all projects in the organization that the authenticated user has access to.
     * @throws AzDException Default Api Exception handler.
     * @return array of projects {@link Projects}
     */
    @Override
    public Projects getProjects() throws AzDException {
        return CORE.projects().list();
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
    public Projects getProjects(Number skip, Number top, Number continuationToken,
                                Boolean getDefaultTeamImageUrl, ProjectState stateFilter) throws AzDException {
        return CORE.projects().list(r -> {
            r.queryParameters.continuationToken = continuationToken;
            r.queryParameters.top = top;
            r.queryParameters.getDefaultTeamImageUrl = getDefaultTeamImageUrl;
            r.queryParameters.stateFilter = stateFilter;
            r.queryParameters.skip = skip;
        });
    }

    /***
     * Update an existing project's name, abbreviation, description, or restore a project.
     * @param projectId pass the project id
     * @param projectParameters HashMap of project parameters to be updated.
     * @see <a href="https://docs.microsoft.com/en-us/rest/api/azure/devops/core/projects/update?view=azure-devops-rest-6.1">Projects - Update</a>
     * @throws AzDException Default Api Exception handler.
     * @return an object or team project with url
     */
    @Override
    public OperationReference updateProject(String projectId, Project projectParameters) throws AzDException {
        return CORE.projects().update(projectId, projectParameters);
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
        return CORE.teams().create(projectName, teamName);
    }

    /***
     * Delete a team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteTeam(String projectName, String teamName) throws AzDException {
        return CORE.teams().delete(projectName, teamName);
    }

    /***
     * Get a specific team.
     * @param projectName pass the project name or id
     * @param teamName pass the team name
     * @throws AzDException Default Api Exception handler.
     * @return team object
     */
    @Override
    public WebApiTeam getTeam(String projectName, String teamName) throws AzDException {
        return CORE.teams().get(projectName, teamName);
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
    public WebApiTeam getTeam(String projectName, String teamName, boolean expandIdentity) throws AzDException {
        return CORE.teams().get(projectName, teamName, expandIdentity);
    }

    /***
     * Get a list of all teams.
     * @throws AzDException Default Api Exception handler.
     * @return array of team
     */
    @Override
    public WebApiTeams getTeams() throws AzDException {
        return CORE.teams().list();
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
    public WebApiTeams getTeams(boolean expandIdentity, boolean mine, int skip, int top) throws AzDException {
        return CORE.teams().list(r -> {
            r.queryParameters.top = top;
            r.queryParameters.skip = skip;
            r.queryParameters.mine = mine;
            r.queryParameters.expandIdentity = expandIdentity;
        });
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
    public WebApiTeam updateTeams(String projectName, String teamName, String description) throws AzDException {
        var team = new WebApiTeam();
        team.setName(teamName);
        team.setDescription(description);
        return CORE.teams().update(projectName, teamName, team);
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
        return CORE.projects().featureManagement().get(projectId, feature);
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
        return CORE.projects().featureManagement().toggle(projectId, feature, state);
    }
}
