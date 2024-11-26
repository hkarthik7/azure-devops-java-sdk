package org.azd.build;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.build.artifacts.ArtifactsRequestBuilder;
import org.azd.build.attachments.AttachmentsRequestBuilder;
import org.azd.build.authorizedresources.AuthorizedResourcesRequestBuilder;
import org.azd.build.builds.BuildsRequestBuilder;
import org.azd.build.controllers.ControllersRequestBuilder;
import org.azd.build.definitions.DefinitionsRequestBuilder;
import org.azd.build.folders.FoldersRequestBuilder;
import org.azd.build.sourceproviders.SourceProvidersRequestBuilder;
import org.azd.build.stages.StagesRequestBuilder;
import org.azd.build.tags.TagsRequestBuilder;
import org.azd.build.timeline.TimelineRequestBuilder;
import org.azd.build.yaml.YamlRequestBuilder;

/**
 * Provides functionality to manage Build Api, and it's related entities.
 */
public class BuildBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public BuildBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Build Artifacts Api.
     *
     * @return ArtifactsRequestBuilder {@link ArtifactsRequestBuilder}
     */
    public ArtifactsRequestBuilder artifacts() {
        return new ArtifactsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Build attachments Api.
     *
     * @return AttachmentsRequestBuilder {@link AttachmentsRequestBuilder}
     */
    public AttachmentsRequestBuilder attachments() {
        return new AttachmentsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Build authorized resources Api.
     *
     * @return AuthorizedResourcesRequestBuilder {@link AuthorizedResourcesRequestBuilder}
     */
    public AuthorizedResourcesRequestBuilder authorizedResources() {
        return new AuthorizedResourcesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Builds Api.
     *
     * @return BuildsRequestBuilder {@link BuildsRequestBuilder}
     */
    public BuildsRequestBuilder builds() {
        return new BuildsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Build Controllers Api.
     *
     * @return ControllersRequestBuilder {@link ControllersRequestBuilder}
     */
    public ControllersRequestBuilder controllers() {
        return new ControllersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Build Definitions Api.
     *
     * @return DefinitionsRequestBuilder {@link DefinitionsRequestBuilder}
     */
    public DefinitionsRequestBuilder definitions() {
        return new DefinitionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Folder for build definitions Api.
     *
     * @return FoldersRequestBuilder {@link FoldersRequestBuilder}
     */
    public FoldersRequestBuilder folders() {
        return new FoldersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage source providers Api.
     *
     * @return SourceProvidersRequestBuilder {@link SourceProvidersRequestBuilder}
     */
    public SourceProvidersRequestBuilder sourceProviders() {
        return new SourceProvidersRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage build and build definition tags Api.
     *
     * @return TagsRequestBuilder {@link TagsRequestBuilder}
     */
    public TagsRequestBuilder tags() {
        return new TagsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage build yaml Api.
     *
     * @return YamlRequestBuilder {@link YamlRequestBuilder}
     */
    public YamlRequestBuilder yaml() {
        return new YamlRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage build stages Api.
     *
     * @return StagesRequestBuilder {@link StagesRequestBuilder}
     */
    public StagesRequestBuilder stages() {
        return new StagesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage build stages Api.
     *
     * @return TimelineRequestBuilder {@link TimelineRequestBuilder}
     */
    public TimelineRequestBuilder timeline() {
        return new TimelineRequestBuilder(organizationUrl, accessTokenCredential);
    }
}

