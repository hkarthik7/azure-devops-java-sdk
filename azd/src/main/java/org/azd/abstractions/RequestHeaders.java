package org.azd.abstractions;

import org.azd.enums.CustomHeader;

import java.util.HashMap;

/**
 * Container class to set the request headers.
 */
public class RequestHeaders {
    private final HashMap<String, String> headers;

    public RequestHeaders() {
        this.headers = new HashMap<>();
    }

    /**
     * Adds a custom header.
     * @param customHeader Custom header to add {@link CustomHeader}.
     */
    public void add(CustomHeader customHeader) {
        if (customHeader != null)
            headers.put(customHeader.getName(), customHeader.getValue());
    }

    /**
     * Adds a new request header object.
     * @param requestHeaders Request headers to add.
     */
    public void add(RequestHeaders requestHeaders) {
        if (requestHeaders != null)
            for (var key : requestHeaders.getHeaders().keySet())
                add(key, requestHeaders.getHeaders().get(key));
    }

    /**
     * Removes the custom header value.
     * @param customHeader Custom header to remove.
     */
    public void remove(CustomHeader customHeader) {
        headers.remove(customHeader.getName());
    }

    /**
     * Replaces the custom header value with the given value.
     * @param customHeader Custom header to replace.
     */
    public void replace(CustomHeader customHeader) {
        headers.replace(customHeader.getName(), customHeader.getValue());
    }

    /**
     * Clears the headers.
     */
    public void clear() {
        headers.clear();
    }

    /**
     * Adds the header name and value.
     * @param name Header name to add.
     * @param value Header value to add.
     */
    public void add(String name, String value) {
        headers.put(name, value);
    }

    /**
     * Remove the header name.
     * @param name Header name to remove.
     */
    public void remove(String name) {
        headers.remove(name);
    }

    /**
     * Replace a header value.
     * @param name Header name.
     * @param value Header value to replace.
     */
    public void replace(String name, String value) {
        headers.replace(name, value);
    }

    /**
     * Get the headers.
     * @return Map of headers.
     */
    public HashMap<String, String> getHeaders() {
        return headers;
    }

    /**
     * Check if the header map os empty.
     * @return True if the map is empty.
     */
    public boolean isEmpty() {
        return headers.isEmpty();
    }
}
