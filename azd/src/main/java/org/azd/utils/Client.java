package org.azd.utils;

import org.azd.common.types.LocationUrl;
import org.azd.connection.Connection;
import org.azd.enums.ApiExceptionTypes;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.helpers.JsonMapper;

import java.io.InputStream;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Wrapper class to build request url and to call Azure DevOps REST API
 * @deprecated This is deprecated as of version 5.0.0
 */
@Deprecated
public abstract class Client extends BaseClient {
    @Deprecated private static final JsonMapper MAPPER = new JsonMapper();

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed.
     *
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection name of the organization
     * @param resourceId pass the resource id.
     * @param project name of the project
     * @param area resource area
     * @param id resource id
     * @param resource resource area endpoint
     * @param apiVersion api version
     * @param queryString query string to append the url
     * @param contentType true to return the request url
     * @param body body of the request to post and patch
     * @return String response from API
     * @throws AzDException throws user understandable error message with error code from API
     */
    @Deprecated public static String send(
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map queryString,
            boolean contentType,
            String body) throws AzDException {
        String requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        // TODO: Remove un-scalable method declarations.

        // I need to maintain consistency across the library. Since this send method is not used in any of the classes to call
        // the API I've modified it to suit Build Tags API call. Check BuildApi and addBuildTags for implementation.
        // This method signature shouldn't interfere or replace any implemented methods.
        if (requestMethod.toString().equals("POST") && contentType) {
            return post(requestUrl, connection.getPersonalAccessToken(), body, "application/json");
        }
        if (requestMethod.toString().equals("POST") && !contentType) {
            return post(requestUrl, connection.getPersonalAccessToken(), body, "application/octet-stream");
        }
        if (requestMethod.toString().equals("PUT") && !contentType) {
            return put(requestUrl, connection.getPersonalAccessToken(), body, "application/json");
        }
        if (requestMethod.toString().equals("PATCH") && !contentType) {
            return patch(requestUrl, connection.getPersonalAccessToken(), body, "application/json");
        }
        return null;
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
     * @param customHeaders Custom headers if any
     * @param redirect      if true looks for redirect URI from HttpResponse
     * @return InputStream from API
     * @throws AzDException Default Api exception handler
     */
    @Deprecated public static InputStream send(
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            HashMap<String, Object> queryString,
            String contentType,
            InputStream contentStream,
            Map<String, String> customHeaders,
            boolean redirect) throws AzDException {
        String requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (redirect) {
            var res = StreamBuilder.response(requestMethod, requestUrl,
                    connection.getPersonalAccessToken(), contentType, contentStream, customHeaders);

            if (requestMethod.name().equals("GET"))
                return StreamBuilder.response(requestMethod, res.thenApplyAsync(x -> x.uri().toString()).join(), null, contentType,
                        null, null, true);

            return res.thenApplyAsync(HttpResponse::body).join();
        }

        return StreamBuilder.response(requestMethod, requestUrl, connection.getPersonalAccessToken(),
                contentType, contentStream, customHeaders, false);
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     *
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection    connection object
     * @param resourceId    pass the resource id.
     * @param project       name of the project
     * @param area          resource area
     * @param id            resource id
     * @param resource      resource area endpoint
     * @param apiVersion    api version
     * @param queryString   query string to append the url
     * @param body          body of the request to post and patch
     * @return String response from API
     * @throws AzDException throws user understandable error message with error code from API
     */
    @Deprecated public static String send(
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map<String, Object> queryString,
            Map<String, Object> body) throws AzDException {
        String requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (requestMethod.toString().equals("GET")) {
            return get(requestUrl, connection.getPersonalAccessToken());
        }

        if (requestMethod.toString().equals("POST")) {
            return post(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PATCH")) {
            return patch(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PUT")) {
            return put(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, connection.getPersonalAccessToken());
        }

        return null;
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     *
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection    connection object
     * @param resourceId    pass the resource id.
     * @param project       name of the project
     * @param area          resource area
     * @param id            resource id
     * @param resource      resource area endpoint
     * @param apiVersion    api version
     * @param queryString   query string to append the url
     * @param body          body of the request to post and patch
     * @param contentType   content type to pass in the request header
     * @return String response from API
     * @throws AzDException throws user understandable error message with error code from API
     */
    @Deprecated public static String send(
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map<String, Object> queryString,
            Map<String, Object> body,
            String contentType) throws AzDException {
        String requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (requestMethod.toString().equals("GET") & (contentType != null)) {
            return get(requestUrl, connection.getPersonalAccessToken(), contentType);
        }

        if (requestMethod.toString().equals("GET") & (contentType == null)) {
            return get(requestUrl, connection.getPersonalAccessToken());
        }

        if (requestMethod.toString().equals("POST")) {
            return post(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PATCH")) {
            return patch(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PUT")) {
            return put(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, connection.getPersonalAccessToken());
        }

        return null;
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     *
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection connection object
     * @param resourceId pass the resource id.
     * @param project name of the project
     * @param area resource area
     * @param id resource id
     * @param resource resource area endpoint
     * @param apiVersion api version
     * @param queryString query string to append the url
     * @param body body of the request to post and patch
     * @param requestBody body of the request to post and patch. This should be a list of HashMap
     * @param contentType content type to pass in the request header
     * @return String response from API
     * @throws AzDException throws user understandable error message with error code from API
     */
    @Deprecated public static String send(
            RequestMethod requestMethod,
            Connection connection,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map<String, Object> queryString,
            Map<String, Object> body,
            List<Object> requestBody,
            String contentType) throws AzDException {
        String requestUrl = buildRequestUrl(connection.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (requestMethod.toString().equals("GET") & (contentType != null)) {
            return get(requestUrl, connection.getPersonalAccessToken(), contentType);
        }

        if (requestMethod.toString().equals("GET") & (contentType == null)) {
            return get(requestUrl, connection.getPersonalAccessToken());
        }

        if (requestMethod.toString().equals("POST") & (requestBody == null)) {
            return post(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("POST") & (requestBody != null)) {
            return post(requestUrl, connection.getPersonalAccessToken(), requestBody);
        }

        if (requestMethod.toString().equals("PATCH") & (requestBody == null)) {
            if (contentType != null)
                return patch(requestUrl, connection.getPersonalAccessToken(), body, contentType);
            return patch(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PATCH") & (requestBody != null)) {
            if (contentType != null)
                return patch(requestUrl, connection.getPersonalAccessToken(), requestBody, contentType);
            return patch(requestUrl, connection.getPersonalAccessToken(), requestBody);
        }

        if (requestMethod.toString().equals("PUT")) {
            return put(requestUrl, connection.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, connection.getPersonalAccessToken());
        }

        return null;
    }

    /**
     * Gets the resource area url based on resource id passed for the organization
     *
     * @param resourceID       pass the resource id
     * @param organizationName pass the organization name
     * @return resource area url
     * @throws AzDException throws user understandable error message with error code from API
     */
    @Deprecated public static String getLocationUrl(String resourceID, String organizationName) throws AzDException {

        String INSTANCE = "https://dev.azure.com/";

        if (resourceID == null) return (INSTANCE + organizationName);

        // Manage Accounts Api when the resource id is accounts. Accounts Api resource id doesn't return the desired location url.
        if (resourceID.equals("accounts")) return "https://app.vssps.visualstudio.com";

        String url = new StringBuilder().append(INSTANCE)
                .append(organizationName)
                .append("/_apis/resourceAreas/")
                .append(resourceID)
                .append("?api-preview=")
                .append("5.0-preview.1")
                .toString();

        try {
            String r = MAPPER.mapJsonResponse(BaseClient.get(url), LocationUrl.class).getLocationUrl();
            return r.replaceAll("/$", "");
        } catch (Exception e) {
            throw new AzDException(ApiExceptionTypes.InvalidOrganizationNameException.toString(), "Couldn't find the organization name '" + organizationName + "'.");
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
    @Deprecated private static String buildRequestUrl(
            String organizationName,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map<String, Object> queryString) throws AzDException {
        // build the request url to dynamically serve the API requests

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((getLocationUrl(resourceId, organizationName)));

        if (project != null) {
            stringBuilder.append("/").append(project);
        }

        stringBuilder.append("/_apis");

        if (area != null) {
            stringBuilder.append("/").append(area);
        }
        if (id != null) {
            stringBuilder.append("/").append(id);
        }
        if (resource != null) {
            stringBuilder.append("/").append(resource);
        }
        stringBuilder.append("?api-version=").append(apiVersion);
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
    @Deprecated private static String getQueryString(String key, Object value) {
        return "&" + key + "=" + value;
    }
}
