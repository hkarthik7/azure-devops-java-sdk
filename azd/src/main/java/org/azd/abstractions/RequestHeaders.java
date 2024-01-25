package org.azd.abstractions;

import org.azd.enums.CustomHeader;

import java.util.HashMap;

public class RequestHeaders {
    private final HashMap<String, String> headers;

    public RequestHeaders() {
        this.headers = new HashMap<>();
    }

    public void add(CustomHeader customHeader) {
        if (customHeader != null)
            headers.put(customHeader.getName(), customHeader.getValue());
    }

    public void add(RequestHeaders requestHeaders) {
        if (requestHeaders != null)
            for (var key : requestHeaders.getHeaders().keySet())
                add(key, requestHeaders.getHeaders().get(key));
    }

    public void remove(CustomHeader customHeader) {
        headers.remove(customHeader.getName());
    }

    public void replace(CustomHeader customHeader) {
        headers.replace(customHeader.getName(), customHeader.getValue());
    }

    public void clear() {
        headers.clear();
    }

    public void add(String name, String value) {
        headers.put(name, value);
    }

    public void remove(String name) {
        headers.remove(name);
    }

    public void replace(String name, String value) {
        headers.replace(name, value);
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public boolean isEmpty() {
        return headers.isEmpty();
    }
}
