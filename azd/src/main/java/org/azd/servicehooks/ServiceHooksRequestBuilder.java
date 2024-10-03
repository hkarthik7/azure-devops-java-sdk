package org.azd.servicehooks;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.authentication.AccessTokenCredential;
import org.azd.servicehooks.subscriptions.SubscriptionsRequestBuilder;

/**
 * Provides functionality to work with Service hooks Api.
 */
public class ServiceHooksRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public ServiceHooksRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential);
    }

    /**
     * Provides functionality to manage Service hooks subscriptions Api.
     *
     * @return SubscriptionsRequestBuilder {@link SubscriptionsRequestBuilder}
     */
    public SubscriptionsRequestBuilder subscriptions() {
        return new SubscriptionsRequestBuilder(organizationUrl, accessTokenCredential);
    }

}
