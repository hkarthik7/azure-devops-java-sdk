package org.azd.distributedtask;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.azd.common.ApiVersion;
import org.azd.connection.Connection;
import org.azd.core.CoreApi;
import org.azd.distributedtask.types.*;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;
import org.azd.interfaces.DistributedTaskDetails;
import org.azd.release.types.ProjectReference;

import java.util.*;

import static org.azd.utils.Client.send;

/***
 * DistributedTaskApi class to manage Agents, Deployment groups, Environments and Variable groups API
 */
public class DistributedTaskApi implements DistributedTaskDetails {
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
    public DistributedTaskApi(Connection connection) { this.CONNECTION = connection; }

    @Override
    public void deleteAgent(int poolId, int agentId) throws ConnectionException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, null,
                    AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    @Override
    public TaskAgent getAgent(int poolId, int agentId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK, null, null);

        return MAPPER.mapJsonResponse(r, TaskAgent.class);
    }

    @Override
    public TaskAgent getAgent(int poolId, int agentId, boolean includeAssignedRequest, boolean includeCapabilities,
                              boolean includeLastCompletedRequest, String[] propertyFilters) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("includeAssignedRequest", includeAssignedRequest);
            put("includeCapabilities", includeCapabilities);
            put("includeLastCompletedRequest", includeLastCompletedRequest);
            put("propertyFilters", String.join(",", propertyFilters));
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, TaskAgent.class);
    }

    @Override
    public TaskAgents getAgents(int poolId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents", null, ApiVersion.DISTRIBUTED_TASK, null, null);

        return MAPPER.mapJsonResponse(r, TaskAgents.class);
    }

    @Override
    public TaskAgents getAgents(int poolId, String agentName, String[] demands, boolean includeAssignedRequest,
                                boolean includeCapabilities, boolean includeLastCompletedRequest, String[] propertyFilters)
            throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("agentName", agentName);
            put("demands", String.join(",", demands));
            put("includeAssignedRequest", includeAssignedRequest);
            put("includeCapabilities", includeCapabilities);
            put("includeLastCompletedRequest", includeLastCompletedRequest);
            put("propertyFilters", String.join(",", propertyFilters));
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents", null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, TaskAgents.class);
    }

    @Override
    public TaskAgent updateAgent(int poolId, int agentId, Map requestBody) throws ConnectionException, AzDException {
        String r = send(RequestMethod.PATCH, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/pools", poolId + "/agents/" + agentId, null, ApiVersion.DISTRIBUTED_TASK, null, requestBody);

        return MAPPER.mapJsonResponse(r, TaskAgent.class);
    }

    @Override
    public DeploymentGroup addDeploymentGroup(String name, String description) throws ConnectionException, AzDException {
        var requestBody = new HashMap<String, Object>(){{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, DISTRIBUTEDTASK, null,
                AREA, null, "deploymentgroups", ApiVersion.DISTRIBUTED_TASK, null, requestBody);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    @Override
    public DeploymentGroup addDeploymentGroup(String name, String description, int poolId) throws ConnectionException, AzDException {
        var requestBody = new HashMap<String, Object>(){{
            put("name", name);
            put("description", description);
            put("poolId", poolId);
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, null,
                AREA, null, "deploymentgroups", ApiVersion.DISTRIBUTED_TASK, null, requestBody);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    @Override
    public void deleteDeploymentGroup(int deploymentGroupId) throws ConnectionException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, null,
                    AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    @Override
    public DeploymentGroup getDeploymentGroup(int deploymentGroupId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    @Override
    public DeploymentGroup getDeploymentGroup(int deploymentGroupId, DeploymentGroupExpands expand, DeploymentGroupActionFilter actionFilter)
            throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
            put("actionFilter", actionFilter.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    @Override
    public DeploymentGroups getDeploymentGroups() throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, null, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    @Override
    public DeploymentGroups getDeploymentGroups(int top) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    @Override
    public DeploymentGroups getDeploymentGroups(int[] ids) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("ids", intArrayToString(ids));
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    @Override
    public DeploymentGroups getDeploymentGroups(String name) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    @Override
    public DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    @Override
    public DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand, int top, DeploymentGroupActionFilter actionFilter,
                                                String continuationToken, int[] ids, String name) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$expand", expand.toString().toLowerCase());
            put("$top", top);
            put("actionFilter", actionFilter.toString().toLowerCase());
            put("continuationToken", continuationToken);
            put("ids", intArrayToString(ids));
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, DeploymentGroups.class);
    }

    @Override
    public DeploymentGroup updateDeploymentGroup(int deploymentGroupId, String name, String description) throws ConnectionException, AzDException {
        var requestBody = new HashMap<String, Object>(){{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/deploymentgroups", Integer.toString(deploymentGroupId), null, ApiVersion.DISTRIBUTED_TASK, null, requestBody);

        return MAPPER.mapJsonResponse(r, DeploymentGroup.class);
    }

    @Override
    public EnvironmentInstance addEnvironment(String name, String description) throws ConnectionException, AzDException {
        var requestBody = new HashMap<String, Object>(){{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, null, requestBody);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    @Override
    public void deleteEnvironment(int environmentId) throws ConnectionException, AzDException {
        try {
            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                    AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK, null, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    @Override
    public EnvironmentInstance getEnvironment(int environmentId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    @Override
    public EnvironmentInstance getEnvironment(int environmentId, EnvironmentExpands expands) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("expands", expands.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    @Override
    public EnvironmentInstances getEnvironments() throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, null, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    @Override
    public EnvironmentInstances getEnvironments(int top) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    @Override
    public EnvironmentInstances getEnvironments(String name) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    @Override
    public EnvironmentInstances getEnvironments(int top, String continuationToken, String name) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$top", top);
            put("continuationToken", continuationToken);
            put("name", name);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", null, null, ApiVersion.DISTRIBUTED_TASK, q, null);

        return MAPPER.mapJsonResponse(r, EnvironmentInstances.class);
    }

    @Override
    public EnvironmentInstance updateEnvironment(int environmentId, String name, String description) throws ConnectionException, AzDException {
        var requestBody = new HashMap<String, Object>(){{
            put("name", name);
            put("description", description);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/environments", Integer.toString(environmentId), null, ApiVersion.DISTRIBUTED_TASK, null, requestBody);

        return MAPPER.mapJsonResponse(r, EnvironmentInstance.class);
    }

    @Override
    public VariableGroup addVariableGroup(VariableGroupDefinition variableGroupDefinition)
            throws ConnectionException, AzDException {
        var ref = new VariableGroupProjectReference();
        ref.setName(variableGroupDefinition.getName());
        ref.setDescription(variableGroupDefinition.getDescription());
        ref.setProjectReference(variableGroupDefinition.getProjectReference());

        List<Object> o = new ArrayList<>();
        o.add(ref);

        var requestBody = new HashMap<String, Object>(){{
            put("variableGroupProjectReferences", o);
            put("name", variableGroupDefinition.getName());
            put("description", variableGroupDefinition.getDescription());
            put("type", variableGroupDefinition.getType());
            put("variables", variableGroupDefinition.getVariables());
            put("providerData", variableGroupDefinition.getProviderData());
        }};

        String r = send(RequestMethod.POST, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, null, requestBody);

        return MAPPER.mapJsonResponse(r, VariableGroup.class);
    }

    @Override
    public VariableGroup addVariableGroup(String name, String description, Map variables) throws ConnectionException, AzDException {
        var definition = new VariableGroupDefinition();
        var projectReference = new ProjectReference();
        var core = new CoreApi(CONNECTION);
        var project = core.getProject(CONNECTION.getProject());

        projectReference.setName(project.getName());
        projectReference.setId(project.getId());

        definition.setName(name);
        definition.setDescription(description);
        definition.setVariables(variables);
        definition.setProjectReference(projectReference);
        definition.setType(VariableGroupType.Vsts);

        return addVariableGroup(definition);
    }

    @Override
    public void deleteVariableGroup(int variableGroupId, String[] projectIds) throws ConnectionException, AzDException {
        try {
            var q = new HashMap<String, Object>(){{
                put("projectIds", String.join(",", projectIds));
            }};

            String r = send(RequestMethod.DELETE, CONNECTION, DISTRIBUTEDTASK, null,
                    AREA + "/variablegroups", Integer.toString(variableGroupId), null, ApiVersion.VARIABLE_GROUPS, q, null);

            if (!r.isEmpty()) MAPPER.mapJsonResponse(r, Map.class);
        } catch (ConnectionException | AzDException e) {
            throw e;
        }
    }

    @Override
    public VariableGroup getVariableGroup(int variableGroupId) throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", Integer.toString(variableGroupId), null, ApiVersion.VARIABLE_GROUPS, null, null);

        return MAPPER.mapJsonResponse(r, VariableGroup.class);
    }

    @Override
    public VariableGroups getVariableGroups() throws ConnectionException, AzDException {
        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, null, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    @Override
    public VariableGroups getVariableGroups(int top) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
           put("$top", top);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, q, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    @Override
    public VariableGroups getVariableGroups(String groupName) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("groupName", groupName);
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, q, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    @Override
    public VariableGroups getVariableGroups(int top, VariableGroupActionFilter actionFilter, int continuationToken, String groupName,
                                            VariableGroupQueryOrder queryOrder) throws ConnectionException, AzDException {
        var q = new HashMap<String, Object>(){{
            put("$top", top);
            put("actionFilter", actionFilter.toString().toLowerCase());
            put("continuationToken", continuationToken);
            put("groupName", groupName);
            put("queryOrder", queryOrder.toString().toLowerCase());
        }};

        String r = send(RequestMethod.GET, CONNECTION, DISTRIBUTEDTASK, CONNECTION.getProject(),
                AREA + "/variablegroups", null, null, ApiVersion.VARIABLE_GROUPS, q, null);

        return MAPPER.mapJsonResponse(r, VariableGroups.class);
    }

    @Override
    public VariableGroup updateVariableGroup(int groupId, String name, String description, Map variables) throws ConnectionException, AzDException {
        var requestBody = new HashMap<String, Object>(){{
            put("name", name);
            put("description", description);
            put("variables", variables);
        }};

        String r = send(RequestMethod.PATCH, CONNECTION, DISTRIBUTEDTASK, null,
                AREA + "/variablegroups", Integer.toString(groupId), null, ApiVersion.VARIABLE_GROUPS, null, requestBody);

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
