package org.azd.serviceendpoint.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;
import org.azd.release.types.ProjectReference;

/***
 * Reference to a project
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceEndpointProjectReference extends BaseAbstractMethod {
    /***
     * Gets or sets description of the service endpoint.
     */
    @JsonProperty("description")
    private String description;
    /***
     * Gets or sets name of the service endpoint.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Gets or sets project reference of the service endpoint.
     */
    @JsonProperty("projectReference")
    private ProjectReference projectReference;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectReference getProjectReference() {
        return projectReference;
    }

    public void setProjectReference(ProjectReference projectReference) {
        this.projectReference = projectReference;
    }

}
