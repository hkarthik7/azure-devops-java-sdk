package org.azd.utils;

import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

/**
 *  Implements HttpRequest request methods to send GET, POST, PATCH and DELETE request
 *  to Azure DevOps REST API.
 *  @author Harish Karthic
 */
public abstract class BaseClient {

    private static final String AUTHORIZATION = "Authorization";
    private static final JsonMapper MAPPER = new JsonMapper();
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    /**
     *  Encodes the personal access token to base 64
     * @param token pass the personal access token
     * @return Encoded string of personal access token for basic authentication
     */
    private static String encodePersonalAccessToken(String token) {
        return "Basic " +
                Base64.getEncoder().encodeToString(("" + ":" + token).getBytes());
    }

    /***
     * Http request builder
     * @param requestUrl request url
     * @param token personal access token
     * @return HttpRequest object to build
     */
    private static HttpRequest.Builder request(String requestUrl, String token) {
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
    private static HttpRequest.Builder request(String requestUrl) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(requestUrl));
    }

    /***
     * Response from API for the given request
     * @param r pass the Http request object
     * @return String response from API
     */
    private static String response(HttpRequest r) {
        return CLIENT.sendAsync(r, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .join();
    }

    /**
     *  Sends a GET request to REST API
     * @param requestUrl pass the request url
     * @return response string from the API
     */
    public static String get(String requestUrl) {
        return response(request(requestUrl).GET().header("Accept", "application/json").build());
    }

    /**
     *  Sends a GET request to REST API with basic authentication
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @return response string from the API
     */
    public static String get(String requestUrl, String token) {
        return response(request(requestUrl, token).GET().header("Accept", "application/json").build());
    }

    /**
     *  Sends a GET request to REST API with basic authentication
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param contentType specify the content type
     * @return response string from the API
     */
    public static String get(String requestUrl, String token, String contentType) {
        return response(request(requestUrl, token).GET().header("Accept", contentType).build());
    }

    /**
     *  Sends a POST request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to post the request
     * @throws AzDException throws IO exception
     * @return response string from the API if any
     */
    public static String post(String requestUrl, String token, HashMap<String, Object> body) throws AzDException {
        return response(
                request(requestUrl, token)
                    .POST(HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                    .header("Content-Type", "application/json")
                    .build());
    }

    /**
     *  Sends a POST request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to post the request (accepts an array of object)
     * @throws AzDException throws IO exception
     * @return response string from the API if any
     */
    public static String post(String requestUrl, String token, List<Object> body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .POST(HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json-patch+json")
                        .build());
    }

    /**
     *  Sends a PATCH request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to update the request
     * @throws AzDException throws IO exception
     * @return response string from the API if any
     */
    public static String patch(String requestUrl, String token, HashMap<String, Object> body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json")
                        .build());
    }

    /**
     *  Sends a PATCH request to REST API with basic authentication and request body
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @param body pass the request body to update the request
     * @throws AzDException throws IO exception
     * @return response string from the API if any
     */
    public static String patch(String requestUrl, String token, List<Object> body) throws AzDException {
        return response(
                request(requestUrl, token)
                        .method(RequestMethod.PATCH.toString(), HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(body)))
                        .header("Content-Type", "application/json")
                        .build());
    }

    /**
     *  Sends a DELETE request to REST API with basic authentication
     * @param requestUrl pass the request url
     * @param token pass the personal access token
     * @return response string from the API if any
     */
    public static String delete(String requestUrl, String token) {
        return response(request(requestUrl, token).DELETE().build());
    }
}
