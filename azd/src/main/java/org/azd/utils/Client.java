package org.azd.utils;

import org.azd.enums.RequestMethod;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;

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
     * @param defaultParameters instance of default parameters class
     * @param resourceId pass the resource id. Refer {@link ResourceId} class
     * @param project name of the project
     * @param area resource area
     * @param id resource id
     * @param resource resource area endpoint
     * @param apiVersion api version
     * @param queryString query string to append the url
     * @param body body of the request to post and patch
     * @return String response from API
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     */
    public static String request(
            RequestMethod requestMethod,
            AzDDefaultParameters defaultParameters,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            HashMap<String, Object> queryString,
            HashMap<String, Object> body) throws DefaultParametersException, AzDException {
        String requestUrl = buildRequestUrl(defaultParameters.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (requestMethod.toString().equals("GET")) {
            return get(requestUrl, defaultParameters.getPersonalAccessToken());
        }

        if (requestMethod.toString().equals("POST")) {
            return post(requestUrl, defaultParameters.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PATCH")) {
            return patch(requestUrl, defaultParameters.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, defaultParameters.getPersonalAccessToken());
        }

        return null;
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param defaultParameters instance of default parameters class
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
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     */
    public static String request(
            RequestMethod requestMethod,
            AzDDefaultParameters defaultParameters,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            HashMap<String, Object> queryString,
            HashMap<String, Object> body,
            String contentType) throws DefaultParametersException, AzDException {
        String requestUrl = buildRequestUrl(defaultParameters.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (requestMethod.toString().equals("GET") & (contentType != null)) {
            return get(requestUrl, defaultParameters.getPersonalAccessToken(), contentType);
        }

        if (requestMethod.toString().equals("GET") & (contentType == null)) {
            return get(requestUrl, defaultParameters.getPersonalAccessToken());
        }

        if (requestMethod.toString().equals("POST")) {
            return post(requestUrl, defaultParameters.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PATCH")) {
            return patch(requestUrl, defaultParameters.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, defaultParameters.getPersonalAccessToken());
        }

        return null;
    }

    /***
     * Request the Azure DevOps REST API and builds the request url dynamically based on resource id and endpoints passed
     * @param requestMethod type of request GET, POST, PATCH, DELETE {@link RequestMethod}
     * @param defaultParameters instance of default parameters class
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
     * @throws DefaultParametersException {@link DefaultParametersException}
     * @throws AzDException {@link AzDException}
     */
    public static String request(
            RequestMethod requestMethod,
            AzDDefaultParameters defaultParameters,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            HashMap<String, Object> queryString,
            HashMap<String, Object> body,
            List<Object> requestBody,
            String contentType) throws DefaultParametersException, AzDException {
        String requestUrl = buildRequestUrl(defaultParameters.getOrganization(), resourceId, project, area, id, resource, apiVersion, queryString);

        if (requestMethod.toString().equals("GET") & (contentType != null)) {
            return get(requestUrl, defaultParameters.getPersonalAccessToken(), contentType);
        }

        if (requestMethod.toString().equals("GET") & (contentType == null)) {
            return get(requestUrl, defaultParameters.getPersonalAccessToken());
        }

        if (requestMethod.toString().equals("POST") & (requestBody == null)) {
            return post(requestUrl, defaultParameters.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("POST") & (requestBody != null)) {
            return post(requestUrl, defaultParameters.getPersonalAccessToken(), requestBody);
        }

        if (requestMethod.toString().equals("PATCH") & (requestBody == null)) {
            return patch(requestUrl, defaultParameters.getPersonalAccessToken(), body);
        }

        if (requestMethod.toString().equals("PATCH") & (requestBody != null)) {
            return patch(requestUrl, defaultParameters.getPersonalAccessToken(), requestBody);
        }

        if (requestMethod.toString().equals("DELETE")) {
            return delete(requestUrl, defaultParameters.getPersonalAccessToken());
        }

        return null;
    }
}
