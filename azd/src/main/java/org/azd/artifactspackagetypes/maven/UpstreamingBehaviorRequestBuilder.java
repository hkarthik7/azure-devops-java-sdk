package org.azd.artifactspackagetypes.maven;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.maven.types.UpstreamingBehavior;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class UpstreamingBehaviorRequestBuilder extends BaseRequestBuilder {
    public UpstreamingBehaviorRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "maven", "fba7ba8c-d1f5-4aeb-8f5d-f017a7d5e719", ApiVersion.MAVEN);
    }

    /**
     * Get the upstreaming behavior of a package within the context of a feed
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @return Upstream behaviour object {@link UpstreamingBehavior}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<UpstreamingBehavior> getAsync(Consumer<UpstreamPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UpstreamPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .build()
                .executeAsync(UpstreamingBehavior.class);
    }

    /**
     * Set the upstreaming behavior of a package within the context of a feed
     *
     * @param pathParameters      Represents the path parameters to set artifact.
     * @param upstreamingBehavior Upstream behaviour object. Allowed values are 'allowExternalVersions' or 'auto'.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> setAsync(Consumer<UpstreamPathParameters> pathParameters,
                                            UpstreamingBehavior upstreamingBehavior) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UpstreamPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(upstreamingBehavior)
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get the upstreaming behavior of a package within the context of a feed
     *
     * @param pathParameters Represents the path parameters to get artifact.
     * @return Upstream behaviour object {@link UpstreamingBehavior}
     * @throws AzDException Default Api Exception handler.
     */
    public UpstreamingBehavior get(Consumer<UpstreamPathParameters> pathParameters) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UpstreamPathParameters();
        pathParameters.accept(values);

        return builder()
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .build()
                .execute(UpstreamingBehavior.class);
    }

    /**
     * Set the upstreaming behavior of a package within the context of a feed
     *
     * @param pathParameters      Represents the path parameters to set artifact.
     * @param upstreamingBehavior Upstream behaviour object. Allowed values are 'allowExternalVersions' or 'auto'.
     * @throws AzDException Default Api Exception handler.
     */
    public Void set(Consumer<UpstreamPathParameters> pathParameters,
                    UpstreamingBehavior upstreamingBehavior) throws AzDException {
        Objects.requireNonNull(pathParameters, "Path parameters cannot be null.");
        final var values = new UpstreamPathParameters();
        pathParameters.accept(values);

        return builder()
                .PATCH(upstreamingBehavior)
                .serviceEndpoint("artifactId", Objects.requireNonNull(values.artifactId, "Artifact ID cannot be null."))
                .serviceEndpoint("feed", Objects.requireNonNull(values.feedId, "Feed ID cannot be null."))
                .serviceEndpoint("groupId", Objects.requireNonNull(values.groupId, "Group ID cannot be null."))
                .build()
                .executePrimitive();
    }

    /**
     * Represents the Path values for Maven Api.
     */
    public static class UpstreamPathParameters {
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
    }
}
