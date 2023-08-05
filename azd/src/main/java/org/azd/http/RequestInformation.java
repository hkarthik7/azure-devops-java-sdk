package org.azd.http;

import org.azd.common.types.QueryParameter;
import org.azd.enums.RequestMethod;
import org.azd.utils.AzDDefaultRegisterFactory;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RequestInformation {
    public RequestMethod requestMethod = RequestMethod.GET;
    public String project;
    public String serviceEndpoint;
    public String apiVersion;
    public RequestHeaders requestHeaders = new RequestHeaders();
    public Object requestBody;
    public InputStream inputStream;

    public void setQueryParameters(Object parameters) {
        if (parameters == null) return;
        var fields = parameters.getClass().getFields();
        for(var field : fields) {
            try {
                final Object value = field.get(parameters);
                var name = field.getName();
                if (field.isAnnotationPresent(QueryParameter.class)) {
                    var annotationName = field.getAnnotation(QueryParameter.class).name();
                    if(annotationName != null && !annotationName.isEmpty()) {
                        name = annotationName;
                    }
                }
                if(value != null) {
                    if(value.getClass().isArray()) {
                        queryParameters.put(name, Arrays.asList((Object[])value));
                    } else if(!value.toString().isEmpty()){
                        queryParameters.put(name, value);
                    }
                }
            } catch (Exception ignored) { }
        }
    }

    public void setQueryParameter(String name, Object value) {
        Objects.requireNonNull(name);
        queryParameters.put(name, value);
    }

    public String getRequestUrl() {
        if (requestUrl != null) return requestUrl;
        var url = new StringBuilder(baseInstance.replaceAll("/$", ""));
        if (project != null) url.append("/").append(project);
        url.append("/_apis");
        if (serviceEndpoint != null) {
            serviceEndpoint = serviceEndpoint.replaceFirst("/$", "").replaceAll("/$", "");
        }
        url.append("/").append(serviceEndpoint).append("?api-version=").append(apiVersion);
        if (!queryParameters.isEmpty()) {
            for (var key : queryParameters.keySet()) {
                url.append(getQueryString(key, queryParameters.get(key)));
            }
        }
        return url.toString();
    }

    public void setRequestUrl(final String requestUrl) {
        Objects.requireNonNull(requestUrl, "Request url cannot be null or empty");
        this.requestUrl = requestUrl;
    }

    public RequestInformation() {}

    /**
     * Creates a query string from given key and value
     *
     * @param key   pass the key of the HashMap
     * @param value pass the value of the HasMap
     * @return query string
     */
    private static String getQueryString(String key, Object value) {
        return "&" + key + "=" + value;
    }
    private final String baseInstance = AzDDefaultRegisterFactory.getBaseInstance();
    private String requestUrl;
    private final Map<String, Object> queryParameters = new HashMap<>();
}
