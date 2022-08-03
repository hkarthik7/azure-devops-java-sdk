package org.azd.common.types;

/**
 * Response class for getting the resource area url.
 * <p>
 * This class is used as a placeholder to deserialize the json response from
 * REST API and to get the organization resource are url.
 * </p>
 *
 * @author Harish Karthic
 */
public class LocationUrl extends BaseAbstractMethod {
    private String id;
    private String name;
    private String locationUrl;

    /**
     * Get the id of the resource area.
     *
     * @return id of the resource. eg., build area id - 5d6898bb-45ec-463f-95f9-54d49c71752e.
     */
    public String getId() {
        return id;
    }

    /***
     * Set the id of resource area
     * @param id of the resource
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of the resource area.
     *
     * @return name of the resource. eg., build area name - build.
     */
    public String getName() {
        return name;
    }

    /***
     * Set the name of the resource
     * @param name name of the resource
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the location url of the resource area.
     *
     * @return url of the resource. eg., feeds area url - https://feeds.dev.azure.com/{organization}
     */
    public String getLocationUrl() {
        return locationUrl;
    }

    /***
     * Sets the location url. This shouldn't be used and is a place holder for json
     * deserialization.
     * @param locationUrl resource area url
     */
    public void setLocationUrl(String locationUrl) {
        this.locationUrl = locationUrl;
    }

    /***
     * Convert the resource object to string
     * @return location url
     */
}
