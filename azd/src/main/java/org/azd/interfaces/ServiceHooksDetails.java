package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;

import java.util.LinkedHashMap;

public interface ServiceHooksDetails {
    ServiceHooksSubscription getSubscription(String subscriptionId) throws AzDException;
    ServiceHooksSubscriptions getSubscriptions() throws AzDException;
    ServiceHooksSubscriptions getSubscriptions(String consumerActionId, String consumerId,
                                               String eventType, String publisherId) throws AzDException;
    void deleteSubscription(String subscriptionId) throws AzDException;
    ServiceHooksSubscription createSubscription(String publisherId, String eventType,
                                                String resourceVersion, String consumerId, String consumerActionId,
                                                LinkedHashMap<String, Object> publisherInputs, LinkedHashMap<String, Object> consumerInputs)
            throws AzDException;
}
