package org.azd.distributedtask;

import org.azd.distributedtask.deploymentgroups.DeploymentGroupsRequestBuilder;
import org.azd.distributedtask.types.*;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.helpers.AzDHelpers;
import org.azd.interfaces.DistributedTaskDetails;
import org.azd.release.types.ProjectReference;
import org.azd.serviceClient.AzDServiceClient;
import org.azd.utils.AzDAsyncApi;

import java.util.List;

/***
 * DistributedTaskApi class to manage Agents, Deployment groups, Environments and Variable groups API
 */
public class DistributedTaskApi extends AzDAsyncApi<DistributedTaskApi> implements DistributedTaskDetails {
    /**
     * Distributed task request builder object to manage DistributedTask API.
     */
    private final DistributedTaskRequestBuilder BUILDER;
    private final AzDServiceClient CLIENT;

    /**
     * Requires the instance of AzDServiceClient.
     * @param client Pass the instance of {@link AzDServiceClient}
     */
    public DistributedTaskApi(AzDServiceClient client) {
        CLIENT = client;
        BUILDER = client.distributedTask();
    }

    /***
     * Delete an agent.
     * @param poolId The pool ID to remove the agent from
     * @param agentId The agent ID to remove
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteAgent(int poolId, int agentId) throws AzDException {
        return BUILDER.agents().delete(poolId, agentId);
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
        return BUILDER.agents().get(poolId, agentId);
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
        return BUILDER.agents().get(poolId, agentId, r -> {
            r.queryParameters.includeAssignedRequest = includeAssignedRequest;
            r.queryParameters.includeCapabilities = includeCapabilities;
            r.queryParameters.includeLastCompletedRequest = includeLastCompletedRequest;
            r.queryParameters.propertyFilters = AzDHelpers.toString(propertyFilters);
        });
    }

    /***
     * Get a list of agents.
     * @param poolId The agent pool containing the agents
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TaskAgents getAgents(int poolId) throws AzDException {
        return BUILDER.agents().list(poolId);
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
        return BUILDER.agents().list(poolId, r -> {
           r.queryParameters.agentName = agentName;
           r.queryParameters.includeAssignedRequest = includeAssignedRequest;
           r.queryParameters.includeCapabilities = includeCapabilities;
           r.queryParameters.propertyFilters = AzDHelpers.toString(propertyFilters);
           r.queryParameters.includeLastCompletedRequest = includeLastCompletedRequest;
           r.queryParameters.demands = AzDHelpers.toString(demands);
        });
    }

    /***
     * Update agent details.
     * @param poolId The agent pool to use
     * @param agentId The agent to update
     * @param requestBody Map of request body.
     * @see <a href="https://docs.microsoft.com/en-us/rest/api/azure/devops/distributedtask/agents/update?view=azure-devops-rest-7.1#request-body">Request body</a>
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public TaskAgent updateAgent(int poolId, int agentId, TaskAgent requestBody) throws AzDException {
        return BUILDER.agents().update(poolId, agentId, requestBody);
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
        var deploymentGroup = new DeploymentGroupsRequestBuilder.DeploymentGroupRequest();
        deploymentGroup.name = name;
        deploymentGroup.description = description;

        return BUILDER.deploymentGroups().add(deploymentGroup);
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
        var deploymentGroup = new DeploymentGroupsRequestBuilder.DeploymentGroupRequest();
        deploymentGroup.name = name;
        deploymentGroup.description = description;
        deploymentGroup.poolId = poolId;

        return BUILDER.deploymentGroups().add(deploymentGroup);
    }

    /***
     * Delete a deployment group.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteDeploymentGroup(int deploymentGroupId) throws AzDException {
        return BUILDER.deploymentGroups().delete(deploymentGroupId);
    }

    /***
     * Get a deployment group by its ID.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroup getDeploymentGroup(int deploymentGroupId) throws AzDException {
        return BUILDER.deploymentGroups().get(deploymentGroupId);
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
        return BUILDER.deploymentGroups().get(deploymentGroupId, r -> {
            r.queryParameters.expand = expand;
            r.queryParameters.actionFilter = actionFilter;
        });
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups() throws AzDException {
        return BUILDER.deploymentGroups().list();
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param top Maximum number of deployment groups to return. Default is 1000.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(int top) throws AzDException {
        return BUILDER.deploymentGroups().list(r -> r.queryParameters.top = top);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param ids Array of Id of deployment groups.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(int[] ids) throws AzDException {
        return BUILDER.deploymentGroups().list(r -> r.queryParameters.ids = AzDHelpers.toString(ids));
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param name Name of the deployment group.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(String name) throws AzDException {
        return BUILDER.deploymentGroups().list(r -> r.queryParameters.name = name);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param expand Include these additional details in the returned objects. {@link DeploymentGroupExpands}
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand) throws AzDException {
        return BUILDER.deploymentGroups().list(r -> r.queryParameters.expand = expand);
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
        return BUILDER.deploymentGroups().list(r -> {
            r.queryParameters.expand = expand;
            r.queryParameters.top = top;
            r.queryParameters.name = name;
            r.queryParameters.ids = AzDHelpers.toString(ids);
            r.queryParameters.actionFilter = actionFilter;
            r.queryParameters.continuationToken = continuationToken;
        });
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
        return BUILDER.deploymentGroups().update(deploymentGroupId, name, description);
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
        return BUILDER.environments().add(name, description);
    }

    /***
     * Delete the specified environment.
     * @param environmentId ID of the environment.
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public Void deleteEnvironment(int environmentId) throws AzDException {
        return BUILDER.environments().delete(environmentId);
    }

    /***
     * Get an environment by its ID.
     * @param environmentId ID of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstance getEnvironment(int environmentId) throws AzDException {
        return BUILDER.environments().get(environmentId);
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
        return BUILDER.environments().get(environmentId, expands);
    }

    /***
     * Get all environments.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstances getEnvironments() throws AzDException {
        return BUILDER.environments().list();
    }

    /***
     * Get all environments.
     * @param top Top environments to list
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstances getEnvironments(int top) throws AzDException {
        return BUILDER.environments().list(r -> r.queryParameters.top = top);
    }

    /***
     * Get all environments.
     * @param name Name of the environment.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public EnvironmentInstances getEnvironments(String name) throws AzDException {
        return BUILDER.environments().list(r -> r.queryParameters.name = name);
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
        return BUILDER.environments().list(r -> {
            r.queryParameters.name = name;
            r.queryParameters.continuationToken = continuationToken;
            r.queryParameters.top = top;
        });
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
        return BUILDER.environments().update(environmentId, name, description);
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

        var variableGroupLibrary = new VariableGroupLibrary();
        variableGroupLibrary.name = variableGroupDefinition.getName();
        variableGroupLibrary.description = variableGroupDefinition.getDescription();
        variableGroupLibrary.type = variableGroupDefinition.getType().name();

        var ref = new VariableGroupProjectReference();
        ref.setName(variableGroupDefinition.getName());
        ref.setDescription(variableGroupDefinition.getDescription());
        ref.setProjectReference(variableGroupDefinition.getProjectReference());

        variableGroupLibrary.variableGroupProjectReferences = List.of(ref);
        variableGroupLibrary.providerData = variableGroupDefinition.getProviderData();
        variableGroupLibrary.variables = variableGroupDefinition.getVariables();

        return BUILDER.variableGroups().add(variableGroupLibrary);
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
        var project = CLIENT.core().projects().get();

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
        return BUILDER.variableGroups().delete(variableGroupId, projectIds);
    }

    /***
     * Get a variable group.
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroup getVariableGroup(int variableGroupId) throws AzDException {
        return BUILDER.variableGroups().get(variableGroupId);
    }

    /***
     * Get variable groups.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroups getVariableGroups() throws AzDException {
        return BUILDER.variableGroups().list();
    }

    /***
     * Get variable groups.
     * @param top Number of variable groups to get.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroups getVariableGroups(int top) throws AzDException {
        return BUILDER.variableGroups().list(r -> r.queryParameters.top = top);
    }

    /***
     * Get variable groups.
     * @param groupName Name of variable group.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    @Override
    public VariableGroups getVariableGroups(String groupName) throws AzDException {
        return BUILDER.variableGroups().list(r -> r.queryParameters.groupName = groupName);
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
        return BUILDER.variableGroups().list(r -> {
            r.queryParameters.groupName = groupName;
            r.queryParameters.top = top;
            r.queryParameters.queryOrder = queryOrder;
            r.queryParameters.continuationToken = continuationToken;
            r.queryParameters.actionFilter = actionFilter;
        });
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
        var project = CLIENT.core().projects().get();

        projectReference.setName(project.getName());
        projectReference.setId(project.getId());

        definition.setName(name);
        definition.setDescription(description);
        definition.setVariables(variables.get());
        definition.setProjectReference(projectReference);
        definition.setType(VariableGroupType.Vsts);

        System.out.println(definition.getVariables());

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

        var variableGroupLibrary = new VariableGroupLibrary();
        variableGroupLibrary.name = variableGroupDefinition.getName();
        variableGroupLibrary.description = variableGroupDefinition.getDescription();
        variableGroupLibrary.type = variableGroupDefinition.getType().name();

        var ref = new VariableGroupProjectReference();
        ref.setName(variableGroupDefinition.getName());
        ref.setDescription(variableGroupDefinition.getDescription());
        ref.setProjectReference(variableGroupDefinition.getProjectReference());

        variableGroupLibrary.variableGroupProjectReferences = List.of(ref);
        variableGroupLibrary.providerData = variableGroupDefinition.getProviderData();
        variableGroupLibrary.variables = variableGroupDefinition.getVariables();

        return BUILDER.variableGroups().update(groupId, variableGroupLibrary);
    }
}
