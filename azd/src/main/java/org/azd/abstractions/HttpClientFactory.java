package org.azd.abstractions;

import java.net.http.HttpClient;
import java.util.Objects;

public class HttpClientFactory {
    private HttpClientFactory() {
    }

    public static HttpClient create(final RequestOption option) {
        Objects.requireNonNull(option, "Request options cannot be null.");
        var client = HttpClient
                .newBuilder()
                .followRedirects(option.getRedirectPolicy())
                .version(option.getVersion())
                .connectTimeout(option.getConnectionTimeOut());
        if (option.getProxySelector() != null) client.proxy(option.getProxySelector());
        if (option.getAuthenticator() != null) client.authenticator(option.getAuthenticator());
        return client.build();
    }
}
