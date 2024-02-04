package org.azd.utils;

import org.azd.helpers.URLHelper;

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
        if (path != null && !path.isEmpty()) {
            if (urlBuilder.length() > 0 && urlBuilder.charAt(urlBuilder.length() - 1) != '/') {
                urlBuilder.append('/');
            }

            if (path.charAt(0) == '/') {
                path = path.substring(1);
            }

            urlBuilder.append(URLHelper.encodeSpace(path));
        }
        return this;
    }

    public UrlBuilder appendQueryString(String key, String value) {
        Objects.requireNonNull(key, "Query parameter key cannot be null.");
        if (value != null) {
            if (urlBuilder.indexOf("?") == -1) {
                urlBuilder.append('?');
            } else {
                urlBuilder.append('&');
            }
            urlBuilder.append(encode(key)).append('=').append(encode(value));
        }

        return this;
    }

    private String encode(String value) {
        return URLHelper.encodeSpecialWithSpace(value);
    }

    public URI build() {
        try {
            return new URI(urlBuilder.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to build URI", e);
        }
    }
}
