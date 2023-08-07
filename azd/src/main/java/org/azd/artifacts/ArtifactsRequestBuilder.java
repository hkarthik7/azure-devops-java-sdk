package org.azd.artifacts;

import org.azd.artifacts.feedmanagement.FeedManagementRequestBuilder;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

/**
 * Provides functionality to Artifacts Api.
 */
public class ArtifactsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new AccountsRequestBuilder instance and sets the default values.
     * @param accessTokenCredential Authentication provider {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public ArtifactsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter);
    }

    public FeedManagementRequestBuilder feedManagement() {
        return new FeedManagementRequestBuilder(accessTokenCredential, requestAdapter);
    }
}
