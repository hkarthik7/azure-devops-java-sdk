package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * An individual contribution made by an extension
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contribution extends BaseAbstractMethod {
    /***
     * List of constraints (filters) that should be applied to the availability of this contribution
     */
    @JsonProperty("constraints")
    private List<ContributionConstraint> constraints;
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
     * Includes is a set of contributions that should have this contribution included in their targets list.
     */
    @JsonProperty("includes")
    private String[] includes;
    /***
     * Properties/attributes of this contribution
     */
    @JsonProperty("properties")
    private JsonNode properties;
    /***
     * List of demanded claims in order for the user to see this contribution (like anonymous, public, member...).
     */
    @JsonProperty("restrictedTo")
    private String[] restrictedTo;
    /***
     * The ids of the contribution(s) that this contribution targets. (parent contributions)
     */
    @JsonProperty("targets")
    private String[] targets;
    /***
     * Id of the Contribution Type
     */
    @JsonProperty("type")
    private String type;
    /***
     * VisibleTo can be used to restrict whom can reference a given contribution/type.
     * This value should be a list of publishers or extensions access is restricted too.
     * Examples: "ms" - Means only the "ms" publisher can reference this. "ms.vss-web" -
     * Means only the "vss-web" extension from the "ms" publisher can reference this.
     */
    @JsonProperty("visibleTo")
    private String[] visibleTo;

    public List<ContributionConstraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<ContributionConstraint> constraints) {
        this.constraints = constraints;
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

    public String[] getIncludes() {
        return includes;
    }

    public void setIncludes(String[] includes) {
        this.includes = includes;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    public String[] getRestrictedTo() {
        return restrictedTo;
    }

    public void setRestrictedTo(String[] restrictedTo) {
        this.restrictedTo = restrictedTo;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getVisibleTo() {
        return visibleTo;
    }

    public void setVisibleTo(String[] visibleTo) {
        this.visibleTo = visibleTo;
    }

}
