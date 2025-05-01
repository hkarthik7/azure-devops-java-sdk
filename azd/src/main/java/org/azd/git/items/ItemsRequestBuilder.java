package org.azd.git.items;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.enums.GitVersionOptions;
import org.azd.enums.GitVersionType;
import org.azd.enums.VersionControlRecursionType;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitItem;
import org.azd.git.types.GitItemRequestData;
import org.azd.git.types.GitItems;
import org.azd.git.types.GitItemsList;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to build requests for managing Git Items Api.
 */
public class ItemsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ItemsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "fb93c0db-47ed-4a31-8c20-47552878fb44", ApiVersion.GIT_ITEMS);
    }

    /**
     * Get Item Metadata and/or Content for a single item.
     *
     * @param repositoryId The name or ID of the repository.
     * @param path         The item path.
     * @return Future of Git item object {@link GitItem}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitItem> getAsync(String repositoryId, String path) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query("path", path)
                .build()
                .executeAsync(GitItem.class);
    }

    /**
     * Get Item Metadata and/or Content for a single item. The download parameter is to indicate whether
     * the content should be available as a download or just sent as a stream in the response.
     * Doesn't apply to zipped content, which is always returned as a download.
     *
     * @param repositoryId         The name or ID of the repository.
     * @param path                 The item path.
     * @param requestConfiguration Request configuration of query parameters.
     * @return Item as plain text.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<String> getAsTextAsync(String repositoryId, String path, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query("path", path)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeStringAsync();
    }

    /**
     * Get Item Metadata and/or Content for a single item. The download parameter is to indicate whether
     * the content should be available as a download or just sent as a stream in the response.
     * Doesn't apply to zipped content, which is always returned as a download.
     *
     * @param repositoryId         The name or ID of the repository.
     * @param path                 The item path.
     * @param requestConfiguration Request configuration of query parameters.
     * @return Item as plain text.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<InputStream> getAsZipAsync(String repositoryId, String path, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query("path", path)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Post for retrieving a creating a batch out of a set of items in a repo / project given a list of paths or a long path
     *
     * @param gitItemRequestData Request data to get the items in batch.
     * @param repositoryId       The name or ID of the repository
     * @return List of GitItems.
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitItemsList> getBatchAsync(GitItemRequestData gitItemRequestData, String repositoryId) throws AzDException {
        return builder()
                .POST(gitItemRequestData)
                .location("630fd2e4-fb88-4f85-ad21-13f3fd1fbca9")
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitItemsList.class);

    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryId The name or ID of the repository
     * @return Git items {@link GitItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitItems> listAsync(String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitItems.class);
    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryId         The name or ID of the repository
     * @param requestConfiguration Represents the query parameters
     * @return Git items {@link GitItems}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<GitItems> listAsync(String repositoryId,
                                                 Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(GitItems.class);
    }

    /**
     * Get Item Metadata and/or Content for a single item.
     *
     * @param repositoryId The name or ID of the repository.
     * @param path         The item path.
     * @return Future of Git item object {@link GitItem}
     * @throws AzDException Default Api exception handler.
     */
    public GitItem get(String repositoryId, String path) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query("path", path)
                .build()
                .execute(GitItem.class);
    }

    /**
     * Get Item Metadata and/or Content for a single item. The download parameter is to indicate whether
     * the content should be available as a download or just sent as a stream in the response.
     * Doesn't apply to zipped content, which is always returned as a download.
     *
     * @param repositoryId         The name or ID of the repository.
     * @param path                 The item path.
     * @param requestConfiguration Request configuration of query parameters.
     * @return Item as plain text.
     * @throws AzDException Default Api exception handler.
     */
    public String getAsText(String repositoryId, String path, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query("path", path)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.TEXT_CONTENT)
                .build()
                .executeString();
    }

    /**
     * Get Item Metadata and/or Content for a single item. The download parameter is to indicate whether
     * the content should be available as a download or just sent as a stream in the response.
     * Doesn't apply to zipped content, which is always returned as a download.
     *
     * @param repositoryId         The name or ID of the repository.
     * @param path                 The item path.
     * @param requestConfiguration Request configuration of query parameters.
     * @return Item as plain text.
     * @throws AzDException Default Api exception handler.
     */
    public InputStream getAsZip(String repositoryId, String path, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query("path", path)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Post for retrieving a creating a batch out of a set of items in a repo / project given a list of paths or a long path
     *
     * @param gitItemRequestData Request data to get the items in batch.
     * @param repositoryId       The name or ID of the repository
     * @return List of GitItems.
     * @throws AzDException Default Api exception handler.
     */
    public GitItemsList getBatch(GitItemRequestData gitItemRequestData, String repositoryId) throws AzDException {
        return builder()
                .POST(gitItemRequestData)
                .location("630fd2e4-fb88-4f85-ad21-13f3fd1fbca9")
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitItemsList.class);

    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryId The name or ID of the repository
     * @return Git items {@link GitItems}
     * @throws AzDException Default Api exception handler.
     */
    public GitItems list(String repositoryId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitItems.class);
    }

    /**
     * Get Item Metadata and/or Content for a collection of items.
     *
     * @param repositoryId         The name or ID of the repository
     * @param requestConfiguration Represents the query parameters
     * @return Git items {@link GitItems}
     * @throws AzDException Default Api exception handler.
     */
    public GitItems list(String repositoryId,
                         Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(GitItems.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Set to true to download the response as a file. Default is false.
         */
        @QueryParameter(name = "download")
        public Boolean download;
        /**
         * Set to true to include item content when requesting json. Default is false.
         */
        @QueryParameter(name = "includeContent")
        public Boolean includeContent;
        /**
         * Set to true to include content metadata. Default is false.
         */
        @QueryParameter(name = "includeContentMetadata")
        public Boolean includeContentMetadata;
        /**
         * Set to true to include the latest changes. Default is false.
         */
        @QueryParameter(name = "latestProcessedChange")
        public Boolean latestProcessedChange;
        /**
         * The recursion level of this request. The default is 'none', no recursion.
         */
        @QueryParameter(name = "recursionLevel")
        public VersionControlRecursionType recursionLevel;
        /**
         * Set to true to resolve Git LFS pointer files to return actual content from Git LFS. Default is false.
         */
        @QueryParameter(name = "resolveLfs")
        public Boolean resolveLfs;
        /**
         * Set to true to sanitize an svg file and return it as image. Useful only if requested for svg file. Default is false.
         */
        @QueryParameter(name = "sanitize")
        public Boolean sanitize;
        /**
         * The path scope. The default is null.
         */
        @QueryParameter(name = "scopePath")
        public String scopePath;
        /**
         * Version string identifier (name of tag/branch, SHA1 of commit)
         */
        @QueryParameter(name = "versionDescriptor.version")
        public String version;
        /**
         * Version options - Specify additional modifiers to version (e.g Previous)
         */
        @QueryParameter(name = "versionDescriptor.versionOptions")
        public GitVersionOptions versionOptions;
        /**
         * Version type (branch, tag, or commit). Determines how Id is interpreted
         */
        @QueryParameter(name = "versionDescriptor.versionType")
        public GitVersionType versionType;
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
         * Set to true to download the response as a file. Default is false.
         */
        @QueryParameter(name = "download")
        public Boolean download;
        /**
         * Set to true to include item content when requesting json. Default is false.
         */
        @QueryParameter(name = "includeContent")
        public Boolean includeContent;
        /**
         * Set to true to include content metadata. Default is false.
         */
        @QueryParameter(name = "includeContentMetadata")
        public Boolean includeContentMetadata;
        /**
         * Set to true to include the latest changes. Default is false.
         */
        @QueryParameter(name = "latestProcessedChange")
        public Boolean latestProcessedChange;
        /**
         * The recursion level of this request. The default is 'none', no recursion.
         */
        @QueryParameter(name = "recursionLevel")
        public VersionControlRecursionType recursionLevel;
        /**
         * Set to true to resolve Git LFS pointer files to return actual content from Git LFS. Default is false.
         */
        @QueryParameter(name = "resolveLfs")
        public Boolean resolveLfs;
        /**
         * Set to true to sanitize an svg file and return it as image. Useful only if requested for svg file. Default is false.
         */
        @QueryParameter(name = "sanitize")
        public Boolean sanitize;
        /**
         * The path scope. The default is null.
         */
        @QueryParameter(name = "scopePath")
        public String scopePath;
        /**
         * Version string identifier (name of tag/branch, SHA1 of commit)
         */
        @QueryParameter(name = "versionDescriptor.version")
        public String version;
        /**
         * Version options - Specify additional modifiers to version (e.g Previous)
         */
        @QueryParameter(name = "versionDescriptor.versionOptions")
        public GitVersionOptions versionOptions;
        /**
         * Version type (branch, tag, or commit). Determines how Id is interpreted
         */
        @QueryParameter(name = "versionDescriptor.versionType")
        public GitVersionType versionType;
        /**
         * Set to true to keep the file permissions for unix (and POSIX) systems like executables and symlinks
         */
        @QueryParameter(name = "zipForUnix")
        public Boolean zipForUnix;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }

}
