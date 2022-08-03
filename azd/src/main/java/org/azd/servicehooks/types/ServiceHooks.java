package org.azd.servicehooks.types;

import org.azd.common.types.BaseAbstractMethod;

import java.util.Map;

public class ServiceHooks extends BaseAbstractMethod {
    private String publisherId;
    private String eventType;
    private String resourceVersion;
    private String consumerId;
    private String consumerActionId;
    private Map publisherInputs;
    private Map consumerInputs;

    public ServiceHooks() {
    }

    public ServiceHooks(String publisherId, String eventType, String resourceVersion, String consumerId,
                        String consumerActionId, Map publisherInputs, Map consumerInputs) {
        this.publisherId = publisherId;
        this.eventType = eventType;
        this.resourceVersion = resourceVersion;
        this.consumerId = consumerId;
        this.consumerActionId = consumerActionId;
        this.publisherInputs = publisherInputs;
        this.consumerInputs = consumerInputs;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerActionId() {
        return consumerActionId;
    }

    public void setConsumerActionId(String consumerActionId) {
        this.consumerActionId = consumerActionId;
    }

    public Map getPublisherInputs() {
        return publisherInputs;
    }

    public void setPublisherInputs(Map publisherInputs) {
        this.publisherInputs = publisherInputs;
    }

    public Map getConsumerInputs() {
        return consumerInputs;
    }

    public void setConsumerInputs(Map consumerInputs) {
        this.consumerInputs = consumerInputs;
    }


}
