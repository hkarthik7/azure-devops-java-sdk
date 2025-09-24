package org.azd.git.pullrequest;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitPullRequestIteration;
import org.azd.git.types.GitPullRequestIterations;

import java.util.concurrent.CompletableFuture;

public class PullRequestIterationsBuilder extends BaseRequestBuilder {

    public PullRequestIterationsBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "4e080c62-fa21-4fbc-8fef-2a10a2b38049", ApiVersion.GIT);
    }

    public CompletableFuture<GitPullRequestIteration> getAsync(String repositoryId, int pullRequestId, int iterationId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("iterationId", iterationId)
                .build()
                .executeAsync(GitPullRequestIteration.class);
    }

    public CompletableFuture<GitPullRequestIterations> listAsync(String repositoryId, int pullRequestId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(GitPullRequestIterations.class);
    }

    public GitPullRequestIteration get(String repositoryId, int pullRequestId, int iterationId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("iterationId", iterationId)
                .build()
                .execute(GitPullRequestIteration.class);
    }

    public GitPullRequestIterations list(String repositoryId, int pullRequestId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(GitPullRequestIterations.class);
    }
}
