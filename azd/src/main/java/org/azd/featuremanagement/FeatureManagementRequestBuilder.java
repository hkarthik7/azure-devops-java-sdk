package org.azd.featuremanagement;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.FeatureManagement;
import org.azd.enums.FeatureManagementScopeName;
import org.azd.enums.FeatureManagementUserScope;
import org.azd.exceptions.AzDException;
import org.azd.featuremanagement.types.ContributedFeature;
import org.azd.featuremanagement.types.ContributedFeatureState;
import org.azd.featuremanagement.types.ContributedFeatureStateQuery;
import org.azd.featuremanagement.types.ContributedFeatures;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Request builder to manage Feature management Api.
 */
public class FeatureManagementRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public FeatureManagementRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "featuremanagement", "c4209f25-7a27-41dd-9f04-06080c7b6afd", ApiVersion.FEATURE_MANAGEMENT);
    }

    /**
     * Get a feature by id.
     *
     * @param featureManagement Represents the id of a feature.
     * @return Contributed feature object {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeature> getAsync(FeatureManagement featureManagement) throws AzDException {
        Objects.requireNonNull(featureManagement);
        return builder()
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .build()
                .executeAsync(ContributedFeature.class);
    }

    /**
     * Get all features.
     *
     * @return Collection of Contributed feature object {@link ContributedFeatures}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatures> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(ContributedFeatures.class);
    }

    /**
     * Get the state of the specified feature for the given user/all-users scope
     *
     * @param featureManagement Contribution id of the feature.
     * @param userScope         User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> getStateAsync(FeatureManagement featureManagement, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .location("98911314-3f9b-4eaf-80e8-83900d8e85d9")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState      Posted feature state object. Should specify the effective value.
     * @param featureManagement Contribution id of the feature
     * @param userScope         User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setStateAsync(ContributedFeatureState featureState,
                                                                    FeatureManagement featureManagement, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("98911314-3f9b-4eaf-80e8-83900d8e85d9")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState         Posted feature state object. Should specify the effective value.
     * @param featureManagement    Contribution id of the feature
     * @param userScope            User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setStateAsync(ContributedFeatureState featureState,
                                                                    FeatureManagement featureManagement, FeatureManagementUserScope userScope,
                                                                    Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("98911314-3f9b-4eaf-80e8-83900d8e85d9")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Get the state of the specified feature for the given named scope
     *
     * @param featureManagement Contribution id of the feature.
     * @param userScope         User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName         Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue        Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> getStateForScopeAsync(FeatureManagement featureManagement,
                                                                            FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                                            String scopeValue)
            throws AzDException {
        return builder()
                .location("dd291e43-aa9f-4cee-8465-a93c78e414a4")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param featureManagement Contribution id of the feature.
     * @param userScope         User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName         Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue        Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setStateForScopeAsync(ContributedFeatureState featureState,
                                                                            FeatureManagement featureManagement,
                                                                            FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                                            String scopeValue)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("dd291e43-aa9f-4cee-8465-a93c78e414a4")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param featureManagement    Contribution id of the feature.
     * @param userScope            User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName            Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue           Value of the scope (e.g. the project or team id)
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setStateForScopeAsync(ContributedFeatureState featureState,
                                                                            FeatureManagement featureManagement,
                                                                            FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                                            String scopeValue, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("dd291e43-aa9f-4cee-8465-a93c78e414a4")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Get the effective state for a list of feature ids
     *
     * @param query Features to query along with current scope values
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureStateQuery> queryAsync(ContributedFeatureStateQuery query)
            throws AzDException {
        return builder()
                .POST(query)
                .location("2b4486ad-122b-400c-ae65-17b6672c1f9d")
                .build()
                .executeAsync(ContributedFeatureStateQuery.class);
    }

    /**
     * Get the states of the specified features for the default scope
     *
     * @param query     Query describing the features to query.
     * @param userScope User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureStateQuery> queryDefaultScopeAsync(ContributedFeatureStateQuery query,
                                                                                  FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .POST(query)
                .location("3f810f28-03e2-4239-b0bc-788add3005e5")
                .serviceEndpoint("userScope", userScope.name())
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
    public CompletableFuture<ContributedFeatureStateQuery> queryNamedScopeAsync(ContributedFeatureStateQuery query,
                                                                                FeatureManagementUserScope userScope,
                                                                                FeatureManagementScopeName scopeName, String scopeValue)
            throws AzDException {
        return builder()
                .POST(query)
                .location("f29e997b-c2da-4d15-8380-765788a1a74c")
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .executeAsync(ContributedFeatureStateQuery.class);
    }

    /**
     * Get a feature by id.
     *
     * @param featureManagement Represents the id of a feature.
     * @return Contributed feature object {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeature get(FeatureManagement featureManagement) throws AzDException {
        Objects.requireNonNull(featureManagement);
        return builder()
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .build()
                .execute(ContributedFeature.class);
    }

    /**
     * Get all features.
     *
     * @return Collection of Contributed feature object {@link ContributedFeatures}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatures list() throws AzDException {
        return builder()
                .build()
                .execute(ContributedFeatures.class);
    }

    /**
     * Get the state of the specified feature for the given user/all-users scope
     *
     * @param featureManagement Contribution id of the feature.
     * @param userScope         User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState getState(FeatureManagement featureManagement, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .location("98911314-3f9b-4eaf-80e8-83900d8e85d9")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState      Posted feature state object. Should specify the effective value.
     * @param featureManagement Contribution id of the feature
     * @param userScope         User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState setState(ContributedFeatureState featureState,
                                            FeatureManagement featureManagement, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("98911314-3f9b-4eaf-80e8-83900d8e85d9")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState         Posted feature state object. Should specify the effective value.
     * @param featureManagement    Contribution id of the feature
     * @param userScope            User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState setState(ContributedFeatureState featureState,
                                            FeatureManagement featureManagement, FeatureManagementUserScope userScope,
                                            Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("98911314-3f9b-4eaf-80e8-83900d8e85d9")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Get the state of the specified feature for the given named scope
     *
     * @param featureManagement Contribution id of the feature.
     * @param userScope         User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName         Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue        Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState getStateForScope(FeatureManagement featureManagement,
                                                    FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                    String scopeValue)
            throws AzDException {
        return builder()
                .location("dd291e43-aa9f-4cee-8465-a93c78e414a4")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param featureManagement Contribution id of the feature.
     * @param userScope         User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName         Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue        Value of the scope (e.g. the project or team id)
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState setStateForScope(ContributedFeatureState featureState,
                                                    FeatureManagement featureManagement,
                                                    FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                    String scopeValue)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("dd291e43-aa9f-4cee-8465-a93c78e414a4")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature at a specific scope
     *
     * @param featureManagement    Contribution id of the feature.
     * @param userScope            User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @param scopeName            Scope at which to get the feature setting for (e.g. "project" or "team")
     * @param scopeValue           Value of the scope (e.g. the project or team id)
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState setStateForScope(ContributedFeatureState featureState,
                                                    FeatureManagement featureManagement,
                                                    FeatureManagementUserScope userScope, FeatureManagementScopeName scopeName,
                                                    String scopeValue, Consumer<RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .location("dd291e43-aa9f-4cee-8465-a93c78e414a4")
                .serviceEndpoint("featureId", featureManagement.getFeatureId())
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Get the effective state for a list of feature ids
     *
     * @param query Features to query along with current scope values
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureStateQuery query(ContributedFeatureStateQuery query)
            throws AzDException {
        return builder()
                .POST(query)
                .location("2b4486ad-122b-400c-ae65-17b6672c1f9d")
                .build()
                .execute(ContributedFeatureStateQuery.class);
    }

    /**
     * Get the states of the specified features for the default scope
     *
     * @param query     Query describing the features to query.
     * @param userScope User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state query object. {@link ContributedFeatureStateQuery}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureStateQuery queryDefaultScope(ContributedFeatureStateQuery query,
                                                          FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .POST(query)
                .location("3f810f28-03e2-4239-b0bc-788add3005e5")
                .serviceEndpoint("userScope", userScope.name())
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
    public ContributedFeatureStateQuery queryNamedScope(ContributedFeatureStateQuery query,
                                                        FeatureManagementUserScope userScope,
                                                        FeatureManagementScopeName scopeName, String scopeValue)
            throws AzDException {
        return builder()
                .POST(query)
                .location("f29e997b-c2da-4d15-8380-765788a1a74c")
                .serviceEndpoint("userScope", userScope.name())
                .serviceEndpoint("scopeName", scopeName.name())
                .serviceEndpoint("scopeValue", scopeValue)
                .build()
                .execute(ContributedFeatureStateQuery.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Reason for changing the state
         */
        @QueryParameter(name = "reason")
        public String reason;
        /**
         * Short reason code
         */
        @QueryParameter(name = "reasonCode")
        public String reasonCode;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
