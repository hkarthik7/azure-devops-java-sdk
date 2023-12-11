package org.azd.distributedtask.variablegroups;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.distributedtask.types.VariableGroup;
import org.azd.distributedtask.types.VariableGroupLibrary;
import org.azd.distributedtask.types.VariableGroupProjectReference;
import org.azd.distributedtask.types.VariableGroups;
import org.azd.enums.VariableGroupActionFilter;
import org.azd.enums.VariableGroupQueryOrder;
import org.azd.exceptions.AzDException;
import org.azd.helpers.AzDHelpers;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class VariableGroupsRequestBuilder extends BaseRequestBuilder {
    public VariableGroupsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "distributedtask/variablegroups", ApiVersion.VARIABLE_GROUPS);
    }

    /***
     * Add a variable group.
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

        var reqInfo = toPostRequestInformation(requestBody);
        reqInfo.project = null;

        return requestAdapter.sendAsync(reqInfo, VariableGroup.class);
    }

    /***
     * Delete a variable group
     * @param variableGroupId Id of the variable group.
     * @param projectIds String array of project ids.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int variableGroupId, String[] projectIds) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;
        reqInfo.setQueryParameter("projectIds", AzDHelpers.toString(projectIds));

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Get a variable group.
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroup> getAsync(int variableGroupId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;

        return requestAdapter.sendAsync(reqInfo, VariableGroup.class);
    }

    /***
     * Get variable groups.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroups> listAsync() throws AzDException {
        var reqInfo = toGetRequestInformation();
        return requestAdapter.sendAsync(reqInfo, VariableGroups.class);
    }

    /***
     * Get variable groups.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroups> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, VariableGroups.class);
    }

    /***
     * Get variable groups by Ids.
     * @param variableGroupId Id of the variable group.
     * @param groupIds String array of Ids of variable group ids.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<VariableGroup> getAsync(int variableGroupId, String[] groupIds) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;
        reqInfo.setQueryParameter("groupIds", AzDHelpers.toString(groupIds));

        return requestAdapter.sendAsync(reqInfo, VariableGroup.class);
    }

    /***
     * Add a variable group. This corresponds to VariableGroups - Share Variable Group.
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/variablegroups/share-variable-group?view=azure-devops-rest-7.1">Share Variable Group</a>
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> shareAsync(int variableGroupId, List<VariableGroupProjectReference> variableGroupProjectReferences)
            throws AzDException {
        var reqInfo = toPatchRequestInformation(variableGroupProjectReferences);
        reqInfo.project = null;
        reqInfo.setQueryParameter("variableGroupId", variableGroupId);

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Update a variable group.
     * @param variableGroupId Id of the variable group.
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

        var reqInfo = toPutRequestInformation(requestBody);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;

        return requestAdapter.sendAsync(reqInfo, VariableGroup.class);
    }

    /***
     * Add a variable group.
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

        var reqInfo = toPostRequestInformation(requestBody);
        reqInfo.project = null;

        return requestAdapter.send(reqInfo, VariableGroup.class);
    }

    /***
     * Delete a variable group
     * @param variableGroupId Id of the variable group.
     * @param projectIds String array of project ids.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int variableGroupId, String[] projectIds) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;
        reqInfo.setQueryParameter("projectIds", AzDHelpers.toString(projectIds));

        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Get a variable group.
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroup get(int variableGroupId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;

        return requestAdapter.send(reqInfo, VariableGroup.class);
    }

    /***
     * Get variable groups.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroups list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        return requestAdapter.send(reqInfo, VariableGroups.class);
    }

    /***
     * Get variable groups.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Variable groups object {@link VariableGroups}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroups list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.send(reqInfo, VariableGroups.class);
    }

    /***
     * Get variable groups by Ids.
     * @param variableGroupId Id of the variable group.
     * @param groupIds String array of Ids of variable group ids.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public VariableGroup get(int variableGroupId, String[] groupIds) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;
        reqInfo.setQueryParameter("groupIds", AzDHelpers.toString(groupIds));

        return requestAdapter.send(reqInfo, VariableGroup.class);
    }

    /***
     * Add a variable group. This corresponds to VariableGroups - Share Variable Group.
     * @see <a href="https://learn.microsoft.com/en-us/rest/api/azure/devops/distributedtask/variablegroups/share-variable-group?view=azure-devops-rest-7.1">Share Variable Group</a>
     * @param variableGroupId Id of the variable group.
     * @return Variable group {@link VariableGroup}
     * @throws AzDException Default Api Exception handler.
     */
    public Void share(int variableGroupId, List<VariableGroupProjectReference> variableGroupProjectReferences)
            throws AzDException {
        var reqInfo = toPatchRequestInformation(variableGroupProjectReferences);
        reqInfo.project = null;
        reqInfo.setQueryParameter("variableGroupId", variableGroupId);

        return requestAdapter.sendPrimitive(reqInfo);
    }

    /***
     * Update a variable group.
     * @param variableGroupId Id of the variable group.
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

        var reqInfo = toPutRequestInformation(requestBody);
        reqInfo.project = null;
        reqInfo.serviceEndpoint = service + "/" + variableGroupId;

        return requestAdapter.send(reqInfo, VariableGroup.class);
    }


    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Number of variable groups to get.
         */
        @QueryParameter(name = "$top")
        public Number top;
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
