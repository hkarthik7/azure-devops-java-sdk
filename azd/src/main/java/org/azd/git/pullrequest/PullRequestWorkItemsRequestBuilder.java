package org.azd.git.pullrequest;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.ResourceRefs;

import java.util.concurrent.CompletableFuture;

/**
 * Request builder to manage the work items associated with a pull request.
 */
public class PullRequestWorkItemsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PullRequestWorkItemsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "0a637fcc-5370-4ce8-b0e8-98091f5f9482", ApiVersion.GIT_WORK_ITEMS);
    }

    /**
     * Retrieve a list of work items associated with a pull request.
     *
     * @param pullRequestId  ID of the pull request.
     * @param repositoryName ID or name of the repository.
     * @return ResourceRefs {@link ResourceRefs}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ResourceRefs> listAsync(int pullRequestId, String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(ResourceRefs.class);
    }

    /**
     * Retrieve a list of work items associated with a pull request.
     *
     * @param pullRequestId  ID of the pull request.
     * @param repositoryName ID or name of the repository.
     * @return ResourceRefs {@link ResourceRefs}
     * @throws AzDException Default Api Exception handler.
     */
    public ResourceRefs list(int pullRequestId, String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(ResourceRefs.class);
    }

}
