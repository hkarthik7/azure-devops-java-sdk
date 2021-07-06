package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.git.types.PullRequest;
import org.azd.git.types.PullRequests;
import org.azd.git.types.Repositories;
import org.azd.git.types.Repository;

import java.util.Map;

public interface GitDetails {
    Repository createRepository(String repositoryName, String projectId) throws ConnectionException, AzDException;

    void deleteRepository(String repositoryId) throws ConnectionException, AzDException;

    void deleteRepositoryFromRecycleBin(String repositoryId) throws ConnectionException, AzDException;

    Map getDeletedRepositories() throws ConnectionException, AzDException;

    Map getRecycleBinRepositories() throws ConnectionException, AzDException;

    Repository getRepository(String repositoryName) throws ConnectionException, AzDException;

    Repositories getRepositories() throws ConnectionException, AzDException;

    Repository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws ConnectionException, AzDException;

    Repository updateRepository(String repositoryId, String repositoryName, String defaultBranchName) throws ConnectionException, AzDException;

    PullRequest createPullRequest(
            String repositoryId, String sourceRefName, String targetRefName,
            String title, String description, String[] reviewers) throws ConnectionException, AzDException;

    PullRequest getPullRequest(String repositoryName, int pullRequestId) throws ConnectionException, AzDException;

    PullRequest getPullRequestById(int pullRequestId) throws ConnectionException, AzDException;

    PullRequests getPullRequests(String repositoryName) throws ConnectionException, AzDException;

    PullRequests getPullRequestsByProject() throws ConnectionException, AzDException;
}
