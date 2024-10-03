package org.azd.release.deployments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.DeploymentOperationStatus;
import org.azd.enums.DeploymentStatus;
import org.azd.enums.ReleaseQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.release.types.Deployments;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Release Deployments Api.
 */
public class DeploymentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DeploymentsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "release", "b005ef73-cddc-448e-9ba2-5193bf36b19f", ApiVersion.RELEASE_DEPLOYMENTS);
    }

    /**
     * Returns the list of release deployments.
     *
     * @return Collection of release deployments. {@link Deployments}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Deployments> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(Deployments.class);
    }

    /**
     * Returns the list of release deployments.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of release deployments. {@link Deployments}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<Deployments> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(Deployments.class);
    }

    /**
     * Returns the list of release deployments.
     *
     * @return Collection of release deployments. {@link Deployments}
     * @throws AzDException Default Api exception handler.
     */
    public Deployments list() throws AzDException {
        return builder()
                .build()
                .execute(Deployments.class);
    }

    /**
     * Returns the list of release deployments.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return Collection of release deployments. {@link Deployments}
     * @throws AzDException Default Api exception handler.
     */
    public Deployments list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(Deployments.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        @QueryParameter(name = "$top")
        public Integer top;
        @QueryParameter(name = "continuationToken")
        public Integer continuationToken;
        @QueryParameter(name = "createdBy")
        public String createdBy;
        @QueryParameter(name = "createdFor")
        public String createdFor;
        @QueryParameter(name = "definitionEnvironmentId")
        public Integer definitionEnvironmentId;
        @QueryParameter(name = "definitionId")
        public Integer definitionId;
        @QueryParameter(name = "deploymentStatus")
        public DeploymentStatus deploymentStatus;
        @QueryParameter(name = "latestAttemptsOnly")
        public Boolean latestAttemptsOnly;
        @QueryParameter(name = "maxModifiedTime")
        public String maxModifiedTime;
        @QueryParameter(name = "maxStartedTime")
        public String maxStartedTime;
        @QueryParameter(name = "minModifiedTime")
        public String minModifiedTime;
        @QueryParameter(name = "minStartedTime")
        public String minStartedTime;
        @QueryParameter(name = "operationStatus")
        public DeploymentOperationStatus operationStatus;
        @QueryParameter(name = "queryOrder")
        public ReleaseQueryOrder queryOrder;
        @QueryParameter(name = "sourceBranch")
        public String sourceBranch;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
