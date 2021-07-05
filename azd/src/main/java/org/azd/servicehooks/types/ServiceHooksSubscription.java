package org.azd.servicehooks.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceHooksSubscription {
    @JsonProperty("actionDescription")
    private String actionDescription;
    @JsonProperty("consumerActionId")
    private String consumerActionId;
    @JsonProperty("consumerId")
    private String consumerId;
    @JsonProperty("consumerInputs")
    private JsonNode consumerInputs;
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("eventDescription")
    private String eventDescription;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("id")
    private String id;
    @JsonProperty("modifiedBy")
    private JsonNode modifiedBy;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("probationRetries")
    private String probationRetries;
    @JsonProperty("publisherId")
    private String publisherId;
    @JsonProperty("publisherInputs")
    private JsonNode publisherInputs;
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("status")
    private String status;
    @JsonProperty("subscriber")
    private Author subscriber;
    @JsonProperty("url")
    private String url;

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getConsumerActionId() {
        return consumerActionId;
    }

    public void setConsumerActionId(String consumerActionId) {
        this.consumerActionId = consumerActionId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public JsonNode getConsumerInputs() {
        return consumerInputs;
    }

    public void setConsumerInputs(JsonNode consumerInputs) {
        this.consumerInputs = consumerInputs;
    }

    public Author getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Author createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JsonNode getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(JsonNode modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getProbationRetries() {
        return probationRetries;
    }

    public void setProbationRetries(String probationRetries) {
        this.probationRetries = probationRetries;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public JsonNode getPublisherInputs() {
        return publisherInputs;
    }

    public void setPublisherInputs(JsonNode publisherInputs) {
        this.publisherInputs = publisherInputs;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Author getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Author subscriber) {
        this.subscriber = subscriber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ServiceHooksSubscription{" +
                "actionDescription='" + actionDescription + '\'' +
                ", consumerActionId='" + consumerActionId + '\'' +
                ", consumerId='" + consumerId + '\'' +
                ", consumerInputs=" + consumerInputs +
                ", createdBy=" + createdBy +
                ", createdDate='" + createdDate + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventType='" + eventType + '\'' +
                ", id='" + id + '\'' +
                ", modifiedBy=" + modifiedBy +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", probationRetries='" + probationRetries + '\'' +
                ", publisherId='" + publisherId + '\'' +
                ", publisherInputs=" + publisherInputs +
                ", resourceVersion='" + resourceVersion + '\'' +
                ", status='" + status + '\'' +
                ", subscriber=" + subscriber +
                ", url='" + url + '\'' +
                '}';
    }
}
