package org.azd.abstractions.handlers;

import org.azd.abstractions.ApiResponse;
import org.azd.abstractions.ResponseHandler;
import org.azd.enums.HttpStatusCode;

import java.util.concurrent.CompletableFuture;

public final class ApiResponseHandler extends ResponseHandler {
    @Override
    public CompletableFuture<Void> handleAsync(ResponseContext context) {
        var response = context.response();

        setResponse(new ApiResponse(
                HttpStatusCode.from(response.statusCode()),
                response.headers().map(),
                response.body(),
                response.request().uri().toString(),
                context.request()
        ));

        return nextAsync(context);
    }
}
