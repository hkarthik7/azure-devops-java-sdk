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
    private final ServiceEndpointBuilder serviceEndpointBuilder = new ServiceEndpointBuilder(null);
    private final AccessTokenCredential accessTokenCredential;
    private final Map<String, Object> query = new HashMap<>();
    private RequestInformation reqInfo;
    private String apiVersion;
    private Object queryParams;
    private String requestUrl;
    private CustomHeader header;
    private RequestHeaders requestHeaders;
    private RequestInformation requestInfo;

    public ClientRequestBuilder() {
        this(null);
    }

    public ClientRequestBuilder(AccessTokenCredential accessTokenCredential) {
        this.accessTokenCredential = accessTokenCredential;
    }

    @Override
    public ClientRequest.Builder baseInstance(String baseInstance) {
        Objects.requireNonNull(baseInstance, "Base instance cannot be null");
        serviceEndpointBuilder.organizationUrl = baseInstance;
        return this;
    }

    @Override
    public ClientRequest.Builder area(String area) {
        Objects.requireNonNull(area, "Area cannot be null.");
        serviceEndpointBuilder.area = area;
        return this;
    }

    @Override
    public ClientRequest.Builder location(String locationId) {
        Objects.requireNonNull(locationId, "Location id cannot be null.");
        serviceEndpointBuilder.locationId = locationId;
        return this;
    }

    @Override
    public ClientRequest.Builder apiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    @Override
    public ClientRequest.Builder GET() {
        reqInfo = new RequestInformation();
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    @Override
    public ClientRequest.Builder POST(Object requestBody) {
        reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.POST;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder PATCH(Object requestBody) {
        reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.PATCH;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder PUT(Object requestBody) {
        reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.PUT;
        reqInfo.requestBody = requestBody;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder DELETE() {
        reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.DELETE;
        reqInfo.requestHeaders.add(CustomHeader.JSON_CONTENT_TYPE);
        return this;
    }

    @Override
    public ClientRequest.Builder OPTIONS() {
        reqInfo = new RequestInformation();
        reqInfo.requestMethod = RequestMethod.OPTIONS;
        reqInfo.requestHeaders.add(CustomHeader.JSON);
        return this;
    }

    @Override
    public ClientRequest.Builder URI(String url) {
        Objects.requireNonNull(url, "Request url cannot be null.");
        this.requestUrl = url;
        return this;
    }

    @Override
    public ClientRequest.Builder URI(URI uri) {
        Objects.requireNonNull(uri, "Request url cannot be null.");
        this.requestUrl = uri.toString();
        return this;
    }

    @Override
    public ClientRequest.Builder serviceEndpoint(String key, Object value) {
        serviceEndpointBuilder.add(key, value);
        return this;
    }

    @Override
    public ClientRequest.Builder query(String name, Object value) {
        query.put(name, value);
        return this;
    }

    @Override
    public <T> ClientRequest.Builder query(Supplier<T> config, Consumer<T> requestConfig, Function<T, Object> func) {
        if (requestConfig != null) {
            T item = config.get();
            requestConfig.accept(item);
            queryParams = func.apply(item);
        }
        return this;
    }

    @Override
    public ClientRequest.Builder header(CustomHeader customHeader) {
        this.header = customHeader;
        return this;
    }

    @Override
    public ClientRequest.Builder headers(RequestHeaders requestHeaders) {
        this.requestHeaders = requestHeaders;
        return null;
    }

    @Override
    public ClientRequest.Builder request(RequestInformation requestInfo) {
        this.requestInfo = requestInfo;
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
        if (requestInfo != null) reqInfo = requestInfo;
        else {
            if (reqInfo == null) GET();
            reqInfo.setRequestUrl(requestUrl);
            reqInfo.accessTokenCredential = accessTokenCredential;
            reqInfo.baseInstance = serviceEndpointBuilder.organizationUrl;
            reqInfo.area = serviceEndpointBuilder.area;
            reqInfo.locationId = serviceEndpointBuilder.locationId;
            reqInfo.pathParameters = serviceEndpointBuilder.build();
            // This is not mandatory as apiVersion will be automatically selected, however some Api doesn't return the
            // correct api version.
            reqInfo.apiVersion = apiVersion;
            reqInfo.setQueryParameters(query);
            reqInfo.setQueryParameters(queryParams);
            if (accessTokenCredential != null) reqInfo.project = accessTokenCredential.getProjectName();
            reqInfo.requestHeaders.add(header);
            reqInfo.requestHeaders.add(requestHeaders);
        }
        return new ClientRequestAdapter(this);
    }

    private static final class ServiceEndpointBuilder {
        private final Map<String, Object> endpointMap = new HashMap<>();
        private String area;
        private String locationId;
        private String organizationUrl;

        public ServiceEndpointBuilder(String area) {
            this.area = area;
        }

        public void add(String key, Object value) {
            Objects.requireNonNull(key);
            if (endpointMap.containsKey(key)) endpointMap.replace(key, value);
            else endpointMap.put(key, value);
        }

        public Map<String, Object> build() {
            return endpointMap;
        }
    }

}
