package org.azd.abstractions.handlers;

import org.azd.abstractions.RequestInformation;

import java.net.http.HttpResponse;
import java.util.Optional;

public final class ResponseContext {
    private final HttpResponse<?> response;
    private final RequestInformation request;
    private final Class<?> model;
    private final ContentType contentType;
    private Object body;
    private int statusCode;

    public ResponseContext(HttpResponse<?> response,
                           RequestInformation request,
                           Class<?> model) {
        this.response = response;
        this.request = request;
        this.model = model;
        this.body = response.body();
        this.statusCode = response.statusCode();
        this.contentType = ContentType.from(response);
    }

    public HttpResponse<?> response() {
        return response;
    }

    public RequestInformation request() {
        return request;
    }

    public ContentType contentType() {
        return contentType;
    }
    public Class<?> model() {
        return model;
    }

    public Object body() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public int statusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Optional<String> header(String value) {
        return response.headers().firstValue(value);
    }
}

