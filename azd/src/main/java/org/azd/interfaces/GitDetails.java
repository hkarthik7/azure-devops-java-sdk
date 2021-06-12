package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.git.types.PullRequest;
import org.azd.git.types.PullRequests;
import org.azd.git.types.Repositories;
import org.azd.git.types.Repository;

import java.util.Map;

public interface GitDetails {
    Repository createRepository(String repositoryName, String projectId) throws DefaultParametersException, AzDException;

    void deleteRepository(String repositoryId) throws DefaultParametersException, AzDException;

    void deleteRepositoryFromRecycleBin(String repositoryId) throws DefaultParametersException, AzDException;

    Map getDeletedRepositories() throws DefaultParametersException, AzDException;

    Map getRecycleBinRepositories() throws DefaultParametersException, AzDException;

    Repository getRepository(String repositoryName) throws DefaultParametersException, AzDException;

    Repositories getRepositories() throws DefaultParametersException, AzDException;

    Repository restoreRepositoryFromRecycleBin(String repositoryId, boolean deleted) throws DefaultParametersException, AzDException;

    Repository updateRepository(String repositoryId, String repositoryName, String defaultBranchName) throws DefaultParametersException, AzDException;

    PullRequest createPullRequest(
            String repositoryId, String sourceRefName, String targetRefName,
            String title, String description, String[] reviewers) throws DefaultParametersException, AzDException;

    PullRequest getPullRequest(String repositoryName, int pullRequestId) throws DefaultParametersException, AzDException;

    PullRequest getPullRequestById(int pullRequestId) throws DefaultParametersException, AzDException;

    PullRequests getPullRequests(String repositoryName) throws DefaultParametersException, AzDException;

    PullRequests getPullRequestsByProject() throws DefaultParametersException, AzDException;
}
