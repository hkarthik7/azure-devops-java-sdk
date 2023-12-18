package org.azd.http;

import java.net.http.HttpHeaders;

public class ApiResponse {
    public int getStatusCode() {
        return statusCode;
    }

    public HttpHeaders getResponseHeaders() {
        return responseHeaders;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public String getRequestUrl() { return requestUrl; }

    public RequestInformation getRequestInformation() { return requestInformation; }

    /**
     * Retrieves the continuation token from response header. This can then be used for getting the paginated response.
     * Note that not all the Apis return continuation token in the headers. If the header value "x-ms-continuationtoken"
     * is present then it will be returned or an empty string will be returned.
     * @return String value.
     */
    public String getContinuationToken() {
        return responseHeaders.firstValue("x-ms-continuationtoken").orElse(null);
    }

    public ApiResponse(int statusCode, HttpHeaders responseHeaders, Object responseBody, String requestUrl,
                       RequestInformation requestInformation) {
        this.statusCode = statusCode;
        this.responseHeaders = responseHeaders;
        this.responseBody = responseBody;
        this.requestUrl = requestUrl;
        this.requestInformation = requestInformation;
    }

    private final int statusCode;
    private final HttpHeaders responseHeaders;
    private final Object responseBody;
    private final String requestUrl;
    private final RequestInformation requestInformation;
}
