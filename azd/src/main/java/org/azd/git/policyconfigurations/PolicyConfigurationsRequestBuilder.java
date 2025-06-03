package org.azd.git.policyconfigurations;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.git.types.PolicyConfigurations;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Request builder to manage Apis associated with policy configurations.
 */
public class PolicyConfigurationsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public PolicyConfigurationsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "git", "2c420070-a0a2-49cc-9639-c9f271c5ff07", ApiVersion.GIT_POLICY_CONFIGURATIONS);
    }

    /**
     * Retrieve a list of policy configurations by a given set of scope/filtering criteria.
     * Below is a short description of how all the query parameters interact with each other:
     *
     * repositoryId set, refName set: returns all policy configurations that apply to a particular branch in a repository
     * repositoryId set, refName unset: returns all policy configurations that apply to a particular repository
     * repositoryId unset, refName unset: returns all policy configurations that are defined at the project level
     * repositoryId unset, refName set: returns all project-level branch policies, plus the project level configurations
     * For all the examples above, when policyType is set, it'll restrict results to the given policy type
     *
     * @param repositoryId Project ID or project name
     * @return Collection of PolicyConfiguration Object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     **/
    public CompletableFuture<PolicyConfigurations> getAsync(String repositoryId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .query("repositoryId", repositoryId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(PolicyConfigurations.class);
    }

    /**
     * Retrieve a list of policy configurations by a given set of scope/filtering criteria.
     * Below is a short description of how all the query parameters interact with each other:
     *
     * repositoryId set, refName set: returns all policy configurations that apply to a particular branch in a repository
     * repositoryId set, refName unset: returns all policy configurations that apply to a particular repository
     * repositoryId unset, refName unset: returns all policy configurations that are defined at the project level
     * repositoryId unset, refName set: returns all project-level branch policies, plus the project level configurations
     * For all the examples above, when policyType is set, it'll restrict results to the given policy type
     *
     * @param repositoryId Project ID or project name
     * @return Collection of PolicyConfiguration Object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     **/
    public PolicyConfigurations get(String repositoryId, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .query("repositoryId", repositoryId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(PolicyConfigurations.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Maximum number of policies to return.
         */
        @QueryParameter(name = "top")
        public Integer top;
        /**
         * The policy type filter. (String uuid of policy id.)
         */
        @QueryParameter(name = "policyType")
        public String policyType;
        /**
         * The fully-qualified Git ref name (e.g. refs/heads/main).
         */
        @QueryParameter(name = "refName")
        public String refName;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
