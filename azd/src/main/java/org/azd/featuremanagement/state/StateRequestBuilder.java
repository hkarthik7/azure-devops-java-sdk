package org.azd.featuremanagement.state;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.FeatureManagement;
import org.azd.enums.FeatureManagementUserScope;
import org.azd.exceptions.AzDException;
import org.azd.featuremanagement.FeatureManagementRequestBuilder;
import org.azd.featuremanagement.types.ContributedFeature;
import org.azd.featuremanagement.types.ContributedFeatureState;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Request builder to manage Feature management state Api.
 */
public class StateRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public StateRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "featuremanagement", "98911314-3f9b-4eaf-80e8-83900d8e85d9",
                ApiVersion.FEATURE_MANAGEMENT);
    }

    /**
     * Get the state of the specified feature for the given user/all-users scope
     *
     * @param feature   Contribution id of the feature.
     * @param userScope User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> getAsync(FeatureManagement feature, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState Posted feature state object. Should specify the effective value.
     * @param feature      Contribution id of the feature
     * @param userScope    User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setAsync(ContributedFeatureState featureState,
                                                               FeatureManagement feature, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState         Posted feature state object. Should specify the effective value.
     * @param feature              Contribution id of the feature
     * @param userScope            User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeatureState> setAsync(ContributedFeatureState featureState,
                                                               FeatureManagement feature, FeatureManagementUserScope userScope,
                                                               Consumer<FeatureManagementRequestBuilder.RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .query(FeatureManagementRequestBuilder.RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ContributedFeatureState.class);
    }

    /**
     * Get the state of the specified feature for the given user/all-users scope
     *
     * @param feature   Contribution id of the feature.
     * @param userScope User-Scope at which to get the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature state object. {@link ContributedFeatureState}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState get(FeatureManagement feature, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState Posted feature state object. Should specify the effective value.
     * @param feature      Contribution id of the feature
     * @param userScope    User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState set(ContributedFeatureState featureState,
                                       FeatureManagement feature, FeatureManagementUserScope userScope)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .build()
                .execute(ContributedFeatureState.class);
    }

    /**
     * Set the state of a feature
     *
     * @param featureState         Posted feature state object. Should specify the effective value.
     * @param feature              Contribution id of the feature
     * @param userScope            User-Scope at which to set the value. Should be "me" for the current user or "host" for all users.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Contributed feature object. {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeatureState set(ContributedFeatureState featureState,
                                       FeatureManagement feature, FeatureManagementUserScope userScope,
                                       Consumer<FeatureManagementRequestBuilder.RequestConfiguration> requestConfiguration)
            throws AzDException {
        return builder()
                .PATCH(featureState)
                .serviceEndpoint("featureId", feature.getFeatureId())
                .serviceEndpoint("userScope", userScope.getUserScope())
                .query(FeatureManagementRequestBuilder.RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ContributedFeatureState.class);
    }
}
