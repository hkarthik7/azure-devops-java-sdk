package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemType {
    @JsonProperty("color")
    private String color;
    @JsonProperty("description")
    private String description;
    @JsonProperty("fieldInstances")
    private List<WorkItemTypeFieldInstance> fieldInstances;
    @JsonProperty("fields")
    private List<WorkItemTypeFieldInstance> fields;
    @JsonProperty("icon")
    private WorkItemIcon icon;
    @JsonProperty("isDisabled")
    private boolean isDisabled;
    @JsonProperty("name")
    private String name;
    @JsonProperty("referenceName")
    private String referenceName;
    @JsonProperty("states")
    private List<WorkItemStateColor> states;
    @JsonProperty("transitions")
    private JsonNode transitions;
    @JsonProperty("url")
    private String url;
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

    @Override
    public String toString() {
        return "WorkItemType{" +
                "color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", fieldInstances=" + fieldInstances +
                ", fields=" + fields +
                ", icon=" + icon +
                ", isDisabled=" + isDisabled +
                ", name='" + name + '\'' +
                ", referenceName='" + referenceName + '\'' +
                ", states=" + states +
                ", transitions=" + transitions +
                ", url='" + url + '\'' +
                ", xmlForm='" + xmlForm + '\'' +
                '}';
    }
}
