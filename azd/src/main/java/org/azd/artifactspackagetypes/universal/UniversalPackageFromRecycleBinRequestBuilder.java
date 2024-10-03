package org.azd.artifactspackagetypes.universal;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.artifactspackagetypes.types.UPackPackagesBatchRequest;
import org.azd.artifactspackagetypes.types.UPackRecycleBinPackageVersionDetails;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.upack.types.UPackPackageVersionDeletionState;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class UniversalPackageFromRecycleBinRequestBuilder extends BaseRequestBuilder {
    public UniversalPackageFromRecycleBinRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "upack", "3ba455ae-31e6-409e-849f-56c66888d004", ApiVersion.UPACK);
    }

    /**
     * Delete a package version from the recycle bin.
     *
     * @param pathParameters Represents the path parameters to delete artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(Consumer<UniversalRequestBuilder.UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UniversalRequestBuilder.UPackPathParameters();
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
    public CompletableFuture<UPackPackageVersionDeletionState> getAsync(
            Consumer<UniversalRequestBuilder.UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UniversalRequestBuilder.UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .executeAsync(UPackPackageVersionDeletionState.class);
    }

    /**
     * Restore a package version from the recycle bin to its associated feed.
     *
     * @param recycleBinPackageVersionDetails Set the deleted property as false to restore the package.
     * @param pathParameters                  Represents the path parameters to restore artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> restoreAsync(UPackRecycleBinPackageVersionDetails recycleBinPackageVersionDetails,
                                                Consumer<UniversalRequestBuilder.UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new UniversalRequestBuilder.UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(recycleBinPackageVersionDetails)
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
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
    public CompletableFuture<Void> updateAsync(String feedId, UPackPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("12f73313-0937-4114-bb9f-4e9e720fdc78")
                .serviceEndpoint("feed", feedId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Delete a package version from the recycle bin.
     *
     * @param pathParameters Represents the path parameters to delete artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(Consumer<UniversalRequestBuilder.UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UniversalRequestBuilder.UPackPathParameters();
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
    public UPackPackageVersionDeletionState get(
            Consumer<UniversalRequestBuilder.UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UniversalRequestBuilder.UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
                .build()
                .execute(UPackPackageVersionDeletionState.class);
    }

    /**
     * Restore a package version from the recycle bin to its associated feed.
     *
     * @param recycleBinPackageVersionDetails Set the deleted property as false to restore the package.
     * @param pathParameters                  Represents the path parameters to restore artifact.
     * @throws AzDException Default Api Exception handler.
     */
    public Void restore(UPackRecycleBinPackageVersionDetails recycleBinPackageVersionDetails,
                        Consumer<UniversalRequestBuilder.UPackPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");

        final var values = new UniversalRequestBuilder.UPackPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(recycleBinPackageVersionDetails)
                .serviceEndpoint("feedId", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("packageName", Objects.requireNonNull(values.packageName, "Group ID cannot be null."))
                .serviceEndpoint("packageVersion", Objects.requireNonNull(values.packageVersion, "Version of the artifact is mandatory."))
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
    public Void update(String feedId, UPackPackagesBatchRequest batchRequest) throws AzDException {
        return builder()
                .POST(batchRequest)
                .location("12f73313-0937-4114-bb9f-4e9e720fdc78")
                .serviceEndpoint("feed", feedId)
                .build()
                .executePrimitive();
    }
}
