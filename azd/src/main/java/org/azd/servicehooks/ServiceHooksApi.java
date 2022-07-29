package org.azd.servicehooks;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ServiceHooksDetails;
import org.azd.servicehooks.types.ServiceHooks;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;
import org.azd.utils.AzDAsyncApi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.azd.utils.RestClient.send;

/***
 * Service Hooks Api to manage service hooks service
 */
public class ServiceHooksApi extends AzDAsyncApi<ServiceHooksApi> implements ServiceHooksDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "hooks";


    /***
     * Pass the connection object to work with Service hooks Api
     * @param connection Connection object
     */
    public ServiceHooksApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Get a specific service hooks subscription.
     * @param subscriptionId ID for a subscription.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceHooksSubscription getSubscription(String subscriptionId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, null, null,
                AREA + "/subscriptions", subscriptionId, null, ApiVersion.SERVICE_HOOKS, null, null, null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscription.class);
    }

    /***
     * Get a list of subscriptions.
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceHooksSubscriptions getSubscriptions() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, null, null,
                AREA + "/subscriptions", null, null, ApiVersion.SERVICE_HOOKS, null, null, null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscriptions.class);
    }

    /***
     * Get a list of subscriptions.
     * @param consumerActionId ID for a consumerActionId.
     * @param consumerId ID for a consumer.
     * @param eventType The event type to filter on (if any).
     * @param publisherId ID for a subscription.
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceHooksSubscriptions getSubscriptions(String consumerActionId, String consumerId, String eventType, String publisherId)
            throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("publisherId", publisherId);
            put("eventType", eventType);
            put("consumerId", consumerId);
            put("consumerActionId", consumerActionId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, null, null,
                AREA + "/subscriptions", null, null, ApiVersion.SERVICE_HOOKS, q, null, null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscriptions.class);
    }

    /***
     * Delete a specific service hooks subscription.
     * @param subscriptionId ID for a subscription.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteSubscription(String subscriptionId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, null, null,
                    AREA + "/subscriptions", subscriptionId, null, ApiVersion.SERVICE_HOOKS, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Create a subscription.
     * @param serviceHooks service hooks object {@link ServiceHooks}
     *  Reference: https://docs.microsoft.com/en-us/azure/devops/service-hooks/events?view=azure-devops#workitem.created
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public ServiceHooksSubscription createSubscription(ServiceHooks serviceHooks)
            throws AzDException {

        var requestBody = new LinkedHashMap<String, Object>() {{
            put("publisherId", serviceHooks.getPublisherId());
            put("eventType", serviceHooks.getEventType());
            put("resourceVersion", serviceHooks.getResourceVersion());
            put("consumerId", serviceHooks.getConsumerId());
            put("consumerActionId", serviceHooks.getConsumerActionId());
            put("publisherInputs", serviceHooks.getPublisherInputs());
            put("consumerInputs", serviceHooks.getConsumerInputs());
        }};

        String r = send(RequestMethod.POST, CONNECTION, null, null,
                AREA + "/subscriptions", null, null, ApiVersion.SERVICE_HOOKS, null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscription.class);
    }
}
