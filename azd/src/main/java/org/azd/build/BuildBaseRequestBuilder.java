package org.azd.build;

import org.azd.build.artifacts.ArtifactsRequestBuilder;
import org.azd.build.attachments.AttachmentsRequestBuilder;
import org.azd.build.authorizedresources.AuthorizedResourcesRequestBuilder;
import org.azd.build.builds.BuildsRequestBuilder;
import org.azd.build.controllers.ControllersRequestBuilder;
import org.azd.build.definitions.DefinitionsRequestBuilder;
import org.azd.build.folders.FoldersRequestBuilder;
import org.azd.build.sourceproviders.SourceProvidersRequestBuilder;
import org.azd.build.tags.TagsRequestBuilder;
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

    /**
     * Provides functionality to manage Build Controllers Api.
     * @return ControllersRequestBuilder {@link ControllersRequestBuilder}
     */
    public ControllersRequestBuilder controllers() {
        return new ControllersRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Build Definitions Api.
     * @return DefinitionsRequestBuilder {@link DefinitionsRequestBuilder}
     */
    public DefinitionsRequestBuilder definitions() {
        return new DefinitionsRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage Folder for build definitions Api.
     * @return FoldersRequestBuilder {@link FoldersRequestBuilder}
     */
    public FoldersRequestBuilder folders() {
        return new FoldersRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage source providers Api.
     * @return SourceProvidersRequestBuilder {@link SourceProvidersRequestBuilder}
     */
    public SourceProvidersRequestBuilder sourceproviders() {
        return new SourceProvidersRequestBuilder(accessTokenCredential, requestAdapter);
    }

    /**
     * Provides functionality to manage build and build definition tags Api.
     * @return TagsRequestBuilder {@link TagsRequestBuilder}
     */
    public TagsRequestBuilder tags() {
        return new TagsRequestBuilder(accessTokenCredential, requestAdapter);
    }
}
