package org.azd.git;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.git.types.PullRequest;
import org.azd.git.types.PullRequests;
import org.azd.git.types.Repositories;
import org.azd.git.types.Repository;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.GitDetails;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Client;
import org.azd.enums.RequestMethod;
import org.azd.utils.ResourceId;

import java.util.*;

import static org.azd.utils.Client.request;

/***
 * GIT class to manage git API
 * @author Harish karthic
 */
public class GitApi implements GitDetails {

    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "git";

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public GitApi(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    /***
     * Create a git repository in a team project.
     * @param repositoryName Name of the repository
     * @param projectId id of the project
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return git repository object
     */
    @Override
    public Repository createRepository(String repositoryName, String projectId) throws DefaultParametersException, AzDException {

        LinkedHashMap<String, Object> h = new LinkedHashMap<>(){{
            put("name", repositoryName);
            put("project", new LinkedHashMap<String, String>(){{
                put("id", projectId);
            }});
        }};
        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.GIT, projectId,
                        AREA, null, "repositories", GitVersion.VERSION, null, h);
        return MAPPER.mapJsonResponse(r, Repository.class);
    }

    /***
     * Delete a git repository
     * @param repositoryId pass the repository id
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     */
    @Override
    public void deleteRepository(String repositoryId) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/repositories", repositoryId, null, GitVersion.VERSION, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Destroy (hard delete) a soft-deleted Git repository.
     * @param repositoryId pass the repository id
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     */
    @Override
    public void deleteRepositoryFromRecycleBin(String repositoryId) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                    AREA + "/recycleBin/repositories", repositoryId, null, GitVersion.VERSION, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Retrieve deleted git repositories.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return Git deleted repository object
     */
    @Override
    public Map getDeletedRepositories() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA, null, "deletedrepositories", GitVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Retrieve soft-deleted git repositories from the recycle bin.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return array of git deleted recycle bin repositories
     */
    @Override
    public Map getRecycleBinRepositories() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA, null, "recycleBin/repositories", GitVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Map.class);
    }

    /***
     * Retrieve a git repository.
     * @param repositoryName pass the repository name
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return git repository object
     */
    @Override
    public Repository getRepository(String repositoryName) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/repositories", repositoryName, null, GitVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Repository.class);
    }

    /***
     * Retrieve git repositories.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return array of git repositories
     */
    @Override
    public Repositories getRepositories() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA, null, "repositories", GitVersion.VERSION, null, null);

        return MAPPER.mapJsonResponse(r, Repositories.class);
    }

    /***
     * Recover a soft-deleted Git repository.
     * Recently deleted repositories go into a soft-delete state for a period of time before they are hard deleted and become unrecoverable.
     * @param repositoryId pass the repository id
     * @param deleted Setting to false will undo earlier deletion and restore the repository.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return object of git repository
     */
    @Override
    public Repository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws DefaultParametersException, AzDException {

        HashMap<String, Object> h = new HashMap<>(){{
            put("deleted", deleted);
        }};

        String r = request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/recycleBin/repositories", repositoryId, null, GitVersion.VERSION, null, h);

        return MAPPER.mapJsonResponse(r, Repository.class);
    }

    /***
     * Updates the Git repository with either a new repo name or a new default branch.
     * @param repositoryId provide the repository id
     * @param repositoryName pass the repository name to rename
     * @param defaultBranchName pass the default branch name to set
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return repository object
     */
    @Override
    public Repository updateRepository(String repositoryId, String repositoryName, String defaultBranchName) throws DefaultParametersException, AzDException {

        HashMap<String, Object> h = new HashMap<>(){{
            put("name", repositoryName);
            put("defaultBranch", "refs/heads/" + defaultBranchName);
        }};

        String r = request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/repositories", repositoryId, null, GitVersion.VERSION, null, h);

        return MAPPER.mapJsonResponse(r, Repository.class);
    }

    /***
     * Create a pull request.
     * @param repositoryId The repository ID of the pull request's target branch.
     * @param sourceRefName The name of the source branch of the pull request.
     * @param targetRefName The name of the target branch of the pull request.
     * @param title The title of the pull request.
     * @param description The description of the pull request.
     * @param reviewers A list of reviewers on the pull request along with the state of their votes.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return an object of git pull request
     */
    @Override
    public PullRequest createPullRequest(
            String repositoryId, String sourceRefName, String targetRefName,
            String title, String description, String[] reviewers) throws DefaultParametersException, AzDException {

            List<Object> o = new ArrayList<>();

        for (String reviewer : reviewers) {
            HashMap<String, String> id = new HashMap<>(){{ put("id", reviewer); }};
            o.add(id);
        }

        HashMap<String, Object> h = new HashMap<>(){{
            put("sourceRefName", sourceRefName);
            put("targetRefName", targetRefName);
            put("title", title);
            put("description", description);
            put("reviewers", o);
        }};

        String r = request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/repositories", repositoryId, "pullrequests", GitVersion.VERSION, null, h);

        return MAPPER.mapJsonResponse(r, PullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequest getPullRequest(String repositoryName, int pullRequestId) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/repositories", repositoryName, "pullrequests/" + pullRequestId, GitVersion.VERSION, null,null);

        return MAPPER.mapJsonResponse(r, PullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequest getPullRequestById(int pullRequestId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/pullrequests", Integer.toString(pullRequestId), null, GitVersion.VERSION, null,null);


        return MAPPER.mapJsonResponse(r, PullRequest.class);
    }

    /***
     * Retrieve all pull requests from a repository
     * @param repositoryName specify the repository name
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequests getPullRequests(String repositoryName) throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/repositories", repositoryName, "pullrequests", GitVersion.VERSION, null,null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from non-default project you have to call setProject
     * method from {@link AzDDefaultParameters}.
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequests getPullRequestsByProject() throws DefaultParametersException, AzDException {

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA, null, "pullrequests", GitVersion.VERSION, null,null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

}
