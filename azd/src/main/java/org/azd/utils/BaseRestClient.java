package org.azd.utils;

import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;

/**
 * BaseRestClient that encapsulates the logic for managing request and response for REST API.
 */
public abstract class BaseRestClient {
    private static final String AUTHORIZATION = "Authorization";
    private static HttpClient.Redirect REDIRECT_POLICY = HttpClient.Redirect.NORMAL;
    private static final HttpClient CLIENT = HttpClient.newBuilder().followRedirects(REDIRECT_POLICY).build();
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();

    /**
     * Encodes the personal access token to base 64
     *
     * @param token pass the personal access token
     * @return Encoded string of personal access token for basic authentication
     */
    private static String encodePersonalAccessToken(String token) {
        return "Basic " +
                Base64.getEncoder().encodeToString(("" + ":" + token).getBytes());
    }

    /***
     * Http request builder
     *
     * @param requestUrl request url
     * @param token personal access token
     * @return HttpRequest object to build
     */
    private static HttpRequest.Builder build(String requestUrl, String token) {
        if (token == null)
            return HttpRequest
                    .newBuilder()
                    .uri(URI.create(requestUrl));

        return HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl))
                .setHeader(AUTHORIZATION, encodePersonalAccessToken(token));
    }

    /***
     * Response from API for the given request
     * @param r pass the Http request object
     * @param handler HttpResponse body handler
     * @param callback If true client will be built with redirect policy
     * @return String response from API
     */
    private static <T> CompletableFuture<HttpResponse<T>> request(HttpRequest r, HttpResponse.BodyHandler<T> handler,
                                                                  boolean callback) {
        if (callback)  return CLIENT.sendAsync(r, handler);
        return HTTP_CLIENT.sendAsync(r, handler);
    }

    /**
     * Get the current redirect policy.
     *
     * @return HttpClient.Redirect policy.
     */
    public static HttpClient.Redirect getRedirectPolicy() {
        return REDIRECT_POLICY;
    }

    /**
     * Set the current redirect policy.
     *
     * @param redirectPolicy HttpClient.Redirect policy.
     */
    public static void setRedirectPolicy(HttpClient.Redirect redirectPolicy) {
        REDIRECT_POLICY = redirectPolicy;
    }

    /**
     * Sends a GET request to REST API with basic authentication
     *
     * @param requestUrl  pass the request url
     * @param token       pass the personal access token
     * @param handler HttpResponse body handler
     * @param contentType specify the content type
     * @param callback If true client will be built with redirect policy
     * @return response string from the API
     */
    public static <T> CompletableFuture<HttpResponse<T>> get(String requestUrl, String token, HttpResponse.BodyHandler<T> handler,
                                                         CustomHeader contentType, boolean callback) {
        return request(build(requestUrl, token).GET().header(contentType.getName(), contentType.getValue()).build(),
                handler, callback);
    }

    /***
     * Sends a POST request to REST API with oauth authentication, content length of the request and request body
     *
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param publisher BodyPublisher with request body
     * @param handler HttpResponse body handlers
     * @param contentType Content type for setting headers
     * @param callback If true client will be built with redirect policy
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    public static <T> CompletableFuture<HttpResponse<T>> post(String requestUrl, String token, HttpRequest.BodyPublisher publisher,
                                                              HttpResponse.BodyHandler<T> handler, CustomHeader contentType,
                                                              boolean callback) throws AzDException {
        return request(
                build(requestUrl, token)
                        .POST(publisher)
                        .header(contentType.getName(), contentType.getValue())
                        .build(), handler, callback);
    }

    /**
     * Sends a PATCH request to REST API with basic authentication and request body
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @param publisher BodyPublisher with request body
     * @param handler HttpResponse body handlers
     * @param contentType Content type for setting headers
     * @param callback If true client will be built with redirect policy
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    public static <T> CompletableFuture<HttpResponse<T>> patch(String requestUrl, String token, HttpRequest.BodyPublisher publisher,
                               HttpResponse.BodyHandler<T> handler, CustomHeader contentType,
                               boolean callback) throws AzDException {
        return request(
                build(requestUrl, token)
                        .method(RequestMethod.PATCH.name(), publisher)
                        .header(contentType.getName(), contentType.getValue())
                        .build(), handler, callback);
    }

    /***
     * Sends a PUT request to REST API with basic authentication and request body
     *
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param publisher BodyPublisher with request body
     * @param handler HttpResponse body handlers
     * @param contentType Content type for setting headers
     * @param callback If true client will be built with redirect policy
     * @return response string from the API if any
     * @throws AzDException throws user friendly error message with error code from API
     */
    public static <T> CompletableFuture<HttpResponse<T>> put(String requestUrl, String token, HttpRequest.BodyPublisher publisher,
                             HttpResponse.BodyHandler<T> handler, CustomHeader contentType,
                             boolean callback) throws AzDException {
        return request(
                build(requestUrl, token)
                        .PUT(publisher)
                        .header(contentType.getName(), contentType.getValue())
                        .build(), handler, callback);
    }

    /**
     * Sends a DELETE request to REST API with basic authentication
     *
     * @param requestUrl pass the request url
     * @param token      pass the personal access token
     * @return response string from the API if any
     */
    public static <T> CompletableFuture<HttpResponse<T>> delete(String requestUrl, String token, HttpResponse.BodyHandler<T> handler) {
        return request(build(requestUrl, token).DELETE().build(), handler, false);
    }

    /**
     * Manages the request method and response from REST API.
     *
     * @param requestMethod Type of request to send. Such as GET, POST, PUT, PATCH and DELETE.
     * @param requestUrl    Request url to call the Api.
     * @param token         Personal access token.
     * @param publisher     HttpRequest body publisher type
     * @param handler       HttpResponse body type
     * @param contentType   Custom headers for sending the request
     * @param callback      If true default redirect policy will be applied
     * @return Completable future object.
     * @throws AzDException Default Api exception handler.
     */
    public static <T> CompletableFuture<HttpResponse<T>> response(RequestMethod requestMethod, String requestUrl,
                                                                   String token, HttpRequest.BodyPublisher publisher,
                                                                  HttpResponse.BodyHandler<T> handler,
                                                                  CustomHeader contentType,
                                                                   boolean callback) throws AzDException {
        if (contentType == null) contentType = CustomHeader.JSON;

        if (requestMethod == RequestMethod.GET)
            return get(requestUrl, token, handler, contentType, callback);

        if (requestMethod == RequestMethod.POST)
            return post(requestUrl, token, publisher, handler, contentType, callback);

        if (requestMethod == RequestMethod.PATCH)
            return patch(requestUrl, token, publisher, handler, contentType, callback);

        if (requestMethod == RequestMethod.PUT)
            return put(requestUrl, token, publisher, handler, contentType, callback);

        if (requestMethod == RequestMethod.DELETE)
            return delete(requestUrl, token, handler);

        return null;
    }

    /**
     * Helper method to create the request with request url and access token.
     *
     * @param requestUrl Pass the request url.
     * @param token Pass the access token. Base64 encoding will be taken care when building the request.
     * @return HttpRequest builder object.
     */
    protected static HttpRequest.Builder getBuilder(String requestUrl, String token) {
        return build(requestUrl, token);
    }

    /**
     * Helper method to get the response based on built http request.
     *
     * @param r Http request object.
     * @param handler Handlers for accepting the response content as. Example string or input stream etc.
     * @param callback If true follows redirects.
     * @param <T> Generic response type object.
     * @return generic type of future of http response.
     */
    protected static <T> CompletableFuture<HttpResponse<T>> getResponse(HttpRequest r, HttpResponse.BodyHandler<T> handler,
                                                                 boolean callback) {
        if (callback)  return CLIENT.sendAsync(r, handler);
        return HTTP_CLIENT.sendAsync(r, handler);
    }

}
