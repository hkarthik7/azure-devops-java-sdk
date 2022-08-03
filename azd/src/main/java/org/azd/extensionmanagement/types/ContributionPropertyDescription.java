package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Description about a property of a contribution type
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributionPropertyDescription extends BaseAbstractMethod {
    /***
     * Description of the property
     */
    @JsonProperty("description")
    private String description;
    /***
     * Name of the property
     */
    @JsonProperty("name")
    private String name;
    /***
     * True if this property is required
     */
    @JsonProperty("required")
    private String required;
    // Contribution property type has reserved keywords, this has to be JsonNode to retrieve the value based on key.
    /***
     * The type of value used for this property
     */
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

}
