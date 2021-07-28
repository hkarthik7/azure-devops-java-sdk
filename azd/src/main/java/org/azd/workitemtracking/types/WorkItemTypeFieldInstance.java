package org.azd.workitemtracking.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkItemTypeFieldInstance {
    @JsonProperty("allowedValues")
    private String[] allowedValues;
    @JsonProperty("alwaysRequired")
    private boolean alwaysRequired;
    @JsonProperty("defaultValue")
    private String defaultValue;
    @JsonProperty("dependentFields")
    private List<WorkItemFieldReference> dependentFields;
    @JsonProperty("helpText")
    private String helpText;
    @JsonProperty("name")
    private String name;
    @JsonProperty("referenceName")
    private String referenceName;
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

    @Override
    public String toString() {
        return "WorkItemTypeFieldInstance{" +
                "allowedValues=" + Arrays.toString(allowedValues) +
                ", alwaysRequired=" + alwaysRequired +
                ", defaultValue='" + defaultValue + '\'' +
                ", dependentFields=" + dependentFields +
                ", helpText='" + helpText + '\'' +
                ", name='" + name + '\'' +
                ", referenceName='" + referenceName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
