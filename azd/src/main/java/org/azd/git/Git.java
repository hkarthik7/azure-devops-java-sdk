package org.azd.git;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.exceptions.DefaultParametersException;
import org.azd.git.types.PullRequest;
import org.azd.git.types.Repositories;
import org.azd.git.types.Repository;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.Request;
import org.azd.utils.RequestMethod;
import org.azd.utils.ResourceId;

import java.io.IOException;
import java.util.*;

import static org.azd.validators.AzDDefaultParametersValidator.validateDefaultParameters;

/***
 * GIT class to manage git API
 * @author Harish karthic
 */
public class Git {

    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final ObjectMapper MAPPER = new ObjectMapper();
    private final String AREA = "git";

    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public Git(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    /***
     * Create a git repository in a team project.
     * @param repositoryName Name of the repository
     * @param projectId id of the project
     * @return git repository object
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public Repository createRepository(String repositoryName, String projectId) throws DefaultParametersException, IOException {

        LinkedHashMap<String, Object> h = new LinkedHashMap<>(){{
            put("name", repositoryName);
            put("project", new LinkedHashMap<String, String>(){{
                put("id", projectId);
            }});
        }};

        String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.GIT, projectId,
                        AREA, null, "repositories", GitVersion.VERSION, null, h);

        return MAPPER.readValue(r, Repository.class);
    }

    /***
     * Delete a git repository
     * @param repositoryId pass the repository id
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public void deleteRepository(String repositoryId) throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/repositories", repositoryId, null, GitVersion.VERSION, null, null);
    }

    /***
     * Destroy (hard delete) a soft-deleted Git repository.
     * @param repositoryId pass the repository id
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public void deleteRepositoryFromRecycleBin(String repositoryId) throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        Request.request(RequestMethod.DELETE, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/recycleBin/repositories", repositoryId, null, GitVersion.VERSION, null, null);
    }

    /***
     * Retrieve deleted git repositories.
     * @return Git deleted repository object
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public Map getDeletedRepositories() throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA, null, "deletedrepositories", GitVersion.VERSION, null, null);

        return MAPPER.readValue(r, Map.class);
    }

    /***
     * Retrieve soft-deleted git repositories from the recycle bin.
     * @return array of git deleted recycle bin repositories
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public Map getRecycleBinRepositories() throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA, null, "recycleBin/repositories", GitVersion.VERSION, null, null);

        return MAPPER.readValue(r, Map.class);
    }

    /***
     * Retrieve a git repository.
     * @param repositoryName pass the repository name
     * @return git repository object
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public Repository getRepository(String repositoryName) throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/repositories", repositoryName, null, GitVersion.VERSION, null, null);

        return MAPPER.readValue(r, Repository.class);
    }

    /***
     * Retrieve git repositories.
     * @return array of git repositories
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public Repositories getRepositories() throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        String r = Request.request(RequestMethod.GET, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA, null, "repositories", GitVersion.VERSION, null, null);

        return MAPPER.readValue(r, Repositories.class);
    }

    /***
     * Recover a soft-deleted Git repository.
     * Recently deleted repositories go into a soft-delete state for a period of time before they are hard deleted and become unrecoverable.
     * @param repositoryId pass the repository id
     * @param deleted Setting to false will undo earlier deletion and restore the repository.
     * @return object of git repository
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public Repository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        HashMap<String, Object> h = new HashMap<>(){{
            put("deleted", deleted);
        }};

        String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/recycleBin/repositories", repositoryId, null, GitVersion.VERSION, null, h);

        return MAPPER.readValue(r, Repository.class);
    }

    /***
     * Updates the Git repository with either a new repo name or a new default branch.
     * @param repositoryId provide the repository id
     * @param repositoryName pass the repository name to rename
     * @param defaultBranchName pass the default branch name to set
     * @return repository object
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public Repository updateRepository(String repositoryId, String repositoryName, String defaultBranchName) throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }

        HashMap<String, Object> h = new HashMap<>(){{
            put("name", repositoryName);
            put("defaultBranch", "refs/heads/" + defaultBranchName);
        }};

        String r = Request.request(RequestMethod.PATCH, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                        AREA + "/repositories", repositoryId, null, GitVersion.VERSION, null, h);

        return MAPPER.readValue(r, Repository.class);
    }

    /***
     * Create a pull request.
     * @param repositoryId The repository ID of the pull request's target branch.
     * @param sourceRefName The name of the source branch of the pull request.
     * @param targetRefName The name of the target branch of the pull request.
     * @param title The title of the pull request.
     * @param description The description of the pull request.
     * @param reviewers A list of reviewers on the pull request along with the state of their votes.
     * @return an object of git pull request
     * @throws DefaultParametersException -> {@link DefaultParametersException}
     * @throws IOException -> {@link IOException}
     */
    public PullRequest createPullRequest(
            String repositoryId, String sourceRefName, String targetRefName,
            String title, String description, String[] reviewers ) throws DefaultParametersException, IOException {

        if(DEFAULT_PARAMETERS.getProject() == null) { validateDefaultParameters(); }
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

        String r = Request.request(RequestMethod.POST, DEFAULT_PARAMETERS, ResourceId.GIT, DEFAULT_PARAMETERS.getProject(),
                AREA + "/repositories", repositoryId, "pullrequests", GitVersion.VERSION, null, h);

        return MAPPER.readValue(r, PullRequest.class);
    }
}
