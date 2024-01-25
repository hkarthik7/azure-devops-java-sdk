package org.azd.git.refs;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitRef;
import org.azd.git.types.GitRefUpdate;
import org.azd.git.types.GitRefUpdateResults;
import org.azd.git.types.GitRefs;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Request builder to handle requests for Git Refs Api.
 */
public class RefsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RefsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "2d874a60-a811-4f62-9c9f-963a6ea0a55b", ApiVersion.GIT);
    }

    /**
     * Queries the provided repository for its refs and returns them.
     *
     * @param repositoryName The name or ID of the repository.
     * @return GitRefs future object {@link GitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitRefs> listAsync(String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .executeAsync(GitRefs.class);
    }

    /**
     * Queries the provided repository for its refs and returns them.
     *
     * @param repositoryName The name or ID of the repository.
     * @return GitRefs future object {@link GitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitRefs> listAsync(String repositoryName,
                                                Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitRefs.class);
    }

    /**
     * Lock or Unlock a branch with repository name and branch name.
     *
     * @param repositoryName The name or ID of the repository.
     * @param branchName     The name of the branch to lock/unlock
     * @param isLocked       true to lock the branch and false to unlock.
     * @return GitRef {@link GitRef}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRef> updateAsync(String repositoryName, String branchName, boolean isLocked) throws AzDException {
        return builder()
                .PATCH(Map.of("isLocked", isLocked))
                .serviceEndpoint("repositoryId", repositoryName)
                .query("filter", "heads/" + branchName)
                .build()
                .executeAsync(GitRef.class);
    }

    /**
     * Creating, updating, or deleting refs(branches).
     * Updating a ref means making it point at a different commit than it used to. You must specify both the old and new commit to avoid race conditions.
     *
     * @param repositoryName The name or ID of the repository.
     * @param gitRefUpdates  Collection of Git Reference object to update.
     * @return GitRefUpdateResults {@link GitRefUpdateResults}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitRefUpdateResults> updateAsync(String repositoryName, List<GitRefUpdate> gitRefUpdates) throws AzDException {
        return builder()
                .PATCH(gitRefUpdates)
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .executeAsync(GitRefUpdateResults.class);
    }

    /**
     * Queries the provided repository for its refs and returns them.
     *
     * @param repositoryName The name or ID of the repository.
     * @return GitRefs future object {@link GitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public GitRefs list(String repositoryName) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .execute(GitRefs.class);
    }

    /**
     * Queries the provided repository for its refs and returns them.
     *
     * @param repositoryName The name or ID of the repository.
     * @return GitRefs future object {@link GitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public GitRefs list(String repositoryName,
                        Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryName)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitRefs.class);
    }

    /**
     * Lock or Unlock a branch with repository name and branch name.
     *
     * @param repositoryName The name or ID of the repository.
     * @param branchName     The name of the branch to lock/unlock
     * @param isLocked       true to lock the branch and false to unlock.
     * @return GitRef {@link GitRef}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRef update(String repositoryName, String branchName, boolean isLocked) throws AzDException {
        return builder()
                .PATCH(Map.of("isLocked", isLocked))
                .serviceEndpoint("repositoryId", repositoryName)
                .query("filter", "heads/" + branchName)
                .build()
                .execute(GitRef.class);
    }

    /**
     * Creating, updating, or deleting refs(branches).
     * Updating a ref means making it point at a different commit than it used to. You must specify both the old and new commit to avoid race conditions.
     *
     * @param repositoryName The name or ID of the repository.
     * @param gitRefUpdates  Collection of Git Reference object to update.
     * @return GitRefUpdateResults {@link GitRefUpdateResults}
     * @throws AzDException Default Api Exception handler.
     */
    public GitRefUpdateResults update(String repositoryName, List<GitRefUpdate> gitRefUpdates) throws AzDException {
        return builder()
                .PATCH(gitRefUpdates)
                .serviceEndpoint("repositoryId", repositoryName)
                .build()
                .execute(GitRefUpdateResults.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Maximum number of refs to return. It cannot be bigger than 1000. If it is not provided but continuationToken is, top will default to 100.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * The continuation token used for pagination.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * A filter to apply to the refs (starts with).
         */
        @QueryParameter(name = "filter")
        public String filter;
        /**
         * A filter to apply to the refs (contains).
         */
        @QueryParameter(name = "filterContains")
        public String filterContains;
        /**
         * Specifies if referenceLinks should be included in the result. default is false.
         */
        @QueryParameter(name = "includeLinks")
        public Boolean includeLinks;
        /**
         * Includes only branches that the user owns, the branches the user favorites, and the default branch.
         * The default value is false. Cannot be combined with the filter parameter.
         */
        @QueryParameter(name = "includeMyBranches")
        public Boolean includeMyBranches;
        /**
         * Includes up to the first 1000 commit statuses for each ref. The default value is false.
         */
        @QueryParameter(name = "includeStatuses")
        public Boolean includeStatuses;
        /**
         * True to include only the tip commit status for each ref. This option requires includeStatuses to be true. The default value is false.
         */
        @QueryParameter(name = "latestStatusesOnly")
        public Boolean latestStatusesOnly;
        /**
         * Annotated tags will populate the PeeledObjectId property. default is false.
         */
        @QueryParameter(name = "peelTags")
        public Boolean peelTags;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
