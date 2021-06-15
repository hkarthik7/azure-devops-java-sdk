package org.azd.utils;

import org.azd.common.LocationUrl;
import org.azd.exceptions.AzDException;
import org.azd.exceptions.DefaultParametersException;
import org.azd.helpers.JsonMapper;

import java.util.HashMap;

import static org.azd.validators.AzDDefaultParametersValidator.validateDefaultParameters;

/**
 *  Build the request url dynamically to call Azure DevOps REST API
 *  <p>
 *      Azure DevOps REST API has many REST API implementations for all the services.
 *      It is segregated as service, resource and area.
 *      This implementation helps to call the Azure DevOps REST API with url formed dynamically
 *      by passing the correct service, resource and area for respective API
 *  </p>
 *  @author Harish Karthic
 */
public abstract class Url {
    private static final JsonMapper MAPPER = new JsonMapper();

    /**
     *  Gets the resource area url based on resource id passed for the organization
     * @param resourceID pass the resource id
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException If invalid json primitive is encountered.
     * @return resource area url
     */
    private static String getLocationUrl(String resourceID, String organizationName) throws DefaultParametersException, AzDException {

        if (organizationName == null) { validateDefaultParameters(); }

        String INSTANCE = "https://dev.azure.com/";
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
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @throws AzDException Exception handler
     * @return resource area url
     */
    public static String buildRequestUrl(
            String organizationName,
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            HashMap<String, Object> queryString) throws DefaultParametersException, AzDException {
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