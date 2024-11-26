package org.azd.http;

import org.azd.abstractions.RequestHeaders;
import org.azd.abstractions.RequestInformation;
import org.azd.abstractions.internals.ClientRequestBuilder;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.CustomHeader;
import org.azd.exceptions.AzDException;

import java.io.InputStream;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Request builder and executor that builds and executes the request for given parameters.
 */
public abstract class ClientRequest {

    /**
     * Default constructor.
     */
    protected ClientRequest() {
    }

    /**
     * Client request builder to build the request information such as url and headers.
     *
     * @param accessTokenCredential Access token credential object. {@link AccessTokenCredential}
     * @return Client request builder. {@link ClientRequest.Builder}
     */
    public static ClientRequest.Builder builder(AccessTokenCredential accessTokenCredential) {
        return new ClientRequestBuilder(accessTokenCredential);
    }

    /**
     * Client request builder to build the request information such as url and headers.
     *
     * @return Client request builder. {@link ClientRequest.Builder}
     */
    public static ClientRequest.Builder builder() {
        return new ClientRequestBuilder();
    }

    /**
     * Executes the request built by ClientRequest.Builder and deserializes the response for given entity/model.
     *
     * @param model Represents the entity or model for which the response should be deserialized to.
     * @return Deserialized POJO model.
     * @throws AzDException Default Api exception handler.
     */
    public abstract <T extends SerializableEntity> T execute(Class<T> model) throws AzDException;

    /**
     * Executes the request built by ClientRequest.Builder and deserializes the response for given entity/model.
     *
     * @param model Represents the entity or model for which the response should be deserialized to.
     * @return Deserialized POJO model of future object.
     * @throws AzDException Default Api exception handler.
     */
    public abstract <T extends SerializableEntity> CompletableFuture<T> executeAsync(Class<T> model) throws AzDException;

    /**
     * Executes the request built by ClientRequest.Builder and returns the response.
     *
     * @return Future string object.
     * @throws AzDException Default Api exception handler.
     */
    public abstract CompletableFuture<String> executeStringAsync() throws AzDException;

    /**
     * Executes the request built by ClientRequest.Builder and return the input stream of object. If this is meant to be
     * a zip file or any kind of stream, use {@link org.azd.helpers.StreamHelper} to download or convert the contents.
     *
     * @return Input stream object.
     * @throws AzDException Default Api exception handler.
     */
    public abstract CompletableFuture<InputStream> executeStreamAsync() throws AzDException;

    /**
     * Executes the request built by ClientRequest.Builder and doesn't return any response. This is mainly used for Api calls
     * that returns 201 or any operation that doesn't return response.
     *
     * @return Future void.
     * @throws AzDException Default Api exception handler.
     */
    public abstract CompletableFuture<Void> executePrimitiveAsync() throws AzDException;

    /**
     * Executes the request built by ClientRequest.Builder and returns the response.
     *
     * @return String object.
     * @throws AzDException Default Api exception handler.
     */
    public abstract String executeString() throws AzDException;

    /**
     * Executes the request built by ClientRequest.Builder and return the input stream of object. If this is meant to be
     * a zip file or any kind of stream, use {@link org.azd.helpers.StreamHelper} to download or convert the contents.
     *
     * @return Input stream object.
     * @throws AzDException Default Api exception handler.
     */
    public abstract InputStream executeStream() throws AzDException;

    /**
     * Executes the request built by ClientRequest.Builder and doesn't return any response. This is mainly used for Api calls
     * that returns 201 or any operation that doesn't return response.
     *
     * @return Void.
     * @throws AzDException Default Api exception handler.
     */
    public abstract Void executePrimitive() throws AzDException;

    /**
     * Returns the request information constructed by ClientRequest.Builder. {@link ClientRequest.Builder}
     *
     * @return Request information object. {@link RequestInformation}
     */
    public abstract RequestInformation request();

    /**
     * Returns the access token credential used to construct and execute the requests.
     *
     * @return Access token credential object. {@link AccessTokenCredential}
     */
    public abstract AccessTokenCredential accessTokenCredential();

    /**
     * Api requests builder.
     * Call ClientRequest.builder(AccessTokenCredential) for requests that require authentication with access token or
     * ClientRequest.builder() for requests that doesn't require authentication to create the instance of builder.
     * The builder is used to build the request information such as request method, query parameters, service, subdomain,
     * endpoints, headers etc. that are required to call Azure DevOps Api. The base url can be
     * set by {@link org.azd.enums.Instance} which is (dev.azure.com), however this behaviour can be overwritten by
     * calling baseInstance() on {@link org.azd.enums.Instance} or by directly setting the request url by calling URI()
     * on the {@link ClientRequest.Builder} instance.
     * If the organization name is part of AccessTokenCredential then it is appended with base instance. To override
     * this default behaviour call noOrganization() and to nullify the project call noProject().
     */
    public interface Builder {
        /**
         * Sets the base instance. Default is set to (dev.azure.com).
         *
         * @param baseInstance Base instance to set to construct the request url.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder baseInstance(String baseInstance);


        /**
         * Represents the service area.
         *
         * @param area Pass the value for area. E.g. core or build or git etc.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder area(String area);

        /**
         * Represents the service area location and all it's associated components.
         *
         * @param locationId Pass the location id for service specific area.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder location(String locationId);


        /**
         * Sets the Api version. Constant {@link org.azd.common.ApiVersion} can be used to set the api version. If the version that certain Api
         * demands is not found in {@link org.azd.common.ApiVersion} then the value can be set manually.
         *
         * @param apiVersion Api version to set.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder apiVersion(String apiVersion);

        /**
         * Represents the "GET" request method and constructs url for GET calls.
         *
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder GET();

        /**
         * Represents the POST request method.
         *
         * @param requestBody Request body to set.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder POST(Object requestBody);

        /**
         * Represents PUT request method.
         *
         * @param requestBody Request body to set.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder PUT(Object requestBody);

        /**
         * Represents PATCH request method.
         *
         * @param requestBody Request body to set.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder PATCH(Object requestBody);

        /**
         * Represents DELETE request method.
         *
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder DELETE();

        /**
         * Represents OPTIONS request method.
         *
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder OPTIONS();

        /**
         * Represents HEAD request method.
         *
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder HEAD();

        /**
         * Sets the complete request url with query parameters.
         *
         * @param url Request url to set.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder URI(String url);

        /**
         * Sets the complete request url with query parameters.
         *
         * @param uri Request url to set.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder URI(URI uri);


        /**
         * Constructs the service endpoint. This method can be chained to construct a long service endpoint.
         *
         * @param key   Represents the path parameter of the url.
         * @param value Value for the path parameter.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         * <p>Note that this method construct the endpoint in the order passed.</p>
         */
        Builder serviceEndpoint(String key, Object value);

        /**
         * Appends url with query parameter.
         *
         * @param name  Name of the query parameter.
         * @param value Value of the query parameter.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder query(String name, Object value);

        /**
         * Appends the url with query parameter.
         *
         * @param config        Supplier of request configuration instance.
         * @param requestConfig Consumer of request configuration that contains the query parameters.
         * @param func          Function of request configuration query parameters that returns any object.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        <T> Builder query(Supplier<T> config, Consumer<T> requestConfig, Function<T, Object> func);

        /**
         * Request headers to add.
         *
         * @param customHeader Custom header to add. {@link CustomHeader}
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder header(CustomHeader customHeader);

        /**
         * Request headers to add.
         *
         * @param requestHeaders Request headers value. {@link RequestHeaders}
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder headers(RequestHeaders requestHeaders);

        /**
         * Sets the request information to execute.
         *
         * @param requestInfo Request information object.
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        Builder request(RequestInformation requestInfo);

        /**
         * Returns the request information.
         *
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        RequestInformation request();

        /**
         * Return the authentication access token credential object.
         *
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        AccessTokenCredential accessTokenCredential();

        /**
         * Build and returns a new ClientRequest object.
         *
         * @return ClientRequest.Builder. {@link ClientRequest.Builder}
         */
        ClientRequest build();
    }
}
