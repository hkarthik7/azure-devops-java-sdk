package org.azd.build.tags;

import org.azd.build.types.BuildTags;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;

public class TagsRequestBuilder extends BaseRequestBuilder {
    public TagsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "build/tags", ApiVersion.BUILD_TAGS);
    }

    public BuildTagsRequestBuilder build() {
        return new BuildTagsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    public BuildDefinitionTagsRequestBuilder definition() {
        return new BuildDefinitionTagsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /***
     * Removes a tag from builds, definitions, and from the tag store
     * @param tag The tag to delete.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> delete(String tag) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = reqInfo.serviceEndpoint + "/" + tag;

        return requestAdapter.sendAsync(reqInfo, BuildTags.class);
    }

    /***
     * Gets a list of all build tags in the project.
     * @return Sting array of tags {@link BuildTags}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<BuildTags> list() throws AzDException {
        return requestAdapter.sendAsync(toGetRequestInformation(), BuildTags.class);
    }
}
