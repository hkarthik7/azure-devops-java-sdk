package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;

import java.util.LinkedHashMap;

public interface ServiceHooksDetails {
    ServiceHooksSubscription getSubscription(String subscriptionId) throws ConnectionException, AzDException;
    ServiceHooksSubscriptions getSubscriptions() throws ConnectionException, AzDException;
    ServiceHooksSubscriptions getSubscriptions(String consumerActionId, String consumerId,
                                               String eventType, String publisherId) throws ConnectionException, AzDException;
    void deleteSubscription(String subscriptionId) throws ConnectionException, AzDException;
    ServiceHooksSubscription createSubscription(String publisherId, String eventType,
                                                String resourceVersion, String consumerId, String consumerActionId,
                                                LinkedHashMap<String, Object> publisherInputs, LinkedHashMap<String, Object> consumerInputs)
            throws ConnectionException, AzDException;
}
