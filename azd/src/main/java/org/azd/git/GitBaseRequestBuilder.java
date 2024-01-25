package org.azd.git;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.git.annotatedtags.AnnotatedTagsRequestBuilder;
import org.azd.git.blobs.BlobsRequestBuilder;
import org.azd.git.commits.CommitsRequestBuilder;
import org.azd.git.forks.ForksRequestBuilder;
import org.azd.git.items.ItemsRequestBuilder;
import org.azd.git.pullrequest.PullRequestBaseRequestBuilder;
import org.azd.git.pullrequests.PullRequestsRequestBuilder;
import org.azd.git.pushes.PushesRequestBuilder;
import org.azd.git.refs.RefsRequestBuilder;
import org.azd.git.repositories.RepositoriesRequestBuilder;

/**
 * Provides functionality to build requests for managing Git Api.
 */
public class GitBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public GitBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Repositories Api.
     *
     * @return RepositoriesRequestBuilder {@link RepositoriesRequestBuilder}
     */
    public RepositoriesRequestBuilder repositories() {
        return new RepositoriesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Repositories Api.
     *
     * @return RepositoriesRequestBuilder {@link RepositoriesRequestBuilder}
     */
    public PullRequestsRequestBuilder pullRequests() {
        return new PullRequestsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Refs Api.
     *
     * @return RefsRequestBuilder {@link RefsRequestBuilder}
     */
    public RefsRequestBuilder refs() {
        return new RefsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Pull request and its associated Apis.
     *
     * @return PullRequestBaseRequestBuilder {@link PullRequestBaseRequestBuilder}
     */
    public PullRequestBaseRequestBuilder pullRequest() {
        return new PullRequestBaseRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Git annotated tags Api.
     *
     * @return AnnotatedTagsRequestBuilder {@link AnnotatedTagsRequestBuilder}.
     */
    public AnnotatedTagsRequestBuilder annotatedTags() {
        return new AnnotatedTagsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Git commits Api.
     *
     * @return CommitsRequestBuilder {@link CommitsRequestBuilder}.
     */
    public CommitsRequestBuilder commits() {
        return new CommitsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Git blobs Api.
     *
     * @return BlobsRequestBuilder {@link BlobsRequestBuilder}.
     */
    public BlobsRequestBuilder blobs() {
        return new BlobsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Git Items Api.
     *
     * @return ItemsRequestBuilder {@link ItemsRequestBuilder}.
     */
    public ItemsRequestBuilder items() {
        return new ItemsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Git Forks Api.
     *
     * @return ForksRequestBuilder {@link ForksRequestBuilder}.
     */
    public ForksRequestBuilder forks() {
        return new ForksRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Git Pushes Api.
     *
     * @return PushesRequestBuilder {@link PushesRequestBuilder}.
     */
    public PushesRequestBuilder pushes() {
        return new PushesRequestBuilder(organizationUrl, accessTokenCredential);
    }
}

