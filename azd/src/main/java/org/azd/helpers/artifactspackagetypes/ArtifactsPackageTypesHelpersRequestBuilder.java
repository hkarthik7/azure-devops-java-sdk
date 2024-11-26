package org.azd.helpers.artifactspackagetypes;

import org.azd.abstractions.internals.LocationService;
import org.azd.artifactspackagetypes.ArtifactsPackageTypesRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.common.Constants;
import org.azd.enums.Instance;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.utils.PathBuilder;

import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static org.azd.utils.RestClient.send;

/**
 * Helper request builder that combines multiple Apis to create logical helper methods for ease of use.
 */
public class ArtifactsPackageTypesHelpersRequestBuilder extends ArtifactsPackageTypesRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ArtifactsPackageTypesHelpersRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Fulfills Maven package file upload requests by either returning the URL
     * of the requested package file or, in the case of Azure DevOps Server (OnPrem),
     *
     * @param feedId     Name or ID of the feed. Example: "mavenfeed".
     * @param groupId    Group ID of the package. Example: "com.example".
     * @param artifactId Artifact ID of the package. Example: "app".
     * @param version    Version of the package. Example: "1.0.0".
     * @param fileName   File name to upload. Must include artifactId Example: "app-1.0.0.jar".
     * @param content    InputStream for the package file.
     * @throws AzDException Default Api Exception handler.
     */
    public Void uploadPackage(String feedId, String groupId, String artifactId, String version, String fileName, InputStream content)
            throws AzDException {
            String path = PathBuilder.from(groupId)
                    .append(artifactId)
                    .append(version)
                    .append(fileName)
                    .build();

            return builder()
                    .PUT(content)
                    .area("maven")
                    .location("f285a171-0df5-4c49-aaf2-17d0d37d9f0e")
                    .serviceEndpoint("feed", feedId)
                    .serviceEndpoint("path", path)
                    .build()
                    .executePrimitive();
    }
}
