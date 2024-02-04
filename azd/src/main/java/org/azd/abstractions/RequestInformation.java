package org.azd.abstractions;

import org.azd.abstractions.internals.LocationService;
import org.azd.authentication.AccessTokenCredential;
import org.azd.common.Constants;
import org.azd.common.types.ApiLocation;
import org.azd.enums.RequestMethod;
import org.azd.utils.UrlBuilder;

import java.io.InputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RequestInformation {
    public RequestMethod requestMethod = RequestMethod.GET;
    public AccessTokenCredential accessTokenCredential;
    public String project;
    public String area;
    public String locationId;
    public Map<String, Object> pathParameters = new HashMap<>();
    public String apiVersion;
    public RequestHeaders requestHeaders = new RequestHeaders();
    public Object requestBody;
    public InputStream inputStream;
    private String baseInstance;
    private String requestUrl;
    private Map<String, Object> queryParameters = new HashMap<>();

    public RequestInformation() {
    }

    public void setBaseInstance(final String baseInstance) {
        if (baseInstance != null) this.baseInstance = baseInstance;
    }

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
                            queryParameters.put(name, value.toString().toLowerCase().replaceAll("_", ""));
                        }
                        else if (value.getClass().isArray()) {
                            queryParameters.put(name, Arrays.asList((Object[]) value));
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

    public void setQueryParameter(String name, Object value) {
        if (name != null || value != null) {
            if (queryParameters.containsKey(name)) queryParameters.replace(name, value);
            else queryParameters.put(name, value);
        }
    }

    public void setQueryParameters(Map<String, Object> queryParameters) {
        if (queryParameters != null) {
            if (!queryParameters.isEmpty()) this.queryParameters = queryParameters;
        }
    }

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

    public void setRequestUrl(final String requestUrl) {
        if (requestUrl != null) this.requestUrl = requestUrl;
    }

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

    private ApiLocation getLocation() {
        if (area != null || locationId != null)
            return LocationService.getInstance(accessTokenCredential).getLocation(baseInstance, area, locationId);
        return null;
    }

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
