package org.azd.abstractions;

import org.azd.abstractions.handlers.RequestExecutor;
import org.azd.abstractions.handlers.RetryHandler;
import org.azd.abstractions.serializer.JsonSerializer;
import org.azd.abstractions.serializer.SerializerContext;
import org.azd.authentication.AccessTokenCredential;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public final class InstanceFactory {
    private InstanceFactory() {
    }

    public static SerializerContext createSerializerContext() {
        return new JsonSerializer();
    }

    public static HttpClient createHttpClient() {
        var reqOption = ClientConfiguration.getInstance().getRequestOption();
        reqOption = reqOption == null ? RequestOption.getInstance() : reqOption;
        return HttpClientFactory.create(reqOption);
    }

    public static HttpRequest createHttpRequest(AccessTokenCredential accessTokenCredential,
                                                RequestInformation requestInformation) {
        return HttpRequestFactory.create(accessTokenCredential, requestInformation);
    }

    public static ResponseHandler createResponseHandler(AccessTokenCredential accessTokenCredential,
                                                        RequestInformation requestInformation) {
        var retryHandler = ClientConfiguration.getInstance().getRetryHandler();
        retryHandler = retryHandler == null ? new RetryHandler(
                new RequestExecutor(accessTokenCredential, requestInformation)) : retryHandler;
        return ResponseHandler.create(retryHandler);
    }
}
