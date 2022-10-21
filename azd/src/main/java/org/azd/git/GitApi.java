package org.azd.git;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.git.types.*;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.GitDetails;
import org.azd.utils.AzDAsyncApi;

import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.azd.utils.RestClient.send;

/***
 * GIT class to manage git API
 */
public class GitApi extends AzDAsyncApi<GitApi> implements GitDetails {

    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "git";
    private final String GIT = "4e080c62-fa21-4fbc-8fef-2a10a2b38049";

    /***
     * Pass the connection object to work with Git Api
     * @param connection Connection object
     */
    public GitApi(Connection connection) {
        CONNECTION = connection;
    }

    /***
     * Create a git repository in a team project.
     * @param repositoryName Name of the repository
     * @param projectId id of the project
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link GitRepository}
     */
    @Override
    public GitRepository createRepository(String repositoryName, String projectId) throws AzDException {
        LinkedHashMap<String, Object> h = new LinkedHashMap<>() {{
            put("name", repositoryName);
            put("project", new LinkedHashMap<String, String>() {{
                put("id", projectId);
            }});
        }};
        String r = send(RequestMethod.POST, CONNECTION, GIT, projectId, AREA, null, "repositories", ApiVersion.GIT,
                null, h, CustomHeader.JSON_CONTENT_TYPE);
        return MAPPER.mapJsonResponse(r, GitRepository.class);
    }

    /***
     * Delete a git repository
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteRepository(String repositoryId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                    repositoryId, null, ApiVersion.GIT, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Destroy (hard delete) a soft-deleted Git repository.
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteRepositoryFromRecycleBin(String repositoryId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, GIT, CONNECTION.getProject(),
                    AREA + "/recycleBin/repositories", repositoryId, null, ApiVersion.GIT, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Retrieve deleted git repositories.
     * @throws AzDException Default Api Exception handler.
     * @return Git deleted repository object
     */
    @Override
    public GitDeletedRepositories getDeletedRepositories() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA, null, "deletedrepositories",
                ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitDeletedRepositories.class);
    }

    /***
     * Retrieve soft-deleted git repositories from the recycle bin.
     * @throws AzDException Default Api Exception handler.
     * @return array of git deleted recycle bin repositories
     */
    @Override
    public GitDeletedRepositories getRecycleBinRepositories() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA, null,
                "recycleBin/repositories", ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitDeletedRepositories.class);
    }

    /***
     * Retrieve a git repository.
     * @param repositoryName pass the repository name
     * @throws AzDException Default Api Exception handler.
     * @return git repository object
     */
    @Override
    public GitRepository getRepository(String repositoryName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, null, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitRepository.class);
    }

    /***
     * Retrieve git repositories.
     * @throws AzDException Default Api Exception handler.
     * @return array of git repositories
     */
    @Override
    public Repositories getRepositories() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA, null, "repositories",
                ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, Repositories.class);
    }

    /***
     * Recover a soft-deleted Git repository. Recently deleted repositories go
     * into a soft-delete state for a period of time before they are hard
     * deleted and become unrecoverable.
     * @param repositoryId pass the repository id
     * @param deleted Setting to false will undo earlier deletion and restore the repository.
     * @throws AzDException Default Api Exception handler.
     * @return object of git repository {@link GitRepository}
     */
    @Override
    public GitRepository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws AzDException {
        HashMap<String, Object> h = new HashMap<>() {{
            put("deleted", deleted);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/recycleBin/repositories", repositoryId, null, ApiVersion.GIT, null, h, null);

        return MAPPER.mapJsonResponse(r, GitRepository.class);
    }

    /***
     * Updates the Git repository with either a new repo name or a new default branch.
     * @param repositoryId provide the repository id
     * @param repositoryName pass the repository name to rename
     * @param defaultBranchName pass the default branch name to set
     * @throws AzDException Default Api Exception handler.
     * @return repository object
     */
    @Override
    public GitRepository updateRepository(String repositoryId, String repositoryName, String defaultBranchName)
            throws AzDException {
        HashMap<String, Object> h = new HashMap<>() {{
            put("name", repositoryName);
            put("defaultBranch", "refs/heads/" + defaultBranchName);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, null, ApiVersion.GIT, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitRepository.class);
    }

    /***
     * Create a pull request.
     * @param repositoryId The repository ID of the pull request's target branch.
     * @param sourceRefName The name of the source branch of the pull request.
     * @param targetRefName The name of the target branch of the pull request.
     * @param title The title of the pull request.
     * @param description The description of the pull request.
     * @param reviewers A list of reviewers on the pull request along with the state of their votes.
     * @throws AzDException Default Api Exception handler.
     * @return an object of git pull request {@link GitPullRequest}
     */
    @Override
    public GitPullRequest createPullRequest(String repositoryId, String sourceRefName, String targetRefName, String title,
                                         String description, String[] reviewers) throws AzDException {
        List<Object> o = new ArrayList<>();

        for (String reviewer : reviewers) {
            HashMap<String, String> id = new HashMap<>() {{
                put("id", reviewer);
            }};
            o.add(id);
        }

        HashMap<String, Object> h = new HashMap<>() {{
            put("sourceRefName", sourceRefName);
            put("targetRefName", targetRefName);
            put("title", title);
            put("description", description);
            put("reviewers", o);
        }};

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "pullrequests", ApiVersion.GIT, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitPullRequest.class);
    }

    /***
     * Create a pull request and optionally make it a draft. You can specify
     * only the source branch name such as develop and target branch name such
     * as master.
     * @param repositoryId The repository ID of the pull request's target branch.
     * @param sourceRefName The name of the source branch of the pull request.
     * @param targetRefName The name of the target branch of the pull request.
     * @param title The title of the pull request.
     * @param description The description of the pull request.
     * @param isDraft if set to true the pull request will be in draft mode.
     * @return an object of git pull request {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitPullRequest createPullRequest(String repositoryId, String sourceRefName, String targetRefName, String title,
                                         String description, boolean isDraft) throws AzDException {
        String referenceHead = "refs/heads/";
        var sourceBranch = sourceRefName.contains(referenceHead) ? sourceRefName : referenceHead + sourceRefName;
        var targetBranch = targetRefName.contains(referenceHead) ? targetRefName : referenceHead + targetRefName;

        var b = new HashMap<String, Object>() {{
            put("sourceRefName", sourceBranch);
            put("targetRefName", targetBranch);
            put("title", title);
            put("description", description);
            put("isDraft", isDraft);
        }};

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "pullrequests", ApiVersion.GIT, null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitPullRequest.class);
    }

    /**
     * Create a pull request.
     * @param gitPullRequest a {@link GitPullRequest} object.
     * @return an object of git pull request {@link GitPullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitPullRequest createPullRequest(GitPullRequest gitPullRequest) throws AzDException {
        if (gitPullRequest == null) throw new AzDException("Request body cannot be null or empty");

        if (!gitPullRequest.getSourceRefName().isEmpty() && !gitPullRequest.getTargetRefName().isEmpty()) {
            String referenceHead = "refs/heads/";
            if (!gitPullRequest.getSourceRefName().contains(referenceHead))
                gitPullRequest.setSourceRefName(referenceHead + gitPullRequest.getSourceRefName());
            if (!gitPullRequest.getTargetRefName().contains(referenceHead))
                gitPullRequest.setTargetRefName(referenceHead + gitPullRequest.getTargetRefName());
        }

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                gitPullRequest.getRepository().getId(), "pullrequests", ApiVersion.GIT, null, gitPullRequest, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    @Override
    public GitPullRequest getPullRequest(String repositoryName, int pullRequestId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "pullrequests/" + pullRequestId, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitPullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link GitPullRequest} object
     */
    @Override
    public GitPullRequest getPullRequestById(int pullRequestId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/pullrequests",
                Integer.toString(pullRequestId), null, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitPullRequest.class);
    }

    /***
     * Retrieve all pull requests from a repository
     * @param repositoryName specify the repository name
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    @Override
    public PullRequests getPullRequests(String repositoryName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "pullrequests", ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from
     * non-default project you have to call setProject method from {@link Connection}.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequests} object
     */
    @Override
    public PullRequests getPullRequestsByProject() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA, null, "pullrequests",
                ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from
     * non-default project you have to call setProject method from {@link Connection}.
     *
     * @param top The number of pull requests to retrieve.
     * @return {@link PullRequests} PullRequest
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequests getPullRequestsByProject(int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA, null, "pullrequests",
                ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from
     * non-default project you have to call setProject method from {@link Connection}.
     *
     * @param status If set, search for pull requests that are in this state. Defaults to Active if unset.
     * @return {@link PullRequests} PullRequest
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequests getPullRequestsByProject(PullRequestStatus status) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("searchCriteria.status", status.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA, null, "pullrequests",
                ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from
     * non-default project you have to call setProject method from {@link Connection}.
     * @param skip The number of pull requests to ignore. For example, to
     * retrieve results 101-150, set top to 50 and skip to 100.
     * @param top The number of pull requests to retrieve.
     * @param creatorId If set, search for pull requests that were created by this identity.
     * @param includeLinks Whether to include the _links field on the shallow references
     * @param repositoryId If set, search for pull requests whose target branch is in this repository.
     * @param reviewerId If set, search for pull requests that have this identity as a reviewer.
     * @param sourceRefName If set, search for pull requests from this branch.
     * @param sourceRepositoryId If set, search for pull requests whose source branch is in this repository.
     * @param status If set, search for pull requests that are in this state. Defaults to Active if unset.
     * @param targetRefName If set, search for pull requests into this branch.
     * @return {@link PullRequests} PullRequest
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequests getPullRequestsByProject(int skip, int top, String creatorId, boolean includeLinks,
                                                 String repositoryId, String reviewerId, String sourceRefName, String sourceRepositoryId,
                                                 PullRequestStatus status, String targetRefName) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$skip", skip);
            put("$top", top);
            put("searchCriteria.creatorId", creatorId);
            put("searchCriteria.includeLinks", includeLinks);
            put("searchCriteria.repositoryId", repositoryId);
            put("searchCriteria.reviewerId", reviewerId);
            put("searchCriteria.sourceRefName", sourceRefName);
            put("searchCriteria.sourceRepositoryId", sourceRepositoryId);
            put("searchCriteria.status", status.toString().toLowerCase());
            put("searchCriteria.targetRefName", targetRefName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA, null, "pullrequests",
                ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Get a specific branch from a repository.
     * @param repositoryName The name of the repository.
     * @param branchName The name of the branch.
     * @return The branch as a {@link GitRef} object.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRef getBranch(String repositoryName, String branchName) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("filter", "heads/" + branchName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "refs", ApiVersion.GIT, q, null, null);

        List<GitRef> gitRefs = MAPPER.mapJsonResponse(r, GitRefs.class).getRefs();

        return gitRefs != null && !gitRefs.isEmpty() ? gitRefs.get(0) : null;
    }

    /***
     * Get the branches from a repository.
     * @param repositoryName The name of the repository.
     * @return The {@link GitRefs} with the branches.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRefs getBranches(String repositoryName) throws AzDException {
        // Query only for refs/heads branches.
        var q = new HashMap<String, Object>() {{
            put("filter", "heads");
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "refs", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitRefs.class);
    }

    /***
     * Lock or Unlock a branch with repository name and branch name.
     * @param repositoryName The name or ID of the repository.
     * @param branchName The name of the branch to lock/unlock
     * @param isLocked true to lock the branch and false to unlock.
     * @return GitRef {@link GitRef}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRef updateBranchLock(String repositoryName, String branchName, boolean isLocked) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("filter", "heads/" + branchName);
        }};

        var b = new HashMap<String, Object>() {{
            put("isLocked", isLocked);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "refs", ApiVersion.GIT, q, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitRef.class);
    }

    /***
     * Retrieve a list of work items associated with a pull request.
     * @param pullRequestId ID of the pull request.
     * @param repositoryName ID or name of the repository.
     * @return ResourceRefs {@link ResourceRefs}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ResourceRefs getPullRequestWorkItems(int pullRequestId, String repositoryName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "pullRequests/" + pullRequestId + "/workitems", ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, ResourceRefs.class);
    }

    /***
     * Create a label for a specified pull request. The only required field is
     * the name of the new label.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WebApiTagDefinition createPullRequestLabel(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("name", labelName);
        }};

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "pullrequests/" + pullRequestId + "/labels", ApiVersion.GIT, null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, WebApiTagDefinition.class);
    }

    /***
     * Removes a label from the set of those assigned to the pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deletePullRequestLabel(String repositoryName, int pullRequestId, String labelName) throws AzDException {
        try {
            String resource = "pullrequests/" + pullRequestId + "/labels/" + labelName;
            String r = send(RequestMethod.DELETE, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                    repositoryName, resource, ApiVersion.GIT, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Retrieves a single label that has been assigned to a pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @param labelName tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WebApiTagDefinition getPullRequestLabel(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        String resource = "pullrequests/" + pullRequestId + "/labels/" + labelName;
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, resource, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, WebApiTagDefinition.class);
    }

    /***
     * Get all the labels assigned to a pull request.
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId ID of the pull request.
     * @return List of WebApi tag object {@link WebApiTagDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public WebApiTagDefinitions getPullRequestLabels(String repositoryName, int pullRequestId) throws AzDException {
        String resource = "pullrequests/" + pullRequestId + "/labels";
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, resource, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, WebApiTagDefinitions.class);
    }

    /***
     * Add a reviewer to a pull request or cast a vote.
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @param vote Vote on a pull request: 10 - approved 5 - approved with
     * suggestions 0 - no vote -5 - waiting for author -10 - rejected
     * @param isRequired Indicates if this is a required reviewer for this pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public IdentityRefWithVote createPullRequestReviewer(int pullRequestId, String repositoryName, String reviewerId,
                                                         int vote, boolean isRequired) throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("vote", vote);
            put("id", reviewerId);
        }};

        String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

        String r = send(RequestMethod.PUT, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories", id, null,
                ApiVersion.GIT, null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, IdentityRefWithVote.class);
    }

    /***
     * Remove a reviewer from a pull request.
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deletePullRequestReviewer(int pullRequestId, String repositoryName, String reviewerId)
            throws AzDException {
        try {
            String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

            String r = send(RequestMethod.DELETE, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories", id,
                    null, ApiVersion.GIT, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Retrieve information about a particular reviewer on a pull request
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public IdentityRefWithVote getPullRequestReviewer(int pullRequestId, String repositoryName, String reviewerId)
            throws AzDException {
        String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories", id, null,
                ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, IdentityRefWithVote.class);
    }

    /***
     * Retrieve the reviewers for a pull request
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @return List of PullRequestReviewer {@link PullRequestReviewers}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequestReviewers getPullRequestReviewers(int pullRequestId, String repositoryName) throws AzDException {
        String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers";

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories", id, null,
                ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, PullRequestReviewers.class);
    }

    /***
     * Edit a reviewer entry. These fields are patchable: isFlagged, hasDeclined
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @param isFlagged Indicates if this reviewer is flagged for attention on this pull request.
     * @param hasDeclined Indicates if this reviewer has declined to review this pull request.
     * @return PullRequestReviewer {@link IdentityRefWithVote}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public IdentityRefWithVote updatePullRequestReviewer(int pullRequestId, String repositoryName, String reviewerId,
                                                         boolean isFlagged, boolean hasDeclined) throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("isFlagged", isFlagged);
            put("hasDeclined", hasDeclined);
        }};

        String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories", id, null,
                ApiVersion.GIT, null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, IdentityRefWithVote.class);
    }

    /**
     * Create an annotated tag.
     *
     * @param repositoryName Name of the repository.
     * @param tagName        The name of the annotated tag.
     * @param objectId       The objectId (Sha1Id) of the tag.
     * @param message        The tagging Message.
     * @return A Git annotated tag object {@link GitAnnotatedTag}.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitAnnotatedTag createAnnotatedTag(String repositoryName, String tagName, String objectId, String message)
            throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("name", tagName);
            put("taggedObject", new HashMap<String, String>() {{
                put("objectId", objectId);
            }});
            put("message", message);
        }};

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "annotatedtags", ApiVersion.GIT, null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitAnnotatedTag.class);
    }

    /**
     * Get an annotated tag.
     *
     * @param repositoryName Name of the repository.
     * @param objectId       ObjectId (Sha1Id) of tag to get.
     * @return A Git annotated tag object {@link GitAnnotatedTag}.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitAnnotatedTag getAnnotatedTag(String repositoryName, String objectId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "annotatedtags/" + objectId, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitAnnotatedTag.class);
    }

    /**
     * Retrieve a particular commit.
     *
     * @param repositoryName Name of the repository.
     * @param commitId       The id of the commit.
     * @return Git commit object {@link GitCommit}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommit getCommit(String repositoryName, String commitId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits/" + commitId, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitCommit.class);
    }

    /**
     * Retrieve a particular commit.
     *
     * @param repositoryName Name of the repository.
     * @param commitId       The id of the commit.
     * @param changeCount    The number of changes to include in the result.
     * @return Git commit object {@link GitCommit}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommit getCommit(String repositoryName, String commitId, int changeCount) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("changeCount", changeCount);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits/" + commitId, ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitCommit.class);
    }

    /**
     * Retrieve changes for a particular commit.
     *
     * @param repositoryName Name of the repository.
     * @param commitId       The id of the commit.
     * @return Git commit changes object {@link GitCommitChanges}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommitChanges getChanges(String repositoryName, String commitId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits/" + commitId + "/changes", ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitCommitChanges.class);
    }

    /**
     * Retrieve changes for a particular commit.
     *
     * @param repositoryName Name of the repository.
     * @param commitId       The id of the commit.
     * @param top            The maximum number of changes to return.
     * @param skip           The number of changes to skip.
     * @return Git commit changes object {@link GitCommitChanges}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommitChanges getChanges(String repositoryName, String commitId, int top, int skip) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("top", top);
            put("skip", skip);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits/" + commitId + "/changes", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitCommitChanges.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryName Name of the repository.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getCommits(String repositoryName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits", ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryName Name of the repository.
     * @param top            Maximum number of entries to retrieve
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getCommits(String repositoryName, int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryName Name of the repository.
     * @param ids            If provided, specifies the exact commit ids of the commits to
     *                       fetch. May not be combined with other parameters.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getCommits(String repositoryName, List<String> ids) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("ids", String.join(",", ids));
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryName         Name of the repository.
     * @param top                    Maximum number of entries to retrieve.
     * @param skip                   Number of entries to skip.
     * @param author                 Alias or display name of the author.
     * @param version                Version string identifier (name of tag/branch, SHA1 of
     *                               commit).
     * @param versionOptions         Version options - Specify additional modifiers to version (e.g
     *                               Previous).
     * @param versionType            Version type (branch, tag, or commit). Determines how Id is
     *                               interpreted.
     * @param excludeDeletes         Only applies when an itemPath is specified. This determines
     *                               whether to exclude delete entries of the specified path.
     * @param fromCommitId           If provided, a lower bound for filtering commits
     *                               alphabetically.
     * @param toCommitId             If provided, an upper bound for filtering commits
     *                               alphabetically
     * @param fromDate               If provided, only include history entries created after this
     *                               date (string).
     * @param toDate                 If provided, only include history entries created before this
     *                               date (string)
     * @param historyMode            What Git history mode should be used. This only applies to the
     *                               search criteria when Ids = null and an itemPath is specified.
     * @param ids                    If provided, specifies the exact commit ids of the commits to
     *                               fetch. May not be combined with other parameters.
     * @param includeLinks           Whether to include the _links field on the shallow references
     * @param includePushData        Whether to include the push information
     * @param includeUserImageUrl    Whether to include the image Url for committers and authors
     * @param includeWorkItems       Whether to include linked work items
     * @param itemPath               Path of item to search under
     * @param showOldestCommitsFirst If enabled, this option will ignore the itemVersion and
     *                               compareVersion parameters.
     * @param user                   Alias or display name of the committer
     * @param itemVersion            Version string identifier (name of tag/branch, SHA1 of commit)
     * @param itemVersionOptions     Version options - Specify additional modifiers to version (e.g
     *                               Previous)
     * @param itemVersionType        Version type (branch, tag, or commit). Determines how Id is
     *                               interpreted
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getCommits(String repositoryName, int top, int skip, String author, String version,
                                 GitVersionOptions versionOptions, GitVersionType versionType, boolean excludeDeletes, String fromCommitId,
                                 String toCommitId, String fromDate, String toDate, GitHistoryMode historyMode, List<String> ids,
                                 boolean includeLinks, boolean includePushData, boolean includeUserImageUrl, boolean includeWorkItems,
                                 String itemPath, boolean showOldestCommitsFirst, String user, String itemVersion,
                                 GitVersionOptions itemVersionOptions, GitVersionType itemVersionType) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
            put("$skip", skip);
            put("author", author);
            put("compareVersion.version", version);
            put("compareVersion.versionOptions", versionOptions.toString().toLowerCase());
            put("compareVersion.versionType", versionType.toString().toLowerCase());
            put("excludeDeletes", excludeDeletes);
            put("fromCommitId", fromCommitId);
            put("fromDate", fromDate);
            put("historyMode", historyMode.toString().toLowerCase());
            put("ids", String.join(",", ids));
            put("includeLinks", includeLinks);
            put("includePushData", includePushData);
            put("includeUserImageUrl", includeUserImageUrl);
            put("itemPath", itemPath);
            put("itemVersion.version", itemVersion);
            put("itemVersion.versionOptions", itemVersionOptions.toString().toLowerCase());
            put("itemVersion.versionType", itemVersionType.toString().toLowerCase());
            put("showOldestCommitsFirst", showOldestCommitsFirst);
            put("toCommitId", toCommitId);
            put("toDate", toDate);
            put("user", user);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve a list of commits associated with a particular push.
     *
     * @param repositoryName Name of the repository.
     * @param pushId         The id of the push.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getPushCommits(String repositoryName, int pushId) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("pushId", pushId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve a list of commits associated with a particular push.
     *
     * @param repositoryName Name of the repository.
     * @param pushId         The id of the push.
     * @param includeLinks   Set to false to avoid including REST Url links for resources.
     *                       Defaults to true.
     * @param top            The maximum number of commits to return ("get the top x
     *                       commits").
     * @param skip           The number of commits to skip.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getPushCommits(String repositoryName, int pushId, boolean includeLinks, int top, int skip)
            throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("pushId", pushId);
            put("top", top);
            put("skip", skip);
            put("includeLinks", includeLinks);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "commits", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }


    /**
     * Queries the provided repository for its refs and returns them.
     *
     * @param repositoryName Name of the repository.
     * @return Array Git ref object {@link GitRefs}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRefs getRefs(String repositoryName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
            AREA + "/repositories", repositoryName, "refs", ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitRefs.class);
    }

    /**
     * Queries the provided repository for its refs and returns them.
     *
     * @param repositoryName Name of the repository.
     * @param filter         A filter to apply to the refs (starts with).
     * @return Array Git ref object {@link GitRefs}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRefs getRefs(String repositoryName, String filter) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("filter", filter);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
            AREA + "/repositories", repositoryName, "refs", ApiVersion.GIT, q, null, null);
            
        return MAPPER.mapJsonResponse(r, GitRefs.class);
    }

    /**
     * Creating, updating, or deleting git ref.
     *
     * @param repositoryName Name of the repository.
     * @param refName        The ref to create, update, or delete.
     * @param oldObjectId    The old object id of the ref.(SHA)
     * @param newObjectId    The new object id of the ref.(SHA)
     * @return Array Git update result object {@link GitRefUpdateResults}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRefUpdateResult updateRef(String repositoryName, String refName, String oldObjectId, String newObjectId) throws AzDException {
        var b = new ArrayList<Map>();
        var h = new HashMap<String, Object>(){{
            put("name", refName);
            put("oldObjectId", oldObjectId);
            put("newObjectId", newObjectId);
        }}; 

        b.add(h);

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(),
            AREA + "/repositories", repositoryName, "refs", ApiVersion.GIT, null, b, CustomHeader.JSON_CONTENT_TYPE);    
            
        return MAPPER.mapJsonResponse(r, GitRefUpdateResults.class).getGitRefUpdateResults().get(0);
    }

    /**
     * Creates a new tag in the repository that points to the supplied ref.
     *
     * @param repositoryName Name of the repository.
     * @param tagName        The name of the tag.
     * @param ref            Create tag using commit SHA, another tag name, or branch name
     * @return Git update result object {@link GitRefUpdateResult}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRefUpdateResult createTag(String repositoryName, String tagName, String ref) throws AzDException {        
        if (ref.matches("^[a-fA-F0-9]{40}$")) {
            return updateRef(repositoryName, "refs/tags/"+tagName, "0000000000000000000000000000000000000000", ref);
        }

        String objectId; 
        GitRefs refs=getRefs(repositoryName, "tags/"+ref);
        if(!refs.getRefs().isEmpty()){
            objectId=refs.getRefs().get(0).getObjectId();
            return updateRef(repositoryName, "refs/tags/"+tagName, "0000000000000000000000000000000000000000", objectId);
        }

        refs=getRefs(repositoryName, "heads/"+ref);
        if(!refs.getRefs().isEmpty()){
            objectId=refs.getRefs().get(0).getObjectId();
            return updateRef(repositoryName, "refs/tags/"+tagName, "0000000000000000000000000000000000000000", objectId);
        }

        throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), MessageFormat.format("Could not find ref {0}", ref));        
    }

    /**
     * Deletes a tag of a repository with given name.
     *
     * @param repositoryName Name of the repository.
     * @param tagName        The name of the tag.
     * @return Array Git update result object {@link GitRefUpdateResults}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitRefUpdateResult deleteTag(String repositoryName, String tagName) throws AzDException {
        GitRefs refs=getRefs(repositoryName, "tags/"+tagName);
        if(refs.getRefs().isEmpty()){
            throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), MessageFormat.format(
                "Tag {0} does not exist in repository {1}", tagName, repositoryName));
        }
        String tagObjectId=refs.getRefs().get(0).getObjectId();

        return updateRef(repositoryName, "refs/tags/"+tagName, tagObjectId, "0000000000000000000000000000000000000000");
    }

    /**
     * Get a single blob.
     *
     * @param repositoryId The name or ID of the repository.
     * @param sha1 SHA1 hash of the file. You can get the SHA1 of a file using the "Git/Items/Get Item" endpoint.
     * @return GitBlobRef Object {@link GitBlobRef}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitBlobRef getBlob(String repositoryId, String sha1) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "blobs/" + sha1, ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitBlobRef.class);
    }

    /**
     * Get a single blob.
     *
     * @param repositoryId The name or ID of the repository.
     * @param sha1 SHA1 hash of the file. You can get the SHA1 of a file using the "Git/Items/Get Item" endpoint.
     * @param fileName Provide a fileName to use for a download.
     * @param resolveLfs If true, try to resolve a blob to its LFS contents, if it's an LFS pointer file. Only compatible with octet-stream Accept headers or $format types
     * @return GitBlobRef Object {@link GitBlobRef}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitBlobRef getBlob(String repositoryId, String sha1, String fileName, boolean resolveLfs) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("$format", GitBlobRefFormat.JSON.name());
            put("fileName", fileName);
            put("resolveLfs", resolveLfs);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "blobs/" + sha1, ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitBlobRef.class);
    }

    /**
     * Get a single blob content.
     *
     * @param repositoryId The name or ID of the repository.
     * @param sha1 SHA1 hash of the file. You can get the SHA1 of a file using the getItems() method.
     * @param download If true, download the text. You can use {@link org.azd.helpers.StreamHelper} to download the file.
     * @param fileName Provide a fileName to use for a download.
     * @param resolveLfs If true, try to resolve a blob to its LFS contents, if it's an LFS pointer file. Only compatible with octet-stream Accept headers or $format types
     * @return String contents of the file.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public String getBlobContent(String repositoryId, String sha1, boolean download, String fileName, boolean resolveLfs) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("$format", GitBlobRefFormat.TEXT.name());
            put("download", download);
            put("fileName", fileName);
            put("resolveLfs", resolveLfs);
        }};

        return send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "blobs/" + sha1, ApiVersion.GIT, q, null, null);
    }

    /**
     * Get a single blob as zip of input stream. Use {@link org.azd.helpers.StreamHelper} to download the file.
     *
     * @param repositoryId The name or ID of the repository.
     * @param sha1 SHA1 hash of the file. You can get the SHA1 of a file using the getItems() method.
     * @param download If true, download the text. You can use {@link org.azd.helpers.StreamHelper} to download the file.
     * @param fileName Provide a fileName to use for a download.
     * @param resolveLfs If true, try to resolve a blob to its LFS contents, if it's an LFS pointer file. Only compatible with octet-stream Accept headers or $format types
     * @return Input stream for zip download. This gets the stream of a single file.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public InputStream getBlobContentAsZip(String repositoryId, String sha1, boolean download, String fileName, boolean resolveLfs) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("$format", GitBlobRefFormat.ZIP.name());
            put("download", download);
            put("fileName", fileName);
            put("resolveLfs", resolveLfs);
        }};

        return send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "blobs/" + sha1, ApiVersion.GIT, q, null, null, false);
    }

    /**
     * Get a single blob content as input stream. Use {@link org.azd.helpers.StreamHelper} to download the file.
     *
     * @param repositoryId The name or ID of the repository.
     * @param sha1 SHA1 hash of the file. You can get the SHA1 of a file using the getItems() method.
     * @param download If true, download the text. You can use {@link org.azd.helpers.StreamHelper} to download the file.
     * @param fileName Provide a fileName to use for a download.
     * @param resolveLfs If true, try to resolve a blob to its LFS contents, if it's an LFS pointer file. Only compatible with octet-stream Accept headers or $format types
     * @return Input stream for zip download. This gets the stream of a single file.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public InputStream getBlobContentAsStream(String repositoryId, String sha1, boolean download, String fileName, boolean resolveLfs) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("$format", GitBlobRefFormat.OCTETSTREAM.name());
            put("download", download);
            put("fileName", fileName);
            put("resolveLfs", resolveLfs);
        }};

        return send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "blobs/" + sha1, ApiVersion.GIT, q, null, null, false);
    }

    /**
     * Gets one or more blobs in a zip file download.
     *
     * @param repositoryId The name or ID of the repository.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public InputStream getBlobsZip(String repositoryId, List<String> sha1) throws AzDException {
        return send(null, RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "blobs", ApiVersion.GIT, null,
                HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(sha1)),
                HttpResponse.BodyHandlers.ofInputStream(),
                Map.of("Stream_Zip", CustomHeader.STREAM_ZIP_ACCEPT, "Content_Type", CustomHeader.JSON_CONTENT_TYPE),
                false)
                .thenApplyAsync(HttpResponse::body)
                .join();
    }

    /**
     * Gets one or more blobs in a zip file download.
     *
     * @param repositoryId The name or ID of the repository.
     * @param fileName Name of the file.
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public InputStream getBlobsZip(String repositoryId, String fileName, List<String> sha1) throws AzDException {
        return send(null, RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryId, "blobs", ApiVersion.GIT, Map.of("filename", fileName),
                HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(sha1)),
                HttpResponse.BodyHandlers.ofInputStream(),
                Map.of("Stream_Zip", CustomHeader.STREAM_ZIP_ACCEPT, "Content_Type", CustomHeader.JSON_CONTENT_TYPE),
                false)
                .thenApplyAsync(HttpResponse::body)
                .join();
    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryName The name or ID of the repository.
     * @return GitItem Object {@link GitItem}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitItems getItems(String repositoryName) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "items", ApiVersion.GIT, null, null, null);

        return MAPPER.mapJsonResponse(r, GitItems.class);
    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryName The name or ID of the repository.
     * @param recursionType The recursion level of this request. The default is 'none', no recursion.
     * @return GitItem Object {@link GitItem}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitItems getItems(String repositoryName, VersionControlRecursionType recursionType) throws AzDException {
        var q = new HashMap<String, Object>(){{ put("recursionLevel", recursionType.name()); }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "items", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitItems.class);
    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryName The name or ID of the repository.
     * @param includeContentMetadata Set to true to include content metadata.  Default is false.
     * @param includeLinks Set to true to include links to items.  Default is false.
     * @param latestProcessedChange Set to true to include the latest changes.  Default is false.
     * @param recursionType The recursion level of this request. The default is 'none', no recursion.
     * @param scopePath The path scope.  The default is null.
     * @return GitItem Object {@link GitItem}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitItems getItems(String repositoryName, boolean includeContentMetadata, boolean includeLinks,
                             boolean latestProcessedChange, VersionControlRecursionType recursionType,
                             String scopePath) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("recursionLevel", recursionType.getValue());
            put("includeContentMetadata", includeContentMetadata);
            put("includeLinks", includeLinks);
            put("latestProcessedChange", latestProcessedChange);
        }};

        if (scopePath != null) q.put("scopePath", scopePath);

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "items", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitItems.class);
    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryName The name or ID of the repository.
     * @param includeContentMetadata Set to true to include content metadata.  Default is false.
     * @param includeLinks Set to true to include links to items.  Default is false.
     * @param latestProcessedChange Set to true to include the latest changes.  Default is false.
     * @param recursionType The recursion level of this request. The default is 'none', no recursion.
     * @param scopePath The path scope.  The default is null.
     * @param version Version string identifier (name of tag/branch, SHA1 of commit)
     * @param versionOptions Version options - Specify additional modifiers to version (e.g Previous)
     * @param versionType Version type (branch, tag, or commit). Determines how Id is interpreted
     * @return GitItem Object {@link GitItem}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitItems getItems(String repositoryName, boolean includeContentMetadata, boolean includeLinks,
                             boolean latestProcessedChange, VersionControlRecursionType recursionType,
                             String scopePath, String version, GitVersionOptions versionOptions,
                             GitVersionType versionType) throws AzDException {
        var q = new HashMap<String, Object>(){{
            put("recursionLevel", recursionType.getValue());
            put("includeContentMetadata", includeContentMetadata);
            put("includeLinks", includeLinks);
            put("latestProcessedChange", latestProcessedChange);
            put("versionOptions", versionOptions);
            put("versionType", versionType);
        }};

        if (scopePath != null) q.put("scopePath", scopePath);

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "items", ApiVersion.GIT, q, null, null);

        return MAPPER.mapJsonResponse(r, GitItems.class);
    }

    /**
     * Request that another repository's refs be fetched into this one. It syncs two existing forks.
     *
     * @param repositoryName The name or ID of the repository.
     * @param sourceCollectionId Team Project Collection ID of the collection for the repository.
     * @param sourceProjectId Team Project ID of the project for the repository.
     * @param sourceRepositoryId ID of the repository.
     * @param includeLinks Set to true to include links to items.  Default is false.
     * @return GitForkSyncRequest Object {@link GitForkSyncRequest}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitForkSyncRequest createForkSyncRequest(String repositoryName, String sourceCollectionId, String sourceProjectId,
                                                    String sourceRepositoryId, Boolean includeLinks) throws AzDException {

        var q = new HashMap<String, Object>() {{
            put("includeLinks", includeLinks);
        }};
        var b = new HashMap<String, Object>() {{
            put("source", new HashMap<String, String>() {{
                put("collectionId", sourceCollectionId);
                put("projectId", sourceProjectId);
                put("repositoryId", sourceRepositoryId);
            }});
        }};

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "forkSyncRequests", ApiVersion.GIT, null, b, CustomHeader.JSON_CONTENT_TYPE);
        
        return MAPPER.mapJsonResponse(r, GitForkSyncRequest.class);
    }


    /**
     * Request that another repository's refs be fetched into this one. It syncs two existing forks.
     *
     * @param repositoryName The name or ID of the repository.
     * @param collectionId Team Project Collection ID of the collection for the repository.
     * @param projectId Team Project ID of the project for the repository.
     * @param repositoryId ID of the repository.
     * @param sourceRef The source ref to copy. For example, refs/heads/main.
     * @param targetRef The target ref to update. For example, refs/heads/main.
     * @param includeLinks Set to true to include links to items.  Default is false.
     * @return GitForkSyncRequest Object {@link GitForkSyncRequest}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitForkSyncRequest createForkSyncRequest(String repositoryName, String collectionId, String projectId,
                                                    String repositoryId, String sourceRef, String targetRef, 
                                                    Boolean includeLinks) throws AzDException {

        var q = new HashMap<String, Object>() {{
            put("includeLinks", includeLinks);
        }};

        var b = new HashMap<String, Object>() {{
            put("source", new HashMap<String, String>() {{
                put("collectionId", collectionId);
                put("projectId", projectId);
                put("repositoryId", repositoryId);
            }});
            put("sourceToTargetRefs", new HashMap<String, String>() {{
                put("sourceRef", sourceRef);
                put("targetRef", targetRef);
            }});
        }};

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "forkSyncRequests", ApiVersion.GIT, q, b, CustomHeader.JSON_CONTENT_TYPE);
        
        return MAPPER.mapJsonResponse(r, GitForkSyncRequest.class);
    }

    /**
     * Get a specific fork sync operation's details.
     *
     * @param repositoryName The name or ID of the repository.
     * @param OperationId OperationId of the sync request.
     * @param includeLinks Set to true to include links to items.  Default is false.
     * @return GitForkSyncRequest Object {@link GitForkSyncRequest}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitForkSyncRequest getForkSyncRequest(String repositoryName, int OperationId, boolean includeLinks)
                                                throws AzDException {
        
        var q = new HashMap<String, Object>() {{
            put("includeLinks", includeLinks);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "forkSyncRequests/"+OperationId, ApiVersion.GIT, q, CustomHeader.JSON_CONTENT_TYPE, null);

        return MAPPER.mapJsonResponse(r, GitForkSyncRequest.class);
    }

    /**
     * Retrieve all requested fork sync operations on this repository.
     *
     * @param repositoryName The name or ID of the repository.
     * @param includeLinks Set to true to include links to items.  Default is false.
     * @param includeAbandoned Set to true to include abandoned requests.  Default is false.
     * @return GitForkSyncRequests Object {@link GitForkSyncRequests}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitForkSyncRequests getForkSyncRequests(String repositoryName, boolean includeLinks, boolean includeAbandoned)
                                                    throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("includeLinks", includeLinks);
            put("includeAbandoned", includeAbandoned);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                repositoryName, "forkSyncRequests", ApiVersion.GIT, q, null, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitForkSyncRequests.class);
    }

    /**
     * Retrieve all forks of a repository in the collection.
     *
     * @param repositoryName The name or ID of the repository.
     * @param collectionId Team project collection ID.
     * @param includeLinks Set to true to include links to items.  Default is false.
     * @return GitRepositoryRefs Object {@link GitRepositoryRefs}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitRepositoryRefs getForks(String repositoryName, String collectionId, boolean includeLinks) throws AzDException {

        var q = new HashMap<String, Object>() {{
            put("includeLinks", includeLinks);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(), AREA + "/repositories",
                    repositoryName, "forks/"+collectionId, ApiVersion.GIT, q, null, CustomHeader.JSON_CONTENT_TYPE);
        
        return MAPPER.mapJsonResponse(r, GitRepositoryRefs.class);
    }

    /**
     * Create a fork of a parent repository
     *
     * @param repositoryName The name or ID of the repository.
     * @param projectId The project id of the target repository
     * @param parentProjectId Project id of the parent repository from which the fork operation has to initiate.
     * @param parentRepositoryId Id of the parent repository
     * @return GitRepository Object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitRepository createForkRepository(String repositoryName, String projectId, String parentProjectId,
                                                   String parentRepositoryId) throws AzDException {
        Map<String, Object> b = new HashMap<>() {{
            put("name", repositoryName);
            put("project", new HashMap<String, String>() {{
                put("id", projectId);
            }});
            put("parentRepository", new HashMap<String, Object>() {{
                put("id", parentRepositoryId);
                put("project", new HashMap<String, String>() {{
                    put("id", parentProjectId);
                }});
            }});
        }};
        String r = send(RequestMethod.POST, CONNECTION, GIT, projectId, AREA, null, "repositories", ApiVersion.GIT,
                null, b, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, GitRepository.class);
    }

    /**
     * Create a fork of a parent repository syncing only the provided refs
     *
     * @param repositoryName The name or ID of the repository.
     * @param projectId The project id of the target repository
     * @param parentProjectId Project id of the parent repository from which the fork operation has to initiate.
     * @param parentRepositoryId Id of the parent repository
     * @param sourceBranch Provide the name of branch to create a fork request.
     * @return GitRepository Object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitRepository createForkRepository(String repositoryName, String projectId, String parentProjectId,
                                                   String parentRepositoryId, String sourceBranch) throws AzDException {

        var q = new HashMap<String, Object>() {{
            put("sourceRef", "refs/heads/"+sourceBranch);
        }};                                                    
                                                    
        Map<String, Object> b = new HashMap<>() {{
            put("name", repositoryName);
            put("project", new HashMap<String, String>() {{
                put("id", projectId);
            }});
            put("parentRepository", new HashMap<String, Object>() {{
                put("id", parentRepositoryId);
                put("project", new HashMap<String, String>() {{
                    put("id", parentProjectId);
                }});
            }});
        }};
        String r = send(RequestMethod.POST, CONNECTION, GIT, projectId, AREA, null, "repositories", ApiVersion.GIT,
                        q, b, CustomHeader.JSON_CONTENT_TYPE);
                
        return MAPPER.mapJsonResponse(r, GitRepository.class);
    }

    /**
     * Create a fork of a parent repository syncing only the provided refs with wait for operation completion
     *
     * @param repositoryName The name or ID of the repository.
     * @param projectId The project id of the target repository
     * @param parentProjectId Project id of the parent repository from which the fork operation has to initiate.
     * @param parentRepositoryId Id of the parent repository
     * @param sourceBranch Provide the name of branch to create a fork request.
     * @param checkTimes Polling interval to wait for operation to complete.
     * @return GitRepository Object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     **/
    @Override
    public GitRepository createForkRepositoryWithComplete(String repositoryName, String projectId, String parentProjectId, String parentRepositoryId, 
                                                          String sourceBranch, int checkTimes) throws AzDException {
        GitRepository gitRepository = createForkRepository(repositoryName, projectId, parentProjectId, parentRepositoryId, sourceBranch);
        GitForkSyncRequest gitForkSyncRequest = getForkSyncRequests(repositoryName, true, true).getForkSyncRequest().get(0);
        int operationId = gitForkSyncRequest.getOperationId();

        for (int i = 0; i < checkTimes; i++) {
            gitForkSyncRequest = getForkSyncRequest(repositoryName, operationId, true);
            if (gitForkSyncRequest.getStatus() == GitAsyncOperationStatus.COMPLETED) {
                return gitRepository;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new AzDException("Error while waiting for fork sync request to complete");
            }
        }

        throw new AzDException("Fork sync request did not complete in time : " + gitForkSyncRequest.getStatus());
    }

}
