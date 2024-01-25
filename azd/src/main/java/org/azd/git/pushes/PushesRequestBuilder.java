package org.azd.git.pushes;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitPush;
import org.azd.git.types.GitPushes;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to build requests for managing Git Pushes Api.
 */
public class PushesRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PushesRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "ea98d07b-3c87-4971-8ede-a613694ffb55", ApiVersion.GIT_PUSH);
    }

    /**
     * Push changes to the repository.
     *
     * @param repositoryId The name or ID of the repository.
     * @return GitPush Object {@link GitPush}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitPush> createAsync(GitPush gitPush, String repositoryId) throws AzDException {
        return builder()
                .POST(gitPush)
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitPush.class);
    }

    /**
     * Retrieves a particular push.
     *
     * @param pushId       ID of the push.
     * @param repositoryId The name or ID of the repository.
     * @return GitPush Object {@link GitPush}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitPush> getAsync(String repositoryId, int pushId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pushId", pushId)
                .build()
                .executeAsync(GitPush.class);
    }

    /**
     * Retrieves a particular push.
     *
     * @param pushId       ID of the push.
     * @param repositoryId The name or ID of the repository.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return GitPush Object {@link GitPush}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitPush> getAsync(String repositoryId, int pushId,
                                          Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pushId", pushId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitPush.class);
    }

    /**
     * Retrieves pushes associated with the specified repository.
     *
     * @param repositoryId The name or ID of the repository.
     * @return Collection of GitPush Object {@link GitPushes}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitPushes> listAsync(String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitPushes.class);
    }

    /**
     * Retrieves pushes associated with the specified repository.
     *
     * @param repositoryId The name or ID of the repository.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Collection of GitPush Object {@link GitPushes}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitPushes> listAsync(String repositoryId,
                                                  Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitPushes.class);
    }

    /**
     * Push changes to the repository.
     *
     * @param repositoryId The name or ID of the repository.
     * @return GitPush Object {@link GitPush}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitPush create(GitPush gitPush, String repositoryId) throws AzDException {
        return builder()
                .POST(gitPush)
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitPush.class);
    }

    /**
     * Retrieves a particular push.
     *
     * @param pushId       ID of the push.
     * @param repositoryId The name or ID of the repository.
     * @return GitPush Object {@link GitPush}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitPush get(String repositoryId, int pushId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pushId", pushId)
                .build()
                .execute(GitPush.class);
    }

    /**
     * Retrieves a particular push.
     *
     * @param pushId       ID of the push.
     * @param repositoryId The name or ID of the repository.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return GitPush Object {@link GitPush}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitPush get(String repositoryId, int pushId,
                       Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("pushId", pushId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitPush.class);
    }

    /**
     * Retrieves pushes associated with the specified repository.
     *
     * @param repositoryId The name or ID of the repository.
     * @return Collection of GitPush Object {@link GitPushes}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitPushes list(String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitPushes.class);
    }

    /**
     * Retrieves pushes associated with the specified repository.
     *
     * @param repositoryId The name or ID of the repository.
     * @param requestConfiguration Request configuration that represents the query parameters.
     * @return Collection of GitPush Object {@link GitPushes}
     * @throws AzDException Default Api Exception handler.
     **/
    public GitPushes list(String repositoryId,
                          Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitPushes.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The number of commits to include in the result.
         */
        @QueryParameter(name = "includeCommits")
        public Boolean includeCommits;
        /**
         * If true, include the list of refs that were updated by the push.
         */
        @QueryParameter(name = "includeRefUpdates")
        public Boolean includeRefUpdates;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * Start date to search from.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * Start date to search from.
         */
        @QueryParameter(name = "$skip")
        public Number skip;
        /**
         * Start date to search from.
         */
        @QueryParameter(name = "fromDate")
        public String fromDate;
        /**
         * Whether to include the _links field on the shallow references
         */
        @QueryParameter(name = "includeLinks")
        public Boolean includeLinks;
        /**
         * If true, include the list of refs that were updated by the push.
         */
        @QueryParameter(name = "includeRefUpdates")
        public Boolean includeRefUpdates;
        /**
         *  Identity of the person who submitted the push.
         */
        @QueryParameter(name = "pusherId")
        public String pusherId;
        /**
         *  Branch name to consider.
         */
        @QueryParameter(name = "refName")
        public String refName;
        /**
         * End date to search from.
         */
        @QueryParameter(name = "toDate")
        public String toDate;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }

}
