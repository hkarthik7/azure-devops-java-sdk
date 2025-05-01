package org.azd.build.artifacts;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildArtifact;
import org.azd.build.types.BuildArtifacts;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides the functionality to manage Build Artifacts Api.
 */
public class ArtifactsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ArtifactsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "1db06c96-014e-44e1-ac91-90b2d4b3e984", ApiVersion.BUILD_ARTIFACTS);
    }

    /**
     * Associates an artifact with a build.
     *
     * @param buildId       The ID of the build.
     * @param buildArtifact Build artifact to associate.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<BuildArtifact> createAsync(int buildId, BuildArtifact buildArtifact) throws AzDException {
        return postRequestBuilder(buildId, buildArtifact)
                .build()
                .executeAsync(BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build.
     *
     * @param buildId      The ID of the build.
     * @param artifactName The name of the artifact.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<BuildArtifact> getAsync(int buildId, String artifactName) throws AzDException {
        return getRequestBuilder(buildId, artifactName)
                .build()
                .executeAsync(BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build as a zip file.
     *
     * @param buildId      The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<InputStream> getAsZipAsync(int buildId, String artifactName) throws AzDException {
        return getRequestBuilder(buildId, artifactName)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Gets a file from the build. Returns the file contents as InputStream and {@link org.azd.helpers.StreamHelper}
     * can be used to download the file.
     *
     * @param buildId      The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<InputStream> getFileAsync(int buildId, String artifactName,
                                                       Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return getRequestBuilder(buildId, artifactName)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Gets all artifacts for a build.
     *
     * @param buildId The ID of the build.
     * @return BuildArtifacts future Object {@link BuildArtifacts}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<BuildArtifacts> listAsync(int buildId) throws AzDException {
        return getRequestBuilder(buildId, null)
                .build()
                .executeAsync(BuildArtifacts.class);
    }

    /**
     * Associates an artifact with a build.
     *
     * @param buildId       The ID of the build.
     * @param buildArtifact Build artifact to associate.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public BuildArtifact create(int buildId, BuildArtifact buildArtifact) throws AzDException {
        return postRequestBuilder(buildId, buildArtifact).build()
                .execute(BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build.
     *
     * @param buildId      The ID of the build.
     * @param artifactName The name of the artifact.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public BuildArtifact get(int buildId, String artifactName) throws AzDException {
        return getRequestBuilder(buildId, artifactName).build()
                .execute(BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build as a zip file.
     *
     * @param buildId      The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public InputStream getAsZip(int buildId, String artifactName) throws AzDException {
        return getRequestBuilder(buildId, artifactName)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Gets a file from the build. Returns the file contents as InputStream and {@link org.azd.helpers.StreamHelper}
     * can be used to download the file.
     *
     * @param buildId      The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public InputStream getFile(int buildId, String artifactName,
                               Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return getRequestBuilder(buildId, artifactName)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .header(CustomHeader.STREAM_ACCEPT)
                .build()
                .executeStream();
    }

    /**
     * Gets all artifacts for a build.
     *
     * @param buildId The ID of the build.
     * @return BuildArtifacts future Object {@link BuildArtifacts}
     * @throws AzDException Default Api Exception handler.
     **/
    public BuildArtifacts list(int buildId) throws AzDException {
        return getRequestBuilder(buildId, null)
                .build()
                .execute(BuildArtifacts.class);
    }

    /**
     * Constructs the request information for Build Artifacts Api.
     *
     * @param buildId      ID of the build.
     * @param artifactName Build artifact name.
     * @return ClientRequest Builder {@link ClientRequest.Builder}
     */
    private ClientRequest.Builder getRequestBuilder(int buildId, String artifactName) {
        var builder = builder()
                .serviceEndpoint("buildId", buildId);
        if (artifactName != null) builder.query("artifactName", artifactName);
        return builder;
    }

    /**
     * Constructs the request information for Build Artifacts Api.
     *
     * @param buildId       ID of the build.
     * @param buildArtifact BuildArtifact object.
     * @return ClientRequest Builder {@link ClientRequest.Builder}
     */
    private ClientRequest.Builder postRequestBuilder(int buildId, BuildArtifact buildArtifact) {
        return builder()
                .POST(buildArtifact)
                .serviceEndpoint("buildId", buildId);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The primary key for the file.
         */
        @QueryParameter(name = "fileId")
        public String fileId;
        /**
         * The name that the file will be set to.
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
