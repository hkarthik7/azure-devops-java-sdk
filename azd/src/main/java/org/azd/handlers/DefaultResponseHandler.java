package org.azd.handlers;

import org.azd.http.ApiResponse;
import org.azd.http.RequestInformation;
import org.azd.interfaces.ResponseHandler;
import org.azd.interfaces.RetryHandler;

import java.net.http.HttpResponse;

public class DefaultResponseHandler implements ResponseHandler {
    private final RetryHandler retryHandler;

    public DefaultResponseHandler(RetryHandler handler) {
        this.retryHandler = handler;
    }
    @Override
    public <T> void handle(HttpResponse<T> response, RequestInformation requestInformation) {
        DefaultResponseHandler.response = new ApiResponse(response.statusCode(), response.headers(),
                response.body(), response.request().uri().toString(), requestInformation);

        if (shouldRetry(response)) retryHandler.retry(response);
    }
    public static ApiResponse getResponse() {
        return response;
    }
    private <T> boolean shouldRetry(HttpResponse<T> response) {
        return response.statusCode() >= 500;
    }
    private static ApiResponse response;
}
