package org.azd.servicehooks.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceHooksSubscriptions {
    @JsonProperty("value")
    private List<ServiceHooksSubscription> subscriptions;

    public List<ServiceHooksSubscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<ServiceHooksSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return "ServiceHooksSubscriptions{" +
                "subscriptions=" + subscriptions +
                '}';
    }
}
