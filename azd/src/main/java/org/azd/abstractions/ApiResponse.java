package org.azd.abstractions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.enums.HttpStatusCode;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    @JsonProperty("statusCode")
    private final HttpStatusCode statusCode;
    @JsonProperty("responseHeadersMap")
    private final Map<String, List<String>> responseHeadersMap;
    @JsonProperty("responseBody")
    private final Object responseBody;
    @JsonProperty("requestUrl")
    private final String requestUrl;
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

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    @JsonIgnore
    public HttpHeaders getResponseHeaders() {
        return HttpHeaders.of(responseHeadersMap, (name, value) -> true);
    }

    public Map<String, List<String>> getResponseHeadersMap() {
        return responseHeadersMap;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

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
