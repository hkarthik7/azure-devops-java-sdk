package org.azd.abstractions;

import org.azd.abstractions.handlers.RequestExecutor;
import org.azd.abstractions.handlers.RetryHandler;
import org.azd.abstractions.serializer.JsonSerializer;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.AccessTokenCredential;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 * Factory class to create an instance of request and response object.
 */
public final class InstanceFactory {
    private InstanceFactory() {
    }

    /**
     * Creates an instance of serializer context.
     * @return SerializerContext {@link SerializerContext}.
     */
    public static SerializerContext createSerializerContext() {
        return new JsonSerializer();
    }

    /**
     * Creates an instance of HttpClient.
     * @return HttpClient {@link HttpClient}.
     */
    public static HttpClient createHttpClient() {
        var reqOption = ClientConfiguration.getInstance().getRequestOption();
        reqOption = reqOption == null ? RequestOption.getInstance() : reqOption;
        return HttpClientFactory.create(reqOption);
    }

    /**
     * Creates an instance of HttpRequest.
     * @param accessTokenCredential Access token credential object.
     * @param requestInformation Request information object to set the request url, request body.
     * @return HttpRequest object {@link HttpRequest}.
     */
    public static HttpRequest createHttpRequest(AccessTokenCredential accessTokenCredential,
                                                RequestInformation requestInformation) {
        return HttpRequestFactory.create(accessTokenCredential, requestInformation);
    }

    /**
     * Creates an instance of response handler object.
     * @param accessTokenCredential Access token credential object.
     * @param requestInformation Request information object to set the request url, request body.
     * @return ResponseHandler {@link ResponseHandler}.
     */
    public static ResponseHandler createResponseHandler(AccessTokenCredential accessTokenCredential,
                                                        RequestInformation requestInformation) {
        var retryHandler = ClientConfiguration.getInstance().getRetryHandler();
        retryHandler = retryHandler == null ? new RetryHandler(
                new RequestExecutor(accessTokenCredential, requestInformation)) : retryHandler;
        return ResponseHandler.create(retryHandler);
    }
}
