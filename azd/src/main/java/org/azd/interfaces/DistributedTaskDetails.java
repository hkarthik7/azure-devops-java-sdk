package org.azd.interfaces;

import org.azd.distributedtask.types.*;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.release.types.ProjectReference;

import java.util.Map;

public interface DistributedTaskDetails {
    void deleteAgent(int poolId, int agentId) throws ConnectionException, AzDException;
    TaskAgent getAgent(int poolId, int agentId) throws ConnectionException, AzDException;
    TaskAgent getAgent(int poolId, int agentId, boolean includeAssignedRequest, boolean includeCapabilities,
                       boolean includeLastCompletedRequest, String[] propertyFilters) throws ConnectionException, AzDException;
    TaskAgents getAgents(int poolId) throws ConnectionException, AzDException;
    TaskAgents getAgents(int poolId, String agentName, String[] demands, boolean includeAssignedRequest, boolean includeCapabilities,
                       boolean includeLastCompletedRequest, String[] propertyFilters) throws ConnectionException, AzDException;
    TaskAgent updateAgent(int poolId, int agentId, Map requestBody) throws ConnectionException, AzDException;
    DeploymentGroup addDeploymentGroup(String name, String description) throws ConnectionException, AzDException;
    DeploymentGroup addDeploymentGroup(String name, String description, int poolId) throws ConnectionException, AzDException;
    void deleteDeploymentGroup(int deploymentGroupId) throws ConnectionException, AzDException;
    DeploymentGroup getDeploymentGroup(int deploymentGroupId) throws ConnectionException, AzDException;
    DeploymentGroup getDeploymentGroup(int deploymentGroupId, DeploymentGroupExpands expand, DeploymentGroupActionFilter actionFilter)
            throws ConnectionException, AzDException;
    DeploymentGroups getDeploymentGroups() throws ConnectionException, AzDException;
    DeploymentGroups getDeploymentGroups(int top) throws ConnectionException, AzDException;
    DeploymentGroups getDeploymentGroups(int[] ids) throws ConnectionException, AzDException;
    DeploymentGroups getDeploymentGroups(String name) throws ConnectionException, AzDException;
    DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand) throws ConnectionException, AzDException;
    DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand, int top, DeploymentGroupActionFilter actionFilter,
                                         String continuationToken, int[] ids, String name)
            throws ConnectionException, AzDException;
    DeploymentGroup updateDeploymentGroup(int deploymentGroupId, String name, String description) throws ConnectionException, AzDException;
    EnvironmentInstance addEnvironment(String name, String description) throws ConnectionException, AzDException;
    void deleteEnvironment(int environmentId) throws ConnectionException, AzDException;
    EnvironmentInstance getEnvironment(int environmentId) throws ConnectionException, AzDException;
    EnvironmentInstance getEnvironment(int environmentId, EnvironmentExpands expands) throws ConnectionException, AzDException;
    EnvironmentInstances getEnvironments() throws ConnectionException, AzDException;
    EnvironmentInstances getEnvironments(int top) throws ConnectionException, AzDException;
    EnvironmentInstances getEnvironments(String name) throws ConnectionException, AzDException;
    EnvironmentInstances getEnvironments(int top, String continuationToken, String name) throws ConnectionException, AzDException;
    EnvironmentInstance updateEnvironment(int environmentId, String name, String description) throws ConnectionException, AzDException;
    VariableGroup addVariableGroup(VariableGroupDefinition variableGroupDefinition) throws ConnectionException, AzDException;
    VariableGroup addVariableGroup(String name, String description, Map variables) throws ConnectionException, AzDException;
    void deleteVariableGroup(int variableGroupId, String[] projectIds) throws ConnectionException, AzDException;
    VariableGroup getVariableGroup(int variableGroupId) throws ConnectionException, AzDException;
    VariableGroups getVariableGroups() throws ConnectionException, AzDException;
    VariableGroups getVariableGroups(int top) throws ConnectionException, AzDException;
    VariableGroups getVariableGroups(String groupName) throws ConnectionException, AzDException;
    VariableGroups getVariableGroups(int top, VariableGroupActionFilter actionFilter, int continuationToken,
                                     String groupName, VariableGroupQueryOrder queryOrder) throws ConnectionException, AzDException;
    VariableGroup updateVariableGroup(int groupId, String name, String description, Map variables) throws ConnectionException, AzDException;
}
