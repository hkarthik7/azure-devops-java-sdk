package org.azd.distributedtask.agents;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.distributedtask.types.TaskAgent;
import org.azd.distributedtask.types.TaskAgents;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Builder class that constructs requests for Distributed tasks agents Api.
 */
public class AgentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public AgentsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "distributedtask/pools", ApiVersion.DISTRIBUTED_TASK);
    }

    /***
     * Delete an agent.
     * @param poolId The pool ID to remove the agent from
     * @param agentId The agent ID to remove
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> delete(int poolId, int agentId) throws AzDException {
       var reqInfo = toDeleteRequestInformation();
       reqInfo.serviceEndpoint = service + "/" + poolId + "/agents/" + agentId;

       return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Get information about an agent.
     * @param poolId The agent pool containing the agent
     * @param agentId The agent ID to get information about
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgent> get(int poolId, int agentId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + poolId + "/agents/" + agentId;

        return requestAdapter.sendAsync(reqInfo, TaskAgent.class);
    }

    /***
     * Get information about an agent.
     * @param poolId The agent pool containing the agent.
     * @param agentId The agent ID to get information about.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return A TaskAgent object {@link TaskAgent}.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgent> get(int poolId, int agentId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + poolId + "/agents/" + agentId;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, TaskAgent.class);
    }

    /***
     * Get a list of agents.
     * @param poolId The agent pool containing the agents
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgents> list(int poolId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + poolId + "/agents";

        return requestAdapter.sendAsync(reqInfo, TaskAgents.class);
    }

    /***
     * Get a list of agents.
     * @param poolId The agent pool containing the agents
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return TaskAgents object {@link TaskAgents}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgents> list(int poolId, Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + poolId + "/agents";

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, TaskAgents.class);
    }

    /***
     * Update agent details.
     * @param poolId The agent pool to use
     * @param agentId The agent to update
     * @param taskAgent Task agent object.
     * @see <a href="https://docs.microsoft.com/en-us/rest/api/azure/devops/distributedtask/agents/update?view=azure-devops-rest-7.1#request-body">Agents - Update</a>
     * @return A TaskAgent object {@link TaskAgent}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<TaskAgent> update(int poolId, int agentId, TaskAgent taskAgent) throws AzDException {
        var reqInfo = toPatchRequestInformation(taskAgent);
        reqInfo.serviceEndpoint = service + "/" + poolId + "/agents/" + agentId;

        return requestAdapter.sendAsync(reqInfo, TaskAgent.class);
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
