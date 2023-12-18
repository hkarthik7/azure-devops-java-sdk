package org.azd.http;

import java.net.http.HttpClient;

public class RequestClientBuilderFactory {
    public static HttpClient create(RequestOption option) {
        return HttpClient
                .newBuilder()
                .followRedirects(option.getRedirectPolicy())
                .version(option.getVersion())
                .connectTimeout(option.getConnectionTimeOut())
                .build();
    }

    private RequestClientBuilderFactory() {}
}
