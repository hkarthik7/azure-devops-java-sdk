package org.azd.distributedtask.deploymentgroups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.distributedtask.types.DeploymentGroup;
import org.azd.distributedtask.types.DeploymentGroups;
import org.azd.enums.DeploymentGroupActionFilter;
import org.azd.enums.DeploymentGroupExpands;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Builder class that constructs requests for Distributed tasks deployment groups Api.
 */
public class DeploymentGroupsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates the request builder with required values.
     * @param accessTokenCredential Authentication type {@link AccessTokenCredential}.
     * @param requestAdapter The request adapter to execute the requests.
     */
    public DeploymentGroupsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "distributedtask/deploymentgroups", ApiVersion.DISTRIBUTED_TASK);
    }

    /***
     * Create a deployment group.
     * @param deploymentGroup DeploymentGroupRequest object {@link DeploymentGroupRequest}.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> add(DeploymentGroupRequest deploymentGroup) throws AzDException {
        var reqInfo = toPostRequestInformation(deploymentGroup);
        return requestAdapter.sendAsync(reqInfo, DeploymentGroup.class);
    }

    /***
     * Delete a deployment group.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> delete(int deploymentGroupId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + deploymentGroupId;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Get a deployment group by its ID.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> get(int deploymentGroupId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + deploymentGroupId;

        return requestAdapter.sendAsync(reqInfo, DeploymentGroup.class);
    }

    /***
     * Get a deployment group by its ID.
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> get(int deploymentGroupId, Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + deploymentGroupId;

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, DeploymentGroup.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroups> list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        return requestAdapter.sendAsync(reqInfo, DeploymentGroups.class);
    }

    /***
     * Get a list of deployment groups by name or IDs.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroups> list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new ListRequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, DeploymentGroups.class);
    }

    /***
     * Update a deployment group.
     * @param deploymentGroupId ID of the deployment group.
     * @param name Name of the deployment group.
     * @param description Description of the deployment group.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> update(int deploymentGroupId, String name, String description) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
        }};

        var reqInfo = toPatchRequestInformation(requestBody);
        reqInfo.serviceEndpoint = service + "/" + deploymentGroupId;

        return requestAdapter.sendAsync(reqInfo, DeploymentGroup.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Include these additional details in the returned object.
         */
        @QueryParameter(name = "$expand")
        public DeploymentGroupExpands expand;
        /**
         * Get the deployment group only if this action can be performed on it.
         */
        @QueryParameter(name = "actionFilter")
        public DeploymentGroupActionFilter actionFilter;
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
         * Include these additional details in the returned object.
         */
        @QueryParameter(name = "$expand")
        public DeploymentGroupExpands expand;
        /**
         * Get the deployment group only if this action can be performed on it.
         */
        @QueryParameter(name = "actionFilter")
        public DeploymentGroupActionFilter actionFilter;
        /**
         * Maximum number of deployment groups to return. Default is 1000.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * Get deployment groups with names greater than this continuationToken lexicographically.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Comma separated list of IDs of the deployment groups.
         */
        @QueryParameter(name = "ids")
        public String ids;
        /**
         * Name of the deployment group.
         */
        @QueryParameter(name = "name")
        public String name;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class ListRequestConfiguration {
        public ListQueryParameters queryParameters = new ListQueryParameters();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DeploymentGroupRequest {
        /**
         * Name of the deployment group.
         */
        @JsonProperty("name")
        public String name;
        /**
         * Description of the deployment group.
         */
        @JsonProperty("description")
        public String description;
        /**
         * Identifier of the deployment pool in which deployment agents are registered.
         */
        @JsonProperty("poolId")
        public Number poolId;
    }
}
