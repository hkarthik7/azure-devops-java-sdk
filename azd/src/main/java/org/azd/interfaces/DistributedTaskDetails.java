package org.azd.interfaces;

import org.azd.distributedtask.types.*;
import org.azd.enums.*;
import org.azd.exceptions.AzDException;

public interface DistributedTaskDetails {
    Void deleteAgent(int poolId, int agentId) throws AzDException;

    TaskAgent getAgent(int poolId, int agentId) throws AzDException;

    TaskAgent getAgent(int poolId, int agentId, boolean includeAssignedRequest, boolean includeCapabilities,
                       boolean includeLastCompletedRequest, String[] propertyFilters) throws AzDException;

    TaskAgents getAgents(int poolId) throws AzDException;

    TaskAgents getAgents(int poolId, String agentName, String[] demands, boolean includeAssignedRequest, boolean includeCapabilities,
                         boolean includeLastCompletedRequest, String[] propertyFilters) throws AzDException;

    TaskAgent updateAgent(int poolId, int agentId, TaskAgent requestBody) throws AzDException;

    DeploymentGroup addDeploymentGroup(String name, String description) throws AzDException;

    DeploymentGroup addDeploymentGroup(String name, String description, int poolId) throws AzDException;

    Void deleteDeploymentGroup(int deploymentGroupId) throws AzDException;

    DeploymentGroup getDeploymentGroup(int deploymentGroupId) throws AzDException;

    DeploymentGroup getDeploymentGroup(int deploymentGroupId, DeploymentGroupExpands expand, DeploymentGroupActionFilter actionFilter)
            throws AzDException;

    DeploymentGroups getDeploymentGroups() throws AzDException;

    DeploymentGroups getDeploymentGroups(int top) throws AzDException;

    DeploymentGroups getDeploymentGroups(int[] ids) throws AzDException;

    DeploymentGroups getDeploymentGroups(String name) throws AzDException;

    DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand) throws AzDException;

    DeploymentGroups getDeploymentGroups(DeploymentGroupExpands expand, int top, DeploymentGroupActionFilter actionFilter,
                                         String continuationToken, int[] ids, String name)
            throws AzDException;

    DeploymentGroup updateDeploymentGroup(int deploymentGroupId, String name, String description) throws AzDException;

    EnvironmentInstance addEnvironment(String name, String description) throws AzDException;

    Void deleteEnvironment(int environmentId) throws AzDException;

    EnvironmentInstance getEnvironment(int environmentId) throws AzDException;

    EnvironmentInstance getEnvironment(int environmentId, EnvironmentExpands expands) throws AzDException;

    EnvironmentInstances getEnvironments() throws AzDException;

    EnvironmentInstances getEnvironments(int top) throws AzDException;

    EnvironmentInstances getEnvironments(String name) throws AzDException;

    EnvironmentInstances getEnvironments(int top, String continuationToken, String name) throws AzDException;

    EnvironmentInstance updateEnvironment(int environmentId, String name, String description) throws AzDException;

    VariableGroup addVariableGroup(VariableGroupDefinition variableGroupDefinition) throws AzDException;

    VariableGroup addVariableGroup(String name, String description, VariableGroupMap variables) throws AzDException;

    Void deleteVariableGroup(int variableGroupId, String[] projectIds) throws AzDException;

    VariableGroup getVariableGroup(int variableGroupId) throws AzDException;

    VariableGroups getVariableGroups() throws AzDException;

    VariableGroups getVariableGroups(int top) throws AzDException;

    VariableGroups getVariableGroups(String groupName) throws AzDException;

    VariableGroups getVariableGroups(int top, VariableGroupActionFilter actionFilter, int continuationToken,
                                     String groupName, VariableGroupQueryOrder queryOrder) throws AzDException;

    VariableGroup updateVariableGroup(int groupId, String name, String description, VariableGroupMap variables) throws AzDException;

    VariableGroup updateVariableGroup(int groupId, VariableGroupDefinition variableGroupDefinition) throws AzDException;
}
