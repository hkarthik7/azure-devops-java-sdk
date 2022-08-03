package org.azd.serviceendpoint.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Represents an endpoint which may be used by an orchestration job.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceEndpoint extends BaseAbstractMethod {
    /***
     * Gets or sets the authorization data for talking to the endpoint.
     */
    @JsonProperty("authorization")
    private JsonNode authorization;
    /***
     * Gets or sets the identity reference for the user who created the Service endpoint.
     */
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("data")
    private JsonNode data;
    /***
     * Gets or sets the description of endpoint.
     */
    @JsonProperty("description")
    private String description;
    /***
     * Gets or sets the identifier of this endpoint.
     */
    @JsonProperty("id")
    private String id;
    /***
     * EndPoint state indicator
     */
    @JsonProperty("isReady")
    private boolean isReady;
    /***
     * Indicates whether service endpoint is shared with other projects or not.
     */
    @JsonProperty("isShared")
    private boolean isShared;
    /***
     * Gets or sets the friendly name of the endpoint.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Error message during creation/deletion of endpoint
     */
    @JsonProperty("operationStatus")
    private JsonNode operationStatus;
    /***
     * Owner of the endpoint Supported values are "library", "agentcloud"
     */
    @JsonProperty("owner")
    private String owner;
    /***
     * Gets or sets the identity reference for the readers group of the service endpoint.
     */
    @JsonProperty("readersGroup")
    private Author readersGroup;
    /***
     * All other project references where the service endpoint is shared.
     */
    @JsonProperty("serviceEndpointProjectReferences")
    private List<ServiceEndpointProjectReference> serviceEndpointProjectReferences;
    /***
     * Gets or sets the type of the endpoint.
     */
    @JsonProperty("type")
    private String type;
    /***
     * Gets or sets the url of the endpoint.
     */
    @JsonProperty("url")
    private String url;

    public JsonNode getAuthorization() {
        return authorization;
    }

    public void setAuthorization(JsonNode authorization) {
        this.authorization = authorization;
    }

    public Author getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Author createdBy) {
        this.createdBy = createdBy;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonNode getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(JsonNode operationStatus) {
        this.operationStatus = operationStatus;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Author getReadersGroup() {
        return readersGroup;
    }

    public void setReadersGroup(Author readersGroup) {
        this.readersGroup = readersGroup;
    }

    public List<ServiceEndpointProjectReference> getServiceEndpointProjectReferences() {
        return serviceEndpointProjectReferences;
    }

    public void setServiceEndpointProjectReferences(List<ServiceEndpointProjectReference> serviceEndpointProjectReferences) {
        this.serviceEndpointProjectReferences = serviceEndpointProjectReferences;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
