package org.azd.utils;

import org.azd.common.types.LocationUrl;
import org.azd.connection.Connection;
import org.azd.enums.ApiExceptionTypes;
import org.azd.enums.Instance;
import org.azd.enums.CustomHeader;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

/**
 * RestClient to call Azure DevOps REST API.
 */
public abstract class RestClient extends BaseRestClient {
    private static final JsonMapper MAPPER = new JsonMapper();
    private static final String API_RELATIVE_PATH = "_apis";
    private static final String API_PREVIEW_INDICATOR = "?api-preview=";
    private static final String API_VERSION_INDICATOR = "?api-version=";

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
     * @param contentType   Type of content to request and accept as
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

        return response(requestMethod, requestUrl, connection.getPersonalAccessToken(),
                HttpRequest.BodyPublishers.ofString(MAPPER.convertToString(requestBody)),
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
     * @param contentType   true to return the request url
     * @param contentStream API payload as stream
     * @param contentType   Type of content to request and accept as
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

        return response(requestMethod, requestUrl, connection.getPersonalAccessToken(),
                HttpRequest.BodyPublishers.ofInputStream(() -> contentStream),
                HttpResponse.BodyHandlers.ofInputStream(), contentType, callback)
                .thenApplyAsync(HttpResponse::body)
                .join();
    }


    /**
     * Gets the resource area url based on resource id passed for the organization
     *
     * @param resourceID       pass the resource id
     * @param organizationName pass the organization name
     * @return resource area url
     * @throws AzDException throws user understandable error message with error code from API
     */
    public static String getLocationUrl(String resourceID, String organizationName) throws AzDException {

        String INSTANCE = Instance.BASE_INSTANCE.getInstance();

        if (resourceID == null) return (INSTANCE + organizationName);

        // Manage Accounts Api when the resource id is accounts. Accounts Api resource id doesn't return the desired location url.
        if (resourceID.equals("accounts")) return Instance.ACCOUNT_INSTANCE.getInstance();

        String url = new StringBuilder().append(INSTANCE)
                .append(organizationName)
                .append("/" + API_RELATIVE_PATH + "/resourceAreas/")
                .append(resourceID)
                .append(API_PREVIEW_INDICATOR)
                .append("5.0-preview.1")
                .toString();

        try {
            var response = response(RequestMethod.GET, url, null, null,
                    HttpResponse.BodyHandlers.ofString(), null, false)
                    .thenApplyAsync(HttpResponse::body)
                    .join();

            String r = MAPPER.mapJsonResponse(response, LocationUrl.class).getLocationUrl();
            return r.replaceAll("/$", "");
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidOrganizationNameException.name(), "Couldn't find the organization name '" + organizationName + "'.");
        }
    }

    /**
     * Builds the request url dynamically for the passed service, resource and area
     *
     * @param organizationName pass the Azure DevOps organization name
     * @param resourceId       pass the resource id
     * @param project          pass the project name
     * @param area             area of the REST API e.g., Release
     * @param id               id of any entity to pass in
     * @param resource         pass the resource entity e.g., Releases
     * @param apiVersion       pass the API version
     * @param queryString      pass the query string to form the url
     * @return resource area url
     * @throws AzDException throws user understandable error message with error code from API
     */
    private static String buildRequestUrl(
            String organizationName,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map<String, Object> queryString) throws AzDException {
        // build the request url to dynamically serve the API requests

        String pathSeparator = "/";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((getLocationUrl(resourceId, organizationName)));

        if (project != null) {
            stringBuilder.append(pathSeparator).append(project);
        }

        stringBuilder.append(pathSeparator + API_RELATIVE_PATH);

        if (area != null) {
            stringBuilder.append(pathSeparator).append(area);
        }
        if (id != null) {
            stringBuilder.append(pathSeparator).append(id);
        }
        if (resource != null) {
            stringBuilder.append(pathSeparator).append(resource);
        }
        stringBuilder.append(API_VERSION_INDICATOR).append(apiVersion);
        if (queryString != null) {
            for (var key : queryString.keySet()) {
                stringBuilder.append(getQueryString(key, queryString.get(key)));
            }
        }

        return stringBuilder.toString();
    }

    /**
     * Helps to create a query string from given key and value
     *
     * @param key   pass the key of the HashMap
     * @param value pass the value of the HasMap
     * @return query string
     */
    private static String getQueryString(String key, Object value) {
        return "&" + key + "=" + value;
    }
}
