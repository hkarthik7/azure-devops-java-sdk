package org.azd.build.tags;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildTags;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to manage build tage Api.
 */
public class TagsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public TagsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "d84ac5c6-edc7-43d5-adc9-1b34be5dea09", ApiVersion.BUILD_TAGS);

    }

    public BuildTagsRequestBuilder build() {
        return new BuildTagsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    public BuildDefinitionTagsRequestBuilder definition() {
        return new BuildDefinitionTagsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Removes a tag from builds, definitions, and from the tag store
     *
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> deleteAsync(String tag) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("tag", tag)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Gets a list of all build tags in the project.
     *
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Removes a tag from builds, definitions, and from the tag store
     *
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags delete(String tag) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("tag", tag)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Gets a list of all build tags in the project.
     *
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags list() throws AzDException {
        return builder()
                .build()
                .execute(BuildTags.class);
    }
}

