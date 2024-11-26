package org.azd.abstractions.internals;

import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.RequestInformation;
import org.azd.abstractions.ResponseHandler;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Implementation of the ClientRequest that executes or sends the request to
 * Azure DevOps API.
 */
public final class ClientRequestAdapter extends ClientRequest {
    /**
     * Represents the access token.
     */
    private final AccessTokenCredential accessTokenCredential;
    /**
     * Request information with all required parameters.
     */
    private final RequestInformation reqInfo;
    /**
     * Serializer context to serialize and deserialize the objects.
     */
    private final SerializerContext serializer;
    /**
     * Response handler to handle the API response.
     */
    private final ResponseHandler handler;
    /**
     * HttpClient object to send the request.
     */
    private final HttpClient client;
    /**
     * Http request object to construct the request.
     */
    private final HttpRequest request;

    /**
     * Default.
     * @param builder Client request builder object.
     */
    public ClientRequestAdapter(ClientRequestBuilder builder) {
        this.reqInfo = Objects.requireNonNull(builder.request());
        this.accessTokenCredential = builder.accessTokenCredential();
        this.client = InstanceFactory.createHttpClient();
        this.serializer = InstanceFactory.createSerializerContext();
        this.handler = InstanceFactory.createResponseHandler(this.accessTokenCredential, this.reqInfo);
        this.request = InstanceFactory.createHttpRequest(this.accessTokenCredential, this.reqInfo);
    }

    /**
     * Executes the raw request without serialization.
     * @return String response from API.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public CompletableFuture<String> executeStringAsync() throws AzDException {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo));
    }

    /**
     * Executes the request and returns the deserialized response.
     * @param model Represents the entity or model for which the response should be deserialized to.
     * @return Deserialized response from API.
     * @param <T> Represents model.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public <T extends SerializableEntity> CompletableFuture<T> executeAsync(Class<T> model) throws AzDException {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> {
                    try {
                        var response = handler.handle(resp, reqInfo);
                        return serializer.deserialize(response, model);
                    } catch (AzDException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    /**
     * Executes the request and returns the stream response from API.
     * @return Stream response. {@link InputStream}
     * @throws AzDException Default API exception handler.
     */
    @Override
    public CompletableFuture<InputStream> executeStreamAsync() throws AzDException {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo));
    }

    /**
     * Executes the request and doesn't return any response. Useful for DELETE operations.
     * @return Void.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public CompletableFuture<Void> executePrimitiveAsync() throws AzDException {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAcceptAsync(resp -> {
                    var response = handler.handle(resp, reqInfo);
                    if (!response.isEmpty()) {
                        try {
                            serializer.deserialize(response, Map.class);
                        } catch (AzDException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    /**
     * Executes the request and returns the deserialized response.
     * @param model Represents the entity or model for which the response should be deserialized to.
     * @return Deserialized response from API.
     * @param <T> Represents model.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public <T extends SerializableEntity> T execute(Class<T> model) throws AzDException {
        var result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo)).join();
        return serializer.deserialize(result, model);

    }

    /**
     * Executes the raw request without serialization.
     * @return String response from API.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public String executeString() throws AzDException {
        return executeStringAsync().join();
    }

    /**
     * Executes the request and returns the stream response from API.
     * @return Stream response. {@link InputStream}
     * @throws AzDException Default API exception handler.
     */
    @Override
    public InputStream executeStream() throws AzDException {
        return executeStreamAsync().join();
    }

    /**
     * Executes the request and doesn't return any response. Useful for DELETE operations.
     * @return Void.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public Void executePrimitive() throws AzDException {
        var result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo)).join();

        if (!result.isEmpty()) serializer.deserialize(result, Map.class);
        return null;
    }

    /**
     * Return the request information object.
     * @return RequestInformation {@link RequestInformation}
     */
    @Override
    public RequestInformation request() {
        return reqInfo;
    }

    /**
     * Returns the access token credential object.
     * @return AccessTokenCredential {@link AccessTokenCredential}
     */
    @Override
    public AccessTokenCredential accessTokenCredential() {
        return accessTokenCredential;
    }
}
