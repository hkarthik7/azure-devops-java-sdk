package org.azd.abstractions.internals;

import org.azd.abstractions.RequestHeaders;
import org.azd.abstractions.RequestInformation;
import org.azd.authentication.AccessTokenCredential;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.http.ClientRequest;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ClientRequestBuilder implements ClientRequest.Builder {
    private final AccessTokenCredential accessTokenCredential;
    private final Map<String, Object> pathParameters;
    private RequestInformation reqInfo;

    public ClientRequestBuilder() {
        this(null);
    }

    public ClientRequestBuilder(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
        this.pathParameters = new HashMap<>();
        this.reqInfo = new RequestInformation();
        if (accessTokenCredential != null) {
            this.reqInfo.accessTokenCredential = accessTokenCredential;
            this.reqInfo.project = accessTokenCredential.getProjectName();
        }
    }

    @Override
    public ClientRequest.Builder baseInstance(String baseInstance) {
        reqInfo.setBaseInstance(Objects.requireNonNull(baseInstance, "Base instance cannot be null"));
        return this;
    }

    @Override
    public ClientRequest.Builder area(String area) {
        reqInfo.area = Objects.requireNonNull(area, "Area cannot be null.");
        return this;
    }

    @Override
    public ClientRequest.Builder location(String locationId) {
        reqInfo.locationId = Objects.requireNonNull(locationId, "Location id cannot be null.");
        return this;
    }

    @Override
    public ClientRequest.Builder apiVersion(String apiVersion) {
        reqInfo.apiVersion = apiVersion;
        return this;
    }

    @Override
    public ClientRequest.Builder GET() {
        reqInfo.requestMethod = RequestMethod.GET;
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    @Override
    public ClientRequest.Builder POST(Object requestBody) {
        reqInfo.requestMethod = RequestMethod.POST;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder PATCH(Object requestBody) {
        reqInfo.requestMethod = RequestMethod.PATCH;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder PUT(Object requestBody) {
        reqInfo.requestMethod = RequestMethod.PUT;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder DELETE() {
        reqInfo.requestMethod = RequestMethod.DELETE;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder OPTIONS() {
        reqInfo.requestMethod = RequestMethod.OPTIONS;
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    @Override
    public ClientRequest.Builder HEAD() {
        reqInfo.requestMethod = RequestMethod.HEAD;
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    @Override
    public ClientRequest.Builder URI(String url) {
        Objects.requireNonNull(url, "Request url cannot be null.");
        reqInfo.setRequestUrl(url);
        return this;
    }

    @Override
    public ClientRequest.Builder URI(URI uri) {
        Objects.requireNonNull(uri, "Request url cannot be null.");
        reqInfo.setRequestUrl(uri.toString());
        return this;
    }

    @Override
    public ClientRequest.Builder serviceEndpoint(String key, Object value) {
        Objects.requireNonNull(key);
        if (pathParameters.containsKey(key)) pathParameters.replace(key, value);
        else pathParameters.put(key, value);
        return this;
    }

    @Override
    public ClientRequest.Builder query(String name, Object value) {
        reqInfo.setQueryParameter(name, value);
        return this;
    }

    @Override
    public <T> ClientRequest.Builder query(Supplier<T> config, Consumer<T> requestConfig, Function<T, Object> func) {
        if (requestConfig != null) {
            T item = config.get();
            requestConfig.accept(item);
            reqInfo.setQueryParameters(func.apply(item));
        }
        return this;
    }

    @Override
    public ClientRequest.Builder header(CustomHeader customHeader) {
        reqInfo.requestHeaders.add(customHeader);
        return this;
    }

    @Override
    public ClientRequest.Builder headers(RequestHeaders requestHeaders) {
        reqInfo.requestHeaders.add(requestHeaders);
        return null;
    }

    @Override
    public ClientRequest.Builder request(RequestInformation requestInfo) {
        reqInfo = requestInfo;
        return this;
    }

    @Override
    public RequestInformation request() {
        return reqInfo;
    }

    @Override
    public AccessTokenCredential accessTokenCredential() {
        return accessTokenCredential;
    }

    @Override
    public ClientRequest build() {
        reqInfo.pathParameters = pathParameters;
        return new ClientRequestAdapter(this);
    }
}
