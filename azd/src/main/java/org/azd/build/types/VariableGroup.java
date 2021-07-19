package org.azd.build.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

/***
 * Represents a variable group.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableGroup {
    /***
     * The Name of the variable group.
     */
    @JsonProperty("alias")
    private String alias;
    /***
     * The description.
     */
    @JsonProperty("description")
    private String description;
    /***
     * The ID of the variable group.
     */
    @JsonProperty("id")
    private int id;
    /***
     * The Name of the variable group.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The type of the variable group.
     */
    @JsonProperty("type")
    private String type;
    /***
     * Build variables
     */
    @JsonProperty("variables")
    private JsonNode variables;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "alias='" + alias + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", variables=" + variables +
                '}';
    }
}
