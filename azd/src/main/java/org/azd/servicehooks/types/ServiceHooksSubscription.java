package org.azd.servicehooks.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Encapsulates an event subscription.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceHooksSubscription extends BaseAbstractMethod {
    /***
     * action description
     */
    @JsonProperty("actionDescription")
    private String actionDescription;
    /***
     * consumer action id
     */
    @JsonProperty("consumerActionId")
    private String consumerActionId;
    /***
     * consumer id
     */
    @JsonProperty("consumerId")
    private String consumerId;
    /***
     * Consumer input values
     */
    @JsonProperty("consumerInputs")
    private JsonNode consumerInputs;
    /***
     * created by
     */
    @JsonProperty("createdBy")
    private Author createdBy;
    /***
     * created date
     */
    @JsonProperty("createdDate")
    private String createdDate;
    /***
     * event description
     */
    @JsonProperty("eventDescription")
    private String eventDescription;
    /***
     * event type
     */
    @JsonProperty("eventType")
    private String eventType;
    /***
     * id
     */
    @JsonProperty("id")
    private String id;
    /***
     * modified by
     */
    @JsonProperty("modifiedBy")
    private JsonNode modifiedBy;
    /***
     * modified date
     */
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    /***
     * probation retries
     */
    @JsonProperty("probationRetries")
    private String probationRetries;
    /***
     * publisher id
     */
    @JsonProperty("publisherId")
    private String publisherId;
    /***
     * publsher inputs
     */
    @JsonProperty("publisherInputs")
    private JsonNode publisherInputs;
    /***
     * resource version
     */
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    /***
     * status
     */
    @JsonProperty("status")
    private String status;
    /***
     * subscriber
     */
    @JsonProperty("subscriber")
    private Author subscriber;
    /***
     * url
     */
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

}
