package org.azd.http;

import org.azd.utils.AzDDefaultRegisterFactory;

import java.net.http.HttpClient;

public class RequestClientBuilderFactory {
    public static HttpClient create() {
        return create(null);
    }
    public static HttpClient create(RequestOption option) {
        final var defaultOption = option == null ? AzDDefaultRegisterFactory.createRequestOption() : option;

        return HttpClient
                .newBuilder()
                .followRedirects(defaultOption.getRedirectPolicy())
                .version(defaultOption.getVersion())
                .connectTimeout(defaultOption.getConnectionTimeOut())
                .build();
    }

    private RequestClientBuilderFactory() {}
}
