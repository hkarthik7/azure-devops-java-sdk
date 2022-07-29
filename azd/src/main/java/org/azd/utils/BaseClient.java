package org.azd.utils;

import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Implements HttpRequest request methods to send GET, POST, PATCH and DELETE request
 * to Azure DevOps REST API.
 * @deprecated This is deprecated as of version 5.0.0
 */
@Deprecated
public abstract class BaseClient {

    private static final String AUTHORIZATION = "Authorization";
    private static final JsonMapper MAPPER = new JsonMapper();
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    /**
     * Encodes the personal access token to base 64
     *
     * @param token pass the personal access token
     * @return Encoded string of personal access token for basic authentication
     */
    @Deprecated private static String encodePersonalAccessToken(String token) {
        return "Basic " +
                Base64.getEncoder().encodeToString(("" + ":" + token).getBytes());
    }

    /***
     * Http request builder
     * @param requestUrl request url
     * @param token personal access token
     * @return HttpRequest object to build
     */
    @Deprecated private static HttpRequest.Builder request(String requestUrl, String token) {
        if (token == null) return request(requestUrl);
        return HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .setHeader(AUTHORIZATION, encodePersonalAccessToken(token));
    }

    /***
     * Http request builder
     * @param requestUrl request url
     * @return HttpRequest object to build
     */
    @Deprecated private static HttpRequest.Builder request(String requestUrl) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl));
    }

    /***
     * Response from API for the given request
     * @param r pass the Http request object
     * @return String response from API
     */
    @Deprecated private static String response(HttpRequest r) {
        return CLIENT.sendAsync(r, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     * Sends a GET request to REST API
     *
     * @param requestUrl pass the request url
     * @return response string from the API
     */
    @Deprecated public static String get(String requestUrl) {
        return response(request(requestUrl).GET().header("Accept", "application/json").build());
    }

    /**
     * Sends a GET request to REST API with basic authentication
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @return response string from the API
     */
    @Deprecated public static String get(String requestUrl, String token) {
        return response(request(requestUrl, token).GET().header("Accept", "application/json").build());
    }

    /**
     * Sends a GET request to REST API with basic authentication
     *
     * @param requestUrl  pass the request url
     * @param token       pass the personal access token
     * @param contentType specify the content type
     * @return response string from the API
     */
    @Deprecated public static String get(String requestUrl, String token, String contentType) {
        return response(request(requestUrl, token).GET().header("Accept", contentType).build());
    }

    /**
     * Sends a POST request to REST API with basic authentication and request body
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @param body       pass the request body to post the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String post(String requestUrl, String token, Map body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .POST(HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json")
                        .build());
    }

    /**
     * Sends a POST request to REST API with oauth authentication, content length of the request and request body
     *
     * @param requestUrl pass the request url
     * @param body       pass the request body to post the request
     * @return response string from the API if any
     */
    @Deprecated public static String post(String requestUrl, String body) {
        return response(
                request(requestUrl)
                        .POST(HttpRequest.BodyPublishers.ofString(body))
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .build());
    }

    /***
     * Sends a POST request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to post the request
     * @param contentType content type. E.g., application/json
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String post(String requestUrl, String token, String body, String contentType) throws AzDException {
        return response(
                request(requestUrl, token)
                        .POST(HttpRequest.BodyPublishers.ofString(body))
                        .header("Content-Type", contentType)
                        .build());
    }

    /***
     * Sends a POST request to REST API with oauth authentication, content length of the request and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to post the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String post(String requestUrl, String token, List<Object> body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .POST(HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json-patch+json")
                        .build());
    }

    /**
     * Sends a PATCH request to REST API with basic authentication and request body
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @param body       pass the request body to update the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String patch(String requestUrl, String token, Map body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json")
                        .build());
    }

    /**
     * Sends a PATCH request to REST API with basic authentication and request body
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @param body       pass the request body to update the request
     * @param contentType pass the content type
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String patch(String requestUrl, String token, String body, String contentType) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(body))
                        .header("Content-Type", contentType)
                        .build());
    }


    /**
     * Sends a PATCH request to REST API with basic authentication and request body
     *
     * @param requestUrl  pass the request url
     * @param token       pass the personal access token
     * @param body        pass the request body to update the request
     * @param contentType pass the content type for the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String patch(String requestUrl, String token, Map body, String contentType) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", contentType)
                        .build());
    }

    /**
     * Sends a PATCH request to REST API with basic authentication and request body
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @param body       pass the request body to update the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String patch(String requestUrl, String token, List<Object> body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json")
                        .build());
    }

    /**
     * Sends a PATCH request to REST API with basic authentication and request body
     *
     * @param requestUrl  pass the request url
     * @param token       pass the personal access token
     * @param body        pass the request body to update the request
     * @param contentType pass the content type for the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String patch(String requestUrl, String token, List<Object> body, String contentType) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", contentType)
                        .build());
    }

    /***
     * Sends a PUT request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to update the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String put(String requestUrl, String token, Map body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PUT.toString(), HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json")
                        .build());
    }

    /***
     * Sends a PUT request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to update the request
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    @Deprecated public static String put(String requestUrl, String token, String body, String contentType) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PUT.toString(), HttpRequest.BodyPublishers.ofString(body))
                        .header("Content-Type", contentType)
                        .build());
    }

    /**
     * Sends a DELETE request to REST API with basic authentication
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @return response string from the API if any
     */
    @Deprecated public static String delete(String requestUrl, String token) {
        return response(request(requestUrl, token).DELETE().build());
    }

    /**
     * Helper inner class for managing the response as stream.
     */
    @Deprecated public abstract static class StreamBuilder {
        @Deprecated private static HttpClient.Redirect REDIRECT_POLICY = HttpClient.Redirect.NORMAL;

        /**
         * Get the current redirect policy.
         *
         * @return HttpClient.Redirect policy.
         */
        @Deprecated public static HttpClient.Redirect getRedirectPolicy() {
            return REDIRECT_POLICY;
        }

        /**
         * Set the current redirect policy.
         *
         * @param redirectPolicy HttpClient.Redirect policy.
         */
        @Deprecated public static void setRedirectPolicy(HttpClient.Redirect redirectPolicy) {
            REDIRECT_POLICY = redirectPolicy;
        }

        /**
         * Sends a POST request to REST API with basic authentication.
         *
         * @param requestMethod   Type of request method - get, post, put, delete and patch. {@link RequestMethod}.
         * @param requestUrl      pass the request url.
         * @param token           pass the personal access token.
         * @param contentType     Type of content to send and accept from API.
         * @param contentStream   Request body as stream for post request.
         * @param customHeaders   custom headers to send with the post request.
         * @param followRedirects if true follow the redirect URL.
         * @return Input stream response from the API.
         */
        @Deprecated public static InputStream response(RequestMethod requestMethod, String requestUrl,
                                           String token, String contentType, InputStream contentStream,
                                           Map<String, String> customHeaders, boolean followRedirects) {
            var client = getClient(followRedirects);

            // TODO: Add handlers for PUT, PATCH and DELETE methods.
            if (requestMethod.name().equals("GET"))
                return client.sendAsync(request(requestUrl, token).GET().header("Accept", contentType).build(),
                        HttpResponse.BodyHandlers.ofInputStream())
                        .thenApplyAsync(HttpResponse::body)
                        .join();

            if (requestMethod.name().equals("POST")) {
                // custom header can be content type, content length etc.
                if (customHeaders != null) {
                    for (var key : customHeaders.keySet()) {
                        return client.sendAsync(request(requestUrl, token)
                                .POST(HttpRequest.BodyPublishers.ofInputStream(() -> contentStream))
                                .header("Accept", contentType)
                                .header(key, customHeaders.get(key))
                                .build(), HttpResponse.BodyHandlers.ofInputStream())
                                .thenApplyAsync(HttpResponse::body)
                                .join();
                    }
                } else {
                    return client.sendAsync(request(requestUrl, token)
                            .POST(HttpRequest.BodyPublishers.ofInputStream(() -> contentStream))
                            .header("Accept", contentType)
                            .build(), HttpResponse.BodyHandlers.ofInputStream())
                            .thenApplyAsync(HttpResponse::body)
                            .join();
                }
            }

            return null;
        }

        /**
         * Sends a POST request to REST API with basic authentication.
         *
         * @param requestMethod Type of request method - get, post, put, delete and patch. {@link RequestMethod}.
         * @param requestUrl    pass the request url.
         * @param token         pass the personal access token.
         * @param contentType   Type of content to send and accept from API.
         * @param contentStream Request body as stream for post request.
         * @param customHeaders custom headers to send with the post request.
         * @return Input stream response from the API as CompletableFuture object.
         */
        @Deprecated public static CompletableFuture<HttpResponse<InputStream>> response(RequestMethod requestMethod, String requestUrl,
                                                                            String token, String contentType, InputStream contentStream,
                                                                            Map<String, String> customHeaders) {

            var client = getClient(false);

            // TODO: Add handlers for PUT, PATCH and DELETE methods.
            if (requestMethod.name().equals("GET"))
                return client.sendAsync(request(requestUrl, token).GET().header("Accept", contentType).build(),
                        HttpResponse.BodyHandlers.ofInputStream());

            if (requestMethod.name().equals("POST")) {
                // custom header can be content type, content length etc.
                if (customHeaders != null) {
                    for (var key : customHeaders.keySet()) {
                        return client.sendAsync(request(requestUrl, token)
                                .POST(HttpRequest.BodyPublishers.ofInputStream(() -> contentStream))
                                .header("Accept", contentType)
                                .header(key, customHeaders.get(key))
                                .build(), HttpResponse.BodyHandlers.ofInputStream());
                    }
                } else {
                    return client.sendAsync(request(requestUrl, token)
                            .POST(HttpRequest.BodyPublishers.ofInputStream(() -> contentStream))
                            .header("Accept", contentType)
                            .build(), HttpResponse.BodyHandlers.ofInputStream());
                }
            }
            return null;
        }

        /**
         * Return HttpClient object
         *
         * @param redirect If true adds redirect policy
         * @return HttpClient object
         */
        @Deprecated private static HttpClient getClient(boolean redirect) {
            var client = HttpClient.newBuilder();

            if (redirect) {
                return client.followRedirects(REDIRECT_POLICY).build();
            }
            return client.build();
        }
    }
}
