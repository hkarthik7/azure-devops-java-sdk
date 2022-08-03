package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Describes a work item type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemType extends BaseAbstractMethod {
    /***
     * The color.
     */
    @JsonProperty("color")
    private String color;
    /***
     * The description of the work item type.
     */
    @JsonProperty("description")
    private String description;
    /***
     * The fields that exist on the work item type.
     */
    @JsonProperty("fieldInstances")
    private List<WorkItemTypeFieldInstance> fieldInstances;
    /***
     * The fields that exist on the work item type.
     */
    @JsonProperty("fields")
    private List<WorkItemTypeFieldInstance> fields;
    /***
     * The icon of the work item type.
     */
    @JsonProperty("icon")
    private WorkItemIcon icon;
    /***
     * True if work item type is disabled
     */
    @JsonProperty("isDisabled")
    private boolean isDisabled;
    /***
     * Gets the name of the work item type.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The reference name of the work item type.
     */
    @JsonProperty("referenceName")
    private String referenceName;
    /***
     * Gets state information for the work item type.
     */
    @JsonProperty("states")
    private List<WorkItemStateColor> states;
    /***
     * Gets the various state transition mappings in the work item type.
     */
    @JsonProperty("transitions")
    private JsonNode transitions;
    /***
     * url
     */
    @JsonProperty("url")
    private String url;
    /***
     * The XML form.
     */
    @JsonProperty("xmlForm")
    private String xmlForm;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WorkItemTypeFieldInstance> getFieldInstances() {
        return fieldInstances;
    }

    public void setFieldInstances(List<WorkItemTypeFieldInstance> fieldInstances) {
        this.fieldInstances = fieldInstances;
    }

    public List<WorkItemTypeFieldInstance> getFields() {
        return fields;
    }

    public void setFields(List<WorkItemTypeFieldInstance> fields) {
        this.fields = fields;
    }

    public WorkItemIcon getIcon() {
        return icon;
    }

    public void setIcon(WorkItemIcon icon) {
        this.icon = icon;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public List<WorkItemStateColor> getStates() {
        return states;
    }

    public void setStates(List<WorkItemStateColor> states) {
        this.states = states;
    }

    public JsonNode getTransitions() {
        return transitions;
    }

    public void setTransitions(JsonNode transitions) {
        this.transitions = transitions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getXmlForm() {
        return xmlForm;
    }

    public void setXmlForm(String xmlForm) {
        this.xmlForm = xmlForm;
    }

}
