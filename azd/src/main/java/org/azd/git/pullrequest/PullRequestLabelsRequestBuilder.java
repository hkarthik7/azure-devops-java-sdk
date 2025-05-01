package org.azd.git.pullrequest;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.WebApiTagDefinition;
import org.azd.git.types.WebApiTagDefinitions;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Request builder to manage pull request labels Api.
 */
public class PullRequestLabelsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PullRequestLabelsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "f22387e3-984e-4c52-9c6d-fbb8f14c812d", ApiVersion.GIT_PULL_REQUEST_LABELS);
    }

    /**
     * Create a label for a specified pull request. The only required field is
     * the name of the new label.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @param labelName      tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTagDefinition> createAsync(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        return builder()
                .POST(Map.of("name", labelName))
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(WebApiTagDefinition.class);
    }

    /**
     * Removes a label from the set of those assigned to the pull request.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @param labelName      tag/label name
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String repositoryName, int pullRequestId, String labelName) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("labelIdOrName", labelName)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Retrieves a single label that has been assigned to a pull request.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @param labelName      tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTagDefinition> getAsync(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("labelIdOrName", labelName)
                .build()
                .executeAsync(WebApiTagDefinition.class);
    }

    /**
     * Get all the labels assigned to a pull request.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @return List of WebApi tag object {@link WebApiTagDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<WebApiTagDefinitions> listAsync(String repositoryName, int pullRequestId)
            throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(WebApiTagDefinitions.class);
    }

    /**
     * Create a label for a specified pull request. The only required field is
     * the name of the new label.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @param labelName      tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTagDefinition create(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        return builder()
                .POST(Map.of("name", labelName))
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(WebApiTagDefinition.class);
    }

    /**
     * Removes a label from the set of those assigned to the pull request.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @param labelName      tag/label name
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String repositoryName, int pullRequestId, String labelName) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("labelIdOrName", labelName)
                .build()
                .executePrimitive();
    }

    /**
     * Retrieves a single label that has been assigned to a pull request.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @param labelName      tag/label name
     * @return WebApi tag object {@link WebApiTagDefinition}
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTagDefinition get(String repositoryName, int pullRequestId, String labelName)
            throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("labelIdOrName", labelName)
                .build()
                .execute(WebApiTagDefinition.class);
    }

    /**
     * Get all the labels assigned to a pull request.
     *
     * @param repositoryName The repository name of the pull request’s target branch.
     * @param pullRequestId  ID of the pull request.
     * @return List of WebApi tag object {@link WebApiTagDefinitions}
     * @throws AzDException Default Api Exception handler.
     */
    public WebApiTagDefinitions list(String repositoryName, int pullRequestId)
            throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(WebApiTagDefinitions.class);
    }
}
