package org.azd.distributedtask.environments;

import org.azd.common.ApiVersion;
import org.azd.common.types.QueryParameter;
import org.azd.distributedtask.agents.AgentsRequestBuilder;
import org.azd.distributedtask.types.EnvironmentInstance;
import org.azd.distributedtask.types.EnvironmentInstances;
import org.azd.enums.EnvironmentExpands;
import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.utils.BaseRequestBuilder;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class EnvironmentsRequestBuilder extends BaseRequestBuilder {
    public EnvironmentsRequestBuilder(AccessTokenCredential accessTokenCredential, RequestAdapter requestAdapter) {
        super(accessTokenCredential, requestAdapter, "distributedtask/environments", ApiVersion.DISTRIBUTED_TASK);
    }

    /***
     * Create an environment.
     * @param name Name of the environment.
     * @param description Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> add(String name, String description) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
        }};

        var reqInfo = toPostRequestInformation(requestBody);
        return requestAdapter.sendAsync(reqInfo, EnvironmentInstance.class);
    }

    /***
     * Delete the specified environment.
     * @param environmentId ID of the environment.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> delete(int environmentId) throws AzDException {
        var reqInfo = toDeleteRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + environmentId;

        return requestAdapter.sendPrimitiveAsync(reqInfo);
    }

    /***
     * Get an environment by its ID.
     * @param environmentId ID of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> get(int environmentId) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + environmentId;

        return requestAdapter.sendAsync(reqInfo, EnvironmentInstance.class);
    }

    /***
     * Get an environment by its ID.
     * @param environmentId ID of the environment.
     * @param expands Include these additional details in the returned objects. {@link EnvironmentExpands}
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> get(int environmentId, EnvironmentExpands expands) throws AzDException {
        var reqInfo = toGetRequestInformation();
        reqInfo.serviceEndpoint = service + "/" + environmentId;
        reqInfo.setQueryParameter("expands", expands);

        return requestAdapter.sendAsync(reqInfo, EnvironmentInstance.class);
    }

    /***
     * Get all environments.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstances> list() throws AzDException {
        var reqInfo = toGetRequestInformation();
        return requestAdapter.sendAsync(reqInfo, EnvironmentInstances.class);
    }

    /***
     * Get all environments.
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstances> list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        var reqInfo = toGetRequestInformation();

        if (requestConfiguration != null) {
            final var config = new RequestConfiguration();
            requestConfiguration.accept(config);
            reqInfo.setQueryParameters(config.queryParameters);
        }

        return requestAdapter.sendAsync(reqInfo, EnvironmentInstances.class);
    }

    /***
     * Update the specified environment.
     * @param environmentId ID of the environment.
     * @param name Name of the environment.
     * @param description Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> update(int environmentId, String name, String description) throws AzDException {
        var requestBody = new HashMap<String, Object>() {{
            put("name", name);
            put("description", description);
        }};

        var reqInfo = toPatchRequestInformation(requestBody);
        reqInfo.serviceEndpoint = service + "/" + environmentId;

        return requestAdapter.sendAsync(reqInfo, EnvironmentInstance.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Maximum number of environments to return.
         */
        @QueryParameter(name = "$top")
        public Number top;
        /**
         * continuationToken value to get next set of results.
         */
        @QueryParameter(name = "continuationToken")
        public String continuationToken;
        /**
         * Name of the environment.
         */
        @QueryParameter(name = "name")
        public String name;
    }

    /**
     * Request configuration object for the query parameters.
     */
    public static class RequestConfiguration {
        public GetQueryParameters queryParameters = new GetQueryParameters();
    }

}
