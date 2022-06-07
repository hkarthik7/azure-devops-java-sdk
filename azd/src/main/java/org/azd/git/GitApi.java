package org.azd.git;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.git.types.*;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.GitDetails;
import org.azd.utils.AzDAsyncApi;

import java.util.*;

import static org.azd.utils.Client.send;

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
        this.CONNECTION = connection;
    }

    /***
     * Create a git repository in a team project.
     * @param repositoryName Name of the repository
     * @param projectId id of the project
     * @throws AzDException Default Api Exception handler.
     * @return git repository object {@link Repository}
     */
    @Override
    public Repository createRepository(String repositoryName, String projectId) throws AzDException {

        LinkedHashMap<String, Object> h = new LinkedHashMap<>() {{
            put("name", repositoryName);
            put("project", new LinkedHashMap<String, String>() {{
                put("id", projectId);
            }});
        }};
        String r = send(RequestMethod.POST, CONNECTION, GIT, projectId,
                AREA, null, "repositories", ApiVersion.GIT, null, h);
        return MAPPER.mapJsonResponse(r, Repository.class);
    }

    /***
     * Delete a git repository
     * @param repositoryId pass the repository id
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteRepository(String repositoryId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, GIT, CONNECTION.getProject(),
                    AREA + "/repositories", repositoryId, null, ApiVersion.GIT, null, null);
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
                    AREA + "/recycleBin/repositories", repositoryId, null, ApiVersion.GIT, null, null);
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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA, null, "deletedrepositories", ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, GitDeletedRepositories.class);
    }

    /***
     * Retrieve soft-deleted git repositories from the recycle bin.
     * @throws AzDException Default Api Exception handler.
     * @return array of git deleted recycle bin repositories
     */
    @Override
    public GitDeletedRepositories getRecycleBinRepositories() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA, null, "recycleBin/repositories", ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, GitDeletedRepositories.class);
    }

    /***
     * Retrieve a git repository.
     * @param repositoryName pass the repository name
     * @throws AzDException Default Api Exception handler.
     * @return git repository object
     */
    @Override
    public Repository getRepository(String repositoryName) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, null, ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, Repository.class);
    }

    /***
     * Retrieve git repositories.
     * @throws AzDException Default Api Exception handler.
     * @return array of git repositories
     */
    @Override
    public Repositories getRepositories() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA, null, "repositories", ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, Repositories.class);
    }

    /***
     * Recover a soft-deleted Git repository.
     * Recently deleted repositories go into a soft-delete state for a period of time before they are hard deleted and become unrecoverable.
     * @param repositoryId pass the repository id
     * @param deleted Setting to false will undo earlier deletion and restore the repository.
     * @throws AzDException Default Api Exception handler.
     * @return object of git repository
     */
    @Override
    public Repository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws AzDException {

        HashMap<String, Object> h = new HashMap<>() {{
            put("deleted", deleted);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/recycleBin/repositories", repositoryId, null, ApiVersion.GIT, null, h);

        return MAPPER.mapJsonResponse(r, Repository.class);
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
    public Repository updateRepository(String repositoryId, String repositoryName, String defaultBranchName) throws AzDException {

        HashMap<String, Object> h = new HashMap<>() {{
            put("name", repositoryName);
            put("defaultBranch", "refs/heads/" + defaultBranchName);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryId, null, ApiVersion.GIT, null, h);

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
     * @throws AzDException Default Api Exception handler.
     * @return an object of git pull request {@link PullRequest}
     */
    @Override
    public PullRequest createPullRequest(
            String repositoryId, String sourceRefName, String targetRefName,
            String title, String description, String[] reviewers) throws AzDException {

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

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryId, "pullrequests", ApiVersion.GIT, null, h);

        return MAPPER.mapJsonResponse(r, PullRequest.class);
    }

    /***
     * Create a pull request and optionally make it a draft. You can specify only the source branch name such as develop and target branch name such as master.
     * @param repositoryId The repository ID of the pull request's target branch.
     * @param sourceRefName The name of the source branch of the pull request.
     * @param targetRefName The name of the target branch of the pull request.
     * @param title The title of the pull request.
     * @param description The description of the pull request.
     * @param isDraft if set to true the pull request will be in draft mode.
     * @return an object of git pull request {@link PullRequest}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequest createPullRequest(String repositoryId, String sourceRefName, String targetRefName, String title,
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

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryId, "pullrequests", ApiVersion.GIT, null, b);

        return MAPPER.mapJsonResponse(r, PullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequest getPullRequest(String repositoryName, int pullRequestId) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "pullrequests/" + pullRequestId, ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, PullRequest.class);
    }

    /***
     * Retrieve a pull request.
     * @param pullRequestId The ID of the pull request to retrieve.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequest getPullRequestById(int pullRequestId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/pullrequests", Integer.toString(pullRequestId), null, ApiVersion.GIT, null, null);


        return MAPPER.mapJsonResponse(r, PullRequest.class);
    }

    /***
     * Retrieve all pull requests from a repository
     * @param repositoryName specify the repository name
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequests getPullRequests(String repositoryName) throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "pullrequests", ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from non-default project you have to call setProject
     * method from {@link Connection}.
     * @throws AzDException Default Api Exception handler.
     * @return {@link PullRequest} object
     */
    @Override
    public PullRequests getPullRequestsByProject() throws AzDException {

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA, null, "pullrequests", ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from non-default project you have to call setProject
     * method from {@link Connection}.
     * @param top The number of pull requests to retrieve.
     * @return {@link PullRequest} PullRequest
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequests getPullRequestsByProject(int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA, null, "pullrequests", ApiVersion.GIT, q, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from non-default project you have to call setProject
     * method from {@link Connection}.
     * @param status If set, search for pull requests that are in this state. Defaults to Active if unset.
     * @return {@link PullRequest} PullRequest
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequests getPullRequestsByProject(PullRequestStatus status) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("searchCriteria.status", status.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA, null, "pullrequests", ApiVersion.GIT, q, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
    }

    /***
     * Gets all pull requests from a project. To get the pull requests from non-default project you have to call setProject
     * method from {@link Connection}.
     * @param skip The number of pull requests to ignore. For example, to retrieve results 101-150, set top to 50 and skip to 100.
     * @param top The number of pull requests to retrieve.
     * @param creatorId If set, search for pull requests that were created by this identity.
     * @param includeLinks Whether to include the _links field on the shallow references
     * @param repositoryId If set, search for pull requests whose target branch is in this repository.
     * @param reviewerId If set, search for pull requests that have this identity as a reviewer.
     * @param sourceRefName If set, search for pull requests from this branch.
     * @param sourceRepositoryId If set, search for pull requests whose source branch is in this repository.
     * @param status If set, search for pull requests that are in this state. Defaults to Active if unset.
     * @param targetRefName If set, search for pull requests into this branch.
     * @return {@link PullRequest} PullRequest
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequests getPullRequestsByProject(int skip, int top, String creatorId,
                                                 boolean includeLinks, String repositoryId, String reviewerId,
                                                 String sourceRefName, String sourceRepositoryId, PullRequestStatus status,
                                                 String targetRefName) throws AzDException {
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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA, null, "pullrequests", ApiVersion.GIT, q, null);

        return MAPPER.mapJsonResponse(r, PullRequests.class);
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

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "refs", ApiVersion.GIT, q, b);

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
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "pullRequests/" + pullRequestId + "/workitems", ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, ResourceRefs.class);
    }

    /***
     * Create a label for a specified pull request. The only required field is the name of the new label.
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

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "pullrequests/" + pullRequestId + "/labels", ApiVersion.GIT, null, b);

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
            String r = send(RequestMethod.DELETE, CONNECTION, GIT, CONNECTION.getProject(),
                    AREA + "/repositories", repositoryName, resource, ApiVersion.GIT, null, null);
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
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, resource, ApiVersion.GIT, null, null);

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
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, resource, ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, WebApiTagDefinitions.class);
    }

    /***
     * Add a reviewer to a pull request or cast a vote.
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @param vote Vote on a pull request: 10 - approved 5 - approved with suggestions 0 - no vote -5 - waiting for author -10 - rejected
     * @param isRequired Indicates if this is a required reviewer for this pull request.
     * @return PullRequestReviewer {@link PullRequestReviewer}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequestReviewer createPullRequestReviewer(int pullRequestId, String repositoryName,
                                                         String reviewerId, int vote, boolean isRequired) throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("vote", vote);
            put("id", reviewerId);
        }};

        String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

        String r = send(RequestMethod.PUT, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", id, null, ApiVersion.GIT, null, b);

        return MAPPER.mapJsonResponse(r, PullRequestReviewer.class);
    }

    /***
     * Remove a reviewer from a pull request.
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deletePullRequestReviewer(int pullRequestId, String repositoryName, String reviewerId) throws AzDException {
        try {
            String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

            String r = send(RequestMethod.DELETE, CONNECTION, GIT, CONNECTION.getProject(),
                    AREA + "/repositories", id, null, ApiVersion.GIT, null, null);
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
     * @return PullRequestReviewer {@link PullRequestReviewer}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequestReviewer getPullRequestReviewer(int pullRequestId, String repositoryName, String reviewerId)
            throws AzDException {
        String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", id, null, ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, PullRequestReviewer.class);
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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", id, null, ApiVersion.GIT, null, null);

        return MAPPER.mapJsonResponse(r, PullRequestReviewers.class);
    }

    /***
     * Edit a reviewer entry. These fields are patchable: isFlagged, hasDeclined
     * @param pullRequestId ID of the pull request.
     * @param repositoryName The repository name of the pull request's target branch.
     * @param reviewerId ID of the reviewer.
     * @param isFlagged Indicates if this reviewer is flagged for attention on this pull request.
     * @param hasDeclined Indicates if this reviewer has declined to review this pull request.
     * @return PullRequestReviewer {@link PullRequestReviewer}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PullRequestReviewer updatePullRequestReviewer(int pullRequestId, String repositoryName,
                                                         String reviewerId, boolean isFlagged, boolean hasDeclined)
            throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("isFlagged", isFlagged);
            put("hasDeclined", hasDeclined);
        }};

        String id = repositoryName + "/pullrequests/" + pullRequestId + "/reviewers/" + reviewerId;

        String r = send(RequestMethod.PATCH, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", id, null, ApiVersion.GIT, null, b);

        return MAPPER.mapJsonResponse(r, PullRequestReviewer.class);
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
    public GitAnnotatedTag createAnnotatedTag(String repositoryName, String tagName, String objectId, String message) throws AzDException {
        var b = new HashMap<String, Object>() {{
            put("name", tagName);
            put("taggedObject", new HashMap<String, String>() {{
                put("objectId", objectId);
            }});
            put("message", message);
        }};

        String r = send(RequestMethod.POST, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "annotatedtags", ApiVersion.GIT, null, b);

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
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "annotatedtags/" + objectId, ApiVersion.GIT, null, null);

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
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits/" + commitId, ApiVersion.GIT, null, null);

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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits/" + commitId, ApiVersion.GIT, q, null);

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
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits/" + commitId + "/changes", ApiVersion.GIT, null, null);

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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits/" + commitId + "/changes", ApiVersion.GIT, q, null);

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
        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits", ApiVersion.GIT, null, null);

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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits", ApiVersion.GIT, q, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryName Name of the repository.
     * @param ids            If provided, specifies the exact commit ids of the commits to fetch. May not be combined with other parameters.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getCommits(String repositoryName, List<String> ids) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("ids", String.join(",", ids));
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits", ApiVersion.GIT, q, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryName         Name of the repository.
     * @param top                    Maximum number of entries to retrieve.
     * @param skip                   Number of entries to skip.
     * @param author                 Alias or display name of the author.
     * @param version                Version string identifier (name of tag/branch, SHA1 of commit).
     * @param versionOptions         Version options - Specify additional modifiers to version (e.g Previous).
     * @param versionType            Version type (branch, tag, or commit). Determines how Id is interpreted.
     * @param excludeDeletes         Only applies when an itemPath is specified. This determines whether to exclude delete entries of the specified path.
     * @param fromCommitId           If provided, a lower bound for filtering commits alphabetically.
     * @param toCommitId             If provided, an upper bound for filtering commits alphabetically
     * @param fromDate               If provided, only include history entries created after this date (string).
     * @param toDate                 If provided, only include history entries created before this date (string)
     * @param historyMode            What Git history mode should be used. This only applies to the search criteria when Ids = null and an itemPath is specified.
     * @param ids                    If provided, specifies the exact commit ids of the commits to fetch. May not be combined with other parameters.
     * @param includeLinks           Whether to include the _links field on the shallow references
     * @param includePushData        Whether to include the push information
     * @param includeUserImageUrl    Whether to include the image Url for committers and authors
     * @param includeWorkItems       Whether to include linked work items
     * @param itemPath               Path of item to search under
     * @param showOldestCommitsFirst If enabled, this option will ignore the itemVersion and compareVersion parameters.
     * @param user                   Alias or display name of the committer
     * @param itemVersion            Version string identifier (name of tag/branch, SHA1 of commit)
     * @param itemVersionOptions     Version options - Specify additional modifiers to version (e.g Previous)
     * @param itemVersionType        Version type (branch, tag, or commit). Determines how Id is interpreted
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getCommits(String repositoryName, int top, int skip, String author, String version,
                                 GitVersionOptions versionOptions, GitVersionType versionType, boolean excludeDeletes,
                                 String fromCommitId, String toCommitId, String fromDate, String toDate,
                                 GitHistoryMode historyMode, List<String> ids, boolean includeLinks, boolean includePushData,
                                 boolean includeUserImageUrl, boolean includeWorkItems, String itemPath, boolean showOldestCommitsFirst,
                                 String user, String itemVersion, GitVersionOptions itemVersionOptions,
                                 GitVersionType itemVersionType) throws AzDException {
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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits", ApiVersion.GIT, q, null);

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

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits", ApiVersion.GIT, q, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }

    /**
     * Retrieve a list of commits associated with a particular push.
     *
     * @param repositoryName Name of the repository.
     * @param pushId         The id of the push.
     * @param includeLinks   Set to false to avoid including REST Url links for resources. Defaults to true.
     * @param top            The maximum number of commits to return ("get the top x commits").
     * @param skip           The number of commits to skip.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public GitCommits getPushCommits(String repositoryName, int pushId, boolean includeLinks, int top, int skip) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("pushId", pushId);
            put("top", top);
            put("skip", skip);
            put("includeLinks", includeLinks);
        }};

        String r = send(RequestMethod.GET, CONNECTION, GIT, CONNECTION.getProject(),
                AREA + "/repositories", repositoryName, "commits", ApiVersion.GIT, q, null);

        return MAPPER.mapJsonResponse(r, GitCommits.class);
    }
}
