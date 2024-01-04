package org.azd.git.blobs;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.GitBlobRefFormat;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitBlobRef;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class BlobsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BlobsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "7b28e929-2c99-405d-9c5c-6167a06e6816");
    }

    /**
     * Get a single blob.
     *
     * @param repositoryId The name or ID of the repository.
     * @param sha1         SHA1 hash of the file. You can get the SHA1 of a file using the "Git/Items/Get Item" endpoint.
     * @return GitBlobRef Object {@link GitBlobRef}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<GitBlobRef> getAsync(String repositoryId, String sha1) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("sha1", sha1)
                .build()
                .executeAsync(GitBlobRef.class);
    }

    /**
     * Get a single blob.
     *
     * @param repositoryId         The name or ID of the repository.
     * @param sha1                 SHA1 hash of the file. You can get the SHA1 of a file using the "Git/Items/Get Item" endpoint.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return GitBlobRef Object {@link GitBlobRef}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<InputStream> getAsync(String repositoryId, String sha1,
                                                   Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("sha1", sha1)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeStreamAsync();
    }

    /**
     * Gets one or more blobs in a zip file download.
     *
     * @param repositoryId The name or ID of the repository.
     * @throws AzDException Default Api Exception handler.
     **/


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Options: json, zip, text, octetstream.
         * If not set, defaults to the MIME type set in the Accept header which is "application/json".
         */
        @QueryParameter(name = "$format")
        public GitBlobRefFormat format;
        /**
         * If true, prompt for a download rather than rendering in a browser.
         * Note: this value defaults to true if format is zip.
         */
        @QueryParameter(name = "download")
        public Boolean download;
        /**
         * If true, try to resolve a blob to its LFS contents, if it's an LFS pointer file.
         * Only compatible with octet-stream Accept headers or $format types
         */
        @QueryParameter(name = "resolveLfs")
        public Boolean resolveLfs;
        /**
         * Provide a fileName to use for a download.
         */
        @QueryParameter(name = "fileName")
        public String fileName;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
