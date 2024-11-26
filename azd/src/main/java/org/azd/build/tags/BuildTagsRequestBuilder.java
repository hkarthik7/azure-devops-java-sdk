package org.azd.build.tags;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildTags;
import org.azd.exceptions.AzDException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Provides functionality to work with Build Tags Api.
 */
public class BuildTagsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildTagsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "6e6114b2-8161-44c8-8f6c-c5505782427f");
    }

    /**
     * Adds a tag to a build.
     *
     * @param buildId The ID of the build.
     * @param tag     The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> addAsync(int buildId, String tag) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("tag", tag)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Adds tags to a build.
     *
     * @param buildId The ID of the build.
     * @param tags    The tags to add.
     * @return String array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> addAsync(int buildId, List<String> tags) throws AzDException {
        return builder()
                .POST(tags)
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Removes a tag from a build.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the update method instead.
     *
     * @param buildId Id of the build.
     * @param tag     The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> deleteAsync(int buildId, String tag) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("tag", tag)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Gets the tags for a build.
     *
     * @param buildId The ID of the build.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> getAsync(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Adds/Removes tags from a build.
     *
     * @param buildId  The ID of the build.
     * @param tags     The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> updateAsync(int buildId, List<String> tags, boolean toRemove) throws AzDException {
        return builder()
                .PATCH(Map.of(toRemove ? "tagsToRemove" : "tagsToAdd", tags))
                .serviceEndpoint("buildId", buildId)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Adds a tag to a build.
     *
     * @param buildId The ID of the build.
     * @param tag     The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags add(int buildId, String tag) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("tag", tag)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Adds tags to a build.
     *
     * @param buildId The ID of the build.
     * @param tags    The tags to add.
     * @return String array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags add(int buildId, List<String> tags) throws AzDException {
        return builder()
                .POST(tags)
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Removes a tag from a build.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the update method instead.
     *
     * @param buildId Id of the build.
     * @param tag     The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags delete(int buildId, String tag) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("buildId", buildId)
                .serviceEndpoint("tag", tag)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Gets the tags for a build.
     *
     * @param buildId The ID of the build.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags get(int buildId) throws AzDException {
        return builder()
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Adds/Removes tags from a build.
     *
     * @param buildId  The ID of the build.
     * @param tags     The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags update(int buildId, List<String> tags, boolean toRemove) throws AzDException {
        return builder()
                .PATCH(Map.of(toRemove ? "tagsToRemove" : "tagsToAdd", tags))
                .serviceEndpoint("buildId", buildId)
                .build()
                .execute(BuildTags.class);
    }
}
