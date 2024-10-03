package org.azd.policy.revisions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.policy.types.PolicyConfiguration;
import org.azd.policy.types.PolicyConfigurations;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to work with Policy Revisions Api.
 */
public class RevisionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public RevisionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "policy", "fe1e68a2-60d3-43cb-855b-85e41ae97c95", ApiVersion.POLICY);
    }

    /**
     * Retrieve a specific revision of a given policy by ID.
     *
     * @param configurationId The policy configuration ID.
     * @param revisionId      The revision ID.
     * @return Policy configuration object {@link PolicyConfiguration}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PolicyConfiguration> getAsync(String configurationId, String revisionId) throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .serviceEndpoint("revisionId", revisionId)
                .build()
                .executeAsync(PolicyConfiguration.class);
    }

    /**
     * Retrieve all revisions for a given policy.
     *
     * @param configurationId The policy configuration ID.
     * @return Collection of policy configuration object {@link PolicyConfigurations}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PolicyConfigurations> listAsync(String configurationId) throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .executeAsync(PolicyConfigurations.class);
    }

    /**
     * Retrieve all revisions for a given policy.
     *
     * @param configurationId      The policy configuration ID.
     * @param requestConfiguration Represents query parameters.
     * @return Collection of policy configuration object {@link PolicyConfigurations}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PolicyConfigurations> listAsync(String configurationId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PolicyConfigurations.class);
    }

    /**
     * Retrieve a specific revision of a given policy by ID.
     *
     * @param configurationId The policy configuration ID.
     * @param revisionId      The revision ID.
     * @return Policy configuration object {@link PolicyConfiguration}
     * @throws AzDException Default Api exception handler.
     */
    public PolicyConfiguration get(String configurationId, String revisionId) throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .serviceEndpoint("revisionId", revisionId)
                .build()
                .execute(PolicyConfiguration.class);
    }

    /**
     * Retrieve all revisions for a given policy.
     *
     * @param configurationId The policy configuration ID.
     * @return Collection of policy configuration object {@link PolicyConfigurations}
     * @throws AzDException Default Api exception handler.
     */
    public PolicyConfigurations list(String configurationId) throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .execute(PolicyConfigurations.class);
    }

    /**
     * Retrieve all revisions for a given policy.
     *
     * @param configurationId      The policy configuration ID.
     * @param requestConfiguration Represents query parameters.
     * @return Collection of policy configuration object {@link PolicyConfigurations}
     * @throws AzDException Default Api exception handler.
     */
    public PolicyConfigurations list(String configurationId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PolicyConfigurations.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The number of revisions to retrieve.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * The number of revisions to ignore. For example, to retrieve results 101-150, set top to 50 and skip to 100.
         */
        @QueryParameter(name = "$skip")
        public Integer skip;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
