package org.azd.policy;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.PolicyDetails;
import org.azd.policy.types.PolicyConfiguration;
import org.azd.policy.types.PolicyConfigurations;
import org.azd.policy.types.PolicyType;
import org.azd.policy.types.PolicyTypes;
import org.azd.utils.AzDAsyncApi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.azd.utils.RestClient.send;

/***
 * PolicyApi class to manage Policy API
 */
public class PolicyApi extends AzDAsyncApi<PolicyApi> implements PolicyDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "policy";
    private final String POLICY = "fb13a388-40dd-4a04-b530-013a739c72ef";

    /***
     * Pass the connection object to work with Policy Api
     * @param connection Connection object
     */
    public PolicyApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Create a policy configuration of a given policy type.
     * @param typeId Guid of the policy type.
     * @param isEnabled If set to true the policy will be enabled.
     * @param isBlocking If set to true direct commit will be blocked to the branch specified.
     * @param settings A Map of user specified settings.
     * Check https://docs.microsoft.com/en-us/rest/api/azure/devops/policy/configurations/create?view=azure-devops-rest-6.1#examples
     * for more examples and how to configure the policy.
     * @return PolicyConfiguration object {@link PolicyConfiguration}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PolicyConfiguration createPolicyConfiguration(String typeId, boolean isEnabled, boolean isBlocking, Map settings) throws AzDException {
        LinkedHashMap<String, Object> h = new LinkedHashMap<>() {{
            put("isEnabled", isEnabled);
            put("isBlocking", isBlocking);
            put("type", new LinkedHashMap<String, String>() {{
                put("id", typeId);
            }});
            put("settings", settings);
        }};

        String r = send(RequestMethod.POST, CONNECTION, POLICY, CONNECTION.getProject(),
                AREA + "/configurations", null, null, ApiVersion.POLICY, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, PolicyConfiguration.class);
    }

    /***
     * Delete a policy configuration by its ID.
     * @param configurationId ID of the policy configuration to delete.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deletePolicyConfiguration(int configurationId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, POLICY, CONNECTION.getProject(),
                    AREA + "/configurations", Integer.toString(configurationId), null, ApiVersion.POLICY, null, null, null);
            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get a policy configuration by its ID.
     * @param configurationId ID of the policy configuration
     * @return PolicyConfiguration object {@link PolicyConfiguration}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PolicyConfiguration getPolicyConfiguration(int configurationId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, POLICY, CONNECTION.getProject(),
                AREA + "/configurations", Integer.toString(configurationId), null, ApiVersion.POLICY, null, null, null);

        return MAPPER.mapJsonResponse(r, PolicyConfiguration.class);
    }

    /***
     * Get a list of policy configurations in a project.
     * @return PolicyConfigurations object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PolicyConfigurations getPolicyConfigurations() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, POLICY, CONNECTION.getProject(),
                AREA + "/configurations", null, null, ApiVersion.POLICY, null, null, null);

        return MAPPER.mapJsonResponse(r, PolicyConfigurations.class);
    }

    /***
     * Get a list of policy configurations in a project.
     * @param top Maximum number of policies to return.
     * @param continuationToken The continuation token used for pagination.
     * @param policyType Filter returned policies to only this type
     * @return PolicyConfigurations object {@link PolicyConfigurations}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PolicyConfigurations getPolicyConfigurations(int top, String continuationToken, String policyType) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
            put("continuationToken", continuationToken);
            put("policyType", policyType);
        }};

        String r = send(RequestMethod.GET, CONNECTION, POLICY, CONNECTION.getProject(),
                AREA + "/configurations", null, null, ApiVersion.POLICY, null, null, null);

        return MAPPER.mapJsonResponse(r, PolicyConfigurations.class);
    }

    /***
     * Update a policy configuration by its ID.
     * @param configurationId ID of the existing policy configuration to be updated.
     * @param typeId Guid of the configuration policy type.
     * @param isEnabled If set to true the policy will be enabled.
     * @param isBlocking If set to true direct commit will be blocked to the branch specified.
     * @param settings A Map of user specified settings.
     * Check https://docs.microsoft.com/en-us/rest/api/azure/devops/policy/configurations/update?view=azure-devops-rest-6.1#examples
     * for more examples and how to configure the policy.
     * @return PolicyConfiguration object {@link PolicyConfiguration}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PolicyConfiguration updatePolicyConfiguration(int configurationId, String typeId, boolean isEnabled, boolean isBlocking, Map settings)
            throws AzDException {
        String id;

        if (typeId.isEmpty()) id = getPolicyConfiguration(configurationId).getType().getId();
        else id = typeId;

        LinkedHashMap<String, Object> h = new LinkedHashMap<>() {{
            put("isEnabled", isEnabled);
            put("isBlocking", isBlocking);
            put("type", new LinkedHashMap<String, String>() {{
                put("id", id);
            }});
            put("settings", settings);
        }};

        String r = send(RequestMethod.PUT, CONNECTION, POLICY, CONNECTION.getProject(),
                AREA + "/configurations", Integer.toString(configurationId), null, ApiVersion.POLICY, null, h, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, PolicyConfiguration.class);
    }

    /***
     * Retrieve a specific policy type by ID.
     * @param typeId Guid of the configuration policy type.
     * @return PolicyType object {@link PolicyType}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PolicyType getPolicyType(String typeId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, POLICY, CONNECTION.getProject(),
                AREA + "/types", typeId, null, ApiVersion.POLICY, null, null, null);

        return MAPPER.mapJsonResponse(r, PolicyType.class);
    }

    /***
     * Retrieve all available policy types.
     * @return PolicyTypes object {@link PolicyTypes}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public PolicyTypes getPolicyTypes() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, POLICY, CONNECTION.getProject(),
                AREA + "/types", null, null, ApiVersion.POLICY, null, null, null);

        return MAPPER.mapJsonResponse(r, PolicyTypes.class);
    }
}
