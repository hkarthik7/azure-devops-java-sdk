package org.azd.interfaces;

import org.azd.enums.PullRequestStatus;
import org.azd.exceptions.AzDException;
import org.azd.git.types.*;

public interface GitDetails {
    Repository createRepository(String repositoryName, String projectId) throws AzDException;

    void deleteRepository(String repositoryId) throws AzDException;

    void deleteRepositoryFromRecycleBin(String repositoryId) throws AzDException;

    GitDeletedRepositories getDeletedRepositories() throws AzDException;

    GitDeletedRepositories getRecycleBinRepositories() throws AzDException;

    Repository getRepository(String repositoryName) throws AzDException;

    Repositories getRepositories() throws AzDException;

    Repository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws AzDException;

    Repository updateRepository(String repositoryId, String repositoryName, String defaultBranchName) throws AzDException;

    PullRequest createPullRequest(
            String repositoryId, String sourceRefName, String targetRefName,
            String title, String description, String[] reviewers) throws AzDException;

    PullRequest createPullRequest(
            String repositoryId, String sourceRefName, String targetRefName,
            String title, String description, boolean isDraft) throws AzDException;

    PullRequest getPullRequest(String repositoryName, int pullRequestId) throws AzDException;

    PullRequest getPullRequestById(int pullRequestId) throws AzDException;

    PullRequests getPullRequests(String repositoryName) throws AzDException;

    PullRequests getPullRequestsByProject() throws AzDException;

    PullRequests getPullRequestsByProject(int top) throws AzDException;

    PullRequests getPullRequestsByProject(PullRequestStatus status) throws AzDException;

    PullRequests getPullRequestsByProject(int skip, int top, String creatorId, boolean includeLinks,
                                          String repositoryId, String reviewerId, String sourceRefName,
                                          String sourceRepositoryId, PullRequestStatus status, String targetRefName) throws AzDException;

    GitRef updateBranchLock(String repositoryName, String branchName, boolean isLocked) throws AzDException;

    ResourceRefs getPullRequestWorkItems(int pullRequestId, String repositoryName) throws AzDException;

    WebApiTagDefinition createPullRequestLabel(String repositoryName, int pullRequestId, String labelName) throws AzDException;

    void deletePullRequestLabel(String repositoryName, int pullRequestId, String labelName) throws AzDException;

    WebApiTagDefinition getPullRequestLabel(String repositoryName, int pullRequestId, String labelName) throws AzDException;

    WebApiTagDefinitions getPullRequestLabels(String repositoryName, int pullRequestId) throws AzDException;

    PullRequestReviewer createPullRequestReviewer(int pullRequestId, String repositoryId,
                                                  String reviewerId, int vote, boolean isRequired) throws AzDException;

    void deletePullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId) throws AzDException;

    PullRequestReviewer getPullRequestReviewer(int pullRequestId, String repositoryId,
                                               String reviewerId) throws AzDException;

    PullRequestReviewers getPullRequestReviewers(int pullRequestId, String repositoryId) throws AzDException;

    PullRequestReviewer updatePullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId,
                                                  boolean isFlagged, boolean hasDeclined) throws AzDException;
}
