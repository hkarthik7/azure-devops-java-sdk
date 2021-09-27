package org.azd.utils;

import org.azd.common.types.LocationUrl;
import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;
import org.azd.helpers.JsonMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Wrapper class to build request url and to call Azure DevOps REST API
 */
public abstract class Client extends BaseClient {
    private static final JsonMapper MAPPER = new JsonMapper();

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param organizationName name of the organization
     * @param resourceId pass the resource id.
     * @param project name of the project
     * @param area resource area
     * @param id resource id
     * @param resource resource area endpoint
     * @param apiVersion api version
     * @param queryString query string to append the url
     * @param authorizationEndpoint true to return the request url
     * @param body body of the request to post and patch
     * @return String response from API
     * @throws ConnectionException user must create a Connection Object before calling this method
     * @throws AzDException throws user understandable error message with error code from API
     */
    public static String send(
            RequestMethod requestMethod,
            String organizationName,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            HashMap<String, Object> queryString,
            boolean authorizationEndpoint,
            String body) throws ConnectionException, AzDException {
        String requestUrl = buildRequestUrl(organizationName, resourceId, project, area, id, resource, apiVersion, queryString);
        requestUrl = requestUrl.replace("/_apis", "").replace("?api-version=null&", "?");

        if (authorizationEndpoint) {
            return requestUrl;
        }

        else {
            if (requestMethod.toString().equals("POST")) {
                return post(requestUrl, body);
            }

            return null;
        }
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
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
     * @return String response from API
     * @throws ConnectionException user must create a Connection Object before calling this method
     * @throws AzDException throws user understandable error message with error code from API
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
            Map<String, Object> queryString,
            Map<String, Object> body) throws ConnectionException, AzDException {
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
     * @param contentType content type to pass in the request header
     * @return String response from API
     * @throws ConnectionException user must create a Connection Object before calling this method
     * @throws AzDException throws user understandable error message with error code from API
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
            Map<String, Object> queryString,
            Map<String, Object> body,
            String contentType) throws ConnectionException, AzDException {
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
     * @throws ConnectionException user must create a Connection Object before calling this method
     * @throws AzDException throws user understandable error message with error code from API
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
            Map<String, Object> queryString,
            Map<String, Object> body,
            List<Object> requestBody,
            String contentType) throws ConnectionException, AzDException {
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
     *  Gets the resource area url based on resource id passed for the organization
     * @param resourceID pass the resource id
     * @throws ConnectionException user must create a Connection Object before calling this method
     * @throws AzDException throws user understandable error message with error code from API
     * @return resource area url
     */
    public static String getLocationUrl(String resourceID, String organizationName) throws ConnectionException, AzDException {

        String INSTANCE = "https://dev.azure.com/";

        if (resourceID == null) return (INSTANCE + organizationName);

        // Manage Accounts Api when the resource id is accounts. Accounts Api resource id doesn't return the desired location url.
        if (resourceID.equals("accounts")) return "https://app.vssps.visualstudio.com";

        String LOCATION_URL_VERSION = "5.0-preview.1";

        String url = new StringBuilder().append(INSTANCE)
                .append(organizationName)
                .append("/_apis/resourceAreas/")
                .append(resourceID)
                .append("?api-preview=")
                .append(LOCATION_URL_VERSION)
                .toString();

        try {
            String r = MAPPER.mapJsonResponse(BaseClient.get(url), LocationUrl.class).getLocationUrl();
            return r.replaceAll("/$","");
        } catch (Exception e) {
            throw new AzDException("Couldn't find the organisation name: " + organizationName);
        }
    }

    /**
     *  Builds the request url dynamically for the passed service, resource and area
     * @param organizationName pass the Azure DevOps organization name
     * @param resourceId pass the resource id
     * @param project pass the project name
     * @param area area of the REST API e.g., Release
     * @param id id of any entity to pass in
     * @param resource pass the resource entity e.g., Releases
     * @param apiVersion pass the API version
     * @param queryString pass the query string to form the url
     * @throws ConnectionException user must create a Connection Object before calling this method
     * @throws AzDException throws user understandable error message with error code from API
     * @return resource area url
     */
    private static String buildRequestUrl(
            String organizationName,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            Map<String, Object> queryString) throws ConnectionException, AzDException {
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
     * @param key pass the key of the HashMap
     * @param value pass the value of the HasMap
     * @return query string
     */
    private static String getQueryString(String key, Object value) {
        return "&" + key + "=" + value;
    }
}
