package org.azd.featuremanagement.scope;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.FeatureManagement;
import org.azd.enums.FeatureManagementScopeName;
import org.azd.enums.FeatureManagementUserScope;
import org.azd.exceptions.AzDException;
import org.azd.featuremanagement.FeatureManagementRequestBuilder;
import org.azd.featuremanagement.types.ContributedFeatureState;
import org.azd.featuremanagement.types.ContributedFeatureStateQuery;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Request builder to manage Feature management state scope Api.
 */
public class StateScopeRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public StateScopeRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "featuremanagement", "dd291e43-aa9f-4cee-8465-a93c78e414a4",
                ApiVersion.FEATURE_MANAGEMENT);
    }

    /**
     * Get the state of the specified feature for the given named scope
     *
     * @param feature    Contribution id of the feature.
     * @param userScope  User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName  Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> getAsync(FeatureManagement feature,
                                                                            FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                                            String scopeValue)
            throws AzDException {
        return builder()
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param feature    Contribution id of the feature.
     * @param userScope  User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName  Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setAsync(ContributedFeatureState featureState,
                                                                            FeatureManagement feature,
                                                                            FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                                            String scopeValue)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param feature              Contribution id of the feature.
     * @param userScope            User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName            Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue           Value of the scope (e.g. the project or team id)
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setAsync(ContributedFeatureState featureState,
                                                                            FeatureManagement feature,
                                                                            FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                                            String scopeValue,
                                                                            Consumer<FeatureManagementRequestBuilder.RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .query(FeatureManagementRequestBuilder.RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Get the states of the specified features for the default scope
     *
     * @param query     Query describing the features to query.
     * @param userScope User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureStateQuery> queryAsync(ContributedFeatureStateQuery query,
                                                                                  FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .POST(query)
                .location("3f810f28-03e2-4239-b0bc-788add3005e5")
                .serviceEndpoint("userScope", userScope.getUserScope())
                .build()
                .executeAsync(ContributedFeatureStateQuery.class);
    }

    /**
     * Get the states of the specified features for the specific named scope
     *
     * @param query      Query describing the features to query.
     * @param userScope  User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName  Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue Value of the scope (e.g. the project or team id)
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureStateQuery> queryAsync(ContributedFeatureStateQuery query,
                                                                                FeatureManagementUserScope userScope,
                                                                                FeatureManagementScopeName scopeName, String scopeValue)
            throws AzDException {
        return builder()
                .POST(query)
                .location("f29e997b-c2da-4d15-8380-765788a1a74c")
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .executeAsync(ContributedFeatureStateQuery.class);
    }

    /**
     * Get the state of the specified feature for the given named scope
     *
     * @param feature    Contribution id of the feature.
     * @param userScope  User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName  Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState get(FeatureManagement feature,
                                       FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                       String scopeValue)
            throws AzDException {
        return builder()
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param feature    Contribution id of the feature.
     * @param userScope  User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName  Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState set(ContributedFeatureState featureState,
                                                    FeatureManagement feature,
                                                    FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                    String scopeValue)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param feature              Contribution id of the feature.
     * @param userScope            User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName            Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue           Value of the scope (e.g. the project or team id)
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState set(ContributedFeatureState featureState,
                                                    FeatureManagement feature,
                                                    FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                    String scopeValue,
                                                    Consumer<FeatureManagementRequestBuilder.RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .query(FeatureManagementRequestBuilder.RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Get the states of the specified features for the default scope
     *
     * @param query     Query describing the features to query.
     * @param userScope User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureStateQuery query(ContributedFeatureStateQuery query,
                                              FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .POST(query)
                .location("3f810f28-03e2-4239-b0bc-788add3005e5")
                .serviceEndpoint("userScope", userScope.getUserScope())
                .build()
                .execute(ContributedFeatureStateQuery.class);
    }

    /**
     * Get the states of the specified features for the specific named scope
     *
     * @param query      Query describing the features to query.
     * @param userScope  User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName  Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue Value of the scope (e.g. the project or team id)
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureStateQuery query(ContributedFeatureStateQuery query,
                                              FeatureManagementUserScope userScope,
                                              FeatureManagementScopeName scopeName, String scopeValue)
            throws AzDException {
        return builder()
                .POST(query)
                .location("f29e997b-c2da-4d15-8380-765788a1a74c")
                .serviceEndpoint("userScope", userScope.getUserScope())
                .serviceEndpoint("scopeName", scopeName.getScopeName())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .execute(ContributedFeatureStateQuery.class);
    }

}
