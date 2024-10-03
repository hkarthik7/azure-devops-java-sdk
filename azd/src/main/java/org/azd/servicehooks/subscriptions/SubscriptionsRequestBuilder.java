package org.azd.servicehooks.subscriptions;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.ApiVersion;
import org.azd.exceptions.AzDException;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;
import org.azd.servicehooks.types.SubscriptionsQuery;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Provides functionality to manage Service hooks subscriptions Api.
 */
public class SubscriptionsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public SubscriptionsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "hooks", "fc50d02a-849f-41fb-8af1-0a5216103269", ApiVersion.SERVICE_HOOKS);
    }

    /**
     * Create a subscription.
     *
     * @param subscription Subscription object to create a new subscription.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceHooksSubscription> createAsync(ServiceHooksSubscription subscription) throws AzDException {
        return builder()
                .POST(subscription)
                .build()
                .executeAsync(ServiceHooksSubscription.class);
    }

    /**
     * Query for service hook subscriptions.
     *
     * @param query Subscription query object to query.
     * @return Subscription query {@link SubscriptionsQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<SubscriptionsQuery> createQueryAsync(SubscriptionsQuery query) throws AzDException {
        return builder()
                .location("c7c3c1cf-9e05-4c0d-a425-a0f922c2c6ed")
                .POST(query)
                .build()
                .executeAsync(SubscriptionsQuery.class);
    }

    /**
     * Delete a specific service hooks subscription.
     *
     * @param subscriptionId ID for a subscription.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(String subscriptionId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("subscriptionId", subscriptionId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a specific service hooks subscription.
     *
     * @param subscriptionId ID for a subscription.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceHooksSubscription> getAsync(String subscriptionId) throws AzDException {
        return builder()
                .serviceEndpoint("subscriptionId", subscriptionId)
                .build()
                .executeAsync(ServiceHooksSubscription.class);
    }

    /**
     * Get a list of subscriptions.
     *
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceHooksSubscriptions> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(ServiceHooksSubscriptions.class);
    }

    /**
     * Get a list of subscriptions.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<ServiceHooksSubscriptions> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(ServiceHooksSubscriptions.class);
    }

    /**
     * Create a subscription.
     *
     * @param subscription Subscription object to create a new subscription.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceHooksSubscription create(ServiceHooksSubscription subscription) throws AzDException {
        return builder()
                .POST(subscription)
                .build()
                .execute(ServiceHooksSubscription.class);
    }

    /**
     * Query for service hook subscriptions.
     *
     * @param query Subscription query object to query.
     * @return Subscription query {@link SubscriptionsQuery}
     * @throws AzDException Default Api Exception handler.
     */
    public SubscriptionsQuery createQuery(SubscriptionsQuery query) throws AzDException {
        return builder()
                .location("c7c3c1cf-9e05-4c0d-a425-a0f922c2c6ed")
                .POST(query)
                .build()
                .execute(SubscriptionsQuery.class);
    }

    /**
     * Delete a specific service hooks subscription.
     *
     * @param subscriptionId ID for a subscription.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(String subscriptionId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("subscriptionId", subscriptionId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a specific service hooks subscription.
     *
     * @param subscriptionId ID for a subscription.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceHooksSubscription get(String subscriptionId) throws AzDException {
        return builder()
                .serviceEndpoint("subscriptionId", subscriptionId)
                .build()
                .execute(ServiceHooksSubscription.class);
    }

    /**
     * Get a list of subscriptions.
     *
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceHooksSubscriptions list() throws AzDException {
        return builder()
                .build()
                .execute(ServiceHooksSubscriptions.class);
    }

    /**
     * Get a list of subscriptions.
     *
     * @param requestConfiguration Represents the query parameters.
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws AzDException Default Api Exception handler.
     */
    public ServiceHooksSubscriptions list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(ServiceHooksSubscriptions.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * ID for a consumerAction.
         */
        @QueryParameter(name = "consumerActionId")
        public String consumerActionId;
        /**
         * ID for a consumer.
         */
        @QueryParameter(name = "consumerId")
        public String consumerId;
        /**
         * The event type to filter on (if any).
         */
        @QueryParameter(name = "eventType")
        public String eventType;
        /**
         * ID for a subscription.
         */
        @QueryParameter(name = "publisherId")
        public Boolean publisherId;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
