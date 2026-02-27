package org.azd.artifactspackagetypes.maven;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.artifactspackagetypes.ArtifactsPackageTypesRequestBuilder;
import org.azd.artifactspackagetypes.types.MavenPackagesBatchRequest;
import org.azd.artifactspackagetypes.types.Package;
import org.azd.artifactspackagetypes.types.PackageVersionDetails;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;
import org.azd.helpers.StreamHelper;

import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Provides functionality to work with Azure DevOps Graph Api.
 */
public class MavenRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public MavenRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "maven", "180ed967-377a-4112-986b-607adb14ded4", ApiVersion.MAVEN);
    }

    /**
     * Provides functionality to manage Package version from recycle bin Api.
     *
     * @return PackageFromRecycleBinRequestBuilder {@link PackageFromRecycleBinRequestBuilder}
     */
    public PackageFromRecycleBinRequestBuilder recycleBin() {
        return new PackageFromRecycleBinRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Package version from upstreaming behaviour Api.
     *
     * @return UpstreamingBehaviorRequestBuilder {@link UpstreamingBehaviorRequestBuilder}
     */
    public UpstreamingBehaviorRequestBuilder upstreamingBehavior() {
        return new UpstreamingBehaviorRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Fulfills Maven package file download requests by either returning the URL of the requested package file or,
     * in the case of Azure DevOps Server (OnPrem), returning the content as a stream.
     *
     * @param pathParameters Represents the path parameters to download artifact.
     * @return Input stream of the artifact. Use {@link StreamHelper} and download(filename, inputStream) to download the artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<InputStream> downloadAsync(Consumer<MavenPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .location("c338d4b5-d30a-47e2-95b7-f157ef558833")
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .serviceEndpoint("fileName", Objects.requireNonNull(values.fileName, "File name cannot be null."))
                .header(CustomHeader.STREAM)
                .build()
                .executeStreamAsync();
    }

    /**
     * Delete a package version from the feed and move it to the feed's recycle bin.
     *
     * @param pathParameters Represents the path parameters to delete artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(Consumer<MavenPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .DELETE()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @return Package object {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Package> getAsync(Consumer<MavenPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .build()
                .executeAsync(Package.class);
    }

    /**
     * Get information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @param showDeleted    Specify to include the deleted packages.
     *                       <strong>Example:</strong>
     *                       <pre>{@code
     *                       client.artifactsPackageTypes().maven().getAsync(r -> {
     *                          r.artifactId = "MyPackage";
     *                          r.groupId = "org.example.com";
     *                          r.feedId = "ID of the feed";
     *                          r.version = "1.0.0";
     *                       }, x -> x.showDeleted).join());
     *                       }</pre>
     * @return Package object {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Package> getAsync(Consumer<MavenPathParameters> pathParameters,
                                               Predicate<ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate> showDeleted)
            throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        final var config = new ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate();

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .query("showDeleted", showDeleted != null && showDeleted.test(config))
                .build()
                .executeAsync(Package.class);
    }

    /**
     * Update state for a package version.
     *
     * @param pathParameters        Represents the path parameters to update artifact.
     * @param packageVersionDetails package version details to update.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(Consumer<MavenPathParameters> pathParameters,
                                               PackageVersionDetails packageVersionDetails) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(packageVersionDetails)
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Update several packages from a single feed in a single request. The updates to the packages do not happen atomically.
     *
     * @param feedId       Feed which contains the packages to update.
     * @param batchRequest Maven batch request with package details to update the packages.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(String feedId, MavenPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("b7c586b0-d947-4d35-811a-f1161de80e6c")
                .serviceEndpoint("feedId", feedId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Fulfills Maven package file download requests by either returning the URL of the requested package file or,
     * in the case of Azure DevOps Server (OnPrem), returning the content as a stream.
     *
     * @param pathParameters Represents the path parameters to download artifact.
     * @return Input stream of the artifact. Use {@link StreamHelper} and download(filename, inputStream) to download the artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public InputStream download(Consumer<MavenPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .location("c338d4b5-d30a-47e2-95b7-f157ef558833")
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .serviceEndpoint("fileName", Objects.requireNonNull(values.fileName, "File name cannot be null."))
                .build()
                .executeStream();
    }

    /**
     * Delete a package version from the feed and move it to the feed's recycle bin.
     *
     * @param pathParameters Represents the path parameters to delete artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(Consumer<MavenPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .DELETE()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .build()
                .executePrimitive();
    }

    /**
     * Get information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @return Package object {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    public Package get(Consumer<MavenPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .build()
                .execute(Package.class);
    }

    /**
     * Get information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @param showDeleted    Specify to include the deleted packages.
     *                       <strong>Example:</strong>
     *                       <pre>{@code
     *                       client.artifactsPackageTypes().maven().get(r -> {
     *                          r.artifactId = "MyPackage";
     *                          r.groupId = "org.example.com";
     *                          r.feedId = "ID of the feed";
     *                          r.version = "1.0.0";
     *                       }, x -> x.showDeleted).join());
     *                       }</pre>
     * @return Package object {@link Package}
     * @throws AzDException Default Api Exception handler.
     */
    public Package get(Consumer<MavenPathParameters> pathParameters,
                       Predicate<ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate> showDeleted) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        final var config = new ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate();

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .query("showDeleted", showDeleted != null && showDeleted.test(config))
                .build()
                .execute(Package.class);
    }

    /**
     * Update state for a package version.
     *
     * @param pathParameters        Represents the path parameters to update artifact.
     * @param packageVersionDetails package version details to update.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(Consumer<MavenPathParameters> pathParameters,
                       PackageVersionDetails packageVersionDetails) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new MavenPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(packageVersionDetails)
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version of the artifact is mandatory."))
                .build()
                .executePrimitive();
    }

    /**
     * Update several packages from a single feed in a single request. The updates to the packages do not happen atomically.
     *
     * @param feedId       Feed which contains the packages to update.
     * @param batchRequest Maven batch request with package details to update the packages.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(String feedId, MavenPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("b7c586b0-d947-4d35-811a-f1161de80e6c")
                .serviceEndpoint("feedId", feedId)
                .build()
                .executePrimitive();
    }

    /**
     * Represents the Path values for Maven Api.
     */
    public static class MavenPathParameters {
        /**
         * ArtifactId of the maven package.
         */
        public String artifactId;
        /**
         * GroupId of the maven package
         */
        public String groupId;
        /**
         * Name or ID of the feed.
         */
        public String feedId;
        /**
         * Version of the package
         */
        public String version;
        /**
         * File name to download
         */
        public String fileName;
    }
}
