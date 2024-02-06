package org.azd.distributedtask.variablegroups;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.distributedtask.types.VariableGroup;
import org.azd.distributedtask.types.VariableGroupLibrary;
import org.azd.distributedtask.types.VariableGroupProjectReference;
import org.azd.distributedtask.types.VariableGroups;
import org.azd.enums.VariableGroupActionFilter;
import org.azd.enums.VariableGroupQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.helpers.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Grant ability to manage distributed task environments Api.
 */
public class VariableGroupsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public VariableGroupsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "distributedtask", "ef5b7057-ffc3-4c77-bbad-c10b4a4abcc7");
    }

    /**
     * Add a variable group.
     *
     * @param variableGroupLibrary Request body of variable group {@link VariableGroupLibrary}
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroup> addAsync(VariableGroupLibrary variableGroupLibrary) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("variableGroupProjectReferences", variableGroupLibrary.variableGroupProjectReferences);
            put("name", variableGroupLibrary.name);
            put("description", variableGroupLibrary.description);
            put("type", variableGroupLibrary.type);
            put("variables", variableGroupLibrary.variables);
            put("providerData", variableGroupLibrary.providerData);
        }};

        return builder()
                .POST(requestBody)
                .build()
                .executeAsync(VariableGroup.class);
    }

    /**
     * Delete a variable group
     *
     * @param variableGroupId Id of the variable group.
     * @param projectIds      String array of project ids.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int variableGroupId, String[] projectIds) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", variableGroupId)
                .query("projectIds", Utils.toString(projectIds))
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get a variable group.
     *
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroup> getAsync(int variableGroupId) throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .serviceEndpoint("groupId", variableGroupId)
                .build()
                .executeAsync(VariableGroup.class);
    }

    /**
     * Get variable groups.
     *
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroups> listAsync() throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .build()
                .executeAsync(VariableGroups.class);
    }

    /**
     * Get variable groups.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroups> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(VariableGroups.class);
    }

    /**
     * Get variable groups by Ids.
     *
     * @param variableGroupId Id of the variable group.
     * @param groupIds        String array of Ids of variable group ids.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroup> getAsync(int variableGroupId, String[] groupIds) throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .serviceEndpoint("groupId", variableGroupId)
                .query("groupIds", Utils.toString(groupIds))
                .build()
                .executeAsync(VariableGroup.class);
    }

    /**
     * Add a variable group. This corresponds to VariableGroups - Share Variable Group.
     *
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/variablegroups/share-variable-group?view=azure-devops-rest-7.1">Share Variable Group</a>
     */
    public CompletableFuture<Void> shareAsync(int variableGroupId, List<VariableGroupProjectReference> variableGroupProjectReferences)
            throws AzDException {
        return builder()
                .PATCH(variableGroupProjectReferences)
                .query("variableGroupId", variableGroupId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Update a variable group.
     *
     * @param variableGroupId      Id of the variable group.
     * @param variableGroupLibrary Request body to update the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroup> updateAsync(int variableGroupId, VariableGroupLibrary variableGroupLibrary) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("variableGroupProjectReferences", variableGroupLibrary.variableGroupProjectReferences);
            put("name", variableGroupLibrary.name);
            put("description", variableGroupLibrary.description);
            put("type", variableGroupLibrary.type);
            put("variables", variableGroupLibrary.variables);
            put("providerData", variableGroupLibrary.providerData);
        }};

        return builder()
                .PUT(requestBody)
                .serviceEndpoint("groupId", variableGroupId)
                .build()
                .executeAsync(VariableGroup.class);
    }

    /**
     * Add a variable group.
     *
     * @param variableGroupLibrary Request body of variable group {@link VariableGroupLibrary}
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroup add(VariableGroupLibrary variableGroupLibrary) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("variableGroupProjectReferences", variableGroupLibrary.variableGroupProjectReferences);
            put("name", variableGroupLibrary.name);
            put("description", variableGroupLibrary.description);
            put("type", variableGroupLibrary.type);
            put("variables", variableGroupLibrary.variables);
            put("providerData", variableGroupLibrary.providerData);
        }};

        return builder()
                .POST(requestBody)
                .build()
                .execute(VariableGroup.class);
    }

    /**
     * Delete a variable group
     *
     * @param variableGroupId Id of the variable group.
     * @param projectIds      String array of project ids.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int variableGroupId, String[] projectIds) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("groupId", variableGroupId)
                .query("projectIds", Utils.toString(projectIds))
                .build()
                .executePrimitive();
    }

    /**
     * Get a variable group.
     *
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroup get(int variableGroupId) throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .serviceEndpoint("groupId", variableGroupId)
                .build()
                .execute(VariableGroup.class);
    }

    /**
     * Get variable groups.
     *
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroups list() throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .build()
                .execute(VariableGroups.class);
    }

    /**
     * Get variable groups.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroups list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(VariableGroups.class);
    }

    /**
     * Get variable groups by Ids.
     *
     * @param variableGroupId Id of the variable group.
     * @param groupIds        String array of Ids of variable group ids.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroup get(int variableGroupId, String[] groupIds) throws AzDException {
        return builder()
                .location("f5b09dd5-9d54-45a1-8b5a-1c8287d634cc")
                .serviceEndpoint("groupId", variableGroupId)
                .query("groupIds", Utils.toString(groupIds))
                .build()
                .execute(VariableGroup.class);
    }

    /**
     * Add a variable group. This corresponds to VariableGroups - Share Variable Group.
     *
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/variablegroups/share-variable-group?view=azure-devops-rest-7.1">Share Variable Group</a>
     */
    public Void share(int variableGroupId, List<VariableGroupProjectReference> variableGroupProjectReferences)
            throws AzDException {
        return builder()
                .PATCH(variableGroupProjectReferences)
                .query("variableGroupId", variableGroupId)
                .build()
                .executePrimitive();
    }

    /**
     * Update a variable group.
     *
     * @param variableGroupId      Id of the variable group.
     * @param variableGroupLibrary Request body to update the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroup update(int variableGroupId, VariableGroupLibrary variableGroupLibrary) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("variableGroupProjectReferences", variableGroupLibrary.variableGroupProjectReferences);
            put("name", variableGroupLibrary.name);
            put("description", variableGroupLibrary.description);
            put("type", variableGroupLibrary.type);
            put("variables", variableGroupLibrary.variables);
            put("providerData", variableGroupLibrary.providerData);
        }};

        return builder()
                .PUT(requestBody)
                .serviceEndpoint("groupId", variableGroupId)
                .build()
                .execute(VariableGroup.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Number of variable groups to get.
         */
        @QueryParameter(name = "$top")
        public Integer top;
        /**
         * Action filter for the variable group. It specifies the action which can be performed on the variable groups.
         */
        @QueryParameter(name = "actionFilter")
        public VariableGroupActionFilter actionFilter;
        /**
         * continuationToken value to get next set of results.
         */
        @QueryParameter(name = "continuationToken")
        public Number continuationToken;
        /**
         * Name of variable group.
         */
        @QueryParameter(name = "groupName")
        public String groupName;
        /**
         * Gets the results in the defined order. Default is 'IdDescending'.
         */
        @QueryParameter(name = "queryOrder")
        public VariableGroupQueryOrder queryOrder;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }
}
