package org.azd.artifacts;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.artifacts.feedmanagement.FeedManagementRequestBuilder;
import org.azd.authentication.AccessTokenCredential;

import java.util.function.Predicate;

/**
 * Provides functionality to Artifacts Api.
 */
public class ArtifactsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ArtifactsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Request builder to manage the feed management Api.
     *
     * @return FeedManagementRequestBuilder {@link FeedManagementRequestBuilder}
     */
    public FeedManagementRequestBuilder feedManagement() {
        return new FeedManagementRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Request builder to manage the feed management Api.
     *
     * @param configuration Set the configuration to include or exclude the project in request url.
     * @return FeedManagementRequestBuilder {@link FeedManagementRequestBuilder}
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/artifacts/feed-management?view=azure-devops-rest-7.2">Feed Management</a>
     */
    public FeedManagementRequestBuilder feedManagement(Predicate<ProjectExcludeParameter> configuration) {
        if (configuration != null) {
            final var config = new ProjectExcludeParameter();
            if (configuration.test(config)) accessTokenCredential.setProjectName(null);
        }
        return new FeedManagementRequestBuilder(organizationUrl, accessTokenCredential);
    }
}

