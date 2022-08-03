package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.azd.common.types.BaseAbstractMethod;

import java.util.List;

/***
 * Field instance of a work item type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTypeFieldInstance extends BaseAbstractMethod {
    /***
     * The list of field allowed values.
     */
    @JsonProperty("allowedValues")
    private String[] allowedValues;
    /***
     * Indicates whether field value is always required.
     */
    @JsonProperty("alwaysRequired")
    private boolean alwaysRequired;
    /***
     * Represents the default value of the field.
     */
    @JsonProperty("defaultValue")
    private String defaultValue;
    /***
     * The list of dependent fields.
     */
    @JsonProperty("dependentFields")
    private List<WorkItemFieldReference> dependentFields;
    /***
     * Gets the help text for the field.
     */
    @JsonProperty("helpText")
    private String helpText;
    /***
     * The friendly name of the field.
     */
    @JsonProperty("name")
    private String name;
    /***
     * The reference name of the field.
     */
    @JsonProperty("referenceName")
    private String referenceName;
    /***
     * The REST URL of the resource.
     */
    @JsonProperty("url")
    private String url;

    public String[] getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(String[] allowedValues) {
        this.allowedValues = allowedValues;
    }

    public boolean isAlwaysRequired() {
        return alwaysRequired;
    }

    public void setAlwaysRequired(boolean alwaysRequired) {
        this.alwaysRequired = alwaysRequired;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public List<WorkItemFieldReference> getDependentFields() {
        return dependentFields;
    }

    public void setDependentFields(List<WorkItemFieldReference> dependentFields) {
        this.dependentFields = dependentFields;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
