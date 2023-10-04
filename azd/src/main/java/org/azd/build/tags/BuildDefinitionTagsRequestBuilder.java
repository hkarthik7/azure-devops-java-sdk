package org.azd.build.tags;

import org.azd.build.types.BuildTags;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BuildDefinitionTagsRequestBuilder extends BaseRequestBuilder {
    public BuildDefinitionTagsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/definitions", ApiVersion.BUILD_TAGS);
    }

    /***
     * Adds a tag to a definition.
     * @param definitionId Id of build definition.
     * @param tag The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> addAsync(int definitionId, String tag) throws AzDException {
        var reqInfo = toPutRequestInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags/" + tag;

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Adds multiple tags to a definition.
     * @param definitionId Id of build definition.
     * @param tags The tags to add.
     * @return String array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> addAsync(int definitionId, List<String> tags) throws AzDException {
        var reqInfo = toPostRequestInformation(tags);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Removes a tag from a definition.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the update method instead.
     * @param definitionId Id of the build definition.
     * @param tag The tag to delete
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> deleteAsync(int definitionId, String tag) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags/" + tag;

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @return Sting array of tags
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> getAsync(int definitionId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @param revision The definition revision number. If not specified, uses the latest revision of the definition.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> getAsync(int definitionId, int revision) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";
        reqInfo.setQueryParameter("revision", revision);

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Adds/Removes tags from a build.
     * @param definitionId The Id of the build definition.
     * @param tags The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> updateAsync(int definitionId, List<String> tags, boolean toRemove) throws AzDException {
        var tagValue = toRemove ? "tagsToRemove" : "tagsToAdd";
        var body = new HashMap<String, Object>() {{
            put(tagValue, tags);
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Adds a tag to a definition.
     * @param definitionId Id of build definition.
     * @param tag The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags add(int definitionId, String tag) throws AzDException {
        var reqInfo = toPutRequestInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags/" + tag;

        return requestAdapter.send(reqInfo, BuildTags.class);
    }

    /***
     * Adds multiple tags to a definition.
     * @param definitionId Id of build definition.
     * @param tags The tags to add.
     * @return String array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags add(int definitionId, List<String> tags) throws AzDException {
        var reqInfo = toPostRequestInformation(tags);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";

        return requestAdapter.send(reqInfo, BuildTags.class);
    }

    /***
     * Removes a tag from a definition.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the update method instead.
     * @param definitionId Id of the build definition.
     * @param tag The tag to delete
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags delete(int definitionId, String tag) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags/" + tag;

        return requestAdapter.send(reqInfo, BuildTags.class);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @return Sting array of tags
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags get(int definitionId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";

        return requestAdapter.send(reqInfo, BuildTags.class);
    }

    /***
     * Gets the tags for a definition.
     * @param definitionId Id of build definition.
     * @param revision The definition revision number. If not specified, uses the latest revision of the definition.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags get(int definitionId, int revision) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";
        reqInfo.setQueryParameter("revision", revision);

        return requestAdapter.send(reqInfo, BuildTags.class);
    }

    /***
     * Adds/Removes tags from a build.
     * @param definitionId The Id of the build definition.
     * @param tags The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public BuildTags update(int definitionId, List<String> tags, boolean toRemove) throws AzDException {
        var tagValue = toRemove ? "tagsToRemove" : "tagsToAdd";
        var body = new HashMap<String, Object>() {{
            put(tagValue, tags);
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + definitionId + "/tags";

        return requestAdapter.send(reqInfo, BuildTags.class);
    }

}
