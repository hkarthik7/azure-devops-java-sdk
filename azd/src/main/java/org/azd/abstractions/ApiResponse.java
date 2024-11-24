package org.azd.abstractions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.HttpStatusCode;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

/**
 * Container class that holds Api request and response information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    /**
     * Specifies Http status code.
     */
    @JsonProperty("statusCode")
    private final HttpStatusCode statusCode;
    /**
     * Map of response headers.
     */
    @JsonProperty("responseHeadersMap")
    private final Map<String, List<String>> responseHeadersMap;
    /**
     * Response body.
     */
    @JsonProperty("responseBody")
    private final Object responseBody;
    /**
     * Request url.
     */
    @JsonProperty("requestUrl")
    private final String requestUrl;
    /**
     * Contains request information object.
     */
    @JsonProperty("requestInformation")
    private final RequestInformation requestInformation;

    public ApiResponse(HttpStatusCode statusCode, Map<String, List<String>> responseHeadersMap, Object responseBody, String requestUrl,
                       RequestInformation requestInformation) {
        this.statusCode = statusCode;
        this.responseHeadersMap = responseHeadersMap;
        this.responseBody = responseBody;
        this.requestUrl = requestUrl;
        this.requestInformation = requestInformation;
    }

    /**
     * Get the status code.
     * @return Http status code {@link HttpStatusCode}
     */
    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    /**
     * Get the response headers.
     * @return Http headers {@link HttpHeaders}.
     */
    @JsonIgnore
    public HttpHeaders getResponseHeaders() {
        return HttpHeaders.of(responseHeadersMap, (name, value) -> true);
    }

    /**
     * Get the response headers map.
     * @return Map of response headers.
     */
    public Map<String, List<String>> getResponseHeadersMap() {
        return responseHeadersMap;
    }

    /**
     * Get the response body.
     * @return Object of response body.
     */
    public Object getResponseBody() {
        return responseBody;
    }

    /**
     * Get the request url.
     * @return Request url.
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * Get the request information object.
     * @return RequestInformation object {@link RequestInformation}.
     */
    public RequestInformation getRequestInformation() {
        return requestInformation;
    }

    /**
     * Retrieves the continuation token from response header. This can then be used for getting the paginated response.
     * Note that not all the Apis return continuation token in the headers. If the header value "x-ms-continuationtoken"
     * is present then it will be returned or an empty string will be returned.
     *
     * @return String value.
     */
    public String getContinuationToken() {
        return getResponseHeaders().firstValue("x-ms-continuationtoken").orElse(null);
    }
}
