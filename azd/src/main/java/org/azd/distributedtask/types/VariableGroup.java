package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * A variable group is a collection of related variables.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroup extends BaseAbstractMethod {
    /***
     * Gets or sets the identity who created the variable group.
     */
    @JsonProperty("createdBy")
    private Author createdBy;
    /***
     * Gets or sets the time when variable group was created.
     */
    @JsonProperty("createdOn")
    private String createdOn;
    /***
     * Gets or sets description of the variable group.
     */
    @JsonProperty("description")
    private String description;
    /***
     * Gets or sets id of the variable group.
     */
    @JsonProperty("id")
    private int id;
    /***
     * Indicates whether variable group is shared with other projects or not.
     */
    @JsonProperty("isShared")
    private boolean isShared;
    /***
     * Gets or sets the identity who modified the variable group.
     */
    @JsonProperty("modifiedBy")
    private Author modifiedBy;
    /***
     * Gets or sets the time when variable group was modified
     */
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    /***
     * Gets or sets name of the variable group.
     */
    @JsonProperty("name")
    private String name;
    /***
     * Gets or sets provider data.
     */
    @JsonProperty("providerData")
    private JsonNode providerData;
    /***
     * Gets or sets type of the variable group.
     */
    @JsonProperty("type")
    private String type;
    /***
     * all project references where the variable group is shared with other projects.
     */
    @JsonProperty("variableGroupProjectReferences")
    private List<VariableGroupProjectReference> variableGroupProjectReferences;
    /***
     * Gets or sets variables contained in the variable group.
     */
    @JsonProperty("variables")
    private JsonNode variables;

    public Author getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Author createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    public Author getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Author modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonNode getProviderData() {
        return providerData;
    }

    public void setProviderData(JsonNode providerData) {
        this.providerData = providerData;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<VariableGroupProjectReference> getVariableGroupProjectReferences() {
        return variableGroupProjectReferences;
    }

    public void setVariableGroupProjectReferences(List<VariableGroupProjectReference> variableGroupProjectReferences) {
        this.variableGroupProjectReferences = variableGroupProjectReferences;
    }

    public JsonNode getVariables() {
        return variables;
    }

    public void setVariables(JsonNode variables) {
        this.variables = variables;
    }

}
