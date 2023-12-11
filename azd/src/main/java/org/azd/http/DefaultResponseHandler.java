package org.azd.http;

import org.azd.interfaces.ResponseHandler;
import org.azd.interfaces.SerializerContext;
import org.azd.utils.InstanceFactory;

import java.net.http.HttpResponse;

public class DefaultResponseHandler implements ResponseHandler {
    private final SerializerContext serializer;

    public DefaultResponseHandler() {
        this(null);
    }
    public DefaultResponseHandler(SerializerContext serializer) {
        this.serializer = serializer == null ? InstanceFactory.createSerializerContext() : serializer;
    }

    @Override
    public <T> void handle(HttpResponse<T> response, RequestInformation requestInformation) {
        DefaultResponseHandler.response = new ApiResponse(response.statusCode(), response.headers(),
                response.body(), response.request().uri().toString(), requestInformation);
    }

    public static ApiResponse getResponse() {
        return response;
    }

    private static ApiResponse response;
}
