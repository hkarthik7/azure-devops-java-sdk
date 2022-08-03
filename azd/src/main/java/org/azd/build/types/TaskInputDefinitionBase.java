package org.azd.build.types;
/**
 * ----------------------------------------------------------
 * GENERATED FILE, should be edited to suit the purpose.
 * ----------------------------------------------------------
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

/**
 * None 
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskInputDefinitionBase extends BaseAbstractMethod {

    @JsonProperty("aliases")
    private String[] aliases;

    @JsonProperty("defaultValue")
    private String defaultValue;

    @JsonProperty("groupName")
    private String groupName;

    @JsonProperty("helpMarkDown")
    private String helpMarkDown;

    @JsonProperty("label")
    private String label;

    @JsonProperty("name")
    private String name;

    @JsonProperty("options")
    private Object options;

    @JsonProperty("properties")
    private Object properties;

    @JsonProperty("required")
    private boolean required;

    @JsonProperty("type")
    private String type;

    @JsonProperty("validation")
    private TaskInputValidation validation;

    @JsonProperty("visibleRule")
    private String visibleRule;

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getHelpMarkDown() {
        return helpMarkDown;
    }

    public void setHelpMarkDown(String helpMarkDown) {
        this.helpMarkDown = helpMarkDown;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
    }

    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TaskInputValidation getValidation() {
        return validation;
    }

    public void setValidation(TaskInputValidation validation) {
        this.validation = validation;
    }

    public String getVisibleRule() {
        return visibleRule;
    }

    public void setVisibleRule(String visibleRule) {
        this.visibleRule = visibleRule;
    }

}
