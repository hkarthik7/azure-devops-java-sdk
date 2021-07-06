package org.azd.utils;

import org.azd.connection.Connection;
import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.ConnectionException;

import java.util.HashMap;
import java.util.List;

import static org.azd.utils.Url.buildRequestUrl;

/***
 * Wrapper class to build request url and to call Azure DevOps REST API
 */
public abstract class Client extends BaseClient {
    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection connection object
     * @param resourceId pass the resource id. Refer {@link ResourceId} class
     * @param project name of the project
     * @param area resource area
     * @param id resource id
     * @param resource resource area endpoint
     * @param apiVersion api version
     * @param queryString query string to append the url
     * @param body body of the request to post and patch
     * @return String response from API
     * @throws ConnectionException {@link ConnectionException}
     * @throws AzDException {@link AzDException}
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
            HashMap<String, Object> queryString,
            HashMap<String, Object> body) throws ConnectionException, AzDException {
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

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, connection.getPersonalAccessToken());
        }

        return null;
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection connection object
     * @param resourceId pass the resource id. Refer {@link ResourceId} class
     * @param project name of the project
     * @param area resource area
     * @param id resource id
     * @param resource resource area endpoint
     * @param apiVersion api version
     * @param queryString query string to append the url
     * @param body body of the request to post and patch
     * @param contentType content type to pass in the request header
     * @return String response from API
     * @throws ConnectionException {@link ConnectionException}
     * @throws AzDException {@link AzDException}
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
            HashMap<String, Object> queryString,
            HashMap<String, Object> body,
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

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, connection.getPersonalAccessToken());
        }

        return null;
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param connection connection object
     * @param resourceId pass the resource id. Refer {@link ResourceId} class
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
     * @throws ConnectionException {@link ConnectionException}
     * @throws AzDException {@link AzDException}
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
            HashMap<String, Object> queryString,
            HashMap<String, Object> body,
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

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, connection.getPersonalAccessToken());
        }

        return null;
    }
}
