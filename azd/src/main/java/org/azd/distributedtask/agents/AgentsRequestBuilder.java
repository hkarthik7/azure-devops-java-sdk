package org.azd.distributedtask.agents;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.distributedtask.types.TaskAgent;
import org.azd.distributedtask.types.TaskAgents;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Builder class that constructs requests for Distributed tasks agents Api.
 */
public class AgentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public AgentsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "distributedtask", "e298ef32-5878-4cab-993c-043836571f42");
    }

    /**
     * Delete an agent.
     *
     * @param poolId  The pool ID to remove the agent from
     * @param agentId The agent ID to remove
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int poolId, int agentId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get information about an agent.
     *
     * @param poolId  The agent pool containing the agent
     * @param agentId The agent ID to get information about
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgent> getAsync(int poolId, int agentId) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .build()
                .executeAsync(TaskAgent.class);
    }

    /**
     * Get information about an agent.
     *
     * @param poolId               The agent pool containing the agent.
     * @param agentId              The agent ID to get information about.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return A TaskAgent object {@link TaskAgent}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgent> getAsync(int poolId, int agentId,
                                                 Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(TaskAgent.class);
    }

    /**
     * Get Permissions on Pool.
     *
     * @param poolId             The agent pool containing the agent.
     * @param agentId            The agent ID to get information about.
     * @param isCheckPermissions Set to true to check permission.
     * @return Returns a boolean.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Boolean> getPermissionAsync(int poolId, int agentId, boolean isCheckPermissions) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .query("isCheckPermissions", isCheckPermissions)
                .build()
                .executeStringAsync()
                .thenApplyAsync(Boolean::valueOf);
    }

    /**
     * Get a list of agents.
     *
     * @param poolId The agent pool containing the agents
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgents> listAsync(int poolId) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .build()
                .executeAsync(TaskAgents.class);
    }

    /**
     * Get a list of agents.
     *
     * @param poolId               The agent pool containing the agents
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgents> listAsync(int poolId, Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(TaskAgents.class);
    }

    /**
     * Update agent details.
     *
     * @param poolId    The agent pool to use
     * @param agentId   The agent to update
     * @param taskAgent Task agent object.
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     * @see <a href="https://docs.microsoft.com/en-us/rest/api/azure/devops/distributedtask/agents/update?view=azure-devops-rest-7.1#request-body">Agents - Update</a>
     */
    public CompletableFuture<TaskAgent> updateAsync(int poolId, int agentId, TaskAgent taskAgent) throws AzDException {
        return builder()
                .PATCH(taskAgent)
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .build()
                .executeAsync(TaskAgent.class);
    }

    /**
     * Delete an agent.
     *
     * @param poolId  The pool ID to remove the agent from
     * @param agentId The agent ID to remove
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int poolId, int agentId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .build()
                .executePrimitive();
    }

    /**
     * Get information about an agent.
     *
     * @param poolId  The agent pool containing the agent
     * @param agentId The agent ID to get information about
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    public TaskAgent get(int poolId, int agentId) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .build()
                .execute(TaskAgent.class);
    }

    /**
     * Get information about an agent.
     *
     * @param poolId               The agent pool containing the agent.
     * @param agentId              The agent ID to get information about.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return A TaskAgent object {@link TaskAgent}.
     * @throws AzDException Default Api Exception handler.
     */
    public TaskAgent get(int poolId, int agentId,
                         Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(TaskAgent.class);
    }

    /**
     * Get Permissions on Pool.
     *
     * @param poolId             The agent pool containing the agent.
     * @param agentId            The agent ID to get information about.
     * @param isCheckPermissions Set to true to check permission.
     * @return Returns a boolean.
     * @throws AzDException Default Api Exception handler.
     */
    public Boolean getPermission(int poolId, int agentId, boolean isCheckPermissions) throws AzDException {
        return Boolean.valueOf(builder()
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .query("isCheckPermissions", isCheckPermissions)
                .build()
                .executeString());
    }

    /**
     * Get a list of agents.
     *
     * @param poolId The agent pool containing the agents
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    public TaskAgents list(int poolId) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .build()
                .execute(TaskAgents.class);
    }

    /**
     * Get a list of agents.
     *
     * @param poolId               The agent pool containing the agents
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    public TaskAgents list(int poolId, Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("poolId", poolId)
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(TaskAgents.class);
    }

    /**
     * Update agent details.
     *
     * @param poolId    The agent pool to use
     * @param agentId   The agent to update
     * @param taskAgent Task agent object.
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     * @see <a href="https://docs.microsoft.com/en-us/rest/api/azure/devops/distributedtask/agents/update?view=azure-devops-rest-7.1#request-body">Agents - Update</a>
     */
    public TaskAgent update(int poolId, int agentId, TaskAgent taskAgent) throws AzDException {
        return builder()
                .PATCH(taskAgent)
                .serviceEndpoint("poolId", poolId)
                .serviceEndpoint("agentId", agentId)
                .build()
                .execute(TaskAgent.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Whether to include the agent's capabilities in the response.
         */
        @QueryParameter(name = "includeCapabilities")
        public Boolean includeCapabilities;
        /**
         * Whether to include details about the agent's current work.
         */
        @QueryParameter(name = "includeAssignedRequest")
        public Boolean includeAssignedRequest;
        /**
         * Whether to include details about the agents' most recent completed work.
         */
        @QueryParameter(name = "includeLastCompletedRequest")
        public Boolean includeLastCompletedRequest;
        /**
         * Filter which custom properties will be returned.
         */
        @QueryParameter(name = "propertyFilters")
        public String propertyFilters;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

    /**
     * Represents the query parameters.
     */
    public static class ListQueryParameters {
        /**
         * Filter on agent name
         */
        @QueryParameter(name = "agentName")
        public String agentName;
        /**
         * Filter by demands the agents can satisfy. Comma separated values; E.g; "a,b,c".
         */
        @QueryParameter(name = "demands")
        public String demands;
        /**
         * Whether to include details about the agents' current work
         */
        @QueryParameter(name = "includeAssignedRequest")
        public Boolean includeAssignedRequest;
        /**
         * Whether to include the agents' capabilities in the response.
         */
        @QueryParameter(name = "includeCapabilities")
        public Boolean includeCapabilities;
        /**
         * Whether to include details about the agents' most recent completed work
         */
        @QueryParameter(name = "includeLastCompletedRequest")
        public Boolean includeLastCompletedRequest;
        /**
         * Filter which custom properties will be returned. Comma separated values; E.g; "a,b,c".
         */
        @QueryParameter(name = "propertyFilters")
        public String propertyFilters;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }
}
