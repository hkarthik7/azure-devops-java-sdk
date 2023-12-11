package org.azd.http;

import org.azd.exceptions.AzDException;
import org.azd.interfaces.AccessTokenCredential;
import org.azd.interfaces.RequestAdapter;
import org.azd.interfaces.ResponseHandler;
import org.azd.interfaces.SerializerContext;
import org.azd.serializer.SerializableEntity;
import org.azd.utils.InstanceFactory;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class DefaultRequestAdapter implements RequestAdapter {
    private final HttpClient client;
    private final AccessTokenCredential accessTokenCredential;
    private final SerializerContext serializer;
    private final ResponseHandler handler;


    public DefaultRequestAdapter(AccessTokenCredential accessTokenCredential) {
        this(accessTokenCredential, null, null, null);
    }

    public DefaultRequestAdapter(AccessTokenCredential accessTokenCredential, SerializerContext serializer) {
        this(accessTokenCredential, null, serializer, null);
    }

    public DefaultRequestAdapter(AccessTokenCredential accessTokenCredential, HttpClient client) {
        this(accessTokenCredential, client, null, null);
    }

    public DefaultRequestAdapter(AccessTokenCredential accessTokenCredential, HttpClient client, SerializerContext serializer) {
        this(accessTokenCredential, client, serializer, null);
    }

    public DefaultRequestAdapter(AccessTokenCredential accessTokenCredential, HttpClient client,
                                 SerializerContext serializer, ResponseHandler handler) {
        this.accessTokenCredential = accessTokenCredential;
        this.client = client == null ? RequestClientBuilderFactory.create() : client;
        this.serializer = serializer == null ? InstanceFactory.createSerializerContext() : serializer;
        this.handler = handler == null ? InstanceFactory.createResponseHandler() : handler;
    }

    @Override
    public CompletableFuture<String> sendStringAsync(RequestInformation requestInformation) throws AzDException {
        return client.sendAsync(getRequest(requestInformation), HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> {
                    handler.handle(resp, requestInformation);
                    return resp.body();
                });
    }

    @Override
    public <T extends SerializableEntity> CompletableFuture<T> sendAsync(RequestInformation requestInformation,
                                                                         Class<T> model) throws AzDException {
        return client.sendAsync(getRequest(requestInformation), HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> {
                    try {
                        handler.handle(resp, requestInformation);
                        return serializer.deserialize(resp.body(), model);
                    } catch (AzDException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Override
    public CompletableFuture<InputStream> sendStreamAsync(RequestInformation requestInformation) throws AzDException {
        return client.sendAsync(getRequest(requestInformation), HttpResponse.BodyHandlers.ofInputStream())
                .thenApplyAsync(resp -> {
                    handler.handle(resp, requestInformation);
                    return resp.body();
                });
    }

    @Override
    public CompletableFuture<Void> sendPrimitiveAsync(RequestInformation requestInformation) throws AzDException {
        return client.sendAsync(getRequest(requestInformation), HttpResponse.BodyHandlers.ofString())
                .thenAcceptAsync(resp -> {
                    handler.handle(resp, requestInformation);
                    if (!resp.body().isEmpty()) {
                        try {
                            serializer.deserialize(resp.body(), Map.class);
                        } catch (AzDException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    @Override
    public <T extends SerializableEntity> T send(RequestInformation requestInformation,
                                                 Class<T> model) throws AzDException {
        var result = client.sendAsync(getRequest(requestInformation), HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> {
                    handler.handle(resp, requestInformation);
                    return resp.body();
                }).join();
        return serializer.deserialize(result, model);

    }

    @Override
    public String sendString(RequestInformation requestInformation) throws AzDException {
        return sendStringAsync(requestInformation).join();
    }

    @Override
    public InputStream sendStream(RequestInformation requestInformation) throws AzDException {
        return sendStreamAsync(requestInformation).join();
    }

    @Override
    public Void sendPrimitive(RequestInformation requestInformation) throws AzDException {
        var result = client.sendAsync(getRequest(requestInformation), HttpResponse.BodyHandlers.ofString())
                .thenApplyAsync(resp -> {
                    handler.handle(resp, requestInformation);
                    return resp.body();
                }).join();

        if (!result.isEmpty()) serializer.deserialize(result, Map.class);
        return null;
    }

    private HttpRequest getRequest(RequestInformation requestInfo) throws AzDException {
        var builder = HttpRequest.newBuilder(URI.create(requestInfo.getRequestUrl()));

        if (accessTokenCredential != null) builder.setHeader("Authorization", accessTokenCredential.getAccessToken());

        requestInfo.requestHeaders.getHeaders().forEach(builder::header);

        var body = HttpRequest.BodyPublishers.ofString(serializer.serialize(requestInfo.requestBody));
        if (requestInfo.inputStream != null)
            body = HttpRequest.BodyPublishers.ofInputStream(() -> requestInfo.inputStream);

        return builder.method(requestInfo.requestMethod.name(), body).build();
    }
}
