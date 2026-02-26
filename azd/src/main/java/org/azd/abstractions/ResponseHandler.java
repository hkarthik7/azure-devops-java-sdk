package org.azd.abstractions;

import org.azd.abstractions.handlers.ResponseContext;
import org.azd.exceptions.AzDException;

import java.util.concurrent.CompletableFuture;

/**
 * Handles the Api response.
 */
public abstract class ResponseHandler {
    protected ResponseHandler next;
    private static ApiResponse apiResponse;

    /**
     * Sets the next handler in pipeline.
     * @param next Next handler to invoke
     * @return ResponseHandler handler.
     */
    public ResponseHandler setNext(ResponseHandler next) {
        this.next = next;
        return next;
    }

    /**
     * Invokes the next handler in the pipeline
     * @param context Response context object container.
     * @return Result of invocation.
     */
    protected CompletableFuture<Void> nextAsync(ResponseContext context) {
        if (next == null) {
            return CompletableFuture.completedFuture(null);
        }
        return next.handleAsync(context);
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
     * @param context ResponseContext object {@link ResponseContext}
     * @return Java type value that is passed.
     */
    public abstract CompletableFuture<Void> handleAsync(ResponseContext context);

    /**
     * Sets the Api response object.
     * @param response ApiResponse object to set {@link ApiResponse}
     */
    public static void setResponse(ApiResponse response) {
        apiResponse = response;
    }
}
