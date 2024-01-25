package org.azd.git.pullrequest;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.types.JsonPatchDocument;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitStatus;
import org.azd.git.types.GitStatuses;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Request builder to manage pull request statuses Api.
 */
public class PullRequestStatusRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PullRequestStatusRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "b5f6bb4f-8d1e-4d79-8d11-4c9172c99c35", ApiVersion.GIT);
    }

    /**
     * Create a pull request status.
     * The only required field for the status is Context.Name that uniquely identifies the status.
     * Note that you can specify iterationId in the request body to post the status on the iteration.
     *
     * @param pullRequestId        ID of the pull request.
     * @param repositoryId         The repository ID of the pull request’s target branch.
     * @param gitPullRequestStatus Request body to create a new pull request status.
     * @return GitStatus Object {@link GitStatus}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitStatus> createAsync(String repositoryId, int pullRequestId, GitStatus gitPullRequestStatus)
            throws AzDException {
        return builder()
                .POST(gitPullRequestStatus)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(GitStatus.class);
    }

    /**
     * Delete pull request status. You can remove multiple statuses in one call by using Update operation.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository ID of the pull request’s target branch.
     * @param statusId      ID of the pull request status.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> deleteAsync(String repositoryId, int pullRequestId, int statusId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("statusId", statusId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get the specific pull request status by ID. The status ID is unique within the pull request across all iterations.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository ID of the pull request’s target branch.
     * @param statusId      ID of the pull request status.
     * @return GitStatus Object {@link GitStatus}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitStatus> getAsync(String repositoryId, int pullRequestId, int statusId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("statusId", statusId)
                .build()
                .executeAsync(GitStatus.class);
    }

    /**
     * Get all the statuses associated with a pull request.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository ID of the pull request’s target branch.
     * @return GitStatuses Object {@link GitStatuses}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitStatuses> listAsync(String repositoryId, int pullRequestId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .executeAsync(GitStatuses.class);
    }

    /**
     * Update pull request statuses collection. The only supported operation type is remove.
     * This operation allows to delete multiple statuses in one call.
     * The path of the remove operation should refer to the ID of the pull request status.
     * For example path="/1" refers to the pull request status with ID 1.
     *
     * @param pullRequestId      ID of the pull request.
     * @param repositoryId       The repository ID of the pull request’s target branch.
     * @param propertiesToUpdate Collection of properties to update.
     *                           <pre>{@code
     *                           [
     *                             {
     *                               "op": "remove",
     *                               "path": "/1",
     *                               "from": null,
     *                               "value": null
     *                             },
     *                             {
     *                               "op": "remove",
     *                               "path": "/2",
     *                               "from": null,
     *                               "value": null
     *                             }
     *                           ]
     *                           }</pre>
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> updateAsync(String repositoryId, int pullRequestId, List<JsonPatchDocument> propertiesToUpdate)
            throws AzDException {
        return builder()
                .PATCH(propertiesToUpdate)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Create a pull request status.
     * The only required field for the status is Context.Name that uniquely identifies the status.
     * Note that you can specify iterationId in the request body to post the status on the iteration.
     *
     * @param pullRequestId        ID of the pull request.
     * @param repositoryId         The repository ID of the pull request’s target branch.
     * @param gitPullRequestStatus Request body to create a new pull request status.
     * @return GitStatus Object {@link GitStatus}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitStatus create(String repositoryId, int pullRequestId, GitStatus gitPullRequestStatus)
            throws AzDException {
        return builder()
                .POST(gitPullRequestStatus)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(GitStatus.class);
    }

    /**
     * Delete pull request status. You can remove multiple statuses in one call by using Update operation.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository ID of the pull request’s target branch.
     * @param statusId      ID of the pull request status.
     * @throws AzDException Default Api Exception handler.
     **/
    public Void delete(String repositoryId, int pullRequestId, int statusId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("statusId", statusId)
                .build()
                .executePrimitive();
    }

    /**
     * Get the specific pull request status by ID. The status ID is unique within the pull request across all iterations.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository ID of the pull request’s target branch.
     * @param statusId      ID of the pull request status.
     * @return GitStatus Object {@link GitStatus}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitStatus get(String repositoryId, int pullRequestId, int statusId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .serviceEndpoint("statusId", statusId)
                .build()
                .execute(GitStatus.class);
    }

    /**
     * Get all the statuses associated with a pull request.
     *
     * @param pullRequestId ID of the pull request.
     * @param repositoryId  The repository ID of the pull request’s target branch.
     * @return GitStatuses Object {@link GitStatuses}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitStatuses list(String repositoryId, int pullRequestId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .build()
                .execute(GitStatuses.class);
    }

    /**
     * Update pull request statuses collection. The only supported operation type is remove.
     * This operation allows to delete multiple statuses in one call.
     * The path of the remove operation should refer to the ID of the pull request status.
     * For example path="/1" refers to the pull request status with ID 1.
     *
     * @param pullRequestId      ID of the pull request.
     * @param repositoryId       The repository ID of the pull request’s target branch.
     * @param propertiesToUpdate Collection of properties to update.
     *                           <pre>{@code
     *                           [
     *                             {
     *                               "op": "remove",
     *                               "path": "/1",
     *                               "from": null,
     *                               "value": null
     *                             },
     *                             {
     *                               "op": "remove",
     *                               "path": "/2",
     *                               "from": null,
     *                               "value": null
     *                             }
     *                           ]
     *                           }</pre>
     * @throws AzDException Default Api Exception handler.
     **/
    public Void update(String repositoryId, int pullRequestId, List<JsonPatchDocument> propertiesToUpdate)
            throws AzDException {
        return builder()
                .PATCH(propertiesToUpdate)
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pullRequestId", pullRequestId)
                .header(CustomHeader.JSON_PATCH)
                .build()
                .executePrimitive();
    }
}
