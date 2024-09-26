package org.azd.abstractions.internals;

import org.azd.abstractions.RequestHeaders;
import org.azd.abstractions.RequestInformation;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.http.ClientRequest;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Client request builder implementation to build the request.
 */
public class ClientRequestBuilder implements ClientRequest.Builder {
    /**
     * Represents the access token credential object.
     */
    private final AccessTokenCredential accessTokenCredential;
    /**
     * Path parameters to construct the URL.
     */
    private final Map<String, Object> pathParameters;
    /**
     * Request information object.
     */
    private RequestInformation reqInfo;

    /**
     * Default.
     */
    public ClientRequestBuilder() {
        this(null);
    }

    /**
     * Default with access token credential.
     * @param accessTokenCredential AccessTokenCredential {@link AccessTokenCredential}
     */
    public ClientRequestBuilder(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
        this.pathParameters = new HashMap<>();
        this.reqInfo = new RequestInformation();
        if (accessTokenCredential != null) {
            this.reqInfo.accessTokenCredential = accessTokenCredential;
            this.reqInfo.project = accessTokenCredential.getProjectName();
        }
    }

    /**
     * Pass the base url instance. (dev.azure.com/{organisation})
     * @param baseInstance Base instance to set to construct the request url.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder baseInstance(String baseInstance) {
        reqInfo.setBaseInstance(Objects.requireNonNull(baseInstance, "Base instance cannot be null"));
        return this;
    }

    /**
     * Pass the Azure DevOps service area.
     * @param area Pass the value for area. E.g. core or build or git etc.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder area(String area) {
        reqInfo.area = Objects.requireNonNull(area, "Area cannot be null.");
        return this;
    }

    /**
     * Pass the location id.
     * @param locationId Pass the location id for service specific area.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder location(String locationId) {
        reqInfo.locationId = Objects.requireNonNull(locationId, "Location id cannot be null.");
        return this;
    }

    /**
     * Pass the api version.
     * @param apiVersion Api version to set.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder apiVersion(String apiVersion) {
        reqInfo.apiVersion = apiVersion;
        return this;
    }

    /**
     * Represents the GET request and sets the RequestMethod for sending the request.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder GET() {
        reqInfo.requestMethod = RequestMethod.GET;
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    /**
     * Represents the POST request and sets the RequestMethod for sending the request.
     * @param requestBody Pass the request body.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder POST(Object requestBody) {
        reqInfo.requestMethod = RequestMethod.POST;
        setRequestBody(requestBody);
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    /**
     * Represents the PATCH request and sets the RequestMethod for sending the request.
     * @param requestBody Pass the request body.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder PATCH(Object requestBody) {
        reqInfo.requestMethod = RequestMethod.PATCH;
        setRequestBody(requestBody);
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    /**
     * Represents the PUT request and sets the RequestMethod for sending the request.
     * @param requestBody Pass the request body.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder PUT(Object requestBody) {
        reqInfo.requestMethod = RequestMethod.PUT;
        setRequestBody(requestBody);
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    /**
     * Represents the DELETE request and sets the RequestMethod for sending the request.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder DELETE() {
        reqInfo.requestMethod = RequestMethod.DELETE;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    /**
     * Represents the OPTIONS request and sets the RequestMethod for sending the request.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder OPTIONS() {
        reqInfo.requestMethod = RequestMethod.OPTIONS;
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    /**
     * Represents the HEAD request and sets the RequestMethod for sending the request.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder HEAD() {
        reqInfo.requestMethod = RequestMethod.HEAD;
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    /**
     * Pass the complete request url.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder URI(String url) {
        Objects.requireNonNull(url, "Request url cannot be null.");
        reqInfo.setRequestUrl(url);
        return this;
    }

    /**
     * Pass the complete request url.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder URI(URI uri) {
        Objects.requireNonNull(uri, "Request url cannot be null.");
        reqInfo.setRequestUrl(uri.toString());
        return this;
    }

    /**
     * Pass the service endpoint to append the URL with.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder serviceEndpoint(String key, Object value) {
        Objects.requireNonNull(key);
        if (pathParameters.containsKey(key)) pathParameters.replace(key, value);
        else pathParameters.put(key, value);
        return this;
    }

    /**
     * Pass the query parameters
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder query(String name, Object value) {
        reqInfo.setQueryParameter(name, value);
        return this;
    }

    /**
     * Supply the values to set the query parameters.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public <T> ClientRequest.Builder query(Supplier<T> config, Consumer<T> requestConfig, Function<T, Object> func) {
        if (requestConfig != null) {
            T item = config.get();
            requestConfig.accept(item);
            reqInfo.setQueryParameters(func.apply(item));
        }
        return this;
    }

    /**
     * Set the request header.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder header(CustomHeader customHeader) {
        reqInfo.requestHeaders.add(customHeader);
        return this;
    }

    /**
     * Set the request headers.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder headers(RequestHeaders requestHeaders) {
        reqInfo.requestHeaders.add(requestHeaders);
        return this;
    }

    /**
     * Set the complete request information.
     * @return Client request builder object {@link ClientRequest.Builder}
     */
    @Override
    public ClientRequest.Builder request(RequestInformation requestInfo) {
        reqInfo = requestInfo;
        return this;
    }

    /**
     * Get the request information.
     * @return Request information object {@link RequestInformation}
     */
    @Override
    public RequestInformation request() {
        reqInfo.pathParameters = pathParameters;
        return reqInfo;
    }

    /**
     * Get the access token credential object.
     * @return AccessTokenCredential {@link AccessTokenCredential}
     */
    @Override
    public AccessTokenCredential accessTokenCredential() {
        return accessTokenCredential;
    }

    /**
     * Constructs and the client request object.
     * @return ClientRequest {@link ClientRequest}
     */
    @Override
    public ClientRequest build() {
        reqInfo.pathParameters = pathParameters;
        return new ClientRequestAdapter(this);
    }

    /**
     * Helper method to identify and set the request body.
     * @param requestBody Request body to set.
     */
    private void setRequestBody(Object requestBody) {
        if (requestBody != null) {
            if (requestBody instanceof InputStream)
                reqInfo.inputStream = (InputStream) requestBody;
            else if (requestBody instanceof  HttpRequest.BodyPublisher)
                reqInfo.body = (HttpRequest.BodyPublisher) requestBody;
            else reqInfo.requestBody = requestBody;
        }
    }
}
