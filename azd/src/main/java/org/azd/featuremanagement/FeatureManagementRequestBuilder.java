package org.azd.featuremanagement;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.enums.FeatureManagement;
import org.azd.exceptions.AzDException;
import org.azd.featuremanagement.scope.StateScopeRequestBuilder;
import org.azd.featuremanagement.state.StateRequestBuilder;
import org.azd.featuremanagement.types.ContributedFeature;
import org.azd.featuremanagement.types.ContributedFeatureStateQuery;
import org.azd.featuremanagement.types.ContributedFeatures;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

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
     * Represents Feature management state API.
     *
     * @return StateRequestBuilder {@link StateRequestBuilder}
     */
    public StateRequestBuilder state() {
        return new StateRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Represents Feature management state scope API.
     *
     * @return StateScopeRequestBuilder {@link StateScopeRequestBuilder}
     */
    public StateScopeRequestBuilder stateScope() {
        return new StateScopeRequestBuilder(organizationUrl, accessTokenCredential);
    }

    /**
     * Get a feature by id.
     *
     * @param feature Represents the id of a feature.
     * @return Contributed feature object {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public CompletableFuture<ContributedFeature> getAsync(FeatureManagement feature) throws AzDException {
        Objects.requireNonNull(feature);
        return builder()
                .serviceEndpoint("featureId", feature.getFeatureId())
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
     * Get a feature by id.
     *
     * @param feature Represents the id of a feature.
     * @return Contributed feature object {@link ContributedFeature}
     * @throws AzDException Default Api exception handler.
     */
    public ContributedFeature get(FeatureManagement feature) throws AzDException {
        Objects.requireNonNull(feature);
        return builder()
                .serviceEndpoint("featureId", feature.getFeatureId())
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
