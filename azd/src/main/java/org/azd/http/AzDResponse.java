package org.azd.http;

import java.net.http.HttpHeaders;
import java.util.OptionalLong;

public class AzDResponse {
    public int getStatusCode() {
        return statusCode;
    }
    public HttpHeaders getResponseHeaders() {
        return responseHeaders;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    /**
     * Retrieves the continuation token from response header. This can then be used for getting the paginated response.
     * Note that not all the Apis return continuation token in the headers. If the header value "x-ms-continuationtoken"
     * is present then it will be returned or an empty string will be returned.
     * @return String value.
     */
    public String getContinuationToken() {
        return responseHeaders.firstValue("x-ms-continuationtoken").orElse(null);
    }

    /**
     * Http Headers of last request. We want to make these accessible everywhere (i.e) something that
     * can be checked after every request, but we don't want to have to modify all the existing API methods
     * to return the data.
     *
     * We need this to be able to check if we are near any API rate limits - as creating 20+ releases in
     * a short time can cause one to go over the limit and even have requests fail.
     * Method to get retryAfterInterval value from response header
     * @return Value in seconds (if it exists in header) of how long we should wait to send next request.
     */
    public OptionalLong retryAfterInterval() {
        if (responseHeaders != null) {
            return responseHeaders.firstValueAsLong("Retry-After");
        }
        return OptionalLong.empty();
    }

    public AzDResponse(int statusCode, HttpHeaders responseHeaders, Object responseBody) {
        this.statusCode = statusCode;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
    }

    private final int statusCode;
    private final HttpHeaders responseHeaders;
    private final Object responseBody;
}
