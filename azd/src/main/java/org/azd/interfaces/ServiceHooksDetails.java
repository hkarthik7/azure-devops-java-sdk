package org.azd.interfaces;

import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;

import java.util.LinkedHashMap;

public interface ServiceHooksDetails {
    ServiceHooksSubscription getSubscription(String subscriptionId) throws DefaultParametersException, AzDException;
    ServiceHooksSubscriptions getSubscriptions() throws DefaultParametersException, AzDException;
    ServiceHooksSubscriptions getSubscriptions(String consumerActionId, String consumerId,
                                               String eventType, String publisherId) throws DefaultParametersException, AzDException;
    void deleteSubscription(String subscriptionId) throws DefaultParametersException, AzDException;
    ServiceHooksSubscription createSubscription(String publisherId, String eventType,
                                                String resourceVersion, String consumerId, String consumerActionId,
                                                LinkedHashMap<String, Object> publisherInputs, LinkedHashMap<String, Object> consumerInputs)
            throws DefaultParametersException, AzDException;
}
