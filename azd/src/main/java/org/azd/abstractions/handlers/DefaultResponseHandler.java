package org.azd.abstractions.handlers;

import org.azd.abstractions.ApiResponse;
import org.azd.abstractions.RequestInformation;
import org.azd.abstractions.ResponseHandler;
import org.azd.enums.HttpStatusCode;

import java.net.http.HttpResponse;
import java.util.OptionalLong;

public class DefaultResponseHandler extends ResponseHandler {

    public DefaultResponseHandler(RetryHandler handler) {
        super(handler);
    }

    @Override
    public <T> T handle(HttpResponse<T> response, RequestInformation requestInformation) {
        apiResponse = new ApiResponse(HttpStatusCode.getByCode(response.statusCode()), response.headers().map(),
                response.body(), response.request().uri().toString(), requestInformation);

        if (shouldRetry(response)) apiResponse = retryHandler.retry(apiResponse);

        return (T) apiResponse.getResponseBody();
    }

    private <T> boolean shouldRetry(HttpResponse<T> response) {
        var retry = OptionalLong.empty();
        if (response.headers() != null) {
            retry = response.headers().firstValueAsLong("Retry-After");
        }
        return response.statusCode() >= 500 || retry.isPresent();
    }
}
