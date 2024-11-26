package org.azd.abstractions;

import org.azd.abstractions.handlers.DefaultResponseHandler;
import org.azd.abstractions.handlers.RetryHandler;

import java.net.http.HttpResponse;

/**
 * Handler the Api response.
 */
public abstract class ResponseHandler {
    protected static ApiResponse apiResponse;
    protected final RetryHandler retryHandler;

    protected ResponseHandler(RetryHandler retryHandler) {
        this.retryHandler = retryHandler;
    }

    /**
     * Creates an instance of Response handler.
     * @param retryHandler Retry handler to retry the request.
     * @return Response handler object.
     */
    public static ResponseHandler create(RetryHandler retryHandler) {
        return new DefaultResponseHandler(retryHandler);
    }

    /**
     * Get the Api response object after the execution of a request.
     * @return ApiResponse object {@link ApiResponse}.
     */
    public static ApiResponse getResponse() {
        return apiResponse;
    }

    /**
     * Handles the Api response.
     * @param response Http response object.
     * @param requestInformation Request information object. {@link RequestInformation}.
     * @return Java type value that is passed.
     * @param <T> Type parameter.
     */
    public abstract <T> T handle(HttpResponse<T> response, RequestInformation requestInformation);

}
