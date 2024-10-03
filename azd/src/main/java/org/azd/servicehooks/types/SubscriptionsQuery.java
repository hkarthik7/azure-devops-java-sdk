package org.azd.servicehooks.types;
/*
----------------------------------------------------------
	GENERATED FILE, should be edited to suit the purpose.
----------------------------------------------------------
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.serializer.SerializableEntity;

import java.util.List;

/**
 * None 
**/
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionsQuery extends SerializableEntity {
	/**
 	* Optional consumer action id to restrict the results to (null for any) 
	**/
	@JsonProperty("consumerActionId")
	private String consumerActionId;
	/**
 	* Optional consumer id to restrict the results to (null for any) 
	**/
	@JsonProperty("consumerId")
	private String consumerId;
	/**
 	* Filter for subscription consumer inputs 
	**/
	@JsonProperty("consumerInputFilters")
	private List<InputFilter> consumerInputFilters;
	/**
 	* Optional event type id to restrict the results to (null for any) 
	**/
	@JsonProperty("eventType")
	private String eventType;
	/**
 	* Optional publisher id to restrict the results to (null for any) 
	**/
	@JsonProperty("publisherId")
	private String publisherId;
	/**
 	* Filter for subscription publisher inputs 
	**/
	@JsonProperty("publisherInputFilters")
	private List<InputFilter> publisherInputFilters;
	/**
 	* Results from the query 
	**/
	@JsonProperty("results")
	private List<ServiceHooksSubscription> results;
	/**
 	* Optional subscriber filter. 
	**/
	@JsonProperty("subscriberId")
	private String subscriberId;

	public String getConsumerActionId() { return consumerActionId; }

	public void setConsumerActionId(String consumerActionId) { this.consumerActionId = consumerActionId; }

	public String getConsumerId() { return consumerId; }

	public void setConsumerId(String consumerId) { this.consumerId = consumerId; }

	public List<InputFilter> getConsumerInputFilters() { return consumerInputFilters; }

	public void setConsumerInputFilters(List<InputFilter> consumerInputFilters) { this.consumerInputFilters = consumerInputFilters; }

	public String getEventType() { return eventType; }

	public void setEventType(String eventType) { this.eventType = eventType; }

	public String getPublisherId() { return publisherId; }

	public void setPublisherId(String publisherId) { this.publisherId = publisherId; }

	public List<InputFilter> getPublisherInputFilters() { return publisherInputFilters; }

	public void setPublisherInputFilters(List<InputFilter> publisherInputFilters) { this.publisherInputFilters = publisherInputFilters; }

	public List<ServiceHooksSubscription> getResults() { return results; }

	public void setResults(List<ServiceHooksSubscription> results) { this.results = results; }

	public String getSubscriberId() { return subscriberId; }

	public void setSubscriberId(String subscriberId) { this.subscriberId = subscriberId; }

}