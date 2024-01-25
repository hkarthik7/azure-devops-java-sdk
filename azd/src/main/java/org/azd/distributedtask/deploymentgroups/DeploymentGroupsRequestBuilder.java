package org.azd.distributedtask.deploymentgroups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.distributedtask.types.DeploymentGroup;
import org.azd.distributedtask.types.DeploymentGroups;
import org.azd.enums.DeploymentGroupActionFilter;
import org.azd.enums.DeploymentGroupExpands;
import org.azd.exceptions.AzDException;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Builder class that constructs requests for Distributed tasks deployment groups Api.
 */
public class DeploymentGroupsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public DeploymentGroupsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "distributedtask", "083c4d89-ab35-45af-aa11-7cf66895c53e");
    }

    /**
     * Create a deployment group.
     *
     * @param deploymentGroup DeploymentGroupRequest object {@link DeploymentGroupRequest}.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> addAsync(DeploymentGroupRequest deploymentGroup) throws AzDException {
        return builder()
                .POST(deploymentGroup)
                .build()
                .executeAsync(DeploymentGroup.class);
    }

    /**
     * Delete a deployment group.
     *
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int deploymentGroupId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a deployment group by its ID.
     *
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> getAsync(int deploymentGroupId) throws AzDException {
        return builder()
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .build()
                .executeAsync(DeploymentGroup.class);
    }

    /**
     * Get a deployment group by its ID.
     *
     * @param deploymentGroupId    ID of the deployment group to be deleted.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> getAsync(int deploymentGroupId,
                                                       Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(DeploymentGroup.class);
    }

    /**
     * Get a list of deployment groups by name or IDs.
     *
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroups> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(DeploymentGroups.class);
    }

    /**
     * Get a list of deployment groups by name or IDs.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroups> listAsync(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(DeploymentGroups.class);
    }

    /**
     * Update a deployment group.
     *
     * @param deploymentGroupId ID of the deployment group.
     * @param name              Name of the deployment group.
     * @param description       Description of the deployment group.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<DeploymentGroup> updateAsync(int deploymentGroupId, String name, String description) throws AzDException {
        return builder()
                .PATCH(Map.of("name", name, "description", description))
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .build()
                .executeAsync(DeploymentGroup.class);
    }

    /**
     * Create a deployment group.
     *
     * @param deploymentGroup DeploymentGroupRequest object {@link DeploymentGroupRequest}.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public DeploymentGroup add(DeploymentGroupRequest deploymentGroup) throws AzDException {
        return builder()
                .POST(deploymentGroup)
                .build()
                .execute(DeploymentGroup.class);
    }

    /**
     * Delete a deployment group.
     *
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int deploymentGroupId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .build()
                .executePrimitive();
    }

    /**
     * Get a deployment group by its ID.
     *
     * @param deploymentGroupId ID of the deployment group to be deleted.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public DeploymentGroup get(int deploymentGroupId) throws AzDException {
        return builder()
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .build()
                .execute(DeploymentGroup.class);
    }

    /**
     * Get a deployment group by its ID.
     *
     * @param deploymentGroupId    ID of the deployment group to be deleted.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public DeploymentGroup get(int deploymentGroupId,
                               Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(DeploymentGroup.class);
    }

    /**
     * Get a list of deployment groups by name or IDs.
     *
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public DeploymentGroups list() throws AzDException {
        return builder()
                .build()
                .execute(DeploymentGroups.class);
    }

    /**
     * Get a list of deployment groups by name or IDs.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Deployment groups object {@link DeploymentGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public DeploymentGroups list(Consumer<ListRequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(ListRequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(DeploymentGroups.class);
    }

    /**
     * Update a deployment group.
     *
     * @param deploymentGroupId ID of the deployment group.
     * @param name              Name of the deployment group.
     * @param description       Description of the deployment group.
     * @return Deployment group object {@link DeploymentGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public DeploymentGroup update(int deploymentGroupId, String name, String description) throws AzDException {
        return builder()
                .PATCH(Map.of("name", name, "description", description))
                .serviceEndpoint("deploymentGroupId", deploymentGroupId)
                .build()
                .execute(DeploymentGroup.class);
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
