package org.azd.interfaces;

import org.azd.enums.GitHistoryMode;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.enums.PullRequestStatus;
import org.azd.exceptions.AzDException;
import org.azd.git.types.*;

import java.util.List;

public interface GitDetails {

    Repository createRepository(String repositoryName, String projectId) throws AzDException;

    Void deleteRepository(String repositoryId) throws AzDException;

    Void deleteRepositoryFromRecycleBin(String repositoryId) throws AzDException;

    GitDeletedRepositories getDeletedRepositories() throws AzDException;

    GitDeletedRepositories getRecycleBinRepositories() throws AzDException;

    Repository getRepository(String repositoryName) throws AzDException;

    Repositories getRepositories() throws AzDException;

    Repository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws AzDException;

    Repository updateRepository(String repositoryId, String repositoryName, String defaultBranchName)
            throws AzDException;

    PullRequest createPullRequest(String repositoryId, String sourceRefName, String targetRefName, String title,
                                  String description, String[] reviewers) throws AzDException;

    PullRequest createPullRequest(String repositoryId, String sourceRefName, String targetRefName, String title,
                                  String description, boolean isDraft) throws AzDException;

    PullRequest getPullRequest(String repositoryName, int pullRequestId) throws AzDException;

    PullRequest getPullRequestById(int pullRequestId) throws AzDException;

    PullRequests getPullRequests(String repositoryName) throws AzDException;

    PullRequests getPullRequestsByProject() throws AzDException;

    PullRequests getPullRequestsByProject(int top) throws AzDException;

    PullRequests getPullRequestsByProject(PullRequestStatus status) throws AzDException;

    PullRequests getPullRequestsByProject(int skip, int top, String creatorId, boolean includeLinks,
                                          String repositoryId, String reviewerId, String sourceRefName, String sourceRepositoryId,
                                          PullRequestStatus status, String targetRefName) throws AzDException;

    GitRef getBranch(String repositoryName, String branchName) throws AzDException;

    GitRefs getBranches(String repositoryName) throws AzDException;

    GitRef updateBranchLock(String repositoryName, String branchName, boolean isLocked) throws AzDException;

    ResourceRefs getPullRequestWorkItems(int pullRequestId, String repositoryName) throws AzDException;

    WebApiTagDefinition createPullRequestLabel(String repositoryName, int pullRequestId, String labelName)
            throws AzDException;

    Void deletePullRequestLabel(String repositoryName, int pullRequestId, String labelName) throws AzDException;

    WebApiTagDefinition getPullRequestLabel(String repositoryName, int pullRequestId, String labelName)
            throws AzDException;

    WebApiTagDefinitions getPullRequestLabels(String repositoryName, int pullRequestId) throws AzDException;

    PullRequestReviewer createPullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId, int vote,
                                                  boolean isRequired) throws AzDException;

    Void deletePullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId) throws AzDException;

    PullRequestReviewer getPullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId)
            throws AzDException;

    PullRequestReviewers getPullRequestReviewers(int pullRequestId, String repositoryId) throws AzDException;

    PullRequestReviewer updatePullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId,
                                                  boolean isFlagged, boolean hasDeclined) throws AzDException;

    GitAnnotatedTag createAnnotatedTag(String repositoryName, String tagName, String objectId, String message)
            throws AzDException;

    GitAnnotatedTag getAnnotatedTag(String repositoryName, String objectId) throws AzDException;

    GitCommit getCommit(String repositoryName, String commitId) throws AzDException;

    GitCommit getCommit(String repositoryName, String commitId, int changeCount) throws AzDException;

    GitCommitChanges getChanges(String repositoryName, String commitId) throws AzDException;

    GitCommitChanges getChanges(String repositoryName, String commitId, int top, int skip) throws AzDException;

    GitCommits getCommits(String repositoryName) throws AzDException;

    GitCommits getCommits(String repositoryName, int top) throws AzDException;

    GitCommits getCommits(String repositoryName, List<String> ids) throws AzDException;

    GitCommits getCommits(String repositoryName, int top, int skip, String author, String version,
                          GitVersionOptions versionOptions, GitVersionType versionType, boolean excludeDeletes, String fromCommitId,
                          String toCommitId, String fromDate, String toDate, GitHistoryMode historyMode, List<String> ids,
                          boolean includeLinks, boolean includePushData, boolean includeUserImageUrl, boolean includeWorkItems,
                          String itemPath, boolean showOldestCommitsFirst, String user, String itemVersion,
                          GitVersionOptions itemVersionOptions, GitVersionType itemVersionType) throws AzDException;

    GitCommits getPushCommits(String repositoryName, int pushId) throws AzDException;

    GitCommits getPushCommits(String repositoryName, int pushId, boolean includeLinks, int top, int skip)
            throws AzDException;
}
