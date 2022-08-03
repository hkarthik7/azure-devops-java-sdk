package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

/***
 * A contribution type, given by a json schema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributionType extends BaseAbstractMethod {
    /***
     * Description of the contribution/type
     */
    @JsonProperty("description")
    private String description;
    /***
     * Fully qualified identifier of the contribution/type
     */
    @JsonProperty("id")
    private String id;
    /***
     * Controls whether or not contributions of this type have the type indexed for queries.
     */
    @JsonProperty("indexed")
    private boolean indexed;
    /***
     * Friendly name of the contribution/type
     */
    @JsonProperty("name")
    private String name;
    /***
     * Describes the allowed properties for this contribution type
     */
    @JsonProperty("properties")
    private JsonNode properties;
    /***
     * VisibleTo can be used to restrict whom can reference a given contribution/type.
     * This value should be a list of publishers or extensions access is restricted too.
     * Examples: "ms" - Means only the "ms" publisher can reference this. "ms.vss-web" -
     * Means only the "vss-web" extension from the "ms" publisher can reference this.
     */
    @JsonProperty("visibleTo")
    private String[] visibleTo;

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

    public boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(boolean indexed) {
        this.indexed = indexed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public String[] getVisibleTo() {
        return visibleTo;
    }

    public void setVisibleTo(String[] visibleTo) {
        this.visibleTo = visibleTo;
    }

}
