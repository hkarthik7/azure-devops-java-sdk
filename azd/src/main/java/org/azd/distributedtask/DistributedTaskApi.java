package org.azd.distributedtask;

import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.core.CoreApi;
import org.azd.distributedtask.types.*;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.DistributedTaskDetails;
import org.azd.release.types.ProjectReference;
import org.azd.utils.AzDAsyncApi;

import java.util.*;

import static org.azd.utils.RestClient.send;

/***
 * DistributedTaskApi class to manage Agents, Deployment groups, Environments and Variable groups API
 */
public class DistributedTaskApi extends AzDAsyncApi<DistributedTaskApi> implements DistributedTaskDetails {
    /***
     * Connection object
     */
    private final Connection CONNECTION;
    private final JsonMapper MAPPER = new JsonMapper();
    private final String AREA = "distributedtask";
    private final String DISTRIBUTEDTASK = "a85b8835-c1a1-4aac-ae97-1c3d0ba72dbd";

    /***
     * Pass the connection object
     * @param connection Connection object
     */
    public DistributedTaskApi(Connection connection) {
        this.CONNECTION = connection;
    }

    /***
     * Delete an agent.
     * @param poolId The pool ID to remove the agent from
     * @param agentId The agent ID to remove
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteAgent(int poolId, int agentId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, null,
                    AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK,
                    null, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get information about an agent.
     * @param poolId The agent pool containing the agent
     * @param agentId The agent ID to get information about
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TaskAgent getAgent(int poolId, int agentId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK,
                null, null, null);

        return MAPPER.mapJsonResponse(r, TaskAgent.class);
    }

    /***
     * Get information about an agent.
     * @param poolId The agent pool containing the agent
     * @param agentId The agent ID to get information about
     * @param includeAssignedRequest Whether to include details about the agent's current work
     * @param includeCapabilities Whether to include the agent's capabilities in the response
     * @param includeLastCompletedRequest Whether to include details about the agents' most recent completed work
     * @param propertyFilters Filter which custom properties will be returned
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TaskAgent getAgent(int poolId, int agentId, boolean includeAssignedRequest, boolean includeCapabilities,
                              boolean includeLastCompletedRequest, String[] propertyFilters) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("includeAssignedRequest", includeAssignedRequest);
            put("includeCapabilities", includeCapabilities);
            put("includeLastCompletedRequest", includeLastCompletedRequest);
            put("propertyFilters", String.join(",", propertyFilters));
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, TaskAgent.class);
    }

    /***
     * Get a list of agents.
     * @param poolId The agent pool containing the agents
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TaskAgents getAgents(int poolId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents", null, ApiVersion.DISTRIBUTED_TASK, null, null, null);

        return MAPPER.mapJsonResponse(r, TaskAgents.class);
    }

    /***
     * Get a list of agents.
     * @param poolId The agent pool containing the agents
     * @param agentName Filter on agent name
     * @param demands Filter by demands the agents can satisfy
     * @param includeAssignedRequest Whether to include details about the agents' current work
     * @param includeCapabilities Whether to include the agents' capabilities in the response
     * @param includeLastCompletedRequest Whether to include details about the agents' most recent completed work
     * @param propertyFilters Filter which custom properties will be returned
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TaskAgents getAgents(int poolId, String agentName, String[] demands, boolean includeAssignedRequest,
                                boolean includeCapabilities, boolean includeLastCompletedRequest, String[] propertyFilters)
            throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("agentName", agentName);
            put("demands", String.join(",", demands));
            put("includeAssignedRequest", includeAssignedRequest);
            put("includeCapabilities", includeCapabilities);
            put("includeLastCompletedRequest", includeLastCompletedRequest);
            put("propertyFilters", String.join(",", propertyFilters));
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents", null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, TaskAgents.class);
    }

    /***
     * Update agent details.
     * @param poolId The agent pool to use
     * @param agentId The agent to update
     * @param requestBody Map of request body.
     * <p>
     *  Visit https://docs.microsoft.com/en-us/rest/api/azure/devops/distributedtask/agents/update?view=azure-devops-rest-7.1#request-body for more details.
     * </p>
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TaskAgent updateAgent(int poolId, int agentId, TaskAgent requestBody) throws AzDException {
        String r = send(RequestMethod.PATCH, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK,
                null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, TaskAgent.class);
    }

    /***
     * Create a deployment group.
     * @param name Name of the deployment group.
     * @param description Description of the deployment group.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroup addDeploymentGroup(String name, String description) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK,
                null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    /***
     * Create a deployment group.
     * @param name Name of the deployment group.
     * @param description Description of the deployment group.
     * @param poolId Identifier of the deployment pool in which deployment agents are registered.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroup addDeploymentGroup(String name, String description, int poolId) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
            put("poolId", poolId);
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK,
                null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    /***
     * Delete a deployment group.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteDeploymentGroup(int deploymentGroupId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                    AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK, null, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get a deployment group by its ID.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroup getDeploymentGroup(int deploymentGroupId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK, null, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    /***
     * Get a deployment group by its ID.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @param expand Include these additional details in the returned object.
     * @param actionFilter Get the deployment group only if this action can be performed on it.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroup getDeploymentGroup(int deploymentGroupId, DeploymentGroupExpands expand, DeploymentGroupActionFilter actionFilter)
            throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
            put("actionFilter", actionFilter.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, null, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param top Maximum number of deployment groups to return. Default is 1000.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param ids Array of Id of deployment groups.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(int[] ids) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("ids", intArrayToString(ids));
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param name Name of the deployment group.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(String name) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param expand Include these additional details in the returned objects. {@link DeploymentGroupExpands}
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param expand Include these additional details in the returned objects. {@link DeploymentGroupExpands}
     * @param top Maximum number of deployment groups to return. Default is 1000.
     * @param actionFilter Get only deployment groups on which this action can be performed. {@link DeploymentGroupActionFilter}
     * @param continuationToken Get deployment groups with names greater than this continuationToken lexicographically.
     * @param ids Comma separated list of IDs of the deployment groups.
     * @param name Name of the deployment group.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand, int top, DeploymentGroupActionFilter actionFilter,
                                                String continuationToken, int[] ids, String name) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$expand", expand.toString().toLowerCase());
            put("$top", top);
            put("actionFilter", actionFilter.toString().toLowerCase());
            put("continuationToken", continuationToken);
            put("ids", intArrayToString(ids));
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    /***
     * Update a deployment group.
     * @param deploymentGroupId ID of the deployment group.
     * @param name Name of the deployment group.
     * @param description Description of the deployment group.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroup updateDeploymentGroup(int deploymentGroupId, String name, String description) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK,
                null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    /***
     * Create an environment.
     * @param name Name of the environment.
     * @param description Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstance addEnvironment(String name, String description) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    /***
     * Delete the specified environment.
     * @param environmentId ID of the environment.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteEnvironment(int environmentId) throws AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                    AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK, null, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get an environment by its ID.
     * @param environmentId ID of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstance getEnvironment(int environmentId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK,
                null, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    /***
     * Get an environment by its ID.
     * @param environmentId ID of the environment.
     * @param expands Include these additional details in the returned objects. {@link EnvironmentExpands}
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstance getEnvironment(int environmentId, EnvironmentExpands expands) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("expands", expands.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    /***
     * Get all environments.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstances getEnvironments() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, null, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    /***
     * Get all environments.
     * @param top Top environments to list
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstances getEnvironments(int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    /***
     * Get all environments.
     * @param name Name of the environment.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstances getEnvironments(String name) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    /***
     * Get all environments.
     * @param top Top environments to list.
     * @param continuationToken Get the list of environments paginated.
     * @param name Name of the environment.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstances getEnvironments(int top, String continuationToken, String name) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
            put("continuationToken", continuationToken);
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, q, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    /***
     * Update the specified environment.
     * @param environmentId ID of the environment.
     * @param name Name of the environment.
     * @param description Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstance updateEnvironment(int environmentId, String name, String description) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK,
                null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    /***
     * Add a variable group.
     * @param variableGroupDefinition Variable group definition {@link VariableGroupDefinition}
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroup addVariableGroup(VariableGroupDefinition variableGroupDefinition)
            throws AzDException {
        var ref = new VariableGroupProjectReference();
        ref.setName(variableGroupDefinition.getName());
        ref.setDescription(variableGroupDefinition.getDescription());
        ref.setProjectReference(variableGroupDefinition.getProjectReference());

        List<Object> o = new ArrayList<>();
        o.add(ref);

        var requestBody = new HashMap<String, Object>() {{
            put("variableGroupProjectReferences", o);
            put("name", variableGroupDefinition.getName());
            put("description", variableGroupDefinition.getDescription());
            put("type", variableGroupDefinition.getType());
            put("variables", variableGroupDefinition.getVariables());
            put("providerData", variableGroupDefinition.getProviderData());
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, VariableGroup.class);
    }

    /***
     * Add a variable group.
     * @param name Name of the variable group.
     * @param description Description for the variable group.
     * @param variables Map of variables to add.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroup addVariableGroup(String name, String description, VariableGroupMap variables) throws AzDException {
        var definition = new VariableGroupDefinition();
        var projectReference = new ProjectReference();
        var core = new CoreApi(CONNECTION);
        var project = core.getProject(CONNECTION.getProject());

        projectReference.setName(project.getName());
        projectReference.setId(project.getId());

        definition.setName(name);
        definition.setDescription(description);
        definition.setVariables(variables.get());
        definition.setProjectReference(projectReference);
        definition.setType(VariableGroupType.Vsts);

        return addVariableGroup(definition);
    }

    /***
     * Delete a variable group
     * @param variableGroupId Id of the variable group.
     * @param projectIds String array of project ids.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteVariableGroup(int variableGroupId, String[] projectIds) throws AzDException {
        try {
            var q = new HashMap<String, Object>() {{
                put("projectIds", String.join(",", projectIds));
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, null,
                    AREA + "/variablegroups", Integer.toString(variableGroupId), null, ApiVersion.VARIABLE_GROUPS, q, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (AzDException e) {
            throw e;
        }
        return null;
    }

    /***
     * Get a variable group.
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroup getVariableGroup(int variableGroupId) throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", Integer.toString(variableGroupId), null, ApiVersion.VARIABLE_GROUPS, null, null, null);

        return MAPPER.mapJsonResponse(r, VariableGroup.class);
    }

    /***
     * Get variable groups.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroups getVariableGroups() throws AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, null, null, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    /***
     * Get variable groups.
     * @param top Number of variable groups to get.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroups getVariableGroups(int top) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, q, null, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    /***
     * Get variable groups.
     * @param groupName Name of variable group.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroups getVariableGroups(String groupName) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("groupName", groupName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, q, null, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    /***
     * Get variable groups.
     * @param top Number of variable groups to get.
     * @param actionFilter Action filter for the variable group. It specifies the action which can be performed on the variable groups. {@link VariableGroupActionFilter}
     * @param continuationToken Gets the variable groups after the continuation token provided.
     * @param groupName Name of variable group.
     * @param queryOrder Gets the results in the defined order. Default is 'IdDescending'. {@link VariableGroupQueryOrder}
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroups getVariableGroups(int top, VariableGroupActionFilter actionFilter, int continuationToken, String groupName,
                                            VariableGroupQueryOrder queryOrder) throws AzDException {
        var q = new HashMap<String, Object>() {{
            put("$top", top);
            put("actionFilter", actionFilter.toString().toLowerCase());
            put("continuationToken", continuationToken);
            put("groupName", groupName);
            put("queryOrder", queryOrder.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, q, null, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    /***
     * Update a variable group.
     * @param groupId Id of the variable group to update.
     * @param name Sets name of the variable group.
     * @param description Sets description of the variable group.
     * @param variables Sets variables contained in the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroup updateVariableGroup(int groupId, String name, String description, VariableGroupMap variables) throws AzDException {
        var definition = new VariableGroupDefinition();
        var projectReference = new ProjectReference();
        var core = new CoreApi(CONNECTION);
        var project = core.getProject(CONNECTION.getProject());

        projectReference.setName(project.getName());
        projectReference.setId(project.getId());

        definition.setName(name);
        definition.setDescription(description);
        definition.setVariables(variables.get());
        definition.setProjectReference(projectReference);
        definition.setType(VariableGroupType.Vsts);

        return updateVariableGroup(groupId, definition);
    }

    /***
     * Update a variable group.
     * @param groupId Id of the variable group to update.
     * @param variableGroupDefinition Variable group definition {@link VariableGroupDefinition}
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroup updateVariableGroup(int groupId, VariableGroupDefinition variableGroupDefinition) throws AzDException {
        var ref = new VariableGroupProjectReference();
        ref.setName(variableGroupDefinition.getName());
        ref.setDescription(variableGroupDefinition.getDescription());
        ref.setProjectReference(variableGroupDefinition.getProjectReference());

        List<Object> o = new ArrayList<>();
        o.add(ref);

        var requestBody = new HashMap<String, Object>() {{
            put("variableGroupProjectReferences", o);
            put("name", variableGroupDefinition.getName());
            put("description", variableGroupDefinition.getDescription());
            put("type", variableGroupDefinition.getType());
            put("variables", variableGroupDefinition.getVariables());
            put("providerData", variableGroupDefinition.getProviderData());
        }};

        String r = send(RequestMethod.PUT, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/variablegroups", Integer.toString(groupId), null, ApiVersion.VARIABLE_GROUPS,
                null, requestBody, CustomHeader.JSON_CONTENT_TYPE);

        return MAPPER.mapJsonResponse(r, VariableGroup.class);
    }

    /***
     * Helper method to convert integer array to string.
     * @param i integer array
     * @return {@link String}
     */
    private String intArrayToString(int[] i) {
        var r = Arrays.stream(i).mapToObj(String::valueOf).toArray(String[]::new);
        return String.join(",", r);
    }
}
