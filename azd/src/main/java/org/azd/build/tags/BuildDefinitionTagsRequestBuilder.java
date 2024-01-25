package org.azd.build.tags;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.types.BuildTags;
import org.azd.exceptions.AzDException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Subset of tags builder that builds request for build definition tags Api.
 */
public class BuildDefinitionTagsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildDefinitionTagsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "build", "cb894432-134a-4d31-a839-83beceaace4b");
    }

    /**
     * Adds a tag to a definition.
     *
     * @param definitionId Id of build definition.
     * @param tag          The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> addAsync(int definitionId, String tag) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("definitionId", definitionId)
                .serviceEndpoint("tag", tag)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Adds multiple tags to a definition.
     *
     * @param definitionId Id of build definition.
     * @param tags         The tags to add.
     * @return String array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> addAsync(int definitionId, List<String> tags) throws AzDException {
        return builder()
                .POST(tags)
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Removes a tag from a definition.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the update method instead.
     *
     * @param definitionId Id of the build definition.
     * @param tag          The tag to delete
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> deleteAsync(int definitionId, String tag) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("definitionId", definitionId)
                .serviceEndpoint("tag", tag)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Gets the tags for a definition.
     *
     * @param definitionId Id of build definition.
     * @return Sting array of tags
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> getAsync(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Gets the tags for a definition.
     *
     * @param definitionId Id of build definition.
     * @param revision     The definition revision number. If not specified, uses the latest revision of the definition.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> getAsync(int definitionId, int revision) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query("revision", revision)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Adds/Removes tags from a build.
     *
     * @param definitionId The Id of the build definition.
     * @param tags         The tags to update.
     * @param toRemove     If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> updateAsync(int definitionId, List<String> tags, boolean toRemove)
            throws AzDException {
        return builder()
                .PATCH(Map.of(toRemove ? "tagsToRemove" : "tagsToAdd", tags))
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .executeAsync(BuildTags.class);
    }

    /**
     * Adds a tag to a definition.
     *
     * @param definitionId Id of build definition.
     * @param tag          The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags add(int definitionId, String tag) throws AzDException {
        return builder()
                .PUT(null)
                .serviceEndpoint("definitionId", definitionId)
                .serviceEndpoint("tag", tag)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Adds multiple tags to a definition.
     *
     * @param definitionId Id of build definition.
     * @param tags         The tags to add.
     * @return String array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags add(int definitionId, List<String> tags) throws AzDException {
        return builder()
                .POST(tags)
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Removes a tag from a definition.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the update method instead.
     *
     * @param definitionId Id of the build definition.
     * @param tag          The tag to delete
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags delete(int definitionId, String tag) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("definitionId", definitionId)
                .serviceEndpoint("tag", tag)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Gets the tags for a definition.
     *
     * @param definitionId Id of build definition.
     * @return Sting array of tags
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags get(int definitionId) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Gets the tags for a definition.
     *
     * @param definitionId Id of build definition.
     * @param revision     The definition revision number. If not specified, uses the latest revision of the definition.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags get(int definitionId, int revision) throws AzDException {
        return builder()
                .serviceEndpoint("definitionId", definitionId)
                .query("revision", revision)
                .build()
                .execute(BuildTags.class);
    }

    /**
     * Adds/Removes tags from a build.
     *
     * @param definitionId The Id of the build definition.
     * @param tags         The tags to update.
     * @param toRemove     If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags update(int definitionId, List<String> tags, boolean toRemove)
            throws AzDException {
        return builder()
                .PATCH(Map.of(toRemove ? "tagsToRemove" : "tagsToAdd", tags))
                .serviceEndpoint("definitionId", definitionId)
                .build()
                .execute(BuildTags.class);
    }

}
