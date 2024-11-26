package org.azd.abstractions;

import org.azd.abstractions.internals.LocationService;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.Constants;
import org.azd.common.types.ApiLocation;
import org.azd.enums.RequestMethod;
import org.azd.helpers.Utils;
import org.azd.utils.UrlBuilder;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Internal class to construct the request parameters to call Azure DevOps API.
 */
public class RequestInformation {
    /**
     * Represents the Http Request method. {@link RequestMethod}
     */
    public RequestMethod requestMethod = RequestMethod.GET;
    /**
     * Pass the {@link AccessTokenCredential} for authentication.
     */
    public AccessTokenCredential accessTokenCredential;
    /**
     * (Optional) Pass the project name.
     */
    public String project;
    /**
     * Area represents the Azure DevOps service such as work item tracking, Git, etc.
     */
    public String area;
    /**
     * The unique location id to identify the details of the API.
     */
    public String locationId;
    /**
     * Path parameters of the URL.
     */
    public Map<String, Object> pathParameters = new HashMap<>();
    /**
     * This is mandatory. Respective API version.
     */
    public String apiVersion;
    /**
     * Represents the request headers to be passed with the request.
     */
    public RequestHeaders requestHeaders = new RequestHeaders();
    /**
     * Request body.
     */
    public Object requestBody;
    /**
     * Represents the request body.
     */
    public InputStream inputStream;
    /**
     * Required to construct the client request to call the API.
     */
    public HttpRequest.BodyPublisher body;
    /**
     * Represents the base url instance (e.g., dev.azure.com).
     */
    private String baseInstance;
    /**
     * The completely constructed request url.
     */
    private String requestUrl;
    /**
     * Represents the query parameters.
     */
    private Map<String, Object> queryParameters = new HashMap<>();

    /**
     * Default.
     */
    public RequestInformation() {
    }

    /**
     * Sets the base url.
     * @param baseInstance Pass the base instance. e.g., dev.azure.com.
     */
    public void setBaseInstance(final String baseInstance) {
        if (baseInstance != null) this.baseInstance = baseInstance;
    }

    /**
     * Sets the query parameters.
     * @param parameters Query parameters.
     */
    public void setQueryParameters(Object parameters) {
        if (parameters != null) {
            var fields = parameters.getClass().getFields();
            for (var field : fields) {
                try {
                    final Object value = field.get(parameters);
                    var name = field.getName();
                    if (field.isAnnotationPresent(QueryParameter.class)) {
                        var annotationName = field.getAnnotation(QueryParameter.class).name();
                        if (annotationName != null && !annotationName.isEmpty()) {
                            name = annotationName;
                        }
                    }
                    if (value != null) {
                        if (value.getClass().isEnum()) {
                            queryParameters.put(name,
                                    value.toString().toLowerCase().replaceAll("_", ""));
                        }
                        else if (value.getClass().isArray()) {
                            queryParameters.put(name, Utils.toString((Object[]) value));
                        } else if (!value.toString().isEmpty()) {
                            queryParameters.put(name, value.toString());
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Sets the query parameters.
     * @param name Name or key of the parameter.
     * @param value Value for the Name or key.
     */
    public void setQueryParameter(String name, Object value) {
        if (name != null || value != null) {
            if (queryParameters.containsKey(name)) queryParameters.replace(name, value);
            else queryParameters.put(name, value);
        }
    }

    /**
     * Sets the query parameters from given map.
     * @param queryParameters Map of query parameters.
     */
    public void setQueryParameters(Map<String, Object> queryParameters) {
        if (queryParameters != null) {
            if (!queryParameters.isEmpty()) this.queryParameters = queryParameters;
        }
    }

    /**
     * Returns the fully constructed request URL.
     * @return Request URI. {@link URI}
     */
    public URI getRequestUri() {
        if (requestUrl != null) return URI.create(requestUrl);
        if (baseInstance != null) {
            var reqUrl = UrlBuilder.fromBaseUrl(baseInstance)
                    .appendPath(replacePathParameters())
                    .appendQueryString(Constants.API_VERSION, getApiVersion());
            if (!queryParameters.isEmpty())
                for (var key : queryParameters.keySet())
                    reqUrl.appendQueryString(key, String.valueOf(queryParameters.get(key)));
            return reqUrl.build();
        }
        return null;
    }

    /**
     * Sets the request URL.
     * @param requestUrl Request url string to set.
     */
    public void setRequestUrl(final String requestUrl) {
        if (requestUrl != null) this.requestUrl = requestUrl;
    }

    /**
     * Replaces path parameters in the route template and constructs a complete path value.
     * @return Path parameters.
     */
    private String replacePathParameters() {
        // Patten to match route template such as -> "{organization}/{project}/teams/{teamId}"
        var routeTemplate = getRouteTemplate();
        if (routeTemplate != null) {
            var pattern = Pattern.compile("\\{(\\*?[^{}]+)\\}");
            var matcher = pattern.matcher(routeTemplate);

            var result = new StringBuilder();
            while (matcher.find()) {
                String paramName = matcher.group(1);
                paramName = paramName.startsWith("*") ? paramName.replace("*", "") : paramName;
                pathParameters = pathParameters.entrySet().stream()
                        .collect(Collectors.toMap(e -> e.getKey().toLowerCase(), Map.Entry::getValue));
                String replacement = String.valueOf(pathParameters.getOrDefault(paramName.toLowerCase(), ""));
                matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
            }
            matcher.appendTail(result);

            var endpoint = URI.create(result.toString()).toString();
            // Replace trailing / and any additional // within the endpoint.
            return endpoint.replaceAll("^/+", "").replaceAll("/+$", "")
                    .replaceAll("/+", "/");
        }
        return null;
    }

    /**
     * Returns the location object with base URL details.
     * @return ApiLocation object {@link ApiLocation}
     */
    private ApiLocation getLocation() {
        if (area != null || locationId != null)
            return LocationService.getInstance(accessTokenCredential).getLocation(baseInstance, area, locationId);
        return null;
    }

    /**
     * Returns the route template from ApiLocation.
     * @return Route template.
     */
    private String getRouteTemplate() {
        var location = getLocation();
        if (location != null) {
            pathParameters.put("resource", location.resourceName);
            pathParameters.put("area", location.area);
            if (project != null) pathParameters.put("project", project);
            return location.routeTemplate;
        }
        return null;
    }

    /**
     * Helper method to automatically identify the latest version of the API.
     * Use this with caution because not all the APIs return correct version.
     * @return Api version.
     */
    private String getApiVersion() {
        if (apiVersion != null) return apiVersion;
        var apiLocation = getLocation();
        if (apiLocation != null) {
            var releasedVersion = Double.parseDouble(apiLocation.releasedVersion);
            String apiVersion;
            if (releasedVersion == 0.0)
                apiVersion = apiLocation.maxVersion + Constants.PREVIEW_INDICATOR + apiLocation.resourceVersion;
            else apiVersion = apiLocation.releasedVersion + Constants.PREVIEW_INDICATOR + apiLocation.resourceVersion;
            return apiVersion;
        }
        return null;
    }
}
