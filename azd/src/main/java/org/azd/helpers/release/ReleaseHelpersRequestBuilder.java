package org.azd.helpers.release;

import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.EnvironmentStatus;
import org.azd.enums.ReleaseEnvironmentStatus;
import org.azd.exceptions.AzDException;
import org.azd.release.ReleaseBaseRequestBuilder;
import org.azd.release.types.ReleaseEnvironment;
import org.azd.release.types.ReleaseEnvironmentUpdateMetadata;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class ReleaseHelpersRequestBuilder extends ReleaseBaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ReleaseHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Queue a release pipeline with release id and environment or stage name.
     *
     * @param releaseId       Id of the release
     * @param environmentName Stage name or environment name
     * @return Release Environment object {@link ReleaseEnvironment}
     * @throws AzDException Default Api Exception handler.
     */
    public ReleaseEnvironment queueRelease(int releaseId, String environmentName) throws AzDException {
        var release = releases().get(releaseId);
        boolean environment = release
                .getEnvironments()
                .stream()
                .anyMatch(x -> x.getName().equals(environmentName));

        if (environment) {
            int environmentId = release
                    .getEnvironments()
                    .stream()
                    .filter(x -> x.getName().equals(environmentName))
                    .findFirst()
                    .get()
                    .getId();

            var releaseEnvironmentUpdateMetadata = new ReleaseEnvironmentUpdateMetadata();
            releaseEnvironmentUpdateMetadata.setStatus(EnvironmentStatus.INPROGRESS);

            return releases().environment().update(environmentId, releaseId, releaseEnvironmentUpdateMetadata);
        }

        throw new AzDException("NoSuchElementException", "Given environment name '" + environmentName + "' doesn't exist.");
    }
}
