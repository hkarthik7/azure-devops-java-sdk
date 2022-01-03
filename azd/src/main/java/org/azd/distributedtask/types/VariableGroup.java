package org.azd.distributedtask.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.Author;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroup {
    @JsonProperty("createdBy")
    private Author createdBy;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private int id;
    @JsonProperty("isShared")
    private boolean isShared;
    @JsonProperty("modifiedBy")
    private Author modifiedBy;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("name")
    private String name;
    @JsonProperty("providerData")
    private JsonNode providerData;
    @JsonProperty("type")
    private String type;
    @JsonProperty("variableGroupProjectReferences")
    private List<VariableGroupProjectReference> variableGroupProjectReferences;
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

    @Override
    public String toString() {
        return "VariableGroup{" +
                "createdBy=" + createdBy +
                ", createdOn='" + createdOn + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", isShared=" + isShared +
                ", modifiedBy=" + modifiedBy +
                ", modifiedOn='" + modifiedOn + '\'' +
                ", name='" + name + '\'' +
                ", providerData=" + providerData +
                ", type='" + type + '\'' +
                ", variableGroupProjectReferences=" + variableGroupProjectReferences +
                ", variables=" + variables +
                '}';
    }
}
