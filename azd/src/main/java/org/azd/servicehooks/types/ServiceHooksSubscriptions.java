package org.azd.servicehooks.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableCollectionEntity;

import java.util.List;

/**
 * List of service hook subscription
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceHooksSubscriptions extends SerializableCollectionEntity {
    /**
     * List of service hook subscription
     */
    @JsonProperty("value")
    private List<ServiceHooksSubscription> subscriptions;

    public List<ServiceHooksSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<ServiceHooksSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

}
