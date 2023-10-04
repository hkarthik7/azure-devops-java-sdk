package org.azd.build.artifacts;

import org.azd.build.types.BuildArtifact;
import org.azd.build.types.BuildArtifacts;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.http.RequestInformation;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/**
 * Provides the functionality to manage Build Artifacts Api.
 */
public class ArtifactsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new ArtifactsRequestBuilder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ArtifactsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds/", ApiVersion.BUILD_ARTIFACTS);
    }

    /**
     * Associates an artifact with a build.
     *
     * @param buildId The ID of the build.
     * @param buildArtifact Build artifact to associate.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<BuildArtifact> createAsync(int buildId, BuildArtifact buildArtifact) throws AzDException {
        return requestAdapter.sendAsync(toPostInformation(buildId, buildArtifact), BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<BuildArtifact> getAsync(int buildId, String artifactName) throws AzDException {
        return requestAdapter.sendAsync(toGetInformation(buildId, artifactName), BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build as a zip file.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<InputStream> getAsZipAsync(int buildId, String artifactName) throws AzDException {
        var reqInfo = toGetInformation(buildId, artifactName);
        reqInfo.requestHeaders.add(CustomHeader.STREAM_ZIP_ACCEPT);
        return requestAdapter.sendStreamAsync(reqInfo);
    }

    /**
     * Gets a file from the build. Returns the file contents as InputStream and {@link org.azd.helpers.StreamHelper}
     * can be used to download the file.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<InputStream> getFileAsync(int buildId, String artifactName, String fileId,
                                                       String fileName) throws AzDException {
        var reqInfo = toGetInformation(buildId, artifactName);
        reqInfo.requestHeaders.add(CustomHeader.STREAM_ACCEPT);
        reqInfo.setQueryParameter("fileId", fileId);
        reqInfo.setQueryParameter("fileName", fileName);
        return requestAdapter.sendStreamAsync(reqInfo);
    }

    /**
     * Gets all artifacts for a build.
     *
     * @param buildId The ID of the build.
     * @return BuildArtifacts future Object {@link BuildArtifacts}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<BuildArtifacts> listAsync(int buildId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        return requestAdapter.sendAsync(reqInfo, BuildArtifacts.class);
    }

    /**
     * Associates an artifact with a build.
     *
     * @param buildId The ID of the build.
     * @param buildArtifact Build artifact to associate.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public BuildArtifact create(int buildId, BuildArtifact buildArtifact) throws AzDException {
        return requestAdapter.send(toPostInformation(buildId, buildArtifact), BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return BuildArtifact future Object {@link BuildArtifact}
     * @throws AzDException Default Api Exception handler.
     **/
    public BuildArtifact get(int buildId, String artifactName) throws AzDException {
        return requestAdapter.send(toGetInformation(buildId, artifactName), BuildArtifact.class);
    }

    /**
     * Gets a specific artifact for a build as a zip file.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public InputStream getAsZip(int buildId, String artifactName) throws AzDException {
        var reqInfo = toGetInformation(buildId, artifactName);
        reqInfo.requestHeaders.add(CustomHeader.STREAM_ZIP_ACCEPT);
        return requestAdapter.sendStream(reqInfo);
    }

    /**
     * Gets a file from the build. Returns the file contents as InputStream and {@link org.azd.helpers.StreamHelper}
     * can be used to download the file.
     *
     * @param buildId The ID of the build.
     * @param artifactName The name of the artifact.
     * @return Input stream future response of artifact
     * @throws AzDException Default Api Exception handler.
     **/
    public InputStream getFile(int buildId, String artifactName, String fileId,
                               String fileName) throws AzDException {
        var reqInfo = toGetInformation(buildId, artifactName);
        reqInfo.requestHeaders.add(CustomHeader.STREAM_ACCEPT);
        reqInfo.setQueryParameter("fileId", fileId);
        reqInfo.setQueryParameter("fileName", fileName);
        return requestAdapter.sendStream(reqInfo);
    }

    /**
     * Gets all artifacts for a build.
     *
     * @param buildId The ID of the build.
     * @return BuildArtifacts future Object {@link BuildArtifacts}
     * @throws AzDException Default Api Exception handler.
     **/
    public BuildArtifacts list(int buildId) throws AzDException {
        var reqInfo = toGetInformation(buildId, null);
        return requestAdapter.send(reqInfo, BuildArtifacts.class);
    }

    /**
     * Constructs the request information for Build Artifacts Api.
     * @param buildId ID of the build.
     * @param artifactName Build artifact name.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toGetInformation(int buildId, String artifactName) {
        var requestInfo = toGetRequestInformation();
        requestInfo.serviceEndpoint = service + buildId + "/artifacts";
        if (artifactName != null) {
            requestInfo.setQueryParameter("artifactName", artifactName);
        }
        return requestInfo;
    }

    /**
     * Constructs the request information for Build Artifacts Api.
     * @param buildId ID of the build.
     * @param buildArtifact BuildArtifact object.
     * @return RequestInformation object {@link RequestInformation}
     */
    private RequestInformation toPostInformation(int buildId, BuildArtifact buildArtifact) {
        var requestInfo = toPostRequestInformation(buildArtifact);
        requestInfo.serviceEndpoint = service + buildId + "/artifacts";
        return requestInfo;
    }
}
