package org.azd.interfaces;

import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.git.types.*;

import java.io.InputStream;
import java.util.List;

public interface GitDetails {

    GitRepository createRepository(String repositoryName, String projectId) throws AzDException;

    Void deleteRepository(String repositoryId) throws AzDException;

    Void deleteRepositoryFromRecycleBin(String repositoryId) throws AzDException;

    GitDeletedRepositories getDeletedRepositories() throws AzDException;

    GitDeletedRepositories getRecycleBinRepositories() throws AzDException;

    GitRepository getRepository(String repositoryName) throws AzDException;

    Repositories getRepositories() throws AzDException;

    GitRepository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws AzDException;

    GitRepository updateRepository(String repositoryId, String repositoryName, String defaultBranchName)
            throws AzDException;

    GitPullRequest createPullRequest(String repositoryId, String sourceRefName, String targetRefName, String title,
                                  String description, String[] reviewers) throws AzDException;

    GitPullRequest createPullRequest(String repositoryId, String sourceRefName, String targetRefName, String title,
                                  String description, boolean isDraft) throws AzDException;

    GitPullRequest createPullRequest(GitPullRequest gitPullRequest) throws AzDException;

    GitPullRequest getPullRequest(String repositoryName, int pullRequestId) throws AzDException;

    GitPullRequest getPullRequestById(int pullRequestId) throws AzDException;

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

    IdentityRefWithVote createPullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId, int vote,
                                                  boolean isRequired) throws AzDException;

    Void deletePullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId) throws AzDException;

    IdentityRefWithVote getPullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId)
            throws AzDException;

    PullRequestReviewers getPullRequestReviewers(int pullRequestId, String repositoryId) throws AzDException;

    IdentityRefWithVote updatePullRequestReviewer(int pullRequestId, String repositoryId, String reviewerId,
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

    GitRefs getRefs(String repositoryName) throws AzDException;

    GitRefs getRefs(String repositoryName, String filter) throws AzDException;
    
    GitRefUpdateResult updateRef(String repositoryName, String refName, String oldObjectId, String newObjectId) throws AzDException;
    
    GitRefUpdateResult createTag(String repositoryName, String tagName, String ref) throws AzDException;
    
    GitRefUpdateResult deleteTag(String repositoryName, String tagName) throws AzDException;


    GitBlobRef getBlob(String repositoryId, String sha1) throws AzDException;

    GitBlobRef getBlob(String repositoryId, String sha1, String fileName, boolean resolveLfs) throws AzDException;

    String getBlobContent(String repositoryId, String sha1, boolean download, String fileName, boolean resolveLfs) throws AzDException;

    InputStream getBlobContentAsZip(String repositoryId, String sha1, boolean download, String fileName, boolean resolveLfs) throws AzDException;

    InputStream getBlobContentAsStream(String repositoryId, String sha1, boolean download, String fileName, boolean resolveLfs) throws AzDException;

    InputStream getBlobsZip(String repositoryId, List<String> sha1) throws AzDException;

    InputStream getBlobsZip(String repositoryId, String fileName, List<String> sha1) throws AzDException;

    GitItems getItems(String repositoryName) throws AzDException;

    GitItems getItems(String repositoryName, VersionControlRecursionType recursionType) throws AzDException;

    GitItems getItems(String repositoryName, boolean includeContentMetadata, boolean includeLinks, boolean latestProcessedChange,
                      VersionControlRecursionType recursionType, String scopePath) throws AzDException;

    GitItems getItems(String repositoryName, boolean includeContentMetadata, boolean includeLinks, boolean latestProcessedChange,
                      VersionControlRecursionType recursionType, String scopePath, String version,
                      GitVersionOptions versionOptions, GitVersionType versionType) throws AzDException;

    GitForkSyncRequest createForkSyncRequest(String repositoryName, String sourceCollectionId, String sourceProjectId, String sourceRepositoryId, 
                                             Boolean includeLinks) throws AzDException;

    GitForkSyncRequest createForkSyncRequest(String repositoryName, String collectionId, String projectId, String repositoryId, 
                                             String sourceRef, String targetRef, Boolean includeLinks) throws AzDException;

    GitRepository createForkRepository(String repositoryName, String projectId, String parentProjectId, String parentRepositoryId) throws AzDException;

    GitRepository createForkRepository(String repositoryName, String projectId, String parentProjectId, String parentRepositoryId, String sourceBranch) throws AzDException;

    GitRepository createForkRepositoryWithComplete(String repositoryName, String projectId, String parentProjectId, String parentRepositoryId, String sourceBranch, int checkTimes) throws AzDException;

    GitForkSyncRequest getForkSyncRequest(String repositoryName, int OperationId, boolean includeLinks) throws AzDException;

    GitForkSyncRequests getForkSyncRequests(String repositoryName, boolean includeLinks, boolean includeAbandoned) throws AzDException;

    GitRepositoryRefs getForks(String repositoryName, String collectionId, boolean includeLinks) throws AzDException;

}