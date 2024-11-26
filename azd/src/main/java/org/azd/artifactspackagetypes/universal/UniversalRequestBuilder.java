package org.azd.artifactspackagetypes.universal;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.artifactspackagetypes.ArtifactsPackageTypesRequestBuilder;
import org.azd.artifactspackagetypes.maven.PackageFromRecycleBinRequestBuilder;
import org.azd.artifactspackagetypes.types.PackageVersionDetails;
import org.azd.artifactspackagetypes.types.UPackPackagesBatchRequest;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.upack.types.Package;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UniversalRequestBuilder extends BaseRequestBuilder {
    public UniversalRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "upack", "72f61ca4-e07c-4eca-be75-6c0b2f3f4051", ApiVersion.UPACK);
    }

    /**
     * Provides functionality to manage Package version from recycle bin Api.
     *
     * @return UniversalPackageFromRecycleBinRequestBuilder {@link UniversalPackageFromRecycleBinRequestBuilder}
     */
    public UniversalPackageFromRecycleBinRequestBuilder recycleBin() {
        return new UniversalPackageFromRecycleBinRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Delete a package version from a feed's recycle bin.
     *
     * @param pathParameters Represents the path parameters to delete artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(Consumer<UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .DELETE()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Show information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Package> getAsync(Consumer<UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .executeAsync(Package.class);
    }

    /**
     * Show information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @param showDeleted    Specify to include the deleted packages.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Package> getAsync(Consumer<UPackPathParameters> pathParameters,
                                               Predicate<ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate> showDeleted)
            throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        final var config = new ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate();

        return builder()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .query("showDeleted", showDeleted != null && showDeleted.test(config))
                .build()
                .executeAsync(Package.class);
    }

    /**
     * Update information for a package version.
     *
     * @param pathParameters        Represents the path parameters to update artifact.
     * @param packageVersionDetails package version details to update.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(Consumer<UPackPathParameters> pathParameters,
                                               PackageVersionDetails packageVersionDetails) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(packageVersionDetails)
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Update several packages from a single feed in a single request. The updates to the packages do not happen atomically.
     *
     * @param feedId       Name of ID of the feed.
     * @param batchRequest UPack batch request with package details to update.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> updateAsync(String feedId, UPackPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("c17e81ae-4caa-4d8b-a431-6b329e890281")
                .serviceEndpoint("feed", feedId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Delete a package version from a feed's recycle bin.
     *
     * @param pathParameters Represents the path parameters to delete artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(Consumer<UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .DELETE()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .executePrimitive();
    }

    /**
     * Show information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public Package get(Consumer<UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .execute(Package.class);
    }

    /**
     * Show information about a package version.
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @param showDeleted    Specify to include the deleted packages.
     * @throws AzDException Default Api Exception handler.
     */
    public Package get(Consumer<UPackPathParameters> pathParameters,
                       Predicate<ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate> showDeleted)
            throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        final var config = new ArtifactsPackageTypesRequestBuilder.DeletedPackagePredicate();

        return builder()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .query("showDeleted", showDeleted != null && showDeleted.test(config))
                .build()
                .execute(Package.class);
    }

    /**
     * Update information for a package version.
     *
     * @param pathParameters        Represents the path parameters to update artifact.
     * @param packageVersionDetails package version details to update.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(Consumer<UPackPathParameters> pathParameters,
                       PackageVersionDetails packageVersionDetails) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(packageVersionDetails)
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .executePrimitive();
    }

    /**
     * Update several packages from a single feed in a single request. The updates to the packages do not happen atomically.
     *
     * @param feedId       Name of ID of the feed.
     * @param batchRequest UPack batch request with package details to update.
     * @throws AzDException Default Api Exception handler.
     */
    public Void update(String feedId, UPackPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("c17e81ae-4caa-4d8b-a431-6b329e890281")
                .serviceEndpoint("feed", feedId)
                .build()
                .executePrimitive();
    }


    /**
     * Represents the Path values for Maven Api.
     */
    public static class UPackPathParameters {
        /**
         * Name or ID of the feed.
         */
        public String feedId;
        /**
         * Version of the package
         */
        public String packageVersion;
        /**
         * Name of the package
         */
        public String packageName;
    }
}
