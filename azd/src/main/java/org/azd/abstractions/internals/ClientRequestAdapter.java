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

public final class ClientRequestAdapter extends ClientRequest {
    private final AccessTokenCredential accessTokenCredential;
    private final RequestInformation reqInfo;
    private final SerializerContext serializer;
    private final ResponseHandler handler;
    private final HttpClient client;
    private final HttpRequest request;

    public ClientRequestAdapter(ClientRequestBuilder builder) {
        this.reqInfo = Objects.requireNonNull(builder.request());
        this.accessTokenCredential = builder.accessTokenCredential();
        this.client = InstanceFactory.createHttpClient();
        this.serializer = InstanceFactory.createSerializerContext();
        this.handler = InstanceFactory.createResponseHandler(this.accessTokenCredential, this.reqInfo);
        this.request = InstanceFactory.createHttpRequest(this.accessTokenCredential, this.reqInfo);
    }

    @Override
    public CompletableFuture<String> executeStringAsync() throws AzDException {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo));
    }

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

    @Override
    public CompletableFuture<InputStream> executeStreamAsync() throws AzDException {
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofInputStream())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo));
    }

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

    @Override
    public <T extends SerializableEntity> T execute(Class<T> model) throws AzDException {
        var result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo)).join();
        return serializer.deserialize(result, model);

    }

    @Override
    public String executeString() throws AzDException {
        return executeStringAsync().join();
    }

    @Override
    public InputStream executeStream() throws AzDException {
        return executeStreamAsync().join();
    }

    @Override
    public Void executePrimitive() throws AzDException {
        var result = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> handler.handle(resp, reqInfo)).join();

        if (!result.isEmpty()) serializer.deserialize(result, Map.class);
        return null;
    }

    @Override
    public RequestInformation request() {
        return reqInfo;
    }

    @Override
    public AccessTokenCredential accessTokenCredential() {
        return accessTokenCredential;
    }
}
