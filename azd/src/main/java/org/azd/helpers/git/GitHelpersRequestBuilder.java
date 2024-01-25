package org.azd.helpers.git;

import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.GitAsyncOperationStatus;
import org.azd.exceptions.AzDException;
import org.azd.git.GitBaseRequestBuilder;
import org.azd.git.types.*;

import java.util.concurrent.TimeUnit;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class GitHelpersRequestBuilder extends GitBaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public GitHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Create a fork of a parent repository
     *
     * @param repositoryName     The name or ID of the repository.
     * @param projectId          The project id of the target repository
     * @param parentProjectId    Project id of the parent repository from which the fork operation has to initiate.
     * @param parentRepositoryId Id of the parent repository
     * @return GitRepository Object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitRepository createForkRepository(String repositoryName, String projectId, String parentProjectId,
                                              String parentRepositoryId) throws AzDException {
        var project = new TeamProjectReference();
        project.setId(projectId);

        var parentProject = new TeamProjectReference();
        project.setId(parentProjectId);

        var parentRepo = new GitRepositoryRef();
        parentRepo.setId(parentRepositoryId);
        parentRepo.setProject(parentProject);

        var repo = new RepositoryRequest();
        repo.name = repositoryName;
        repo.project = project;
        repo.parentRepository = parentRepo;

        return repositories().create(repo);
    }

    /**
     * Create a fork of a parent repository syncing only the provided refs
     *
     * @param repositoryName     The name or ID of the repository.
     * @param projectId          The project id of the target repository
     * @param parentProjectId    Project id of the parent repository from which the fork operation has to initiate.
     * @param parentRepositoryId Id of the parent repository
     * @param sourceBranch       Provide the name of branch to create a fork request.
     * @return GitRepository Object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitRepository createForkRepository(String repositoryName, String projectId, String parentProjectId,
                                              String parentRepositoryId, String sourceBranch) throws AzDException {

        var project = new TeamProjectReference();
        project.setId(projectId);

        var parentProject = new TeamProjectReference();
        project.setId(parentProjectId);

        var parentRepo = new GitRepositoryRef();
        parentRepo.setId(parentRepositoryId);
        parentRepo.setProject(parentProject);

        var repo = new RepositoryRequest();
        repo.name = repositoryName;
        repo.project = project;
        repo.parentRepository = parentRepo;

        sourceBranch = !sourceBranch.contains("refs/heads/") ? "refs/heads/" + sourceBranch : sourceBranch;

        return repositories().create(repo, sourceBranch);
    }

    /**
     * Create a fork of a parent repository syncing only the provided refs with wait for operation completion
     *
     * @param repositoryName     The name or ID of the repository.
     * @param projectId          The project id of the target repository
     * @param parentProjectId    Project id of the parent repository from which the fork operation has to initiate.
     * @param parentRepositoryId Id of the parent repository
     * @param sourceBranch       Provide the name of branch to create a fork request.
     * @param checkTimes         Polling interval to wait for operation to complete.
     * @return GitRepository Object {@link GitRepository}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitRepository createForkRepositoryWithComplete(String repositoryName, String projectId, String parentProjectId, String parentRepositoryId,
                                                          String sourceBranch, int checkTimes) throws AzDException {
        GitRepository gitRepository = createForkRepository(repositoryName, projectId, parentProjectId, parentRepositoryId, sourceBranch);
        GitForkSyncRequest gitForkSyncRequest = forks().get(repositoryName, r -> {
            r.queryParameters.includeLinks = true;
            r.queryParameters.includeAbandoned = true;
        }).getForkSyncRequest().get(0);

        int operationId = gitForkSyncRequest.getOperationId();

        for (int i = 0; i < checkTimes; i++) {
            gitForkSyncRequest = forks().get(repositoryName, operationId, r -> r.queryParameters.includeLinks = true);
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
