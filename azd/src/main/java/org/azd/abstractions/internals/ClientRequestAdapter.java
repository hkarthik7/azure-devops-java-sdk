package org.azd.abstractions.internals;

import org.azd.abstractions.InstanceFactory;
import org.azd.abstractions.RequestInformation;
import org.azd.abstractions.handlers.ResponseContext;
import org.azd.abstractions.handlers.RetryHandler;
import org.azd.abstractions.pipelines.ResponsePipeline;
import org.azd.abstractions.serializer.SerializableEntity;
import org.azd.authentication.AccessTokenCredential;
import org.azd.exceptions.AzDException;
import org.azd.http.ClientRequest;

import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

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
     * HttpClient object to send the request.
     */
    private final HttpClient client;
    /**
     * Http request object to construct the request.
     */
    private final HttpRequest request;
    private final ResponsePipeline pipeline;
    private final RetryHandler retryHandler;

    /**
     * Default.
     *
     * @param builder Client request builder object.
     */
    public ClientRequestAdapter(ClientRequestBuilder builder) {
        this.reqInfo = Objects.requireNonNull(builder.request());
        this.accessTokenCredential = builder.accessTokenCredential();
        this.client = InstanceFactory.createHttpClient();
        this.request = InstanceFactory.createHttpRequest(this.accessTokenCredential, this.reqInfo);
        this.pipeline = InstanceFactory.createResponsePipeline();
        this.retryHandler = InstanceFactory.createRetryHandler();
    }

    /**
     * Executes the raw request without serialization.
     *
     * @return String response from API.
     */
    @Override
    public CompletableFuture<String> executeStringAsync() {
        return retryHandler.executeAsync(() ->
                        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
                .thenCompose(resp -> {
                    var context = new ResponseContext(resp, reqInfo, null);
                    return pipeline.processAsync(context);
                });
    }

    /**
     * Executes the request and returns the deserialized response.
     *
     * @param model Represents the entity or model for which the response should be deserialized to.
     * @param <T>   Represents model.
     * @return Deserialized response from API.
     */
    @Override
    public <T extends SerializableEntity> CompletableFuture<T> executeAsync(Class<T> model) {
        return retryHandler.executeAsync(() ->
                        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
                .thenCompose(resp -> {
                    var context = new ResponseContext(resp, reqInfo, model);
                    return pipeline.processAsync(context);
                })
                .thenApplyAsync(model::cast);

    }

    /**
     * Executes the request and returns the stream response from API.
     *
     * @return Stream response. {@link InputStream}
     */
    @Override
    public CompletableFuture<InputStream> executeStreamAsync() {
        return retryHandler.executeAsync(() ->
                        client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream()))
                .thenCompose(resp -> {
                    var context = new ResponseContext(resp, reqInfo, null);
                    return pipeline.processAsync(context);
                });
    }

    /**
     * Executes the request built by ClientRequest.Builder and doesn't return any response. This is mainly used for Api calls
     * that returns 201 or any operation that doesn't return response.
     *
     * @return Future void.
     */
    @Override
    public CompletableFuture<Void> executePrimitiveAsync() {
        return retryHandler.executeAsync(() ->
                        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()))
                .thenCompose(resp -> {
                    var context = new ResponseContext(resp, reqInfo, null);
                    return pipeline.processAsync(context)
                            .thenApply(result -> null);
                });
    }

    /**
     * Executes the request and returns the deserialized response.
     *
     * @param model Represents the entity or model for which the response should be deserialized to.
     * @param <T>   Represents model.
     * @return Deserialized response from API.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public <T extends SerializableEntity> T execute(Class<T> model) throws AzDException {
        try {
            return executeAsync(model).join();
        } catch (CompletionException e) {
            var cause = e.getCause();
            if (cause instanceof AzDException) {
                throw (AzDException) cause;
            }
            throw new AzDException(cause.getMessage());
        }
    }

    /**
     * Executes the raw request without serialization.
     *
     * @return String response from API.
     * @throws AzDException Default API exception handler.
     */
    @Override
    public String executeString() throws AzDException {
        try {
            return executeStringAsync().join();
        } catch (CompletionException e) {
            var cause = e.getCause();
            if (cause instanceof AzDException) {
                throw (AzDException) cause;
            }
            throw new AzDException(cause.getMessage());
        }
    }

    /**
     * Executes the request and returns the stream response from API.
     *
     * @return Stream response. {@link InputStream}
     * @throws AzDException Default API exception handler.
     */
    @Override
    public InputStream executeStream() throws AzDException {
        try {
            return executeStreamAsync().join();
        } catch (CompletionException e) {
            var cause = e.getCause();
            if (cause instanceof AzDException) {
                throw (AzDException) cause;
            }
            throw new AzDException(cause.getMessage());
        }
    }

    /**
     * Executes the request built by ClientRequest.Builder and doesn't return any response. This is mainly used for Api calls
     * that returns 201 or any operation that doesn't return response.
     *
     * @return Future void.
     */
    @Override
    public Void executePrimitive() throws AzDException {
        try {
            return executePrimitiveAsync().join();
        } catch (CompletionException e) {
            var cause = e.getCause();
            if (cause instanceof AzDException) {
                throw (AzDException) cause;
            }
            throw new AzDException(cause.getMessage());
        }
    }

    /**
     * Return the request information object.
     *
     * @return RequestInformation {@link RequestInformation}
     */
    @Override
    public RequestInformation request() {
        return reqInfo;
    }

    /**
     * Returns the access token credential object.
     *
     * @return AccessTokenCredential {@link AccessTokenCredential}
     */
    @Override
    public AccessTokenCredential accessTokenCredential() {
        return accessTokenCredential;
    }
}
