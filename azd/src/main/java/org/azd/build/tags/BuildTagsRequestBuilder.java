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

/**
 * Provides functionality to work with Build Tags Api.
 */
public class BuildTagsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new request builder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public BuildTagsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/builds", ApiVersion.BUILD_TAGS);
    }

    /**
     * Adds a tag to a build.
     * @param buildId The ID of the build.
     * @param tag The tag to add.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> add(int buildId, String tag) throws AzDException {
        var reqInfo = toPutRequestInformation(null);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/tags/" + tag;

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Adds tags to a build.
     * @param buildId The ID of the build.
     * @param tags The tags to add.
     * @return String array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> add(int buildId, List<String> tags) throws AzDException {
        var reqInfo = toPostRequestInformation(tags);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/tags";

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Removes a tag from a build.
     * NOTE: This method will not work for tags with special characters. To remove tags with special characters, use the update method instead.
     * @param buildId Id of the build.
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> delete(int buildId, String tag) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/tags/" + tag;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Gets the tags for a build.
     * @param buildId The ID of the build.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> get(int buildId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/tags";

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Adds/Removes tags from a build.
     * @param buildId The ID of the build.
     * @param tags The tags to update.
     * @param toRemove If true removes the tags. Use this to remove tags that has special characters.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> update(int buildId, List<String> tags, boolean toRemove) throws AzDException {
        var tagValue = toRemove ? "tagsToRemove" : "tagsToAdd";
        var body = new HashMap<String, Object>() {{
            put(tagValue, tags);
        }};

        var reqInfo = toPatchRequestInformation(body);
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + buildId + "/tags";

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }
}
