package org.azd.policy.configurations;

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
 * Provides functionality to work with Policy configurations Api.
 */
public class ConfigurationsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ConfigurationsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "policy", "dad91cbe-d183-45f8-9c6e-9c1164472121", ApiVersion.POLICY);
    }

    /**
     * Create a policy configuration of a given policy type.
     *
     * @param policyConfiguration Policy configuration object to create policy. {@link PolicyConfiguration}
     * @return Policy configuration object. {@link PolicyConfiguration}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<PolicyConfiguration> createAsync(PolicyConfiguration policyConfiguration) throws AzDException {
        return builder()
                .POST(policyConfiguration)
                .build()
                .executeAsync(PolicyConfiguration.class);
    }

    /**
     * Delete a policy configuration by its ID.
     *
     * @param configurationId ID of the policy configuration to delete.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int configurationId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a policy configuration by its ID.
     *
     * @param configurationId ID of the policy configuration
     * @return PolicyConfiguration object {@link PolicyConfiguration}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyConfiguration> getAsync(int configurationId) throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .executeAsync(PolicyConfiguration.class);
    }

    /**
     * Get a list of policy configurations in a project.
     *
     * @return PolicyConfigurations object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyConfigurations> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(PolicyConfigurations.class);
    }

    /**
     * Get a list of policy configurations in a project.
     * <p>
     * <br /><br />The 'scope' parameter for this API should not be used, except for legacy compatibility reasons.
     * It returns specifically scoped policies and does not support hierarchical nesting.
     * Instead, use the /_apis/git/policy/configurations API, which provides first class scope filtering support.
     * <p>
     * <br /><br />The optional policyType parameter can be used to filter the set of policies returned from this method.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return PolicyConfigurations object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyConfigurations> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PolicyConfigurations.class);
    }

    /**
     * Update a policy configuration by its ID.
     *
     * @param configurationId     ID of the existing policy configuration to be updated.
     * @param policyConfiguration Policy configuration object. Use get method to get policy, edit it and then use the
     *                            PolicyConfiguration object with this method to update.
     * @return PolicyConfiguration object {@link PolicyConfiguration}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<PolicyConfiguration> updateAsync(int configurationId, PolicyConfiguration policyConfiguration) throws AzDException {
        return builder()
                .PUT(policyConfiguration)
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .executeAsync(PolicyConfiguration.class);
    }

    /**
     * Create a policy configuration of a given policy type.
     *
     * @param policyConfiguration Policy configuration object to create policy. {@link PolicyConfiguration}
     * @return Policy configuration object. {@link PolicyConfiguration}
     * @throws AzDException Default Api exception handler.
     */
    public PolicyConfiguration create(PolicyConfiguration policyConfiguration) throws AzDException {
        return builder()
                .POST(policyConfiguration)
                .build()
                .execute(PolicyConfiguration.class);
    }

    /**
     * Delete a policy configuration by its ID.
     *
     * @param configurationId ID of the policy configuration to delete.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int configurationId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a policy configuration by its ID.
     *
     * @param configurationId ID of the policy configuration
     * @return PolicyConfiguration object {@link PolicyConfiguration}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyConfiguration get(int configurationId) throws AzDException {
        return builder()
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .execute(PolicyConfiguration.class);
    }

    /**
     * Get a list of policy configurations in a project.
     *
     * @return PolicyConfigurations object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyConfigurations list() throws AzDException {
        return builder()
                .build()
                .execute(PolicyConfigurations.class);
    }

    /**
     * Get a list of policy configurations in a project.
     * <p>
     * <br /><br />The 'scope' parameter for this API should not be used, except for legacy compatibility reasons.
     * It returns specifically scoped policies and does not support hierarchical nesting.
     * Instead, use the /_apis/git/policy/configurations API, which provides first class scope filtering support.
     * <p>
     * <br /><br />The optional policyType parameter can be used to filter the set of policies returned from this method.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return PolicyConfigurations object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyConfigurations list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PolicyConfigurations.class);
    }

    /**
     * Update a policy configuration by its ID.
     *
     * @param configurationId     ID of the existing policy configuration to be updated.
     * @param policyConfiguration Policy configuration object. Use get method to get policy, edit it and then use the
     *                            PolicyConfiguration object with this method to update.
     * @return PolicyConfiguration object {@link PolicyConfiguration}
     * @throws AzDException Default Api Exception handler.
     */
    public PolicyConfiguration update(int configurationId, PolicyConfiguration policyConfiguration) throws AzDException {
        return builder()
                .PUT(policyConfiguration)
                .serviceEndpoint("configurationId", configurationId)
                .build()
                .execute(PolicyConfiguration.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * The maximum number of configurations to return
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * A continuation token from a previous request, to retrieve the next page of results
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Filter returned policies to only this type
         */
        @QueryParameter(name = "policyType")
        public String policyType;
        /**
         * [Provided for legacy reasons] The scope on which a subset of policies is defined.
         */
        @QueryParameter(name = "scope")
        public String scope;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
