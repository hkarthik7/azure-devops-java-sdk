package org.azd.extensionmanagement.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

/***
 * Specifies a constraint that can be used to dynamically include/exclude a given contribution
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributionConstraint extends BaseAbstractMethod {
    /***
     * An optional property that can be specified to group constraints together.
     */
    @JsonProperty("group")
    private int group;
    /***
     * Fully qualified identifier of a shared constraint
     */
    @JsonProperty("id")
    private String id;
    /***
     * If true, negate the result of the filter (include the contribution if the applied filter returns false instead of true)
     */
    @JsonProperty("inverse")
    private boolean inverse;
    /***
     * Name of the IContributionFilter plugin
     */
    @JsonProperty("name")
    private String name;
    /***
     * Properties that are fed to the contribution filter class
     */
    @JsonProperty("properties")
    private JsonNode properties;
    /***
     * Constraints can be optionally be applied to one or more of the relationships defined in the contribution.
     * If no relationships are defined then all relationships are associated with the constraint.
     * This means the default behaviour will eliminate the contribution from the tree completely if the constraint is applied.
     */
    @JsonProperty("relationships")
    private String[] relationships;

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
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

    public String[] getRelationships() {
        return relationships;
    }

    public void setRelationships(String[] relationships) {
        this.relationships = relationships;
    }

}
