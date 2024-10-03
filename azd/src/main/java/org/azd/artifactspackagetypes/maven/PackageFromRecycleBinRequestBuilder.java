package org.azd.artifactspackagetypes.maven;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.artifactspackagetypes.types.MavenPackagesBatchRequest;
import org.azd.artifactspackagetypes.types.MavenRecycleBinPackageVersionDetails;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.maven.types.MavenPackageVersionDeletionState;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class PackageFromRecycleBinRequestBuilder extends BaseRequestBuilder {
    public PackageFromRecycleBinRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "maven", "f67e10eb-1254-4953-add7-d49b83a16c9f", ApiVersion.MAVEN);
    }

    /**
     * Permanently delete a package from a feed's recycle bin.
     *
     * @param pathParameters Pass the package path parameters to delete the artifact.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> deleteAsync(Consumer<PackagePathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new PackagePathParameters();
        pathParameters.accept(values);

        return builder()
                .DELETE()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feed, "Feed name or ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID is mandatory."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version is mandatory."))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get information about a package version in the recycle bin.
     *
     * @param pathParameters Pass the package path parameters to get the artifact.
     * @return MavenPackageVersionDeletionState {@link MavenPackageVersionDeletionState}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<MavenPackageVersionDeletionState> getAsync(Consumer<PackagePathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new PackagePathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feed, "Feed name or ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID is mandatory."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version is mandatory."))
                .build()
                .executeAsync(MavenPackageVersionDeletionState.class);
    }

    /**
     * Get information about a package version in the recycle bin.
     *
     * @param pathParameters                  Pass the package path parameters to restore the artifact.
     * @param recycleBinPackageVersionDetails Set the deleted property as false to restore the package.
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<Void> restoreAsync(MavenRecycleBinPackageVersionDetails recycleBinPackageVersionDetails,
                                                Consumer<PackagePathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new PackagePathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(recycleBinPackageVersionDetails)
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feed, "Feed name or ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID is mandatory."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version is mandatory."))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Delete or restore several package versions from the recycle bin.
     *
     * @param feedId       ID of the feed.
     * @param batchRequest Maven batch request with package details to delete or restore the packages.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(String feedId, MavenPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("5dd6f547-c76f-4d9d-b2ec-4720feda641f")
                .serviceEndpoint("feed", feedId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Permanently delete a package from a feed's recycle bin.
     *
     * @param pathParameters Pass the package path parameters to delete the artifact.
     * @throws AzDException Default Api Exception handler.
     **/
    public Void delete(Consumer<PackagePathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new PackagePathParameters();
        pathParameters.accept(values);

        return builder()
                .DELETE()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feed, "Feed name or ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID is mandatory."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version is mandatory."))
                .build()
                .executePrimitive();
    }

    /**
     * Get information about a package version in the recycle bin.
     *
     * @param pathParameters Pass the package path parameters to get the artifact.
     * @return MavenPackageVersionDeletionState {@link MavenPackageVersionDeletionState}
     * @throws AzDException Default Api Exception handler.
     **/
    public MavenPackageVersionDeletionState get(Consumer<PackagePathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new PackagePathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feed, "Feed name or ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID is mandatory."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version is mandatory."))
                .build()
                .execute(MavenPackageVersionDeletionState.class);
    }

    /**
     * Get information about a package version in the recycle bin.
     *
     * @param pathParameters                  Pass the package path parameters to get the artifact.
     * @param recycleBinPackageVersionDetails Set the deleted property as false to restore the package.
     * @throws AzDException Default Api Exception handler.
     **/
    public Void restore(MavenRecycleBinPackageVersionDetails recycleBinPackageVersionDetails,
                        Consumer<PackagePathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new PackagePathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(recycleBinPackageVersionDetails)
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feed, "Feed name or ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID is mandatory."))
                .serviceEndpoint("version", Objects.requireNonNull(values.version, "Version is mandatory."))
                .build()
                .executePrimitive();
    }

    /**
     * Delete or restore several package versions from the recycle bin.
     *
     * @param feedId       ID of the feed.
     * @param batchRequest Maven batch request with package details to delete or restore the packages.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(String feedId, MavenPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("5dd6f547-c76f-4d9d-b2ec-4720feda641f")
                .serviceEndpoint("feed", feedId)
                .build()
                .executePrimitive();
    }

    /**
     * Represents path parameters.
     */
    public static class PackagePathParameters {
        /**
         * ArtifactId of the maven package
         */
        public String artifactId;
        /**
         * Name or ID of the feed.
         */
        public String feed;
        /**
         * GroupId of the maven package
         */
        public String groupId;
        /**
         * Version of the package
         */
        public String version;
    }
}
