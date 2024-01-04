package org.azd.git.commits;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.GitHistoryMode;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.exceptions.AzDException;
import org.azd.git.types.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Request builder to manage Git commits Api.
 */
public class CommitsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public CommitsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "c2570c3b-5b3f-41b8-98bf-5407bfde8d58", ApiVersion.GIT);
    }

    /**
     * Retrieve a particular commit.
     *
     * @param repositoryId Name or id of the repository.
     * @param commitId     The id of the commit.
     * @return Git commit object {@link GitCommit}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitCommit> getAsync(String repositoryId, String commitId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .build()
                .executeAsync(GitCommit.class);
    }

    /**
     * Retrieve a particular commit.
     *
     * @param repositoryId id of the repository.
     * @param commitId     The id of the commit.
     * @param changeCount  The number of changes to include in the result.
     * @return Git commit object {@link GitCommit}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitCommit> getAsync(String repositoryId, String commitId, int changeCount) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .query("changeCount", changeCount)
                .build()
                .executeAsync(GitCommit.class);
    }

    /**
     * Retrieve changes for a particular commit.
     *
     * @param repositoryId Name or id of the repository.
     * @param commitId     The id of the commit.
     * @return Git commit changes object {@link GitCommitChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitCommitChanges> getChangesAsync(String repositoryId, String commitId) throws AzDException {
        return builder()
                .location("5bf884f5-3e07-42e9-afb8-1b872267bf16")
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .build()
                .executeAsync(GitCommitChanges.class);
    }

    /**
     * Retrieve changes for a particular commit.
     *
     * @param repositoryId         Name or id of the repository.
     * @param commitId             The id of the commit.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Git commit changes object {@link GitCommitChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitCommitChanges> getChangesAsync(String repositoryId, String commitId,
                                                               Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("5bf884f5-3e07-42e9-afb8-1b872267bf16")
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitCommitChanges.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryId id of the repository.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitCommits> listAsync(String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitCommits.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryId         id of the repository.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitCommits> listAsync(String repositoryId,
                                                   Consumer<CommitsRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(CommitsRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitCommits.class);
    }

    /**
     * Retrieve git commits for a project matching the search criteria.
     *
     * @param repositoryId    The name or ID of the repository.
     * @param gitCommitsBatch request body {@link GitCommitsBatch}.
     * @return GitCommitRefs object {@link GitCommitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitCommitRefs> listBatchAsync(String repositoryId, GitCommitsBatch gitCommitsBatch) throws AzDException {
        return builder()
                .POST(gitCommitsBatch)
                .location("6400dfb2-0bcb-462b-b992-5a57f8f1416c")
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitCommitRefs.class);
    }

    /**
     * Retrieve git commits for a project matching the search criteria.
     *
     * @param repositoryId         The name or ID of the repository.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @param gitCommitsBatch      request body {@link GitCommitsBatch}.
     * @return GitCommitRefs object {@link GitCommitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitCommitRefs> listBatchAsync(String repositoryId,
                                                           GitCommitsBatch gitCommitsBatch,
                                                           Consumer<CommitsBatchRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .POST(gitCommitsBatch)
                .location("6400dfb2-0bcb-462b-b992-5a57f8f1416c")
                .serviceEndpoint("repositoryId", repositoryId)
                .query(CommitsBatchRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitCommitRefs.class);
    }

    /**
     * Retrieve a list of commits associated with a particular push. Push id is mandatory.
     *
     * @param repositoryId         id of the repository.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitCommitRefs> listPushAsync(String repositoryId,
                                                          Consumer<CommitsPushRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(CommitsPushRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitCommitRefs.class);
    }

    /**
     * Retrieve a particular commit.
     *
     * @param repositoryId Name or id of the repository.
     * @param commitId     The id of the commit.
     * @return Git commit object {@link GitCommit}
     * @throws AzDException Default Api Exception handler.
     */
    public GitCommit get(String repositoryId, String commitId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .build()
                .execute(GitCommit.class);
    }

    /**
     * Retrieve a particular commit.
     *
     * @param repositoryId id of the repository.
     * @param commitId     The id of the commit.
     * @param changeCount  The number of changes to include in the result.
     * @return Git commit object {@link GitCommit}
     * @throws AzDException Default Api Exception handler.
     */
    public GitCommit get(String repositoryId, String commitId, int changeCount) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .query("changeCount", changeCount)
                .build()
                .execute(GitCommit.class);
    }

    /**
     * Retrieve changes for a particular commit.
     *
     * @param repositoryId Name or id of the repository.
     * @param commitId     The id of the commit.
     * @return Git commit changes object {@link GitCommitChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public GitCommitChanges getChanges(String repositoryId, String commitId) throws AzDException {
        return builder()
                .location("5bf884f5-3e07-42e9-afb8-1b872267bf16")
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .build()
                .execute(GitCommitChanges.class);
    }

    /**
     * Retrieve changes for a particular commit.
     *
     * @param repositoryId         Name or id of the repository.
     * @param commitId             The id of the commit.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Git commit changes object {@link GitCommitChanges}
     * @throws AzDException Default Api Exception handler.
     */
    public GitCommitChanges getChanges(String repositoryId, String commitId,
                                       Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .location("5bf884f5-3e07-42e9-afb8-1b872267bf16")
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("commitId", commitId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitCommitChanges.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryId id of the repository.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    public GitCommits list(String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitCommits.class);
    }

    /**
     * Retrieve git commits for a project.
     *
     * @param repositoryId         id of the repository.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    public GitCommits list(String repositoryId,
                           Consumer<CommitsRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(CommitsRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitCommits.class);
    }

    /**
     * Retrieve git commits for a project matching the search criteria.
     *
     * @param repositoryId    The name or ID of the repository.
     * @param gitCommitsBatch request body {@link GitCommitsBatch}.
     * @return GitCommitRefs object {@link GitCommitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public GitCommitRefs listBatch(String repositoryId, GitCommitsBatch gitCommitsBatch) throws AzDException {
        return builder()
                .POST(gitCommitsBatch)
                .location("6400dfb2-0bcb-462b-b992-5a57f8f1416c")
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitCommitRefs.class);
    }

    /**
     * Retrieve git commits for a project matching the search criteria.
     *
     * @param repositoryId         The name or ID of the repository.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @param gitCommitsBatch      request body {@link GitCommitsBatch}.
     * @return GitCommitRefs object {@link GitCommitRefs}.
     * @throws AzDException Default Api exception handler.
     */
    public GitCommitRefs listBatch(String repositoryId,
                                   GitCommitsBatch gitCommitsBatch,
                                   Consumer<CommitsBatchRequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .POST(gitCommitsBatch)
                .location("6400dfb2-0bcb-462b-b992-5a57f8f1416c")
                .serviceEndpoint("repositoryId", repositoryId)
                .query(CommitsBatchRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitCommitRefs.class);
    }

    /**
     * Retrieve a list of commits associated with a particular push. Push id is mandatory.
     *
     * @param repositoryId         id of the repository.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Array Git commit object {@link GitCommits}
     * @throws AzDException Default Api Exception handler.
     */
    public GitCommitRefs listPush(String repositoryId,
                                  Consumer<CommitsPushRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(CommitsPushRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitCommitRefs.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The maximum number of changes to return.
         */
        @QueryParameter(name = "top")
        public Number top;
        /**
         * The number of changes to skip.
         */
        @QueryParameter(name = "skip")
        public Number skip;
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
    public static class CommitsBatchGetQueryParameters {
        /**
         * The maximum number of changes to return.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * The number of changes to skip.
         */
        @QueryParameter(name = "$skip")
        public Number skip;
        /**
         * True to include additional commit status information.
         */
        @QueryParameter(name = "includeStatuses")
        public Boolean includeStatuses;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class CommitsBatchRequestConfiguration {
        public CommitsBatchGetQueryParameters queryParameters = new CommitsBatchGetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class CommitsPushGetQueryParameters {
        /**
         * The id of the push.
         */
        @QueryParameter(name = "pushId")
        public Number pushId;
        /**
         * The maximum number of changes to return.
         */
        @QueryParameter(name = "top")
        public Number top;
        /**
         * The number of changes to skip.
         */
        @QueryParameter(name = "skip")
        public Number skip;
        /**
         * True to include additional commit status information.
         */
        @QueryParameter(name = "includeLinks")
        public Boolean includeLinks;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class CommitsPushRequestConfiguration {
        public CommitsPushGetQueryParameters queryParameters = new CommitsPushGetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class GetCommitsQueryParameters {
        /**
         * Maximum number of entries to retrieve.
         */
        @QueryParameter(name = "searchCriteria.$top")
        public Number top;
        /**
         * Number of entries to skip
         */
        @QueryParameter(name = "searchCriteria.$skip")
        public Number skip;
        /**
         * Alias or display name of the author
         */
        @QueryParameter(name = "searchCriteria.author")
        public String author;
        /**
         * Version String identifier (name of tag/branch, SHA1 of commit)
         */
        @QueryParameter(name = "searchCriteria.compareVersion.version")
        public String compareVersion;

        /**
         * Version options - Specify additional modifiers to version (e.g Previous)
         */
        @QueryParameter(name = "searchCriteria.compareVersion.versionOptions")
        public GitVersionOptions compareVersionOptions;

        /**
         * Version type (branch, tag, or commit). Determines how Id is interpreted
         */
        @QueryParameter(name = "searchCriteria.compareVersion.versionType")
        public GitVersionType compareVersionType;

        /**
         * Only applies when an itemPath is specified. This determines whether to exclude delete entries of the specified path.
         */
        @QueryParameter(name = "searchCriteria.excludeDeletes")
        public Boolean excludeDeletes;

        /**
         * If provided, a lower bound for filtering commits alphabetically
         */
        @QueryParameter(name = "searchCriteria.fromCommitId")
        public String fromCommitId;

        /**
         * If provided, only include history entries created after this date (String)
         */
        @QueryParameter(name = "searchCriteria.fromDate")
        public String fromDate;

        /**
         * What Git history mode should be used. This only applies to the search criteria when Ids = null and an itemPath is specified.
         */
        @QueryParameter(name = "searchCriteria.historyMode")
        public GitHistoryMode historyMode;

        /**
         * If provided, specifies the exact commit ids of the commits to fetch. May not be combined with other parameters.
         */
        @QueryParameter(name = "searchCriteria.ids")
        public String ids;

        /**
         * Whether to include the _links field on the shallow references
         */
        @QueryParameter(name = "searchCriteria.includeLinks")
        public Boolean includeLinks;

        /**
         * Whether to include the push information
         */
        @QueryParameter(name = "searchCriteria.includePushData")
        public Boolean includePushData;

        /**
         * Whether to include the image Url for committers and authors
         */
        @QueryParameter(name = "searchCriteria.includeUserImageUrl")
        public Boolean includeUserImageUrl;

        /**
         * Whether to include linked work items
         */
        @QueryParameter(name = "searchCriteria.includeWorkItems")
        public Boolean includeWorkItems;

        /**
         * Path of item to search under
         */
        @QueryParameter(name = "searchCriteria.itemPath")
        public String itemPath;

        /**
         * Version String identifier (name of tag/branch, SHA1 of commit)
         */
        @QueryParameter(name = "searchCriteria.itemVersion.version")
        public String itemVersion;

        /**
         * Version options - Specify additional modifiers to version (e.g Previous)
         */
        @QueryParameter(name = "searchCriteria.itemVersion.versionOptions")
        public GitVersionOptions itemVersionOptions;

        /**
         * Version type (branch, tag, or commit). Determines how Id is interpreted
         */
        @QueryParameter(name = "searchCriteria.itemVersion.versionType")
        public GitVersionType itemVersionType;

        /**
         * If enabled, this option will ignore the itemVersion and compareVersion parameters
         */
        @QueryParameter(name = "searchCriteria.showOldestCommitsFirst")
        public Boolean showOldestCommitsFirst;

        /**
         * If provided, an upper bound for filtering commits alphabetically
         */
        @QueryParameter(name = "searchCriteria.toCommitId")
        public String toCommitId;

        /**
         * If provided, only include history entries created before this date (String)
         */
        @QueryParameter(name = "searchCriteria.toDate")
        public String toDate;

        /**
         * Alias or display name of the committer
         */
        @QueryParameter(name = "searchCriteria.user")
        public String user;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class CommitsRequestConfiguration {
        public GetCommitsQueryParameters queryParameters = new GetCommitsQueryParameters();
    }

}
