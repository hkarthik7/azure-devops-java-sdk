package org.azd.servicehooks;

import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.ServiceHooks;
import org.azd.servicehooks.types.ServiceHooksSubscription;
import org.azd.servicehooks.types.ServiceHooksSubscriptions;
import org.azd.utils.AzDDefaultParameters;
import org.azd.utils.ResourceId;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.azd.utils.Client.request;

public class ServiceHooksApi implements ServiceHooks {
    /***
     * Instance of AzDDefaultParameters
     */
    private final AzDDefaultParameters DEFAULT_PARAMETERS;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "hooks";


    /***
     * Instantiate the class with instance of AzDDefaultParameters
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public ServiceHooksApi(AzDDefaultParameters defaultParameters) { this.DEFAULT_PARAMETERS = defaultParameters; }

    /***
     * Get a specific service hooks subscription.
     * @param subscriptionId ID for a subscription.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws DefaultParametersException
     * @throws AzDException
     */
    @Override
    public ServiceHooksSubscription getSubscription(String subscriptionId) throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, null, null,
                AREA + "/subscriptions",  subscriptionId, null, ServiceHooksVersion.VERSION, null,null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscription.class);
    }

    /***
     * Get a list of subscriptions.
     * @return ServiceHooksSubscriptions {@link ServiceHooksSubscriptions}
     * @throws DefaultParametersException
     * @throws AzDException
     */
    @Override
    public ServiceHooksSubscriptions getSubscriptions() throws DefaultParametersException, AzDException {
        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, null, null,
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
     * @throws DefaultParametersException
     * @throws AzDException
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

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, null, null,
                AREA + "/subscriptions",  null, null, ServiceHooksVersion.VERSION, q,null);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscriptions.class);
    }

    /***
     * Delete a specific service hooks subscription.
     * @param subscriptionId ID for a subscription.
     * @throws DefaultParametersException
     * @throws AzDException
     */
    @Override
    public void deleteSubscription(String subscriptionId) throws DefaultParametersException, AzDException {
        try {
            String r = request(RequestMethod.DELETE, DEFAULT_PARAMETERS, null, null,
                    AREA + "/subscriptions",  subscriptionId, null, ServiceHooksVersion.VERSION, null,null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (DefaultParametersException | AzDException e) {
            throw e;
        }
    }

    /***
     * Create a subscription.
     * @param publisherId Represents the parameter for request body. Specify the publisher Id.
     * @param eventType Represents the parameter for request body. Specify the event type.
     * @param resourceVersion Represents the parameter for request body. Specify the resource version.
     * @param consumerId Represents the parameter for request body. Specify the consumer id.
     * @param consumerActionId Represents the parameter for request body. Specify the consumer action id.
     * @param publisherInputs Represents the parameter for request body. Specify the publisher inputs.
     * @param consumerInputs Represents the parameter for request body. Specify the consumer inputs.
     * @return ServiceHooksSubscription {@link ServiceHooksSubscription}
     * @throws DefaultParametersException
     * @throws AzDException
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

        String r = request(RequestMethod.GET, DEFAULT_PARAMETERS, null, null,
                AREA + "/subscriptions",  null, null, ServiceHooksVersion.VERSION, null,requestBody);

        return MAPPER.mapJsonResponse(r, ServiceHooksSubscription.class);
    }
}
