package org.azd.build;

import org.azd.build.artifacts.ArtifactsRequestBuilder;
import org.azd.build.attachments.AttachmentsRequestBuilder;
import org.azd.build.authorizedresources.AuthorizedResourcesRequestBuilder;
import org.azd.build.builds.BuildsRequestBuilder;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

/**
 * Provides functionality to manage Build Api, and it's related entities.
 */
public class BuildBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public BuildBaseRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Build Artifacts Api.
     * @return ArtifactsRequestBuilder {@link ArtifactsRequestBuilder}
     */
    public ArtifactsRequestBuilder artifacts() {
        return new ArtifactsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Build attachments Api.
     * @return AttachmentsRequestBuilder {@link AttachmentsRequestBuilder}
     */
    public AttachmentsRequestBuilder attachments() {
        return new AttachmentsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Build authorized resources Api.
     * @return AuthorizedResourcesRequestBuilder {@link AuthorizedResourcesRequestBuilder}
     */
    public AuthorizedResourcesRequestBuilder authorizedResources() {
        return new AuthorizedResourcesRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Builds Api.
     * @return BuildsRequestBuilder {@link BuildsRequestBuilder}
     */
    public BuildsRequestBuilder builds() {
        return new BuildsRequestBuilder(accessTokenCredential, requestAdapter);
    }
}
