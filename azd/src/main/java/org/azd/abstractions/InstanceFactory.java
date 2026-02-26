package org.azd.abstractions;

import org.azd.abstractions.handlers.*;
import org.azd.abstractions.pipelines.ResponsePipeline;
import org.azd.abstractions.pipelines.ResponsePipelineBuilder;
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

    public static RetryHandler createRetryHandler() {
        return new DefaultRetryHandler();
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
     * Creates the response pipeline with all handlers.
     * @return ResponsePipeline with default response handlers.
     */
    public static ResponsePipeline createResponsePipeline() {
        return ResponsePipelineBuilder.create()
                .add(ApiResponseHandler::new)
                .add(RedirectResponseHandler::new)
                .add(() -> new ErrorResponseHandler(createSerializerContext()))
                .add(() -> new SerializerHandler(createSerializerContext()))
                .build();
    }
}
