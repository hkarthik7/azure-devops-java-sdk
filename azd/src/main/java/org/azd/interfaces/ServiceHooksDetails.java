package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.servicehooks.types.ServiceHooks;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;

public interface ServiceHooksDetails {
    ServiceHooksSubscription getSubscription(String subscriptionId) throws AzDException;

    ServiceHooksSubscriptions getSubscriptions() throws AzDException;

    ServiceHooksSubscriptions getSubscriptions(String consumerActionId, String consumerId,
                                               String eventType, String publisherId) throws AzDException;

    Void deleteSubscription(String subscriptionId) throws AzDException;

    ServiceHooksSubscription createSubscription(ServiceHooks serviceHooks)
            throws AzDException;
}
