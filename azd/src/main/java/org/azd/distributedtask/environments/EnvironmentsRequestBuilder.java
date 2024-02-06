package org.azd.distributedtask.environments;

import org.azd.abstractions.BaseRequestBuilder;
import org.azd.abstractions.QueryParameter;
import org.azd.authentication.AccessTokenCredential;
import org.azd.distributedtask.types.EnvironmentInstance;
import org.azd.distributedtask.types.EnvironmentInstances;
import org.azd.enums.EnvironmentExpands;
import org.azd.exceptions.AzDException;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Grant ability to manage distributed task environments Api.
 */
public class EnvironmentsRequestBuilder extends BaseRequestBuilder {
    /**
     * Instantiates a new RequestBuilder instance and sets the default values.
     *
     * @param organizationUrl       Represents organization location request url.
     * @param accessTokenCredential Access token credential object.
     */
    public EnvironmentsRequestBuilder(String organizationUrl, AccessTokenCredential accessTokenCredential) {
        super(organizationUrl, accessTokenCredential, "distributedtask", "8572b1fc-2482-47fa-8f74-7e3ed53ee54b");
    }

    /**
     * Create an environment.
     *
     * @param name        Name of the environment.
     * @param description Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> addAsync(String name, String description) throws AzDException {
        return builder()
                .POST(Map.of("name", name, "description", description))
                .build()
                .executeAsync(EnvironmentInstance.class);
    }

    /**
     * Delete the specified environment.
     *
     * @param environmentId ID of the environment.
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<Void> deleteAsync(int environmentId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("environmentId", environmentId)
                .build()
                .executePrimitiveAsync();
    }

    /**
     * Get an environment by its ID.
     *
     * @param environmentId ID of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> getAsync(int environmentId) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .build()
                .executeAsync(EnvironmentInstance.class);
    }

    /**
     * Get an environment by its ID.
     *
     * @param environmentId ID of the environment.
     * @param expands       Include these additional details in the returned objects. {@link EnvironmentExpands}
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> getAsync(int environmentId, EnvironmentExpands expands) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .query("expands", expands)
                .build()
                .executeAsync(EnvironmentInstance.class);
    }

    /**
     * Get all environments.
     *
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstances> listAsync() throws AzDException {
        return builder()
                .build()
                .executeAsync(EnvironmentInstances.class);
    }

    /**
     * Get all environments.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstances> listAsync(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .executeAsync(EnvironmentInstances.class);
    }

    /**
     * Update the specified environment.
     *
     * @param environmentId ID of the environment.
     * @param name          Name of the environment.
     * @param description   Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public CompletableFuture<EnvironmentInstance> updateAsync(int environmentId, String name, String description) throws AzDException {
        return builder()
                .PATCH(Map.of("name", name, "description", description))
                .serviceEndpoint("environmentId", environmentId)
                .build()
                .executeAsync(EnvironmentInstance.class);
    }

    /**
     * Create an environment.
     *
     * @param name        Name of the environment.
     * @param description Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public EnvironmentInstance add(String name, String description) throws AzDException {
        return builder()
                .POST(Map.of("name", name, "description", description))
                .build()
                .execute(EnvironmentInstance.class);
    }

    /**
     * Delete the specified environment.
     *
     * @param environmentId ID of the environment.
     * @throws AzDException Default Api Exception handler.
     */
    public Void delete(int environmentId) throws AzDException {
        return builder()
                .DELETE()
                .serviceEndpoint("environmentId", environmentId)
                .build()
                .executePrimitive();
    }

    /**
     * Get an environment by its ID.
     *
     * @param environmentId ID of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public EnvironmentInstance get(int environmentId) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .build()
                .execute(EnvironmentInstance.class);
    }

    /**
     * Get an environment by its ID.
     *
     * @param environmentId ID of the environment.
     * @param expands       Include these additional details in the returned objects. {@link EnvironmentExpands}
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public EnvironmentInstance get(int environmentId, EnvironmentExpands expands) throws AzDException {
        return builder()
                .serviceEndpoint("environmentId", environmentId)
                .query("expands", expands)
                .build()
                .execute(EnvironmentInstance.class);
    }

    /**
     * Get all environments.
     *
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    public EnvironmentInstances list() throws AzDException {
        return builder()
                .build()
                .execute(EnvironmentInstances.class);
    }

    /**
     * Get all environments.
     *
     * @param requestConfiguration Consumer of request configuration. This represents the query parameter for the request.
     * @return Environment instances array {@link EnvironmentInstances}
     * @throws AzDException Default Api Exception handler.
     */
    public EnvironmentInstances list(Consumer<RequestConfiguration> requestConfiguration) throws AzDException {
        return builder()
                .query(RequestConfiguration::new, requestConfiguration, q -> q.queryParameters)
                .build()
                .execute(EnvironmentInstances.class);
    }

    /**
     * Update the specified environment.
     *
     * @param environmentId ID of the environment.
     * @param name          Name of the environment.
     * @param description   Description of the environment.
     * @return Environment instance {@link EnvironmentInstance}
     * @throws AzDException Default Api Exception handler.
     */
    public EnvironmentInstance update(int environmentId, String name, String description) throws AzDException {
        return builder()
                .PATCH(Map.of("name", name, "description", description))
                .serviceEndpoint("environmentId", environmentId)
                .build()
                .execute(EnvironmentInstance.class);
    }

    /**
     * Represents the query parameters.
     */
    public static class GetQueryParameters {
        /**
         * Maximum number of environments to return.
         */
        @QueryParameter(name = "$top")
        public Integer top;
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
