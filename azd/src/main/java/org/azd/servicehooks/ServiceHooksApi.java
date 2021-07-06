package org.azd.servicehooks;

import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ServiceHooksDetails;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;
import org.azd.connection.Connection;
import org.azd.utils.Client;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.azd.utils.Client.send;

/***
 * Service Hooks Api to manage service hooks service
 */
public class ServiceHooksApi implements ServiceHooksDetails {
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
    public ServiceHooksApi(Connection connection) { this.CONNECTION = connection; }

    /***
     * Get a specific service hooks subscription.
     * @param subscriptionId ID for a subscription.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ServiceHooksSubscription getSubscription(String subscriptionId) throws DefaultParametersException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, null, null,
                AREA + "/subscriptions",  subscriptionId, null, ServiceHooksVersion.VERSION, null,null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscription.class);
    }

    /***
     * Get a list of subscriptions.
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ServiceHooksSubscriptions getSubscriptions() throws DefaultParametersException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, null, null,
                AREA + "/subscriptions",  null, null, ServiceHooksVersion.VERSION, null,null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscriptions.class);
    }

    /***
     * Get a list of subscriptions.
     * @param consumerActionId ID for a consumerActionId.
     * @param consumerId ID for a consumer.
     * @param eventType The event type to filter on (if any).
     * @param publisherId ID for a subscription.
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ServiceHooksSubscriptions getSubscriptions(String consumerActionId, String consumerId, String eventType, String publisherId)
            throws DefaultParametersException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("publisherId", publisherId);
            put("eventType", eventType);
            put("consumerId", consumerId);
            put("consumerActionId", consumerActionId);
        }};

        String r = send(RequestMethod.GET, CONNECTION, null, null,
                AREA + "/subscriptions",  null, null, ServiceHooksVersion.VERSION, q,null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscriptions.class);
    }

    /***
     * Delete a specific service hooks subscription.
     * @param subscriptionId ID for a subscription.
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public void deleteSubscription(String subscriptionId) throws DefaultParametersException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, null, null,
                    AREA + "/subscriptions",  subscriptionId, null, ServiceHooksVersion.VERSION, null,null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Create a subscription.
     * @param publisherId Represents the parameter for request body. Specify the publisher Id. E.g., tfs;
     * @param eventType Represents the parameter for request body. Specify the event type. E.g., workitem.created;
     * @param resourceVersion Represents the parameter for request body. Specify the resource version. E.g., 1.0;
     * @param consumerId Represents the parameter for request body. Specify the consumer id. E.g., webHooks;
     * @param consumerActionId Represents the parameter for request body. Specify the consumer action id. E.g., httpRequest;
     * @param publisherInputs Represents the parameter for request body. Specify the publisher inputs.
     * @param consumerInputs Represents the parameter for request body. Specify the consumer inputs.
     *  Reference: https://docs.microsoft.com/en-us/azure/devops/service-hooks/events?view=azure-devops#workitem.created
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws DefaultParametersException set the default parameters organization name, project name and
     * personal access token to work with any API in this library.
     * @throws AzDException Handles errors from REST API and validates passed arguments
     */
    @Override
    public ServiceHooksSubscription createSubscription(String publisherId, String eventType,
                                                       String resourceVersion, String consumerId,
                                                       String consumerActionId, LinkedHashMap<String, Object> publisherInputs,
                                                       LinkedHashMap<String, Object> consumerInputs)
            throws DefaultParametersException, AzDException {

        var requestBody = new LinkedHashMap<String, Object>(){{
            put("publisherId", publisherId);
            put("eventType", eventType);
            put("resourceVersion", resourceVersion);
            put("consumerId", consumerId);
            put("consumerActionId", consumerActionId);
            put("publisherInputs", publisherInputs);
            put("consumerInputs", consumerInputs);
        }};

        String r = send(RequestMethod.POST, CONNECTION, null, null,
                AREA + "/subscriptions",  null, null, ServiceHooksVersion.VERSION, null,requestBody);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscription.class);
    }
}
