package org.azd.release.releases;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Release releases Api.
 */
public class ReleaseLogsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ReleaseLogsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "c37fbab5-214b-48e4-a55b-cb6b4f6e4038", ApiVersion.RELEASE_LOGS);
    }

    /**
     * Get logs for a release Id.
     *
     * <br /><br />Example:
     * <br />
     * <pre>{@code
     *          // Create AzDServiceClient object first.
     *          var logs = client.release().releases().logs().getAsync(1234).join(); // release Id
     *         StreamHelper.download("logs.zip", logs);
     * }</pre>
     * @param releaseId Id of the release.
     * @return Input stream of logs. Use {@link org.azd.helpers.StreamHelper} to download the logs.
     * @throws AzDException
     */
    public CompletableFuture<InputStream> getAsync(int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStreamAsync();
    }

    /**
     * Get logs for a release Id.
     *
     * <br /><br />Example:
     * <br />
     * <pre>{@code
     *          // Create AzDServiceClient object first.
     *          var logs = client.release().releases().logs().get(1234); // release Id
     *         StreamHelper.download("logs.zip", logs);
     * }</pre>
     * @param releaseId Id of the release.
     * @return Input stream of logs. Use {@link org.azd.helpers.StreamHelper} to download the logs.
     * @throws AzDException
     */
    public InputStream get(int releaseId) throws AzDException {
        return builder()
                .serviceEndpoint("releaseId", releaseId)
                .header(CustomHeader.STREAM_ZIP_ACCEPT)
                .build()
                .executeStream();
    }
}
