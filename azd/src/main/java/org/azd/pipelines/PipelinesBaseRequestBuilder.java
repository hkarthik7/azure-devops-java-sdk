package org.azd.pipelines;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.pipelines.artifacts.ArtifactsRequestBuilder;
import org.azd.pipelines.logs.LogsRequestBuilder;
import org.azd.pipelines.permissions.PermissionsRequestBuilder;
import org.azd.pipelines.pipelines.PipelinesRequestBuilder;
import org.azd.pipelines.preview.PreviewRequestBuilder;
import org.azd.pipelines.runs.RunsRequestBuilder;

/**
 * Provides functionality to work with Pipelines Api.
 */
public class PipelinesBaseRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PipelinesBaseRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to pipeline artifacts Api.
     *
     * @return ArtifactsRequestBuilder {@link ArtifactsRequestBuilder}
     */
    public ArtifactsRequestBuilder artifacts() {
        return new ArtifactsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to pipeline logs Api.
     *
     * @return LogsRequestBuilder {@link LogsRequestBuilder}
     */
    public LogsRequestBuilder logs() {
        return new LogsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to Pipelines Api.
     *
     * @return PipelinesRequestBuilder {@link PipelinesRequestBuilder}
     */
    public PipelinesRequestBuilder pipelines() {
        return new PipelinesRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to Pipelines permissions Api.
     *
     * @return PermissionsRequestBuilder {@link PermissionsRequestBuilder}
     */
    public PermissionsRequestBuilder permissions() {
        return new PermissionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to Pipelines preview Api.
     *
     * @return PreviewRequestBuilder {@link PreviewRequestBuilder}
     */
    public PreviewRequestBuilder preview() {
        return new PreviewRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to Pipelines runs Api.
     *
     * @return RunsRequestBuilder {@link RunsRequestBuilder}
     */
    public RunsRequestBuilder runs() {
        return new RunsRequestBuilder(organizationUrl, accessTokenCredential);
    }
}
