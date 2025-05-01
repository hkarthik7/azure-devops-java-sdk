package org.azd.git.annotatedtags;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.GitAnnotatedTag;

import java.util.concurrent.CompletableFuture;

/**
 * Grants ability to manage Git annotated tags Api.
 */
public class AnnotatedTagsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AnnotatedTagsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "5e8a8081-3851-4626-b677-9891cc04102e", ApiVersion.GIT_ANNOTATED_TAGS);
    }

    /**
     * Create an annotated tag.
     *
     * @param repositoryId id of the repository.
     * @param annotatedTag Git annotated tag to add.
     * @return A Git annotated tag object {@link GitAnnotatedTag}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitAnnotatedTag> createAsync(String repositoryId, GitAnnotatedTag annotatedTag) throws AzDException {
        return builder()
                .POST(annotatedTag)
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .executeAsync(GitAnnotatedTag.class);
    }

    /**
     * Get an annotated tag.
     *
     * @param repositoryId id of the repository.
     * @param objectId     ObjectId (Sha1Id) of tag to get.
     * @return A Git annotated tag object {@link GitAnnotatedTag}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<GitAnnotatedTag> getAsync(String repositoryId, String objectId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("objectId", objectId)
                .build()
                .executeAsync(GitAnnotatedTag.class);
    }

    /**
     * Create an annotated tag.
     *
     * @param repositoryId id of the repository.
     * @param annotatedTag Git annotated tag to add.
     * @return A Git annotated tag object {@link GitAnnotatedTag}.
     * @throws AzDException Default Api Exception handler.
     */
    public GitAnnotatedTag create(String repositoryId, GitAnnotatedTag annotatedTag) throws AzDException {
        return builder()
                .POST(annotatedTag)
                .serviceEndpoint("repositoryId", repositoryId)
                .build()
                .execute(GitAnnotatedTag.class);
    }

    /**
     * Get an annotated tag.
     *
     * @param repositoryId id of the repository.
     * @param objectId     ObjectId (Sha1Id) of tag to get.
     * @return A Git annotated tag object {@link GitAnnotatedTag}.
     * @throws AzDException Default Api Exception handler.
     */
    public GitAnnotatedTag get(String repositoryId, String objectId) throws AzDException {
        return builder()
                .serviceEndpoint("repositoryId", repositoryId)
                .serviceEndpoint("objectId", objectId)
                .build()
                .execute(GitAnnotatedTag.class);
    }
}
