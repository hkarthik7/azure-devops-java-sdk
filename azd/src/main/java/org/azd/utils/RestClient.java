package org.azd.utils;

import org.azd.connection.Connection;
import org.azd.enums.ApiExceptionTypes;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;

import java.io.InputStream;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static org.azd.utils.RestClientProvider.buildRequestUrl;

/**
 * RestClient to call Azure DevOps REST API.
 */
public abstract class RestClient {

    /**
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     *
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection    name of the organization
     * @param resourceId    pass the resource id.
     * @param project       name of the project
     * @param area          resource area
     * @param id            resource id
     * @param resource      resource area endpoint
     * @param apiVersion    api version
     * @param queryString   query string to append the url
     * @param requestBody   Api payload for post, patch and put methods
     * @param contentType   Type of content to request and accept as; Default is "Accept", "application/json"
     * @return String response from Api
     * @throws AzDException Default Api exception handler
     */
    public static String send(
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map queryString,
            Object requestBody,
            CustomHeader contentType) throws AzDException {
        String requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (contentType == null) contentType = CustomHeader.JSON;

        return RestClientProvider.response(requestMethod, requestUrl, connection.getPersonalAccessToken(),
                HttpRequest.BodyPublishers.ofString(RestClientProvider.MAPPER.convertToString(requestBody)),
                HttpResponse.BodyHandlers.ofString(),
                contentType, false)
                .thenApplyAsync(HttpResponse::body)
                .join();
    }

    /**
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     *
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection    name of the organization
     * @param resourceId    pass the resource id.
     * @param project       name of the project
     * @param area          resource area
     * @param id            resource id
     * @param resource      resource area endpoint
     * @param apiVersion    api version
     * @param queryString   query string to append the url
     * @param contentStream API payload as stream
     * @param contentType   Type of content to request and accept as; Default is "Content-Type", "application/octet-stream"
     * @param callback      If true default redirect policy will be applied. The redirect policy can be controlled
     * in BaseRestClient class.
     * @return InputStream from API
     * @throws AzDException Default Api exception handler
     */
    public static InputStream send(
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map queryString,
            InputStream contentStream,
            CustomHeader contentType,
            boolean callback) throws AzDException {
        String requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (contentType == null) contentType = CustomHeader.STREAM;

        return RestClientProvider.response(requestMethod, requestUrl, connection.getPersonalAccessToken(),
                HttpRequest.BodyPublishers.ofInputStream(() -> contentStream),
                HttpResponse.BodyHandlers.ofInputStream(), contentType, callback)
                .thenApplyAsync(HttpResponse::body)
                .join();
    }

    /**
     * Mediator for BaseRestClient and other Api implementations.
     *
     * @param requestUrl    Pass the request url if any. Note that if the url is passed only this will be considered for Api call.
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection    name of the organization
     * @param resourceId    pass the resource id.
     * @param project       name of the project
     * @param area          resource area
     * @param id            resource id
     * @param resource      resource area endpoint
     * @param apiVersion    api version
     * @param queryString   query string to append the url
     * @param contentStream API payload as stream
     * @param contentType   Type of content to request and accept as; Default is "Content-Type", "application/octet-stream"
     * @param callback      If true default redirect policy will be applied. The redirect policy can be controlled
     * @return A Future of Http response stream.
     * @throws AzDException Default Api exception handler.
     */
    public static CompletableFuture<HttpResponse<InputStream>> send(
            String requestUrl,
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map queryString,
            InputStream contentStream,
            CustomHeader contentType,
            boolean callback) throws AzDException {
        if (requestUrl == null)
            requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (contentType == null) contentType = CustomHeader.STREAM;

        if (connection != null)
            return RestClientProvider.response(requestMethod, requestUrl, connection.getPersonalAccessToken(),
                    HttpRequest.BodyPublishers.ofInputStream(() -> contentStream),
                    HttpResponse.BodyHandlers.ofInputStream(), contentType, callback);

        return RestClientProvider.response(requestMethod, requestUrl, null,
                HttpRequest.BodyPublishers.ofInputStream(() -> contentStream),
                HttpResponse.BodyHandlers.ofInputStream(), contentType, callback);
    }

    /**
     * Mediator for BaseRestClient and other Api implementations.
     *
     * @param requestUrl    Pass the request url if any. Note that if the url is passed only this will be considered for Api call.
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param requestBody   API payload
     * @param contentType   Type of content to request and accept as; Default is "Accept", "application/json"
     * @param callback      If true default redirect policy will be applied. The redirect policy can be controlled
     * @return String response from Api
     * @throws AzDException Default Api exception handler
     */
    public static String send(
            String requestUrl,
            RequestMethod requestMethod,
            Object requestBody,
            CustomHeader contentType,
            boolean callback) throws AzDException {
        if (contentType == null) contentType = CustomHeader.JSON;

        return RestClientProvider.response(requestMethod, requestUrl, null,
                HttpRequest.BodyPublishers.ofString(RestClientProvider.MAPPER.convertToString(requestBody)),
                HttpResponse.BodyHandlers.ofString(), contentType, callback)
                .thenApplyAsync(HttpResponse::body)
                .join();
    }

    /**
     * Helper method and a mediator for calling Azure DevOps REST Api.
     *
     * @param requestUrl    Pass the request url if any. Note that if the url is passed only this will be considered for Api call.
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection    name of the organization
     * @param resourceId    pass the resource id.
     * @param project       name of the project
     * @param area          resource area
     * @param id            resource id
     * @param resource      resource area endpoint
     * @param apiVersion    api version
     * @param queryString   query string to append the url
     * @param publisher     HttpRequest body publisher type
     * @param handler       HttpResponse body type
     * @param headerMap     Map of request headers.
     * @param callback      If true default redirect policy will be applied
     * @param <T>           Type name that is been returned.
     * @return Generic type can be String or Stream response from Api.
     * @throws AzDException Default Api exception handler.
     */
    public static <T> CompletableFuture<HttpResponse<T>> send(
            String requestUrl,
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map queryString,
            HttpRequest.BodyPublisher publisher,
            HttpResponse.BodyHandler<T> handler,
            Map<String, CustomHeader> headerMap,
            boolean callback) throws AzDException {
        if (requestUrl == null)
            requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (headerMap == null) headerMap = Map.of("Accept", CustomHeader.JSON);

        HttpRequest.Builder builder;

        if (connection != null) {
            builder = RestClientProvider.getBuilder(requestUrl, connection.getPersonalAccessToken());
            for (var key : headerMap.keySet()) {
                // This can only be used when there are no restricted content headers, such as Content-Length.
                builder.header(headerMap.get(key).getName(), headerMap.get(key).getValue());
            }

            if (requestMethod == RequestMethod.GET)
                return RestClientProvider.getResponse(builder.GET().build(), handler, callback);
            if (requestMethod == RequestMethod.POST)
                return RestClientProvider.getResponse(builder.POST(publisher).build(), handler, callback);
            if (requestMethod == RequestMethod.PATCH)
                return RestClientProvider.getResponse(builder.method(RequestMethod.PATCH.name(), publisher).build(), handler, callback);
            if (requestMethod == RequestMethod.PUT)
                return RestClientProvider.getResponse(builder.PUT(publisher).build(), handler, callback);
            if (requestMethod == RequestMethod.DELETE)
                return RestClientProvider.getResponse(builder.DELETE().build(), handler, callback);
        }

        throw new AzDException(ApiExceptionTypes.InvalidArgumentException.name(), "Connection object cannot be null.");
    }
}
