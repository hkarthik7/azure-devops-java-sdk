package org.azd.utils;

import org.azd.helpers.URLHelper;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * Utility class to build the url.
 */
public class UrlBuilder {
    /**
     * String builder to build the url on need.
     */
    private final StringBuilder urlBuilder;

    /**
     * Default private constructor
     *
     * @param baseUrl Base url or base address
     */
    private UrlBuilder(String baseUrl) {
        Objects.requireNonNull(baseUrl, "Base url cannot be null.");
        this.urlBuilder = new StringBuilder(baseUrl);
    }

    /**
     * Creates a new instance of UrlBuilder with the given base address.
     *
     * @param baseUrl Pass the base url.
     * @return UrlBuilder {@link UrlBuilder}
     */
    public static UrlBuilder fromBaseUrl(String baseUrl) {
        return new UrlBuilder(baseUrl);
    }

    /**
     * Appends the path value with the base address and return the instance of Url builder.
     *
     * @param path path value to append.
     * @return UrlBuilder {@link UrlBuilder}
     */
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

    /**
     * Appends the query string with formed url.
     *
     * @param key   Name of the query parameter.
     * @param value Value for the query parameter.
     * @return UrlBuilder {@link UrlBuilder}
     */
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

    /**
     * Return the new URI formed upon build.
     *
     * @return URI {@link URI}
     */
    public URI build() {
        try {
            return new URI(urlBuilder.toString());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to build URI", e);
        }
    }

    /**
     * Encodes the given value.
     *
     * @param value string value to encode.
     * @return Encoded string.
     */
    private String encode(String value) {
        return URLHelper.encodeSpecialWithSpace(value);
    }
}
