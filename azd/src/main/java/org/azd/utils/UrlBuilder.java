package org.azd.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class UrlBuilder {
    private final StringBuilder urlBuilder;

    private UrlBuilder(String baseUrl) {
        Objects.requireNonNull(baseUrl, "Base url cannot be null.");
        this.urlBuilder = new StringBuilder(baseUrl);
    }

    public static UrlBuilder fromBaseUrl(String baseUrl) {
        return new UrlBuilder(baseUrl);
    }

    public UrlBuilder appendPath(String path) {
        if (path != null) {
            if (urlBuilder.charAt(urlBuilder.length() - 1) != '/' && path.charAt(0) != '/')
                urlBuilder.append('/');
            urlBuilder.append(path);
        }

        return this;
    }

    public URI build() {
        try {
            return new URI(urlBuilder.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to build URI", e);
        }
    }
}
