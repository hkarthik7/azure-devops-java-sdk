package org.azd.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.azd.exceptions.DefaultParametersException;

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
public class Url {

    private final String INSTANCE = "https://dev.azure.com/";
    private final AzDDefaultParameters DefaultParameters;

    /***
     * This class expects the instance of AzDDefaultParameters to create the request url
     * @param defaultParameters instance of AzDDefaultParameters
     */
    public Url(AzDDefaultParameters defaultParameters) {
        this.DefaultParameters = defaultParameters;
    }


    /**
     *  Gets the resource area url based on resource id passed for the organization
     * @param resourceID pass the resource id
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @return resource area url
     */
    private String getLocationUrl(String resourceID) throws DefaultParametersException {

        if (DefaultParameters.getOrganization() == null) { validateDefaultParameters(); }

        String url = this.INSTANCE +
                DefaultParameters.getOrganization() +
                "/_apis/resourceAreas/" +
                resourceID +
                "?api-preview=5.0-preview.1";

        DeserializeLocationUrl locationUrl = new DeserializeLocationUrl();
        return (String) locationUrl.deserialize(RequestAPI.get(url));
    }

    /**
     *  Builds the request url dynamically for the passed service, resource and area
     * @param resourceId pass the resource id
     * @param project pass the project name
     * @param area area of the REST API e.g., Release
     * @param id id of any entity to pass in
     * @param resource pass the resource entity e.g., Releases
     * @param apiVersion pass the API version
     * @param queryString pass the query string to form the url
     * @throws DefaultParametersException user must instantiate AzDDefaultParameters before calling this method
     * @return resource area url
     */
    public String buildRequestUrl(
            String resourceId,
            String project,
            String area,
            String id,
            String resource,
            String apiVersion,
            HashMap<String, Object> queryString) throws DefaultParametersException {
        // build the request url to dynamically serve the API requests

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((getLocationUrl(resourceId)));

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
    private String getQueryString(String key, Object value) {
        return "&" + key + "=" + value;
    }

    /**
     * This class deserializes the json string to object to extract resource area url
     */
    private static class DeserializeLocationUrl {

        private final ObjectMapper mapper = new ObjectMapper();

        /**
         * Deserialize the response string to object of type LocationUrl
         * @param response pass the response from REST API
         * @return location url
         */
        public Object deserialize(String response) {
            LocationUrl result = null;
            try {
                result = mapper.readValue(response, new TypeReference<>() {});
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            if (result != null) {
                return result.getLocationUrl().replaceAll("/$","");
            }
            return null;
        }
    }
}
