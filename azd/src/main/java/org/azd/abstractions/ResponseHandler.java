package org.azd.abstractions;

import org.azd.abstractions.handlers.DefaultResponseHandler;
import org.azd.abstractions.handlers.RetryHandler;

import java.net.http.HttpResponse;

public abstract class ResponseHandler {
    protected static ApiResponse apiResponse;
    protected final RetryHandler retryHandler;

    protected ResponseHandler(RetryHandler retryHandler) {
        this.retryHandler = retryHandler;
    }

    public static ResponseHandler create(RetryHandler retryHandler) {
        return new DefaultResponseHandler(retryHandler);
    }

    public static ApiResponse getResponse() {
        return apiResponse;
    }

    public abstract <T> T handle(HttpResponse<T> response, RequestInformation requestInformation);

}
