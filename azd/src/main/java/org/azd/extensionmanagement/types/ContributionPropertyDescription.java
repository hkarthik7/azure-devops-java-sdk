package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributionPropertyDescription {
    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("required")
    private String required;
    // Contribution property type has reserved keywords, this has to be JsonNode to retrieve the value based on key.
    @JsonProperty("type")
    private JsonNode type;

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

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public JsonNode getType() {
        return type;
    }

    public void setType(JsonNode type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ContributionPropertyDescription{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", required='" + required + '\'' +
                ", type=" + type +
                '}';
    }
}
